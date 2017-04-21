package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillConfirmStatus implements EnumType {

	//确认状态
	UNKNOWN(0, "未知"),
	WAIT_CONFIRM(1,"待确认"),
	ALREADY_CONFIRM(2, "已确认");
   
    private final int code;
    private final String text;

    private BillConfirmStatus(int code, String text) {
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
    public static BillConfirmStatus nameOf(String name) {
        try {
            return BillConfirmStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillConfirmStatus codeOf(int code) {
       
        for (BillConfirmStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
