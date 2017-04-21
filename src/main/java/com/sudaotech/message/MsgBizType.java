package com.sudaotech.message;

import com.sudaotech.core.EnumType;

/**
 * 消息业务类型
 */
public enum MsgBizType implements EnumType {

    UNKNOWN(0, "未知"),
    NOTICE(1, "跳转公告详情"),
    BILL(2, "跳转账单详情"),
    ORDER(3, "跳转订单详情"),
    APPLY_ORDER(4, "跳转申请单详情"),
    ACTIVITY_APPLY(5, "跳转活动申请详情"),
    APPLY(6, "跳转申报详情"),
    TASK(7, "跳转任务详情"),
    CONFIRM(8, "跳转关联确认"),
    REPAIR(9, "跳转报修任务"),
    DEVICE(10, "跳转设备计划(手动申请&自动申请)"),;

    private final int code;
    private final String text;

    private MsgBizType(int code, String text) {
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

    public static MsgBizType codeOf(int code) {
        for (MsgBizType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid MsgBizType code: " + code);
    }
}
