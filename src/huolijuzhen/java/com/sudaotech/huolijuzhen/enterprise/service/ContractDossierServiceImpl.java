package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractDossierEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ContractDossierServiceImpl extends BaseServiceImpl implements ContractDossierService {
	private static final String TRACKING_TYPE = "ContractDossier";

    @Inject
    private ContractDossierEntityMapper contractDossierEntityMapper;

	@Override
	public ContractDossier getById(Long id) {
		ContractDossierEntity entity = this.contractDossierEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ContractDossier.class);
		}
		
		return null;
	}

	@Override
	public Long create(ContractDossier obj) {
		logger.debug("Creating ContractDossier: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ContractDossierEntity entity = BeanUtils.copyProperties(obj, ContractDossierEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.contractDossierEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ContractDossier: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ContractDossier obj) {
		logger.debug("Updating ContractDossier: {}", obj);

		ContractDossierEntity entity = BeanUtils.copyProperties(obj, ContractDossierEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.contractDossierEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ContractDossier: {}", obj);
	}

	@Override
	public Long save(ContractDossier obj) {
		logger.debug("Saving ContractDossier: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ContractDossier> find(Query query) {
		Page<ContractDossier> page = new Page<ContractDossier>(query);
		ContractDossierEntityExample example = new ContractDossierEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.contractDossierEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ContractDossierEntity> list = this.contractDossierEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ContractDossier.class));
		}
		
		return page;
	}

	@Override
	public List<ContractDossier> findByObj(ContractDossier obj) {
		ContractDossierEntityExample example = new ContractDossierEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
    
		if(obj.getContractId() != null){
			criteria.andContractIdEqualTo(obj.getContractId());
		}
		
		example.setOrderByClause("id DESC");
		
	   return BeanUtils.copyListProperties(this.contractDossierEntityMapper.selectByExample(example), ContractDossier.class);
	}
}
