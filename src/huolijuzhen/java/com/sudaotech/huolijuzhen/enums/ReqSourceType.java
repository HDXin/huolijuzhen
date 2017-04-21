package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 终端获取图片资源路径时，上传至后台判断其用户来源
 *
 * @author fuqq
 */
public enum ReqSourceType implements EnumType {

    APP_PARK(0, "园区APP"),
    APP_ENTERPRISE(1, "企业APP"),
    APP_ENTERPRISE_SERVER(2,"企业APP内部服务"),
    ADMIN_ENTERPRISE(3,"企业PC"),
    ADMIN_PARK(4,"园区PC"),
    ADMIN_PLATFORM(5,"平台PC");

    private final int code;
    private final String text;

    private ReqSourceType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }

    public static ReqSourceType nameOf(String name) {
        try {
            return ReqSourceType.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static ReqSourceType codeOf(int code) {

        for (ReqSourceType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
