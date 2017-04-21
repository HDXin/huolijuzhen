package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntityMapper;
import com.sudaotech.huolijuzhen.enums.UseStatus;
import com.sudaotech.util.BeanUtils;

public class ContractResourceServiceImpl extends BaseServiceImpl implements ContractResourceService {
	private static final String TRACKING_TYPE = "ContractResource";

    @Inject
    private ContractResourceEntityMapper contractResourceEntityMapper;

	@Override
	public ContractResource getById(Long id) {
		ContractResourceEntity entity = this.contractResourceEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ContractResource.class);
		}
		
		return null;
	}

	@Override
	public Long create(ContractResource obj) {
		logger.debug("Creating ContractResource: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ContractResourceEntity entity = BeanUtils.copyProperties(obj, ContractResourceEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.contractResourceEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ContractResource: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ContractResource obj) {
		logger.debug("Updating ContractResource: {}", obj);

		ContractResourceEntity entity = BeanUtils.copyProperties(obj, ContractResourceEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.contractResourceEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ContractResource: {}", obj);
	}

	@Override
	public Long save(ContractResource obj) {
		logger.debug("Saving ContractResource: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ContractResource> find(Query query) {
		Page<ContractResource> page = new Page<ContractResource>(query);
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.contractResourceEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractResourceEntity> list = this.contractResourceEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractResource.class));
		}
		
		return page;
	}

	@Override
	public Page<ContractResource> platformFind(PlatformQuery query) {
		Page<ContractResource> page = new Page<ContractResource>(query);
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();
		
		Long constractId = query.getConstractId();
		if(constractId != null){
			criteria.andContractIdEqualTo(constractId);
		}
		
		Long resourceId = query.getResourceId();
		if(resourceId != null){
			criteria.andResourceIdEqualTo(resourceId);
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.contractResourceEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractResourceEntity> list = this.contractResourceEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractResource.class));
		}
		
		return page;
	}

	@Override
	public Page<ContractResource> parkFind(ParkQuery query) {
		Page<ContractResource> page = new Page<ContractResource>(query);
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.contractResourceEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractResourceEntity> list = this.contractResourceEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractResource.class));
		}
		
		return page;
	}

	@Override
	public List<ContractResource> findByObj(ContractResource contractResource) {
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();

		Long contractId = contractResource.getContractId();
		
		List<Long> resourceIds = contractResource.getNotInResourceIds();
		if(CollectionUtils.isNotEmpty(resourceIds)){
			criteria.andResourceIdIn(resourceIds);
			if(contractId != null){
				criteria.andContractIdNotEqualTo(contractId);
			}
			criteria.andUseStatusEqualTo(UseStatus.USE);
		}else{
			if(contractId != null){
				criteria.andContractIdEqualTo(contractId);
			}
		}
		
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		return BeanUtils.copyListProperties(this.contractResourceEntityMapper.selectByExample(example), ContractResource.class);
		
	}
	
	@Override
	public List<ContractResource> findInvalid(Long contractId,List<Long> resourceIds) {
		
		if(CollectionUtils.isEmpty(resourceIds)){
			return null;
		}
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();

		criteria.andContractIdNotEqualTo(contractId);
		criteria.andResourceIdIn(resourceIds);
		criteria.andUseStatusEqualTo(UseStatus.USE);
		criteria.andStatusEqualTo(Status.NORMAL);
		
		example.setOrderByClause("createTime DESC");
		return BeanUtils.copyListProperties(this.contractResourceEntityMapper.selectByExample(example), ContractResource.class);
	}

	@Override
	public List<ContractResource> findAllUseReslurce(
			ContractResource contractResource) {
		ContractResourceEntityExample example = new ContractResourceEntityExample();
		Criteria criteria = example.createCriteria();
		Date now = new Date();
		criteria.andStartDateLessThanOrEqualTo(now);
		criteria.andEndDateGreaterThanOrEqualTo(now);
		criteria.andUseStatusEqualTo(UseStatus.USE);
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("createTime DESC");
		return BeanUtils.copyListProperties(this.contractResourceEntityMapper.selectByExample(example), ContractResource.class);
	}
}
