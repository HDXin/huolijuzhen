package com.sudaotech.huolijuzhen.bill.dao;

import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntity;
import com.sudaotech.huolijuzhen.bill.dao.BillPayVoucherEntityExample;
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

public interface BillPayVoucherEntityMapper {
    @SelectProvider(type=BillPayVoucherEntitySqlProvider.class, method="countByExample")
    int countByExample(BillPayVoucherEntityExample example);

    @DeleteProvider(type=BillPayVoucherEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(BillPayVoucherEntityExample example);

    @Delete({
        "delete from bill_pay_voucher",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into bill_pay_voucher (id, billId, ",
        "fileType, fileName, ",
        "fileUrl, imgLink, ",
        "fileDesc, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{billId,jdbcType=BIGINT}, ",
        "#{fileType,jdbcType=INTEGER}, #{fileName,jdbcType=VARCHAR}, ",
        "#{fileUrl,jdbcType=VARCHAR}, #{imgLink,jdbcType=VARCHAR}, ",
        "#{fileDesc,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(BillPayVoucherEntity record);

    @InsertProvider(type=BillPayVoucherEntitySqlProvider.class, method="insertSelective")
    int insertSelective(BillPayVoucherEntity record);

    @SelectProvider(type=BillPayVoucherEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillPayVoucherEntity> selectByExampleWithRowbounds(BillPayVoucherEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=BillPayVoucherEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BillPayVoucherEntity> selectByExample(BillPayVoucherEntityExample example);

    @Select({
        "select",
        "id, billId, fileType, fileName, fileUrl, imgLink, fileDesc, version, status, ",
        "createBy, createTime, updateBy, updateTime, lastUpdate",
        "from bill_pay_voucher",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="billId", property="billId", jdbcType=JdbcType.BIGINT),
        @Result(column="fileType", property="fileType", jdbcType=JdbcType.INTEGER),
        @Result(column="fileName", property="fileName", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileUrl", property="fileUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgLink", property="imgLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="fileDesc", property="fileDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    BillPayVoucherEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=BillPayVoucherEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BillPayVoucherEntity record, @Param("example") BillPayVoucherEntityExample example);

    @UpdateProvider(type=BillPayVoucherEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BillPayVoucherEntity record, @Param("example") BillPayVoucherEntityExample example);

    @UpdateProvider(type=BillPayVoucherEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BillPayVoucherEntity record);

    @Update({
        "update bill_pay_voucher",
        "set billId = #{billId,jdbcType=BIGINT},",
          "fileType = #{fileType,jdbcType=INTEGER},",
          "fileName = #{fileName,jdbcType=VARCHAR},",
          "fileUrl = #{fileUrl,jdbcType=VARCHAR},",
          "imgLink = #{imgLink,jdbcType=VARCHAR},",
          "fileDesc = #{fileDesc,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BillPayVoucherEntity record);
}