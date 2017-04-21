package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TransactionType;


public class TransactionTypeHandler implements TypeHandler<TransactionType> {

    @Override
    public TransactionType getResult(ResultSet rs, String column) throws SQLException {
        return TransactionType.codeOf(rs.getInt(column));
    }

    @Override
    public TransactionType getResult(ResultSet rs, int i) throws SQLException {
        return TransactionType.codeOf(rs.getInt(i));
    }

    @Override
    public TransactionType getResult(CallableStatement cs, int i) throws SQLException {
        return TransactionType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TransactionType param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
