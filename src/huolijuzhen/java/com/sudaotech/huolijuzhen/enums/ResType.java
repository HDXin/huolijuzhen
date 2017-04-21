package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 维护周期类型
 * 1.年
 * 2.月
 * 3.日
 *
 * @author admin
 */
public enum ResType implements EnumType {

    UNKNOW(0, "未知"),

    SIMPLE(1, "普通资源"),
    COMMON(2, "公用资源"),;

    private final int code;
    private final String text;

    private ResType(int code, String text) {
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

    public static ResType nameOf(String name) {
        try {
            return ResType.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static ResType codeOf(int code) {

        for (ResType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
