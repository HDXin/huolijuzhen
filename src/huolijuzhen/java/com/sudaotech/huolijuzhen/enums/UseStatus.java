package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum UseStatus implements EnumType {

    NOUSE(0, "未被使用"),
    USE(1, "已使用");

    private final int code;
    private final String text;

    private UseStatus(int code, String text) {
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

    public static UseStatus nameOf(String name) {
        try {
            return UseStatus.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static UseStatus codeOf(int code) {

        for (UseStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
