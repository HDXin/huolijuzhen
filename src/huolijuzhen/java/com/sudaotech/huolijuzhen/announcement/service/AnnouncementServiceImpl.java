package com.sudaotech.huolijuzhen.announcement.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntity;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntityExample;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntityExample.Criteria;
import com.sudaotech.huolijuzhen.announcement.dao.AnnouncementEntityMapper;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.util.BeanUtils;

public class AnnouncementServiceImpl extends BaseServiceImpl implements AnnouncementService {
	private static final String TRACKING_TYPE = "Announcement";

    @Inject
    private AnnouncementEntityMapper announcementEntityMapper;

	@Override
	public Announcement getById(Long id) {
		AnnouncementEntity entity = this.announcementEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Announcement.class);
		}
		
		return null;
	}

	@Override
	public Long create(Announcement obj) {
		logger.debug("Creating Announcement: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		AnnouncementEntity entity = BeanUtils.copyProperties(obj, AnnouncementEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.announcementEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Announcement: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Announcement obj) {
		logger.debug("Updating Announcement: {}", obj);

		AnnouncementEntity entity = BeanUtils.copyProperties(obj, AnnouncementEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.announcementEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Announcement: {}", obj);
	}

	@Override
	public Long save(Announcement obj) {
		logger.debug("Saving Announcement: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Announcement> find(Query query) {
		Page<Announcement> page = new Page<Announcement>(query);
		AnnouncementEntityExample example = new AnnouncementEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.announcementEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<AnnouncementEntity> list = this.announcementEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Announcement.class));
		}
		
		return page;
	}
	
	@Override
	public Page<Announcement> findByCondition(Query query) throws ParseException {
		Page<Announcement> page = new Page<Announcement>(query);
		AnnouncementEntityExample example = new AnnouncementEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = query.getStartDate();
		if(StringUtils.isNotBlank(startDate)){
			Date startCreateDate = sdf.parse(startDate);
			criteria.andCreateTimeGreaterThanOrEqualTo(startCreateDate);
		}
		
		String endDate = query.getEndDate();
		if(StringUtils.isNotBlank(endDate)){
			Date endCreateDate = sdf.parse(endDate);
			criteria.andCreateTimeLessThanOrEqualTo(endCreateDate);
		}
		
		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		String approvalStatusStr = query.getApprovalStatus();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			if("ALREADYAPPROVAL".equals(approvalStatusStr)){
				List<ApprovalStatus> approvalStatusList = new ArrayList<ApprovalStatus>();
				approvalStatusList.add(ApprovalStatus.ALREADYPASS);
				approvalStatusList.add(ApprovalStatus.NOPASS);
				
				criteria.andApprovalStatusIn(approvalStatusList);
			}else{
				ApprovalStatus approvalStatus = ApprovalStatus.valueOf(approvalStatusStr);
				criteria.andApprovalStatusEqualTo(approvalStatus);
			}
		}
		
		CreateSide querySide = query.getQuerySide();
		if(CreateSide.PLATFORM.equals(querySide)){
			criteria.andCreateSideEqualTo(CreateSide.PLATFORM);
		}else if(CreateSide.PARK.equals(querySide)){
			Long parkId = query.getParkId();
			if(parkId != null){
				criteria.andParkIdEqualTo(parkId);
			}
			criteria.andCreateSideEqualTo(CreateSide.PARK);
		}
		
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.announcementEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<AnnouncementEntity> list = this.announcementEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Announcement.class));
		}
		
		return page;
	}
}
