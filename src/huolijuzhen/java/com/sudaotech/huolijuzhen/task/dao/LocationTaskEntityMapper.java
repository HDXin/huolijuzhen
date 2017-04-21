package com.sudaotech.huolijuzhen.task.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.task.service.TaskService.Query;
import com.sudaotech.huolijuzhen.task.service.TaskService.Task;

public interface LocationTaskEntityMapper extends TaskEntityMapper {
	
	@SelectProvider(type=LocationTaskSqlProvider.class,method="findByEquPlanIds")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="operator",property="operator"),
		@Result(column="operatorTime",property="operatorTime"),
		@Result(column="taskStatus",property="taskStatus"),
		@Result(column="operatorMemo",property="operatorMemo"),
		@Result(column="taskType", property="taskType", jdbcType=JdbcType.INTEGER)
	})
	public List<Map<String, Object>> findTaskByEquPlanIds(Map<String, Object> params);
	
	
	@SelectProvider(type=LocationTaskSqlProvider.class,method="findByConfigCount")
	public Integer findByConfigCount(Query query);
	
	
	@SelectProvider(type=LocationTaskSqlProvider.class,method="findByConfig")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="taskType", property="taskType", jdbcType=JdbcType.INTEGER),
        @Result(column="equPlanId", property="equPlanId", jdbcType=JdbcType.BIGINT),
        @Result(column="equId", property="equId", jdbcType=JdbcType.BIGINT),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="taskStatus", property="taskStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="isAdjust", property="isAdjust", jdbcType=JdbcType.BIT),
        @Result(column="adjustBy", property="adjustBy", jdbcType=JdbcType.BIGINT),
        @Result(column="adjustTime", property="adjustTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="adjustMemo", property="adjustMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator", property="operator", jdbcType=JdbcType.BIGINT),
        @Result(column="operatorMemo", property="operatorMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="operatorTime", property="operatorTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="payWay", property="payWay", jdbcType=JdbcType.INTEGER),
        @Result(column="executor", property="executor", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="allBy", property="allBy", jdbcType=JdbcType.BIGINT),
        @Result(column="allTime", property="allTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="hasCost", property="hasCost", jdbcType=JdbcType.BIT),
        @Result(column="costIsVerify", property="costIsVerify", jdbcType=JdbcType.BIT),
        @Result(column="taskCost", property="taskCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="verifyBy", property="verifyBy", jdbcType=JdbcType.BIGINT),
        @Result(column="veribyTime", property="veribyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="veribyMemo", property="veribyMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="isComment", property="isComment", jdbcType=JdbcType.BIT),
        @Result(column="commentBy", property="commentBy", jdbcType=JdbcType.BIGINT),
        @Result(column="commentTime", property="commentTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="commentGrade", property="commentGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="commentContent", property="commentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="commentStarGrade", property="commentStarGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="updateMemo", property="updateMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="history", property="history", jdbcType=JdbcType.VARCHAR)
    })
	public List<Task> findByConfig(Query query);
	
	@SelectProvider(type=LocationTaskSqlProvider.class,method="statisticsTask")
	public List<Map<String, Object>> statisticsTask(Map<String, Object> params);
}