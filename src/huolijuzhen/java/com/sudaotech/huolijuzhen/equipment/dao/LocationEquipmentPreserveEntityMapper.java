package com.sudaotech.huolijuzhen.equipment.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface LocationEquipmentPreserveEntityMapper extends EquipmentPreserveEntityMapper{
    
	
	@Select("select count(id)"
			+ " from equ_pre_info"
			+ " where 1=1 "
			+ " and status = #{status}"
			+ " and parkId = #{parkId}"
			+ " and equTypeId = #{equTypeId}")
	public Integer findCountByEquTypeId(Map<String, Object> params);
	
}