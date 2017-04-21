package com.sudaotech.account.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.core.enums.AuditStatus;

public class AuditStatusHandler implements TypeHandler<AuditStatus> {

    @Override
    public AuditStatus getResult(ResultSet rs, String column) throws SQLException {
        return AuditStatus.codeOf(rs.getInt(column));
    }

    @Override
    public AuditStatus getResult(ResultSet rs, int i) throws SQLException {
        return AuditStatus.codeOf(rs.getInt(i));
    }

    @Override
    public AuditStatus getResult(CallableStatement cs, int i) throws SQLException {
        return AuditStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, AuditStatus param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
