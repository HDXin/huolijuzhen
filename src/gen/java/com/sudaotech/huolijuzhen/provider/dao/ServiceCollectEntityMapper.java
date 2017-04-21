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

public interface ServiceCollectEntityMapper {
    @SelectProvider(type=ServiceCollectEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceCollectEntityExample example);

    @DeleteProvider(type=ServiceCollectEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceCollectEntityExample example);

    @Delete({
        "delete from service_collect",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_collect (id, serviceProId, ",
        "collectBy, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "parkId)",
        "values (#{id,jdbcType=BIGINT}, #{serviceProId,jdbcType=BIGINT}, ",
        "#{collectBy,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{parkId,jdbcType=BIGINT})"
    })
    int insert(ServiceCollectEntity record);

    @InsertProvider(type=ServiceCollectEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceCollectEntity record);

    @SelectProvider(type=ServiceCollectEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectBy", property="collectBy", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    List<ServiceCollectEntity> selectByExampleWithRowbounds(ServiceCollectEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceCollectEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectBy", property="collectBy", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    List<ServiceCollectEntity> selectByExample(ServiceCollectEntityExample example);

    @Select({
        "select",
        "id, serviceProId, collectBy, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate, parkId",
        "from service_collect",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="collectBy", property="collectBy", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT)
    })
    ServiceCollectEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceCollectEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceCollectEntity record, @Param("example") ServiceCollectEntityExample example);

    @UpdateProvider(type=ServiceCollectEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceCollectEntity record, @Param("example") ServiceCollectEntityExample example);

    @UpdateProvider(type=ServiceCollectEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceCollectEntity record);

    @Update({
        "update service_collect",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "collectBy = #{collectBy,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "parkId = #{parkId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceCollectEntity record);
}