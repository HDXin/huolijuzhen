package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CorrContractStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	ONGOING(1,"进行中"),
	EXPIRE(2, "已过期"),
    TERMINATED(3,"已终止");
   
    private final int code;
    private final String text;

    private CorrContractStatus(int code, String text) {
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
    public static CorrContractStatus nameOf(String name) {
        try {
            return CorrContractStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CorrContractStatus codeOf(int code) {
       
        for (CorrContractStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
