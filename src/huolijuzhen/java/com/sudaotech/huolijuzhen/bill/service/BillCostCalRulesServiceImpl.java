package com.sudaotech.huolijuzhen.bill.service;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCostCalRulesEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BillCostCalRulesServiceImpl extends BaseServiceImpl implements BillCostCalRulesService {
	private static final String TRACKING_TYPE = "BillCostCalRules";

    @Inject
    private BillCostCalRulesEntityMapper billCostCalRulesEntityMapper;

	@Override
	public BillCostCalRules getById(Long id) {
		BillCostCalRulesEntity entity = this.billCostCalRulesEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillCostCalRules.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillCostCalRules obj) {
		logger.debug("Creating BillCostCalRules: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL));
		
		BillCostCalRulesEntity entity = BeanUtils.copyProperties(obj, BillCostCalRulesEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billCostCalRulesEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillCostCalRules: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillCostCalRules obj) {
		logger.debug("Updating BillCostCalRules: {}", obj);

		BillCostCalRulesEntity entity = BeanUtils.copyProperties(obj, BillCostCalRulesEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billCostCalRulesEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCostCalRules: {}", obj);
	}

	@Override
	public Long save(BillCostCalRules obj) {
		logger.debug("Saving BillCostCalRules: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillCostCalRules> find(Query query) {
		Page<BillCostCalRules> page = new Page<BillCostCalRules>(query);
		BillCostCalRulesEntityExample example = new BillCostCalRulesEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billCostCalRulesEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillCostCalRulesEntity> list = this.billCostCalRulesEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillCostCalRules.class));
		}
		
		return page;
	}

	@Override
	public List<BillCostCalRules> findByObj(BillCostCalRules query) {
		BillCostCalRulesEntityExample example = new BillCostCalRulesEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(query.getContractId() != null){
			criteria.andContractIdEqualTo(query.getContractId());
		}
			
		example.setOrderByClause("id DESC");
		
	    return BeanUtils.copyListProperties(this.billCostCalRulesEntityMapper.selectByExample(example), BillCostCalRules.class);
	    		
		
	}
}
