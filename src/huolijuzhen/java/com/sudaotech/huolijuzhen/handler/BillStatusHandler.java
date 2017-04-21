package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillStatus;


public class BillStatusHandler implements TypeHandler<BillStatus> {

    @Override
    public BillStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
