package com.sudaotech.sms.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.sms.SmsStatus;

public class SmsStatusHandler implements TypeHandler<SmsStatus> {

    @Override
    public SmsStatus getResult(ResultSet rs, String column) throws SQLException {
        return SmsStatus.codeOf(rs.getInt(column));
    }

    @Override
    public SmsStatus getResult(ResultSet rs, int i) throws SQLException {
        return SmsStatus.codeOf(rs.getInt(i));
    }

    @Override
    public SmsStatus getResult(CallableStatement cs, int i) throws SQLException {
        return SmsStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, SmsStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
