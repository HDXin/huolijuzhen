package com.sudaotech.core.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.core.enums.Status;

public class StatusHandler implements TypeHandler<Status> {

    @Override
    public Status getResult(ResultSet rs, String column) throws SQLException {
        return Status.codeOf(rs.getInt(column));
    }

    @Override
    public Status getResult(ResultSet rs, int i) throws SQLException {
        return Status.codeOf(rs.getInt(i));
    }

    @Override
    public Status getResult(CallableStatement cs, int i) throws SQLException {
        return Status.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Status param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
