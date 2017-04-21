package com.sudaotech.tag.dao;

import com.sudaotech.tag.dao.TagEntity;
import com.sudaotech.tag.dao.TagEntityExample;
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

public interface TagEntityMapper {
    @SelectProvider(type=TagEntitySqlProvider.class, method="countByExample")
    int countByExample(TagEntityExample example);

    @DeleteProvider(type=TagEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TagEntityExample example);

    @Delete({
        "delete from tag",
        "where tagId = #{tagId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long tagId);

    @Insert({
        "insert into tag (tagId, tagName, ",
        "parent, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{tagId,jdbcType=BIGINT}, #{tagName,jdbcType=VARCHAR}, ",
        "#{parent,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(TagEntity record);

    @InsertProvider(type=TagEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TagEntity record);

    @SelectProvider(type=TagEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tagId", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tagName", property="tagName", jdbcType=JdbcType.VARCHAR),
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
    List<TagEntity> selectByExampleWithRowbounds(TagEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TagEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="tagId", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tagName", property="tagName", jdbcType=JdbcType.VARCHAR),
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
    List<TagEntity> selectByExample(TagEntityExample example);

    @Select({
        "select",
        "tagId, tagName, parent, displayOrder, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from tag",
        "where tagId = #{tagId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="tagId", property="tagId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="tagName", property="tagName", jdbcType=JdbcType.VARCHAR),
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
    TagEntity selectByPrimaryKey(Long tagId);

    @UpdateProvider(type=TagEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TagEntity record, @Param("example") TagEntityExample example);

    @UpdateProvider(type=TagEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TagEntity record, @Param("example") TagEntityExample example);

    @UpdateProvider(type=TagEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TagEntity record);

    @Update({
        "update tag",
        "set tagName = #{tagName,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where tagId = #{tagId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TagEntity record);
}