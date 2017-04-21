package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.Grade;



public class GradeHandler implements TypeHandler<Grade> {

    @Override
    public Grade getResult(ResultSet rs, String column) throws SQLException {
        return Grade.codeOf(rs.getInt(column));
    }

    @Override
    public Grade getResult(ResultSet rs, int i) throws SQLException {
        return Grade.codeOf(rs.getInt(i));
    }

    @Override
    public Grade getResult(CallableStatement cs, int i) throws SQLException {
        return Grade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Grade param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
