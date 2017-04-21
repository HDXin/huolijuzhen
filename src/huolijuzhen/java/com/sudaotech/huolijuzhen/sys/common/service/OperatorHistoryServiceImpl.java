package com.sudaotech.huolijuzhen.sys.common.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.sys.common.dao.LocationOperatorHistoryEntityMapper;
import com.sudaotech.huolijuzhen.sys.common.dao.OperatorHistoryEntity;
import com.sudaotech.huolijuzhen.sys.common.dao.OperatorHistoryEntityExample;
import com.sudaotech.huolijuzhen.sys.common.dao.OperatorHistoryEntityExample.Criteria;
import com.sudaotech.util.BeanUtils;

public class OperatorHistoryServiceImpl extends BaseServiceImpl implements OperatorHistoryService {
	private static final String TRACKING_TYPE = "OperatorHistory";

    @Inject
    private LocationOperatorHistoryEntityMapper operatorHistoryEntityMapper;

	@Override
	public OperatorHistory getById(Long id) {
		OperatorHistoryEntity entity = this.operatorHistoryEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, OperatorHistory.class);
		}
		
		return null;
	}

	@Override
	public Long create(OperatorHistory obj) {
		logger.debug("Creating OperatorHistory: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		OperatorHistoryEntity entity = BeanUtils.copyProperties(obj, OperatorHistoryEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.operatorHistoryEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created OperatorHistory: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(OperatorHistory obj) {
		logger.debug("Updating OperatorHistory: {}", obj);

		OperatorHistoryEntity entity = BeanUtils.copyProperties(obj, OperatorHistoryEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.operatorHistoryEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated OperatorHistory: {}", obj);
	}

	@Override
	public Long save(OperatorHistory obj) {
		logger.debug("Saving OperatorHistory: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<OperatorHistory> find(Query query) {
		Page<OperatorHistory> page = new Page<OperatorHistory>(query);
		OperatorHistoryEntityExample example = new OperatorHistoryEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.operatorHistoryEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<OperatorHistoryEntity> list = this.operatorHistoryEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, OperatorHistory.class));
		}
		
		return page;
	}
	
}
