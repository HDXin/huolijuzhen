package com.sudaotech.huolijuzhen.bill.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillChangeLogsEntityMapper;
import com.sudaotech.util.BeanUtils;

public class BillChangeLogsServiceImpl extends BaseServiceImpl implements BillChangeLogsService {
	private static final String TRACKING_TYPE = "BillChangeLogs";

    @Inject
    private BillChangeLogsEntityMapper billChangeLogsEntityMapper;

	@Override
	public BillChangeLogs getById(Long id) {
		BillChangeLogsEntity entity = this.billChangeLogsEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillChangeLogs.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillChangeLogs obj) {
		logger.debug("Creating BillChangeLogs: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		BillChangeLogsEntity entity = BeanUtils.copyProperties(obj, BillChangeLogsEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billChangeLogsEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillChangeLogs: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillChangeLogs obj) {
		logger.debug("Updating BillChangeLogs: {}", obj);

		BillChangeLogsEntity entity = BeanUtils.copyProperties(obj, BillChangeLogsEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billChangeLogsEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillChangeLogs: {}", obj);
	}

	@Override
	public Long save(BillChangeLogs obj) {
		logger.debug("Saving BillChangeLogs: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillChangeLogs> find(Query query) {
		Page<BillChangeLogs> page = new Page<BillChangeLogs>(query);
		BillChangeLogsEntityExample example = new BillChangeLogsEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billChangeLogsEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillChangeLogsEntity> list = this.billChangeLogsEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillChangeLogs.class));
		}
		
		return page;
	}
}
