package com.sudaotech.huolijuzhen.bill.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.SelectProvider;


public interface BillCostDetailMapper extends BillCostDetailEntityMapper {
	
	
	
	@SelectProvider(type=BillCostDetailSqlProvider.class, method="getTotalApportion")
    BigDecimal getTotalApportion(Long billId);
    
    
	
}