package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CreateSide implements EnumType {
	
	UNKNOWN(0, "未知"),
    PLATFORM(1, "平台创建"),
    PARK(2, "园区创建");
       
    private final int code;
    private final String text;

    private CreateSide(int code, String text) {
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
    public static CreateSide nameOf(String name) {
        try {
            return CreateSide.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CreateSide codeOf(int code) {
        
        for (CreateSide value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
