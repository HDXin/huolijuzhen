package com.sudaotech.area.service;

import java.util.List;

import com.sudaotech.core.service.BaseService;

public interface AreaService extends BaseService {
    Province getProvince(int areaId);
    City getCity(int areaId);
    Area getArea(int areaId);

    Area getByAreaId(int areaId);

    Area getByAreaName(String name);

    List<Area> findByParentId(int parentId);
    
    List<Area> findAll();
    
}
