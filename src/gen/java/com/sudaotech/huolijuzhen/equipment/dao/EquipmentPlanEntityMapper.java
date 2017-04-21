package com.sudaotech.huolijuzhen.equipment.dao;

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

public interface EquipmentPlanEntityMapper {
    @SelectProvider(type=EquipmentPlanEntitySqlProvider.class, method="countByExample")
    int countByExample(EquipmentPlanEntityExample example);

    @DeleteProvider(type=EquipmentPlanEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EquipmentPlanEntityExample example);

    @Delete({
        "delete from equipment_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into equipment_plan (id, equId, ",
        "equCode, equName, ",
        "equTypeId, upkeepTime, ",
        "equTypeName, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "planStatus, assignerId, ",
        "assignerTime, planExecutorDate, ",
        "deleteBy, deleteTime, ",
        "deleteMemo, enableStatus, ",
        "description)",
        "values (#{id,jdbcType=BIGINT}, #{equId,jdbcType=BIGINT}, ",
        "#{equCode,jdbcType=VARCHAR}, #{equName,jdbcType=VARCHAR}, ",
        "#{equTypeId,jdbcType=BIGINT}, #{upkeepTime,jdbcType=TIMESTAMP}, ",
        "#{equTypeName,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{planStatus,jdbcType=INTEGER}, #{assignerId,jdbcType=BIGINT}, ",
        "#{assignerTime,jdbcType=TIMESTAMP}, #{planExecutorDate,jdbcType=DATE}, ",
        "#{deleteBy,jdbcType=BIGINT}, #{deleteTime,jdbcType=TIMESTAMP}, ",
        "#{deleteMemo,jdbcType=VARCHAR}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    int insert(EquipmentPlanEntity record);

    @InsertProvider(type=EquipmentPlanEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EquipmentPlanEntity record);

    @SelectProvider(type=EquipmentPlanEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="equId", property="equId", jdbcType=JdbcType.BIGINT),
        @Result(column="equCode", property="equCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="equName", property="equName", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="upkeepTime", property="upkeepTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planStatus", property="planStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="assignerId", property="assignerId", jdbcType=JdbcType.BIGINT),
        @Result(column="assignerTime", property="assignerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planExecutorDate", property="planExecutorDate", jdbcType=JdbcType.DATE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteMemo", property="deleteMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<EquipmentPlanEntity> selectByExampleWithRowbounds(EquipmentPlanEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EquipmentPlanEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="equId", property="equId", jdbcType=JdbcType.BIGINT),
        @Result(column="equCode", property="equCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="equName", property="equName", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="upkeepTime", property="upkeepTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planStatus", property="planStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="assignerId", property="assignerId", jdbcType=JdbcType.BIGINT),
        @Result(column="assignerTime", property="assignerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planExecutorDate", property="planExecutorDate", jdbcType=JdbcType.DATE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteMemo", property="deleteMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<EquipmentPlanEntity> selectByExample(EquipmentPlanEntityExample example);

    @Select({
        "select",
        "id, equId, equCode, equName, equTypeId, upkeepTime, equTypeName, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate, planStatus, assignerId, ",
        "assignerTime, planExecutorDate, deleteBy, deleteTime, deleteMemo, enableStatus, ",
        "description",
        "from equipment_plan",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="equId", property="equId", jdbcType=JdbcType.BIGINT),
        @Result(column="equCode", property="equCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="equName", property="equName", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="upkeepTime", property="upkeepTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planStatus", property="planStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="assignerId", property="assignerId", jdbcType=JdbcType.BIGINT),
        @Result(column="assignerTime", property="assignerTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="planExecutorDate", property="planExecutorDate", jdbcType=JdbcType.DATE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteMemo", property="deleteMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    EquipmentPlanEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EquipmentPlanEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EquipmentPlanEntity record, @Param("example") EquipmentPlanEntityExample example);

    @UpdateProvider(type=EquipmentPlanEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EquipmentPlanEntity record, @Param("example") EquipmentPlanEntityExample example);

    @UpdateProvider(type=EquipmentPlanEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EquipmentPlanEntity record);

    @Update({
        "update equipment_plan",
        "set equId = #{equId,jdbcType=BIGINT},",
          "equCode = #{equCode,jdbcType=VARCHAR},",
          "equName = #{equName,jdbcType=VARCHAR},",
          "equTypeId = #{equTypeId,jdbcType=BIGINT},",
          "upkeepTime = #{upkeepTime,jdbcType=TIMESTAMP},",
          "equTypeName = #{equTypeName,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "planStatus = #{planStatus,jdbcType=INTEGER},",
          "assignerId = #{assignerId,jdbcType=BIGINT},",
          "assignerTime = #{assignerTime,jdbcType=TIMESTAMP},",
          "planExecutorDate = #{planExecutorDate,jdbcType=DATE},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "deleteMemo = #{deleteMemo,jdbcType=VARCHAR},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EquipmentPlanEntity record);
}