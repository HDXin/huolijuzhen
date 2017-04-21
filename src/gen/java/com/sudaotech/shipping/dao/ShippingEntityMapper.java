package com.sudaotech.shipping.dao;

import com.sudaotech.shipping.dao.ShippingEntity;
import com.sudaotech.shipping.dao.ShippingEntityExample;
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

public interface ShippingEntityMapper {
    @SelectProvider(type=ShippingEntitySqlProvider.class, method="countByExample")
    int countByExample(ShippingEntityExample example);

    @DeleteProvider(type=ShippingEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ShippingEntityExample example);

    @Delete({
        "delete from shipping",
        "where shippingId = #{shippingId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long shippingId);

    @Insert({
        "insert into shipping (shippingId, shippingNo, ",
        "shippingCompany, shippingCompanyId, ",
        "shippingFrom, shippingTo, ",
        "state, saleOrderId, ",
        "displayOrder, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "json)",
        "values (#{shippingId,jdbcType=BIGINT}, #{shippingNo,jdbcType=VARCHAR}, ",
        "#{shippingCompany,jdbcType=VARCHAR}, #{shippingCompanyId,jdbcType=VARCHAR}, ",
        "#{shippingFrom,jdbcType=VARCHAR}, #{shippingTo,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{saleOrderId,jdbcType=BIGINT}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{json,jdbcType=LONGVARCHAR})"
    })
    int insert(ShippingEntity record);

    @InsertProvider(type=ShippingEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ShippingEntity record);

    @SelectProvider(type=ShippingEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="shippingId", property="shippingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shippingNo", property="shippingNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompany", property="shippingCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompanyId", property="shippingCompanyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingFrom", property="shippingFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingTo", property="shippingTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="saleOrderId", property="saleOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ShippingEntity> selectByExampleWithBLOBsWithRowbounds(ShippingEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ShippingEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="shippingId", property="shippingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shippingNo", property="shippingNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompany", property="shippingCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompanyId", property="shippingCompanyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingFrom", property="shippingFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingTo", property="shippingTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="saleOrderId", property="saleOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ShippingEntity> selectByExampleWithBLOBs(ShippingEntityExample example);

    @SelectProvider(type=ShippingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="shippingId", property="shippingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shippingNo", property="shippingNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompany", property="shippingCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompanyId", property="shippingCompanyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingFrom", property="shippingFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingTo", property="shippingTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="saleOrderId", property="saleOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ShippingEntity> selectByExampleWithRowbounds(ShippingEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ShippingEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="shippingId", property="shippingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shippingNo", property="shippingNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompany", property="shippingCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompanyId", property="shippingCompanyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingFrom", property="shippingFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingTo", property="shippingTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="saleOrderId", property="saleOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ShippingEntity> selectByExample(ShippingEntityExample example);

    @Select({
        "select",
        "shippingId, shippingNo, shippingCompany, shippingCompanyId, shippingFrom, shippingTo, ",
        "state, saleOrderId, displayOrder, version, status, createBy, createTime, updateBy, ",
        "updateTime, lastUpdate, json",
        "from shipping",
        "where shippingId = #{shippingId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="shippingId", property="shippingId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shippingNo", property="shippingNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompany", property="shippingCompany", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingCompanyId", property="shippingCompanyId", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingFrom", property="shippingFrom", jdbcType=JdbcType.VARCHAR),
        @Result(column="shippingTo", property="shippingTo", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="saleOrderId", property="saleOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="displayOrder", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="json", property="json", jdbcType=JdbcType.LONGVARCHAR)
    })
    ShippingEntity selectByPrimaryKey(Long shippingId);

    @UpdateProvider(type=ShippingEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShippingEntity record, @Param("example") ShippingEntityExample example);

    @UpdateProvider(type=ShippingEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ShippingEntity record, @Param("example") ShippingEntityExample example);

    @UpdateProvider(type=ShippingEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShippingEntity record, @Param("example") ShippingEntityExample example);

    @UpdateProvider(type=ShippingEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShippingEntity record);

    @Update({
        "update shipping",
        "set shippingNo = #{shippingNo,jdbcType=VARCHAR},",
          "shippingCompany = #{shippingCompany,jdbcType=VARCHAR},",
          "shippingCompanyId = #{shippingCompanyId,jdbcType=VARCHAR},",
          "shippingFrom = #{shippingFrom,jdbcType=VARCHAR},",
          "shippingTo = #{shippingTo,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "saleOrderId = #{saleOrderId,jdbcType=BIGINT},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "json = #{json,jdbcType=LONGVARCHAR}",
        "where shippingId = #{shippingId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ShippingEntity record);

    @Update({
        "update shipping",
        "set shippingNo = #{shippingNo,jdbcType=VARCHAR},",
          "shippingCompany = #{shippingCompany,jdbcType=VARCHAR},",
          "shippingCompanyId = #{shippingCompanyId,jdbcType=VARCHAR},",
          "shippingFrom = #{shippingFrom,jdbcType=VARCHAR},",
          "shippingTo = #{shippingTo,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "saleOrderId = #{saleOrderId,jdbcType=BIGINT},",
          "displayOrder = #{displayOrder,jdbcType=INTEGER},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where shippingId = #{shippingId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShippingEntity record);
}