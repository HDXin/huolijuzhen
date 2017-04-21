package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum FileType implements EnumType {
	
	UNKNOWN(0, "未知"),
	JPG(1,"jpg"),
    PNG(2, "png"),
	GIF(3, "gif"),
	PDF(4, "pdf"),
	TXT(5, "txt"),
	DOC(6, "doc"),
	XLS(7, "xls");
    
    private final int code;
    private final String text;

    private FileType(int code, String text) {
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
    public static FileType nameOf(String name) {
        try {
            return FileType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static FileType codeOf(int code) {
       
        for (FileType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
