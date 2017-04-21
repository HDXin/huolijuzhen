package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillConfirmStatus;


public class BillConfirmStatusHandler implements TypeHandler<BillConfirmStatus> {

    @Override
    public BillConfirmStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillConfirmStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillConfirmStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillConfirmStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillConfirmStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillConfirmStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillConfirmStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
