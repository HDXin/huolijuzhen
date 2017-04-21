package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ComputeMode implements EnumType {

	UNKNOWN(0, "未知"),
	FIXED_AMOUNT(1, "固定金额"),
	CUSTOME_CAL(2, "自定义计算"),;
   
    private final int code;
    private final String text;

    private ComputeMode(int code, String text) {
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
    public static ComputeMode nameOf(String name) {
        try {
            return ComputeMode.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ComputeMode codeOf(int code) {
       
        for (ComputeMode value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
