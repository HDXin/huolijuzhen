package com.sudaotech.huolijuzhen.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.sudaotech.huolijuzhen.enums.TaskStatus;


public class TaskStatusHandler implements TypeHandler<TaskStatus> {

    @Override
    public TaskStatus getResult(ResultSet rs, String column) throws SQLException {
        return TaskStatus.codeOf(rs.getInt(column));
    }

    @Override
    public TaskStatus getResult(ResultSet rs, int i) throws SQLException {
        return TaskStatus.codeOf(rs.getInt(i));
    }

    @Override
    public TaskStatus getResult(CallableStatement cs, int i) throws SQLException {
        return TaskStatus.codeOf(cs.getInt(i));
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, TaskStatus param, JdbcType jdbcType) throws SQLException {
        ps.setByte(i, (byte)param.code());
    }

}
