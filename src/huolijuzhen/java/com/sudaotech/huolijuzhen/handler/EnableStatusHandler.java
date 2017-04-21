package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.EnableStatus;



public class EnableStatusHandler implements TypeHandler<EnableStatus> {

    @Override
    public EnableStatus getResult(ResultSet rs, String column) throws SQLException {
        return EnableStatus.codeOf(rs.getInt(column));
    }

    @Override
    public EnableStatus getResult(ResultSet rs, int i) throws SQLException {
        return EnableStatus.codeOf(rs.getInt(i));
    }

    @Override
    public EnableStatus getResult(CallableStatement cs, int i) throws SQLException {
        return EnableStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, EnableStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
