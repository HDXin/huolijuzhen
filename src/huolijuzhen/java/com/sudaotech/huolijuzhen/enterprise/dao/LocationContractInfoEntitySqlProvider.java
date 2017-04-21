package com.sudaotech.huolijuzhen.enterprise.dao;

import java.util.Map;

public class LocationContractInfoEntitySqlProvider extends ContractInfoEntitySqlProvider {

public String findByBillMonthAndEnterpriseIdAndContractIdCount(Map<String, Object> params){
		
		StringBuilder sql = new StringBuilder("");
		
		sql.append(" select count(*) ");
		sql.append(" from enterprise_cott ett");
		sql.append(" left join enterprise_info ei on ett.enterpriseId = ei.id");
		sql.append(" left join enterprise_corr_contract err on ett.id = err.enterpriseCottId");
		sql.append(" left join contract_info ci on err.contractId = ci.id");
		sql.append(" where ett.status = 1 and ei.status = 1");
		
		Long parkId = (Long)params.get("parkId");
		sql.append(" and ett.parkId = " + parkId);

		String billMonth = (String)params.get("billMonth");
//		sql.append(" and (");
//		sql.append("date_format(ci.startDate,'%Y-%m') >= '" + billMonth + "'" );
//		sql.append(" or ");
//		sql.append("date_format(ci.endDate,'%Y-%m') <= '" + billMonth + "'");
//		sql.append(")");
		
		sql.append(" and date_format(ci.startDate,'%Y-%m') <= '" + billMonth + "'" );
		sql.append(" and date_format(ci.endDate,'%Y-%m') >= '" + billMonth + "'");
		
		
		if(params.get("companyId") != null){
			Long companyId = (Long)params.get("companyId");
			sql.append(" and ett.enterpriseId = " + companyId);
		}

		if(params.get("contractId") != null){
			Long contractId = (Long)params.get("contractId");
			sql.append(" and ci.id = " + contractId);
		}
		
		sql.append(" order by ei.name,err.contNo desc");
		
		System.out.println("count:" + sql.toString());
		return sql.toString();
	}
	
	public String findByBillMonthAndEnterpriseIdAndContractId(Map<String, Object> params){
		
		StringBuilder sql = new StringBuilder("");
		
//		String str = "select ett.id,ett.parkId,ett.enterpriseId,ei.name,ci.id,err.contNo,ci.startDate,ci.endDate "
//				+ " from enterprise_cott ett "
//				+ " left join enterprise_info ei on ett.enterpriseId = ei.id "
//				+ " left join enterprise_corr_contract err on ett.id = err.enterpriseCottId "
//				+ " left join contract_info ci on err.contractId = ci.id "
//				+ " where ett.status = 1 and ei.status = 1 "
//				+ " and ett.parkId = 33 "
//				+ " order by ei.name,err.contNo desc;";

		sql.append(" select ett.enterpriseId companyId,ei.name companyName,ci.id contractId,ci.contNo contNo,ci.startDate startDate,ci.endDate endDate");
		sql.append(" from enterprise_cott ett");
		sql.append(" left join enterprise_info ei on ett.enterpriseId = ei.id");
		sql.append(" left join enterprise_corr_contract err on ett.id = err.enterpriseCottId");
		sql.append(" left join contract_info ci on err.contractId = ci.id");
		sql.append(" where ett.status = 1 and ei.status = 1");
		
		Long parkId = (Long)params.get("parkId");
		sql.append(" and ett.parkId = " + parkId);

		String billMonth = (String)params.get("billMonth");
//		sql.append(" and(");
//		sql.append("date_format(ci.startDate,'%Y-%m') >= '" + billMonth + "'" );
//		sql.append(" or ");
//		sql.append("date_format(ci.endDate,'%Y-%m') <= '" + billMonth + "'");
//		sql.append(")");

		sql.append(" and date_format(ci.startDate,'%Y-%m') <= '" + billMonth + "'" );
		sql.append(" and date_format(ci.endDate,'%Y-%m') >= '" + billMonth + "'");

		
		if(params.get("companyId") != null){
			Long companyId = (Long)params.get("companyId");
			sql.append(" and ett.enterpriseId = " + companyId);
		}

		if(params.get("contractId") != null){
			Long contractId = (Long)params.get("contractId");
			sql.append(" and ci.id = " + contractId);
		}
		
		sql.append(" order by ei.name,err.contNo desc");
		sql.append(" limit ");
		sql.append(params.get("offset"));
		sql.append(",");
		sql.append(params.get("limit"));
		return sql.toString();
	}
    
}