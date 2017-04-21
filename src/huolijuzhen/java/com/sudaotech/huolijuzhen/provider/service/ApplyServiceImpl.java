package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ApplyEntity;
import com.sudaotech.huolijuzhen.provider.dao.ApplyEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ApplyEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ApplyEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ApplyServiceImpl extends BaseServiceImpl implements ApplyService {
	private static final String TRACKING_TYPE = "Apply";

    @Inject
    private ApplyEntityMapper applyEntityMapper;

	@Override
	public Apply getById(Long id) {
		ApplyEntity entity = this.applyEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, Apply.class);
		}
		
		return null;
	}

	@Override
	public Long create(Apply obj) {
		logger.debug("Creating Apply: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApplyEntity entity = BeanUtils.copyProperties(obj, ApplyEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.applyEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created Apply: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(Apply obj) {
		logger.debug("Updating Apply: {}", obj);

		ApplyEntity entity = BeanUtils.copyProperties(obj, ApplyEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.applyEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated Apply: {}", obj);
	}

	@Override
	public Long save(Apply obj) {
		logger.debug("Saving Apply: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<Apply> find(Query query) {
		Page<Apply> page = new Page<Apply>(query);
		ApplyEntityExample example = new ApplyEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.applyEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApplyEntity> list = this.applyEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, Apply.class));
		}
		
		return page;
	}
}
