package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.CellphoneParams;

public class CellphomeParamsHandler implements TypeHandler<CellphoneParams> {

    @Override
    public CellphoneParams getResult(ResultSet rs, String column) throws SQLException {
        return CellphoneParams.codeOf(rs.getInt(column));
    }

    @Override
    public CellphoneParams getResult(ResultSet rs, int i) throws SQLException {
        return CellphoneParams.codeOf(rs.getInt(i));
    }

    @Override
    public CellphoneParams getResult(CallableStatement cs, int i) throws SQLException {
        return CellphoneParams.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CellphoneParams param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
