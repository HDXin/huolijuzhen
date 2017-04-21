package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ApprovalType;


public class ApprovalTypeHandler implements TypeHandler<ApprovalType> {

    @Override
    public ApprovalType getResult(ResultSet rs, String column) throws SQLException {
        return ApprovalType.codeOf(rs.getInt(column));
    }

    @Override
    public ApprovalType getResult(ResultSet rs, int i) throws SQLException {
        return ApprovalType.codeOf(rs.getInt(i));
    }

    @Override
    public ApprovalType getResult(CallableStatement cs, int i) throws SQLException {
        return ApprovalType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ApprovalType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
