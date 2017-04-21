package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ContractStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
	WAITSUBMIT(10,"待提交"),
	WAITVERIFY(20,"待确认"),
	SUCCESS(30,"已生效"),
	TERMINATED(40, "已终止");

   
    private final int code;
    private final String text;

    private ContractStatus(int code, String text) {
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
    public static ContractStatus nameOf(String name) {
        try {
            return ContractStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ContractStatus codeOf(int code) {
       
        for (ContractStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
