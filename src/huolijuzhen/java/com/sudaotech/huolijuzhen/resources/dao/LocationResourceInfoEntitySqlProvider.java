package com.sudaotech.huolijuzhen.resources.dao;

import java.util.Map;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.enums.CalcDimension;
import com.sudaotech.huolijuzhen.enums.UseStatus;
public class LocationResourceInfoEntitySqlProvider {
	
	public String resOfAreaAll(Map<String,Object> params){
		Long parkId = (Long)params.get("parkId");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ri.resInfoId resTypeId,rt.name resTypeName,round(SUM(ri.area),2) sumAreaAll FROM resource_info ri ");
		sql.append(" LEFT JOIN res_info rt ON rt.id = ri.resInfoId");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ri.isSeat = 1 ");
		sql.append(" AND ri.status = " + Status.NORMAL.code());
		sql.append(" AND ri.gardenId = " + parkId);
		sql.append(" AND rt.calcDimension = " + CalcDimension.BY_AREA.code());
		sql.append(" GROUP BY ri.resInfoId");
		sql.append(" ORDER BY sumAreaAll");

		return sql.toString();
	}
	public String resOfAreaUse(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ri.resInfoId resTypeId,rt.name resTypeName,round(SUM(ri.area),2) sumAreaUse FROM resource_info ri");
		sql.append(" LEFT JOIN res_info rt ON rt.id = ri.resInfoId");
		sql.append(" left join contract_resource cr on cr.resourceId = ri.id ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ri.isSeat = 1 ");
		sql.append(" AND ri.status = " + Status.NORMAL.code());
		sql.append(" AND ri.gardenId = " + parkId);
		sql.append(" AND rt.calcDimension = " + CalcDimension.BY_AREA.code());
		sql.append(" AND cr.useStatus = " + UseStatus.USE.code());
		sql.append(" GROUP BY ri.resInfoId");
		sql.append(" ORDER BY sumAreaUse");

		return sql.toString();
	}
	public String resOfNumAll(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ri.resInfoId resTypeId,rt.name resTypeName,COUNT(ri.id) sumNumAll FROM resource_info ri ");
		sql.append(" LEFT JOIN res_info rt ON rt.id = ri.resInfoId");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ri.isSeat = 1 ");
		sql.append(" AND ri.status = " + Status.NORMAL.code());
		sql.append(" AND ri.gardenId = " + parkId);
		sql.append(" AND rt.calcDimension = " + CalcDimension.BY_NUMS.code());
		sql.append(" GROUP BY ri.resInfoId");
		sql.append(" ORDER BY sumNumAll");
		
		return sql.toString();
	}
	public String resOfNumUse(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ri.resInfoId resTypeId,rt.name resTypeName,COUNT(ri.id) sumNumUse FROM resource_info ri ");
		sql.append(" LEFT JOIN res_info rt ON rt.id = ri.resInfoId ");
		sql.append(" left join contract_resource cr on cr.resourceId = ri.id ");
		sql.append(" WHERE 1=1 ");
		sql.append(" AND ri.isSeat = 1 ");
		sql.append(" AND ri.status = " + Status.NORMAL.code());
		sql.append(" AND ri.gardenId = " + parkId);
		sql.append(" AND rt.calcDimension = " + CalcDimension.BY_NUMS.code());
		sql.append(" AND cr.useStatus = " + UseStatus.USE.code());
		sql.append(" GROUP BY ri.resInfoId");
		sql.append(" ORDER BY sumNumUse");

		return sql.toString();
	}
	
	/**
	 * 该园区资源平均基价
	 * @param params
	 * @return
	 */
	public String resAvgBasicPrice(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		Long resTypeId = (Long)params.get("resTypeId");
		StringBuilder sql = new StringBuilder();
		sql.append("select ri.resInfoId resTypeId,rt.name resTypeName,round(sum(ri.area*ri.price),2) sumPrice,round(sum(area),2) sumArea from resource_info ri");
		sql.append(" left join res_info rt on rt.id = ri.resInfoId");
		sql.append(" where 1=1");
		sql.append(" and ri.status = " + Status.NORMAL.code());
		sql.append(" and ri.gardenId = " + parkId);
		sql.append(" and resInfoId = " + resTypeId);
		return sql.toString();
	}
	
	/**
	 * 该园区已出租资源的均价
	 * @param params
	 * @return
	 */
	public String resAvgRentPrice(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		Long resTypeId = (Long)params.get("resTypeId");
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(area) sumArea,sum(totalMoney) sumPrice from contract_info");
		sql.append(" where 1=1");
		sql.append(" and status = " + Status.NORMAL.code());
		sql.append(" and id in(");
			sql.append(" select distinct(contractId) from contract_resource");
			sql.append(" where 1=1 ");
			sql.append(" and status = " + Status.NORMAL.code());
			sql.append(" and resourceId in(");
				sql.append(" select id from resource_info where 1=1 ");
				sql.append(" and status = " + Status.NORMAL.code());
				sql.append(" and useStatus = " + UseStatus.USE.code());
				sql.append(" and gardenId = " + parkId);
				sql.append(" and resInfoId = " + resTypeId);
			sql.append(")");
		sql.append(")");
		return sql.toString();
	}
	
	/**
	 * 该园区未出租的资源的面积和、基价和
	 * @param params
	 * @return
	 */
	public String resNoRentInfo(Map<String, Object> params){
		Long parkId = (Long)params.get("parkId");
		Long resTypeId = (Long)params.get("resTypeId");
		StringBuilder sql = new StringBuilder();
		sql.append("select sum(area) sumArea,sum(price) sumPrice from resource_info");
		sql.append(" where 1=1");
		sql.append(" and status = " + Status.NORMAL.code());
		sql.append(" and useStatus = " + UseStatus.NOUSE.code());
		sql.append(" and gardenId = " + parkId);
		sql.append(" and resInfoId = " + resTypeId);
		return sql.toString();
	}
	
}