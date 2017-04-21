package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 交易类型
 * 
 * @author Spector 2016-8-30下午3:34:21
 */
public enum TransactionType implements EnumType {
	DEFAULT(0,"默认"),
	APPLYORDER_PAY(1, "服务订单支付");

	
	private final int code;
	private final String text;
	
    private TransactionType(int code, String text) {
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
	
	public static TransactionType codeOf(String text) {
		for (TransactionType value : values()) {
			if (value.name().equals(text)) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid TransactionType code: " + text);
	}
	
	public static TransactionType codeOf(int code) {
        for (TransactionType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid TransactionType code: " + code);
	}

}
