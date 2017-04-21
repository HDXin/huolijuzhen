package com.sudaotech.huolijuzhen.basic.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.dao.ServiceTypeEntity;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

public interface ServiceTypeService extends BaseService {

    public ServiceType getById(Long id);

    public Long create(ServiceType obj);

    public void update(ServiceType obj);

    public Long save(ServiceType obj);

    public Page<ServiceType> find(Query query);
    
    public List<ServiceType> findAll(String type);
    
    public List<ServiceType> findValid(String type);
    
	public Page<ServiceType> findByCondition(Query query);
	
    public static class Query extends Pagination {
    	//类型名称
    	private String name;
    	//适用级别
    	private String serverGrade;
    	//是否被推荐
    	private Boolean isReco;
    	//启用状态
    	private EnableStatus enableStatus;
    	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getServerGrade() {
			return serverGrade;
		}
		public void setServerGrade(String serverGrade) {
			this.serverGrade = serverGrade;
		}
		public Boolean getIsReco() {
			return isReco;
		}
		public void setIsReco(Boolean isReco) {
			this.isReco = isReco;
		}
		public EnableStatus getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(EnableStatus enableStatus) {
			this.enableStatus = enableStatus;
		}
    }
    
    public static class RecommendParams{
    	private Long recoId;
    	private Long targetId;
    	private String recoLogo;
		public Long getRecoId() {
			return recoId;
		}
		public void setRecoId(Long recoId) {
			this.recoId = recoId;
		}
		public Long getTargetId() {
			return targetId;
		}
		public void setTargetId(Long targetId) {
			this.targetId = targetId;
		}
		public String getRecoLogo() {
			return recoLogo;
		}
		public void setRecoLogo(String recoLogo) {
			this.recoLogo = recoLogo;
		}
    }
    
    public static class ServiceType extends ServiceTypeEntity {
    }

	
}
