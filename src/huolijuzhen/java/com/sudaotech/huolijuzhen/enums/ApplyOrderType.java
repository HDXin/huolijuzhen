package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ApplyOrderType implements EnumType {
	
	UNKNOWN(0, "未知"),
    APPLY(1, "申请单"),
    ORDER(2, "订单");
   
    private final int code;
    private final String text;

    private ApplyOrderType(int code, String text) {
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
    public static ApplyOrderType nameOf(String name) {
        try {
            return ApplyOrderType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ApplyOrderType codeOf(int code) {
       
        for (ApplyOrderType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
