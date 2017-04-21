package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.CycleType;


public class CycleTypeHandler implements TypeHandler<CycleType> {

    @Override
    public CycleType getResult(ResultSet rs, String column) throws SQLException {
        return CycleType.codeOf(rs.getInt(column));
    }

    @Override
    public CycleType getResult(ResultSet rs, int i) throws SQLException {
        return CycleType.codeOf(rs.getInt(i));
    }

    @Override
    public CycleType getResult(CallableStatement cs, int i) throws SQLException {
        return CycleType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CycleType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
