package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.CommentGrade;


public class CommentGradeHandler implements TypeHandler<CommentGrade> {

    @Override
    public CommentGrade getResult(ResultSet rs, String column) throws SQLException {
        return CommentGrade.codeOf(rs.getInt(column));
    }

    @Override
    public CommentGrade getResult(ResultSet rs, int i) throws SQLException {
        return CommentGrade.codeOf(rs.getInt(i));
    }

    @Override
    public CommentGrade getResult(CallableStatement cs, int i) throws SQLException {
        return CommentGrade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CommentGrade param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
