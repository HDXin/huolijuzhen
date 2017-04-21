package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CreateSource implements EnumType {
    UNKNOWN(0, "未知"),
    PLATFORM(1, "平台"),
    PARK(2, "园区"),
    OTHER(3,"其他"),
    ;
    private final int code;
    private final String text;

    private CreateSource(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static CreateSource codeOf(String name) {
        for (CreateSource value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus name: " + name);
    }
    
    public static CreateSource codeOf(int code) {
        for (CreateSource value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
