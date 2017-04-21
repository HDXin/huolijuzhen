package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillApprovalStatus;


public class BillApprovalStatusHandler implements TypeHandler<BillApprovalStatus> {

    @Override
    public BillApprovalStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillApprovalStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillApprovalStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillApprovalStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillApprovalStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillApprovalStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillApprovalStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
