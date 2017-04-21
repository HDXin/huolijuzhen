package com.sudaotech.message;

import com.sudaotech.core.EnumType;

/**
 * 消息类型
 */
public enum MsgType implements EnumType {

    UNKNOWN(0, "未知"),
    SYSTEM_NOTICE(1, "系统公告"),
    ENTERPRISE_SERVICE(2, "企业服务"),
    PARK_RELATION(3, "园区关联"),
    GROUP_ACTIVITY(4, "社群活动"),
    ENTERPRISE_ORDER(5, "企业账单"),
    REPAIR_APPLY(6, "维修申报");

    private final int code;
    private final String text;

    private MsgType(int code, String text) {
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

    public static MsgType codeOf(int code) {
        for (MsgType value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid MsgType code: " + code);
    }
}
