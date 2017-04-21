package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrBusinessEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EnterpriseCorrBusinessServiceImpl extends BaseServiceImpl implements EnterpriseCorrBusinessService {
	private static final String TRACKING_TYPE = "EnterpriseCorrBusiness";

    @Inject
    private EnterpriseCorrBusinessEntityMapper EnterpriseCorrBusinessEntityMapper;

	@Override
	public EnterpriseCorrBusiness getById(Long id) {
		EnterpriseCorrBusinessEntity entity = this.EnterpriseCorrBusinessEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseCorrBusiness.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseCorrBusiness obj) {
		logger.debug("Creating EnterpriseCorrBusiness: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseCorrBusinessEntity entity = BeanUtils.copyProperties(obj, EnterpriseCorrBusinessEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.EnterpriseCorrBusinessEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseCorrBusiness: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseCorrBusiness obj) {
		logger.debug("Updating EnterpriseCorrBusiness: {}", obj);

		EnterpriseCorrBusinessEntity entity = BeanUtils.copyProperties(obj, EnterpriseCorrBusinessEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.EnterpriseCorrBusinessEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseCorrBusiness: {}", obj);
	}

	@Override
	public Long save(EnterpriseCorrBusiness obj) {
		logger.debug("Saving EnterpriseCorrBusiness: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseCorrBusiness> find(Query query) {
		Page<EnterpriseCorrBusiness> page = new Page<EnterpriseCorrBusiness>(query);
		EnterpriseCorrBusinessEntityExample example = new EnterpriseCorrBusinessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.EnterpriseCorrBusinessEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseCorrBusinessEntity> list = this.EnterpriseCorrBusinessEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseCorrBusiness.class));
		}
		
		return page;
	}
	
	@Override
	public List<EnterpriseCorrBusiness> findByObj(EnterpriseCorrBusiness obj) {
		EnterpriseCorrBusinessEntityExample example = new EnterpriseCorrBusinessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(obj.getEnterpriseCottId() != null ){
			criteria.andEnterpriseCottIdEqualTo(obj.getEnterpriseCottId());
		}
		example.setOrderByClause("id DESC");
		
		List<EnterpriseCorrBusinessEntity> list = this.EnterpriseCorrBusinessEntityMapper.selectByExample(example);
		
		return BeanUtils.copyListProperties(list, EnterpriseCorrBusiness.class);
		
	}
	
}
