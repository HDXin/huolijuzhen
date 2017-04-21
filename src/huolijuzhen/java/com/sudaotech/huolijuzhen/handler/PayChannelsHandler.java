package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.PayChannels;


public class PayChannelsHandler implements TypeHandler<PayChannels> {

    @Override
    public PayChannels getResult(ResultSet rs, String column) throws SQLException {
        return PayChannels.codeOf(rs.getInt(column));
    }

    @Override
    public PayChannels getResult(ResultSet rs, int i) throws SQLException {
        return PayChannels.codeOf(rs.getInt(i));
    }

    @Override
    public PayChannels getResult(CallableStatement cs, int i) throws SQLException {
        return PayChannels.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PayChannels param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
