package com.sudaotech.huolijuzhen.approval.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntityExample;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntityExample.Criteria;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ApprovalTypeItemServiceImpl extends BaseServiceImpl implements ApprovalTypeItemService {
	private static final String TRACKING_TYPE = "ApprovalTypeItem";

    @Inject
    private ApprovalTypeItemEntityMapper approvalTypeItemEntityMapper;

	@Override
	public ApprovalTypeItem getById(Long id) {
		ApprovalTypeItemEntity entity = this.approvalTypeItemEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApprovalTypeItem.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApprovalTypeItem obj) {
		logger.debug("Creating ApprovalTypeItem: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApprovalTypeItemEntity entity = BeanUtils.copyProperties(obj, ApprovalTypeItemEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.approvalTypeItemEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApprovalTypeItem: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApprovalTypeItem obj) {
		logger.debug("Updating ApprovalTypeItem: {}", obj);

		ApprovalTypeItemEntity entity = BeanUtils.copyProperties(obj, ApprovalTypeItemEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.approvalTypeItemEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApprovalTypeItem: {}", obj);
	}
	
	@Override
	public int updateByApprovalTypeIdandVersion(Long id, Integer latestVersion) {

		ApprovalTypeItemEntityExample example = new ApprovalTypeItemEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		if(id != null){
			criteria.andApprovalTypeIdEqualTo(id);
		}
		
		if(latestVersion != null){
			criteria.andCurrentVersionEqualTo(latestVersion);
		}
		
		ApprovalTypeItem record = new ApprovalTypeItem();
		record.setIsHistory(true);
		
		return this.approvalTypeItemEntityMapper.updateByExampleSelective(record, example);
	}


	@Override
	public Long save(ApprovalTypeItem obj) {
		logger.debug("Saving ApprovalTypeItem: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApprovalTypeItem> find(Query query) {
		Page<ApprovalTypeItem> page = new Page<ApprovalTypeItem>(query);
		ApprovalTypeItemEntityExample example = new ApprovalTypeItemEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.approvalTypeItemEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApprovalTypeItemEntity> list = this.approvalTypeItemEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApprovalTypeItem.class));
		}
		
		return page;
	}

	@Override
	public List<ApprovalTypeItem> findByObjQuery(
			ApprovalTypeItemQuery approvalTypeItemQuery) {
		ApprovalTypeItemEntityExample example = new ApprovalTypeItemEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		if(approvalTypeItemQuery.getApprovalTypeId() != null){
			criteria.andApprovalTypeIdEqualTo(approvalTypeItemQuery.getApprovalTypeId());
		}
		
		if(approvalTypeItemQuery.getCurrentVersion() != null){
			criteria.andCurrentVersionEqualTo(approvalTypeItemQuery.getCurrentVersion());
		}
		
		example.setOrderByClause("approvalNo ASC,id ASC");

		return BeanUtils.copyListProperties(this.approvalTypeItemEntityMapper.selectByExample(example), ApprovalTypeItem.class);
	}

}
