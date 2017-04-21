package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractInfoEntity;
import com.sudaotech.huolijuzhen.enterprise.service.ContractDossierService.ContractDossier;
import com.sudaotech.huolijuzhen.enums.ContractStatus;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.ResourceInfo;

public interface ContractInfoService extends BaseService {

    public ContractInfo getById(Long id);

    public Long create(ContractInfo obj);

    public void update(ContractInfo obj);

    public Long save(ContractInfo obj);

    public Page<ContractInfo> find(Query query);
    
    public Page<Map<String, Object>> findByBillMonthAndEnterpriseIdAndContractId(ContractInfoQuery contractInfoQuery);
    
    public List<ContractInfo> findByObj(ContractInfo ci);
    
    public static class Query extends Pagination {
    	private ContractStatus contractStatus;
    	private List<Long> contractInfoIds = new ArrayList<Long>();
    	
		public ContractStatus getContractStatus() {
			return contractStatus;
		}

		public void setContractStatus(ContractStatus contractStatus) {
			this.contractStatus = contractStatus;
		}

		public List<Long> getContractInfoIds() {
			return contractInfoIds;
		}

		public void setContractInfoIds(List<Long> contractInfoIds) {
			this.contractInfoIds = contractInfoIds;
		}
    }
    
    public static class ContractInfoQuery extends Pagination{
    	//账单日期
    	private String billMonth;
    	//企业ID
    	private Long companyId;
    	//合同ID
    	private Long contractId;
    	//园区ID
    	private Long parkId;
		public String getBillMonth() {
			return billMonth;
		}
		public void setBillMonth(String billMonth) {
			this.billMonth = billMonth;
		}
		public Long getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Long companyId) {
			this.companyId = companyId;
		}
		public Long getContractId() {
			return contractId;
		}
		public void setContractId(Long contractId) {
			this.contractId = contractId;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}    	
    }
    
    public static class ContractInfo extends ContractInfoEntity {
    	
    	//账单
    	private List<BillCostCalRules> bccrs ;
    	
    	//档案信息
        private List<ContractDossier>  contractDossiers;

        //ids
        private List<Long> ids;
        
        //审批流是否被启用
        private boolean approvalEnabelStatus;
        
        //审批是否通过
        private boolean passStatus;
        //审批备注
        private String approvalMemo;
        
        //企业ID
        private Long enterpriseId;
        
        //资源
        private List<ResourceInfo> resourceInfos = new ArrayList<ResourceInfo>();
        
        //资源是否可用
        private Map<Long, Boolean> ResourceInfoIsValidMap = new HashMap<Long, Boolean>();
        //合同资源关联表的 ID
        private Map<Long, Long> contractResourceIdMap = new HashMap<Long, Long>();
        
		public Map<Long, Boolean> getResourceInfoIsValidMap() {
			return ResourceInfoIsValidMap;
		}

		public void setResourceInfoIsValidMap(Map<Long, Boolean> resourceInfoIsValidMap) {
			ResourceInfoIsValidMap = resourceInfoIsValidMap;
		}

		public Map<Long, Long> getContractResourceIdMap() {
			return contractResourceIdMap;
		}

		public void setContractResourceIdMap(Map<Long, Long> contractResourceIdMap) {
			this.contractResourceIdMap = contractResourceIdMap;
		}

		public List<Long> getIds() {
			return ids;
		}

		public void setIds(List<Long> ids) {
			this.ids = ids;
		}

		public List<ContractDossier> getContractDossiers() {
			return contractDossiers;
		}

		public void setContractDossiers(List<ContractDossier> contractDossiers) {
			this.contractDossiers = contractDossiers;
		}

		public List<BillCostCalRules> getBccrs() {
			return bccrs;
		}

		public void setBccrs(List<BillCostCalRules> bccrs) {
			this.bccrs = bccrs;
		}

		public List<ResourceInfo> getResourceInfos() {
			return resourceInfos;
		}

		public void setResourceInfos(List<ResourceInfo> resourceInfos) {
			this.resourceInfos = resourceInfos;
		}

		public Long getEnterpriseId() {
			return enterpriseId;
		}

		public void setEnterpriseId(Long enterpriseId) {
			this.enterpriseId = enterpriseId;
		}

		public boolean isApprovalEnabelStatus() {
			return approvalEnabelStatus;
		}

		public void setApprovalEnabelStatus(boolean approvalEnabelStatus) {
			this.approvalEnabelStatus = approvalEnabelStatus;
		}

		public String getApprovalMemo() {
			return approvalMemo;
		}

		public void setApprovalMemo(String approvalMemo) {
			this.approvalMemo = approvalMemo;
		}

		public boolean isPassStatus() {
			return passStatus;
		}

		public void setPassStatus(boolean passStatus) {
			this.passStatus = passStatus;
		}
		
    }
    
    public static class Items{
    	private Long id;
    	private String contractStatusStr;
		public String getContractStatusStr() {
			return contractStatusStr;
		}
		public void setContractStatusStr(String contractStatusStr) {
			this.contractStatusStr = contractStatusStr;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
    }
    
}
