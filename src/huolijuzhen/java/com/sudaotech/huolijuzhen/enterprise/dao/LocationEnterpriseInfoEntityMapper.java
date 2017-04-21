package com.sudaotech.huolijuzhen.enterprise.dao;

import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

public interface LocationEnterpriseInfoEntityMapper extends EnterpriseInfoEntityMapper{

	
	@SelectProvider(type=LocationEnterpriseInfoEntitySqlProvider.class,method="enterpriseInfoStatistics")
	public Integer enterpriseInfoStatistics(Map<String, Object> params);
}