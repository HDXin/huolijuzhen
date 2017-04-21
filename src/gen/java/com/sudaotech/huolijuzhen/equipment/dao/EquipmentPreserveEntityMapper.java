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

public interface EquipmentPreserveEntityMapper {
    @SelectProvider(type=EquipmentPreserveEntitySqlProvider.class, method="countByExample")
    int countByExample(EquipmentPreserveEntityExample example);

    @DeleteProvider(type=EquipmentPreserveEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EquipmentPreserveEntityExample example);

    @Delete({
        "delete from equ_pre_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into equ_pre_info (id, name, ",
        "preCycle, cycleType, ",
        "parkId, code, equTypeId, ",
        "equTypeName, preObj, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, enableStatus, ",
        "enableDate, enableBy, ",
        "enableTime, disableBy, ",
        "disableTime, isEnablePlan)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{preCycle,jdbcType=INTEGER}, #{cycleType,jdbcType=INTEGER}, ",
        "#{parkId,jdbcType=BIGINT}, #{code,jdbcType=VARCHAR}, #{equTypeId,jdbcType=BIGINT}, ",
        "#{equTypeName,jdbcType=VARCHAR}, #{preObj,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableDate,jdbcType=DATE}, #{enableBy,jdbcType=BIGINT}, ",
        "#{enableTime,jdbcType=TIMESTAMP}, #{disableBy,jdbcType=BIGINT}, ",
        "#{disableTime,jdbcType=TIMESTAMP}, #{isEnablePlan,jdbcType=BIT})"
    })
    int insert(EquipmentPreserveEntity record);

    @InsertProvider(type=EquipmentPreserveEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EquipmentPreserveEntity record);

    @SelectProvider(type=EquipmentPreserveEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="preCycle", property="preCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="cycleType", property="cycleType", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="preObj", property="preObj", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableDate", property="enableDate", jdbcType=JdbcType.DATE),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isEnablePlan", property="isEnablePlan", jdbcType=JdbcType.BIT)
    })
    List<EquipmentPreserveEntity> selectByExampleWithRowbounds(EquipmentPreserveEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EquipmentPreserveEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="preCycle", property="preCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="cycleType", property="cycleType", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="preObj", property="preObj", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableDate", property="enableDate", jdbcType=JdbcType.DATE),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isEnablePlan", property="isEnablePlan", jdbcType=JdbcType.BIT)
    })
    List<EquipmentPreserveEntity> selectByExample(EquipmentPreserveEntityExample example);

    @Select({
        "select",
        "id, name, preCycle, cycleType, parkId, code, equTypeId, equTypeName, preObj, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, enableStatus, ",
        "enableDate, enableBy, enableTime, disableBy, disableTime, isEnablePlan",
        "from equ_pre_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="preCycle", property="preCycle", jdbcType=JdbcType.INTEGER),
        @Result(column="cycleType", property="cycleType", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="equTypeId", property="equTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="equTypeName", property="equTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="preObj", property="preObj", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableDate", property="enableDate", jdbcType=JdbcType.DATE),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="isEnablePlan", property="isEnablePlan", jdbcType=JdbcType.BIT)
    })
    EquipmentPreserveEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EquipmentPreserveEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EquipmentPreserveEntity record, @Param("example") EquipmentPreserveEntityExample example);

    @UpdateProvider(type=EquipmentPreserveEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EquipmentPreserveEntity record, @Param("example") EquipmentPreserveEntityExample example);

    @UpdateProvider(type=EquipmentPreserveEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EquipmentPreserveEntity record);

    @Update({
        "update equ_pre_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "preCycle = #{preCycle,jdbcType=INTEGER},",
          "cycleType = #{cycleType,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "code = #{code,jdbcType=VARCHAR},",
          "equTypeId = #{equTypeId,jdbcType=BIGINT},",
          "equTypeName = #{equTypeName,jdbcType=VARCHAR},",
          "preObj = #{preObj,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableDate = #{enableDate,jdbcType=DATE},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP},",
          "isEnablePlan = #{isEnablePlan,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EquipmentPreserveEntity record);
}