package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.SuccessOrFailEnums;

public class SuccessOrFailEnumsHandler implements TypeHandler<SuccessOrFailEnums> {

    @Override
    public SuccessOrFailEnums getResult(ResultSet rs, String column) throws SQLException {
        return SuccessOrFailEnums.codeOf(rs.getInt(column));
    }

    @Override
    public SuccessOrFailEnums getResult(ResultSet rs, int i) throws SQLException {
        return SuccessOrFailEnums.codeOf(rs.getInt(i));
    }

    @Override
    public SuccessOrFailEnums getResult(CallableStatement cs, int i) throws SQLException {
        return SuccessOrFailEnums.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, SuccessOrFailEnums param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
