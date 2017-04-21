package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntity;
import com.sudaotech.huolijuzhen.dao.UnitTierInfoEntityExample;
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

public interface UnitTierInfoEntityMapper {
    @SelectProvider(type=UnitTierInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(UnitTierInfoEntityExample example);

    @DeleteProvider(type=UnitTierInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(UnitTierInfoEntityExample example);

    @Delete({
        "delete from unit_tier_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into unit_tier_info (id, name, ",
        "code, isBase, tierNum, ",
        "resInfoId, resInfoName, ",
        "enableStatus, gardenId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, startBy, ",
        "startTime, closeBy, ",
        "closeTime)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{isBase,jdbcType=BIT}, #{tierNum,jdbcType=INTEGER}, ",
        "#{resInfoId,jdbcType=BIGINT}, #{resInfoName,jdbcType=VARCHAR}, ",
        "#{enableStatus,jdbcType=INTEGER}, #{gardenId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{startBy,jdbcType=BIGINT}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{closeBy,jdbcType=BIGINT}, ",
        "#{closeTime,jdbcType=TIMESTAMP})"
    })
    int insert(UnitTierInfoEntity record);

    @InsertProvider(type=UnitTierInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(UnitTierInfoEntity record);

    @SelectProvider(type=UnitTierInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="isBase", property="isBase", jdbcType=JdbcType.BIT),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="resInfoName", property="resInfoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UnitTierInfoEntity> selectByExampleWithRowbounds(UnitTierInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=UnitTierInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="isBase", property="isBase", jdbcType=JdbcType.BIT),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="resInfoName", property="resInfoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UnitTierInfoEntity> selectByExample(UnitTierInfoEntityExample example);

    @Select({
        "select",
        "id, name, code, isBase, tierNum, resInfoId, resInfoName, enableStatus, gardenId, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, startBy, ",
        "startTime, closeBy, closeTime",
        "from unit_tier_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="isBase", property="isBase", jdbcType=JdbcType.BIT),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="resInfoName", property="resInfoName", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="startBy", property="startBy", jdbcType=JdbcType.BIGINT),
        @Result(column="startTime", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="closeBy", property="closeBy", jdbcType=JdbcType.BIGINT),
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UnitTierInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=UnitTierInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UnitTierInfoEntity record, @Param("example") UnitTierInfoEntityExample example);

    @UpdateProvider(type=UnitTierInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UnitTierInfoEntity record, @Param("example") UnitTierInfoEntityExample example);

    @UpdateProvider(type=UnitTierInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UnitTierInfoEntity record);

    @Update({
        "update unit_tier_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "isBase = #{isBase,jdbcType=BIT},",
          "tierNum = #{tierNum,jdbcType=INTEGER},",
          "resInfoId = #{resInfoId,jdbcType=BIGINT},",
          "resInfoName = #{resInfoName,jdbcType=VARCHAR},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "gardenId = #{gardenId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "startBy = #{startBy,jdbcType=BIGINT},",
          "startTime = #{startTime,jdbcType=TIMESTAMP},",
          "closeBy = #{closeBy,jdbcType=BIGINT},",
          "closeTime = #{closeTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UnitTierInfoEntity record);
}