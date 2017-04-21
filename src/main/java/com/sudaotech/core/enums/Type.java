package com.sudaotech.core.enums;

import com.sudaotech.core.EnumType;

/**
 * 系统类型定义
 */
public enum Type implements EnumType {
    UNKNOWN(0, "未知类型"),
    FACTORY(10, "工厂"),
    DISTRIBUTOR(20, "经销商"),
    SHOP(30, "门店"),
    ;
    
    private final int code;
    private final String text;

    private Type(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static Type codeOf(int code) {
        for (Type value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
