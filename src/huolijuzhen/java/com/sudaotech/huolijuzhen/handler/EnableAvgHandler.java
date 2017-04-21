package com.sudaotech.huolijuzhen.handler;

import com.sudaotech.huolijuzhen.enums.EnableAvg;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnableAvgHandler implements TypeHandler<EnableAvg> {

    @Override
    public EnableAvg getResult(ResultSet rs, String column) throws SQLException {
        return EnableAvg.codeOf(rs.getInt(column));
    }

    @Override
    public EnableAvg getResult(ResultSet rs, int i) throws SQLException {
        return EnableAvg.codeOf(rs.getInt(i));
    }

    @Override
    public EnableAvg getResult(CallableStatement cs, int i) throws SQLException {
        return EnableAvg.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, EnableAvg param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) param.code());
    }

}
