package com.sudaotech.huolijuzhen.park.dao;

import java.util.Map;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.EnableStatus;

public class LocationParkInfoEntitySqlProvider {

   public String findAllParkIdsByLocation(Map<String, Object> params){
	   StringBuilder sql = new StringBuilder();
	   
	   sql.append("select id from park_info where 1=1 ");
	   
	   Long proId = (Long)params.get("id");
	   if(proId != null){
		   sql.append(" and provinceId = #{proId}");
	   }
	   
	   Long cityId = (Long)params.get("cityId");
	   if(cityId != null){
		   sql.append(" and cityId = #{cityId}");
	   }
	   
	   Long counId = (Long)params.get("counId");
	   if(counId != null){
		   sql.append(" and regionId = #{counId}");
	   }
	    
	   Long locationId = (Long)params.get("locationId");
	   if(locationId != null){
		   sql.append(" and positionId = #{loactionId}");
	   }
	   
	   sql.append(" and status = #{status}");
	   return sql.toString();
   }
   
   /**
    * 园区入驻统计
    * @param params
    * @return
    */
   public String statisticsPark(Map<String, Object> params){
	   String startDate = (String)params.get("startDate");
	   String endDate = (String)params.get("endDate");
	   StringBuilder sql = new StringBuilder();
	   sql.append("select count(id) from park_info");
	   sql.append(" where 1=1");
	   sql.append(" and status = " + Status.NORMAL.code());
	   sql.append(" and enableStatus = " + EnableStatus.ENABLE.code());
	   sql.append(" and DATE_FORMAT(createTime,'%Y-%m-%d')");
	   sql.append(" BETWEEN");
	   sql.append(" '" + startDate + "'");
	   sql.append(" and");
	   sql.append(" '" + endDate + "'");
	   
	   return sql.toString();
   }
	
}