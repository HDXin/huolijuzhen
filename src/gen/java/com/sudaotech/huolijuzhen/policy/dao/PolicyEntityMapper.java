package com.sudaotech.huolijuzhen.policy.dao;

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

public interface PolicyEntityMapper {
    @SelectProvider(type=PolicyEntitySqlProvider.class, method="countByExample")
    int countByExample(PolicyEntityExample example);

    @DeleteProvider(type=PolicyEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(PolicyEntityExample example);

    @Delete({
        "delete from policy_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into policy_info (id, title, ",
        "polUri, publicGrade, ",
        "parkId, proId, cityId, ",
        "counId, locationId, ",
        "approvalStatus, approvalBy, ",
        "approvalTime, approvalText, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, createSide, ",
        "createSideId, readNum)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{polUri,jdbcType=VARCHAR}, #{publicGrade,jdbcType=INTEGER}, ",
        "#{parkId,jdbcType=BIGINT}, #{proId,jdbcType=BIGINT}, #{cityId,jdbcType=BIGINT}, ",
        "#{counId,jdbcType=BIGINT}, #{locationId,jdbcType=BIGINT}, ",
        "#{approvalStatus,jdbcType=INTEGER}, #{approvalBy,jdbcType=BIGINT}, ",
        "#{approvalTime,jdbcType=TIMESTAMP}, #{approvalText,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{createSide,jdbcType=INTEGER}, ",
        "#{createSideId,jdbcType=BIGINT}, #{readNum,jdbcType=INTEGER})"
    })
    int insert(PolicyEntity record);

    @InsertProvider(type=PolicyEntitySqlProvider.class, method="insertSelective")
    int insertSelective(PolicyEntity record);

    @SelectProvider(type=PolicyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="polUri", property="polUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER)
    })
    List<PolicyEntity> selectByExampleWithRowbounds(PolicyEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=PolicyEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="polUri", property="polUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER)
    })
    List<PolicyEntity> selectByExample(PolicyEntityExample example);

    @Select({
        "select",
        "id, title, polUri, publicGrade, parkId, proId, cityId, counId, locationId, approvalStatus, ",
        "approvalBy, approvalTime, approvalText, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate, createSide, createSideId, readNum",
        "from policy_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="polUri", property="polUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER)
    })
    PolicyEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=PolicyEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PolicyEntity record, @Param("example") PolicyEntityExample example);

    @UpdateProvider(type=PolicyEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PolicyEntity record, @Param("example") PolicyEntityExample example);

    @UpdateProvider(type=PolicyEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PolicyEntity record);

    @Update({
        "update policy_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "polUri = #{polUri,jdbcType=VARCHAR},",
          "publicGrade = #{publicGrade,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "proId = #{proId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "counId = #{counId,jdbcType=BIGINT},",
          "locationId = #{locationId,jdbcType=BIGINT},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "readNum = #{readNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PolicyEntity record);
}