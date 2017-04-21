package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 任务的状态：
 * 1.待分配
 * 2.待处理
 * 3.已完成
 * @author admin
 *
 */
public enum TaskStatus implements EnumType {
	
	UNKNOWN(0, "未知"),
    WAITALLOT(1, "待分配"),
    WAITEXECUTOR(2, "待处理"),
    WAITCOMMENT(3,"待评价"),
    FINISH(4, "已完成"),
    ISCLOSE(5,"已关闭");
       
    private final int code;
    private final String text;

    private TaskStatus(int code, String text) {
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
    public static TaskStatus nameOf(String name) {
        try {
            return TaskStatus.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static TaskStatus codeOf(int code) {
        
        for (TaskStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
