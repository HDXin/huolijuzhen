package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ApplyOrderType;

public class ApplyOrderTypeHandler implements TypeHandler<ApplyOrderType> {

    @Override
    public ApplyOrderType getResult(ResultSet rs, String column) throws SQLException {
        return ApplyOrderType.codeOf(rs.getInt(column));
    }

    @Override
    public ApplyOrderType getResult(ResultSet rs, int i) throws SQLException {
        return ApplyOrderType.codeOf(rs.getInt(i));
    }

    @Override
    public ApplyOrderType getResult(CallableStatement cs, int i) throws SQLException {
        return ApplyOrderType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ApplyOrderType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
