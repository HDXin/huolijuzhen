package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TransferSourceType;


public class TransferSourceTypeHandler implements TypeHandler<TransferSourceType> {

    @Override
    public TransferSourceType getResult(ResultSet rs, String column) throws SQLException {
        return TransferSourceType.codeOf(rs.getInt(column));
    }

    @Override
    public TransferSourceType getResult(ResultSet rs, int i) throws SQLException {
        return TransferSourceType.codeOf(rs.getInt(i));
    }

    @Override
    public TransferSourceType getResult(CallableStatement cs, int i) throws SQLException {
        return TransferSourceType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TransferSourceType param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
