package com.sudaotech.huolijuzhen.bannerManager.dao;

import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntity;
import com.sudaotech.huolijuzhen.bannerManager.dao.BannerSourcesEntityExample;
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

public interface BannerSourcesEntityMapper {
    @SelectProvider(type=BannerSourcesEntitySqlProvider.class, method="countByExample")
    int countByExample(BannerSourcesEntityExample example);

    @DeleteProvider(type=BannerSourcesEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BannerSourcesEntityExample example);

    @Delete({
        "delete from banner_sources",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into banner_sources (id, imageUrl, ",
        "reqSourceType, jumpTo, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{imageUrl,jdbcType=VARCHAR}, ",
        "#{reqSourceType,jdbcType=INTEGER}, #{jumpTo,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(BannerSourcesEntity record);

    @InsertProvider(type=BannerSourcesEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BannerSourcesEntity record);

    @SelectProvider(type=BannerSourcesEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="reqSourceType", property="reqSourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="jumpTo", property="jumpTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BannerSourcesEntity> selectByExampleWithRowbounds(BannerSourcesEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BannerSourcesEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="reqSourceType", property="reqSourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="jumpTo", property="jumpTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BannerSourcesEntity> selectByExample(BannerSourcesEntityExample example);

    @Select({
        "select",
        "id, imageUrl, reqSourceType, jumpTo, version, status, createBy, createTime, ",
        "updateBy, updateTime, lastUpdate",
        "from banner_sources",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="imageUrl", property="imageUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="reqSourceType", property="reqSourceType", jdbcType=JdbcType.INTEGER),
        @Result(column="jumpTo", property="jumpTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    BannerSourcesEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BannerSourcesEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BannerSourcesEntity record, @Param("example") BannerSourcesEntityExample example);

    @UpdateProvider(type=BannerSourcesEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BannerSourcesEntity record, @Param("example") BannerSourcesEntityExample example);

    @UpdateProvider(type=BannerSourcesEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BannerSourcesEntity record);

    @Update({
        "update banner_sources",
        "set imageUrl = #{imageUrl,jdbcType=VARCHAR},",
          "reqSourceType = #{reqSourceType,jdbcType=INTEGER},",
          "jumpTo = #{jumpTo,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BannerSourcesEntity record);
}