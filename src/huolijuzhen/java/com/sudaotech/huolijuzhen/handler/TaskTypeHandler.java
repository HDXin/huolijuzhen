package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TaskType;


public class TaskTypeHandler implements TypeHandler<TaskType> {

    @Override
    public TaskType getResult(ResultSet rs, String column) throws SQLException {
        return TaskType.codeOf(rs.getInt(column));
    }

    @Override
    public TaskType getResult(ResultSet rs, int i) throws SQLException {
        return TaskType.codeOf(rs.getInt(i));
    }

    @Override
    public TaskType getResult(CallableStatement cs, int i) throws SQLException {
        return TaskType.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TaskType param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
