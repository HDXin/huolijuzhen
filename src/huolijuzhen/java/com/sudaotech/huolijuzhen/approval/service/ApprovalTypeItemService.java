package com.sudaotech.huolijuzhen.approval.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalTypeItemEntity;

public interface ApprovalTypeItemService extends BaseService {

    public ApprovalTypeItem getById(Long id);

    public Long create(ApprovalTypeItem obj);

    public void update(ApprovalTypeItem obj);

    public int updateByApprovalTypeIdandVersion(Long id, Integer latestVersion);
    
    public Long save(ApprovalTypeItem obj);

    public Page<ApprovalTypeItem> find(Query query);

	public List<ApprovalTypeItem> findByObjQuery(ApprovalTypeItemQuery approvalTypeItemQuery);
    
    public static class Query extends Pagination {
    }
    
    public static class ApprovalTypeItem extends ApprovalTypeItemEntity {
    	
    	public static final Integer STATIC_APPROVAL_NO = 100;
    	
    }
    
    public static class ApprovalTypeItemQuery extends ApprovalTypeItem {
    }

}
