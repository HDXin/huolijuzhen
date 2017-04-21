package com.sudaotech.file.dao;

import com.sudaotech.file.dao.FileDataEntity;
import com.sudaotech.file.dao.FileDataEntityExample;
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

public interface FileDataEntityMapper {
    @SelectProvider(type=FileDataEntitySqlProvider.class, method="countByExample")
    int countByExample(FileDataEntityExample example);

    @DeleteProvider(type=FileDataEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(FileDataEntityExample example);

    @Delete({
        "delete from file_data",
        "where fileId = #{fileId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long fileId);

    @Insert({
        "insert into file_data (fileId, fileType, ",
        "title, fileUrl, ",
        "description, displayOrder, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{fileId,jdbcType=BIGINT}, #{fileType,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{fileUrl,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{displayOrder,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(FileDataEntity record);

    @InsertProvider(type=FileDataEntitySqlProvider.class, method="insertSelective")
    int insertSelective(FileDataEntity record);

    @SelectProvider(type=FileDataEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="fileId", property="fileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FileDataEntity> selectByExampleWithRowbounds(FileDataEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=FileDataEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="fileId", property="fileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FileDataEntity> selectByExample(FileDataEntityExample example);

    @Select({
        "select",
        "fileId, fileType, title, fileUrl, description, displayOrder, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from file_data",
        "where fileId = #{fileId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="fileId", property="fileId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    FileDataEntity selectByPrimaryKey(Long fileId);

    @UpdateProvider(type=FileDataEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FileDataEntity record, @Param("example") FileDataEntityExample example);

    @UpdateProvider(type=FileDataEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FileDataEntity record, @Param("example") FileDataEntityExample example);

    @UpdateProvider(type=FileDataEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FileDataEntity record);

    @Update({
        "update file_data",
        "set fileType = #{fileType,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "fileUrl = #{fileUrl,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where fileId = #{fileId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FileDataEntity record);
}