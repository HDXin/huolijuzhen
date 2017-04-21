package com.sudaotech.huolijuzhen.equipment.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.core.web.result.Pagination;
import com.sudaotech.huolijuzhen.enums.CycleType;
import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntity;

public interface EquipmentPlanService extends BaseService {

    public EquipmentPlan getById(Long id);

    public Long create(EquipmentPlan obj);

    public void update(EquipmentPlan obj);

    public Long save(EquipmentPlan obj);

    public Page<EquipmentPlan> find(Query query);
    
    public Page<EquipmentPlan> findByCondition(Query query);
    
//    public Page<EquipmentPlan> findByMonth(Query query) throws ParseException;

    public List<EquipmentPlan> findByMonth(Query query) throws ParseException;
    
    public Page<EquipmentPlan> findByDate(Query query) throws ParseException;
    
    /**
     * 设备计划提醒
     * @param equipmentPlanStatistics
     * @return
     */
    public Page<EquipmentPlan> equipmentPlanStatistics(EquipmentPlanQuery equipmentPlanQuery)throws ParseException;
    
    //根据计划 ID 删除所有计划
    public void removeByIds(List<Long> ids);
    
    //根据维护项目获取此时之后的所有计划
    public List<Long> getByEquPreId(Long id);
    
    public static class Query extends Pagination {
    	
    	//园区 ID
    	private List<Long> equIds = new ArrayList<Long>();
    	
    	//根据月份查
    	private String byMonth;
    	//根据日期查
    	private String byDay;
		public String getByMonth() {
			return byMonth;
		}
		public void setByMonth(String byMonth) {
			this.byMonth = byMonth;
		}
		public String getByDay() {
			return byDay;
		}
		public void setByDay(String byDay) {
			this.byDay = byDay;
		}
		public List<Long> getEquIds() {
			return equIds;
		}
		public void setEquIds(List<Long> equIds) {
			this.equIds = equIds;
		}
    }
    
    public static class EquipmentPlanQuery extends Pagination {
    	
    	//园区 ID
    	private List<Long> equIds = new ArrayList<Long>();
    	private Date startDate;
		public List<Long> getEquIds() {
			return equIds;
		}
		public void setEquIds(List<Long> equIds) {
			this.equIds = equIds;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
    }
    
    public static class EquipmentPlan extends EquipmentPlanEntity {
    }
    
    public static class BatchCreateItem{
    	
    	private Long equipmentId;
    	private List<EquipmentPlan> equipmentPlans = new ArrayList<EquipmentPlanService.EquipmentPlan>();

		public List<EquipmentPlan> getEquipmentPlans() {
			return equipmentPlans;
		}

		public void setEquipmentPlans(List<EquipmentPlan> equipmentPlans) {
			this.equipmentPlans = equipmentPlans;
		}

		public Long getEquipmentId() {
			return equipmentId;
		}

		public void setEquipmentId(Long equipmentId) {
			this.equipmentId = equipmentId;
		}
    }

	public List<Map<String, Object>> findByEquId(Map<String, Object> params);

	public static class PlanItems{
		
		private String cycStartDate;
		private String cycEndDate;
		private Integer preCycle;
		private List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		private CycleType cycleType;
		private String description;
		public String getCycStartDate() {
			return cycStartDate;
		}
		public void setCycStartDate(String cycStartDate) {
			this.cycStartDate = cycStartDate;
		}
		public String getCycEndDate() {
			return cycEndDate;
		}
		public void setCycEndDate(String cycEndDate) {
			this.cycEndDate = cycEndDate;
		}
		public Integer getPreCycle() {
			return preCycle;
		}
		public void setPreCycle(Integer preCycle) {
			this.preCycle = preCycle;
		}
		public List<Map<String, Object>> getItems() {
			return items;
		}
		public void setItems(List<Map<String, Object>> items) {
			this.items = items;
		}
		public CycleType getCycleType() {
			return cycleType;
		}
		public void setCycleType(CycleType cycleType) {
			this.cycleType = cycleType;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}

	

	
}
