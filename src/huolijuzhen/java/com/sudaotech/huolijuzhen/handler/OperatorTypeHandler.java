package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.OperatorType;

public class OperatorTypeHandler implements TypeHandler<OperatorType> {

    @Override
    public OperatorType getResult(ResultSet rs, String column) throws SQLException {
        return OperatorType.codeOf(rs.getInt(column));
    }

    @Override
    public OperatorType getResult(ResultSet rs, int i) throws SQLException {
        return OperatorType.codeOf(rs.getInt(i));
    }

    @Override
    public OperatorType getResult(CallableStatement cs, int i) throws SQLException {
        return OperatorType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, OperatorType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
