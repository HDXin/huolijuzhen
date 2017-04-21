package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ApprovalStatus;


public class ApprovalStatusHandler implements TypeHandler<ApprovalStatus> {

    @Override
    public ApprovalStatus getResult(ResultSet rs, String column) throws SQLException {
        return ApprovalStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ApprovalStatus getResult(ResultSet rs, int i) throws SQLException {
        return ApprovalStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ApprovalStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ApprovalStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ApprovalStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
