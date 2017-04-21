package com.sudaotech.huolijuzhen.park.service;

import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.dao.ParkInfoEntity;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

public interface ParkInfoService extends BaseService {

    public ParkInfo getById(Long id);

    public ParkInfo getByPositionId(Long id);

    public Long create(ParkInfo obj);

    public void update(ParkInfo obj);

    public Long save(ParkInfo obj);

    public Page<ParkInfo> find(Query query);
    
    public Integer statisticsPark(Map<String, Object> params);

	/**
	 * 根据行政位置查询所有的园区
	 * @param locationIds
	 * @return
	 */
	public List<Long> findAllParkIds(Map<String, Object> locationIds);

	/**
	 * 根据 parkIds 获取园区列表
	 * @param parkIds
	 * @return
	 */
	public List<ParkInfo> findParkInfosByParkIds(List<Long> parkIds);
    
    public static class Query extends Pagination {
    	
        private Long provinceId ;
        private Long cityId;
        private Long regionId;
        private Long positionId;
        private String name;
        private Integer startStatus;
        private Long counId,locationId;
        private String parkname;
        private EnableStatus enableStatus;

		public EnableStatus getEnableStatus() {
			return enableStatus;
		}

		public void setEnableStatus(EnableStatus enableStatus) {
			this.enableStatus = enableStatus;
		}

		public String getParkname() {
			return parkname;
		}

		public void setParkname(String parkname) {
			this.parkname = parkname;
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

		public Long getProvinceId() {
			return provinceId;
		}
		public void setProvinceId(Long provinceId) {
			this.provinceId = provinceId;
		}
		public Long getCityId() {
			return cityId;
		}
		public void setCityId(Long cityId) {
			this.cityId = cityId;
		}
		public Long getRegionId() {
			return regionId;
		}
		public void setRegionId(Long regionId) {
			this.regionId = regionId;
		}
		public Long getPositionId() {
			return positionId;
		}
		public void setPositionId(Long positionId) {
			this.positionId = positionId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getStartStatus() {
			return startStatus;
		}
		public void setStartStatus(Integer startStatus) {
			this.startStatus = startStatus;
		}
        
    	
    }

    public static class ParkInfo extends ParkInfoEntity {
        private String position;
        private String pro,city,region,location,parkLogo;

		public String getPro() {
			return pro;
		}

		public void setPro(String pro) {
			this.pro = pro;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

		public String getParkLogo() {
			return parkLogo;
		}

		public void setParkLogo(String parkLogo) {
			this.parkLogo = parkLogo;
		}
    }


}
