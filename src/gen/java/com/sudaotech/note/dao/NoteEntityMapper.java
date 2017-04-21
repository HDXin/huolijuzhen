package com.sudaotech.note.dao;

import com.sudaotech.note.dao.NoteEntity;
import com.sudaotech.note.dao.NoteEntityExample;
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

public interface NoteEntityMapper {
    @SelectProvider(type=NoteEntitySqlProvider.class, method="countByExample")
    int countByExample(NoteEntityExample example);

    @DeleteProvider(type=NoteEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(NoteEntityExample example);

    @Delete({
        "delete from note",
        "where noteId = #{noteId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long noteId);

    @Insert({
        "insert into note (noteId, title, ",
        "message, extType, ",
        "extId, userId, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{noteId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{message,jdbcType=VARCHAR}, #{extType,jdbcType=INTEGER}, ",
        "#{extId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(NoteEntity record);

    @InsertProvider(type=NoteEntitySqlProvider.class, method="insertSelective")
    int insertSelective(NoteEntity record);

    @SelectProvider(type=NoteEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="noteId", property="noteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NoteEntity> selectByExampleWithRowbounds(NoteEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=NoteEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="noteId", property="noteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NoteEntity> selectByExample(NoteEntityExample example);

    @Select({
        "select",
        "noteId, title, message, extType, extId, userId, displayOrder, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from note",
        "where noteId = #{noteId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="noteId", property="noteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    NoteEntity selectByPrimaryKey(Long noteId);

    @UpdateProvider(type=NoteEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NoteEntity record, @Param("example") NoteEntityExample example);

    @UpdateProvider(type=NoteEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NoteEntity record, @Param("example") NoteEntityExample example);

    @UpdateProvider(type=NoteEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NoteEntity record);

    @Update({
        "update note",
        "set title = #{title,jdbcType=VARCHAR},",
          "message = #{message,jdbcType=VARCHAR},",
          "extType = #{extType,jdbcType=INTEGER},",
          "extId = #{extId,jdbcType=BIGINT},",
          "userId = #{userId,jdbcType=BIGINT},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where noteId = #{noteId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NoteEntity record);
}