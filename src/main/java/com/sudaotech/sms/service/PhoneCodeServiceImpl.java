package com.sudaotech.sms.service;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.sudaotech.core.Session;
import com.sudaotech.core.service.BaseServiceImpl;
import com.sudaotech.core.template.TemplateConfig;
import com.sudaotech.core.template.TemplateKey;
import com.sudaotech.redis.service.RedisStoreService;

public class PhoneCodeServiceImpl extends BaseServiceImpl implements PhoneCodeService {
    @Inject
    private RedisStoreService storeService;

    @Inject
    private SmsService smsService;


    @Override
    public boolean sendPhoneCode(String cellphone, Session session) {
        // create phone code
        String str = String.valueOf(System.currentTimeMillis());
        String phoneCode = str.substring(str.length() - 4);
        storeService.store(new PhoneCode(cellphone, phoneCode));

        // send phone code to cellphone
        Sms sms = new Sms();
        sms.setPhoneNum(cellphone);
        String content = TemplateConfig.format(TemplateKey.PHONE_CODE_SEND, phoneCode);
        sms.setContent(content);
        return smsService.sendSms(sms, session);
    }

    @Override
    public boolean checkPhoneCode(String cellphone, String phoneCode) {
        if (StringUtils.isBlank(cellphone) || StringUtils.isBlank(phoneCode)) {
            return false;
        }
        
        // 若验证码是1516，则认为通过
       if ("1516".endsWith(phoneCode)) {
            return true;
        }
        
        PhoneCode storable = storeService.get(cellphone, PhoneCode.class);
        // 手机验证码不区分大小写
        return storable != null && StringUtils.equalsIgnoreCase(storable.getPhoneCode(), phoneCode);
    }

    @Override
    public boolean checkPhoneCode(PhoneCode obj) {
        return obj != null && this.checkPhoneCode(obj.getCellphone(), obj.getPhoneCode());
    }
    
}
