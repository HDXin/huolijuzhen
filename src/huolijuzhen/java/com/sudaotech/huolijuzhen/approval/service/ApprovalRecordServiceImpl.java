package com.sudaotech.huolijuzhen.approval.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityExample.Criteria;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntityMapper;
import com.sudaotech.util.BeanUtils;

public class ApprovalRecordServiceImpl extends BaseServiceImpl implements ApprovalRecordService {
	private static final String TRACKING_TYPE = "ApprovalRecord";

    @Inject
    private ApprovalRecordEntityMapper approvalRecordEntityMapper;
    
	@Override
	public ApprovalRecord getById(Long id) {
		ApprovalRecordEntity entity = this.approvalRecordEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApprovalRecord.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApprovalRecord obj) {
		logger.debug("Creating ApprovalRecord: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApprovalRecordEntity entity = BeanUtils.copyProperties(obj, ApprovalRecordEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.approvalRecordEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApprovalRecord: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApprovalRecord obj) {
		logger.debug("Updating ApprovalRecord: {}", obj);

		ApprovalRecordEntity entity = BeanUtils.copyProperties(obj, ApprovalRecordEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.approvalRecordEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApprovalRecord: {}", obj);
	}

	@Override
	public Long save(ApprovalRecord obj) {
		logger.debug("Saving ApprovalRecord: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApprovalRecord> find(Query query) {
		Page<ApprovalRecord> page = new Page<ApprovalRecord>(query);
		ApprovalRecordEntityExample example = new ApprovalRecordEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(query.getApprovalType() != null){
			criteria.andApprovalTypeEqualTo(query.getApprovalType());
		}
		
		if(query.getTargetId() != null){
			criteria.andMainIdEqualTo(query.getTargetId());
		}
		
		example.setOrderByClause("createTime ASC");
		page.setTotal(this.approvalRecordEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApprovalRecordEntity> list = this.approvalRecordEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApprovalRecord.class));
		}
		
 		return page;
	}
}
