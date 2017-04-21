package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillVerificationStatus;


public class BillVerificationStatusHandler implements TypeHandler<BillVerificationStatus> {

    @Override
    public BillVerificationStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillVerificationStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillVerificationStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillVerificationStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillVerificationStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillVerificationStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillVerificationStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
