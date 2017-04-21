package com.sudaotech.huolijuzhen.basic.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.enums.Status;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.web.result.Page;
import com.sudaotech.huolijuzhen.basic.dao.LocationEntity;
import com.sudaotech.huolijuzhen.basic.dao.LocationEntityExample;
import com.sudaotech.huolijuzhen.basic.dao.LocationEntityExample.Criteria;
import com.sudaotech.huolijuzhen.basic.dao.ServiceLocationEntityMapper;
import com.sudaotech.huolijuzhen.enums.EnableStatus;
import com.sudaotech.util.BeanUtils;

public class LocationServiceImpl extends BaseServiceImpl implements LocationService {
    private static final String TRACKING_TYPE = "Location";

    @Inject
    private ServiceLocationEntityMapper locationEntityMapper;

    @Override
    public Location getById(Long id) {
        LocationEntity entity = this.locationEntityMapper.selectByPrimaryKey(id);
        if (entity != null && Status.NORMAL.equals(entity.getStatus())) {
            return BeanUtils.copyProperties(entity, Location.class);
        }

        return null;
    }

    @Override
    public Long create(Location obj) {
        logger.debug("Creating Location: {}", obj);

        obj.setId(this.getSequenceService().nextLong());
        Date now = new Date();
        LocationEntity entity = BeanUtils.copyProperties(obj, LocationEntity.class);
        entity.setStatus(Status.NORMAL);
        entity.setCreateBy(obj.getOperator());
        entity.setCreateTime(now);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(now);
        entity.setLastUpdate(now);
        entity.setVersion(0);

        //设置商业圈的启用状态
        EnableStatus enableStatus = obj.getEnableStatus();
        if (enableStatus.code() == 0) {
            entity.setEnableBy(obj.getOperator());
            entity.setEnableTime(now);
        } else {
            entity.setDisableBy(obj.getOperator());
            entity.setDisableTime(now);
        }

        this.locationEntityMapper.insertSelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "create", entity);

        logger.info("Created Location: {}", obj);

        return obj.getId();
    }

    @Override
    public void update(Location obj) {
        logger.debug("Updating Location: {}", obj);

        LocationEntity entity = BeanUtils.copyProperties(obj, LocationEntity.class);
        entity.setUpdateBy(obj.getOperator());
        entity.setUpdateTime(new Date());
        this.locationEntityMapper.updateByPrimaryKeySelective(entity);

        this.getTrackingService().save(TRACKING_TYPE, entity.getId(), "update", entity);

        logger.info("Updated Location: {}", obj);
    }

    @Override
    public Long save(Location obj) {
        logger.debug("Saving Location: {}", obj);

        if (obj.getId() == null) {
            this.create(obj);
        } else {
            this.update(obj);
        }

        return obj.getId();
    }

    @Override
    public Page<Location> find(Query query) {
        Page<Location> page = new Page<Location>(query);
        LocationEntityExample example = new LocationEntityExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Status.NORMAL);

        example.setOrderByClause("createTime DESC");
        page.setTotal(this.locationEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<LocationEntity> list = this.locationEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, Location.class));
        }

        return page;
    }

    @Override
    public Page<Location> findByCondition(Query query) {

        Page<Location> page = new Page<Location>(query);
        LocationEntityExample example = new LocationEntityExample();
        Criteria criteria = example.createCriteria();

        Long proId = query.getProId();
        if (proId != null) {
            criteria.andProIdEqualTo(proId);
        }
        Long cityId = query.getCityId();
        if (cityId != null) {
            criteria.andCityIdEqualTo(cityId);
        }
        Long counId = query.getCounId();
        if (counId != null) {
            criteria.andCounIdEqualTo(counId);
        }
        String enable = query.getEnableStatus();
        if (StringUtils.isNotBlank(enable)) {
            criteria.andEnableStatusEqualTo(EnableStatus.valueOf(enable));
        }
        if (query.getLocationId() != null) {
            criteria.andIdEqualTo(query.getLocationId());
        }
        criteria.andStatusEqualTo(Status.NORMAL);
        example.setOrderByClause("createTime DESC");
        page.setTotal(this.locationEntityMapper.countByExample(example));
        if (page.getTotal() > query.getOffset()) {
            List<LocationEntity> list = this.locationEntityMapper.selectByExampleWithRowbounds(example, this.toRowBounds(query));
            page.setItems(BeanUtils.copyListProperties(list, Location.class));
        }

        return page;
    }

    @Override
    public List<Long> findAllProvince() {
        Map<String, Object> paramMap = new HashedMap<String, Object>();
        paramMap.put("status", Status.NORMAL.code());
        paramMap.put("enableStatus", EnableStatus.ENABLE.code());
        List<Long> ids = locationEntityMapper.selectAllProvince(paramMap);
        return ids;
    }

    @Override
    public List<Long> findCityByProvinceId(Long proId) {
        Map<String, Object> paramMap = new HashedMap<String, Object>();
        paramMap.put("proId", proId);
        paramMap.put("status", Status.NORMAL.code());
        paramMap.put("enableStatus", EnableStatus.ENABLE.code());
        List<Long> ids = locationEntityMapper.selectCityByProId(paramMap);
        return ids;
    }

    @Override
    public List<Long> findCountoryBycityId(Long cityId) {
        Map<String, Object> paramMap = new HashedMap<String, Object>();
        paramMap.put("cityId", cityId);
        paramMap.put("status", Status.NORMAL.code());
        paramMap.put("enableStatus", EnableStatus.ENABLE.code());
        List<Long> ids = locationEntityMapper.selectCountoryByCityId(paramMap);
        return ids;
    }

    @Override
    public List<Map<String, Object>> findBusinessByCounId(Long counId) {
        Map<String, Object> paramMap = new HashedMap<String, Object>();
        paramMap.put("counId", counId);
        paramMap.put("status", Status.NORMAL.code());
        paramMap.put("enableStatus", EnableStatus.ENABLE.code());
        List<Map<String, Object>> dataMap = locationEntityMapper.selectByCounId(paramMap);
        return dataMap;
    }

	@Override
	public List<Long> isExist(Location location) {

		Map<String, Object> params = new HashedMap<String, Object>();
		Long proId = location.getProId();
		if(proId != null){
			params.put("proId", proId);
		}
		
		Long cityId = location.getCityId();
		if(cityId != null){
			params.put("cityId", cityId);
		}
		
		Long counId = location.getCounId();
		if(counId != null){
			params.put("counId", counId);
		}
		
		String business = location.getBusiness();
		if(StringUtils.isNotBlank(business)){
			params.put("business", business);
		}
		
		List<Long> ids = locationEntityMapper.isExist(params);
		
		return ids;
	}


}
