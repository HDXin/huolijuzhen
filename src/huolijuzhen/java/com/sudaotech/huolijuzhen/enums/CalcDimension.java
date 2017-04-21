package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CalcDimension implements EnumType {

    UNKNOWN(0, "未知"),
    BY_AREA(1, "按面积"),
    BY_NUMS(2, "按数量");

    private final int code;
    private final String text;

    private CalcDimension(int code, String text) {
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

    public static CalcDimension nameOf(String name) {
        try {
            return CalcDimension.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static CalcDimension codeOf(int code) {

        for (CalcDimension value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
