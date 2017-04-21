package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum EnableStatus implements EnumType {

    UNKNOWN(0, "未知"),
    ENABLE(1, "启用"),
    DISABLE(2, "禁用");

    private final int code;
    private final String text;

    private EnableStatus(int code, String text) {
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

    public static EnableStatus nameOf(String name) {
        try {
            return EnableStatus.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static EnableStatus codeOf(int code) {

        for (EnableStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
