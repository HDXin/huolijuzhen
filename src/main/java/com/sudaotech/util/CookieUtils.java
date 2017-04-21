package com.sudaotech.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;

import com.sudaotech.core.config.ConfigLoader;

public abstract class CookieUtils {
    public static String getCookieDomain() {
        // 先获取配置
        String domain = ConfigLoader.loadEnvConfig().get("cookie.domain");
        // 若配置为空，则使用当前请求的环境信息
        if (StringUtils.isBlank(domain)) {
            domain = ThreadContext.get("cookie.domain");
        }
        
        return domain;
    }
}
