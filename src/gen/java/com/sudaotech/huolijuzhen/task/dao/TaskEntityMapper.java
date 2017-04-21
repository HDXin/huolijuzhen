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

public interface TaskEntityMapper {
    @SelectProvider(type=TaskEntitySqlProvider.class, method="countByExample")
    int countByExample(TaskEntityExample example);

    @DeleteProvider(type=TaskEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskEntityExample example);

    @Delete({
        "delete from task_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into task_info (id, title, ",
        "code, taskType, ",
        "equPlanId, equId, ",
        "description, enableStatus, ",
        "taskStatus, isAdjust, ",
        "adjustBy, adjustTime, ",
        "adjustMemo, operator, ",
        "operatorMemo, operatorTime, ",
        "payWay, executor, ",
        "parkId, allBy, allTime, ",
        "closeBy, closeTime, ",
        "version, status, ",
        "createBy, createTime, ",
        "createName, updateBy, ",
        "updateTime, lastUpdate, ",
        "hasCost, costIsVerify, taskCost, ",
        "verifyBy, veribyTime, ",
        "veribyMemo, isComment, ",
        "commentBy, commentTime, ",
        "commentGrade, commentContent, ",
        "commentStarGrade, equTypeId, ",
        "updateMemo, history, ",
        "isChoose, billId)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{taskType,jdbcType=INTEGER}, ",
        "#{equPlanId,jdbcType=BIGINT}, #{equId,jdbcType=BIGINT}, ",
        "#{description,jdbcType=VARCHAR}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{taskStatus,jdbcType=INTEGER}, #{isAdjust,jdbcType=BIT}, ",
        "#{adjustBy,jdbcType=BIGINT}, #{adjustTime,jdbcType=TIMESTAMP}, ",
        "#{adjustMemo,jdbcType=VARCHAR}, #{operator,jdbcType=BIGINT}, ",
        "#{operatorMemo,jdbcType=VARCHAR}, #{operatorTime,jdbcType=TIMESTAMP}, ",
        "#{payWay,jdbcType=INTEGER}, #{executor,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=BIGINT}, #{allBy,jdbcType=BIGINT}, #{allTime,jdbcType=TIMESTAMP}, ",
        "#{closeBy,jdbcType=BIGINT}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createName,jdbcType=VARCHAR}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{hasCost,jdbcType=BIT}, #{costIsVerify,jdbcType=BIT}, #{taskCost,jdbcType=DECIMAL}, ",
        "#{verifyBy,jdbcType=BIGINT}, #{veribyTime,jdbcType=TIMESTAMP}, ",
        "#{veribyMemo,jdbcType=VARCHAR}, #{isComment,jdbcType=BIT}, ",
        "#{commentBy,jdbcType=BIGINT}, #{commentTime,jdbcType=TIMESTAMP}, ",
        "#{commentGrade,jdbcType=INTEGER}, #{commentContent,jdbcType=VARCHAR}, ",
        "#{commentStarGrade,jdbcType=INTEGER}, #{equTypeId,jdbcType=BIGINT}, ",
        "#{updateMemo,jdbcType=VARCHAR}, #{history,jdbcType=VARCHAR}, ",
        "#{isChoose,jdbcType=INTEGER}, #{billId,jdbcType=BIGINT})"
    })
    int insert(TaskEntity record);

    @InsertProvider(type=TaskEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TaskEntity record);

    @SelectProvider(type=TaskEntitySqlProvider.class, method="selectByExample")
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
        @Result(column="history", property="history", jdbcType=JdbcType.VARCHAR),
        @Result(column="isChoose", property="isChoose", jdbcType=JdbcType.INTEGER),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT)
    })
    List<TaskEntity> selectByExampleWithRowbounds(TaskEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TaskEntitySqlProvider.class, method="selectByExample")
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
        @Result(column="history", property="history", jdbcType=JdbcType.VARCHAR),
        @Result(column="isChoose", property="isChoose", jdbcType=JdbcType.INTEGER),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT)
    })
    List<TaskEntity> selectByExample(TaskEntityExample example);

    @Select({
        "select",
        "id, title, code, taskType, equPlanId, equId, description, enableStatus, taskStatus, ",
        "isAdjust, adjustBy, adjustTime, adjustMemo, operator, operatorMemo, operatorTime, ",
        "payWay, executor, parkId, allBy, allTime, closeBy, closeTime, version, status, ",
        "createBy, createTime, createName, updateBy, updateTime, lastUpdate, hasCost, ",
        "costIsVerify, taskCost, verifyBy, veribyTime, veribyMemo, isComment, commentBy, ",
        "commentTime, commentGrade, commentContent, commentStarGrade, equTypeId, updateMemo, ",
        "history, isChoose, billId",
        "from task_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
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
        @Result(column="history", property="history", jdbcType=JdbcType.VARCHAR),
        @Result(column="isChoose", property="isChoose", jdbcType=JdbcType.INTEGER),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT)
    })
    TaskEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=TaskEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    @UpdateProvider(type=TaskEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TaskEntity record, @Param("example") TaskEntityExample example);

    @UpdateProvider(type=TaskEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TaskEntity record);

    @Update({
        "update task_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "taskType = #{taskType,jdbcType=INTEGER},",
          "equPlanId = #{equPlanId,jdbcType=BIGINT},",
          "equId = #{equId,jdbcType=BIGINT},",
          "description = #{description,jdbcType=VARCHAR},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "taskStatus = #{taskStatus,jdbcType=INTEGER},",
          "isAdjust = #{isAdjust,jdbcType=BIT},",
          "adjustBy = #{adjustBy,jdbcType=BIGINT},",
          "adjustTime = #{adjustTime,jdbcType=TIMESTAMP},",
          "adjustMemo = #{adjustMemo,jdbcType=VARCHAR},",
          "operator = #{operator,jdbcType=BIGINT},",
          "operatorMemo = #{operatorMemo,jdbcType=VARCHAR},",
          "operatorTime = #{operatorTime,jdbcType=TIMESTAMP},",
          "payWay = #{payWay,jdbcType=INTEGER},",
          "executor = #{executor,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "allBy = #{allBy,jdbcType=BIGINT},",
          "allTime = #{allTime,jdbcType=TIMESTAMP},",
          "closeBy = #{closeBy,jdbcType=BIGINT},",
          "closeTime = #{closeTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "hasCost = #{hasCost,jdbcType=BIT},",
          "costIsVerify = #{costIsVerify,jdbcType=BIT},",
          "taskCost = #{taskCost,jdbcType=DECIMAL},",
          "verifyBy = #{verifyBy,jdbcType=BIGINT},",
          "veribyTime = #{veribyTime,jdbcType=TIMESTAMP},",
          "veribyMemo = #{veribyMemo,jdbcType=VARCHAR},",
          "isComment = #{isComment,jdbcType=BIT},",
          "commentBy = #{commentBy,jdbcType=BIGINT},",
          "commentTime = #{commentTime,jdbcType=TIMESTAMP},",
          "commentGrade = #{commentGrade,jdbcType=INTEGER},",
          "commentContent = #{commentContent,jdbcType=VARCHAR},",
          "commentStarGrade = #{commentStarGrade,jdbcType=INTEGER},",
          "equTypeId = #{equTypeId,jdbcType=BIGINT},",
          "updateMemo = #{updateMemo,jdbcType=VARCHAR},",
          "history = #{history,jdbcType=VARCHAR},",
          "isChoose = #{isChoose,jdbcType=INTEGER},",
          "billId = #{billId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TaskEntity record);
}