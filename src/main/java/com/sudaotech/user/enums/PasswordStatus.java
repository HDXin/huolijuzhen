package com.sudaotech.user.enums;

import com.sudaotech.core.EnumType;

public enum PasswordStatus implements EnumType {
    UNKNOWN(0, "未知"),
    NORMAL(1, "正常"),
    FORCE_UPDATE(2, "强制更新密码"),
    ;
    private final int code;
    private final String text;

    private PasswordStatus(int code, String text) {
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

    public static PasswordStatus codeOf(int code) {
        for (PasswordStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid PasswordStatus code: " + code);
    }
}