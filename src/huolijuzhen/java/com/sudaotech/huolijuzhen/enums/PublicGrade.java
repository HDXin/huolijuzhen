package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum PublicGrade implements EnumType {
	
	UNKNOWN(0, "未知"),
    PLATFORM(1, "平台"),
    ADMINISTRACTIVE(2, "按行政位置"),
    PARK(3, "园区");
       
    private final int code;
    private final String text;

    private PublicGrade(int code, String text) {
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
    public static PublicGrade nameOf(String name) {
        try {
            return PublicGrade.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static PublicGrade codeOf(int code) {
        
        for (PublicGrade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
