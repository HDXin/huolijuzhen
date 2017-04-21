package com.sudaotech.captcha.service;

import java.io.IOException;

public interface CaptchaService {

    public String createCaptchaCode();

    public byte[] createCaptchaImage(String code) throws IOException;
}
