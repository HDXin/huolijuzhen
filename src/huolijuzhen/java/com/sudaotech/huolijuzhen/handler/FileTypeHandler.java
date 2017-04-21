package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.FileType;


public class FileTypeHandler implements TypeHandler<FileType> {

    @Override
    public FileType getResult(ResultSet rs, String column) throws SQLException {
        return FileType.codeOf(rs.getInt(column));
    }

    @Override
    public FileType getResult(ResultSet rs, int i) throws SQLException {
        return FileType.codeOf(rs.getInt(i));
    }

    @Override
    public FileType getResult(CallableStatement cs, int i) throws SQLException {
        return FileType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, FileType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
