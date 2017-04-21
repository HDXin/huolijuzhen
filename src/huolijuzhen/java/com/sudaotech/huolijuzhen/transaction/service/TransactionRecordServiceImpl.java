package com.sudaotech.huolijuzhen.transaction.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.mapping.SqlCommandType;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntity;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.transaction.dao.TransactionRecordEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class TransactionRecordServiceImpl extends BaseServiceImpl implements TransactionRecordService {
	private static final String TRACKING_TYPE = "TransactionRecord";

    @Inject
    private TransactionRecordEntityMapper transactionRecordEntityMapper;

	@Override
	public TransactionRecord getById(Long id) {
		TransactionRecordEntity entity = this.transactionRecordEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, TransactionRecord.class);
		}
		
		return null;
	}

	@Override
	public Long create(TransactionRecord obj) {
		logger.debug("Creating TransactionRecord: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_TRANSACTION));
		
		TransactionRecordEntity entity = BeanUtils.copyProperties(obj, TransactionRecordEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.transactionRecordEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created TransactionRecord: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(TransactionRecord obj) {
		logger.debug("Updating TransactionRecord: {}", obj);

		TransactionRecordEntity entity = BeanUtils.copyProperties(obj, TransactionRecordEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.transactionRecordEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated TransactionRecord: {}", obj);
	}

	@Override
	public Long save(TransactionRecord obj) {
		logger.debug("Saving TransactionRecord: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<TransactionRecord> find(Query query) {
		Page<TransactionRecord> page = new Page<TransactionRecord>(query);
		TransactionRecordEntityExample example = new TransactionRecordEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.transactionRecordEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<TransactionRecordEntity> list = this.transactionRecordEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, TransactionRecord.class));
		}
		
		return page;
	}
}
