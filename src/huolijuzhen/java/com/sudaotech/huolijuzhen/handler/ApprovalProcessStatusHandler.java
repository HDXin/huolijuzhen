package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ApprovalProcessStatus;


public class ApprovalProcessStatusHandler implements TypeHandler<ApprovalProcessStatus> {

    @Override
    public ApprovalProcessStatus getResult(ResultSet rs, String column) throws SQLException {
        return ApprovalProcessStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ApprovalProcessStatus getResult(ResultSet rs, int i) throws SQLException {
        return ApprovalProcessStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ApprovalProcessStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ApprovalProcessStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ApprovalProcessStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
