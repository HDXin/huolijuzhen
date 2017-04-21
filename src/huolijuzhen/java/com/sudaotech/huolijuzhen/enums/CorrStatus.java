package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CorrStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	ALREADY_SETTLED(1,"已入驻"),
    HISTORICAL_SETTLED(2, "历史入驻");
   
    private final int code;
    private final String text;

    private CorrStatus(int code, String text) {
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
    public static CorrStatus nameOf(String name) {
        try {
            return CorrStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CorrStatus codeOf(int code) {
       
        for (CorrStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
