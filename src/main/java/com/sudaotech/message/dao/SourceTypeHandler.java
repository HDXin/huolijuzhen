package com.sudaotech.message.dao;

import com.sudaotech.message.SourceType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SourceTypeHandler implements TypeHandler<SourceType> {

    @Override
    public SourceType getResult(ResultSet rs, String column) throws SQLException {
        return SourceType.codeOf(rs.getInt(column));
    }

    @Override
    public SourceType getResult(ResultSet rs, int i) throws SQLException {
        return SourceType.codeOf(rs.getInt(i));
    }

    @Override
    public SourceType getResult(CallableStatement cs, int i) throws SQLException {
        return SourceType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, SourceType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) param.code());
    }

}
