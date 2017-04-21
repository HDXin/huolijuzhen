package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ComputeMode;


public class ComputeModeHandler implements TypeHandler<ComputeMode> {

    @Override
    public ComputeMode getResult(ResultSet rs, String column) throws SQLException {
        return ComputeMode.codeOf(rs.getInt(column));
    }

    @Override
    public ComputeMode getResult(ResultSet rs, int i) throws SQLException {
        return ComputeMode.codeOf(rs.getInt(i));
    }

    @Override
    public ComputeMode getResult(CallableStatement cs, int i) throws SQLException {
        return ComputeMode.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ComputeMode param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
