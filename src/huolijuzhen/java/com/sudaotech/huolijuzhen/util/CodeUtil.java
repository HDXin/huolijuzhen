package com.sudaotech.huolijuzhen.util;


import com.sudaotech.huolijuzhen.resources.service.ResourceInfoService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编号生成工具
 */
public abstract class CodeUtil {
    /**
     * 生成新的流水编号
     *
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

    /**
     * url编码
     *
     * @param code 需要编码的字符串
     * @return 编码的的结果
     */
    public static String urlEncode(String code) {
        try {
            return URLEncoder.encode(code, Contains.Base.encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * url解码
     *
     * @param code 需要解码的字符串
     * @return 解码的的结果
     */
    public static String urlDecode(String code) {
        try {
            String decode = URLDecoder.decode(code, Contains.Base.encode);
            return replaceLikeWord(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String replaceLikeWord(String word) {
        String str = word.replaceAll("%", "").replaceAll("]", "").replaceAll("_", "").replaceAll("^", "");
        return "%" + str + "%";
    }

    //随机生成指定长度的代码,包含大小写和数字
    public static final String generateRandomString(int length) {
        String allChar = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    //随机生成指定长度的代码,包含数字
    public static final String generateRandomNumber(int length) {
        String allChar = "0123456789";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9"};

    /**
     * 生成短码
     *
     * @param length 指定长度
     * @return
     */
    public static String generateShortUUid(int length) {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < length; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    private static boolean isNotEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    public static boolean isIncludeEmoji(String source) {
        int len = source.length();
        StringBuilder buf = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint)) {
            } else {
                return true;
            }
        }
        return false;
    }

    public static String filterEmoji(String source) {
        if (source == null) return "";
        int len = source.length();
        StringBuilder buf = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (isNotEmojiCharacter(codePoint)) {
                buf.append(codePoint);
            } else {
                buf.append("");
            }
        }
        return buf.toString();
    }

    @org.junit.Test
    public void test() {
        ResourceInfoService.Batch batch = new ResourceInfoService.Batch();
        batch.setDigit(3);//设置位数
        batch.setNums(30);//设置个数
        batch.setPrefix("LT");//设置前缀
        batch.setStart(1);//设置开始数
        for (String s : genStationNo(batch)) {
            System.out.println(s);
        }
    }

    /**
     * 生成工位编码,根据web提交的数据
     *
     * @param batch
     */
    public static List<String> genStationNo(ResourceInfoService.Batch batch) {
        List<String> codeList = new ArrayList<>();
        StringBuffer code = null;
        for (int index = batch.getStart(); index < batch.getStart() + batch.getNums(); index++) {
            code = new StringBuffer(batch.getPrefix());
            code.append(genCode(index, batch.getDigit()));
            code.append(batch.getSuffix());
            codeList.add(code.toString());
        }
        return codeList;
    }

    private static String genCode(int number, int nums) {
        StringBuffer code = new StringBuffer();
        int length = String.valueOf(number).length();
        for (int index = nums; index >= 1; index--) {
            if (index <= length) {
                code.append(number);
                break;
            } else {
                code.append(0);
            }
        }
        return code.toString();
    }


}
