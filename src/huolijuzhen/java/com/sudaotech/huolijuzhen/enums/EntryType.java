package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum EntryType implements EnumType {
	
	UNKNOWN(0, "未知"),
	PARK(1,"园区入驻"),
	SERVICE_PROVIDER(2,"服务商入驻");
   
    private final int code;
    private final String text;

    private EntryType(int code, String text) {
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
    public static EntryType nameOf(String name) {
        try {
            return EntryType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static EntryType codeOf(int code) {
       
        for (EntryType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
