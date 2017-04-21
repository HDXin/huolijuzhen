package com.sudaotech.user.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.user.enums.PasswordStatus;

public class PasswordStatusHandler implements TypeHandler<PasswordStatus> {

    @Override
    public PasswordStatus getResult(ResultSet rs, String column) throws SQLException {
        return PasswordStatus.codeOf(rs.getInt(column));
    }

    @Override
    public PasswordStatus getResult(ResultSet rs, int i) throws SQLException {
        return PasswordStatus.codeOf(rs.getInt(i));
    }

    @Override
    public PasswordStatus getResult(CallableStatement cs, int i) throws SQLException {
        return PasswordStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PasswordStatus param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
