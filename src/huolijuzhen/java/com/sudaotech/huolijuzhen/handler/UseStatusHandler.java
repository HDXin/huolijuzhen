package com.sudaotech.huolijuzhen.handler;

import com.sudaotech.huolijuzhen.enums.UseStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UseStatusHandler implements TypeHandler<UseStatus> {

    @Override
    public UseStatus getResult(ResultSet rs, String column) throws SQLException {
        return UseStatus.codeOf(rs.getInt(column));
    }

    @Override
    public UseStatus getResult(ResultSet rs, int i) throws SQLException {
        return UseStatus.codeOf(rs.getInt(i));
    }

    @Override
    public UseStatus getResult(CallableStatement cs, int i) throws SQLException {
        return UseStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, UseStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) param.code());
    }

}
