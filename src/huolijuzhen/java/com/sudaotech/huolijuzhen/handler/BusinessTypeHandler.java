package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BusinessType;

public class BusinessTypeHandler implements TypeHandler<BusinessType> {

    @Override
    public BusinessType getResult(ResultSet rs, String column) throws SQLException {
        return BusinessType.codeOf(rs.getInt(column));
    }

    @Override
    public BusinessType getResult(ResultSet rs, int i) throws SQLException {
        return BusinessType.codeOf(rs.getInt(i));
    }

    @Override
    public BusinessType getResult(CallableStatement cs, int i) throws SQLException {
        return BusinessType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BusinessType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
