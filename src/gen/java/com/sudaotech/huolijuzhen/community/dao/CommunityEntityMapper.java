package com.sudaotech.huolijuzhen.community.dao;

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

public interface CommunityEntityMapper {
    @SelectProvider(type=CommunityEntitySqlProvider.class, method="countByExample")
    int countByExample(CommunityEntityExample example);

    @DeleteProvider(type=CommunityEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommunityEntityExample example);

    @Delete({
        "delete from community_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into community_info (id, title, ",
        "discrible, time, ",
        "publicGrade, parkId, ",
        "proId, cityId, counId, ",
        "locationId, approvalStatus, ",
        "version, status, ",
        "approvalBy, approvalTime, ",
        "approvalMemo, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "deleteBy, deleteTime, ",
        "createSide, createSideId, ",
        "terminateBy, terminateTime, ",
        "content, operatorHistory)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{discrible,jdbcType=VARCHAR}, #{time,jdbcType=TIMESTAMP}, ",
        "#{publicGrade,jdbcType=INTEGER}, #{parkId,jdbcType=BIGINT}, ",
        "#{proId,jdbcType=CHAR}, #{cityId,jdbcType=CHAR}, #{counId,jdbcType=CHAR}, ",
        "#{locationId,jdbcType=BIGINT}, #{approvalStatus,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{approvalBy,jdbcType=BIGINT}, #{approvalTime,jdbcType=TIMESTAMP}, ",
        "#{approvalMemo,jdbcType=VARCHAR}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{deleteBy,jdbcType=BIGINT}, #{deleteTime,jdbcType=TIMESTAMP}, ",
        "#{createSide,jdbcType=INTEGER}, #{createSideId,jdbcType=BIGINT}, ",
        "#{terminateBy,jdbcType=BIGINT}, #{terminateTime,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=LONGVARCHAR}, #{operatorHistory,jdbcType=LONGVARCHAR})"
    })
    int insert(CommunityEntityWithBLOBs record);

    @InsertProvider(type=CommunityEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CommunityEntityWithBLOBs record);

    @SelectProvider(type=CommunityEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="discrible", property="discrible", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.CHAR),
        @Result(column="counId", property="counId", jdbcType=JdbcType.CHAR),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateBy", property="terminateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateTime", property="terminateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="operatorHistory", property="operatorHistory", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CommunityEntityWithBLOBs> selectByExampleWithBLOBsWithRowbounds(CommunityEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CommunityEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="discrible", property="discrible", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.CHAR),
        @Result(column="counId", property="counId", jdbcType=JdbcType.CHAR),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateBy", property="terminateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateTime", property="terminateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="operatorHistory", property="operatorHistory", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CommunityEntityWithBLOBs> selectByExampleWithBLOBs(CommunityEntityExample example);

    @SelectProvider(type=CommunityEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="discrible", property="discrible", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.CHAR),
        @Result(column="counId", property="counId", jdbcType=JdbcType.CHAR),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateBy", property="terminateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateTime", property="terminateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityEntity> selectByExampleWithRowbounds(CommunityEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CommunityEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="discrible", property="discrible", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.CHAR),
        @Result(column="counId", property="counId", jdbcType=JdbcType.CHAR),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateBy", property="terminateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateTime", property="terminateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommunityEntity> selectByExample(CommunityEntityExample example);

    @Select({
        "select",
        "id, title, discrible, time, publicGrade, parkId, proId, cityId, counId, locationId, ",
        "approvalStatus, version, status, approvalBy, approvalTime, approvalMemo, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, deleteBy, deleteTime, createSide, ",
        "createSideId, terminateBy, terminateTime, content, operatorHistory",
        "from community_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="discrible", property="discrible", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.CHAR),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.CHAR),
        @Result(column="counId", property="counId", jdbcType=JdbcType.CHAR),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalMemo", property="approvalMemo", jdbcType=JdbcType.VARCHAR),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateBy", property="terminateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="terminateTime", property="terminateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="operatorHistory", property="operatorHistory", jdbcType=JdbcType.LONGVARCHAR)
    })
    CommunityEntityWithBLOBs selectByPrimaryKey(Long id);

    @UpdateProvider(type=CommunityEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommunityEntityWithBLOBs record, @Param("example") CommunityEntityExample example);

    @UpdateProvider(type=CommunityEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") CommunityEntityWithBLOBs record, @Param("example") CommunityEntityExample example);

    @UpdateProvider(type=CommunityEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommunityEntity record, @Param("example") CommunityEntityExample example);

    @UpdateProvider(type=CommunityEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommunityEntityWithBLOBs record);

    @Update({
        "update community_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "discrible = #{discrible,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "publicGrade = #{publicGrade,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "proId = #{proId,jdbcType=CHAR},",
          "cityId = #{cityId,jdbcType=CHAR},",
          "counId = #{counId,jdbcType=CHAR},",
          "locationId = #{locationId,jdbcType=BIGINT},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalMemo = #{approvalMemo,jdbcType=VARCHAR},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "terminateBy = #{terminateBy,jdbcType=BIGINT},",
          "terminateTime = #{terminateTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=LONGVARCHAR},",
          "operatorHistory = #{operatorHistory,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(CommunityEntityWithBLOBs record);

    @Update({
        "update community_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "discrible = #{discrible,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "publicGrade = #{publicGrade,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "proId = #{proId,jdbcType=CHAR},",
          "cityId = #{cityId,jdbcType=CHAR},",
          "counId = #{counId,jdbcType=CHAR},",
          "locationId = #{locationId,jdbcType=BIGINT},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalMemo = #{approvalMemo,jdbcType=VARCHAR},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "terminateBy = #{terminateBy,jdbcType=BIGINT},",
          "terminateTime = #{terminateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommunityEntity record);
}