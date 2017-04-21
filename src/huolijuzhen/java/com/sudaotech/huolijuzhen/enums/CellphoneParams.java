package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum CellphoneParams implements EnumType {
	OK(1000,"校验成功"),
	NEW_CELLPHONE_IS_NULL(1001,"新手机号为空"),
	NEW_CELLPHONE_ERROR_FORMAT(1002,"新手机号含有非数字字符"),
	NEW_CELLPHONE_ERROR_NUMBER(1003,"新手机号位数非11位"),
	OLD_CELLPHONE_IS_NULL(1004,"旧手机号为空"),
	OLD_CELLPHONE_ERROR_FORMAT(1005,"旧手机号含有非数字字符"),
	OLD_CELLPHONE_ERROR_NUMBER(1006,"旧手机号位数非11位"),
	VERIFY_CODE_IS_NULL(1007,"手机验证码为空"),
	VERIFY_CODE_ERROR_FORMAT(1008,"手机验证码含非数字字符"),
	SAME_PHONE(1009,"新旧手机号不能相同");
	
	private final int code;
	private final String text;
	
	private CellphoneParams(int code, String text){
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
	
	public static CellphoneParams nameOf(String name) {
        try {
            return CellphoneParams.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CellphoneParams codeOf(int code) {
       
        for (CellphoneParams value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
	
}
