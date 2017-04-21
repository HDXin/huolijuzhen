package com.sudaotech.core.dao.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.core.enums.Type;

public class TypeHandlerImpl implements TypeHandler<Type> {

    @Override
    public Type getResult(ResultSet rs, String column) throws SQLException {
        return Type.codeOf(rs.getInt(column));
    }

    @Override
    public Type getResult(ResultSet rs, int i) throws SQLException {
        return Type.codeOf(rs.getInt(i));
    }

    @Override
    public Type getResult(CallableStatement cs, int i) throws SQLException {
        return Type.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Type param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
