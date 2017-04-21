package com.sudaotech.huolijuzhen.sys.common.dao;

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

public interface ImageInfoEntityMapper {
    @SelectProvider(type=ImageInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ImageInfoEntityExample example);

    @DeleteProvider(type=ImageInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ImageInfoEntityExample example);

    @Delete({
        "delete from image_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into image_info (id, imageType, ",
        "targetId, path, title, ",
        "describle, version, ",
        "status, createBy, ",
        "createTime, createName, ",
        "updateBy, updateTime, ",
        "lastUpdate, serviceProRelease)",
        "values (#{id,jdbcType=BIGINT}, #{imageType,jdbcType=INTEGER}, ",
        "#{targetId,jdbcType=BIGINT}, #{path,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{describle,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createName,jdbcType=VARCHAR}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{serviceProRelease,jdbcType=INTEGER})"
    })
    int insert(ImageInfoEntity record);

    @InsertProvider(type=ImageInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ImageInfoEntity record);

    @SelectProvider(type=ImageInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageType", property="imageType", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ImageInfoEntity> selectByExampleWithRowbounds(ImageInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ImageInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageType", property="imageType", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ImageInfoEntity> selectByExample(ImageInfoEntityExample example);

    @Select({
        "select",
        "id, imageType, targetId, path, title, describle, version, status, createBy, ",
        "createTime, createName, updateBy, updateTime, lastUpdate, serviceProRelease",
        "from image_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageType", property="imageType", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="describle", property="describle", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createName", property="createName", jdbcType=JdbcType.VARCHAR),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    ImageInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ImageInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ImageInfoEntity record, @Param("example") ImageInfoEntityExample example);

    @UpdateProvider(type=ImageInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ImageInfoEntity record, @Param("example") ImageInfoEntityExample example);

    @UpdateProvider(type=ImageInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ImageInfoEntity record);

    @Update({
        "update image_info",
        "set imageType = #{imageType,jdbcType=INTEGER},",
          "targetId = #{targetId,jdbcType=BIGINT},",
          "path = #{path,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "describle = #{describle,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "createName = #{createName,jdbcType=VARCHAR},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ImageInfoEntity record);
}