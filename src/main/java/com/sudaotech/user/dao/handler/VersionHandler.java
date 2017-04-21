package com.sudaotech.user.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.user.enums.Version;

public class VersionHandler implements TypeHandler<Version> {

    @Override
    public Version getResult(ResultSet rs, String column) throws SQLException {
        return Version.codeOf(rs.getInt(column));
    }

    @Override
    public Version getResult(ResultSet rs, int i) throws SQLException {
        return Version.codeOf(rs.getInt(i));
    }

    @Override
    public Version getResult(CallableStatement cs, int i) throws SQLException {
        return Version.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Version param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
