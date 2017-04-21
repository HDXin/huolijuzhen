package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ServiceGrade;



public class serviceGradeHandler implements TypeHandler<ServiceGrade> {

    @Override
    public ServiceGrade getResult(ResultSet rs, String column) throws SQLException {
        return ServiceGrade.codeOf(rs.getInt(column));
    }

    @Override
    public ServiceGrade getResult(ResultSet rs, int i) throws SQLException {
        return ServiceGrade.codeOf(rs.getInt(i));
    }

    @Override
    public ServiceGrade getResult(CallableStatement cs, int i) throws SQLException {
        return ServiceGrade.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ServiceGrade param, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, param.code());
    }

}
