package com.sudaotech.huolijuzhen.bill.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntityExample;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailEntityExample.Criteria;
import com.sudaotech.huolijuzhen.bill.dao.BillCostDetailMapper;
import com.sudaotech.sequence.SequenceType;
import com.sudaotech.util.BeanUtils;

public class BillCostDetailServiceImpl extends BaseServiceImpl implements BillCostDetailService {
	private static final String TRACKING_TYPE = "BillCostDetail";

    @Inject
    private BillCostDetailMapper billCostDetailEntityMapper;

	@Override
	public BillCostDetail getById(Long id) {
		BillCostDetailEntity entity = this.billCostDetailEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, BillCostDetail.class);
		}
		
		return null;
	}

	@Override
	public Long create(BillCostDetail obj) {
		logger.debug("Creating BillCostDetail: {}", obj);

		obj.setId(this.getSequenceService().nextLong(SequenceType.SEQUENCE_BILL));
		
		BillCostDetailEntity entity = BeanUtils.copyProperties(obj, BillCostDetailEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.billCostDetailEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created BillCostDetail: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(BillCostDetail obj) {
		logger.debug("Updating BillCostDetail: {}", obj);

		BillCostDetailEntity entity = BeanUtils.copyProperties(obj, BillCostDetailEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.billCostDetailEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCostDetail: {}", obj);
	}
	
	@Override
	public void updateObj(BillCostDetail obj) {
		logger.debug("Updating BillCostDetail: {}", obj);
		BillCostDetailEntityExample example = new BillCostDetailEntityExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andBillIdEqualTo(obj.getBillId());
		
		BillCostDetailEntity entity = BeanUtils.copyProperties(obj, BillCostDetailEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		
		if(obj.getVerifyMoney() != null){
		entity.setVerifyMoney(obj.getVerifyMoney() );
		}
		
		this.billCostDetailEntityMapper.updateByExampleSelective(entity,example);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated BillCostDetail: {}", obj);
	}

	@Override
	public Long save(BillCostDetail obj) {
		logger.debug("Saving BillCostDetail: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<BillCostDetail> find(Query query) {
		Page<BillCostDetail> page = new Page<BillCostDetail>(query);
		BillCostDetailEntityExample example = new BillCostDetailEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.billCostDetailEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<BillCostDetailEntity> list = this.billCostDetailEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, BillCostDetail.class));
		}
		
		return page;
	}

	@Override
	public List<BillCostDetail> findByObj(BillCostDetail bcd) {
		
		BillCostDetailEntityExample example = new BillCostDetailEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(bcd.getBillId() !=null){
			criteria.andBillIdEqualTo(bcd.getBillId());
		}
		example.setOrderByClause("id DESC");
		List<BillCostDetailEntity> list = this.billCostDetailEntityMapper.selectByExample(example);
		
		return	BeanUtils.copyListProperties(list, BillCostDetail.class);
		
		}

	@Override
	public BigDecimal getTotalApportion(Long billId) {
		// TODO Auto-generated method stub
		return this.billCostDetailEntityMapper.getTotalApportion(billId);
	}

}
