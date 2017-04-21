package com.sudaotech.huolijuzhen.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.EnterpriseDisplayExtends;
import com.sudaotech.huolijuzhen.community.service.EnterpriseDisplayService.Query;

public class EnterpriseDisplayEntityExtendsSqlProvider {

	public String selectByEnterpriseIds(Map<String, Object> paramsMap){
		Query query = (Query) paramsMap.get("query");
		EnterpriseDisplayExtends extendsEntity = (EnterpriseDisplayExtends) paramsMap.get("extendsEntity");
		
		Integer offset = query.getOffset();
		Integer limit = query.getLimit();
		
		String startTime = extendsEntity.getStartTime();
		String endTime = extendsEntity.getEndTime();
		String enterpriseName = extendsEntity.getEnterpriseName();
		int publishLevel = extendsEntity.getPublishLevel();
		int approvalStatus = extendsEntity.getApprovalStatus();
		Long enterpriseId = extendsEntity.getEnterpriseId();
		
		@SuppressWarnings("unchecked")
		List<Long> enterpriseIdsList = (List<Long>)paramsMap.get("ids");
		
		//获取园区id
		Long parkId = (Long) paramsMap.get("parkId");
		
		StringBuffer sql = new StringBuffer("select id id, enterpriseId enterpriseId, parkId parkId, info info, details details, introduce introduce, thumbnailUrl thumbnailUrl,")
									.append("publishLevel publishLevel, detailUrl detailUrl, approvalStatus approvalStatus, approvalDate approvalDate,")
									.append("approvalUser approvalUser, version version, status status, createBy createBy, createTime createTime, updateBy updateBy,")
									.append("updateTime updateTime, lastUpdate lastUpdate from enterprise_display where status=1 ");
		if(enterpriseIdsList!=null && enterpriseIdsList.size()>0){
			sql.append(" and enterpriseId in ( ").append(StringUtils.join(enterpriseIdsList, ",")).append(") ");
		}
		if(startTime!=null){
			sql.append(" and createTime >= DATE_FORMAT('").append(startTime).append("','%Y-%m-%d') ");
		}
		if(endTime!=null){
			sql.append(" and createTime <= DATE_FORMAT('").append(endTime).append("','%Y-%m-%d') ");
		}
		if(!com.sudaotech.huolijuzhen.util.StringUtils.isEmpty(enterpriseName)){
			sql.append(" and enterpriseId in (select id from enterprise_info where name like '%").append(enterpriseName).append("%') ");
		}
		if(publishLevel!=-1){
			sql.append(" and publishLevel=").append(publishLevel).append(" ");
		}
		if(approvalStatus!=-1){
			sql.append(" and approvalStatus=").append(approvalStatus).append(" ");
		}
		if(parkId!=null){
			sql.append(" and parkId=").append(parkId).append(" ");
		}
		if(enterpriseId!=null){
			sql.append(" and enterpriseId=").append(enterpriseId).append(" ");
		}
		sql.append(" limit ").append(offset).append(",").append(limit);
		
		return sql.toString();
	}
	
	/**
	 * 查找数量
	 * */
	public String findCountBySql(Map<String, Object> paramsMap){
		List<Long> enterpriseIdsList = (List<Long>) paramsMap.get("ids");
		EnterpriseDisplayExtendsEntity extendsEntity = (EnterpriseDisplayExtendsEntity) paramsMap.get("extendsEntity");
		
		String startTime = extendsEntity.getStartTime();
		String endTime = extendsEntity.getEndTime();
		String enterpriseName = extendsEntity.getEnterpriseName();
		int publishLevel = extendsEntity.getPublishLevel();
		int approvalStatus = extendsEntity.getApprovalStatus();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select count(*) from enterprise_display where status=1 ");
		if(enterpriseIdsList!=null && enterpriseIdsList.size()>0){
			sql.append(" and enterpriseId in ( ").append(StringUtils.join(enterpriseIdsList, ",")).append(") ");
		}
		if(startTime!=null){
			sql.append(" and createTime >= DATE_FORMAT('").append(startTime).append("','%Y-%m-%d') ");
		}
		if(endTime!=null){
			sql.append(" and createTime <= DATE_FORMAT('").append(endTime).append("','%Y-%m-%d') ");
		}
		if(!com.sudaotech.huolijuzhen.util.StringUtils.isEmpty(enterpriseName)){
			sql.append(" and enterpriseId in (select id from enterprise_info where name like '%").append(enterpriseName).append("%') ");
		}
		if(publishLevel!=-1){
			sql.append(" and publishLevel=").append(publishLevel).append(" ");
		}
		if(approvalStatus!=-1){
			sql.append(" and approvalStatus=").append(approvalStatus).append(" ");
		}
		
		return sql.toString();
	}
	
	/**
	 * 根据园区id和企业id查询数量
	 * */
	public String findCountByParkidAndEnterpriseId(Map<String, Object> paramsMap){
		EnterpriseDisplayExtends extendsEntity = (EnterpriseDisplayExtends) paramsMap.get("extendsEntity");
		String startTime = extendsEntity.getStartTime();
		String endTime = extendsEntity.getEndTime();
		int publishLevel = extendsEntity.getPublishLevel();
		int approvalStatus = extendsEntity.getApprovalStatus();
		Long enterpriseId = extendsEntity.getEnterpriseId();
		
		Long parkId = (Long) paramsMap.get("parkId");
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select count(*) from enterprise_display where status=1 ");
		if(startTime!=null){
			sql.append(" and createTime >= DATE_FORMAT('").append(startTime).append("','%Y-%m-%d') ");
		}
		if(endTime!=null){
			sql.append(" and createTime <= DATE_FORMAT('").append(endTime).append("','%Y-%m-%d') ");
		}
		if(publishLevel!=-1){
			sql.append(" and publishLevel=").append(publishLevel).append(" ");
		}
		if(approvalStatus!=-1){
			sql.append(" and approvalStatus=").append(approvalStatus).append(" ");
		}
		if(parkId!=null){
			sql.append(" and parkId=").append(parkId).append(" ");
		}
		sql.append(" and enterpriseId= ").append(enterpriseId).append(" ");
		
		return sql.toString();
	}
	
	//查询所有id
	public String selectAllIDs(){
		String sql = "select distinct enterpriseId from enterprise_display";
		return sql;
	}
	
	/**
	 * 根据发布级别查询
	 * */
	public String selectByPublishLevel(Integer publishLevel){
		String sql = "select id, enterpriseId, parkId, info, details, introduce, thumbnailUrl, publishLevel, detailUrl, approvalStatus, approvalDate, approvalUser, version, status, createBy, createTime, updateBy, updateTime, lastUpdate from enterprise_display where status=1 and publishLevel="+publishLevel;
		return sql;
	}
	
}