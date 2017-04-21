package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum OperatorType implements EnumType {

	//申请单状态
	UNKNOWN(0, "未知"),
	CREATE(1,"新增"),
	UPDATE(2,"修改"),
	DELETE(3,"删除"),
	DELETEMORE(4,"批量删除"),
	APPROVAL(5, "审批");
   
    private final int code;
    private final String text;

    private OperatorType(int code, String text) {
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
    public static OperatorType nameOf(String name) {
        try {
            return OperatorType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static OperatorType codeOf(int code) {
       
        for (OperatorType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
