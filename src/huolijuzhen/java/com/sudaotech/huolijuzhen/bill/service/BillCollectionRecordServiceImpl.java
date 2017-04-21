package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCollectionRecordMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BillCollectionRecordServiceImpl extends BaseServiceImpl implements BillCollectionRecordService {
	private static final String TRACKING_TYPE = "BillCollectionRecord";

    @Inject
    private BillCollectionRecordMapper billCollectionRecordEntityMapper;

	@Override
	public BillCollectionRecord getById(Long id) {
		BillCollectionRecordEntity entity = this.billCollectionRecordEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillCollectionRecord.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillCollectionRecord obj) {
		logger.debug("Creating BillCollectionRecord: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL));
		
		BillCollectionRecordEntity entity = BeanUtils.copyProperties(obj, BillCollectionRecordEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billCollectionRecordEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillCollectionRecord: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillCollectionRecord obj) {
		logger.debug("Updating BillCollectionRecord: {}", obj);

		BillCollectionRecordEntity entity = BeanUtils.copyProperties(obj, BillCollectionRecordEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billCollectionRecordEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCollectionRecord: {}", obj);
	}

	@Override
	public Long save(BillCollectionRecord obj) {
		logger.debug("Saving BillCollectionRecord: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillCollectionRecord> find(Query query) {
		Page<BillCollectionRecord> page = new Page<BillCollectionRecord>(query);
		BillCollectionRecordEntityExample example = new BillCollectionRecordEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billCollectionRecordEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillCollectionRecordEntity> list = this.billCollectionRecordEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillCollectionRecord.class));
		}
		
		return page;
	}

	@Override
	public List<BillCollectionRecord> findByOBj(BillCollectionRecord record) {
		
		BillCollectionRecordEntityExample example = new BillCollectionRecordEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		if(record.getBillId() !=null){
			criteria.andBillIdEqualTo(record.getBillId());
		}
		example.setOrderByClause("id DESC");
		List<BillCollectionRecordEntity> list =  this.billCollectionRecordEntityMapper.selectByExample(example);
		
		return BeanUtils.copyListProperties(list, BillCollectionRecord.class);
		
	}
	
	@Override
	public void deteleByBillId(BillCollectionRecord obj) {
		
		logger.debug("Updating BillCollectionRecord: {}", obj);

		BillCollectionRecordEntityExample example = new BillCollectionRecordEntityExample();
		
		BillCollectionRecordEntity entity = BeanUtils.copyProperties(obj, BillCollectionRecordEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		entity.setStatus(Status.DELETED);
		
		Criteria criteria = example.createCriteria();
		criteria.andBillIdEqualTo(obj.getBillId());
		
		this.billCollectionRecordEntityMapper.updateByExampleSelective(entity, example);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCollectionRecord: {}", obj);
	}

	@Override
	public BigDecimal getTotalCollectioin(Long billId) {
		
		return this.billCollectionRecordEntityMapper.getTotalCollectioin(billId);
		
		
	}
}



