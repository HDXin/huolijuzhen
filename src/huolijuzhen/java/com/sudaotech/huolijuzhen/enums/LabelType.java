package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;


public enum LabelType implements EnumType {
	
	UNKNOWN(0, "未知"),
	TEXT(1,"文本输入"),
    NUM(2, "数值输入"),
    FILE(3, "文件"),
    TEXTAREA(4,"大文本");
   
    private final int code;
    private final String text;

    private LabelType(int code, String text) {
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
    public static LabelType nameOf(String name) {
        try {
            return LabelType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static LabelType codeOf(int code) {
       
        for (LabelType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
