package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;



import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EnterpriseCorrContractServiceImpl extends BaseServiceImpl implements EnterpriseCorrContractService {
	private static final String TRACKING_TYPE = "EnterpriseCorrContract";

    @Inject
    private EnterpriseCorrContractEntityMapper enterpriseCorrContractEntityMapper;

	@Override
	public EnterpriseCorrContract getById(Long id) {
		EnterpriseCorrContractEntity entity = this.enterpriseCorrContractEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseCorrContract.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseCorrContract obj) {
		logger.debug("Creating EnterpriseCorrContract: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseCorrContractEntity entity = BeanUtils.copyProperties(obj, EnterpriseCorrContractEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseCorrContractEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseCorrContract: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseCorrContract obj) {
		logger.debug("Updating EnterpriseCorrContract: {}", obj);

		EnterpriseCorrContractEntity entity = BeanUtils.copyProperties(obj, EnterpriseCorrContractEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseCorrContractEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseCorrContract: {}", obj);
	}

	@Override
	public Long save(EnterpriseCorrContract obj) {
		logger.debug("Saving EnterpriseCorrContract: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseCorrContract> find(Query query) {
		
		Page<EnterpriseCorrContract> page = new Page<EnterpriseCorrContract>(query);
		EnterpriseCorrContractEntityExample example = new EnterpriseCorrContractEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andStatusEqualTo(Status.NORMAL);
		if(query.getCottId() != null ){
			criteria.andEnterpriseCottIdEqualTo(query.getCottId());
		}
		
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseCorrContractEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseCorrContractEntity> list = this.enterpriseCorrContractEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseCorrContract.class));
		}
		
		return page;
	}

	@Override
	public List<EnterpriseCorrContract> findByObj(EnterpriseCorrContract obj) {
		EnterpriseCorrContractEntityExample example = new EnterpriseCorrContractEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andStatusEqualTo(Status.NORMAL);
		if(obj.getEnterpriseCottId() != null){
			criteria.andEnterpriseCottIdEqualTo(obj.getEnterpriseCottId());
		}
		if(obj.getContractStatus() != null){
			criteria.andContractStatusEqualTo(obj.getContractStatus());
		}
		if(obj.getEnterpriseCottId() != null){
			criteria.andEnterpriseCottIdEqualTo(obj.getEnterpriseCottId());
		}
		if(CollectionUtils.isNotEmpty(obj.getEnterpriseCottIds())){
			criteria.andEnterpriseCottIdIn(obj.getEnterpriseCottIds());
		}
		
		if(obj.getContractId() != null){
			criteria.andContractIdEqualTo(obj.getContractId());
		}
		return BeanUtils.copyListProperties(this.enterpriseCorrContractEntityMapper.selectByExample(example),EnterpriseCorrContract.class);
	}
}
