package com.sudaotech.user.dao.handler;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.sudaotech.user.dao.AdminUserEntityMapper;

public interface LocationAdminUserEntityMapper extends AdminUserEntityMapper{
    
    //获取平台下所有园区用户、企业用户
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllParkEnterpriseUserId")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})
	public List<Long> findAllParkEnterpriseUserId();
	//获取平台下所有园区用户
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllParkUserId")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})
	public List<Long> findAllParkUserId();

	//获取平台下所有企业用户
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllEnterpriseUerId")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})
	public List<Long> findAllEnterpriseUerId();

	//获取行政区下所有园区用户、企业用户
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})
	public List<Long> findAllParkEnterpriseUserIdByParkIdsAndEnterpriseIds(Map<String,Object> params);

	//获取行政区下所有园区用户
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllParkUserIdByParkIds")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})
	public List<Long> findAllParkUserIdByParkIds(Map<String,Object> params);

	//获取行政区下所有企业用户
	
	@SelectProvider(type=LocationAdminUserEntitySqlProvider.class,method="findAllEnterpriseUserIdByEnterpriseIds")
	@Results({
		@Result(id=true,column="userId",property="userId")
	})public List<Long> findAllEnterpriseUserIdByEnterpriseIds(Map<String,Object> params);
	
}