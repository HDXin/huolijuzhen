package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntity;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ServiceProjectHistoryEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ServiceProjectHistoryServiceImpl extends BaseServiceImpl implements ServiceProjectHistoryService {
	private static final String TRACKING_TYPE = "ServiceProjectHistory";

    @Inject
    private ServiceProjectHistoryEntityMapper serviceProjectHistoryEntityMapper;

	@Override
	public ServiceProjectHistory getById(Long id) {
		ServiceProjectHistoryEntity entity = this.serviceProjectHistoryEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ServiceProjectHistory.class);
		}
		
		return null;
	}

	@Override
	public Long create(ServiceProjectHistory obj) {
		logger.debug("Creating ServiceProjectHistory: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ServiceProjectHistoryEntity entity = BeanUtils.copyProperties(obj, ServiceProjectHistoryEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.serviceProjectHistoryEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ServiceProjectHistory: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ServiceProjectHistory obj) {
		logger.debug("Updating ServiceProjectHistory: {}", obj);

		ServiceProjectHistoryEntity entity = BeanUtils.copyProperties(obj, ServiceProjectHistoryEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.serviceProjectHistoryEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ServiceProjectHistory: {}", obj);
	}

	@Override
	public Long save(ServiceProjectHistory obj) {
		logger.debug("Saving ServiceProjectHistory: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ServiceProjectHistory> find(Query query) {
		Page<ServiceProjectHistory> page = new Page<ServiceProjectHistory>(query);
		ServiceProjectHistoryEntityExample example = new ServiceProjectHistoryEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.serviceProjectHistoryEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ServiceProjectHistoryEntity> list = this.serviceProjectHistoryEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ServiceProjectHistory.class));
		}
		
		return page;
	}

	@Override
	public List<ServiceProjectHistory> findByObj(
			ServiceProjectHistory serviceProjectHistory) {
		ServiceProjectHistoryEntityExample example = new ServiceProjectHistoryEntityExample();
		Criteria criteria = example.createCriteria();
		
		if(serviceProjectHistory.getServiceProId() != null){
			criteria.andServiceProIdEqualTo(serviceProjectHistory.getServiceProId());
		}
		
		if(serviceProjectHistory.getServiceProRelease() != null){
			criteria.andServiceProReleaseEqualTo(serviceProjectHistory.getServiceProRelease());
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		return BeanUtils.copyListProperties(this.serviceProjectHistoryEntityMapper.selectByExample(example), ServiceProjectHistory.class);
	}
}
