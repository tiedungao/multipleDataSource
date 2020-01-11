package com.shallbuy.transfer.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FrameDateUtils
{
  protected static final String[] months = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
  protected static final String[] quarters = { "一季度", "二季度", "三季度", "四季度" };

  protected static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

  protected static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";


  /**
   * 根据格式化获取日期格式字符串
   *
   * @param date 日期
   * @param pattern 格式化：yyyy-MM-dd/yyyy-MM-dd HH:mm:ss
    1970-01-01/1970-01-01 00:00:00
   */
  public static String DateToString(Date date, String pattern)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return simpleDateFormat.format(date);
  }

  /**
   * 日期转字符串
   *
   * @param date 日期
    1970-01-01
   */
  public static String DateToShortString(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);
    return simpleDateFormat.format(date);
  }

  /**
   * 当前日期转字符串
   *
    1970-01-01
   */
  public static String DateToShortString()
  {
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);

    return formatter.format(new Date());
  }

  /**
   * 日期转字符串
   *
   * @param date 日期
    1970-01-01 00:00:00
   */
  public static String DateToLongString(Date date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_DETAIAL_PATTERN);
    return simpleDateFormat.format(date);
  }

  /**
   * 当前日期转字符串
   *
    1970-01-01 00:00:00
   */
  public static String DateToLongString() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_DETAIAL_PATTERN);
    return simpleDateFormat.format(new Date());
  }



  /**
   * 时间戳转日期格式字符串
   *
   * @param source 时间戳
   * @param pattern 格式化：yyyy-MM-dd/yyyy-MM-dd HH:mm:ss
    1970-01-01/1970-01-01 00:00:00
   */
  public static String timeStampToString(long source, String pattern)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date = new Date(source * 1000L);
    return simpleDateFormat.format(date);
  }

  /**
   *  时间戳转日期格式字符串
   *
   * @param unix_time 时间戳
    1970-01-01
   */
  public static String timeStampToString(long unix_time) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TO_STRING_SHORT_PATTERN);
    Date date = new Date(unix_time * 1000L);
    return simpleDateFormat.format(date);
  }

  /**
   * 日期转时间戳
   *
   * @param date 日期
    时间戳
   */
  public static Integer dateToTimeStamp(Date date)
  {
    Timestamp timestamp = new Timestamp(date.getTime());
    long num = timestamp.getTime() / 1000L;
    return (int) num;
  }

  /**
   * 日期格式字符串转日期
   *
   * @param source 日期格式字符串
   * @param pattern 格式化
    Date
   */
  public static Date stringToDate(String source, String pattern)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date date = null;
    try {
      date = simpleDateFormat.parse(source);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

  /**
   * 当前日期转格式化字符串
   *
   * @param
   // 1970-01-01/1970-01-01 00:00:00
   */
  public static String currentFormatDate()
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return simpleDateFormat.format(new Date());
  }

  /**
   * 当前时间戳
   *
    当前时间戳
   */
  public static int currentTimeStamp()
  {
    return (int)(System.currentTimeMillis() / 1000L);
  }


  /**
   * 精确到天数的整形字符串
   *
    yyyyMMdd
   */
  public static String getNumberOfDate()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

    return formatter.format(new Date());
  }

  /**
   * 精确到秒的整形字符串
   *
    yyyyMMddHHmmss
   */
  public static String getNumberOfDateDetail()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");

    return formatter.format(new Date());
  }

  /**
   * 当前时间对应的年份
    yyyy
   */
  public static String getNumberOfNowYear()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

    return formatter.format(new Date());
  }

  /**
   * 当前时间对应的月份
   *
    MM
   */
  public static String getNumberOfNowMonth()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("MM");

    return formatter.format(new Date());
  }

  /**
   * 获取当前日期
   *
    dd
   */
  public static String getNumberOfNowDay()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd");

    return formatter.format(new Date());
  }

  /**
   * 获取日期的TimeInMillis
   *
   * @param date 日期
    timeInMillis
   */
  public static long getMillis(Date date)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    return c.getTimeInMillis();
  }

  /**
   * 获取当前时间
   *
    HH:mm:ss
   */
  public static String getNowHourStr() {
    String str ;
    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    str = df.format(new Date());
    return str;
  }

  /**
   * 获取当日结束时间戳
   *
    时间戳
   */
  public static int getTodayEndTimestamp() {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.set(Calendar.HOUR_OF_DAY, 23);
    todayEnd.set(Calendar.MINUTE, 59);
    todayEnd.set(Calendar.SECOND, 59);
    todayEnd.set(Calendar.MILLISECOND, 999);

    return dateToTimeStamp(todayEnd.getTime());
  }

  /**
   * 获取当日结束时间戳
   *
    时间戳
   */
  public static int getDayEndTimestamp(int day) {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.set(Calendar.HOUR_OF_DAY, 23);
    todayEnd.set(Calendar.MINUTE, 59);
    todayEnd.set(Calendar.SECOND, 59);
    todayEnd.set(Calendar.MILLISECOND, 999);
    todayEnd.add(Calendar.DAY_OF_MONTH, day);
    return dateToTimeStamp(todayEnd.getTime());
  }

  /**
   * 获取今天+-day天开始时间戳
   *
    时间戳
   */
  public static int getDayStartTimestamp(int day) {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.set(Calendar.HOUR_OF_DAY, 0);
    todayEnd.set(Calendar.MINUTE, 0);
    todayEnd.set(Calendar.SECOND, 0);
    todayEnd.set(Calendar.MILLISECOND, 0);
    todayEnd.add(Calendar.DAY_OF_MONTH, day);
    return dateToTimeStamp(todayEnd.getTime());
  }

  /**
   * 获取当日开始时间戳
   *
    时间戳
   */
  public static int getTodayStartTimestamp() {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.set(Calendar.HOUR_OF_DAY, 0);
    todayEnd.set(Calendar.MINUTE, 0);
    todayEnd.set(Calendar.SECOND, 0);
    todayEnd.set(Calendar.MILLISECOND, 0);
    return dateToTimeStamp(todayEnd.getTime());
  }

  /**
   * 获取+minute分钟后的时间戳
   *
   * @param minute 分钟
    时间戳
   */
  public static int getAddMinuteTimestamp(int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE,minute);

    return dateToTimeStamp(calendar.getTime());
  }



  /**
   * 获取+hour小时后的时间戳
   *
   * @param hour 添加的小时
    时间戳
   */
  public static int getAddHourTimestamp(int hour) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.HOUR,hour);

    return dateToTimeStamp(calendar.getTime());
  }

  public static int getAddHourAndMinuteTimestamp(int hour, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.HOUR,hour);
    calendar.add(Calendar.MINUTE,minute);

    return dateToTimeStamp(calendar.getTime());
  }

  /**
   * 获取+day天后的时间戳
   *
   * @param day 天数
    时间戳
   */
  public static int getAddDayTimestamp(int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, day);

    return dateToTimeStamp(calendar.getTime());
  }

  /**
   * 获取+day天后的时间戳
   *
   * @param day 天数
   * @param hour 小时
    时间戳
   */
  public static int getAddDayAndMinuteTimestamp(int day, int hour) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, day);
    calendar.add(Calendar.HOUR, hour);
    return dateToTimeStamp(calendar.getTime());
  }


  /**
   * 日期格式字符串转换成时间戳
   * @param date_str 字符串日期
   * @param format 如：yyyy-MM-dd HH:mm:ss
    时间戳
   */
  public static Integer dateStrToTimeStamp(String date_str, String format){
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      return (int) (sdf.parse(date_str).getTime()/1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * 字符串的日期格式的计算两个日期间相差天数
   * @author ayou_java
   * @since 2017-1-29
   * @version 1.1
   * @param date1 日期1字符串
   * @param date2 日期2字符串
   * @return date2-date1
   */
  public static int daysBetween(String date1, String date2)throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(sdf.parse(date1));
    long time1 = cal.getTimeInMillis();
    cal.setTime(sdf.parse(date2));
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / (1000 * 3600 * 24);
    return Integer.parseInt(String.valueOf(between_days));
  }
  /**
   *   字符串的日期格式的计算两个日期间相差月份
   * @author ayou_java
   * @since 2017-1-29
   * @version 1.1
   * @param date1 日期1字符串
   * @param date2 日期2字符串
   */
  public static int monthBetween(String date1, String date2) throws ParseException {
    int result;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(sdf.parse(date1));
    c2.setTime(sdf.parse(date2));
    result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
    return result == 0 ? 1 : Math.abs(result);
  }
  /**
   *  字符串的日期格式的计算两个日期间相差年份
   * @author ayou_java
   * @since 2017-1-29
   * @version 1.1
   * @param date1 日期1字符串
   * @param date2 日期2字符串
   */
  public static int yearBetween(String date1, String date2) throws ParseException {
    int result;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c1.setTime(sdf.parse(date1));
    c2.setTime(sdf.parse(date2));
    result = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
    return result;
  }


  /**
   *  计算两个日期间相差的天数用XX年XX月XX日来表示
   * @author ayou_java
   * @since 2017-1-29
   * @version 1.1
   * @param fdate 日期1(2015-11-28)
   * @param sdate 日期2(2016-01-29)
   */
  public static String calculateDays(String fdate, String sdate)throws ParseException {
    int year1,year2,month1,month2,day1,day2,tempY,tempM,tempD;
    String[] str1 = fdate.split("-");
    year1 = Integer.parseInt(str1[0]);//年份
    month1 =  Integer.parseInt(str1[1]);//月份
    day1 =  Integer.parseInt(str1[2]);//日期

    String[] str2 = sdate.split("-");
    year2 = Integer.parseInt(str2[0]);//年份
    month2 =  Integer.parseInt(str2[1]);//月份
    day2 =  Integer.parseInt(str2[2]);//日期


    tempY = year2 - year1;//计算年数

    if(month1-month2>0){//计算月份
      tempY --;
      tempM = 12-month1+month2;
    }else{
      tempM = month2-month1;
    }

    if(day1-day2>=0){ //计算天数
      tempM --;
      int dat = calculateMonthDays(year1,month1);
      tempD = dat-day1+day2;
    }else{
      tempD = day2 -day1;
    }

      return "" + tempY + "年" + tempM + "月" + tempD + "日";
  }
  /**
   * 判断是否是闰年
   * @author ayou_java
   * @since 2017-1-29
   * @version 1.1
   * @param year 年份
   */
  public static boolean isRunYear(int year) {
      // true是闰年 false不是平年
      return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }
  /**
   *  获取当前月份的是天数
   * @author ayou_java
   * @since 2016-1-29
   * @version 1.1
   * @param year 年份
   * @param month 月份
   */
  public static int calculateMonthDays(int year, int month) {
    boolean isYunYear = isRunYear(year);
    int days = 31;
    switch (month) {
      case 2:
        if (isYunYear) {
          days = 29;
        } else {
          days = 28;
        }
        break;
      case 4:
        days = 30;
        break;
      case 6:
        days = 30;
        break;
      case 9:
        days = 30;
        break;
      case 11:
        days = 30;
        break;
      default:
        break;
    }
    return days;
  }
}