package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ChooseStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	CHOOSE(1,"已选择"),
    CANCEL(2, "已取消");
    
    private final int code;
    private final String text;

    private ChooseStatus(int code, String text) {
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
    public static ChooseStatus nameOf(String name) {
        try {
            return ChooseStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ChooseStatus codeOf(int code) {
       
        for (ChooseStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
