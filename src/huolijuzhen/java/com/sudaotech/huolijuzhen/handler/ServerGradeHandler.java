package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ServerGrade;



public class ServerGradeHandler implements TypeHandler<ServerGrade> {

    @Override
    public ServerGrade getResult(ResultSet rs, String column) throws SQLException {
        return ServerGrade.codeOf(rs.getInt(column));
    }

    @Override
    public ServerGrade getResult(ResultSet rs, int i) throws SQLException {
        return ServerGrade.codeOf(rs.getInt(i));
    }

    @Override
    public ServerGrade getResult(CallableStatement cs, int i) throws SQLException {
        return ServerGrade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ServerGrade param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
