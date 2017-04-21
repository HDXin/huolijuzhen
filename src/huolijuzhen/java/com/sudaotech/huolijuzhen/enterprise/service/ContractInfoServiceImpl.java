package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.LocationContractInfoEntityMapper;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class ContractInfoServiceImpl extends BaseServiceImpl implements ContractInfoService {
	
	private static final String TRACKING_TYPE = "ContractInfo";

    @Inject
    private LocationContractInfoEntityMapper contractInfoEntityMapper;

	@Override
	public ContractInfo getById(Long id) {
		ContractInfoEntity entity = this.contractInfoEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ContractInfo.class);
		}
		
		return null;
	}

	@Override
	public Long create(ContractInfo obj) {
		logger.debug("Creating ContractInfo: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCT_CONTRACT));
		
		ContractInfoEntity entity = BeanUtils.copyProperties(obj, ContractInfoEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.contractInfoEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ContractInfo: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ContractInfo obj) {
		logger.debug("Updating ContractInfo: {}", obj);

		ContractInfoEntity entity = BeanUtils.copyProperties(obj, ContractInfoEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.contractInfoEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ContractInfo: {}", obj);
	}

	@Override
	public Long save(ContractInfo obj) {
		logger.debug("Saving ContractInfo: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ContractInfo> find(Query query) {
		Page<ContractInfo> page = new Page<ContractInfo>(query);
		ContractInfoEntityExample example = new ContractInfoEntityExample();
		Criteria criteria = example.createCriteria();
		
		if(CollectionUtils.isNotEmpty(query.getContractInfoIds())){
			criteria.andIdIn(query.getContractInfoIds());
		}
		
		if(query.getContractStatus() != null){
			criteria.andContractStatusEqualTo(ContractStatus.WAITSUBMIT);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause(" enterpriseName ASC,contNo ASC ");
		page.setTotal(this.contractInfoEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractInfoEntity> list = this.contractInfoEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractInfo.class));
		}
		
		return page;
	}

	@Override
	public List<ContractInfo> findByObj(ContractInfo ci) {
		
		ContractInfoEntityExample example = new ContractInfoEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(CollectionUtils.isNotEmpty(ci.getIds())){
			criteria.andIdIn(ci.getIds());
		}
		example.setOrderByClause("id DESC");
		
		return  BeanUtils.copyListProperties(this.contractInfoEntityMapper.selectByExample(example),ContractInfo.class);
	
	}

	@Override
	public Page<Map<String, Object>> findByBillMonthAndEnterpriseIdAndContractId(
			ContractInfoQuery contractInfoQuery) {

		Map<String, Object> params = new HashedMap<String, Object>();
		params.put("parkId", contractInfoQuery.getParkId());
		params.put("billMonth", contractInfoQuery.getBillMonth());
		params.put("companyId", contractInfoQuery.getCompanyId());
		params.put("contractId", contractInfoQuery.getContractId());
		
		//total 总数
		Page<Map<String, Object>> page = new Page<Map<String,Object>>();
		int total = contractInfoEntityMapper.findByBillMonthAndEnterpriseIdAndContractIdCount(params);
		page.setTotal(total);

		Integer limit = contractInfoQuery.getLimit();
		params.put("limit", limit);
		Integer offset = contractInfoQuery.getOffset();
		params.put("offset", offset);
		List<Map<String, Object>> itemMap = contractInfoEntityMapper.findByBillMonthAndEnterpriseIdAndContractId(params);
		page.setLimit(limit);
		page.setOffset(offset);
		page.setPage(contractInfoQuery.getStartPage());

		page.setItems(itemMap);
		return page;
	}
	
}
