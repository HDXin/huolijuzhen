package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.PayWay;


public class PayWayHandler implements TypeHandler<PayWay> {

    @Override
    public PayWay getResult(ResultSet rs, String column) throws SQLException {
        return PayWay.codeOf(rs.getInt(column));
    }

    @Override
    public PayWay getResult(ResultSet rs, int i) throws SQLException {
        return PayWay.codeOf(rs.getInt(i));
    }

    @Override
    public PayWay getResult(CallableStatement cs, int i) throws SQLException {
        return PayWay.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PayWay param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
