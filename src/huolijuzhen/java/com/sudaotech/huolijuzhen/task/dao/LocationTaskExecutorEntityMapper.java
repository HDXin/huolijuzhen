package com.sudaotech.huolijuzhen.task.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface LocationTaskExecutorEntityMapper extends TaskExecutorEntityMapper {
    
	@Select("select taskId taskId from task_executor "
			+ "where executorId = #{executorId} and status = #{status}")
	@Results({@Result(column="taskId",property="taskId")})
	public List<Long> findAllTaskByExecutorId(Map<String, Object> params);
	
	@Select("select id id from task_executor "
			+ "where taskId = #{taskId} and status = #{status}")
	@Results({@Result(id=true,column="id",property="id")})
	public List<Long> findAllTaskExecutorByTaskId(Map<String, Object> params);
	
	@Select("select executorId executorId from task_executor "
			+ "where taskId = #{taskId} and status = #{status}")
	@Results({@Result(column="executorId",property="executorId")})
	public List<Long> findAllExecutorByTaskId(Map<String, Object> params);
	
}