package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillOperType implements EnumType {
	
	UNKNOWN(0, "未知"),
    CREATE(1, "创建"),
    UPDATE(2, "修改"),
    SUBMIT(3, "提交"),
	APPROVAL_PASS(4, "审批通过"),
    APPROVAL_FAIL(5, "审批拒绝"),
    PUSHED(6,"推送"),
    PAYMENT_CONFIRM(7,"缴款确认"),
    WARITTEN_ADJUST(8,"核销调整"),
    HAS_BEEN_WRITTEN(9, "已核销"),
    HANG_UP(10, "已挂起"),
    RELEASE(11, "取消挂起"),
    FINISHED(12,"已完结"),
    INVALID(13,"作废"),
	URGE(14,"催缴"),
	WRITTEN_REST(15,"核销重置"),
	FINISHED_REST(16,"完结催缴");
   
    private final int code;
    private final String text;

    private BillOperType(int code, String text) {
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
    public static BillOperType nameOf(String name) {
        try {
            return BillOperType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillOperType codeOf(int code) {
       
        for (BillOperType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}

