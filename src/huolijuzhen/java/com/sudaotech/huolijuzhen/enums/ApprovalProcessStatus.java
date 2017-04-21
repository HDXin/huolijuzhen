package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ApprovalProcessStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	WAITAPPROVAL(10,"待审批"),
    ONAPPROVAL(20, "审批中"),
    APPROVALED(30,"已审批");
   
    private final int code;
    private final String text;

    private ApprovalProcessStatus(int code, String text) {
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
    public static ApprovalProcessStatus nameOf(String name) {
        try {
            return ApprovalProcessStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ApprovalProcessStatus codeOf(int code) {
       
        for (ApprovalProcessStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
