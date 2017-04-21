package com.sudaotech.huolijuzhen.provider.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.FindServiceProByCurrentUser;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.Query;
import com.sudaotech.huolijuzhen.provider.service.ServiceProjectService.ServiceProject;

public interface LocationServiceProjectEntityMapper extends ServiceProjectEntityMapper{
    

	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findParkServiceSql")
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
        @Result(column="releases", property="releases", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
	public List<ServiceProject> findParkServiceSql(Query query);

	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findParkServiceSqlCount")
	public Integer findParkServiceSqlCount(Query query);
	
	
	@Select("select id id"
			+ " from service_pro "
			+ " where 1 = 1 "
			+ " and status = #{status} "
			+ " and serviceGrade = #{serviceGrade}")
	@Results({
		@Result(id=true,column="id",property="id")
	})
	public List<Long> getServiceProIdByServiceGrade(Map<String, Object> params);
	
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findServiceProByCurrentUser")
	@Results({
		@Result(id=true,column="id",property="id")
	})
	public List<Long> findServiceProByCurrentUser(FindServiceProByCurrentUser condition);
	
	
	
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findParkValidServiceProCount")
	public Integer findParkValidServiceProCount(Map<String,Object> paramsMap);
	
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findParkValidServicePro")
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
        @Result(column="releases", property="releases", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
	public List<ServiceProject> findParkValidServicePro(Map<String,Object> paramsMap);

	//平台有权看到的所有服务项目
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findPlatformServiceIds")
	@Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true)
    })
	public List<Long> findPlatformServiceIds();

	/**
	 * 平台有权限看到的服务项目数量
	 * @param params
	 * @return
	 */
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findPlatformServiceSqlCount")
	public Integer findPlatformServiceCount(Query query);
	
	/**
	 * 平台有权看到的服务项目（分页）
	 * @param params
	 * @return
	 */
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="findPlatformServiceSql")
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
        @Result(column="releases", property="releases", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
	public List<ServiceProject> findPlatformService(Query query);

	@Select("SELECT sp.serviceTypeId serviceTypeId,st.name serviceTypeName,SUM(sp.readNum) sumReadNum FROM service_pro sp"
			+ " LEFT JOIN service_type st ON sp.serviceTypeId = st.id "
			+ " GROUP BY sp.serviceTypeId"
			+ " ORDER BY sumReadNum DESC"
			+ " LIMIT 0,10")
	@Results({
        @Result(column="serviceTypeId", property="serviceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="serviceTypeName", property="serviceTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sumReadNum", property="sumReadNum", jdbcType=JdbcType.INTEGER),
    })
	public List<Map<String, Object>> statisticsByServiceType();

	@Select("SELECT mainTitle,readNum FROM service_pro"
			+ " ORDER BY readNum DESC"
			+ " LIMIT 0,10")
	@Results({
        @Result(column="mainTitle", property="mainTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="readNum", property="readNum", jdbcType=JdbcType.INTEGER),
    })
	public List<Map<String, Object>> statisticsByReadNum();

	/**
	 * 运营平台的服务项目的数据统计
	 * @param paramsMap
	 * @return
	 */
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="statisticsToPlatform")
	public List<Map<String, Object>> statisticsToPlatform(Map<String, Object> paramsMap);
	
	/**
	 * 园区管理 Web 服务项目的数据统计
	 * @param paramsMap
	 * @return
	 */
	@SelectProvider(type=LocationServiceProjectSqlProvider.class,method="statisticsToPark")
	public List<Map<String, Object>> statisticsToPark(Map<String, Object> paramsMap);
}