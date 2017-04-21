package com.sudaotech.huolijuzhen.announcement.dao;

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

public interface AnnouncementEntityMapper {
    @SelectProvider(type=AnnouncementEntitySqlProvider.class, method="countByExample")
    int countByExample(AnnouncementEntityExample example);

    @DeleteProvider(type=AnnouncementEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AnnouncementEntityExample example);

    @Delete({
        "delete from announcement_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into announcement_info (id, title, ",
        "publicGrade, parkId, ",
        "proId, cityId, counId, ",
        "locationId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "approvalStatus, approvalBy, ",
        "approvalTime, approvalText, ",
        "deleteBy, deleteTime, ",
        "createSide, createSideId, ",
        "sendGrade, content)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{publicGrade,jdbcType=INTEGER}, #{parkId,jdbcType=BIGINT}, ",
        "#{proId,jdbcType=BIGINT}, #{cityId,jdbcType=BIGINT}, #{counId,jdbcType=BIGINT}, ",
        "#{locationId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{approvalStatus,jdbcType=INTEGER}, #{approvalBy,jdbcType=BIGINT}, ",
        "#{approvalTime,jdbcType=TIMESTAMP}, #{approvalText,jdbcType=VARCHAR}, ",
        "#{deleteBy,jdbcType=BIGINT}, #{deleteTime,jdbcType=TIMESTAMP}, ",
        "#{createSide,jdbcType=INTEGER}, #{createSideId,jdbcType=BIGINT}, ",
        "#{sendGrade,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(AnnouncementEntity record);

    @InsertProvider(type=AnnouncementEntitySqlProvider.class, method="insertSelective")
    int insertSelective(AnnouncementEntity record);

    @SelectProvider(type=AnnouncementEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="sendGrade", property="sendGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AnnouncementEntity> selectByExampleWithBLOBsWithRowbounds(AnnouncementEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=AnnouncementEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="sendGrade", property="sendGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<AnnouncementEntity> selectByExampleWithBLOBs(AnnouncementEntityExample example);

    @SelectProvider(type=AnnouncementEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="sendGrade", property="sendGrade", jdbcType=JdbcType.INTEGER)
    })
    List<AnnouncementEntity> selectByExampleWithRowbounds(AnnouncementEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=AnnouncementEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="sendGrade", property="sendGrade", jdbcType=JdbcType.INTEGER)
    })
    List<AnnouncementEntity> selectByExample(AnnouncementEntityExample example);

    @Select({
        "select",
        "id, title, publicGrade, parkId, proId, cityId, counId, locationId, version, ",
        "status, createBy, createTime, updateBy, updateTime, lastUpdate, approvalStatus, ",
        "approvalBy, approvalTime, approvalText, deleteBy, deleteTime, createSide, createSideId, ",
        "sendGrade, content",
        "from announcement_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="publicGrade", property="publicGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="proId", property="proId", jdbcType=JdbcType.BIGINT),
        @Result(column="cityId", property="cityId", jdbcType=JdbcType.BIGINT),
        @Result(column="counId", property="counId", jdbcType=JdbcType.BIGINT),
        @Result(column="locationId", property="locationId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createSide", property="createSide", jdbcType=JdbcType.INTEGER),
        @Result(column="createSideId", property="createSideId", jdbcType=JdbcType.BIGINT),
        @Result(column="sendGrade", property="sendGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    AnnouncementEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=AnnouncementEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AnnouncementEntity record, @Param("example") AnnouncementEntityExample example);

    @UpdateProvider(type=AnnouncementEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") AnnouncementEntity record, @Param("example") AnnouncementEntityExample example);

    @UpdateProvider(type=AnnouncementEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AnnouncementEntity record, @Param("example") AnnouncementEntityExample example);

    @UpdateProvider(type=AnnouncementEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AnnouncementEntity record);

    @Update({
        "update announcement_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "publicGrade = #{publicGrade,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "proId = #{proId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "counId = #{counId,jdbcType=BIGINT},",
          "locationId = #{locationId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "sendGrade = #{sendGrade,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(AnnouncementEntity record);

    @Update({
        "update announcement_info",
        "set title = #{title,jdbcType=VARCHAR},",
          "publicGrade = #{publicGrade,jdbcType=INTEGER},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "proId = #{proId,jdbcType=BIGINT},",
          "cityId = #{cityId,jdbcType=BIGINT},",
          "counId = #{counId,jdbcType=BIGINT},",
          "locationId = #{locationId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "createSide = #{createSide,jdbcType=INTEGER},",
          "createSideId = #{createSideId,jdbcType=BIGINT},",
          "sendGrade = #{sendGrade,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AnnouncementEntity record);
}