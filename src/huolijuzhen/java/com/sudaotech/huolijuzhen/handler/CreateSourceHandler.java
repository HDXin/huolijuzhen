package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.CreateSource;


public class CreateSourceHandler implements TypeHandler<CreateSource> {

    @Override
    public CreateSource getResult(ResultSet rs, String column) throws SQLException {
        return CreateSource.codeOf(rs.getInt(column));
    }

    @Override
    public CreateSource getResult(ResultSet rs, int i) throws SQLException {
        return CreateSource.codeOf(rs.getInt(i));
    }

    @Override
    public CreateSource getResult(CallableStatement cs, int i) throws SQLException {
        return CreateSource.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CreateSource param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
