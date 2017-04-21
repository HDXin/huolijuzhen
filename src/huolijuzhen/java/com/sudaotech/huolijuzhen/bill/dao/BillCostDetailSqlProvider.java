package com.sudaotech.huolijuzhen.bill.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

public class BillCostDetailSqlProvider extends BillCostDetailEntitySqlProvider {
	
	
    public String getTotalApportion(Long billId) {
        BEGIN();
        SELECT("sum(verifyMoney)");
        FROM("bill_cost_detail");
        WHERE("status = 1 and billId ="+billId );
        return SQL();
    }
	
	
	
	
}