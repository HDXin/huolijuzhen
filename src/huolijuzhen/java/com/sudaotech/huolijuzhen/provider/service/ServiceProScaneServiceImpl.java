package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProScaneEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ServiceProScaneServiceImpl extends BaseServiceImpl implements ServiceProScaneService {
	private static final String TRACKING_TYPE = "ServiceProScane";

    @Inject
    private ServiceProScaneEntityMapper serviceProScaneEntityMapper;

	@Override
	public ServiceProScane getById(Long id) {
		ServiceProScaneEntity entity = this.serviceProScaneEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceProScane.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceProScane obj) {
		logger.debug("Creating ServiceProScane: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceProScaneEntity entity = BeanUtils.copyProperties(obj, ServiceProScaneEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceProScaneEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceProScane: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceProScane obj) {
		logger.debug("Updating ServiceProScane: {}", obj);

		ServiceProScaneEntity entity = BeanUtils.copyProperties(obj, ServiceProScaneEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceProScaneEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceProScane: {}", obj);
	}

	@Override
	public Long save(ServiceProScane obj) {
		logger.debug("Saving ServiceProScane: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceProScane> find(Query query) {
		Page<ServiceProScane> page = new Page<ServiceProScane>(query);
		ServiceProScaneEntityExample example = new ServiceProScaneEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceProScaneEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceProScaneEntity> list = this.serviceProScaneEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceProScane.class));
		}
		
		return page;
	}
	
	@Override
	public List<ServiceProScane> findByObj(ServiceProScane serviceProScane) {
		ServiceProScaneEntityExample example = new ServiceProScaneEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		if(serviceProScane.getServiceProId() != null){
			criteria.andServiceProIdEqualTo(serviceProScane.getServiceProId());
		}
		
		if(serviceProScane.getServiceScaneId() != null){
			criteria.andServiceScaneIdEqualTo(serviceProScane.getServiceScaneId());
		}
		
		if(serviceProScane.getServiceProRelease() != null){
			criteria.andServiceProReleaseEqualTo(serviceProScane.getServiceProRelease());
		}
		
		if(serviceProScane.getIsPast() != null){
			criteria.andIsPastEqualTo(serviceProScane.getIsPast());
		}

		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.serviceProScaneEntityMapper.selectByExample(example), ServiceProScane.class);
	}
}
