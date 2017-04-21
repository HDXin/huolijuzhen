package com.sudaotech.huolijuzhen.equipment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sudaotech.huolijuzhen.equipment.dao.EquipmentPlanEntityMapper;

public interface LocationEquipmentPlanEntityMapper extends EquipmentPlanEntityMapper {
   
	@Select("select id from equipment_plan where planStatus = #{planStatus} and equId = #{equPreId} and date_format(planExecutorDate,'%Y-%m-%d') > #{planExecutorDate}")
	@Results(@Result(id=true,column="id",property="id"))
	public List<Long> getByEquPreId(Map<String, Object> params);
	
	@Select("select id id,"
			+ "planExecutorDate planExecutorDate,"
			+ "description description,"
			+ "enableStatus enableStatus,"
			+ "planStatus planStatus"
			+ " from equipment_plan"
			+ " where 1=1 "
			+ "	and equId = #{equPreId} "
			+ "	and status = #{status}"
			+ " order by planExecutorDate")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="planExecutorDate",property="planExecutorDate"),
		@Result(column="description",property="description"),
		@Result(column="enableStatus",property="enableStatus"),
		@Result(column="planStatus",property="planStatus")
	})
	public List<Map<String, Object>> findByEquId(Map<String, Object> params);
	
}