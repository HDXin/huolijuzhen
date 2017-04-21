package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum TreatmentStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	PENDING_TREATMENT(1,"待处理"),
	ALREADY_PROCESSED(2,"已处理");
   
    private final int code;
    private final String text;

    private TreatmentStatus(int code, String text) {
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
    public static TreatmentStatus nameOf(String name) {
        try {
            return TreatmentStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static TreatmentStatus codeOf(int code) {
       
        for (TreatmentStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
