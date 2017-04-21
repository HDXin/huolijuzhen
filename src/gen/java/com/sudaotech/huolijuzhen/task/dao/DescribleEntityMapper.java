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

public interface DescribleEntityMapper {
    @SelectProvider(type=DescribleEntitySqlProvider.class, method="countByExample")
    int countByExample(DescribleEntityExample example);

    @DeleteProvider(type=DescribleEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(DescribleEntityExample example);

    @Delete({
        "delete from desc_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into desc_info (id, desciption, ",
        "enableStatus, parkId, ",
        "enableBy, enableTime, ",
        "disableBy, disableTime, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, deleteBy, ",
        "deleteTime)",
        "values (#{id,jdbcType=BIGINT}, #{desciption,jdbcType=VARCHAR}, ",
        "#{enableStatus,jdbcType=INTEGER}, #{parkId,jdbcType=BIGINT}, ",
        "#{enableBy,jdbcType=BIGINT}, #{enableTime,jdbcType=TIMESTAMP}, ",
        "#{disableBy,jdbcType=BIGINT}, #{disableTime,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{deleteBy,jdbcType=BIGINT}, ",
        "#{deleteTime,jdbcType=TIMESTAMP})"
    })
    int insert(DescribleEntity record);

    @InsertProvider(type=DescribleEntitySqlProvider.class, method="insertSelective")
    int insertSelective(DescribleEntity record);

    @SelectProvider(type=DescribleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="desciption", property="desciption", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DescribleEntity> selectByExampleWithRowbounds(DescribleEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=DescribleEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="desciption", property="desciption", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DescribleEntity> selectByExample(DescribleEntityExample example);

    @Select({
        "select",
        "id, desciption, enableStatus, parkId, enableBy, enableTime, disableBy, disableTime, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, deleteBy, ",
        "deleteTime",
        "from desc_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="desciption", property="desciption", jdbcType=JdbcType.VARCHAR),
        @Result(column="enableStatus", property="enableStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enableBy", property="enableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="enableTime", property="enableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disableBy", property="disableBy", jdbcType=JdbcType.BIGINT),
        @Result(column="disableTime", property="disableTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP)
    })
    DescribleEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=DescribleEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") DescribleEntity record, @Param("example") DescribleEntityExample example);

    @UpdateProvider(type=DescribleEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") DescribleEntity record, @Param("example") DescribleEntityExample example);

    @UpdateProvider(type=DescribleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DescribleEntity record);

    @Update({
        "update desc_info",
        "set desciption = #{desciption,jdbcType=VARCHAR},",
          "enableStatus = #{enableStatus,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "enableBy = #{enableBy,jdbcType=BIGINT},",
          "enableTime = #{enableTime,jdbcType=TIMESTAMP},",
          "disableBy = #{disableBy,jdbcType=BIGINT},",
          "disableTime = #{disableTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(DescribleEntity record);
}