package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupInfoEntityExample;
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

public interface ParkGroupInfoEntityMapper {
    @SelectProvider(type=ParkGroupInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ParkGroupInfoEntityExample example);

    @DeleteProvider(type=ParkGroupInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkGroupInfoEntityExample example);

    @Delete({
        "delete from park_group_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into park_group_info (id, name, ",
        "contacts, mobilePhone, ",
        "closeBy, closeTime, ",
        "enableStatus, startBy, ",
        "startTime, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{contacts,jdbcType=VARCHAR}, #{mobilePhone,jdbcType=VARCHAR}, ",
        "#{closeBy,jdbcType=BIGINT}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{enableStatus,jdbcType=INTEGER}, #{startBy,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ParkGroupInfoEntity record);

    @InsertProvider(type=ParkGroupInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ParkGroupInfoEntity record);

    @SelectProvider(type=ParkGroupInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupInfoEntity> selectByExampleWithRowbounds(ParkGroupInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ParkGroupInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupInfoEntity> selectByExample(ParkGroupInfoEntityExample example);

    @Select({
        "select",
        "id, name, contacts, mobilePhone, closeBy, closeTime, enableStatus, startBy, ",
        "startTime, version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from park_group_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobilePhone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkGroupInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkGroupInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkGroupInfoEntity record, @Param("example") ParkGroupInfoEntityExample example);

    @UpdateProvider(type=ParkGroupInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkGroupInfoEntity record, @Param("example") ParkGroupInfoEntityExample example);

    @UpdateProvider(type=ParkGroupInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkGroupInfoEntity record);

    @Update({
        "update park_group_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "contacts = #{contacts,jdbcType=VARCHAR},",
          "mobilePhone = #{mobilePhone,jdbcType=VARCHAR},",
          "closeBy = #{closeBy,jdbcType=BIGINT},",
          "closeTime = #{closeTime,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "startBy = #{startBy,jdbcType=BIGINT},",
          "startTime = #{startTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkGroupInfoEntity record);
}