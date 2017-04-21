package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ApprovalType implements EnumType {
	
	UNKNOWN(0, "未知"),
	CONTRACTAPPROVAL(10,"合同审批"),
    BILLAPPROVAL(20, "账单审批"),
    BILLVERIFY(30,"账单核销");
   
    private final int code;
    private final String text;

    private ApprovalType(int code, String text) {
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
    public static ApprovalType nameOf(String name) {
        try {
            return ApprovalType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ApprovalType codeOf(int code) {
       
        for (ApprovalType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
