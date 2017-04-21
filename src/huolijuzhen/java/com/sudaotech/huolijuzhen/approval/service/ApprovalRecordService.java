package com.sudaotech.huolijuzhen.approval.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalRecordEntity;
import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;
import com.sudaotech.huolijuzhen.enums.ApprovalType;

public interface ApprovalRecordService extends BaseService {

    public ApprovalRecord getById(Long id);

    public Long create(ApprovalRecord obj);

    public void update(ApprovalRecord obj);

    public Long save(ApprovalRecord obj);

    public Page<ApprovalRecord> find(Query query);
    
    public static class Query extends Pagination {
    	
    	private ApprovalType approvalType;
    	
    	private Long targetId;

		public ApprovalType getApprovalType() {
			return approvalType;
		}

		public void setApprovalType(ApprovalType approvalType) {
			this.approvalType = approvalType;
		}

		public Long getTargetId() {
			return targetId;
		}

		public void setTargetId(Long targetId) {
			this.targetId = targetId;
		}
    	
    }
    
    public static class ApprovalRecord extends ApprovalRecordEntity {

    	private ApprovalProcessStatus approvalProcessStatus = ApprovalProcessStatus.APPROVALED;

		public ApprovalProcessStatus getApprovalProcessStatus() {
			return approvalProcessStatus;
		}

		public void setApprovalProcessStatus(ApprovalProcessStatus approvalProcessStatus) {
			this.approvalProcessStatus = approvalProcessStatus;
		}
    }
    
}
