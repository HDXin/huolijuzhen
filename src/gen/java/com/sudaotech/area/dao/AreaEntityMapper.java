package com.sudaotech.area.dao;

import com.sudaotech.area.dao.AreaEntity;
import com.sudaotech.area.dao.AreaEntityExample;
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

public interface AreaEntityMapper {
    @SelectProvider(type=AreaEntitySqlProvider.class, method="countByExample")
    int countByExample(AreaEntityExample example);

    @DeleteProvider(type=AreaEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(AreaEntityExample example);

    @Delete({
        "delete from area",
        "where areaId = #{areaId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer areaId);

    @Insert({
        "insert into area (areaId, parentId, ",
        "adcode, name, note, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{areaId,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{adcode,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(AreaEntity record);

    @InsertProvider(type=AreaEntitySqlProvider.class, method="insertSelective")
    int insertSelective(AreaEntity record);

    @SelectProvider(type=AreaEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="adcode", property="adcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AreaEntity> selectByExampleWithRowbounds(AreaEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=AreaEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="adcode", property="adcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AreaEntity> selectByExample(AreaEntityExample example);

    @Select({
        "select",
        "areaId, parentId, adcode, name, note, displayOrder, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from area",
        "where areaId = #{areaId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="areaId", property="areaId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parentId", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="adcode", property="adcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    AreaEntity selectByPrimaryKey(Integer areaId);

    @UpdateProvider(type=AreaEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AreaEntity record, @Param("example") AreaEntityExample example);

    @UpdateProvider(type=AreaEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AreaEntity record, @Param("example") AreaEntityExample example);

    @UpdateProvider(type=AreaEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AreaEntity record);

    @Update({
        "update area",
        "set parentId = #{parentId,jdbcType=INTEGER},",
          "adcode = #{adcode,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where areaId = #{areaId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AreaEntity record);
}