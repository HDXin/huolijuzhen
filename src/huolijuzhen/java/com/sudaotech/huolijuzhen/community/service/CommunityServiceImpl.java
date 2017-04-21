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
import com.sudaotech.huolijuzhen.community.dao.CommunityEntity;
import com.sudaotech.huolijuzhen.community.dao.CommunityEntityExample;
import com.sudaotech.huolijuzhen.community.dao.CommunityEntityExample.Criteria;
import com.sudaotech.huolijuzhen.community.dao.CommunityEntityWithBLOBs;
import com.sudaotech.huolijuzhen.community.dao.LocationCommunityEntityMapper;
import com.sudaotech.huolijuzhen.enums.ApprovalStatus;
import com.sudaotech.huolijuzhen.enums.CreateSide;
import com.sudaotech.huolijuzhen.enums.PublicGrade;
import com.sudaotech.huolijuzhen.park.service.ParkInfoService.ParkInfo;
import com.sudaotech.util.BeanUtils;

public class CommunityServiceImpl extends BaseServiceImpl implements CommunityService {
	private static final String TRACKING_TYPE = "Community";

    @Inject
    private LocationCommunityEntityMapper communityEntityMapper;

	@Override
	public Community getById(Long id) {
		CommunityEntity entity = this.communityEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Community.class);
		}
		
		return null;
	}

	@Override
	public Long create(Community obj) {
		logger.debug("Creating Community: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		CommunityEntityWithBLOBs entity = BeanUtils.copyProperties(obj, CommunityEntityWithBLOBs.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.communityEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Community: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Community obj) {
		logger.debug("Updating Community: {}", obj);

		CommunityEntityWithBLOBs entity = BeanUtils.copyProperties(obj, CommunityEntityWithBLOBs.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.communityEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Community: {}", obj);
	}

	@Override
	public Long save(Community obj) {
		logger.debug("Saving Community: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Community> find(Query query) {
		Page<Community> page = new Page<Community>(query);
		CommunityEntityExample example = new CommunityEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		List<Long> companyIds = query.getCommunityIds();
		if(CollectionUtils.isNotEmpty(companyIds)){
			criteria.andIdIn(companyIds);
		}
		
		Long parkId = query.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		example.setOrderByClause("createTime ASC");
		page.setTotal(this.communityEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CommunityEntity> list = this.communityEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Community.class));
		}
		
		return page;
	}
	
	/**
	 * 按条件查询
	 * @throws ParseException 
	 */
	@Override
	public Page<Community> find(Query query,CreateSide createSide,Long parkId) throws ParseException{
		Page<Community> page = new Page<Community>(query);
		CommunityEntityExample example = new CommunityEntityExample();
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
		
		String approvalStatus = query.getApprovalStatus();
		if(StringUtils.isNotBlank(approvalStatus)){
			criteria.andApprovalStatusEqualTo(ApprovalStatus.valueOf(approvalStatus));
		}
		
		String title = query.getTitle();
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		
		//平台可以查看全部的，园区只能查看自己的
		criteria.andCreateSideEqualTo(createSide);
		if(CreateSide.PARK.equals(createSide)){
			criteria.andParkIdEqualTo(parkId);
		}

		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.communityEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<CommunityEntity> list = this.communityEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Community.class));
		}
		
		return page;
	}

	@Override
	public boolean hasEditPrivilegeById(Long itemId,Long userId) {
		
		//1.根据 userId 判断当前用户类型（1.平台用户，2.园区管理者）
		//TODO 判断用户类型
		Map<String, Object> params = new HashMap<String, Object>();
		
		Long id;
		if(1>0){
			
			params.put("itemId", itemId);
			params.put("createSide", CreateSide.PLATFORM.code());
			
			id = communityEntityMapper.hasPlatformEditPrivilegeById(params);
		}
//		else{
//			params.put("itemId", itemId);
//			params.put("createSide", CreateSide.PARK);
//			params.put("parkId", "");
//			
//			id = communityEntityMapper.hasParkEditPrivilegeById(params);
//		}
		return id == null?false:true;
	}

	/**
	 * 根据当前用户获取活动
	 */
	@Override
	public Page<Community> findByCurrentUser(Query query, ParkInfo parkInfo) {
		
		
		//1.获取该用户有权限查看的活动（1.活动对象为园区，parkId;2.活动对象为平台;3.活动对象为行政位置）
		Map<String, Object> params = new HashMap<String, Object>();
		//平台
		params.put("platform", PublicGrade.PLATFORM.code());
		//正常状态
		params.put("status", Status.NORMAL.code());
		//已通过审批
		params.put("approvalStatus", ApprovalStatus.ALREADYPASS.code());
		
		params.put("offset", query.getOffset());
		params.put("limit", query.getLimit());

		//2.查询符合条件的活动数量
		Integer num = 0;
		
		//3.分页查询
		List<Community> itemList = null;
		if(parkInfo != null){
			//2.1入驻企业
			params.put("parkId", parkInfo.getId());
			params.put("park", PublicGrade.PARK.code());
			params.put("administractive", PublicGrade.ADMINISTRACTIVE.code());
			params.put("proId", parkInfo.getProvinceId());
			params.put("cityId", parkInfo.getCityId());
			params.put("counId", parkInfo.getRegionId());
			params.put("locationId", parkInfo.getPositionId());			
			
			num = communityEntityMapper.getCountByCondition(params);
			itemList = communityEntityMapper.getPageByCondition(params);
		}else{
			//2.1 平台企业
			num = communityEntityMapper.getPlatformCountByCondition(params);
			itemList = communityEntityMapper.getPagePlatformByCondition(params);
		}
		
		Page<Community> page = new Page<Community>();
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		page.setTotal(num);
		if(CollectionUtils.isNotEmpty(itemList)){
			page.setItems(itemList);
		}else{
			page.setItems(new ArrayList<CommunityService.Community>());
		}
		
		return page;
	}

	/**
	 * 统计
	 * @param statisticsCondition
	 * @return
	 */
	@Override
	public Page<Community> statistics(StatisticsCondition statisticsCondition) {
		Page<Community> page = new Page<Community>(statisticsCondition);
		CommunityEntityExample example = new CommunityEntityExample();
		Criteria criteria = example.createCriteria();
		
		String title = statisticsCondition.getTitle();
		if(StringUtils.isNotBlank(title)){
			criteria.andTitleLike("%" + title + "%");
		}
		
		CreateSide createSide = statisticsCondition.getCreateSide();
		if(createSide != null){
			criteria.andCreateSideEqualTo(createSide);
		}

		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		page.setTotal(this.communityEntityMapper.countByExample(example));
		if (page.getTotal() > statisticsCondition.getOffset()) {
			List<CommunityEntity> list = this.communityEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(statisticsCondition));
			page.setItems(BeanUtils.copyListProperties(list, Community.class));
		}
		
		return page;
	}
	
	
	
}
