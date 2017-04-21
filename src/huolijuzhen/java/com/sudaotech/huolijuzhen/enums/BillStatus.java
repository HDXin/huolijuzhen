package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillStatus implements EnumType {

	//申请单主状态
	UNKNOWN(0, "未知"),
	SUBMIT(1, "提交"),
	APPROVAL(2, "审批"),
	PUSH(3, "推送"),
    PAYMENT(4,"缴款确认"),
    WRITTEN(5, "核销"),
//    EXPEDITING(6, "催缴"),
    INVALID(6,"作废");
   
    private final int code;
    private final String text;

    private BillStatus(int code, String text) {
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
    public static BillStatus nameOf(String name) {
        try {
            return BillStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillStatus codeOf(int code) {
       
        for (BillStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
