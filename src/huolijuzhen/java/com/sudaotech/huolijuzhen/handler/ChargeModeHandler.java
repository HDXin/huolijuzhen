package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ChargeMode;


public class ChargeModeHandler implements TypeHandler<ChargeMode> {

    @Override
    public ChargeMode getResult(ResultSet rs, String column) throws SQLException {
        return ChargeMode.codeOf(rs.getInt(column));
    }

    @Override
    public ChargeMode getResult(ResultSet rs, int i) throws SQLException {
        return ChargeMode.codeOf(rs.getInt(i));
    }

    @Override
    public ChargeMode getResult(CallableStatement cs, int i) throws SQLException {
        return ChargeMode.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ChargeMode param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
