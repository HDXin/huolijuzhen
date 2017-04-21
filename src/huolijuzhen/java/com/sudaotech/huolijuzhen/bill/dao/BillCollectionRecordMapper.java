package com.sudaotech.huolijuzhen.bill.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.SelectProvider;

public interface BillCollectionRecordMapper extends BillCollectionRecordEntityMapper {
	
	@SelectProvider(type=BillCollectionRecordSqlProvider.class, method="getTotalCollectioin")
    BigDecimal getTotalCollectioin(Long billId);
	
	
}