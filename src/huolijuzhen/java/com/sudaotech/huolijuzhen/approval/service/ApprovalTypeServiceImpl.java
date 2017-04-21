package com.sudaotech.huolijuzhen.approval.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BusinessBaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntityExample;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntityExample.Criteria;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntityMapper;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItem;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItemQuery;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType;
import com.sudaotech.util.BeanUtils;

public class ApprovalTypeServiceImpl extends BusinessBaseServiceImpl<ApprovalType> implements ApprovalTypeService {
	private static final String TRACKING_TYPE = "ApprovalType";

    @Inject
    private ApprovalTypeEntityMapper approvalTypeEntityMapper;

	@Override
	public ApprovalType getById(Long id) {
		ApprovalTypeEntity entity = this.approvalTypeEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return packItem(BeanUtils.copyProperties(entity, ApprovalType.class));
		}
		return null;
	}

	@Override
	public Long create(ApprovalType obj) {
		logger.debug("Creating ApprovalType: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApprovalTypeEntity entity = BeanUtils.copyProperties(obj, ApprovalTypeEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.approvalTypeEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApprovalType: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApprovalType obj) {
		logger.debug("Updating ApprovalType: {}", obj);

		ApprovalTypeEntity entity = BeanUtils.copyProperties(obj, ApprovalTypeEntity.class);
		entity.setUpdateBy(obj.getOperator());
		
		entity.setUpdateTime(new Date());
		this.approvalTypeEntityMapper.updateByPrimaryKeySelective(entity);
		
		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApprovalType: {}", obj);
	}

	@Override
	public Long save(ApprovalType obj) {
		logger.debug("Saving ApprovalType: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApprovalType> find(Query query) {
		Page<ApprovalType> page = new Page<ApprovalType>(query);
		ApprovalTypeEntityExample example = new ApprovalTypeEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(query.getParkId() != null){
			criteria.andParkIdEqualTo(query.getParkId());
		}
		
		example.setOrderByClause("id DESC");
		page.setTotal(this.approvalTypeEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApprovalTypeEntity> list = this.approvalTypeEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApprovalType.class));
		}
		
		return page;
	}

	@Override
	public List<ApprovalType> findByObjQuery(ApprovalTypeQuery approvalTypeQuery) {
		ApprovalTypeEntityExample example = new ApprovalTypeEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(approvalTypeQuery.getParkId() != null){
			criteria.andParkIdEqualTo(approvalTypeQuery.getParkId());
		}
		
		example.setOrderByClause("id DESC");

		return BeanUtils.copyListProperties(this.approvalTypeEntityMapper.selectByExample(example), ApprovalType.class);
	}

	@Override
	protected ApprovalType packItem(ApprovalType item) {

		if(item == null){
			return null;
		}
		
		ApprovalTypeItemQuery approvalTypeItemQuery = new ApprovalTypeItemQuery();
		approvalTypeItemQuery.setApprovalTypeId(item.getId());
		approvalTypeItemQuery.setCurrentVersion(item.getLatestVersion());
		List<ApprovalTypeItem> approvalTypeItems = approvalTypeItemService.findByObjQuery(approvalTypeItemQuery);
		item.setApprovalTypeItems(approvalTypeItems);
		
		return item;
	}

	@Override
	public ApprovalType findValidItem(Long parkId,
			com.sudaotech.huolijuzhen.enums.ApprovalType approvalType) {
		ApprovalTypeEntityExample example = new ApprovalTypeEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		
		if(parkId != null){
			criteria.andParkIdEqualTo(parkId);
		}
		
		if(approvalType != null){
			criteria.andApprovalTypeEqualTo(approvalType);
		}
		example.setOrderByClause("id DESC");
		List<ApprovalType> approvalTypes = BeanUtils.copyListProperties(this.approvalTypeEntityMapper.selectByExample(example), ApprovalType.class);
		return CollectionUtils.isEmpty(approvalTypes) ? null:approvalTypes.get(0);
	}
}
