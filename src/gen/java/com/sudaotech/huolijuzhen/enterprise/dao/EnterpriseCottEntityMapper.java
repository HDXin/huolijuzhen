package com.sudaotech.huolijuzhen.enterprise.dao;

import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntity;
import com.sudaotech.huolijuzhen.enterprise.dao.EnterpriseCottEntityExample;
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

public interface EnterpriseCottEntityMapper {
    @SelectProvider(type=EnterpriseCottEntitySqlProvider.class, method="countByExample")
    int countByExample(EnterpriseCottEntityExample example);

    @DeleteProvider(type=EnterpriseCottEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(EnterpriseCottEntityExample example);

    @Delete({
        "delete from enterprise_cott",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into enterprise_cott (id, corrStatus, ",
        "corrType, corrTime, ",
        "parkId, enterpriseId, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{corrStatus,jdbcType=INTEGER}, ",
        "#{corrType,jdbcType=INTEGER}, #{corrTime,jdbcType=TIMESTAMP}, ",
        "#{parkId,jdbcType=BIGINT}, #{enterpriseId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(EnterpriseCottEntity record);

    @InsertProvider(type=EnterpriseCottEntitySqlProvider.class, method="insertSelective")
    int insertSelective(EnterpriseCottEntity record);

    @SelectProvider(type=EnterpriseCottEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="corrStatus", property="corrStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="corrType", property="corrType", jdbcType=JdbcType.INTEGER),
        @Result(column="corrTime", property="corrTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCottEntity> selectByExampleWithRowbounds(EnterpriseCottEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=EnterpriseCottEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="corrStatus", property="corrStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="corrType", property="corrType", jdbcType=JdbcType.INTEGER),
        @Result(column="corrTime", property="corrTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<EnterpriseCottEntity> selectByExample(EnterpriseCottEntityExample example);

    @Select({
        "select",
        "id, corrStatus, corrType, corrTime, parkId, enterpriseId, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from enterprise_cott",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="corrStatus", property="corrStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="corrType", property="corrType", jdbcType=JdbcType.INTEGER),
        @Result(column="corrTime", property="corrTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="enterpriseId", property="enterpriseId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    EnterpriseCottEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=EnterpriseCottEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EnterpriseCottEntity record, @Param("example") EnterpriseCottEntityExample example);

    @UpdateProvider(type=EnterpriseCottEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EnterpriseCottEntity record, @Param("example") EnterpriseCottEntityExample example);

    @UpdateProvider(type=EnterpriseCottEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnterpriseCottEntity record);

    @Update({
        "update enterprise_cott",
        "set corrStatus = #{corrStatus,jdbcType=INTEGER},",
          "corrType = #{corrType,jdbcType=INTEGER},",
          "corrTime = #{corrTime,jdbcType=TIMESTAMP},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "enterpriseId = #{enterpriseId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EnterpriseCottEntity record);
}