package com.sudaotech.huolijuzhen.equipment.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPreserveEntity;
import com.sudaotech.huolijuzhen.equipment.service.EquipmentPlanService.EquipmentPlan;

public interface EquipmentPreserveService extends BaseService {

    public EquipmentPreserve getById(Long id);

    public Long create(EquipmentPreserve obj);

    public void update(EquipmentPreserve obj);

    public Long save(EquipmentPreserve obj);

    public Page<EquipmentPreserve> find(Query query);
    
	public List<EquipmentPreserve> findByObj(EquipmentPreserve equipmentPreserve);
    
    public int findCountByEquTypeId(Long parkId,Long equTypeId);
    
    public static class Query extends Pagination {
    	private Long parkId;
    	private String name;
    	private String code;
    	private Long equTypeId;
    	private String enableStatus;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Long getEquTypeId() {
			return equTypeId;
		}
		public void setEquTypeId(Long equTypeId) {
			this.equTypeId = equTypeId;
		}
		public String getEnableStatus() {
			return enableStatus;
		}
		public void setEnableStatus(String enableStatus) {
			this.enableStatus = enableStatus;
		}
		public Long getParkId() {
			return parkId;
		}
		public void setParkId(Long parkId) {
			this.parkId = parkId;
		}
    }
    
    public static class ByParkIdQuery extends Query{
    	
    }
    
    public static class EquipmentPreserve extends EquipmentPreserveEntity {
    	
    	private List<EquipmentPlan> equipmentPlanList;

		public List<EquipmentPlan> getEquipmentPlanList() {
			return equipmentPlanList;
		}

		public void setEquipmentPlanList(List<EquipmentPlan> equipmentPlanList) {
			this.equipmentPlanList = equipmentPlanList;
		}
    	
    }

}
