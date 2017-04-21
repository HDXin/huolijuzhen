package com.sudaotech.huolijuzhen.handler;

import com.sudaotech.huolijuzhen.enums.CalcDimension;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CalcDimensionHandler implements TypeHandler<CalcDimension> {

    @Override
    public CalcDimension getResult(ResultSet rs, String column) throws SQLException {
        return CalcDimension.codeOf(rs.getInt(column));
    }

    @Override
    public CalcDimension getResult(ResultSet rs, int i) throws SQLException {
        return CalcDimension.codeOf(rs.getInt(i));
    }

    @Override
    public CalcDimension getResult(CallableStatement cs, int i) throws SQLException {
        return CalcDimension.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CalcDimension param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte) param.code());
    }

}
