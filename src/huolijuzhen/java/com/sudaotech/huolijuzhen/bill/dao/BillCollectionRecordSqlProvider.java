package com.sudaotech.huolijuzhen.bill.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

public class BillCollectionRecordSqlProvider extends BillCollectionRecordEntitySqlProvider {

    public String getTotalCollectioin(Long billId) {
        BEGIN();
        SELECT("sum(collectionAmount)");
        FROM("bill_collection_record");
        WHERE("status = 1 and billId ="+billId );
        return SQL();
    }

   
}