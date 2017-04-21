package com.sudaotech.user.enums;

import com.sudaotech.core.EnumType;

public enum UserStatus implements EnumType {
    UNKNOWN(0, "未知"),
    NORMAL(1, "正常"),
    CLOSED(2, "已关闭"),
    FORBIDDEN(3, "禁用"),
    ;
    private final int code;
    private final String text;

    private UserStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static UserStatus codeOf(String name) {
        for (UserStatus value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus name: " + name);
    }
    
    public static UserStatus codeOf(int code) {
        for (UserStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
