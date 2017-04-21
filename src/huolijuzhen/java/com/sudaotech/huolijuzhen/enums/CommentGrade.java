package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

/**
 * 维护评论：
 * 1.好评
 * 2.中评
 * 3.差评
 * @author admin
 *
 */
public enum CommentGrade implements EnumType {
	
	UNKNOWN(0,"未知的"),
    GOOD(1, "好评"),
    MEDIUM(2, "中评"),
    NEGATIVE(3, "差评");
       
    private final int code;
    private final String text;

    private CommentGrade(int code, String text) {
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
    public static CommentGrade nameOf(String name) {
        try {
            return CommentGrade.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static CommentGrade codeOf(int code) {
        
        for (CommentGrade value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
