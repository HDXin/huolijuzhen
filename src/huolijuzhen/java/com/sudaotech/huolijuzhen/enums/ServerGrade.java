package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ServerGrade implements EnumType {
	
	UNKNOWN(0, "未知"),
    PLATFORM(1, "平台"),
    PARK(2, "园区"),
    PLATFORMANDPARK(3,"平台/园区");
       
    private final int code;
    private final String text;

    private ServerGrade(int code, String text) {
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
    public static ServerGrade nameOf(String name) {
        try {
            return ServerGrade.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ServerGrade codeOf(int code) {
        
        for (ServerGrade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
