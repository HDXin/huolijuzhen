package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 转入转出类型
 * 
 * @author Spector 2016-8-30下午3:34:34
 */
public enum TransferSourceType implements EnumType {
	DEFAULT(0,"默认"),
	PERSONAL(1, "个人"),
	COMPANY(2, "公司"),
	TASK_SHARE_PROFIT(3, "任务分润"),
	ACTIVITY_SIGN_UP(4, "活动报名"),
	TASK_COMPLETE(5, "任务完成");

	private final int code;
	private final String text;
	
    private TransferSourceType(int code, String text) {
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
	
	public static TransferSourceType codeOf(String text) {
		for (TransferSourceType value : values()) {
			if (value.name().equals(text)) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid TransferSourceType code: " + text);
	}
	
	public static TransferSourceType codeOf(int code) {
        for (TransferSourceType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid TransferSourceType code: " + code);
	}

}
