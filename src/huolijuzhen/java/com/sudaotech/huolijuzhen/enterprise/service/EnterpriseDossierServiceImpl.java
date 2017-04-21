package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDossierEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EnterpriseDossierServiceImpl extends BaseServiceImpl implements EnterpriseDossierService {
	private static final String TRACKING_TYPE = "EnterpriseDossier";

    @Inject
    private EnterpriseDossierEntityMapper enterpriseDossierEntityMapper;

	@Override
	public EnterpriseDossier getById(Long id) {
		EnterpriseDossierEntity entity = this.enterpriseDossierEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseDossier.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseDossier obj) {
		logger.debug("Creating EnterpriseDossier: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseDossierEntity entity = BeanUtils.copyProperties(obj, EnterpriseDossierEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseDossierEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseDossier: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseDossier obj) {
		logger.debug("Updating EnterpriseDossier: {}", obj);

		EnterpriseDossierEntity entity = BeanUtils.copyProperties(obj, EnterpriseDossierEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseDossierEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseDossier: {}", obj);
	}

	@Override
	public Long save(EnterpriseDossier obj) {
		logger.debug("Saving EnterpriseDossier: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseDossier> find(Query query) {
		Page<EnterpriseDossier> page = new Page<EnterpriseDossier>(query);
		EnterpriseDossierEntityExample example = new EnterpriseDossierEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseDossierEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseDossierEntity> list = this.enterpriseDossierEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseDossier.class));
		}
		
		return page;
	}

	@Override
	public List<EnterpriseDossier> findByObj(EnterpriseDossier obj) {
		EnterpriseDossierEntityExample example = new EnterpriseDossierEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(obj.getEnterpriseId() !=  null){
			criteria.andEnterpriseIdEqualTo(obj.getEnterpriseId());
		}
		return BeanUtils.copyListProperties(this.enterpriseDossierEntityMapper.selectByExample(example),EnterpriseDossier.class);
		
	}
}
