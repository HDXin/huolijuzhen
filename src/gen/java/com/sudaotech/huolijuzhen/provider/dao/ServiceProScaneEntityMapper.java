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

public interface ServiceProScaneEntityMapper {
    @SelectProvider(type=ServiceProScaneEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceProScaneEntityExample example);

    @DeleteProvider(type=ServiceProScaneEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceProScaneEntityExample example);

    @Delete({
        "delete from service_pro_scane",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_pro_scane (id, serviceProId, ",
        "serviceScaneId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "serviceProRelease, isPast)",
        "values (#{id,jdbcType=BIGINT}, #{serviceProId,jdbcType=BIGINT}, ",
        "#{serviceScaneId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{serviceProRelease,jdbcType=INTEGER}, #{isPast,jdbcType=INTEGER})"
    })
    int insert(ServiceProScaneEntity record);

    @InsertProvider(type=ServiceProScaneEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceProScaneEntity record);

    @SelectProvider(type=ServiceProScaneEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceScaneId", property="serviceScaneId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="isPast", property="isPast", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceProScaneEntity> selectByExampleWithRowbounds(ServiceProScaneEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceProScaneEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceScaneId", property="serviceScaneId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="isPast", property="isPast", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceProScaneEntity> selectByExample(ServiceProScaneEntityExample example);

    @Select({
        "select",
        "id, serviceProId, serviceScaneId, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate, serviceProRelease, isPast",
        "from service_pro_scane",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceScaneId", property="serviceScaneId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="isPast", property="isPast", jdbcType=JdbcType.INTEGER)
    })
    ServiceProScaneEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceProScaneEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceProScaneEntity record, @Param("example") ServiceProScaneEntityExample example);

    @UpdateProvider(type=ServiceProScaneEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceProScaneEntity record, @Param("example") ServiceProScaneEntityExample example);

    @UpdateProvider(type=ServiceProScaneEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceProScaneEntity record);

    @Update({
        "update service_pro_scane",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "serviceScaneId = #{serviceScaneId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER},",
          "isPast = #{isPast,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceProScaneEntity record);
}