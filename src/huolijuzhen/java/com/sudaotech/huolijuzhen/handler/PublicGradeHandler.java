package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.PublicGrade;

public class PublicGradeHandler implements TypeHandler<PublicGrade> {

    @Override
    public PublicGrade getResult(ResultSet rs, String column) throws SQLException {
        return PublicGrade.codeOf(rs.getInt(column));
    }

    @Override
    public PublicGrade getResult(ResultSet rs, int i) throws SQLException {
        return PublicGrade.codeOf(rs.getInt(i));
    }

    @Override
    public PublicGrade getResult(CallableStatement cs, int i) throws SQLException {
        return PublicGrade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, PublicGrade param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
