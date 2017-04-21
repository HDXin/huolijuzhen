package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ChargeMode implements EnumType {

	DOSAGE(1, "按用量计费"),
	AMOUNT(2, "按金额计费");

    private final int code;
    private final String text;

    private ChargeMode(int code, String text) {
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
    public static ChargeMode nameOf(String name) {
        try {
            return ChargeMode.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ChargeMode codeOf(int code) {
       
        for (ChargeMode value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
