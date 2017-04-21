package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.CorrType;


public class CorrTypeHandler implements TypeHandler<CorrType> {

    @Override
    public CorrType getResult(ResultSet rs, String column) throws SQLException {
        return CorrType.codeOf(rs.getInt(column));
    }

    @Override
    public CorrType getResult(ResultSet rs, int i) throws SQLException {
        return CorrType.codeOf(rs.getInt(i));
    }

    @Override
    public CorrType getResult(CallableStatement cs, int i) throws SQLException {
        return CorrType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CorrType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
