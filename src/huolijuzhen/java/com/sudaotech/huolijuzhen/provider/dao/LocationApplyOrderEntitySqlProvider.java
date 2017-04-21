package com.sudaotech.huolijuzhen.provider.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;


public class LocationApplyOrderEntitySqlProvider extends ApplyOrderEntitySqlProvider{
	
	
	public String findApplyOrderCount(Map<String, Object> params){

		List<Integer> applyOrderStatus = new ArrayList<Integer>();
		applyOrderStatus.add(ApplyOrderStatus.APPLYWAITEXECUTOR.code());
		applyOrderStatus.add(ApplyOrderStatus.ALREADYPASS.code());
		applyOrderStatus.add(ApplyOrderStatus.NOPASS.code());
		
		applyOrderStatus.add(ApplyOrderStatus.WAITCOMMENT.code());
		applyOrderStatus.add(ApplyOrderStatus.FINISH.code());
		
		StringBuilder sql = new StringBuilder();
		sql.append("select count(id) from apply_order_info where 1=1 ");
		sql.append(" and status = " + params.get("status"));
		sql.append(" and serviceProId = " + params.get("serviceProId"));
		
		String applyOrderStatusStr = integerToStr(applyOrderStatus);
		if(StringUtils.isNotBlank(applyOrderStatusStr)){
			sql.append(" and applyOrderStatus in" + applyOrderStatusStr);
		}
		return sql.toString();
	}

	private String integerToStr(List<Integer> ids){

		if(CollectionUtils.isEmpty(ids)){
			return null;
		}
		StringBuilder inSql = new StringBuilder();
		inSql.append("(");
		for(int i=0;i<ids.size();i++){
			inSql.append(ids.get(i));
			if(i<ids.size()-1){
				inSql.append(",");
			}
		}
		inSql.append(")");
		return inSql.toString();
	}
}