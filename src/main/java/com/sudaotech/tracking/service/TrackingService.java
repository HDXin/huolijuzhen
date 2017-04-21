package com.sudaotech.tracking.service;

import java.io.Serializable;

import com.sudaotech.core.service.BaseService;

public interface TrackingService extends BaseService {
    void save(String type, Serializable resouceId, String action, Object data);
}
