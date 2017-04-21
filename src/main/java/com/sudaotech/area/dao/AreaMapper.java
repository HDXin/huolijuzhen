package com.sudaotech.area.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sudaotech.area.service.Area;

public interface AreaMapper extends AreaEntityMapper {

    @Select({ "select * from Area c where c.status = 1 and c.name like #{name}" })
    Area getAreaByName(@Param("name") String name);
}