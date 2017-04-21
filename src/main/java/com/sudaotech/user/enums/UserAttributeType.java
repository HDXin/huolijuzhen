package com.sudaotech.user.enums;

import com.sudaotech.core.EnumType;

public enum UserAttributeType implements EnumType  {
	
    UNKNOWN(0, "未知"),
    PARK_MANAGE(1, "园区管理"),
    PROPERTY_MANAGE(2, "物业管理");
    
    private final int code;
    private final String text;

    private UserAttributeType(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int code() {
        return code;
    }

    public String text() {
        return text;
    }

    public static UserAttributeType codeOf(String name) {
        for (UserAttributeType value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus name: " + name);
    }
    
    public static UserAttributeType codeOf(int code) {
        for (UserAttributeType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
