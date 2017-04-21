package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.ApplyOrderStatus;

public class ApplyOrderStatusHandler implements TypeHandler<ApplyOrderStatus> {

    @Override
    public ApplyOrderStatus getResult(ResultSet rs, String column) throws SQLException {
        return ApplyOrderStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ApplyOrderStatus getResult(ResultSet rs, int i) throws SQLException {
        return ApplyOrderStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ApplyOrderStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ApplyOrderStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ApplyOrderStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
