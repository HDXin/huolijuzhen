package com.sudaotech.picture.dao;

import com.sudaotech.picture.dao.PictureEntity;
import com.sudaotech.picture.dao.PictureEntityExample;
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

public interface PictureEntityMapper {
    @SelectProvider(type=PictureEntitySqlProvider.class, method="countByExample")
    int countByExample(PictureEntityExample example);

    @DeleteProvider(type=PictureEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(PictureEntityExample example);

    @Delete({
        "delete from picture",
        "where pictureId = #{pictureId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long pictureId);

    @Insert({
        "insert into picture (pictureId, extType, ",
        "extId, title, pictureUri, ",
        "description, width, ",
        "height, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{pictureId,jdbcType=BIGINT}, #{extType,jdbcType=INTEGER}, ",
        "#{extId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, #{pictureUri,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{width,jdbcType=INTEGER}, ",
        "#{height,jdbcType=INTEGER}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(PictureEntity record);

    @InsertProvider(type=PictureEntitySqlProvider.class, method="insertSelective")
    int insertSelective(PictureEntity record);

    @SelectProvider(type=PictureEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pictureId", property="pictureId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pictureUri", property="pictureUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PictureEntity> selectByExampleWithRowbounds(PictureEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=PictureEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="pictureId", property="pictureId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pictureUri", property="pictureUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PictureEntity> selectByExample(PictureEntityExample example);

    @Select({
        "select",
        "pictureId, extType, extId, title, pictureUri, description, width, height, displayOrder, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate",
        "from picture",
        "where pictureId = #{pictureId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="pictureId", property="pictureId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="extType", property="extType", jdbcType=JdbcType.INTEGER),
        @Result(column="extId", property="extId", jdbcType=JdbcType.BIGINT),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="pictureUri", property="pictureUri", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="height", property="height", jdbcType=JdbcType.INTEGER),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    PictureEntity selectByPrimaryKey(Long pictureId);

    @UpdateProvider(type=PictureEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PictureEntity record, @Param("example") PictureEntityExample example);

    @UpdateProvider(type=PictureEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PictureEntity record, @Param("example") PictureEntityExample example);

    @UpdateProvider(type=PictureEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PictureEntity record);

    @Update({
        "update picture",
        "set extType = #{extType,jdbcType=INTEGER},",
          "extId = #{extId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "pictureUri = #{pictureUri,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=INTEGER},",
          "height = #{height,jdbcType=INTEGER},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where pictureId = #{pictureId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PictureEntity record);
}