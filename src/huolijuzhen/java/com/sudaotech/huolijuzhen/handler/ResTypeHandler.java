package com.sudaotech.huolijuzhen.handler;

import com.sudaotech.huolijuzhen.enums.ResType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ResTypeHandler implements TypeHandler<ResType> {

    @Override
    public ResType getResult(ResultSet rs, String column) throws SQLException {
        return ResType.codeOf(rs.getInt(column));
    }

    @Override
    public ResType getResult(ResultSet rs, int i) throws SQLException {
        return ResType.codeOf(rs.getInt(i));
    }

    @Override
    public ResType getResult(CallableStatement cs, int i) throws SQLException {
        return ResType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ResType param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
