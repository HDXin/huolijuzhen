package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.ChooseStatus;


public class ChooseStatusHandler implements TypeHandler<ChooseStatus> {

    @Override
    public ChooseStatus getResult(ResultSet rs, String column) throws SQLException {
        return ChooseStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ChooseStatus getResult(ResultSet rs, int i) throws SQLException {
        return ChooseStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ChooseStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ChooseStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ChooseStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
