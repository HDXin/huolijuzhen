package com.sudaotech.user.enums;

import com.sudaotech.core.EnumType;

public enum Version implements EnumType {
    VERSION_101(101, "V1.0.1"),
    VERSION_102(102, "V1.0.2")
    ;
    private final int code;
    private final String text;

    private Version(int code, String text) {
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
    public static Version nameOf(String name) {
        try {
            return Version.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static Version codeOf(int code) {
        for (Version value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid Version code: " + code);
    }
}
