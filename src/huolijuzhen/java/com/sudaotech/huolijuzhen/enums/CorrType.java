package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CorrType implements EnumType {
	
	UNKNOWN(0, "未知"),
	CONTRACT_RELATED(1,"合同关联"),
	BUSINESS_RELATED(2, "业务关联");
   
    private final int code;
    private final String text;

    private CorrType(int code, String text) {
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
    public static CorrType nameOf(String name) {
        try {
            return CorrType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CorrType codeOf(int code) {
       
        for (CorrType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
