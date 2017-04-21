package com.sudaotech.huolijuzhen.bill.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntity;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.RollPeriodEntityMapper;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.util.BeanUtils;

public class RollPeriodServiceImpl extends BaseServiceImpl implements RollPeriodService {
	private static final String TRACKING_TYPE = "RollPeriod";

    @Inject
    private RollPeriodEntityMapper rollPeriodEntityMapper;

	@Override
	public RollPeriod getById(Long id) {
		RollPeriodEntity entity = this.rollPeriodEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, RollPeriod.class);
		}
		
		return null;
	}

	@Override
	public Long create(RollPeriod obj) {
		logger.debug("Creating RollPeriod: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		RollPeriodEntity entity = BeanUtils.copyProperties(obj, RollPeriodEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.rollPeriodEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created RollPeriod: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(RollPeriod obj) {
		logger.debug("Updating RollPeriod: {}", obj);

		RollPeriodEntity entity = BeanUtils.copyProperties(obj, RollPeriodEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.rollPeriodEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated RollPeriod: {}", obj);
	}

	@Override
	public Long save(RollPeriod obj) {
		logger.debug("Saving RollPeriod: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<RollPeriod> find(Query query) {
		Page<RollPeriod> page = new Page<RollPeriod>(query);
		RollPeriodEntityExample example = new RollPeriodEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.rollPeriodEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<RollPeriodEntity> list = this.rollPeriodEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, RollPeriod.class));
		}
		
		return page;
	}

	@Override
	public List<RollPeriod> findByObj(BillCostCalRules obj) {
		//1.当计算规则为空时
		if(obj == null || obj.getId() == null){
			return null;
		}
		//2.当计算规则不为空时，查询对应的所有滚动周期列表
		RollPeriodEntityExample example = new RollPeriodEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andBillCostCalRulesIdEqualTo(obj.getId());
		example.setOrderByClause("startDate ASC");
		
		List<RollPeriod> rollPeriods = BeanUtils.copyListProperties(this.rollPeriodEntityMapper.selectByExample(example), RollPeriod.class);
		
		return rollPeriods;
	}
}
