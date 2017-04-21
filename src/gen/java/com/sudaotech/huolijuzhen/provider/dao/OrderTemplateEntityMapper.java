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

public interface OrderTemplateEntityMapper {
    @SelectProvider(type=OrderTemplateEntitySqlProvider.class, method="countByExample")
    int countByExample(OrderTemplateEntityExample example);

    @DeleteProvider(type=OrderTemplateEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderTemplateEntityExample example);

    @Delete({
        "delete from order_template",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into order_template (id, serviceProId, ",
        "supportAliPay, supportWeChatPay, ",
        "priceTitleOne, priceTitleTwo, ",
        "priceTitleThree, discountTitleOne, ",
        "discountTitleTwo, discountTitleThree, ",
        "discountThree, discountOne, ",
        "priceThree, priceOne, ",
        "priceTwo, discountTwo, ",
        "version, status, ",
        "createBy, createTime, ",
        "updateBy, updateTime, ",
        "lastUpdate)",
        "values (#{id,jdbcType=BIGINT}, #{serviceProId,jdbcType=BIGINT}, ",
        "#{supportAliPay,jdbcType=BIT}, #{supportWeChatPay,jdbcType=BIT}, ",
        "#{priceTitleOne,jdbcType=VARCHAR}, #{priceTitleTwo,jdbcType=VARCHAR}, ",
        "#{priceTitleThree,jdbcType=VARCHAR}, #{discountTitleOne,jdbcType=VARCHAR}, ",
        "#{discountTitleTwo,jdbcType=VARCHAR}, #{discountTitleThree,jdbcType=VARCHAR}, ",
        "#{discountThree,jdbcType=DOUBLE}, #{discountOne,jdbcType=DOUBLE}, ",
        "#{priceThree,jdbcType=DOUBLE}, #{priceOne,jdbcType=DOUBLE}, ",
        "#{priceTwo,jdbcType=DOUBLE}, #{discountTwo,jdbcType=DOUBLE}, ",
        "#{version,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createBy,jdbcType=BIGINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(OrderTemplateEntity record);

    @InsertProvider(type=OrderTemplateEntitySqlProvider.class, method="insertSelective")
    int insertSelective(OrderTemplateEntity record);

    @SelectProvider(type=OrderTemplateEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportAliPay", property="supportAliPay", jdbcType=JdbcType.BIT),
        @Result(column="supportWeChatPay", property="supportWeChatPay", jdbcType=JdbcType.BIT),
        @Result(column="priceTitleOne", property="priceTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleTwo", property="priceTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleThree", property="priceTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleOne", property="discountTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleTwo", property="discountTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleThree", property="discountTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountThree", property="discountThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountOne", property="discountOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceThree", property="priceThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceOne", property="priceOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceTwo", property="priceTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountTwo", property="discountTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderTemplateEntity> selectByExampleWithRowbounds(OrderTemplateEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=OrderTemplateEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportAliPay", property="supportAliPay", jdbcType=JdbcType.BIT),
        @Result(column="supportWeChatPay", property="supportWeChatPay", jdbcType=JdbcType.BIT),
        @Result(column="priceTitleOne", property="priceTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleTwo", property="priceTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleThree", property="priceTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleOne", property="discountTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleTwo", property="discountTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleThree", property="discountTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountThree", property="discountThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountOne", property="discountOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceThree", property="priceThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceOne", property="priceOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceTwo", property="priceTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountTwo", property="discountTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderTemplateEntity> selectByExample(OrderTemplateEntityExample example);

    @Select({
        "select",
        "id, serviceProId, supportAliPay, supportWeChatPay, priceTitleOne, priceTitleTwo, ",
        "priceTitleThree, discountTitleOne, discountTitleTwo, discountTitleThree, discountThree, ",
        "discountOne, priceThree, priceOne, priceTwo, discountTwo, version, status, createBy, ",
        "createTime, updateBy, updateTime, lastUpdate",
        "from order_template",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportAliPay", property="supportAliPay", jdbcType=JdbcType.BIT),
        @Result(column="supportWeChatPay", property="supportWeChatPay", jdbcType=JdbcType.BIT),
        @Result(column="priceTitleOne", property="priceTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleTwo", property="priceTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="priceTitleThree", property="priceTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleOne", property="discountTitleOne", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleTwo", property="discountTitleTwo", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountTitleThree", property="discountTitleThree", jdbcType=JdbcType.VARCHAR),
        @Result(column="discountThree", property="discountThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountOne", property="discountOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceThree", property="priceThree", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceOne", property="priceOne", jdbcType=JdbcType.DOUBLE),
        @Result(column="priceTwo", property="priceTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="discountTwo", property="discountTwo", jdbcType=JdbcType.DOUBLE),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    OrderTemplateEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderTemplateEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderTemplateEntity record, @Param("example") OrderTemplateEntityExample example);

    @UpdateProvider(type=OrderTemplateEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderTemplateEntity record, @Param("example") OrderTemplateEntityExample example);

    @UpdateProvider(type=OrderTemplateEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderTemplateEntity record);

    @Update({
        "update order_template",
        "set serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "supportAliPay = #{supportAliPay,jdbcType=BIT},",
          "supportWeChatPay = #{supportWeChatPay,jdbcType=BIT},",
          "priceTitleOne = #{priceTitleOne,jdbcType=VARCHAR},",
          "priceTitleTwo = #{priceTitleTwo,jdbcType=VARCHAR},",
          "priceTitleThree = #{priceTitleThree,jdbcType=VARCHAR},",
          "discountTitleOne = #{discountTitleOne,jdbcType=VARCHAR},",
          "discountTitleTwo = #{discountTitleTwo,jdbcType=VARCHAR},",
          "discountTitleThree = #{discountTitleThree,jdbcType=VARCHAR},",
          "discountThree = #{discountThree,jdbcType=DOUBLE},",
          "discountOne = #{discountOne,jdbcType=DOUBLE},",
          "priceThree = #{priceThree,jdbcType=DOUBLE},",
          "priceOne = #{priceOne,jdbcType=DOUBLE},",
          "priceTwo = #{priceTwo,jdbcType=DOUBLE},",
          "discountTwo = #{discountTwo,jdbcType=DOUBLE},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderTemplateEntity record);
}