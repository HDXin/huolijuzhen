package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BusinessType implements EnumType {

	UNKNOWN(0, "未知"),
	EQUIPMWNRPLAN(1,"设备计划");
   
    private final int code;
    private final String text;

    private BusinessType(int code, String text) {
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
    public static BusinessType nameOf(String name) {
        try {
            return BusinessType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BusinessType codeOf(int code) {
       
        for (BusinessType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
