package com.sudaotech.huolijuzhen.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sudaotech.huolijuzhen.community.service.CommunityService.Community;

public interface LocationCommunityEntityMapper extends CommunityEntityMapper {
    
	
	@Select("select id from community_info where id = #{itemId} and createSide = #{createSide}")
	@Results(@Result(id=true,column="id",property="id"))
	public Long hasPlatformEditPrivilegeById(Map<String, Object> params);
	
	@Select("select id from community_info where id=#{itemId} and createSide = #{createSide} and parkId = #{parkId}")
	@Results(@Result(id=true,column="id",property="id"))
	public Long hasParkEditPrivilegeById(Map<String, Object> params);
	
	/**
	 * 查询符合条件的活动数
	 * @param params
	 * @return
	 */
	@Select("select count(id) from community_info where 1=1 "
			+ " and approvalStatus = #{approvalStatus} "
			+ " and status = #{status} "
			+ " and publicGrade = #{platform}")
	public Integer getPlatformCountByCondition(Map<String, Object> params);
	
	/**
	 * 分页查询符合条件的活动
	 * @param params
	 * @return
	 */
	@Select("select "
			+ "id id,"
			+ "title title,"
			+ "discrible discrible,"
			+ "publicGrade publicGrade,"
			+ "parkId parkId,"
			+ "proId proId,"
			+ "cityId cityId,"
			+ "counId counId,"
			+ "locationId locationId,"
			+ "approvalStatus approvalStatus,"
			+ "approvalBy approvalBy,"
			+ "approvalMemo approvalMemo,"
			+ "approvalTime approvalTime,"
			+ "createBy createBy,"
			+ "createTime createTime,"
			+ "createSide createSide,"
			+ "createSideId createSideId"
			+ " from community_info where 1=1 "
			+ " and approvalStatus = #{approvalStatus} "
			+ " and status = #{status} "
			+ " and publicGrade = #{platform}"
			+ " order by approvalTime DESC "
			+ " limit #{offset},#{limit}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="describle",property="describle"),
		@Result(column="approvalTime",property="approvalTime")})
	public List<Community> getPagePlatformByCondition(Map<String, Object> params);
	
	/**
	 * 查询符合条件的活动数
	 * @param params
	 * @return
	 */
	@Select("select count(id) from community_info where "
			+ " approvalStatus = #{approvalStatus} and status = #{status} "
			+ " and (publicGrade = #{platform}"
			+ " or (publicGrade = #{park} and parkId = #{parkId})"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId = #{counId} and locationId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId = #{counId} and locationId = #{locationId}))")
	public Integer getCountByCondition(Map<String, Object> params);
	
	/**
	 * 分页查询符合条件的活动
	 * @param params
	 * @return
	 */
	@Select("select "
			+ "id id,"
			+ "title title,"
			+ "discrible discrible,"
			+ "publicGrade publicGrade,"
			+ "parkId parkId,"
			+ "proId proId,"
			+ "cityId cityId,"
			+ "counId counId,"
			+ "locationId locationId,"
			+ "approvalStatus approvalStatus,"
			+ "approvalBy approvalBy,"
			+ "approvalMemo approvalMemo,"
			+ "approvalTime approvalTime,"
			+ "createBy createBy,"
			+ "createTime createTime,"
			+ "createSide createSide,"
			+ "createSideId createSideId"
			+ " from community_info where "
			+ " approvalStatus = #{approvalStatus} and status = #{status} "
			+ " and (publicGrade = #{platform}"
			+ " or (publicGrade = #{park} and parkId = #{parkId})"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId = #{counId} and locationId is null)"
			+ " or (publicGrade = #{administractive} and proId = #{proId} and cityId = #{cityId} and counId = #{counId} and locationId = #{locationId}))"
			+ " order by approvalTime DESC "
			+ " limit #{offset},#{limit}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="title",property="title"),
		@Result(column="describle",property="describle"),
		@Result(column="approvalTime",property="approvalTime")})
	public List<Community> getPageByCondition(Map<String, Object> params);
	
}