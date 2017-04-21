package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillVerificationStatus implements EnumType {

	//核销状态
	UNKNOWN(0, "未知"),
	WAIT_WRITTEN(1,"待核销"),
	ALREADY_WRITTEN(2, "已核销"),
	ALREADY_SUSPEND(3, "已挂起"),
	ALREADY_FINISHED(4, "已完结");
   
    private final int code;
    private final String text;

    private BillVerificationStatus(int code, String text) {
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
    public static BillVerificationStatus nameOf(String name) {
        try {
            return BillVerificationStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillVerificationStatus codeOf(int code) {
       
        for (BillVerificationStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
