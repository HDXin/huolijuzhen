package com.sudaotech.sms;

import com.sudaotech.core.EnumType;

public enum SmsStatus implements EnumType {
	FAILED(0, "发送失败"),
	SUCESSED(1, "发送成功"),
    PENDING(2, "等待发送"),
    ;
    private final int code;
    private final String text;

    private SmsStatus(int code, String text) {
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

    public static SmsStatus codeOf(int code) {
        for (SmsStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
