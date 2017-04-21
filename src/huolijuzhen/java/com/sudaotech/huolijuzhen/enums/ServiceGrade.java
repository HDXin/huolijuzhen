package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ServiceGrade implements EnumType {
	
	UNKNOWN(0, "未知"),
    PLATFORMSELF(1, "平台自营"),
    PARKSELF(2, "园区自营"),
    PLATFORMSERVICE(3, "平台服务商"),
    PARKSERVICE(4,"园区服务商");
       
    private final int code;
    private final String text;

    private ServiceGrade(int code, String text) {
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
    public static ServiceGrade nameOf(String name) {
        try {
            return ServiceGrade.valueOf(name);
        } catch(Exception e) {
        	
        }
        
        return null;
    }

    public static ServiceGrade codeOf(int code) {
        
        for (ServiceGrade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
