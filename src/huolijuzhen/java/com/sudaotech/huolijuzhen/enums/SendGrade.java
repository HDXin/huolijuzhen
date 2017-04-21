package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum SendGrade implements EnumType {
	
	UNKNOWN(0, "未知"),
    ALLUSER(1, "全部"),
    ENTERPRISEUSER(2, "企业用户"),
    PARKUSER(3,"园区用户");
       
    private final int code;
    private final String text;

    private SendGrade(int code, String text) {
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
    public static SendGrade nameOf(String name) {
        try {
            return SendGrade.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static SendGrade codeOf(int code) {
        
        for (SendGrade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
