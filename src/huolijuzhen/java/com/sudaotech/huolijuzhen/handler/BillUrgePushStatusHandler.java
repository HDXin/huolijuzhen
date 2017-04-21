package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.BillUrgePushStatus;


public class BillUrgePushStatusHandler implements TypeHandler<BillUrgePushStatus> {

    @Override
    public BillUrgePushStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillUrgePushStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillUrgePushStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillUrgePushStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillUrgePushStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillUrgePushStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillUrgePushStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
