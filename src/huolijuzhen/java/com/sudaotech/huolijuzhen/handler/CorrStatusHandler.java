package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import com.sudaotech.huolijuzhen.enums.CorrStatus;


public class CorrStatusHandler implements TypeHandler<CorrStatus> {

    @Override
    public CorrStatus getResult(ResultSet rs, String column) throws SQLException {
        return CorrStatus.codeOf(rs.getInt(column));
    }

    @Override
    public CorrStatus getResult(ResultSet rs, int i) throws SQLException {
        return CorrStatus.codeOf(rs.getInt(i));
    }

    @Override
    public CorrStatus getResult(CallableStatement cs, int i) throws SQLException {
        return CorrStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CorrStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
