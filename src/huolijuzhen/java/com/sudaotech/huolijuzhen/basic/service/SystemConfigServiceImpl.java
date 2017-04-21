package com.sudaotech.huolijuzhen.basic.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntity;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExample.Criteria;
import com.sudaotech.huolijuzhen.basic.dao.SystemConfigEntityExtendsMapper;
import com.sudaotech.util.BeanUtils;

public class SystemConfigServiceImpl extends BaseServiceImpl implements SystemConfigService {
	private static final String TRACKING_TYPE = "SystemConfig";

    @Inject
    private SystemConfigEntityExtendsMapper systemConfigEntityExtendsMapper;

	@Override
	public SystemConfig getById(Long id) {
		SystemConfigEntity entity = this.systemConfigEntityExtendsMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, SystemConfig.class);
		}
		
		return null;
	}

	@Override
	public Long create(SystemConfig obj) {
		logger.debug("Creating SystemConfig: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		SystemConfigEntity entity = BeanUtils.copyProperties(obj, SystemConfigEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.systemConfigEntityExtendsMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created SystemConfig: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(SystemConfig obj) {
		logger.debug("Updating SystemConfig: {}", obj);

		SystemConfigEntity entity = BeanUtils.copyProperties(obj, SystemConfigEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.systemConfigEntityExtendsMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated SystemConfig: {}", obj);
	}

	@Override
	public Long save(SystemConfig obj) {
		logger.debug("Saving SystemConfig: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<SystemConfig> find(Query query) {
		Page<SystemConfig> page = new Page<SystemConfig>(query);
		SystemConfigEntityExample example = new SystemConfigEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.systemConfigEntityExtendsMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<SystemConfigEntity> list = this.systemConfigEntityExtendsMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, SystemConfig.class));
		}
		
		return page;
	}

	@Override
	public List<SystemConfig> getByParkId(Long parkId) {
		return systemConfigEntityExtendsMapper.getByParkId(parkId);
	}
}
