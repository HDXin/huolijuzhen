package com.sudaotech.event.service;

import com.sudaotech.core.service.BaseService;
import com.sudaotech.event.NotifyEvent;

public interface NotifyService extends BaseService {
    void dispatch(NotifyEvent event);
}
