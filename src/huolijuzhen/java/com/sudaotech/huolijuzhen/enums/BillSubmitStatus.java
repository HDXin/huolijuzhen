package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillSubmitStatus implements EnumType {

	//提交状态
	UNKNOWN(0, "未知"),
	WAIT_SUBMIT(1,"待提交"),
	ALREADY_SUBMIT(2, "已提交");
   
    private final int code;
    private final String text;

    private BillSubmitStatus(int code, String text) {
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
    public static BillSubmitStatus nameOf(String name) {
        try {
            return BillSubmitStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillSubmitStatus codeOf(int code) {
       
        for (BillSubmitStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
