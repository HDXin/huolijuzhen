package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 交易方向
 * 
 * @author Spector 2016-8-30下午3:34:21
 */
public enum TransDirectionType implements EnumType {
	DEFAULT(0,"默认"),
	UN_CHECK(1, "支出"),
	CHECKINIG(2, "收入");

	private final int code;
	private final String text;
	
    private TransDirectionType(int code, String text) {
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
	
	public static TransDirectionType codeOf(String text) {
		for (TransDirectionType value : values()) {
			if (value.name().equals(text)) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid TransDirectionType code: " + text);
	}
	
	public static TransDirectionType codeOf(int code) {
        for (TransDirectionType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid TransDirectionType code: " + code);
	}

}
