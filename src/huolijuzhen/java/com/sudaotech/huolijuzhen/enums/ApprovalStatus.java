package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ApprovalStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	WAITSUBMIT(1,"待提交"),
    WAITAPPROVAL(2, "待审批"),
    ALREADYPASS(3, "已通过"),
    NOPASS(4,"未通过"),
    TERMINATION(5,"已终止");
   
    private final int code;
    private final String text;

    private ApprovalStatus(int code, String text) {
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
    public static ApprovalStatus nameOf(String name) {
        try {
            return ApprovalStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ApprovalStatus codeOf(int code) {
       
        for (ApprovalStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
