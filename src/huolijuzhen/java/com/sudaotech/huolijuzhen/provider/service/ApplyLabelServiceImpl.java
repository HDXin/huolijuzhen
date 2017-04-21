package com.sudaotech.huolijuzhen.provider.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntity;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntityExample;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntityExample.Criteria;
import com.sudaotech.huolijuzhen.provider.dao.ApplyLabelEntityMapper;
import com.sudaotech.huolijuzhen.provider.service.ApplyOrderService.ApplyOrder;
import com.sudaotech.util.BeanUtils;

public class ApplyLabelServiceImpl extends BaseServiceImpl implements ApplyLabelService {
	private static final String TRACKING_TYPE = "ApplyLabel";

    @Inject
    private ApplyLabelEntityMapper applyLabelEntityMapper;

	@Override
	public ApplyLabel getById(Long id) {
		ApplyLabelEntity entity = this.applyLabelEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApplyLabel.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApplyLabel obj) {
		logger.debug("Creating ApplyLabel: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApplyLabelEntity entity = BeanUtils.copyProperties(obj, ApplyLabelEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.applyLabelEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApplyLabel: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApplyLabel obj) {
		logger.debug("Updating ApplyLabel: {}", obj);

		ApplyLabelEntity entity = BeanUtils.copyProperties(obj, ApplyLabelEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.applyLabelEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApplyLabel: {}", obj);
	}

	@Override
	public Long save(ApplyLabel obj) {
		logger.debug("Saving ApplyLabel: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApplyLabel> find(Query query) {
		Page<ApplyLabel> page = new Page<ApplyLabel>(query);
		ApplyLabelEntityExample example = new ApplyLabelEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("labelNo ASC");
		page.setTotal(this.applyLabelEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApplyLabelEntity> list = this.applyLabelEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApplyLabel.class));
		}
		
		return page;
	}

	@Override
	public List<ApplyLabel> findAllByApplyOrderId(ApplyOrder applyOrder) {
		ApplyLabelEntityExample example = new ApplyLabelEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long applyOrderId = applyOrder.getId();
		if(applyOrderId != null){
			criteria.andApplyOrderIdEqualTo(applyOrderId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("labelNo ASC");
		
		return BeanUtils.copyListProperties(this.applyLabelEntityMapper.selectByExample(example), ApplyLabel.class);
	}
}
