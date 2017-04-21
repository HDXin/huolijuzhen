package com.sudaotech.message.dao;

import com.sudaotech.message.MsgType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MsgTypeHandler implements TypeHandler<MsgType> {

    @Override
    public MsgType getResult(ResultSet rs, String column) throws SQLException {
        return MsgType.codeOf(rs.getInt(column));
    }

    @Override
    public MsgType getResult(ResultSet rs, int i) throws SQLException {
        return MsgType.codeOf(rs.getInt(i));
    }

    @Override
    public MsgType getResult(CallableStatement cs, int i) throws SQLException {
        return MsgType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, MsgType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) param.code());
    }

}
