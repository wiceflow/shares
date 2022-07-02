package com.wiceflow.shares.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author BF
 * @date 2022/7/2
 * 时间Util
 */
public class DateUtil {

    public final static String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public final static String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String PATTERN_YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public final static String PATTERN_YYYY_MM = "yyyy-MM";

    public final static String PATTERN_YYYY_MM_DD_HH_MM = "yyyy年MM月dd日 HH:mm";


    /**
     * 获取当前日期 String 格式
     *
     * @return 年月日 时分秒
     */
    public static String getCurrentStringDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYY_MM_DD_HH_MM_SS);
        return sdf.format(new Date());
    }

    /**
     * 获取日期 String 格式
     *
     * @param date    日期
     * @param pattern 格式
     * @return 返回 String 类型
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取日期 Date 格式
     *
     * @param date    日期
     * @param pattern 格式
     * @return 返回 String 类型
     */
    public static Date stringToDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * 获取当年的第一天
     * <p>格式 2018-01-01</p>
     *
     * @return 精确到日
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * <p>格式 2018-12-31</p>
     *
     * @return 精确到日
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * <p>格式 2018-01-01</p>
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取上一个月
     *
     * @param time 传入月份
     * @return String 格式
     */
    public static String getLastMonth(String time) {
        String lastDayString;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c1.add(Calendar.MONTH, -1);
        lastDayString = sdf.format(c1.getTime());
        return lastDayString;
    }

    /**
     * 获取上一个月
     *
     * @param time 传入月份
     * @return String 格式
     */
    public static String getNextMonth(String time) {
        String lastDayString;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c1.add(Calendar.MONTH, 1);
        lastDayString = sdf.format(c1.getTime());
        return lastDayString;
    }

    /**
     * 获取下一天
     *
     * @param time 传入时间
     * @return String 格式
     */
    public static String getNextDate(String time) {
        String lastDayString;
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.PATTERN_YYYY_MM_DD);
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c1.add(Calendar.DATE, 1);
        lastDayString = sdf.format(c1.getTime());
        return lastDayString;
    }

    /**
     * 获取前多少天
     *
     * @param time  传入时间
     * @param count 前多少天
     * @return String 格式
     */
    public static String getLastDate(String time, Integer count) {
        String lastDayString;
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.PATTERN_YYYY_MM_DD);
        Calendar c1 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c1.add(Calendar.DATE, count);
        lastDayString = sdf.format(c1.getTime());
        return lastDayString;
    }


    /**
     * 获取当前月份
     * <p>格式 年-月 2018-12</p>
     *
     * @return 返回String格式月份
     */
    public static String getCurrentMonthString() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYY_MM);
        return sdf.format(new Date());
    }

    /**
     * 返回当前小时
     * <p>若小时为单数，则自动补上0 </p>
     *
     * @return 返回 String 类型
     */
    public static String getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String result = String.valueOf(hour);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * 获取当前月份  只获取月份，年没有返回
     * <p>格式 01  12</p>
     *
     * @return 返回 int 类型
     */
    public static Integer getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取上周的今天
     *
     * @param date [LocalDate] localDate
     * @return Date
     */
    public static Date getLastWeek(LocalDate date) {
        return localDateToDate(date.plusDays(-7));
    }

    /**
     * 将 Date 转换成 localDate
     *
     * @param date [Date] 时间
     * @return localDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDate 转 Date
     *
     * @param localDate [LocalDate] LocalDate
     * @return date
     */
    public static Date localDateToDate(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取当前月份  只获取月份，年没有返回
     * <p>格式 01  12</p>
     *
     * @return 返回 int 类型
     */
    public static Integer getCurrentMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 判断是不是整十分
     *
     * @param date [Date] date
     * @return 布尔类型
     */
    public static Boolean isTenMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minute = calendar.get(Calendar.MINUTE);
        return minute % 10 == 0;
    }

    /**
     * 判断时间是否为整点
     *
     * @param date [Date] date
     * @return 布尔类型
     */
    public static Boolean isWholePoint(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minute = calendar.get(Calendar.MINUTE);
        return minute == 0;
    }
}
