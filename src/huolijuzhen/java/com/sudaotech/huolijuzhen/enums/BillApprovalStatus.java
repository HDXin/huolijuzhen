package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum BillApprovalStatus implements EnumType {

	//审核状态
	UNKNOWN(0, "未知"),
	PENDING_APPROVAL(1,"待审批"),
    APPROVAL_PASS(2, "审核通过"),
    APPROVAL_FAIL(3, "审核拒绝");
   
    private final int code;
    private final String text;

    private BillApprovalStatus(int code, String text) {
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
    public static BillApprovalStatus nameOf(String name) {
        try {
            return BillApprovalStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static BillApprovalStatus codeOf(int code) {
       
        for (BillApprovalStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
