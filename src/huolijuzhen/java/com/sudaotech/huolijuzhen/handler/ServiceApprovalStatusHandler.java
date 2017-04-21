package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ServiceApprovalStatus;



public class ServiceApprovalStatusHandler implements TypeHandler<ServiceApprovalStatus> {

    @Override
    public ServiceApprovalStatus getResult(ResultSet rs, String column) throws SQLException {
        return ServiceApprovalStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ServiceApprovalStatus getResult(ResultSet rs, int i) throws SQLException {
        return ServiceApprovalStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ServiceApprovalStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ServiceApprovalStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ServiceApprovalStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
