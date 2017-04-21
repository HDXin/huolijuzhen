package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.ArrayList;
import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.ContractResourceEntity;

public interface ContractResourceService extends BaseService {

    public ContractResource getById(Long id);

    public Long create(ContractResource obj);

    public void update(ContractResource obj);

    public Long save(ContractResource obj);

    public Page<ContractResource> find(Query query);
    
    public Page<ContractResource> platformFind(PlatformQuery query);
    
    public Page<ContractResource> parkFind(ParkQuery query);
    
    public static class Query extends Pagination {
    }
    
    public List<ContractResource> findByObj(ContractResource contractResource);
    
    public List<ContractResource> findAllUseReslurce(ContractResource contractResource);

    public List<ContractResource> findInvalid(Long contracId,List<Long> resourceIds);
    
    public static class PlatformQuery extends Pagination{
    	
    	//合同 ID
    	private Long constractId;
    	//资源 ID
    	private Long resourceId;
		public Long getConstractId() {
			return constractId;
		}
		public void setConstractId(Long constractId) {
			this.constractId = constractId;
		}
		public Long getResourceId() {
			return resourceId;
		}
		public void setResourceId(Long resourceId) {
			this.resourceId = resourceId;
		}
    	
    }
    
    public static class ParkQuery extends Pagination{

    	//合同 ID
    	private Long constractId;
    	//资源 ID
    	private Long resourceId;
		public Long getConstractId() {
			return constractId;
		}
		public void setConstractId(Long constractId) {
			this.constractId = constractId;
		}
		public Long getResourceId() {
			return resourceId;
		}
		public void setResourceId(Long resourceId) {
			this.resourceId = resourceId;
		}
    	
    }
    
    public static class ContractResource extends ContractResourceEntity {
    	
    	private List<Long> notInResourceIds = new ArrayList<Long>();

		public List<Long> getNotInResourceIds() {
			return notInResourceIds;
		}

		public void setNotInResourceIds(List<Long> notInResourceIds) {
			this.notInResourceIds = notInResourceIds;
		}
    }
}
