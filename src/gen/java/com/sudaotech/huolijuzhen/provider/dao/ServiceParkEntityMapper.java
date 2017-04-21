package com.sudaotech.huolijuzhen.provider.dao;

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

public interface ServiceParkEntityMapper {
    @SelectProvider(type=ServiceParkEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceParkEntityExample example);

    @DeleteProvider(type=ServiceParkEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceParkEntityExample example);

    @Delete({
        "delete from service_park",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_park (id, serviceId, ",
        "parkId, chooseStatus, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate, serviceProRelease)",
        "values (#{id,jdbcType=BIGINT}, #{serviceId,jdbcType=BIGINT}, ",
        "#{parkId,jdbcType=BIGINT}, #{chooseStatus,jdbcType=INTEGER}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{serviceProRelease,jdbcType=INTEGER})"
    })
    int insert(ServiceParkEntity record);

    @InsertProvider(type=ServiceParkEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceParkEntity record);

    @SelectProvider(type=ServiceParkEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceId", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="chooseStatus", property="chooseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceParkEntity> selectByExampleWithRowbounds(ServiceParkEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceParkEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceId", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="chooseStatus", property="chooseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceParkEntity> selectByExample(ServiceParkEntityExample example);

    @Select({
        "select",
        "id, serviceId, parkId, chooseStatus, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate, serviceProRelease",
        "from service_park",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceId", property="serviceId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="chooseStatus", property="chooseStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    ServiceParkEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceParkEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceParkEntity record, @Param("example") ServiceParkEntityExample example);

    @UpdateProvider(type=ServiceParkEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceParkEntity record, @Param("example") ServiceParkEntityExample example);

    @UpdateProvider(type=ServiceParkEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceParkEntity record);

    @Update({
        "update service_park",
        "set serviceId = #{serviceId,jdbcType=BIGINT},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "chooseStatus = #{chooseStatus,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceParkEntity record);
}