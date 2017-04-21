package com.sudaotech.huolijuzhen.basic.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.dao.ServiceScenarioEntity;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

public interface ServiceScenarioService extends BaseService {

    public ServiceScenario getById(Long id);

    public Long create(ServiceScenario obj);

    public void update(ServiceScenario obj);

    public Long save(ServiceScenario obj);

    public Page<ServiceScenario> find(Query query);
    
    public List<ServiceScenario> findAll(String type);
    
    public List<ServiceScenario> findValid(String type);
    
    public Page<ServiceScenario> findByCondition(Query query);
    public static class Query extends Pagination {
    	
    	//场景名称
    	private String name;
    	//场景适用级别
    	private String serverGrade;
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
		public EnableStatus getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(EnableStatus enableStatus) {
			this.enableStatus = enableStatus;
		}
    }
    
    public static class ServiceScenario extends ServiceScenarioEntity {
    }
}
