package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum SuccessOrFailEnums implements EnumType {
	DEFAULT(0,"默认"),
	FAIL(1, "失败"),
	SUCCESS(2, "成功");
	

	private final int code;
	private final String text;
	
    private SuccessOrFailEnums(int code, String text) {
        this.code = code;
        this.text = text;
    }
	
	@Override
	public int code() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String text() {
		// TODO Auto-generated method stub
		return text;
	}
	
	public static SuccessOrFailEnums codeOf(int code) {
        for (SuccessOrFailEnums value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid SuccessOrFailEnums code: " + code);
	}

	
}
