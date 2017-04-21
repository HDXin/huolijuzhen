package com.sudaotech.huolijuzhen.provider.service;

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
import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;
import com.sudaotech.huolijuzhen.enums.ServiceGrade;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceProjectEntityMapper;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectEntityExample.Criteria;
import com.sudaotech.util.BeanUtils;

public class ServiceProjectServiceImpl extends BaseServiceImpl implements ServiceProjectService {
	private static final String TRACKING_TYPE = "ServiceProject";

    @Inject
    private LocationServiceProjectEntityMapper serviceProjectEntityMapper;

	@Override
	public ServiceProject getById(Long id) {
		ServiceProjectEntity entity = this.serviceProjectEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceProject.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceProject obj) {
		logger.debug("Creating ServiceProject: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceProjectEntity entity = BeanUtils.copyProperties(obj, ServiceProjectEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceProjectEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceProject: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceProject obj) {
		logger.debug("Updating ServiceProject: {}", obj);

		ServiceProjectEntity entity = BeanUtils.copyProperties(obj, ServiceProjectEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceProjectEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceProject: {}", obj);
	}

	@Override
	public Long save(ServiceProject obj) {
		logger.debug("Saving ServiceProject: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceProject> find(Query query) {
		Page<ServiceProject> page = new Page<ServiceProject>(query);
		ServiceProjectEntityExample example = new ServiceProjectEntityExample();
		Criteria criteria = example.createCriteria();
		
		//根据服务商名搜索服务项目
		String providerName = query.getProviderName();
		if(StringUtils.isNotBlank(providerName)){
			criteria.andServiceGradeNameLike("%" + providerName + "%");
		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			criteria.andMainTitleLike("%" + mainTitle + "%");
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			criteria.andServiceTypeIdEqualTo(serviceTypeId);
		}
		
		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			criteria.andServiceGradeEqualTo(serviceGrade);
		}		

		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				criteria.andApprovalStatusEqualTo(approvalStatus);
			}
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceProjectEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceProjectEntity> list = this.serviceProjectEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceProject.class));
		}
		return page;
	}

	@Override
	public Page<ServiceProject> findProviderServiceSql(Query query) {
		Page<ServiceProject> page = new Page<ServiceProject>(query);
		ServiceProjectEntityExample example = new ServiceProjectEntityExample();
		Criteria criteria = example.createCriteria();
		
		//根据服务商名搜索服务项目
//		String providerName = query.getProviderName();
//		if(StringUtils.isNotBlank(providerName)){
//			criteria.andServiceGradeNameLike("%" + providerName + "%");
//		}

		String mainTitle = query.getMainTitle();
		if(StringUtils.isNotBlank(mainTitle)){
			criteria.andMainTitleLike("%" + mainTitle + "%");
		}
		
		Long serviceTypeId = query.getServiceTypeId();
		if(serviceTypeId != null){
			criteria.andServiceTypeIdEqualTo(serviceTypeId);
		}
		
		//服务商类别
		ServiceGrade serviceGrade = query.getServiceGrade();
		if(serviceGrade != null){
			criteria.andServiceGradeEqualTo(serviceGrade);
			criteria.andServiceGradeIdEqualTo(query.getServiceGradeId());
		}
		

		String approvalStatusStr = query.getApprovalStatu();
		if(StringUtils.isNotBlank(approvalStatusStr)){
			ServiceApprovalStatus approvalStatus = ServiceApprovalStatus.valueOf(approvalStatusStr);
			if(approvalStatus != null){
				criteria.andApprovalStatusEqualTo(approvalStatus);
			}
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceProjectEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceProjectEntity> list = this.serviceProjectEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceProject.class));
		}
		return page;
	}
	
	/**
	 * 根据自定义 sql 获取分页的 ServiceProvider 信息
	 */
	@Override
	public Page<ServiceProject> findParkServiceSql(Query query) {
		
		Page<ServiceProject> page = new Page<ServiceProjectService.ServiceProject>();
		Integer total = serviceProjectEntityMapper.findParkServiceSqlCount(query);
		
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		page.setTotal(0);
		if(total != null){
			page.setTotal(total);
		}
		List<ServiceProject> dataList= serviceProjectEntityMapper.findParkServiceSql(query);
		page.setItems(new ArrayList<ServiceProjectService.ServiceProject>());
		if(CollectionUtils.isNotEmpty(dataList)){
			page.setItems(dataList);			
		}
		return page;
	}

	@Override
	public List<Long> findServiceProIdByServiceGrade(ServiceGrade serviceGrade) {

		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("serviceGrade", serviceGrade.code());
		params.put("status", Status.NORMAL.code());
		
		List<Long> serviceProIds = serviceProjectEntityMapper.getServiceProIdByServiceGrade(params);
		
		return serviceProIds;
	}

	@Override
	public List<Long> findServiceProIdByCurrentUser(
			FindServiceProByCurrentUser condition) {
		List<Long> serviceProIds = serviceProjectEntityMapper.findServiceProByCurrentUser(condition);
		return serviceProIds;
	}

	/**
	 * 根据自定义 sql 获取分页的 ServiceProvider 信息
	 */
	@Override
	public Page<ServiceProject> findParkValidServicePro(Query query,Long parkId,List<Long> ids) {
		
		
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("query", query);
		paramsMap.put("parkId", parkId);
		paramsMap.put("ids", ids);
		Integer total = serviceProjectEntityMapper.findParkValidServiceProCount(paramsMap);

		Page<ServiceProject> page = new Page<ServiceProject>();
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		page.setTotal(0);
		if(total != null){
			page.setTotal(total);
		}

		List<ServiceProject> dataList = serviceProjectEntityMapper.findParkValidServicePro(paramsMap);
		page.setItems(new ArrayList<ServiceProjectService.ServiceProject>());
		if(CollectionUtils.isNotEmpty(dataList)){
			page.setItems(dataList);
		}
		return page;
	}

	@Override
	public List<Long> findPlatformServiceIds() {
		List<Long> ids = serviceProjectEntityMapper.findPlatformServiceIds();
		return ids;
	}

	@Override
	public Page<ServiceProject> findPlatformService(Query query) {
		
		Page<ServiceProject> page = new Page<ServiceProject>();
		page.setOffset(query.getOffset());
		page.setLimit(query.getLimit());
		Integer total = serviceProjectEntityMapper.findPlatformServiceCount(query);
		page.setTotal(0);
		if(total != null){
			page.setTotal(total);
		}
		List<ServiceProject> items = serviceProjectEntityMapper.findPlatformService(query);
		if(CollectionUtils.isNotEmpty(items)){
			page.setItems(items);
		}
		
		return page;
	}

	 /**
     * 按服务类型、点击数统计服务项目
     * @return
     */
	@Override
	public List<Map<String, Object>> statisticsByServiceType() {
		return serviceProjectEntityMapper.statisticsByServiceType();
	}

	/**
	 * 按点击数统计服务项目
	 */
	@Override
	public List<Map<String, Object>> statisticsByReadNum() {
		return serviceProjectEntityMapper.statisticsByReadNum();
	}

	@Override
	public List<Map<String, Object>> statisticsToPlatform(
			Map<String, Object> paramsMap) {
		return serviceProjectEntityMapper.statisticsToPlatform(paramsMap);
	}
	
	@Override
	public List<Map<String, Object>> statisticsToPark(
			Map<String, Object> paramsMap) {
		return serviceProjectEntityMapper.statisticsToPark(paramsMap);
	}
	
	
	@Override
	public List<ServiceProject> findByObj(ServiceProject serviceProject) {
		ServiceProjectEntityExample example = new ServiceProjectEntityExample();
		Criteria criteria = example.createCriteria();
		
		if(serviceProject.getId() != null){
			criteria.andIdEqualTo(serviceProject.getId());
		}
		if(serviceProject.getReleases() != null){
			criteria.andReleasesEqualTo(serviceProject.getReleases());
		}
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.serviceProjectEntityMapper.selectByExample(example), ServiceProject.class);
	}
	
}
