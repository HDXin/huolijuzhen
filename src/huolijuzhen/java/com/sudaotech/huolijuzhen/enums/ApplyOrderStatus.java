package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ApplyOrderStatus implements EnumType {

	//申请单状态
	UNKNOWN(0, "未知"),
    APPLYWAITEXECUTOR(1, "待处理"),
    ALREADYPASS(2, "已通过"),
    NOPASS(3,"未通过"),

    //订单状态
    WAITPAY(4,"待支付"),
    ORDERWAITEXECUTOR(5, "待处理"),
    WAITCOMMENT(6, "待评价"),
    FINISH(7, "已完成"),
    CANCEL(8,"已取消"),
    TERMINATION(9,"已关闭");
   
    private final int code;
    private final String text;

    private ApplyOrderStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }
    
    ///
    
    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }
    public static ApplyOrderStatus nameOf(String name) {
        try {
            return ApplyOrderStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ApplyOrderStatus codeOf(int code) {
       
        for (ApplyOrderStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
