package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 维护周期类型
 * 1.年
 * 2.月
 * 3.日
 * @author admin
 *
 */
public enum CycleType implements EnumType {
	
	UNKNOWN(0, "未知"),
    YEARS(1, "年"),
    QUARTER(4,"季度"),
    MONTHS(2, "月"),
    DAYS(3, "日"),
    WEEKLY(4,"每周"),
    MONTHLY(5,"每月");
       
    private final int code;
    private final String text;

    private CycleType(int code, String text) {
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
    public static CycleType nameOf(String name) {
        try {
            return CycleType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CycleType codeOf(int code) {
        
        for (CycleType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
