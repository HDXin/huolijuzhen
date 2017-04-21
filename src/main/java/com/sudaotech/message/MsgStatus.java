package com.sudaotech.message;

import com.sudaotech.core.EnumType;

//消息状态
public enum MsgStatus implements EnumType {
    UNKNOWN(0, "未知"),
    CREATE(1, "创建"),
    RECEIVE(2, "已接收"),
    READ(3, "已阅读"),
    DELETE(4, "已删除")
    ;
    private final int code;
    private final String text;

    private MsgStatus(int code, String text) {
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

    public static MsgStatus codeOf(int code) {
        for (MsgStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid MsgStatus code: " + code);
    }
}
