package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillUrgePushStatus implements EnumType {

	//催缴状态
	UNKNOWN(0, "未知"),
	WAIT_URGE(1,"待催缴"),
	ALREADY_URGE(2, "已催缴");
   
    private final int code;
    private final String text;

    private BillUrgePushStatus(int code, String text) {
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
    public static BillUrgePushStatus nameOf(String name) {
        try {
            return BillUrgePushStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillUrgePushStatus codeOf(int code) {
       
        for (BillUrgePushStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
