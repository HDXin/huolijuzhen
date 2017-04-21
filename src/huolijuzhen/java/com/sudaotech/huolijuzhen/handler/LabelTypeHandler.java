package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.LabelType;

public class LabelTypeHandler implements TypeHandler<LabelType> {

    @Override
    public LabelType getResult(ResultSet rs, String column) throws SQLException {
        return LabelType.codeOf(rs.getInt(column));
    }

    @Override
    public LabelType getResult(ResultSet rs, int i) throws SQLException {
        return LabelType.codeOf(rs.getInt(i));
    }

    @Override
    public LabelType getResult(CallableStatement cs, int i) throws SQLException {
        return LabelType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, LabelType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
