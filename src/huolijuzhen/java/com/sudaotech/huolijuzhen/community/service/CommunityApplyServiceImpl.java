package com.sudaotech.huolijuzhen.community.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntity;
import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntityExample;
import com.sudaotech.huolijuzhen.community.dao.CommunityApplyEntityExample.Criteria;
import com.sudaotech.huolijuzhen.community.dao.LocationCommunityApplyEntityMapper;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.util.BeanUtils;

public class CommunityApplyServiceImpl extends BaseServiceImpl implements CommunityApplyService {
	private static final String TRACKING_TYPE = "CommunityApply";

    @Inject
    private LocationCommunityApplyEntityMapper communityApplyEntityMapper;

	@Override
	public CommunityApply getById(Long id) {
		CommunityApplyEntity entity = this.communityApplyEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, CommunityApply.class);
		}
		
		return null;
	}

	@Override
	public Long create(CommunityApply obj) {
		logger.debug("Creating CommunityApply: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		CommunityApplyEntity entity = BeanUtils.copyProperties(obj, CommunityApplyEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.communityApplyEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created CommunityApply: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(CommunityApply obj) {
		logger.debug("Updating CommunityApply: {}", obj);

		CommunityApplyEntity entity = BeanUtils.copyProperties(obj, CommunityApplyEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.communityApplyEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated CommunityApply: {}", obj);
	}

	@Override
	public Long save(CommunityApply obj) {
		logger.debug("Saving CommunityApply: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<CommunityApply> find(Query query) {
		Page<CommunityApply> page = new Page<CommunityApply>(query);
		CommunityApplyEntityExample example = new CommunityApplyEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.communityApplyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CommunityApplyEntity> list = this.communityApplyEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, CommunityApply.class));
		}
		
		return page;
	}
	
	@Override
	public Page<CommunityApply> findByCondition(Query query) throws ParseException {
		Page<CommunityApply> page = new Page<CommunityApply>(query);
		CommunityApplyEntityExample example = new CommunityApplyEntityExample();
		Criteria criteria = example.createCriteria();
		
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
		
		String communityName = query.getCommunityName();
		if(StringUtils.isNotBlank(communityName)){
			criteria.andCommunityNameLike("%" + communityName + "%");
		}
		
		String companyName = query.getCompanyName();
		if(StringUtils.isNotBlank(companyName)){
			criteria.andCompanyNameLike("%" + companyName + "%");
		}
		
		CreateSide createSide = query.getCreateSide();
		criteria.andCreateSideEqualTo(createSide);
		if(CreateSide.PARK.equals(createSide)){
			criteria.andCreateSideIdEqualTo(query.getCreateParkId());
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.communityApplyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CommunityApplyEntity> list = this.communityApplyEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, CommunityApply.class));
		}
		
		return page;
	}
	
	@Override
	public Page<CommunityApply> findHistoryByCondition(Query query) throws ParseException {
		Page<CommunityApply> page = new Page<CommunityApply>(query);
		CommunityApplyEntityExample example = new CommunityApplyEntityExample();
		Criteria criteria = example.createCriteria();
		
		//获取当前企业活动的历史申请单
		Long companyId = query.getCompanyId();
		if(companyId != null){
			criteria.andCompanyIdEqualTo(query.getCompanyId());
		}
		
		//获取申请单企业的园区
		Long parkId = query.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.communityApplyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CommunityApplyEntity> list = this.communityApplyEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, CommunityApply.class));
		}
		
		return page;
	}

	/**
	 * 通过企业 ID,园区ID 获取所有社群活动 ID
	 */
	@Override
	public List<Long> findAllByEnterpriseIdAndParkId(Long enterpriseId,
			Long parkId) {
		
		CommunityApplyEntityExample example = new CommunityApplyEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andCompanyIdEqualTo(enterpriseId);
		criteria.andParkIdEqualTo(parkId);
		
		List<CommunityApplyEntity> communityEntities = this.communityApplyEntityMapper.selectByExample(example);
		List<Long> communityIds = new ArrayList<Long>();
		if(CollectionUtils.isNotEmpty(communityEntities)){
			for(CommunityApplyEntity item:communityEntities){
				communityIds.add(item.getCommunityId());
			}
		}
		return communityIds;
	}

	/**
	 * 统计
	 */
	@Override
	public List<Map<String, Object>> statistics(List<Long> communityIds) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityIds", communityIds);
		List<Map<String, Object>> dataMap = this.communityApplyEntityMapper.statistics(params);
		
		return dataMap;
	}
}
