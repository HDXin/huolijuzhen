package com.sudaotech.area.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.area.dao.AreaEntity;
import com.sudaotech.area.dao.AreaEntityExample;
import com.sudaotech.area.dao.AreaMapper;
import com.sudaotech.core.Cachable;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.util.BeanUtils;

public class AreaServiceImpl extends BaseServiceImpl implements AreaService {

    @Inject
    private AreaMapper areaMapper;

    @Override
    public List<Area> findByParentId(final int parentId) {
        if (parentId < 0) {
            return Collections.emptyList();
        }
        
        Cachable<List<Area>> cache = new Cachable<List<Area>>() {
            @Override
            public Object getKey() {
                return "areas-parentId:" + parentId;
            }
            @Override
            public List<Area> getValue() {
                AreaEntityExample example = new AreaEntityExample();
                example.createCriteria().andStatusEqualTo(Status.NORMAL).andParentIdEqualTo(parentId);
                List<AreaEntity> entityList = areaMapper.selectByExample(example);
                return BeanUtils.copyListProperties(entityList, Area.class);
            }};
            
        return this.getCacheService().cache(cache);
    }

    @Override
    public Area getByAreaId(final int areaId) {
        if (areaId <= 0) {
            return null;
        }
        Cachable<Area> cache = new Cachable<Area>(){
            @Override
            public Object getKey() {
                return "area-areaId:" + areaId;
            }
            @Override
            public Area getValue() {
                AreaEntity entity = areaMapper.selectByPrimaryKey(areaId);
                
                return BeanUtils.copyProperties(entity, Area.class);
            }
            
        };
        return this.getCacheService().cache(cache);
    }

    @Override
    public Area getByAreaName(String areaName) {
        String name = StringUtils.trim(areaName);
        if (StringUtils.length(name) < 2) {
            logger.warn("Illegal area name: {}", name);
            return null;
        }

        Area area = this.areaMapper.getAreaByName(name + "%");
        // 健壮性处理：若没有找到，取前2个字符再次查找
        if (area == null && name.length() > 2) {
            logger.warn("Not found area: {}, try to find by: {}", name, name.substring(0, 2));
            area = this.areaMapper.getAreaByName(name.substring(0, 2) + "%");
        }
        
        return area;
    }

    @Override
    public List<Area> findAll() {
        AreaEntityExample example = new AreaEntityExample();
        example.createCriteria().andStatusEqualTo(Status.NORMAL);
        List<AreaEntity> entityList = areaMapper.selectByExample(example);
        List<Area> list = BeanUtils.copyListProperties(entityList, Area.class);
        Map<Integer, Area> areaMap = new LinkedHashMap<Integer, Area>();
        // put in map
        for (Area area : list) {
            areaMap.put(area.getAreaId(), area);
        }
        // parent-child merge
        for (Area area : list) {
            if (area.getParentId() > 0) {
                Area parentArea = areaMap.get(area.getParentId());
                parentArea.addItem(area);
            }
        }
        // cascade
        List<Area> result = new ArrayList<Area>();
        for (Area area : list) {
            if (area.getParentId() == 0) {
                result.add(area);
            }
        }
        
        return result;
    }

    @Override
    public Province getProvince(int areaId) {
        return BeanUtils.copyProperties(this.getByAreaId(areaId), Province.class);
    }

    @Override
    public City getCity(int areaId) {
        return BeanUtils.copyProperties(this.getByAreaId(areaId), City.class);
    }

    @Override
    public Area getArea(int areaId) {
        return this.getByAreaId(areaId);
    }
}
