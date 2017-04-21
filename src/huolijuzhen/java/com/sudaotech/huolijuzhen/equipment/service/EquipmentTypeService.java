package com.sudaotech.huolijuzhen.equipment.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentTypeEntity;

public interface EquipmentTypeService extends BaseService {

    public EquipmentType getById(Long id);

    public Long create(EquipmentType obj);

    public void update(EquipmentType obj);

    public Long save(EquipmentType obj);

    public Page<EquipmentType> find(Query query);
    
    public List<EquipmentType> findAll(Long parkId);
    
    public static class Query extends Pagination {
    	
    	private Long parkId;
    	private String nameOrCode;
    	private String enableStatus;
		
		public String getNameOrCode() {
			return nameOrCode;
		}
		public void setNameOrCode(String nameOrCode) {
			this.nameOrCode = nameOrCode;
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
    
    public static class EquipmentType extends EquipmentTypeEntity {
    }
}
