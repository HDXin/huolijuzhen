package com.sudaotech.huolijuzhen.sys.common.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Update;

public interface LocationImageInfoEntityMapper extends ImageInfoEntityMapper{

	@Update("update image_info set status = #{status}"
			+ " where 1=1 "
			+ " and imageType = #{imageType}"
			+ " and targetId = #{targetId}")
	int deleteMore(Map<String, Object> parmas);
}