package com.sudaotech.comment.dao;

import com.sudaotech.comment.dao.CommentEntity;
import com.sudaotech.comment.dao.CommentEntityExample;
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

public interface CommentEntityMapper {
    @SelectProvider(type=CommentEntitySqlProvider.class, method="countByExample")
    int countByExample(CommentEntityExample example);

    @DeleteProvider(type=CommentEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(CommentEntityExample example);

    @Delete({
        "delete from comment",
        "where commentId = #{commentId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long commentId);

    @Insert({
        "insert into comment (commentId, type, ",
        "parent, content, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{commentId,jdbcType=BIGINT}, #{type,jdbcType=INTEGER}, ",
        "#{parent,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(CommentEntity record);

    @InsertProvider(type=CommentEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CommentEntity record);

    @SelectProvider(type=CommentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommentEntity> selectByExampleWithRowbounds(CommentEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=CommentEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CommentEntity> selectByExample(CommentEntityExample example);

    @Select({
        "select",
        "commentId, type, parent, content, displayOrder, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from comment",
        "where commentId = #{commentId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="commentId", property="commentId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    CommentEntity selectByPrimaryKey(Long commentId);

    @UpdateProvider(type=CommentEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CommentEntity record, @Param("example") CommentEntityExample example);

    @UpdateProvider(type=CommentEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CommentEntity record, @Param("example") CommentEntityExample example);

    @UpdateProvider(type=CommentEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CommentEntity record);

    @Update({
        "update comment",
        "set type = #{type,jdbcType=INTEGER},",
          "parent = #{parent,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where commentId = #{commentId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CommentEntity record);
}