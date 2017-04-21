package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ResInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResInfoEntityExample;
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

public interface ResInfoEntityMapper {
    @SelectProvider(type=ResInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ResInfoEntityExample example);

    @DeleteProvider(type=ResInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ResInfoEntityExample example);

    @Delete({
        "delete from res_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into res_info (id, name, ",
        "code, resType, enableStatus, ",
        "gardenId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "startBy, startTime, ",
        "closeBy, closeTime, ",
        "calcDimension, enableAvg)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{resType,jdbcType=INTEGER}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{gardenId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{startBy,jdbcType=BIGINT}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{closeBy,jdbcType=BIGINT}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{calcDimension,jdbcType=INTEGER}, #{enableAvg,jdbcType=INTEGER})"
    })
    int insert(ResInfoEntity record);

    @InsertProvider(type=ResInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ResInfoEntity record);

    @SelectProvider(type=ResInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="resType", property="resType", jdbcType=JdbcType.INTEGER),
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
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="calcDimension", property="calcDimension", jdbcType=JdbcType.INTEGER),
        @Result(column="enableAvg", property="enableAvg", jdbcType=JdbcType.INTEGER)
    })
    List<ResInfoEntity> selectByExampleWithRowbounds(ResInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ResInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="resType", property="resType", jdbcType=JdbcType.INTEGER),
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
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="calcDimension", property="calcDimension", jdbcType=JdbcType.INTEGER),
        @Result(column="enableAvg", property="enableAvg", jdbcType=JdbcType.INTEGER)
    })
    List<ResInfoEntity> selectByExample(ResInfoEntityExample example);

    @Select({
        "select",
        "id, name, code, resType, enableStatus, gardenId, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, startBy, startTime, closeBy, closeTime, ",
        "calcDimension, enableAvg",
        "from res_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="resType", property="resType", jdbcType=JdbcType.INTEGER),
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
        @Result(column="closeTime", property="closeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="calcDimension", property="calcDimension", jdbcType=JdbcType.INTEGER),
        @Result(column="enableAvg", property="enableAvg", jdbcType=JdbcType.INTEGER)
    })
    ResInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ResInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResInfoEntity record, @Param("example") ResInfoEntityExample example);

    @UpdateProvider(type=ResInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResInfoEntity record, @Param("example") ResInfoEntityExample example);

    @UpdateProvider(type=ResInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResInfoEntity record);

    @Update({
        "update res_info",
        "set name = #{name,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "resType = #{resType,jdbcType=INTEGER},",
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
          "closeTime = #{closeTime,jdbcType=TIMESTAMP},",
          "calcDimension = #{calcDimension,jdbcType=INTEGER},",
          "enableAvg = #{enableAvg,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResInfoEntity record);
}