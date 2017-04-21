package com.sudaotech.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 编号生成工具
 */
public abstract class CodeBuilder {
    /**
     * 生成新的流水编号
     * @return 20位字符串
     */
    public static final String newTxCode() {
        // 年月日时分秒毫秒(15位)
        String time = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
        StringBuilder builder = new StringBuilder(time);
        Random random = new Random();
        // 随机数(5位)
        for (int i = 0; i < 5; i++) {
            int nextInt = random.nextInt(10);
            builder.append(nextInt);
        }
        
        return builder.toString();
    }
    
}
