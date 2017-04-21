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
import com.sudaotech.huolijuzhen.provider.dao.ServiceParkEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceParkEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceParkEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.LocationServiceParkEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ServiceParkServiceImpl extends BaseServiceImpl implements ServiceParkService {
	private static final String TRACKING_TYPE = "ServicePark";

    @Inject
    private LocationServiceParkEntityMapper serviceParkEntityMapper;

	@Override
	public ServicePark getById(Long id) {
		ServiceParkEntity entity = this.serviceParkEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServicePark.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServicePark obj) {
		logger.debug("Creating ServicePark: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceParkEntity entity = BeanUtils.copyProperties(obj, ServiceParkEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceParkEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServicePark: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServicePark obj) {
		logger.debug("Updating ServicePark: {}", obj);

		ServiceParkEntity entity = BeanUtils.copyProperties(obj, ServiceParkEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceParkEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServicePark: {}", obj);
	}

	@Override
	public Long save(ServicePark obj) {
		logger.debug("Saving ServicePark: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServicePark> find(Query query) {
		Page<ServicePark> page = new Page<ServicePark>(query);
		ServiceParkEntityExample example = new ServiceParkEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceParkEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceParkEntity> list = this.serviceParkEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServicePark.class));
		}
		
		return page;
	}

	@Override
	public List<Long> findAllBySql(Map<String, Object> params) {

		List<Long> ids = serviceParkEntityMapper.findAllBySql(params);
		
		return ids;
	}
	
	@Override
	public Map<String, Object> findBySql(Map<String, Object> params){
		params.put("status", Status.NORMAL.code());
		List<Map<String, Object>> list = serviceParkEntityMapper.findBySql(params);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else {
			return list.get(0);
		}
	}

	/**
	 * 获取所有的有效的服务项目（园区选用的）
	 */
	@Override
	public List<Long> findAllValidServiceProId(Map<String, Object> parmas) {
		List<Long> validServiceProIds = serviceParkEntityMapper.findAllValidServiceProIds(parmas);
		return validServiceProIds;
	}

	@Override
	public List<Long> findAllParkIdsByServiceProIdAndRelease(Long serviceProId,Integer serviceProRelease) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", Status.NORMAL.code());
		params.put("serviceProId", serviceProId);
		params.put("serviceProRelease", serviceProRelease);
		List<Long> parkIds = serviceParkEntityMapper.findAllParkIdsByServiceProId(params);
		return parkIds;
	}

	@Override
	public void updateByServiceProIdAndRelease(Long serviceProId,Integer serviceProRelease) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceProId", serviceProId);
		params.put("status", Status.DELETED.code());
		params.put("serviceProRelease", serviceProRelease);
		
		serviceParkEntityMapper.updateByServiceProIdAndRelease(params);
		
	}
	
	
}
