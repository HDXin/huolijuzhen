package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum Grade implements EnumType {
	
	UNKNOWN(0, "未知"),
    PLATFORM(1, "平台"),
    ADMINISTRACTIVE(2, "按行政位置"),
    PARK(3, "园区"),
    PLATFORMANDPARK(4,"平台/园区");
       
    private final int code;
    private final String text;

    private Grade(int code, String text) {
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
    public static Grade nameOf(String name) {
        try {
            return Grade.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static Grade codeOf(int code) {
        
        for (Grade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
