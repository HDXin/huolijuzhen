package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.CreateSide;

public class CreateSideHandler implements TypeHandler<CreateSide> {

    @Override
    public CreateSide getResult(ResultSet rs, String column) throws SQLException {
        return CreateSide.codeOf(rs.getInt(column));
    }

    @Override
    public CreateSide getResult(ResultSet rs, int i) throws SQLException {
        return CreateSide.codeOf(rs.getInt(i));
    }

    @Override
    public CreateSide getResult(CallableStatement cs, int i) throws SQLException {
        return CreateSide.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CreateSide param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
