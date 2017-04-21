package com.sudaotech.huolijuzhen.approval.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntity;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityExample;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityExample.Criteria;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntityMapper;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.util.BeanUtils;

public class ApprovalProcessServiceImpl extends BaseServiceImpl implements ApprovalProcessService {
	private static final String TRACKING_TYPE = "ApprovalProcess";

    @Inject
    private ApprovalProcessEntityMapper approvalProcessEntityMapper;

	@Override
	public ApprovalProcess getById(Long id) {
		ApprovalProcessEntity entity = this.approvalProcessEntityMapper.selectByPrimaryKey(id);
		if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
			return BeanUtils.copyProperties(entity, ApprovalProcess.class);
		}
		
		return null;
	}

	@Override
	public Long create(ApprovalProcess obj) {
		logger.debug("Creating ApprovalProcess: {}", obj);

		obj.setId(this.getSequenceService().nextLong());
		
		ApprovalProcessEntity entity = BeanUtils.copyProperties(obj, ApprovalProcessEntity.class);
		entity.setStatus(Status.NORMAL);
		entity.setCreateBy(obj.getOperator());
		entity.setCreateTime(new Date());
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());

		this.approvalProcessEntityMapper.insertSelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);
		
		logger.info("Created ApprovalProcess: {}", obj);

		return obj.getId();
	}

	@Override
	public void update(ApprovalProcess obj) {
		logger.debug("Updating ApprovalProcess: {}", obj);

		ApprovalProcessEntity entity = BeanUtils.copyProperties(obj, ApprovalProcessEntity.class);
		entity.setUpdateBy(obj.getOperator());
		entity.setUpdateTime(new Date());
		this.approvalProcessEntityMapper.updateByPrimaryKeySelective(entity);

		this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

		logger.info("Updated ApprovalProcess: {}", obj);
	}

	@Override
	public Long save(ApprovalProcess obj) {
		logger.debug("Saving ApprovalProcess: {}", obj);

		if (obj.getId() == null) {
			this.create(obj);
		} else {
			this.update(obj);
		}

		return obj.getId();
	}

	@Override
	public Page<ApprovalProcess> find(Query query) {
		Page<ApprovalProcess> page = new Page<ApprovalProcess>(query);
		ApprovalProcessEntityExample example = new ApprovalProcessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		example.setOrderByClause("id DESC");
		page.setTotal(this.approvalProcessEntityMapper.countByExample(example));
		if (page.getTotal() > query.getOffset()) {
			List<ApprovalProcessEntity> list = this.approvalProcessEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
			page.setItems(BeanUtils.copyListProperties(list, ApprovalProcess.class));
		}
		
		return page;
	}

	@Override
	public List<ApprovalProcess> findByObjQuery(
			ApprovalProcessQuery approvalProcessQuery) {

		ApprovalProcessEntityExample example = new ApprovalProcessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		if(approvalProcessQuery.getApprovalTypeId() != null){
			criteria.andApprovalTypeIdEqualTo(approvalProcessQuery.getApprovalTypeId());
		}
		
		if(approvalProcessQuery.getApprovalTypeVersion() != null){
			criteria.andApprovalTypeVersionEqualTo(approvalProcessQuery.getApprovalTypeVersion());
		}

		//待处理，处理中
		if(approvalProcessQuery.getApprovalProcessStatus() != null){
			criteria.andApprovalProcessStatusNotEqualTo(approvalProcessQuery.getApprovalProcessStatus());
		}
		
		example.setOrderByClause("approvalItemNo ASC,id ASC");
		return BeanUtils.copyListProperties(this.approvalProcessEntityMapper.selectByExample(example), ApprovalProcess.class);
	}

	@Override
	public int updateByApprovalTypeIdAndVersion(Long id, Integer latestVersion) {
		ApprovalProcessEntityExample example = new ApprovalProcessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		if(id != null){
			criteria.andApprovalTypeIdEqualTo(id);
		}
		
		if(latestVersion != null){
			criteria.andApprovalTypeVersionEqualTo(latestVersion);
		}
		example.setOrderByClause("id DESC");

		ApprovalProcess record = new ApprovalProcess();
		record.setIsHistory(true);
		
		return this.approvalProcessEntityMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int cancleByObjQuery(ApprovalProcessQuery approvalProcessQuery) {
		ApprovalProcessEntityExample example = new ApprovalProcessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);

		if(approvalProcessQuery.getApprovalTypeId() != null){
			criteria.andApprovalTypeIdEqualTo(approvalProcessQuery.getApprovalTypeId());
		}
		
		if(approvalProcessQuery.getApprovalTypeVersion() != null){
			criteria.andApprovalTypeVersionEqualTo(approvalProcessQuery.getApprovalTypeVersion());
		}

		if(approvalProcessQuery.getApprovalType() != null){
			criteria.andApprovalTypeEqualTo(approvalProcessQuery.getApprovalType());
		}
		
		if(approvalProcessQuery.getMainId() != null){
			criteria.andMainIdEqualTo(approvalProcessQuery.getMainId());
		}
		
		example.setOrderByClause("id DESC");

		ApprovalProcess record = new ApprovalProcess();
		record.setStatus(Status.DELETED);
		
		return this.approvalProcessEntityMapper.updateByExampleSelective(record, example);
	}

	@Override
	public ApprovalProcess findNextNodeByObj(ApprovalProcess approvalProcess) {
		ApprovalProcessEntityExample example = new ApprovalProcessEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(Status.NORMAL);
		criteria.andIsHistoryEqualTo(false);
		criteria.andApprovalProcessStatusEqualTo(ApprovalProcessStatus.WAITAPPROVAL);

		if(approvalProcess.getApprovalType() != null){
			criteria.andApprovalTypeEqualTo(approvalProcess.getApprovalType());
		}
		if(approvalProcess.getMainId() != null){
			criteria.andMainIdEqualTo(approvalProcess.getMainId());
		}
		
		example.setOrderByClause("approvalItemNo ASC,id ASC");

		List<ApprovalProcess> approvalProcessesList = BeanUtils.copyListProperties(this.approvalProcessEntityMapper.selectByExample(example), ApprovalProcess.class);

		return CollectionUtils.isEmpty(approvalProcessesList) ? null:approvalProcessesList.get(0);
	}

}
