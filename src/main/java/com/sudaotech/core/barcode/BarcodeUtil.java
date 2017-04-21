package com.sudaotech.core.barcode;

public class BarcodeUtil {

    /**
     * 检查条形码是否合法有效
     * @param barcode
     * @return boolean
     */
    public static boolean isBarcodeValid(String barcode) {
        if (barcode == null) {
            return false;
        }
        
        String code = barcode.substring(0, barcode.length() - 1);
        int i = Integer.parseInt(barcode.substring(barcode.length() - 1));
        return i == computeCRC(code);
    }
    
    public static String buildBarcode(String origCode) {
        return origCode + computeCRC(origCode);
    }
    /**
     * 1.自右向左顺序编号
     * 2.从序号2开始求出偶数位上数字之和①
     * 3. ①*3=②
     * 4.从序号3开始求出奇数位上数字之和③
     * 5. ②+③=④
     * 6.用大于或等于结果④且为10最小整数倍的数减去④，其差即为所求校验码的值
     * 
     * @param code
     * @return
     */
    public static int computeCRC(String code) {
        int evens = 0, odds = 0;
        
        for (int i = code.length() - 1; i >= 0; i -= 2) {
            evens += Integer.parseInt(code.substring(i, i+1));
        }
        
        for (int i = code.length() - 2; i >= 0; i -= 2) {
            odds += Integer.parseInt(code.substring(i, i+1));
        }
        
        int n = evens * 3 + odds;
        int crc = 10 - n % 10;
        
        return crc % 10;
    }
}
