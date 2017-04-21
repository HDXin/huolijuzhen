package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.ContractStatus;


public class ContractStatusHandler implements TypeHandler<ContractStatus> {

    @Override
    public ContractStatus getResult(ResultSet rs, String column) throws SQLException {
        return ContractStatus.codeOf(rs.getInt(column));
    }

    @Override
    public ContractStatus getResult(ResultSet rs, int i) throws SQLException {
        return ContractStatus.codeOf(rs.getInt(i));
    }

    @Override
    public ContractStatus getResult(CallableStatement cs, int i) throws SQLException {
        return ContractStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, ContractStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
