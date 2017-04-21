package com.sudaotech.message.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.message.MsgBizType;


public class MsgBizTypeHandler implements TypeHandler<MsgBizType> {

    @Override
    public MsgBizType getResult(ResultSet rs, String column) throws SQLException {
        return MsgBizType.codeOf(rs.getInt(column));
    }

    @Override
    public MsgBizType getResult(ResultSet rs, int i) throws SQLException {
        return MsgBizType.codeOf(rs.getInt(i));
    }

    @Override
    public MsgBizType getResult(CallableStatement cs, int i) throws SQLException {
        return MsgBizType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, MsgBizType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
