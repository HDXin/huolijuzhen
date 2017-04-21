package com.sudaotech.huolijuzhen.policy.dao;

import java.util.Map;

public class LocationPolicyEntitySqlProvider {

	 public String findAllCountByParkId(Map<String, Object> params){
	    	
	    	StringBuilder sql = new StringBuilder();
	    	sql.append("select count(id) ");
	    	sql.append(" from policy_info");
	    	sql.append(" where 1=1 ");
	    	sql.append(" and status = #{status}");
	    	sql.append(" and approvalStatus = #{approvalStatus}");
	    	
	    	sql.append(" and(");
	    	//1.所有的平台
	    	sql.append("(publicGrade = #{pPublicGrade})");
	    	
	    	//2.所有省份
	    	sql.append(" or (");
	    	sql.append(" publicGrade = #{aPublicGrade}");
	    	sql.append(" and proId = #{proId}");
	    	sql.append(")");
	    	//3.所有的城市
	    	sql.append(" or (");
	    	sql.append(" publicGrade = #{aPublicGrade}");
	    	sql.append(" and proId = #{proId}");
	    	sql.append(" and cityId = #{cityId}");
	    	sql.append(")");    	
	    	//4.所有的县区
	    	sql.append(" or (");
	    	sql.append(" publicGrade = #{aPublicGrade}");
	    	sql.append(" and proId = #{proId}");
	    	sql.append(" and cityId = #{cityId}");
	    	sql.append(" and counId = #{counId}");
	    	sql.append(")");     	
	    	//5.所有的行政位置
	    	sql.append(" or (");
	    	sql.append(" publicGrade = #{aPublicGrade}");
	    	sql.append(" and proId = #{proId}");
	    	sql.append(" and cityId = #{cityId}");
	    	sql.append(" and counId = #{counId}");
	    	sql.append(" and locationId = #{locationId}");
	    	sql.append(")");     	
	    	
	    	sql.append(")");
	    	
	    	Integer offset = (Integer)params.get("offset");
	    	Integer limit = (Integer)params.get("limit");
	    	
	    	StringBuilder limitSql = new StringBuilder();
	    	limitSql.append(" limit ");
	    	limitSql.append(offset);
	    	limitSql.append(",");
	    	limitSql.append(limit);
	    	
	    	String sqlStr = sql.append(limitSql).toString();
	    	System.out.println("policy-----------:" + sqlStr);
	    	
	    	return sqlStr;
	    }
	
    public String findAllByParkId(Map<String, Object> params){
    	
    	StringBuilder sql = new StringBuilder();
    	sql.append("select");
    	sql.append(" id, title, polUri, publicGrade, parkId, proId, cityId, counId, locationId, approvalStatus,");
    	sql.append(" approvalBy, approvalTime, approvalText, version, status, createBy, createTime,");
    	sql.append(" updateBy, updateTime, lastUpdate, createSide, createSideId, readNum");
    	sql.append(" from policy_info");
    	sql.append(" where 1=1 ");
    	sql.append(" and status = #{status}");
    	sql.append(" and approvalStatus = #{approvalStatus}");
    	
    	sql.append(" and(");
    	//1.所有的平台
    	sql.append("(publicGrade = #{pPublicGrade})");
    	
    	//2.所有省份
    	sql.append(" or (");
    	sql.append(" publicGrade = #{aPublicGrade}");
    	sql.append(" and proId = #{proId}");
    	sql.append(")");
    	//3.所有的城市
    	sql.append(" or (");
    	sql.append(" publicGrade = #{aPublicGrade}");
    	sql.append(" and proId = #{proId}");
    	sql.append(" and cityId = #{cityId}");
    	sql.append(")");    	
    	//4.所有的县区
    	sql.append(" or (");
    	sql.append(" publicGrade = #{aPublicGrade}");
    	sql.append(" and proId = #{proId}");
    	sql.append(" and cityId = #{cityId}");
    	sql.append(" and counId = #{counId}");
    	sql.append(")");     	
    	//5.所有的行政位置
    	sql.append(" or (");
    	sql.append(" publicGrade = #{aPublicGrade}");
    	sql.append(" and proId = #{proId}");
    	sql.append(" and cityId = #{cityId}");
    	sql.append(" and counId = #{counId}");
    	sql.append(" and locationId = #{locationId}");
    	sql.append(")");     	
    	
    	sql.append(")");
    	
    	StringBuilder orderSql = new StringBuilder();
    	orderSql.append(" order by approvalStatus DESC ");
    	
    	Integer offset = (Integer)params.get("offset");
    	Integer limit = (Integer)params.get("limit");
    	
    	StringBuilder limitSql = new StringBuilder();
    	limitSql.append(" limit ");
    	limitSql.append(offset);
    	limitSql.append(",");
    	limitSql.append(limit);
    	
    	String sqlStr = sql.append(limitSql).toString();
    	System.out.println("policy-----------:" + sqlStr);
    	
    	return sqlStr;
    }
}