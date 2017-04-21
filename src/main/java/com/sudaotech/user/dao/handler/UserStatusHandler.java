package com.sudaotech.user.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.user.enums.UserStatus;

public class UserStatusHandler implements TypeHandler<UserStatus> {

    @Override
    public UserStatus getResult(ResultSet rs, String column) throws SQLException {
        return UserStatus.codeOf(rs.getInt(column));
    }

    @Override
    public UserStatus getResult(ResultSet rs, int i) throws SQLException {
        return UserStatus.codeOf(rs.getInt(i));
    }

    @Override
    public UserStatus getResult(CallableStatement cs, int i) throws SQLException {
        return UserStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, UserStatus param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
