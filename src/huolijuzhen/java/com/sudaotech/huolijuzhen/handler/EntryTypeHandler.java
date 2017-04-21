package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.EntryType;


public class EntryTypeHandler implements TypeHandler<EntryType> {

    @Override
    public EntryType getResult(ResultSet rs, String column) throws SQLException {
        return EntryType.codeOf(rs.getInt(column));
    }

    @Override
    public EntryType getResult(ResultSet rs, int i) throws SQLException {
        return EntryType.codeOf(rs.getInt(i));
    }

    @Override
    public EntryType getResult(CallableStatement cs, int i) throws SQLException {
        return EntryType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, EntryType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
