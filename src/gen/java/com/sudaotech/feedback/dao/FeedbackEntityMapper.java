package com.sudaotech.feedback.dao;

import com.sudaotech.feedback.dao.FeedbackEntity;
import com.sudaotech.feedback.dao.FeedbackEntityExample;
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

public interface FeedbackEntityMapper {
    @SelectProvider(type=FeedbackEntitySqlProvider.class, method="countByExample")
    int countByExample(FeedbackEntityExample example);

    @DeleteProvider(type=FeedbackEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(FeedbackEntityExample example);

    @Delete({
        "delete from feedback",
        "where feedbackId = #{feedbackId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long feedbackId);

    @Insert({
        "insert into feedback (feedbackId, feedbackType, ",
        "title, feedbackStatus, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "body)",
        "values (#{feedbackId,jdbcType=BIGINT}, #{feedbackType,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{feedbackStatus,jdbcType=INTEGER}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{body,jdbcType=LONGVARCHAR})"
    })
    int insert(FeedbackEntity record);

    @InsertProvider(type=FeedbackEntitySqlProvider.class, method="insertSelective")
    int insertSelective(FeedbackEntity record);

    @SelectProvider(type=FeedbackEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="feedbackId", property="feedbackId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="feedbackType", property="feedbackType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedbackStatus", property="feedbackStatus", jdbcType=JdbcType.INTEGER),
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
    List<FeedbackEntity> selectByExampleWithBLOBsWithRowbounds(FeedbackEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=FeedbackEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="feedbackId", property="feedbackId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="feedbackType", property="feedbackType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedbackStatus", property="feedbackStatus", jdbcType=JdbcType.INTEGER),
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
    List<FeedbackEntity> selectByExampleWithBLOBs(FeedbackEntityExample example);

    @SelectProvider(type=FeedbackEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="feedbackId", property="feedbackId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="feedbackType", property="feedbackType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedbackStatus", property="feedbackStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FeedbackEntity> selectByExampleWithRowbounds(FeedbackEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=FeedbackEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="feedbackId", property="feedbackId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="feedbackType", property="feedbackType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedbackStatus", property="feedbackStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FeedbackEntity> selectByExample(FeedbackEntityExample example);

    @Select({
        "select",
        "feedbackId, feedbackType, title, feedbackStatus, displayOrder, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate, body",
        "from feedback",
        "where feedbackId = #{feedbackId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="feedbackId", property="feedbackId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="feedbackType", property="feedbackType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="feedbackStatus", property="feedbackStatus", jdbcType=JdbcType.INTEGER),
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
    FeedbackEntity selectByPrimaryKey(Long feedbackId);

    @UpdateProvider(type=FeedbackEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FeedbackEntity record, @Param("example") FeedbackEntityExample example);

    @UpdateProvider(type=FeedbackEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") FeedbackEntity record, @Param("example") FeedbackEntityExample example);

    @UpdateProvider(type=FeedbackEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FeedbackEntity record, @Param("example") FeedbackEntityExample example);

    @UpdateProvider(type=FeedbackEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FeedbackEntity record);

    @Update({
        "update feedback",
        "set feedbackType = #{feedbackType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "feedbackStatus = #{feedbackStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "body = #{body,jdbcType=LONGVARCHAR}",
        "where feedbackId = #{feedbackId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(FeedbackEntity record);

    @Update({
        "update feedback",
        "set feedbackType = #{feedbackType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "feedbackStatus = #{feedbackStatus,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where feedbackId = #{feedbackId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FeedbackEntity record);
}