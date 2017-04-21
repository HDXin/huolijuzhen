package com.sudaotech.tracking.service;

import java.io.Serializable;
import java.util.Date;

import com.google.inject.Inject;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.tracking.dao.TrackingEntity;
import com.sudaotech.tracking.dao.TrackingEntityMapper;
import com.sudaotech.util.JsonUtil;

public class TrackingServiceImpl extends BaseServiceImpl implements TrackingService {
    @Inject
    private TrackingEntityMapper trackingEntityMapper;

    @Override
    public void save(String type, Serializable resouceId, String action, Object data) {
        TrackingEntity entity = new TrackingEntity();
        entity.setType(type);
        if (resouceId == null) {
            logger.warn("resouceId is null");
            entity.setResourceId("");
        } else {
            entity.setResourceId(resouceId.toString());    
        }
        
        entity.setAction(action);
        entity.setData(JsonUtil.toJson(data));
        entity.setTime(new Date());
        
        this.trackingEntityMapper.insertSelective(entity);
    }
}
