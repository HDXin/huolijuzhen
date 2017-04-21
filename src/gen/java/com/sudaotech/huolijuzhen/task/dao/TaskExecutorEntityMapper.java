package com.sudaotech.huolijuzhen.task.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface TaskExecutorEntityMapper {
    @SelectProvider(type=TaskExecutorEntitySqlProvider.class, method="countByExample")
    int countByExample(TaskExecutorEntityExample example);

    @DeleteProvider(type=TaskExecutorEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskExecutorEntityExample example);

    @Delete({
        "delete from task_executor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_executor (id, taskId, ",
        "executorId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{taskId,jdbcType=BIGINT}, ",
        "#{executorId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TaskExecutorEntity record);

    @InsertProvider(type=TaskExecutorEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TaskExecutorEntity record);

    @SelectProvider(type=TaskExecutorEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="taskId", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskExecutorEntity> selectByExampleWithRowbounds(TaskExecutorEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TaskExecutorEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="taskId", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TaskExecutorEntity> selectByExample(TaskExecutorEntityExample example);

    @Select({
        "select",
        "id, taskId, executorId, version, status, createBy, createTime, updateBy, updateTime, ",
        "lastUpdate",
        "from task_executor",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="taskId", property="taskId", jdbcType=JdbcType.BIGINT),
        @Result(column="executorId", property="executorId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    TaskExecutorEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskExecutorEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskExecutorEntity record, @Param("example") TaskExecutorEntityExample example);

    @UpdateProvider(type=TaskExecutorEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskExecutorEntity record, @Param("example") TaskExecutorEntityExample example);

    @UpdateProvider(type=TaskExecutorEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskExecutorEntity record);

    @Update({
        "update task_executor",
        "set taskId = #{taskId,jdbcType=BIGINT},",
          "executorId = #{executorId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskExecutorEntity record);
}