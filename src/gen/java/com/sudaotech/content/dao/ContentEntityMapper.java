package com.sudaotech.content.dao;

import com.sudaotech.content.dao.ContentEntity;
import com.sudaotech.content.dao.ContentEntityExample;
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

public interface ContentEntityMapper {
    @SelectProvider(type=ContentEntitySqlProvider.class, method="countByExample")
    int countByExample(ContentEntityExample example);

    @DeleteProvider(type=ContentEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ContentEntityExample example);

    @Delete({
        "delete from content",
        "where contentId = #{contentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long contentId);

    @Insert({
        "insert into content (contentId, contentType, ",
        "title, summary, ",
        "imageUrl, videoUrl, ",
        "parent, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, body)",
        "values (#{contentId,jdbcType=BIGINT}, #{contentType,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{summary,jdbcType=VARCHAR}, ",
        "#{imageUrl,jdbcType=VARCHAR}, #{videoUrl,jdbcType=VARCHAR}, ",
        "#{parent,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{body,jdbcType=LONGVARCHAR})"
    })
    int insert(ContentEntity record);

    @InsertProvider(type=ContentEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ContentEntity record);

    @SelectProvider(type=ContentEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="contentId", property="contentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contentType", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="videoUrl", property="videoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ContentEntity> selectByExampleWithBLOBsWithRowbounds(ContentEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContentEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="contentId", property="contentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contentType", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="videoUrl", property="videoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ContentEntity> selectByExampleWithBLOBs(ContentEntityExample example);

    @SelectProvider(type=ContentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="contentId", property="contentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contentType", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="videoUrl", property="videoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContentEntity> selectByExampleWithRowbounds(ContentEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ContentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="contentId", property="contentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contentType", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="videoUrl", property="videoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ContentEntity> selectByExample(ContentEntityExample example);

    @Select({
        "select",
        "contentId, contentType, title, summary, imageUrl, videoUrl, parent, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, body",
        "from content",
        "where contentId = #{contentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="contentId", property="contentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="contentType", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="summary", property="summary", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="videoUrl", property="videoUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="body", property="body", jdbcType=JdbcType.LONGVARCHAR)
    })
    ContentEntity selectByPrimaryKey(Long contentId);

    @UpdateProvider(type=ContentEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ContentEntity record, @Param("example") ContentEntityExample example);

    @UpdateProvider(type=ContentEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ContentEntity record, @Param("example") ContentEntityExample example);

    @UpdateProvider(type=ContentEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ContentEntity record, @Param("example") ContentEntityExample example);

    @UpdateProvider(type=ContentEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContentEntity record);

    @Update({
        "update content",
        "set contentType = #{contentType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "summary = #{summary,jdbcType=VARCHAR},",
          "imageUrl = #{imageUrl,jdbcType=VARCHAR},",
          "videoUrl = #{videoUrl,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "body = #{body,jdbcType=LONGVARCHAR}",
        "where contentId = #{contentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ContentEntity record);

    @Update({
        "update content",
        "set contentType = #{contentType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "summary = #{summary,jdbcType=VARCHAR},",
          "imageUrl = #{imageUrl,jdbcType=VARCHAR},",
          "videoUrl = #{videoUrl,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where contentId = #{contentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ContentEntity record);
}