package com.sudaotech.core.util;

import java.util.Calendar;
import java.util.Date;

public class RemindDateUtils {
    /** 
     * 获得本周的第一天，周一 
     * 
     * @return 
     */ 
    public static Date getCurrentWeekDayStartTime() { 
        Calendar c = Calendar.getInstance(); 
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    } 
    
    /** 
     * 获得本周的最后一天，周日 
     * 
     * @return 
     */ 
    public static Date getCurrentWeekDayEndTime() { 
        Calendar c = Calendar.getInstance(); 
        int weekday = c.get(Calendar.DAY_OF_WEEK); 
        c.add(Calendar.DATE, 8 - weekday);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 

    /** 
     * 获得本天的开始时间，即2012-01-01 00:00:00 
     * 
     * @return 
     */ 
    public static Date getCurrentDayStartTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    } 

    /** 
     * 获得本天的结束时间，即2012-01-01 23:59:59 
     * 
     * @return 
     */ 
    public static Date getCurrentDayEndTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 

    /** 
     * 获得本小时的开始时间，即2012-01-01 00:00:00 
     * 
     * @return 
     */ 
    public static Date getCurrentHourStartTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    } 

    /** 
     * 获得本小时的结束时间，即2012-01-01 23:59:59 
     * 
     * @return 
     */ 
    public static Date getCurrentHourEndTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 

    /** 
     * 获得本月的开始时间，即2012-01-01 00:00:00 
     * 
     * @return 
     */ 
    public static Date getCurrentMonthStartTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.DATE, 1); 
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    } 

    /** 
     * 当前月的结束时间，即2012-01-31 23:59:59 
     * 
     * @return 
     */ 
    public static Date getCurrentMonthEndTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.DATE, 1); 
        c.add(Calendar.MONTH, 1); 
        c.add(Calendar.DATE, -1); 
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 

    /** 
     * 当前年的开始时间，即2012-01-01 00:00:00 
     * 
     * @return 
     */ 
    public static Date getCurrentYearStartTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.MONTH, 0); 
        c.set(Calendar.DATE, 1); 
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime(); 
    } 

    /** 
     * 当前年的结束时间，即2012-12-31 23:59:59 
     * 
     * @return 
     */ 
    public static Date getCurrentYearEndTime() { 
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.MONTH, 11); 
        c.set(Calendar.DATE, 31); 
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 

    /** 
     * 当前季度的开始时间，即2012-01-1 00:00:00 
     * 
     * @return 
     */ 
    public static Date getCurrentQuarterStartTime() { 
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1; 
        if (currentMonth >= 1 && currentMonth <= 3) 
            c.set(Calendar.MONTH, 0); 
        else if (currentMonth >= 4 && currentMonth <= 6) 
            c.set(Calendar.MONTH, 3); 
        else if (currentMonth >= 7 && currentMonth <= 9) 
            c.set(Calendar.MONTH, 4); 
        else if (currentMonth >= 10 && currentMonth <= 12) 
            c.set(Calendar.MONTH, 9); 
        c.set(Calendar.DATE, 1); 
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime(); 
    } 

    /** 
     * 当前季度的结束时间，即2012-03-31 23:59:59 
     * 
     * @return 
     */ 
    public static Date getCurrentQuarterEndTime() { 
        Calendar c = Calendar.getInstance(); 
        int currentMonth = c.get(Calendar.MONTH) + 1; 
        if (currentMonth >= 1 && currentMonth <= 3) { 
            c.set(Calendar.MONTH, 2); 
            c.set(Calendar.DATE, 31); 
        } else if (currentMonth >= 4 && currentMonth <= 6) { 
            c.set(Calendar.MONTH, 5); 
            c.set(Calendar.DATE, 30); 
        } else if (currentMonth >= 7 && currentMonth <= 9) { 
            c.set(Calendar.MONTH,8); 
            c.set(Calendar.DATE, 30); 
        } else if (currentMonth >= 10 && currentMonth <= 12) { 
            c.set(Calendar.MONTH, 11); 
            c.set(Calendar.DATE, 31); 
        } 
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 
    /** 
     * 获取前/后半年的开始时间 
     * @return 
     */ 
    public static Date getHalfYearStartTime(){ 
        Calendar c = Calendar.getInstance(); 
        int currentMonth = c.get(Calendar.MONTH) + 1; 
        if (currentMonth >= 1 && currentMonth <= 6){ 
            c.set(Calendar.MONTH, 0); 
        }else if (currentMonth >= 7 && currentMonth <= 12){ 
            c.set(Calendar.MONTH, 6); 
        } 
        c.set(Calendar.DATE, 1); 
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
        
    } 
    /** 
     * 获取前/后半年的结束时间 
     * @return 
     */ 
    public static Date getHalfYearEndTime(){ 
        Calendar c = Calendar.getInstance(); 
        int currentMonth = c.get(Calendar.MONTH) + 1; 
        if (currentMonth >= 1 && currentMonth <= 6){ 
            c.set(Calendar.MONTH, 5); 
            c.set(Calendar.DATE, 30); 
        }else if (currentMonth >= 7 && currentMonth <= 12){ 
            c.set(Calendar.MONTH, 11); 
            c.set(Calendar.DATE, 31); 
        } 
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    } 
} 
