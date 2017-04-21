package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCollectEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCollectEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceCollectEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceCollectEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ServiceCollectServiceImpl extends BaseServiceImpl implements ServiceCollectService {
	private static final String TRACKING_TYPE = "ServiceCollect";

    @Inject
    private LocationServiceCollectEntityMapper serviceCollectEntityMapper;

	@Override
	public ServiceCollect getById(Long id) {
		ServiceCollectEntity entity = this.serviceCollectEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceCollect.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceCollect obj) {
		logger.debug("Creating ServiceCollect: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceCollectEntity entity = BeanUtils.copyProperties(obj, ServiceCollectEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceCollectEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceCollect: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceCollect obj) {
		logger.debug("Updating ServiceCollect: {}", obj);

		ServiceCollectEntity entity = BeanUtils.copyProperties(obj, ServiceCollectEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceCollectEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceCollect: {}", obj);
	}

	@Override
	public Long save(ServiceCollect obj) {
		logger.debug("Saving ServiceCollect: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceCollect> find(Query query) {
		Page<ServiceCollect> page = new Page<ServiceCollect>(query);
		ServiceCollectEntityExample example = new ServiceCollectEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long collectBy = query.getCollectBy();
		if(collectBy != null){
			criteria.andCollectByEqualTo(collectBy);
		}
		
		Long parkId = query.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}

		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceCollectEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceCollectEntity> list = this.serviceCollectEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceCollect.class));
		}
		
		return page;
	}

	@Override
	public Page<ServiceCollect> findByServiceCollect(
			CollectService collectService) {
		Page<ServiceCollect> page = new Page<ServiceCollect>(collectService);
		
		ServiceCollectEntityExample example = new ServiceCollectEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long collectBy = collectService.getCollectBy();
		if(collectBy != null){
			criteria.andCollectByEqualTo(collectBy);
		}
		
		Long parkId = collectService.getParkId();
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		Long serviceProId = collectService.getServiceProId();
		if(serviceProId != null){
			criteria.andServiceProIdEqualTo(serviceProId);
		}
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceCollectEntityMapper.countByExample(example));
		if (page.getTotal() > collectService.getOffset()) {
			List<ServiceCollectEntity> list = this.serviceCollectEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(collectService));
			page.setItems(BeanUtils.copyListProperties(list, ServiceCollect.class));
		}
		
		return page;
	}

	@Override
	public Integer findCollectNum(Long serviceProId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceProId", serviceProId);
		params.put("status", Status.NORMAL.code());
		
		Integer collectNum = serviceCollectEntityMapper.findCollectNum(params);
		
		return collectNum;
	}

	@Override
	public Long isCollect(Long serviceProId, Long collectBy,Long parkId) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("serviceProId", serviceProId);
		params.put("status", Status.NORMAL.code());
		params.put("collectBy", collectBy);
		params.put("parkId", parkId);

		List<Long> serviceCollectIds = serviceCollectEntityMapper.isCollect(params);
		
		if(CollectionUtils.isNotEmpty(serviceCollectIds)){
			return serviceCollectIds.get(0);
		}else{
			return null;
		}
	}
	
	
}
