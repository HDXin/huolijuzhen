package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillPushStatus;


public class BillPushStatusHandler implements TypeHandler<BillPushStatus> {

    @Override
    public BillPushStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillPushStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillPushStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillPushStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillPushStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillPushStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillPushStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
