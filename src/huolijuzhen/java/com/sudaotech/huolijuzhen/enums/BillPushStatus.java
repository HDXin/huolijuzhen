package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillPushStatus implements EnumType {

	//推送状态
	UNKNOWN(0, "未知"),
	WAIT_PUSH(1,"待推送"),
	ALREADY_PUSH(2, "已推送");
   
    private final int code;
    private final String text;

    private BillPushStatus(int code, String text) {
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
    public static BillPushStatus nameOf(String name) {
        try {
            return BillPushStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillPushStatus codeOf(int code) {
       
        for (BillPushStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
