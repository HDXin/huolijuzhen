package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 支付渠道
 * 
 * @author Spector 2016-8-30下午3:33:39
 */
public enum PayChannels implements EnumType {
	DEFAULT(0,"默认"),
	ALIPAY(1, "支付宝"),
	WX(2, "微信");

	private final int code;
	private final String text;
	
    private PayChannels(int code, String text) {
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
	
	public static PayChannels codeOf(String text) {
		for (PayChannels value : values()) {
			if (value.name().equals(text)) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid PayChannelsEnums code: " + text);
	}
	
	public static PayChannels codeOf(int code) {
        for (PayChannels value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid PayChannelsEnums code: " + code);
	}

}
