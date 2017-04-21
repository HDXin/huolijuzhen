package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum EnableAvg implements EnumType {

    //是否均价计算
    UNKNOWN(0, "未知"),
    ENABLE(1, "启用"),
    DISABLE(2, "不启用"),;

    private final int code;
    private final String text;

    private EnableAvg(int code, String text) {
        this.code = code;
        this.text = text;
    }

    ///

    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }

    public static EnableAvg nameOf(String name) {
        try {
            return EnableAvg.valueOf(name);
        } catch (Exception e) {
        }

        return null;
    }

    public static EnableAvg codeOf(int code) {

        for (EnableAvg value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
