package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum PayWay implements EnumType {
	
	UNKNOWN(0, "未知"),
	CASE(1,"现结"),
    MONTH(2, "月结"),
    ALIPAY(3,"支付宝"),
    WECHATPAY(4,"微信支付");
    
    private final int code;
    private final String text;

    private PayWay(int code, String text) {
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
    public static PayWay nameOf(String name) {
        try {
            return PayWay.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static PayWay codeOf(int code) {
       
        for (PayWay value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
