package com.sudaotech.core.enums;

import com.sudaotech.core.EnumType;

public enum PlatformSource implements EnumType {
    UNKNOWN(0, "未知"),
    PLATFORM(1, "平台"),
    PARK(2, "园区"),
    ENTERPRISE(3, "企业"),
    ;
    private final int code;
    private final String text;

    private PlatformSource(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static PlatformSource codeOf(String name) {
        for (PlatformSource value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus name: " + name);
    }
    
    public static PlatformSource codeOf(int code) {
        for (PlatformSource value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
