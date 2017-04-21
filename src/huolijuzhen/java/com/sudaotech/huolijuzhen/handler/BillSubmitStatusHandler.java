package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.BillSubmitStatus;


public class BillSubmitStatusHandler implements TypeHandler<BillSubmitStatus> {

    @Override
    public BillSubmitStatus getResult(ResultSet rs, String column) throws SQLException {
        return BillSubmitStatus.codeOf(rs.getInt(column));
    }

    @Override
    public BillSubmitStatus getResult(ResultSet rs, int i) throws SQLException {
        return BillSubmitStatus.codeOf(rs.getInt(i));
    }

    @Override
    public BillSubmitStatus getResult(CallableStatement cs, int i) throws SQLException {
        return BillSubmitStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, BillSubmitStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
