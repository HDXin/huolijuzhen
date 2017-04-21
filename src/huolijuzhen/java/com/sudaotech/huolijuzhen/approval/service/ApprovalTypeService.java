package com.sudaotech.huolijuzhen.approval.service;

import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeEntity;
import com.sudaotech.huolijuzhen.approval.service.ApprovalTypeItemService.ApprovalTypeItem;

public interface ApprovalTypeService extends BaseService {

    public ApprovalType getById(Long id);

    public Long create(ApprovalType obj);

    public void update(ApprovalType obj);

    public Long save(ApprovalType obj);

    public Page<ApprovalType> find(Query query);

    public List<ApprovalType> findByObjQuery(ApprovalTypeQuery approvalTypeQuery);

	public com.sudaotech.huolijuzhen.approval.service.ApprovalTypeService.ApprovalType findValidItem(
			Long platformId, com.sudaotech.huolijuzhen.enums.ApprovalType contractapproval);
    
    public static class Query extends Pagination {
    	
    	private Long parkId;

		public Long getParkId() {
			return parkId;
		}

		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    	
    }
    
    public static class ApprovalType extends ApprovalTypeEntity {
    	
    	private List<ApprovalTypeItem> approvalTypeItems = new ArrayList<ApprovalTypeItemService.ApprovalTypeItem>();

		public List<ApprovalTypeItem> getApprovalTypeItems() {
			return approvalTypeItems;
		}

		public void setApprovalTypeItems(List<ApprovalTypeItem> approvalTypeItems) {
			this.approvalTypeItems = approvalTypeItems;
		}

    }
    
    public static class ApprovalTypeQuery extends ApprovalType {
    }

}
