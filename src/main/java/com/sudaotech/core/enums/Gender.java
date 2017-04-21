package com.sudaotech.core.enums;

import com.sudaotech.core.EnumType;

/**
 * 性别
 */
public enum Gender implements EnumType {
    UNKNOWN(0, "未知"),
    MALE(1, "先生"),
    FEMALE(2, "女士"),
    CONFIDENTIALITY(3, "保密");

    private final int code;
    private String text;

    private Gender(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static Gender codeOf(int code) {
        for (Gender value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid Gender code: " + code);
    }
}
