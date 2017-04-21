package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntity;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.OrderTemplateEntityMapper;
import com.sudaotech.util.BeanUtils;

public class OrderTemplateServiceImpl extends BaseServiceImpl implements OrderTemplateService {
	private static final String TRACKING_TYPE = "OrderTemplate";

    @Inject
    private OrderTemplateEntityMapper orderTemplateEntityMapper;

	@Override
	public OrderTemplate getById(Long id) {
		OrderTemplateEntity entity = this.orderTemplateEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, OrderTemplate.class);
		}
		
		return null;
	}

	@Override
	public Long create(OrderTemplate obj) {
		logger.debug("Creating OrderTemplate: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		OrderTemplateEntity entity = BeanUtils.copyProperties(obj, OrderTemplateEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.orderTemplateEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created OrderTemplate: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(OrderTemplate obj) {
		logger.debug("Updating OrderTemplate: {}", obj);

		OrderTemplateEntity entity = BeanUtils.copyProperties(obj, OrderTemplateEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.orderTemplateEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated OrderTemplate: {}", obj);
	}

	@Override
	public Long save(OrderTemplate obj) {
		logger.debug("Saving OrderTemplate: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<OrderTemplate> find(Query query) {
		Page<OrderTemplate> page = new Page<OrderTemplate>(query);
		OrderTemplateEntityExample example = new OrderTemplateEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.orderTemplateEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<OrderTemplateEntity> list = this.orderTemplateEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, OrderTemplate.class));
		}
		
		return page;
	}
}
