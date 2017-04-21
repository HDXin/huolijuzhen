package com.sudaotech.favorite.dao;

import com.sudaotech.favorite.dao.FavoriteEntity;
import com.sudaotech.favorite.dao.FavoriteEntityExample;
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

public interface FavoriteEntityMapper {
    @SelectProvider(type=FavoriteEntitySqlProvider.class, method="countByExample")
    int countByExample(FavoriteEntityExample example);

    @DeleteProvider(type=FavoriteEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(FavoriteEntityExample example);

    @Delete({
        "delete from favorite",
        "where favoriteId = #{favoriteId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long favoriteId);

    @Insert({
        "insert into favorite (favoriteId, userId, ",
        "type, targetId, target, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{favoriteId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{type,jdbcType=INTEGER}, #{targetId,jdbcType=BIGINT}, #{target,jdbcType=VARCHAR}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(FavoriteEntity record);

    @InsertProvider(type=FavoriteEntitySqlProvider.class, method="insertSelective")
    int insertSelective(FavoriteEntity record);

    @SelectProvider(type=FavoriteEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="favoriteId", property="favoriteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FavoriteEntity> selectByExampleWithRowbounds(FavoriteEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=FavoriteEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="favoriteId", property="favoriteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FavoriteEntity> selectByExample(FavoriteEntityExample example);

    @Select({
        "select",
        "favoriteId, userId, type, targetId, target, displayOrder, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from favorite",
        "where favoriteId = #{favoriteId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="favoriteId", property="favoriteId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="targetId", property="targetId", jdbcType=JdbcType.BIGINT),
        @Result(column="target", property="target", jdbcType=JdbcType.VARCHAR),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    FavoriteEntity selectByPrimaryKey(Long favoriteId);

    @UpdateProvider(type=FavoriteEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FavoriteEntity record, @Param("example") FavoriteEntityExample example);

    @UpdateProvider(type=FavoriteEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FavoriteEntity record, @Param("example") FavoriteEntityExample example);

    @UpdateProvider(type=FavoriteEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FavoriteEntity record);

    @Update({
        "update favorite",
        "set userId = #{userId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "targetId = #{targetId,jdbcType=BIGINT},",
          "target = #{target,jdbcType=VARCHAR},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where favoriteId = #{favoriteId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FavoriteEntity record);
}