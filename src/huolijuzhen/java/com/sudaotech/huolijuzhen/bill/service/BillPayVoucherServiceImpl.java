package com.sudaotech.huolijuzhen.bill.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntityMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BillPayVoucherServiceImpl extends BaseServiceImpl implements BillPayVoucherService {
	private static final String TRACKING_TYPE = "BillPayVoucher";

    @Inject
    private BillPayVoucherEntityMapper billPayVoucherEntityMapper;

	@Override
	public BillPayVoucher getById(Long id) {
		BillPayVoucherEntity entity = this.billPayVoucherEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillPayVoucher.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillPayVoucher obj) {
		logger.debug("Creating BillPayVoucher: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL));
		
		BillPayVoucherEntity entity = BeanUtils.copyProperties(obj, BillPayVoucherEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billPayVoucherEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillPayVoucher: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillPayVoucher obj) {
		logger.debug("Updating BillPayVoucher: {}", obj);

		BillPayVoucherEntity entity = BeanUtils.copyProperties(obj, BillPayVoucherEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billPayVoucherEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillPayVoucher: {}", obj);
	}

	@Override
	public Long save(BillPayVoucher obj) {
		logger.debug("Saving BillPayVoucher: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillPayVoucher> find(Query query) {
		Page<BillPayVoucher> page = new Page<BillPayVoucher>(query);
		BillPayVoucherEntityExample example = new BillPayVoucherEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billPayVoucherEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillPayVoucherEntity> list = this.billPayVoucherEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillPayVoucher.class));
		}
		
		return page;
	}

	@Override
	public List<BillPayVoucher> findByObj(BillPayVoucher record) {
		
		BillPayVoucherEntityExample example = new BillPayVoucherEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(record.getBillId() != null){
     	   criteria.andBillIdEqualTo(record.getBillId());
		}
		example.setOrderByClause("id DESC");
		
		List<BillPayVoucherEntity> list = this.billPayVoucherEntityMapper.selectByExample(example);
		
		return BeanUtils.copyListProperties(list, BillPayVoucher.class);
		
	}

}
