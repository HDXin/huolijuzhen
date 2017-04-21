package com.sudaotech.core.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.core.enums.Gender;

public class GenderHandler implements TypeHandler<Gender> {

    @Override
    public Gender getResult(ResultSet rs, String column) throws SQLException {
        return Gender.codeOf(rs.getInt(column));
    }

    @Override
    public Gender getResult(ResultSet rs, int i) throws SQLException {
        return Gender.codeOf(rs.getInt(i));
    }

    @Override
    public Gender getResult(CallableStatement cs, int i) throws SQLException {
        return Gender.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Gender param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
