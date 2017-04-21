package com.sudaotech.huolijuzhen.util;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.sudaotech.huolijuzhen.bill.service.BillCostCalRulesService.BillCostCalRules;
import com.sudaotech.huolijuzhen.enterprise.service.ContractInfoService.ContractInfo;

/**
 * 工具类
 * @author chenjiashun
 * 2016年9月14日
 */
public class SystemUtil {
	/**
	 * 格式化 输出 指定长度字符
	 * @param str
	 */
	public static String charStr(String str, int count) {
		if (str != null && str.length() >= count) {
			return str.substring(0, count) + "....";
		}
		return str;
	}

	/**
	 * 格式化 date（yyyy-MM-dd HH:mm:ss）
	 * @param date
	 */
	public static String dateFormatHHMMSS(Date date) {
		return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化 date（yyyy-MM-dd）
	 * @param date
	 * @return String
	 */
	public static String dateFormatYYMMDD(Date date) {
		return dateFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 格式化 date（yyyy-MM-dd）
	 * @param date
	 * @return
	 */
	public static Date formatYYMMDD(Date date) {
		return getDateYYYYMMDD(dateFormat(date, "yyyy-MM-dd"));
	}
	
	/**
	 * 格式化 date（yyyy-MM-dd hh:mm）
	 * @param date
	 * @return
	 */
	public static String dateFormatHHMM(Date date) {
		return dateFormat(date, "yyyy-MM-dd HH:mm");
	}

	/**
	 * 指定格式获得字符串日期
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date, String format) {
		return date==null?null: new SimpleDateFormat(format).format(date);
	}
	

	/**
	 * 格式化 输出TimeStamp
	 * @param t
	 * @return
	 */
	public static Date timeStampFormat(Timestamp t) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.format(t);
		Date d = null;
		try {
			d = dateFormat.parse(dateFormat.format(t));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 将字符串转成 util.Date (yyyy-MM)
	 * @param str
	 */
	public static Date getDateYYYYMM(String strDate) {
		return getDate(strDate, "yyyy-MM");
	}
	
	/**
	 * 将字符串转成 util.Date (yyyy年MM月)
	 * @param str
	 */
	public static String getDateStrYYYYMM(String strDate) {
		
		Date date=getDate(strDate, "yyyy-MM");
		
		if(date == null)
			return "";
		
		return new SimpleDateFormat("yyyy年MM月").format(date);
		
	}
	
	/**
	 * 将字符串转成 util.Date (yyyy-MM-dd)
	 * @param str
	 */
	public static Date getDateYYYYMMDD(String strDate) {
		return getDate(strDate, "yyyy-MM-dd");
	}

	/**
	 * 将字符串转成 util.Date (yyyy-MM-dd HH:mm:ss)
	 * @param str
	 */
	public static Date getDateHHMMSS(String strDate) {
		return getDate(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将字符串转成 util.Date
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date getDate(String strDate,String format) {
		try {
			return (strDate==null||format==null)?null:new SimpleDateFormat(format).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将util.Date转换成 Timestamp 类型
	 * @param date
	 */
	public static Timestamp getTimestamp(Date date) {
		return Timestamp.valueOf(dateFormatHHMMSS(date));
	}

	/**
	 * 将date字符串转换成 Timestamp 类型
	 * @param str
	 */
	public static Timestamp getTimesByStr(String dataStr) {
		Timestamp ts = null;
		if (!StringUtils.isEmpty(dataStr)) {
			Date d = getDateHHMMSS(dataStr);
			ts = new Timestamp(d.getTime());
		}
		return ts;
	}

	/**
	 * 将 字符串转换成sql.Date
	 * @param str
	 * @return
	 */
	public static java.sql.Date convertToSqlDate(String str) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;
		try {
			java.util.Date date = bartDateFormat.parse(str);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return sqlDate;
	}

	/**
	 * 将Util.Date转换成Sql.Date
	 * @param date
	 * @return
	 */
	public static java.sql.Date getSqlDate(Date date) {
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	/**
	 * 格式化 双精度
	 * @param db
	 * @return
	 */
	public static String doubleString(double db) {
		return new DecimalFormat("#.00").format(db);
	}

	/**
	 * 格式化 双精度(返回double)
	 *
	 * @param pDouble
	 * @return
	 */
	public static Double doubleRound(double db) {
		return new Double(new DecimalFormat("#.00").format(db)); 
	}

	/**
	 * 指定double类型精确度返回double
	 *
	 * @param pDouble
	 * @param scale
	 * @return
	 */
	public static double getDoubleRound(Double pDouble, Integer scale) {
		BigDecimal bd = new BigDecimal(pDouble);
		@SuppressWarnings("static-access")
		BigDecimal bd1 = bd.setScale(scale, bd.ROUND_HALF_UP);
		pDouble = bd1.doubleValue();
		// long ll= Double.doubleToLongBits(pDouble);
		return pDouble;
	}
	/**
	 *  保留两位小数
	 *  上午11:28:09 by chenjiashun
	 *  @param obj
	 *  @return
	 */
	public static BigDecimal formatComma2BigDecimal(Object obj) {
		String val = String.valueOf(obj);
		if (val == null)
			return new BigDecimal("0.00");

		val = val.replaceAll(",", "");
		if (!isNumber(val))
			return new BigDecimal("0.00");

		BigDecimal decimal = new BigDecimal(val);
		decimal = decimal.setScale(2, RoundingMode.HALF_UP);

		return decimal;

	}
	/**
	 *  保留两位
	 *  上午11:28:22 by chenjiashun
	 *  @param obj
	 *  @return
	 */
	public  static String formatCommaAnd2Point(Object obj) {
		BigDecimal decimal = formatComma2BigDecimal(obj);

		DecimalFormat df = new DecimalFormat("#,###.00");
		String decimalStr = df.format(decimal).equals(".00")?"0.00":df.format(decimal);
		if(decimalStr.startsWith(".")){
			decimalStr = "0"+decimalStr;
		}
		return decimalStr;
	}
	/**
	 *  是否双精度
	 *  上午11:28:58 by chenjiashun
	 *  @param value
	 *  @return
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 格式化数据 百分比
	 * @param d1
	 * 除数
	 * 
	 * @param d2
	 * 被除数
	 * 
	 * @param digit
	 * 设置百分数精确度
	 * @return
	 */
	public static String  getPercent(Double d1,Double d2,Integer digit){
		
		 //这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
		   double percent = d1 / d2;
		   //获取格式化对象
		   NumberFormat nt = NumberFormat.getPercentInstance();
		   //设置百分数精确度2即保留两位小数
		   nt.setMinimumFractionDigits(digit==null?0:digit);
	    
		return nt.format(percent);
	}
	
	/**
	 * 格式化数据 百分比
	 * 
	 * @param d1
	 * 除数
	 * 
	 * @param d2
	 * 被除数
	 * 
	 * @return
	 */
	public static String  getPercent(Double d1,Double d2){
	    
		return getPercent(d1, d2, null);
	}
	
	
	/**
	 * 格式化数据 百分比
	 * 
	 * @param d1
	 * 除数
	 * 
	 * @param d2
	 * 被除数
	 * 
	 * @return
	 * 小数
	 */
	public static String  getPercentDec(Double d1,Double d2){
		NumberFormat formatter = new DecimalFormat("0.000");
		Double x=new Double(d1/d2);
		return  formatter.format(x);
	}
	
	/**
	 *  是否整数
	 *  上午11:29:14 by chenjiashun
	 *  @param value
	 *  @return
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 *  是否为数字
	 *  上午11:29:24 by chenjiashun
	 *  @param value
	 *  @return
	 */
	public static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}
	 
	/**
	 * 在当前减多少天
	 *
	 * @return
	 */
	public static String getSubDateStr(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -num + 1);
		Date date = new Date(cal.getTimeInMillis());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String str = df.format(date);
		return str;
	}
	
	/**
	 * 在当前减多少天
	 *
	 * @return
	 */
	public static Date getSubDate(int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -num + 1);
		return new Date(cal.getTimeInMillis());
	}

	/**
	 * 在当前日期增加多少天
	 * @return
	 */
	public static String getDate2(int num) {
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DAY_OF_MONTH, num);
		Date date = new Date(cal.getTimeInMillis());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = df.format(date);
		return str;
	}

	/**
	 * 在指定日期增加 几天
	 * @param date
	 * @param num
	 * @return
	 */
	public static String getDate(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, num);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date c = cal.getTime();
		return df.format(c);
	}
	
	/**
	 * 在指定日期增加 几天
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date getDateAddDay(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, num);
		Date c = cal.getTime();
		return c;
	}
	
	/**
	 *   获取某月的天数
	 * @param strDate
	 * @return
	 */
	public static int getDaysByMonth(String strDate){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM"); 
		Calendar calendar = new GregorianCalendar(); 
		Date date;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		} 
		calendar.setTime(date); //日期 
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	}
	
	/**
	 *   获取某月的天数
	 * @param strDate
	 * @return
	 */
	public static int getDaysByMonth(Date date){
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTime(date); //日期 
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	}
	/**
	 * 在指定日期增加 n月
	 * @param date
	 * @param num
	 * @return
	 */
	public static String getDateByAddMonth(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, num);
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Date c = cal.getTime();
		return df.format(c);
	}
	
	/**
	 * 在指定日期减少 n月
	 * @param date
	 * @param num
	 * @return
	 */
	public static String getDateBySubMonth(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -num);
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Date c = cal.getTime();
		return df.format(c);
	}
	
	
	public static Date getTreatedDate(Date date,int field ,int num,String format){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field,num);
		return cal.getTime();
	}
	/**
	 *        在当前时间增加 指定指定小时
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date getDateByHour(Date date ,int num){
		return getTreatedDate(date, Calendar.HOUR, num, null);
	}
	
	/**
	 * 
	 * @param 在当前时间增加 增加指定分钟
	 * @param num
	 * @return
	 */
	public static Date getDateByMin(Date date ,int num){
		return getTreatedDate(date, Calendar.MINUTE, num, null);
	}

	/**
	 * 获得 年
	 * @param date
	 * @return
	 */
	public static String getYear(Date date) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy");
		String year = bartDateFormat.format(date);
		return year;
	}

	/**
	 * 获得月
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("MM");
		String month = bartDateFormat.format(date);
		return month;
	}

	/**
	 * 获得 日
	 * @param date
	 * @return
	 */
	public static String getDay(Date date) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("dd");
		String day = bartDateFormat.format(date);
		return day;
	}

	/**
	 * 获得时分秒
	 *
	 * @param timestamp
	 * @return
	 */
	public static String getHms(Timestamp timestamp) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("HH:mm:ss");
		String hms = bartDateFormat.format(timestamp);
		return hms;
	}
	
	/**
	 * 获得 年月
	 * @param date
	 * @return
	 */
	public static String getYearAndMonth(Date date) {
		return getYear(date)+""+getMonth(date);
	}

	/**
	 * 格式化 timestamp
	 *
	 * @param timestamp
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getStrTimeStamp(Timestamp timestamp) {
		String hms = "";
		if (timestamp != null) {
			SimpleDateFormat bartDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			hms = bartDateFormat.format(timestamp);
		}
		return hms;
	}

	/**
	 * 获取今天是本周的第几天
	 *
	 * @return
	 */
	public static Integer getDay() {
		Calendar c = Calendar.getInstance();
		Integer day = c.get(Calendar.DAY_OF_WEEK); // 获致是本周的第几天地,
													// 1代表星期天...7代表星期六
		return day;
	}

	/**
	 * 获取本周是本月的第几周
	 *
	 * @return
	 */
	public static Integer getWeek() {
		Calendar c = Calendar.getInstance();
		int week = c.get(Calendar.WEEK_OF_MONTH);// 获取是本月的第几周
		return week;
	}

	/**
	 * 获取本月是本年的第几月
	 *
	 * @return
	 */
	public static Integer getMonth() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);// 获取是本年的第几月
		return month;
	}

	/**
	 * 获取当月第一天
	 */

	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1); // 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获得当月最后一天
	 */
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获得上月 第一天
	 */
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		// lastDate.add(Calendar.DATE,-1);//减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 获得上月最后一天
	 */
	public static String getPreviousMonthEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		return sdf.format(lastDate.getTime());
	}

	/**
	 * 获得指定 时间的所在月的 最后一天的 时间
	 *
	 * @param date
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getLastDateOfmonth(Date date) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(lastDate.DATE, 1);// 设为当前月的1号
		lastDate.add(lastDate.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(lastDate.DATE, -1);// 减去一天，变为当月最后一天
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(lastDate.getTime());
		return str;
	}

	/**
	 * 当页面编码是GBK时，如果用ajax,href 请求中文字符时需要转码
	 *
	 * @param paramStr
	 *            页面传过来的参数
	 * @return
	 */
	public static String decodeUTF8(String paramStr) {
		/*
		 * 如果ajax使用post提交，只须在页面中将内容使用js函数encodeURI()将需要传送的文本编码，
		 * 如果不行可以编码两次，在服务端使用URLDecoder.decode("a string", "UTF-8") 解码就可以了
		 */
		String decodeStr = "";
		try {
			decodeStr = URLDecoder.decode(paramStr, "UTF-8");// 烦死的GBK
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodeStr;
	}

	/**
	 * 去除字符串空格
	 *
	 * @param str
	 *   \n 回车( ) \t 水平制表符( ) \s 空格(\u0008) \r 换行( )
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 编码
	 *
	 * @param paramStr 页面传过来的参数
	 *
	 *  @param encode 字符编码
	 *
	 * @return
	 */
	public static String encodeUTF8(String paramStr,String encode) {
		/*
		 * 如果ajax使用post提交，只须在页面中将内容使用js函数encodeURI()将需要传送的文本编码，
		 * 如果不行可以编码两次，在服务端使用URLDecoder.decode("a string", "UTF-8") 解码就可以了
		 */
		String decodeStr = "";
		try {
			decodeStr = URLEncoder.encode(paramStr, encode);// 烦死的GBK
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodeStr;
	}
	
    /**
     * 数字转换，去非空
     *  下午5:20:44 by chenjiashun
     *  @param str
     *  @return
     */
	public static Integer pasetInt(String str){
		return str==null?null:Integer.parseInt(str);
	}
	
	/**
	 * 获取两个时间段的月份（包括起始月份，和截止月份）
	 * @return
	 */
    @SuppressWarnings("deprecation")
	public static List<String> getMonthsBetweenTimes(Date d1,Date d2){
    	
    	List<String> dateStrList=new ArrayList<String>();
		Calendar dd = Calendar.getInstance();//定义日期实例
		dd.setTime(d1);//设置日期起始时间
		//判断是否到结束日期
		while(dd.getTime().before(d2) || dd.get(Calendar.MONTH) == (d2.getMonth())){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String str = sdf.format(dd.getTime());
			dateStrList.add(str);
			dd.add(Calendar.MONTH, 1);        //进行当前日期月份加1
		}
		
		return dateStrList;
		
    }

    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }   
	
	@SuppressWarnings("deprecation")
	public  static String dateToCron(Date date) {
		if(date == null)
			return null;
		
		return   date.getSeconds()+" " 
		       + date.getMinutes() + " " 
		       + date.getHours() + " "
			   + getDay(date) + " " 
			   + getMonth(date) + " ? "
			   + getYear(date);
	}

	public static List<String> getBillMonthsBetweenTimes(ContractInfo ci,
			BillCostCalRules obj) {
		//1.获取合同自然月份
		List<String> months = getMonthsBetweenTimes(ci.getStartDate(), ci.getEndDate());
		if(CollectionUtils.isEmpty(months)){
			return null;
		}
		List<String> billMonths = new ArrayList<String>();
		billMonths.add(months.get(0));
		Integer freeMonth = obj.getFreeMonth();
		Integer advanceMonth = obj.getAdvanceMonth();
		
		for(int num = 0,index = 0;index < months.size();num++){
			//免收月数不为 0
			if(freeMonth != null && freeMonth > 0){
				index = freeMonth + num*advanceMonth - 1;					
			}else{
				index = (num+1)*advanceMonth;
			}

			if(index < months.size()){
				billMonths.add(months.get(index));				
			}
		}
		return billMonths;
	}

}
