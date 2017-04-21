package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TransDirectionType;


public class TransDirectionTypeHandler implements TypeHandler<TransDirectionType> {

    @Override
    public TransDirectionType getResult(ResultSet rs, String column) throws SQLException {
        return TransDirectionType.codeOf(rs.getInt(column));
    }

    @Override
    public TransDirectionType getResult(ResultSet rs, int i) throws SQLException {
        return TransDirectionType.codeOf(rs.getInt(i));
    }

    @Override
    public TransDirectionType getResult(CallableStatement cs, int i) throws SQLException {
        return TransDirectionType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TransDirectionType param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
