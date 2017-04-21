package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntity;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ApplyTemplateEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ApplyTemplateServiceImpl extends BaseServiceImpl implements ApplyTemplateService {
	private static final String TRACKING_TYPE = "ApplyTemplate";

    @Inject
    private ApplyTemplateEntityMapper applyTemplateEntityMapper;

	@Override
	public ApplyTemplate getById(Long id) {
		ApplyTemplateEntity entity = this.applyTemplateEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApplyTemplate.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApplyTemplate obj) {
		logger.debug("Creating ApplyTemplate: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApplyTemplateEntity entity = BeanUtils.copyProperties(obj, ApplyTemplateEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.applyTemplateEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApplyTemplate: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApplyTemplate obj) {
		logger.debug("Updating ApplyTemplate: {}", obj);

		ApplyTemplateEntity entity = BeanUtils.copyProperties(obj, ApplyTemplateEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.applyTemplateEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApplyTemplate: {}", obj);
	}

	@Override
	public Long save(ApplyTemplate obj) {
		logger.debug("Saving ApplyTemplate: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApplyTemplate> find(Query query) {
		Page<ApplyTemplate> page = new Page<ApplyTemplate>(query);
		ApplyTemplateEntityExample example = new ApplyTemplateEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.applyTemplateEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApplyTemplateEntity> list = this.applyTemplateEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApplyTemplate.class));
		}
		
		return page;
	}
}
