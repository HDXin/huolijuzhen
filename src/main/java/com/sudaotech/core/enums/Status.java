package com.sudaotech.core.enums;

import com.sudaotech.core.EnumType;

public enum Status implements EnumType {
    DELETED(-1, "已删除"),
    UNKNOWN(0, "未知"),
    NORMAL(1, "正常(有效)"),
    INVALID(2, "无效"),
    ;
    private final int code;
    private final String text;

    private Status(int code, String text) {
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
    public static Status nameOf(String name) {
        try {
            return Status.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static Status codeOf(int code) {
        
        for (Status value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
