package com.sudaotech.huolijuzhen.policy.service;

import java.text.ParseException;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.policy.dao.PolicyEntity;

public interface PolicyService extends BaseService {

    public Policy getById(Long id);

    public Long create(Policy obj);

    public void update(Policy obj);

    public Long save(Policy obj);
    
    public Page<Policy> findAllPlatform(AdminEnterpriseQuery query);
    
    public Page<Policy> findAllByParkId(AdminEnterpriseQuery query);

    public Page<Policy> find(Query query);
    
    public Page<Policy> findByCondition(Query query) throws ParseException;
    
    /**
     * 政策统计
     * @param query
     * @return
     */
	public Page<Policy> statistics(Query query);

    
    public static class Query extends Pagination {
    	
    	private String startDate;
    	private String endDate;
    	//政策标题
    	private String title;
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
    }
    
    public static class AdminEnterpriseQuery extends Pagination{
    	
    	private Long proId;
    	private Long cityId;
    	private Long counId;
    	private Long locationId;
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
		public Long getLocationId() {
			return locationId;
		}
		public void setLocationId(Long locationId) {
			this.locationId = locationId;
		}
    	
    }
    public static class Policy extends PolicyEntity {
    }
}
