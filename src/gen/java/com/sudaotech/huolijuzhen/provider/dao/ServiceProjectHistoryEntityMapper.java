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

public interface ServiceProjectHistoryEntityMapper {
    @SelectProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="countByExample")
    int countByExample(ServiceProjectHistoryEntityExample example);

    @DeleteProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceProjectHistoryEntityExample example);

    @Delete({
        "delete from service_pro_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into service_pro_history (id, mainTitle, ",
        "subTitle, serviceTypeId, ",
        "serverGrade, serviceGrade, ",
        "serviceGradeId, serviceGradeName, ",
        "parkId, supportApply, ",
        "applyViewId, supportOrder, ",
        "orderViewId, version, ",
        "status, createBy, ",
        "createTime, updateBy, ",
        "updateTime, lastUpdate, ",
        "approvalStatus, approvalBy, ",
        "approvalTime, approvalText, ",
        "parkProId, parkCityId, ",
        "parkCounId, parkLocationId, ",
        "applyOrderNum, collectNum, ",
        "readNum, commentNum, ",
        "serviceProId, serviceProRelease, ",
        "content)",
        "values (#{id,jdbcType=BIGINT}, #{mainTitle,jdbcType=VARCHAR}, ",
        "#{subTitle,jdbcType=VARCHAR}, #{serviceTypeId,jdbcType=BIGINT}, ",
        "#{serverGrade,jdbcType=INTEGER}, #{serviceGrade,jdbcType=INTEGER}, ",
        "#{serviceGradeId,jdbcType=BIGINT}, #{serviceGradeName,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=BIGINT}, #{supportApply,jdbcType=BIT}, ",
        "#{applyViewId,jdbcType=BIGINT}, #{supportOrder,jdbcType=BIT}, ",
        "#{orderViewId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createBy,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{approvalStatus,jdbcType=INTEGER}, #{approvalBy,jdbcType=BIGINT}, ",
        "#{approvalTime,jdbcType=TIMESTAMP}, #{approvalText,jdbcType=VARCHAR}, ",
        "#{parkProId,jdbcType=BIGINT}, #{parkCityId,jdbcType=BIGINT}, ",
        "#{parkCounId,jdbcType=BIGINT}, #{parkLocationId,jdbcType=BIGINT}, ",
        "#{applyOrderNum,jdbcType=INTEGER}, #{collectNum,jdbcType=INTEGER}, ",
        "#{readNum,jdbcType=INTEGER}, #{commentNum,jdbcType=DECIMAL}, ",
        "#{serviceProId,jdbcType=BIGINT}, #{serviceProRelease,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ServiceProjectHistoryEntity record);

    @InsertProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="insertSelective")
    int insertSelective(ServiceProjectHistoryEntity record);

    @SelectProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="subTitle", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGrade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGradeId", property="serviceGradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceGradeName", property="serviceGradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportApply", property="supportApply", jdbcType=JdbcType.BIT),
        @Result(column="applyViewId", property="applyViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportOrder", property="supportOrder", jdbcType=JdbcType.BIT),
        @Result(column="orderViewId", property="orderViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkProId", property="parkProId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCityId", property="parkCityId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCounId", property="parkCounId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkLocationId", property="parkLocationId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyOrderNum", property="applyOrderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="collectNum", property="collectNum", jdbcType=JdbcType.INTEGER),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentNum", property="commentNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ServiceProjectHistoryEntity> selectByExampleWithBLOBsWithRowbounds(ServiceProjectHistoryEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="subTitle", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGrade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGradeId", property="serviceGradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceGradeName", property="serviceGradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportApply", property="supportApply", jdbcType=JdbcType.BIT),
        @Result(column="applyViewId", property="applyViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportOrder", property="supportOrder", jdbcType=JdbcType.BIT),
        @Result(column="orderViewId", property="orderViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkProId", property="parkProId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCityId", property="parkCityId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCounId", property="parkCounId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkLocationId", property="parkLocationId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyOrderNum", property="applyOrderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="collectNum", property="collectNum", jdbcType=JdbcType.INTEGER),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentNum", property="commentNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<ServiceProjectHistoryEntity> selectByExampleWithBLOBs(ServiceProjectHistoryEntityExample example);

    @SelectProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="subTitle", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGrade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGradeId", property="serviceGradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceGradeName", property="serviceGradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportApply", property="supportApply", jdbcType=JdbcType.BIT),
        @Result(column="applyViewId", property="applyViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportOrder", property="supportOrder", jdbcType=JdbcType.BIT),
        @Result(column="orderViewId", property="orderViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkProId", property="parkProId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCityId", property="parkCityId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCounId", property="parkCounId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkLocationId", property="parkLocationId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyOrderNum", property="applyOrderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="collectNum", property="collectNum", jdbcType=JdbcType.INTEGER),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentNum", property="commentNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceProjectHistoryEntity> selectByExampleWithRowbounds(ServiceProjectHistoryEntityExample example, RowBounds rowBounds);

    @SelectProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="subTitle", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGrade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGradeId", property="serviceGradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceGradeName", property="serviceGradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportApply", property="supportApply", jdbcType=JdbcType.BIT),
        @Result(column="applyViewId", property="applyViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportOrder", property="supportOrder", jdbcType=JdbcType.BIT),
        @Result(column="orderViewId", property="orderViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkProId", property="parkProId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCityId", property="parkCityId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCounId", property="parkCounId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkLocationId", property="parkLocationId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyOrderNum", property="applyOrderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="collectNum", property="collectNum", jdbcType=JdbcType.INTEGER),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentNum", property="commentNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER)
    })
    List<ServiceProjectHistoryEntity> selectByExample(ServiceProjectHistoryEntityExample example);

    @Select({
        "select",
        "id, mainTitle, subTitle, serviceTypeId, serverGrade, serviceGrade, serviceGradeId, ",
        "serviceGradeName, parkId, supportApply, applyViewId, supportOrder, orderViewId, ",
        "version, status, createBy, createTime, updateBy, updateTime, lastUpdate, approvalStatus, ",
        "approvalBy, approvalTime, approvalText, parkProId, parkCityId, parkCounId, parkLocationId, ",
        "applyOrderNum, collectNum, readNum, commentNum, serviceProId, serviceProRelease, ",
        "content",
        "from service_pro_history",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="subTitle", property="subTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serverGrade", property="serverGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGrade", property="serviceGrade", jdbcType=JdbcType.INTEGER),
        @Result(column="serviceGradeId", property="serviceGradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceGradeName", property="serviceGradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkId", property="parkId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportApply", property="supportApply", jdbcType=JdbcType.BIT),
        @Result(column="applyViewId", property="applyViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="supportOrder", property="supportOrder", jdbcType=JdbcType.BIT),
        @Result(column="orderViewId", property="orderViewId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="createBy", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateBy", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="updateTime", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="lastUpdate", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalStatus", property="approvalStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="approvalBy", property="approvalBy", jdbcType=JdbcType.BIGINT),
        @Result(column="approvalTime", property="approvalTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="approvalText", property="approvalText", jdbcType=JdbcType.VARCHAR),
        @Result(column="parkProId", property="parkProId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCityId", property="parkCityId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkCounId", property="parkCounId", jdbcType=JdbcType.BIGINT),
        @Result(column="parkLocationId", property="parkLocationId", jdbcType=JdbcType.BIGINT),
        @Result(column="applyOrderNum", property="applyOrderNum", jdbcType=JdbcType.INTEGER),
        @Result(column="collectNum", property="collectNum", jdbcType=JdbcType.INTEGER),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
        @Result(column="commentNum", property="commentNum", jdbcType=JdbcType.DECIMAL),
        @Result(column="serviceProId", property="serviceProId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceProRelease", property="serviceProRelease", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    ServiceProjectHistoryEntity selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceProjectHistoryEntity record, @Param("example") ServiceProjectHistoryEntityExample example);

    @UpdateProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ServiceProjectHistoryEntity record, @Param("example") ServiceProjectHistoryEntityExample example);

    @UpdateProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceProjectHistoryEntity record, @Param("example") ServiceProjectHistoryEntityExample example);

    @UpdateProvider(type=ServiceProjectHistoryEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceProjectHistoryEntity record);

    @Update({
        "update service_pro_history",
        "set mainTitle = #{mainTitle,jdbcType=VARCHAR},",
          "subTitle = #{subTitle,jdbcType=VARCHAR},",
          "serviceTypeId = #{serviceTypeId,jdbcType=BIGINT},",
          "serverGrade = #{serverGrade,jdbcType=INTEGER},",
          "serviceGrade = #{serviceGrade,jdbcType=INTEGER},",
          "serviceGradeId = #{serviceGradeId,jdbcType=BIGINT},",
          "serviceGradeName = #{serviceGradeName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "supportApply = #{supportApply,jdbcType=BIT},",
          "applyViewId = #{applyViewId,jdbcType=BIGINT},",
          "supportOrder = #{supportOrder,jdbcType=BIT},",
          "orderViewId = #{orderViewId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "parkProId = #{parkProId,jdbcType=BIGINT},",
          "parkCityId = #{parkCityId,jdbcType=BIGINT},",
          "parkCounId = #{parkCounId,jdbcType=BIGINT},",
          "parkLocationId = #{parkLocationId,jdbcType=BIGINT},",
          "applyOrderNum = #{applyOrderNum,jdbcType=INTEGER},",
          "collectNum = #{collectNum,jdbcType=INTEGER},",
          "readNum = #{readNum,jdbcType=INTEGER},",
          "commentNum = #{commentNum,jdbcType=DECIMAL},",
          "serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(ServiceProjectHistoryEntity record);

    @Update({
        "update service_pro_history",
        "set mainTitle = #{mainTitle,jdbcType=VARCHAR},",
          "subTitle = #{subTitle,jdbcType=VARCHAR},",
          "serviceTypeId = #{serviceTypeId,jdbcType=BIGINT},",
          "serverGrade = #{serverGrade,jdbcType=INTEGER},",
          "serviceGrade = #{serviceGrade,jdbcType=INTEGER},",
          "serviceGradeId = #{serviceGradeId,jdbcType=BIGINT},",
          "serviceGradeName = #{serviceGradeName,jdbcType=VARCHAR},",
          "parkId = #{parkId,jdbcType=BIGINT},",
          "supportApply = #{supportApply,jdbcType=BIT},",
          "applyViewId = #{applyViewId,jdbcType=BIGINT},",
          "supportOrder = #{supportOrder,jdbcType=BIT},",
          "orderViewId = #{orderViewId,jdbcType=BIGINT},",
          "version = #{version,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "createBy = #{createBy,jdbcType=BIGINT},",
          "createTime = #{createTime,jdbcType=TIMESTAMP},",
          "updateBy = #{updateBy,jdbcType=BIGINT},",
          "updateTime = #{updateTime,jdbcType=TIMESTAMP},",
          "lastUpdate = #{lastUpdate,jdbcType=TIMESTAMP},",
          "approvalStatus = #{approvalStatus,jdbcType=INTEGER},",
          "approvalBy = #{approvalBy,jdbcType=BIGINT},",
          "approvalTime = #{approvalTime,jdbcType=TIMESTAMP},",
          "approvalText = #{approvalText,jdbcType=VARCHAR},",
          "parkProId = #{parkProId,jdbcType=BIGINT},",
          "parkCityId = #{parkCityId,jdbcType=BIGINT},",
          "parkCounId = #{parkCounId,jdbcType=BIGINT},",
          "parkLocationId = #{parkLocationId,jdbcType=BIGINT},",
          "applyOrderNum = #{applyOrderNum,jdbcType=INTEGER},",
          "collectNum = #{collectNum,jdbcType=INTEGER},",
          "readNum = #{readNum,jdbcType=INTEGER},",
          "commentNum = #{commentNum,jdbcType=DECIMAL},",
          "serviceProId = #{serviceProId,jdbcType=BIGINT},",
          "serviceProRelease = #{serviceProRelease,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceProjectHistoryEntity record);
}