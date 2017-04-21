package com.sudaotech.huolijuzhen.handler;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.PlanStatus;


public class PlanStatusHandler implements TypeHandler<PlanStatus> {

    @Override
    public PlanStatus getResult(ResultSet rs, String column) throws SQLException {
        return PlanStatus.codeOf(rs.getInt(column));
    }

    @Override
    public PlanStatus getResult(ResultSet rs, int i) throws SQLException {
        return PlanStatus.codeOf(rs.getInt(i));
    }

    @Override
    public PlanStatus getResult(CallableStatement cs, int i) throws SQLException {
        return PlanStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PlanStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
