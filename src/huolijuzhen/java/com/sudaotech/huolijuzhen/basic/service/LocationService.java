package com.sudaotech.huolijuzhen.basic.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.basic.dao.LocationEntity;

public interface LocationService extends BaseService {

    public Location getById(Long id);

    public Long create(Location obj);

    public void update(Location obj);

    public Long save(Location obj);

    public Page<Location> find(Query query);
    
    public Page<Location> findByCondition(Query query);
    
    public List<Long> findAllProvince();

	public List<Long> findCityByProvinceId(Long proId);

	public List<Long> findCountoryBycityId(Long cityId);
	
	public List<Long> isExist(Location location);
	
	public List<Map<String, Object>> findBusinessByCounId(Long counId);
    
    public static class Query extends Pagination {
    	
    	private Long proId;
    	private Long cityId;
    	private Long counId;
    	private String enableStatus;
		private Long locationId;

		public Long getLocationId() {
			return locationId;
		}

		public void setLocationId(Long locationId) {
			this.locationId = locationId;
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
		public String getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(String enableStatus) {
			this.enableStatus = enableStatus;
		}
    	
    }
    
    public static class Location extends LocationEntity {
    }

    
	
	

}
