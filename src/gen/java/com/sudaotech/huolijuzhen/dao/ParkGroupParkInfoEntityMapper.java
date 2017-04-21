package com.sudaotech.huolijuzhen.dao;

import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntity;
import com.sudaotech.huolijuzhen.dao.ParkGroupParkInfoEntityExample;
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

public interface ParkGroupParkInfoEntityMapper {
    @SelectProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="countByExample")
    int countByExample(ParkGroupParkInfoEntityExample example);

    @DeleteProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ParkGroupParkInfoEntityExample example);

    @Delete({
        "delete from park_group_park_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into park_group_park_info (id, parkGroupId, ",
        "parkId, parkname, ",
        "position, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{parkGroupId,jdbcType=BIGINT}, ",
        "#{parkId,jdbcType=BIGINT}, #{parkname,jdbcType=VARCHAR}, ",
        "#{position,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(ParkGroupParkInfoEntity record);

    @InsertProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ParkGroupParkInfoEntity record);

    @SelectProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkname", property="parkname", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupParkInfoEntity> selectByExampleWithRowbounds(ParkGroupParkInfoEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkname", property="parkname", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ParkGroupParkInfoEntity> selectByExample(ParkGroupParkInfoEntityExample example);

    @Select({
        "select",
        "id, parkGroupId, parkId, parkname, position, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from park_group_park_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parkGroupId", property="parkGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkname", property="parkname", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    ParkGroupParkInfoEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ParkGroupParkInfoEntity record, @Param("example") ParkGroupParkInfoEntityExample example);

    @UpdateProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ParkGroupParkInfoEntity record, @Param("example") ParkGroupParkInfoEntityExample example);

    @UpdateProvider(type=ParkGroupParkInfoEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ParkGroupParkInfoEntity record);

    @Update({
        "update park_group_park_info",
        "set parkGroupId = #{parkGroupId,jdbcType=BIGINT},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "parkname = #{parkname,jdbcType=VARCHAR},",
          "position = #{position,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ParkGroupParkInfoEntity record);
}