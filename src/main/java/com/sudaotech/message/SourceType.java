package com.sudaotech.message;

import com.sudaotech.core.EnumType;

/**
 * 消息类型
 */
public enum SourceType implements EnumType {

    UNKNOWN(0, "未知"),
    SYSTEM_NOTICE(1, "系统公告"),
    SYSTEM_MESSAGE(2, "系统消息"),
    SYSTEM_OPERATION(3, "系统操作");

    private final int code;
    private final String text;

    private SourceType(int code, String text) {
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

    public static SourceType codeOf(int code) {
        for (SourceType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid MsgType code: " + code);
    }
}
