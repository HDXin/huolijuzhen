package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ResourceInfoEntity;
import com.sudaotech.huolijuzhen.dao.ResourceInfoEntityExample;
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

public interface ResourceInfoEntityMapper {
    @SelectProvider(type=ResourceInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ResourceInfoEntityExample example);

    @DeleteProvider(type=ResourceInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ResourceInfoEntityExample example);

    @Delete({
        "delete from resource_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into resource_info (id, isRoot, resInfoId, ",
        "tierId, tierName, ",
        "tierNum, name, description, ",
        "gardenId, parentId, ",
        "isSeat, code, area, ",
        "deleteBy, deleteTime, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, contId, ",
        "useStatus, price)",
        "values (#{id,jdbcType=BIGINT}, #{isRoot,jdbcType=BIT}, #{resInfoId,jdbcType=BIGINT}, ",
        "#{tierId,jdbcType=BIGINT}, #{tierName,jdbcType=VARCHAR}, ",
        "#{tierNum,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{gardenId,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{isSeat,jdbcType=BIT}, #{code,jdbcType=VARCHAR}, #{area,jdbcType=DOUBLE}, ",
        "#{deleteBy,jdbcType=BIGINT}, #{deleteTime,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{contId,jdbcType=BIGINT}, ",
        "#{useStatus,jdbcType=INTEGER}, #{price,jdbcType=DECIMAL})"
    })
    int insert(ResourceInfoEntity record);

    @InsertProvider(type=ResourceInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ResourceInfoEntity record);

    @SelectProvider(type=ResourceInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="isRoot", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierId", property="tierId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierName", property="tierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="isSeat", property="isSeat", jdbcType=JdbcType.BIT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DOUBLE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contId", property="contId", jdbcType=JdbcType.BIGINT),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<ResourceInfoEntity> selectByExampleWithRowbounds(ResourceInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ResourceInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="isRoot", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierId", property="tierId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierName", property="tierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="isSeat", property="isSeat", jdbcType=JdbcType.BIT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DOUBLE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contId", property="contId", jdbcType=JdbcType.BIGINT),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<ResourceInfoEntity> selectByExample(ResourceInfoEntityExample example);

    @Select({
        "select",
        "id, isRoot, resInfoId, tierId, tierName, tierNum, name, description, gardenId, ",
        "parentId, isSeat, code, area, deleteBy, deleteTime, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate, contId, useStatus, price",
        "from resource_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="isRoot", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="resInfoId", property="resInfoId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierId", property="tierId", jdbcType=JdbcType.BIGINT),
        @Result(column="tierName", property="tierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tierNum", property="tierNum", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="gardenId", property="gardenId", jdbcType=JdbcType.BIGINT),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="isSeat", property="isSeat", jdbcType=JdbcType.BIT),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="area", property="area", jdbcType=JdbcType.DOUBLE),
        @Result(column="deleteBy", property="deleteBy", jdbcType=JdbcType.BIGINT),
        @Result(column="deleteTime", property="deleteTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="contId", property="contId", jdbcType=JdbcType.BIGINT),
        @Result(column="useStatus", property="useStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    ResourceInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ResourceInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ResourceInfoEntity record, @Param("example") ResourceInfoEntityExample example);

    @UpdateProvider(type=ResourceInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ResourceInfoEntity record, @Param("example") ResourceInfoEntityExample example);

    @UpdateProvider(type=ResourceInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ResourceInfoEntity record);

    @Update({
        "update resource_info",
        "set isRoot = #{isRoot,jdbcType=BIT},",
          "resInfoId = #{resInfoId,jdbcType=BIGINT},",
          "tierId = #{tierId,jdbcType=BIGINT},",
          "tierName = #{tierName,jdbcType=VARCHAR},",
          "tierNum = #{tierNum,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "gardenId = #{gardenId,jdbcType=BIGINT},",
          "parentId = #{parentId,jdbcType=BIGINT},",
          "isSeat = #{isSeat,jdbcType=BIT},",
          "code = #{code,jdbcType=VARCHAR},",
          "area = #{area,jdbcType=DOUBLE},",
          "deleteBy = #{deleteBy,jdbcType=BIGINT},",
          "deleteTime = #{deleteTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "contId = #{contId,jdbcType=BIGINT},",
          "useStatus = #{useStatus,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ResourceInfoEntity record);
}