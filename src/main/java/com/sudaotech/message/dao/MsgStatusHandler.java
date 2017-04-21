package com.sudaotech.message.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.message.MsgStatus;


public class MsgStatusHandler implements TypeHandler<MsgStatus> {

    @Override
    public MsgStatus getResult(ResultSet rs, String column) throws SQLException {
        return MsgStatus.codeOf(rs.getInt(column));
    }

    @Override
    public MsgStatus getResult(ResultSet rs, int i) throws SQLException {
        return MsgStatus.codeOf(rs.getInt(i));
    }

    @Override
    public MsgStatus getResult(CallableStatement cs, int i) throws SQLException {
        return MsgStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, MsgStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
