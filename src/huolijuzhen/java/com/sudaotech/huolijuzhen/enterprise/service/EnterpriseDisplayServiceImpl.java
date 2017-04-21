package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntityExample;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntityExample.Criteria;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntityMapper;
import com.sudaotech.util.BeanUtils;

public class EnterpriseDisplayServiceImpl extends BaseServiceImpl implements EnterpriseDisplayService {
	private static final String TRACKING_TYPE = "EnterpriseDisplay";

    @Inject
    private EnterpriseDisplayEntityMapper enterpriseDisplayEntityMapper;

	@Override
	public EnterpriseDisplay getById(Long id) {
		EnterpriseDisplayEntity entity = this.enterpriseDisplayEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, EnterpriseDisplay.class);
		}
		
		return null;
	}

	@Override
	public Long create(EnterpriseDisplay obj) {
		logger.debug("Creating EnterpriseDisplay: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		EnterpriseDisplayEntity entity = BeanUtils.copyProperties(obj, EnterpriseDisplayEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.enterpriseDisplayEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created EnterpriseDisplay: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(EnterpriseDisplay obj) {
		logger.debug("Updating EnterpriseDisplay: {}", obj);

		EnterpriseDisplayEntity entity = BeanUtils.copyProperties(obj, EnterpriseDisplayEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.enterpriseDisplayEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated EnterpriseDisplay: {}", obj);
	}

	@Override
	public Long save(EnterpriseDisplay obj) {
		logger.debug("Saving EnterpriseDisplay: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<EnterpriseDisplay> find(Query query) {
		Page<EnterpriseDisplay> page = new Page<EnterpriseDisplay>(query);
		EnterpriseDisplayEntityExample example = new EnterpriseDisplayEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.enterpriseDisplayEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<EnterpriseDisplayEntity> list = this.enterpriseDisplayEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, EnterpriseDisplay.class));
		}
		
		return page;
	}
}
