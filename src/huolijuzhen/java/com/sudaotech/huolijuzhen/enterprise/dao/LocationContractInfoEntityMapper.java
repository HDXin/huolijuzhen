package com.sudaotech.huolijuzhen.enterprise.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.SelectProvider;

public interface LocationContractInfoEntityMapper extends ContractInfoEntityMapper{
    
	@SelectProvider(type=LocationContractInfoEntitySqlProvider.class, method="findByBillMonthAndEnterpriseIdAndContractIdCount")
	public int findByBillMonthAndEnterpriseIdAndContractIdCount(Map<String, Object> params);
	
	@SelectProvider(type=LocationContractInfoEntitySqlProvider.class, method="findByBillMonthAndEnterpriseIdAndContractId")
	public List<Map<String, Object>> findByBillMonthAndEnterpriseIdAndContractId(Map<String, Object> params);
	
}