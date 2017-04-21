package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCorrContractEntity;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;
import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService.ResourceInfo;

public interface EnterpriseCorrContractService extends BaseService {

    public EnterpriseCorrContract getById(Long id);

    public Long create(EnterpriseCorrContract obj);

    public void update(EnterpriseCorrContract obj);

    public Long save(EnterpriseCorrContract obj);

    public Page<EnterpriseCorrContract> find(Query query);
    
    public List<EnterpriseCorrContract> findByObj(EnterpriseCorrContract obj);
    
    
    public static class Query extends Pagination {
    	
    	private Long cottId;

		public Long getCottId() {
			return cottId;
		}

		public void setCottId(Long cottId) {
			this.cottId = cottId;
		}
    	
    }
    
    public static class EnterpriseCorrContract extends EnterpriseCorrContractEntity {
    	
    	private ContractInfo  ci;
    	
    	//企业IDs
    	private List<Long> enterpriseCottIds = new ArrayList<Long>();
    	
    	//资源
        private List<ResourceInfo> resourceInfos = new ArrayList<ResourceInfo>();

		public ContractInfo getCi() {
			return ci;
		}

		public void setCi(ContractInfo ci) {
			this.ci = ci;
		}

		public List<ResourceInfo> getResourceInfos() {
			return resourceInfos;
		}

		public void setResourceInfos(List<ResourceInfo> resourceInfos) {
			this.resourceInfos = resourceInfos;
		}

		public List<Long> getEnterpriseCottIds() {
			return enterpriseCottIds;
		}

		public void setEnterpriseCottIds(List<Long> enterpriseCottIds) {
			this.enterpriseCottIds = enterpriseCottIds;
		}
    }
}
