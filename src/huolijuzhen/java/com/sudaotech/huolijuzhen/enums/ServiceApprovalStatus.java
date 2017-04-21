package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ServiceApprovalStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	WAITSUBMIT(1,"待提交"),
    WAITAPPROVAL(2, "待审批"),
//    ALREADYPASS(3, "已通过"),
    NOPASS(4,"未通过"),
    
    PUBLISH(5,"已上架"),
    UNPUBLISH(6,"已下架");
	
    private final int code;
    
    private final String text;

    private ServiceApprovalStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }
    
    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }
    public static ServiceApprovalStatus nameOf(String name) {
        try {
            return ServiceApprovalStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ServiceApprovalStatus codeOf(int code) {
       
        for (ServiceApprovalStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
