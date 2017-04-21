package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 任务类型：
 * 1.设备计划生产
 * 2.园区创建
 * 3.企业申请
 * @author admin
 *
 */
public enum TaskType implements EnumType {
	
	UNKNOWN(0, "未知"),
    EQUI(1, "设备计划"),
    PARKCREATE(2, "园区创建"),
    COMPANYAPPLY(3, "企业申请");
       
    private final int code;
    private final String text;

    private TaskType(int code, String text) {
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
    public static TaskType nameOf(String name) {
        try {
            return TaskType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static TaskType codeOf(int code) {
        
        for (TaskType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
