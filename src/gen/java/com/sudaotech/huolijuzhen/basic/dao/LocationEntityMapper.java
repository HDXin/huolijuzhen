package com.sudaotech.huolijuzhen.basic.dao;

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

public interface LocationEntityMapper {
    @SelectProvider(type=LocationEntitySqlProvider.class, method="countByExample")
    int countByExample(LocationEntityExample example);

    @DeleteProvider(type=LocationEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(LocationEntityExample example);

    @Delete({
        "delete from location_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into location_info (id, proId, ",
        "cityId, counId, business, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, enableStatus, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime)",
        "values (#{id,jdbcType=BIGINT}, #{proId,jdbcType=BIGINT}, ",
        "#{cityId,jdbcType=BIGINT}, #{counId,jdbcType=BIGINT}, #{business,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{enableStatus,jdbcType=INTEGER}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP})"
    })
    int insert(LocationEntity record);

    @InsertProvider(type=LocationEntitySqlProvider.class, method="insertSelective")
    int insertSelective(LocationEntity record);

    @SelectProvider(type=LocationEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="business", property="business", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LocationEntity> selectByExampleWithRowbounds(LocationEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=LocationEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="business", property="business", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LocationEntity> selectByExample(LocationEntityExample example);

    @Select({
        "select",
        "id, proId, cityId, counId, business, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate, enableStatus, enableBy, enableTime, disableBy, ",
        "disableTime",
        "from location_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="business", property="business", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP)
    })
    LocationEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=LocationEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LocationEntity record, @Param("example") LocationEntityExample example);

    @UpdateProvider(type=LocationEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LocationEntity record, @Param("example") LocationEntityExample example);

    @UpdateProvider(type=LocationEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LocationEntity record);

    @Update({
        "update location_info",
        "set proId = #{proId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "counId = #{counId,jdbcType=BIGINT},",
          "business = #{business,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LocationEntity record);
}