package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TreatmentStatus;


public class TreatmentStatusHandler implements TypeHandler<TreatmentStatus> {

    @Override
    public TreatmentStatus getResult(ResultSet rs, String column) throws SQLException {
        return TreatmentStatus.codeOf(rs.getInt(column));
    }

    @Override
    public TreatmentStatus getResult(ResultSet rs, int i) throws SQLException {
        return TreatmentStatus.codeOf(rs.getInt(i));
    }

    @Override
    public TreatmentStatus getResult(CallableStatement cs, int i) throws SQLException {
        return TreatmentStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TreatmentStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
