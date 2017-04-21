package com.sudaotech.core.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_TIME_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_3 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_TIME_FORMAT_4 = "MMddHHmmssSSS";
    public static final String DATE_TIME_FORMAT_5 = "yyyy-MM";

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern DATE_TIME_PATTERN_1 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}[T]\\d{2}:\\d{2}:\\d{2}$");
    private static final Pattern DATE_TIME_PATTERN_2 = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$");
    private static final Pattern DATE_TIME_PATTERN_5 = Pattern.compile("^\\d{4}-\\d{2}$");

    public static Date parse(String dateString) {
        Date date = null;
        if (!StringUtils.isBlank(dateString)) {
            try {
                if (DATE_PATTERN.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
                } else if (DATE_TIME_PATTERN_1.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_1).parse(dateString);
                } else if (DATE_TIME_PATTERN_2.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_2).parse(dateString);
                } else if (DATE_TIME_PATTERN_5.matcher(dateString).find()) {
                    date = new SimpleDateFormat(DATE_TIME_FORMAT_5).parse(dateString);
                }
            } catch (ParseException e) {
                logger.debug("Exception: {}", e);
            }
        }

        return date;
    }

    /**
     * 将日期字符串转换成指定格式的date
     *
     * @param 日期字符串
     * @param 日期格式
     * @return
     */
    public static Date formatStr(String str, String formatStr) {

        Date date = null;
        if (str != null) {
            DateFormat sdf = new SimpleDateFormat(formatStr);
            try {
                if (formatStr.equals(DATE_TIME_FORMAT_3)) {
                    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                }
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 将日期转换成指定格式字符串
     *
     * @param date
     * @param str
     * @return
     */
    public static String formatDate(Date date, String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        return sdf.format(date);
    }

    /**
     * 获取月日时分秒时间戳字符串
     *
     * @return
     */
    public static String getTimeString() {
        Date now = new Date();
        DateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT_4);
        return sdf.format(now);
    }

    public static Date getDateBegin(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDateEnd(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}
