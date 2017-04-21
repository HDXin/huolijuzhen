package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ImageType;

public class ImageTypeHandler implements TypeHandler<ImageType> {

    @Override
    public ImageType getResult(ResultSet rs, String column) throws SQLException {
        return ImageType.codeOf(rs.getInt(column));
    }

    @Override
    public ImageType getResult(ResultSet rs, int i) throws SQLException {
        return ImageType.codeOf(rs.getInt(i));
    }

    @Override
    public ImageType getResult(CallableStatement cs, int i) throws SQLException {
        return ImageType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ImageType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }
}
