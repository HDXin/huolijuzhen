package com.sudaotech.huolijuzhen.basic.dao;

import java.util.Map;

public class ServiceLocationEntitySqlProvider {


	
	public String isExist(Map<String, Object> params){
		StringBuilder sql = new StringBuilder();
		sql.append("select id from location_info"
				+ " where 1=1 ");
		
		Long proId = (Long)params.get("proId");
		if(proId != null){
			sql.append(" and proId = #{proId}");
		}
		
		Long cityId = (Long)params.get("cityId");
		if(cityId != null){
			sql.append(" and cityId = #{cityId}");
		}

		Long counId = (Long)params.get("counId");
		if(counId != null){
			sql.append(" and counId = #{counId}");
		}
		
		Object business = params.get("business");
		if(business != null){
			sql.append(" and business = #{business}");
		}
		
		return sql.toString();
	}
	

}