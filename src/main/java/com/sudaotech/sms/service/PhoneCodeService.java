package com.sudaotech.sms.service;

import com.sudaotech.core.Session;


/**
 * 手机验证码服务
 */
public interface PhoneCodeService {
    /**
     * 发送手机验证码到指定手机号
     * @param cellphone
     * @return
     */
    boolean sendPhoneCode(String cellphone, Session session);

    /**
     * 检查手机验证码是否有效
     * @param cellphone
     * @return boolean
     */
    boolean checkPhoneCode(String cellphone, String phoneCode);
    
    boolean checkPhoneCode(PhoneCode obj);
}
