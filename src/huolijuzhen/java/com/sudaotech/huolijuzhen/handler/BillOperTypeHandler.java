package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillOperType;


public class BillOperTypeHandler implements TypeHandler<BillOperType> {

    @Override
    public BillOperType getResult(ResultSet rs, String column) throws SQLException {
        return BillOperType.codeOf(rs.getInt(column));
    }

    @Override
    public BillOperType getResult(ResultSet rs, int i) throws SQLException {
        return BillOperType.codeOf(rs.getInt(i));
    }

    @Override
    public BillOperType getResult(CallableStatement cs, int i) throws SQLException {
        return BillOperType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillOperType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
