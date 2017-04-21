package com.sudaotech.huolijuzhen.enums;

import com.sudaotech.core.EnumType;

public enum ImageType implements EnumType {

	//申请单状态
	UNKNOWN(0, "未知"),
    COMMUNITY_MAIN(1, "社群活动主图"),
    COMMUNITY_LIST(2, "社群活动列表图"),
    TASK_LOCALE(3,"维修申报图"),
    TASK_OPERATOR(4,"维修现场图"),
    SERVICE_MAIN(5,"服务项目主图"),
    SERVICE_LIST(6,"服务项目轮播图"),
    PARK_LOGO(20,"园区LOGO");
   
    private final int code;
    private final String text;

    private ImageType(int code, String text) {
        this.code = code;
        this.text = text;
    }
    
    //
    
    @Override
    public int code() {
        return code;
    }

    @Override
    public String text() {
        return text;
    }
    public static ImageType nameOf(String name) {
        try {
            return ImageType.valueOf(name);
        } catch(Exception e) {
        }
        
        return null;
    }

    public static ImageType codeOf(int code) {
       
        for (ImageType value : values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
