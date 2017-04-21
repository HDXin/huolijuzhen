package com.sudaotech.huolijuzhen.basic.dao;

import com.sudaotech.core.enums.Status;
import com.sudaotech.huolijuzhen.dao.ParkGroupUserInfoEntityMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ParkGroupUserMapper extends ParkGroupUserInfoEntityMapper {


    @Update({
            "update park_group_user_info",
            "set status = #{status,jdbcType=INTEGER}",
            "where parkGroupId in (#{parkGroupIds,jdbcType=VARCHAR})"
    })
    int updateByStatusByParkGroupIds(@Param("status") Status status, @Param("parkGroupIds") String parkGroupIds);
}
