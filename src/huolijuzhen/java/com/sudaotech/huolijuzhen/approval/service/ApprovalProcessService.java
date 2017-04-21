package com.sudaotech.huolijuzhen.approval.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.approval.dao.ApprovalProcessEntity;

public interface ApprovalProcessService extends BaseService {

    public ApprovalProcess getById(Long id);

    public Long create(ApprovalProcess obj);

    public void update(ApprovalProcess obj);

	public int updateByApprovalTypeIdAndVersion(Long id, Integer latestVersion);

	public int cancleByObjQuery(ApprovalProcessQuery approvalProcessQuery);

	public ApprovalProcess findNextNodeByObj(ApprovalProcess approvalProcess);

    public Long save(ApprovalProcess obj);

    public Page<ApprovalProcess> find(Query query);

    public List<ApprovalProcess> findByObjQuery(ApprovalProcessQuery approvalProcessQuery);
    
    public static class Query extends Pagination {
    }
    
    public static class ApprovalProcess extends ApprovalProcessEntity {
    }
    
    public static class ApprovalProcessQuery extends ApprovalProcess {
    }


}
