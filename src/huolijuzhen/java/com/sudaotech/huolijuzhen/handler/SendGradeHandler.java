package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.SendGrade;


public class SendGradeHandler implements TypeHandler<SendGrade> {

    @Override
    public SendGrade getResult(ResultSet rs, String column) throws SQLException {
        return SendGrade.codeOf(rs.getInt(column));
    }

    @Override
    public SendGrade getResult(ResultSet rs, int i) throws SQLException {
        return SendGrade.codeOf(rs.getInt(i));
    }

    @Override
    public SendGrade getResult(CallableStatement cs, int i) throws SQLException {
        return SendGrade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, SendGrade param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
