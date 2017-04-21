package com.sudaotech.sms.service;

import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseService;

public interface SmsService extends BaseService {
	
    boolean sendSms(Sms shortMessage, Session session);
    
}
