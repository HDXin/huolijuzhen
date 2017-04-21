package com.sudaotech.huolijuzhen.enterprise.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseUserCottEntity;

public interface EnterpriseUserCottService extends BaseService {

    public EnterpriseUserCott getById(Long id);

    public Long create(EnterpriseUserCott obj);

    public void update(EnterpriseUserCott obj);

    public Long save(EnterpriseUserCott obj);

    public Page<EnterpriseUserCott> find(Query query);
    
    public List<EnterpriseUserCott> findByObj(EnterpriseUserCott euc);
    
    public static class Query extends Pagination {
    	private Long enterpriseUserId;
    	private Long parkId;
    	private Long cottId;
		public Long getEnterpriseUserId() {
			return enterpriseUserId;
		}
		public void setEnterpriseUserId(Long enterpriseUserId) {
			this.enterpriseUserId = enterpriseUserId;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
		public Long getCottId() {
			return cottId;
		}
		public void setCottId(Long cottId) {
			this.cottId = cottId;
		}
		@Override
		public String toString() {
			return "Query [enterpriseUserId=" + enterpriseUserId + ", parkId="
					+ parkId + ", cottId=" + cottId + "]";
		}
    }
    
    public static class EnterpriseUserCott extends EnterpriseUserCottEntity {
    }
}
