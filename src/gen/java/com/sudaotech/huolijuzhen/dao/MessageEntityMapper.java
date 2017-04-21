package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.MessageEntity;
import com.sudaotech.huolijuzhen.dao.MessageEntityExample;
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

public interface MessageEntityMapper {
    @SelectProvider(type=MessageEntitySqlProvider.class, method="countByExample")
    int countByExample(MessageEntityExample example);

    @DeleteProvider(type=MessageEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(MessageEntityExample example);

    @Delete({
        "delete from message",
        "where msgId = #{msgId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long msgId);

    @Insert({
        "insert into message (msgId, msgBizType, ",
        "bizId, msgType, src, ",
        "dst, msgStatus, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "content, extId, ",
        "sourceType, title, ",
        "parkId)",
        "values (#{msgId,jdbcType=BIGINT}, #{msgBizType,jdbcType=INTEGER}, ",
        "#{bizId,jdbcType=BIGINT}, #{msgType,jdbcType=INTEGER}, #{src,jdbcType=BIGINT}, ",
        "#{dst,jdbcType=BIGINT}, #{msgStatus,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{content,jdbcType=VARCHAR}, #{extId,jdbcType=INTEGER}, ",
        "#{sourceType,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=BIGINT})"
    })
    int insert(MessageEntity record);

    @InsertProvider(type=MessageEntitySqlProvider.class, method="insertSelective")
    int insertSelective(MessageEntity record);

    @SelectProvider(type=MessageEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msgId", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msgBizType", property="msgBizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.BIGINT),
        @Result(column="msgType", property="msgType", jdbcType=JdbcType.INTEGER),
        @Result(column="src", property="src", jdbcType=JdbcType.BIGINT),
        @Result(column="dst", property="dst", jdbcType=JdbcType.BIGINT),
        @Result(column="msgStatus", property="msgStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="extId", property="extId", jdbcType=JdbcType.INTEGER),
        @Result(column="sourceType", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    List<MessageEntity> selectByExampleWithRowbounds(MessageEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=MessageEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="msgId", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msgBizType", property="msgBizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.BIGINT),
        @Result(column="msgType", property="msgType", jdbcType=JdbcType.INTEGER),
        @Result(column="src", property="src", jdbcType=JdbcType.BIGINT),
        @Result(column="dst", property="dst", jdbcType=JdbcType.BIGINT),
        @Result(column="msgStatus", property="msgStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="extId", property="extId", jdbcType=JdbcType.INTEGER),
        @Result(column="sourceType", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    List<MessageEntity> selectByExample(MessageEntityExample example);

    @Select({
        "select",
        "msgId, msgBizType, bizId, msgType, src, dst, msgStatus, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, content, extId, sourceType, title, ",
        "parkId",
        "from message",
        "where msgId = #{msgId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="msgId", property="msgId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="msgBizType", property="msgBizType", jdbcType=JdbcType.INTEGER),
        @Result(column="bizId", property="bizId", jdbcType=JdbcType.BIGINT),
        @Result(column="msgType", property="msgType", jdbcType=JdbcType.INTEGER),
        @Result(column="src", property="src", jdbcType=JdbcType.BIGINT),
        @Result(column="dst", property="dst", jdbcType=JdbcType.BIGINT),
        @Result(column="msgStatus", property="msgStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="extId", property="extId", jdbcType=JdbcType.INTEGER),
        @Result(column="sourceType", property="sourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    MessageEntity selectByPrimaryKey(Long msgId);

    @UpdateProvider(type=MessageEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    @UpdateProvider(type=MessageEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    @UpdateProvider(type=MessageEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MessageEntity record);

    @Update({
        "update message",
        "set msgBizType = #{msgBizType,jdbcType=INTEGER},",
          "bizId = #{bizId,jdbcType=BIGINT},",
          "msgType = #{msgType,jdbcType=INTEGER},",
          "src = #{src,jdbcType=BIGINT},",
          "dst = #{dst,jdbcType=BIGINT},",
          "msgStatus = #{msgStatus,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=VARCHAR},",
          "extId = #{extId,jdbcType=INTEGER},",
          "sourceType = #{sourceType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT}",
        "where msgId = #{msgId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MessageEntity record);
}