package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alipay.api.domain.ContactFollower;
import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractBillEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ContractBillServiceImpl extends BaseServiceImpl implements ContractBillService {
	private static final String TRACKING_TYPE = "ContractBill";

    @Inject
    private ContractBillEntityMapper contractBillEntityMapper;

	@Override
	public ContractBill getById(Long id) {
		ContractBillEntity entity = this.contractBillEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ContractBill.class);
		}
		
		return null;
	}

	@Override
	public Long create(ContractBill obj) {
		logger.debug("Creating ContractBill: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ContractBillEntity entity = BeanUtils.copyProperties(obj, ContractBillEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.contractBillEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ContractBill: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ContractBill obj) {
		logger.debug("Updating ContractBill: {}", obj);

		ContractBillEntity entity = BeanUtils.copyProperties(obj, ContractBillEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.contractBillEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ContractBill: {}", obj);
	}

	@Override
	public Long save(ContractBill obj) {
		logger.debug("Saving ContractBill: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ContractBill> find(Query query) {
		Page<ContractBill> page = new Page<ContractBill>(query);
		ContractBillEntityExample example = new ContractBillEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.contractBillEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractBillEntity> list = this.contractBillEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractBill.class));
		}
		
		return page;
	}

	@Override
	public List<ContractBill> findAllPast(ContractBill contractBill) {

		ContractBillEntityExample example = new ContractBillEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		String month = contractBill.getMonth();
		if(StringUtils.isNotBlank(month)){
			criteria.andMonthEqualTo(month);
		}
		
		Long costProId = contractBill.getCostProId();
		if(costProId != null){
			criteria.andCostProIdEqualTo(costProId);
		}
		
		Long contractId = contractBill.getContractId();
		if(contractBill != null){
			criteria.andContractIdEqualTo(contractId);
		}
		example.setOrderByClause("month ASC");

		return BeanUtils.copyListProperties(this.contractBillEntityMapper.selectByExample(example), ContractBill.class);
	}
}
