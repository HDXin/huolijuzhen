package com.sudaotech.tracking.dao;

import com.sudaotech.tracking.dao.TrackingEntity;
import com.sudaotech.tracking.dao.TrackingEntityExample;
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

public interface TrackingEntityMapper {
    @SelectProvider(type=TrackingEntitySqlProvider.class, method="countByExample")
    int countByExample(TrackingEntityExample example);

    @DeleteProvider(type=TrackingEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(TrackingEntityExample example);

    @Delete({
        "delete from tracking",
        "where trackingId = #{trackingId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long trackingId);

    @Insert({
        "insert into tracking (trackingId, type, ",
        "resourceId, action, ",
        "time, data)",
        "values (#{trackingId,jdbcType=BIGINT}, #{type,jdbcType=VARCHAR}, ",
        "#{resourceId,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{time,jdbcType=TIMESTAMP}, #{data,jdbcType=LONGVARCHAR})"
    })
    int insert(TrackingEntity record);

    @InsertProvider(type=TrackingEntitySqlProvider.class, method="insertSelective")
    int insertSelective(TrackingEntity record);

    @SelectProvider(type=TrackingEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="trackingId", property="trackingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TrackingEntity> selectByExampleWithBLOBsWithRowbounds(TrackingEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TrackingEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="trackingId", property="trackingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TrackingEntity> selectByExampleWithBLOBs(TrackingEntityExample example);

    @SelectProvider(type=TrackingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trackingId", property="trackingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TrackingEntity> selectByExampleWithRowbounds(TrackingEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=TrackingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="trackingId", property="trackingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TrackingEntity> selectByExample(TrackingEntityExample example);

    @Select({
        "select",
        "trackingId, type, resourceId, action, time, data",
        "from tracking",
        "where trackingId = #{trackingId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="trackingId", property="trackingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceId", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    TrackingEntity selectByPrimaryKey(Long trackingId);

    @UpdateProvider(type=TrackingEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TrackingEntity record, @Param("example") TrackingEntityExample example);

    @UpdateProvider(type=TrackingEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") TrackingEntity record, @Param("example") TrackingEntityExample example);

    @UpdateProvider(type=TrackingEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TrackingEntity record, @Param("example") TrackingEntityExample example);

    @UpdateProvider(type=TrackingEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TrackingEntity record);

    @Update({
        "update tracking",
        "set type = #{type,jdbcType=VARCHAR},",
          "resourceId = #{resourceId,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "data = #{data,jdbcType=LONGVARCHAR}",
        "where trackingId = #{trackingId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(TrackingEntity record);

    @Update({
        "update tracking",
        "set type = #{type,jdbcType=VARCHAR},",
          "resourceId = #{resourceId,jdbcType=VARCHAR},",
          "action = #{action,jdbcType=VARCHAR},",
          "time = #{time,jdbcType=TIMESTAMP}",
        "where trackingId = #{trackingId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TrackingEntity record);
}