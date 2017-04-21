package com.sudaotech.huolijuzhen.enter.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enter.dao.EnterInfoEntity;
import com.sudaotech.huolijuzhen.enums.EntryType;

public interface EnterInfoService extends BaseService {

    public EnterInfo getById(Long id);

    public Long create(EnterInfo obj);

    public void update(EnterInfo obj);

    public Long save(EnterInfo obj);

    public Page<EnterInfo> find(Query query, EntryType type);
    
    public static class Query extends Pagination {
    	private Long id;
    	private String treatmentStatus;
    	private String updateDescribe;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTreatmentStatus() {
			return treatmentStatus;
		}
		public void setTreatmentStatus(String treatmentStatus) {
			this.treatmentStatus = treatmentStatus;
		}
		public String getUpdateDescribe() {
			return updateDescribe;
		}
		public void setUpdateDescribe(String updateDescribe) {
			this.updateDescribe = updateDescribe;
		}
    }
    
    public static class EnterInfo extends EnterInfoEntity {
    }
}
