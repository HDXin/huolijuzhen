package com.sudaotech.huolijuzhen.provider.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.provider.dao.ProviderEntity;

public interface ProviderService extends BaseService {

    public Provider getById(Long id);

    public Long create(Provider obj);

    public void update(Provider obj);

    public Long save(Provider obj);

    public Page<Provider> find(Query query);
    
    public static class Query extends Pagination {
    	private Long parkId;
    	private String providerName;
    	private String createSide;
    	private String enableStatus;
    	private Long proId;
    	private Long cityId;
    	private Long counId;
		public String getProviderName() {
			return providerName;
		}
		public void setProviderName(String providerName) {
			this.providerName = providerName;
		}
		public String getCreateSide() {
			return createSide;
		}
		public void setCreateSide(String createSide) {
			this.createSide = createSide;
		}
		public String getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(String enableStatus) {
			this.enableStatus = enableStatus;
		}
		public Long getProId() {
			return proId;
		}
		public void setProId(Long proId) {
			this.proId = proId;
		}
		public Long getCityId() {
			return cityId;
		}
		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}
		public Long getCounId() {
			return counId;
		}
		public void setCounId(Long counId) {
			this.counId = counId;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    }
    
    public static class Provider extends ProviderEntity {
    }
}
