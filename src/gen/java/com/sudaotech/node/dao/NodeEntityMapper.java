package com.sudaotech.node.dao;

import com.sudaotech.node.dao.NodeEntity;
import com.sudaotech.node.dao.NodeEntityExample;
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

public interface NodeEntityMapper {
    @SelectProvider(type=NodeEntitySqlProvider.class, method="countByExample")
    int countByExample(NodeEntityExample example);

    @DeleteProvider(type=NodeEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(NodeEntityExample example);

    @Delete({
        "delete from node",
        "where nodeId = #{nodeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long nodeId);

    @Insert({
        "insert into node (nodeId, nodeType, ",
        "parent, code, name, ",
        "content, image, ",
        "note, attr, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{nodeId,jdbcType=BIGINT}, #{nodeType,jdbcType=INTEGER}, ",
        "#{parent,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, ",
        "#{note,jdbcType=VARCHAR}, #{attr,jdbcType=CHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(NodeEntity record);

    @InsertProvider(type=NodeEntitySqlProvider.class, method="insertSelective")
    int insertSelective(NodeEntity record);

    @SelectProvider(type=NodeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="nodeId", property="nodeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="nodeType", property="nodeType", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr", property="attr", jdbcType=JdbcType.CHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NodeEntity> selectByExampleWithRowbounds(NodeEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=NodeEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="nodeId", property="nodeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="nodeType", property="nodeType", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr", property="attr", jdbcType=JdbcType.CHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NodeEntity> selectByExample(NodeEntityExample example);

    @Select({
        "select",
        "nodeId, nodeType, parent, code, name, content, image, note, attr, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from node",
        "where nodeId = #{nodeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="nodeId", property="nodeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="nodeType", property="nodeType", jdbcType=JdbcType.INTEGER),
        @Result(column="parent", property="parent", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="attr", property="attr", jdbcType=JdbcType.CHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    NodeEntity selectByPrimaryKey(Long nodeId);

    @UpdateProvider(type=NodeEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") NodeEntity record, @Param("example") NodeEntityExample example);

    @UpdateProvider(type=NodeEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") NodeEntity record, @Param("example") NodeEntityExample example);

    @UpdateProvider(type=NodeEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(NodeEntity record);

    @Update({
        "update node",
        "set nodeType = #{nodeType,jdbcType=INTEGER},",
          "parent = #{parent,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "attr = #{attr,jdbcType=CHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where nodeId = #{nodeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(NodeEntity record);
}