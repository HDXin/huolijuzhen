package com.sudaotech.core.enums;

import com.sudaotech.core.EnumType;

public enum AuditStatus implements EnumType {
    UNKNOWN(0, "未知"),
    PENDING(1, "待审核"),
    APPROVED(2, "已审核"),
    REJECTED(3, "审核不通过"),
    ;
    private final int code;
    private final String text;

    private AuditStatus(int code, String text) {
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

    public static AuditStatus codeOf(int code) {
        for (AuditStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid AuditStatus code: " + code);
    }

}
