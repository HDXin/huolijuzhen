package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseDisplayEntityExample;
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

public interface EnterpriseDisplayEntityMapper {
    @SelectProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseDisplayEntityExample example);

    @DeleteProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseDisplayEntityExample example);

    @Delete({
        "delete from enterprise_display",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_display (id, info, ",
        "introduce, thumbnailUrl, ",
        "detailUrl, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "details)",
        "values (#{id,jdbcType=BIGINT}, #{info,jdbcType=VARCHAR}, ",
        "#{introduce,jdbcType=VARCHAR}, #{thumbnailUrl,jdbcType=VARCHAR}, ",
        "#{detailUrl,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{details,jdbcType=LONGVARCHAR})"
    })
    int insert(EnterpriseDisplayEntity record);

    @InsertProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseDisplayEntity record);

    @SelectProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<EnterpriseDisplayEntity> selectByExampleWithBLOBsWithRowbounds(EnterpriseDisplayEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<EnterpriseDisplayEntity> selectByExampleWithBLOBs(EnterpriseDisplayEntityExample example);

    @SelectProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseDisplayEntity> selectByExampleWithRowbounds(EnterpriseDisplayEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseDisplayEntity> selectByExample(EnterpriseDisplayEntityExample example);

    @Select({
        "select",
        "id, info, introduce, thumbnailUrl, detailUrl, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate, details",
        "from enterprise_display",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="thumbnailUrl", property="thumbnailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailUrl", property="detailUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    EnterpriseDisplayEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseDisplayEntity record, @Param("example") EnterpriseDisplayEntityExample example);

    @UpdateProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") EnterpriseDisplayEntity record, @Param("example") EnterpriseDisplayEntityExample example);

    @UpdateProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseDisplayEntity record, @Param("example") EnterpriseDisplayEntityExample example);

    @UpdateProvider(type=EnterpriseDisplayEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseDisplayEntity record);

    @Update({
        "update enterprise_display",
        "set info = #{info,jdbcType=VARCHAR},",
          "introduce = #{introduce,jdbcType=VARCHAR},",
          "thumbnailUrl = #{thumbnailUrl,jdbcType=VARCHAR},",
          "detailUrl = #{detailUrl,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "details = #{details,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(EnterpriseDisplayEntity record);

    @Update({
        "update enterprise_display",
        "set info = #{info,jdbcType=VARCHAR},",
          "introduce = #{introduce,jdbcType=VARCHAR},",
          "thumbnailUrl = #{thumbnailUrl,jdbcType=VARCHAR},",
          "detailUrl = #{detailUrl,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseDisplayEntity record);
}