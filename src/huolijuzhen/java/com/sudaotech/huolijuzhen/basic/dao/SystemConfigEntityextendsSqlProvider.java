package com.sudaotech.huolijuzhen.basic.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

public class SystemConfigEntityextendsSqlProvider {

	/**
	 * 提供根据园区id查询的sql语句
	 * */
	public String selectByParkId(Long parkId){
		BEGIN();
		SELECT("id");
		SELECT("parkId");
		SELECT("maintenanceReportSign");
		SELECT("maintenanceReportDays");
		SELECT("createParkSign");
		SELECT("createParkDays");
		SELECT("equipmentMaintainSign");
		SELECT("equipmentMaintainDays");
		SELECT("urgeTermSign");
		SELECT("urgeTermDays");
		SELECT("urgeContentTemplate");
		SELECT("version");
		SELECT("status");
		SELECT("createBy");
		SELECT("createTime");
		SELECT("updateBy");
		SELECT("updateTime");
		SELECT("lastUpdate");
        SELECT("billIntroduction");
        SELECT("billPayWay");
        SELECT("billBankAccount");
        SELECT("billInscrible");
		FROM("system_config");
		WHERE("parkId="+parkId+" and status=1");
		return SQL();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new SystemConfigEntityextendsSqlProvider().selectByParkId(new Long(1002)));
		
	}
	
}
