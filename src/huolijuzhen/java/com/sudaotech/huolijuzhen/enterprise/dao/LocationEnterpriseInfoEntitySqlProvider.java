package com.sudaotech.huolijuzhen.enterprise.dao;

import java.util.Map;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CorrStatus;

public class LocationEnterpriseInfoEntitySqlProvider {
	
	public String enterpriseInfoStatistics(Map<String, Object> params){

		String startDate = (String)params.get("startDate");
		String endDate = (String)params.get("endDate");
		StringBuilder sql = new StringBuilder();
		sql.append("select count(ei.id) from enterprise_info ei");
		sql.append(" left join enterprise_cott ec on ec.enterpriseId = ei.id");
		sql.append(" where 1=1");
		sql.append(" and ei.status = " + Status.NORMAL.code());
		sql.append(" and ec.corrStatus = " + CorrStatus.ALREADY_SETTLED.code());
		sql.append(" and DATE_FORMAT(ec.corrTime,'%Y-%m-%d')");
		sql.append(" between");
		sql.append(" '" + startDate + "'");
		sql.append(" and ");
		sql.append(" '" + endDate + "'");

		return sql.toString();
	}
    
}