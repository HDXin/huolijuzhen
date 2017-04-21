package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum PlanStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	WAITALLOT(1,"待分配"),
    WAITEXECUTOR(2, "待审批"),
    FINISH(3, "已完成");
   
    private final int code;
    private final String text;

    private PlanStatus(int code, String text) {
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
    public static PlanStatus nameOf(String name) {
        try {
            return PlanStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static PlanStatus codeOf(int code) {
       
        for (PlanStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
