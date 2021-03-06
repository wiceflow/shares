package com.wiceflow.shares.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author BF
 * @date 2022/6/21
 *
 * String 工具类
 */
@Slf4j
public class StringUtil {

    /**
     * 把字符型数字转换成整型.
     *
     * @param str 字符型数字
     * @return int 返回整型值。如果不能转换则返回默认值defaultValue.
     */
    public static int stringToInt(String str, int defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        if (isInt(str)) {
            return Integer.parseInt(str);
        } else {
            log.info(new Date() + " stringToInteger is fail");
            return defaultValue;
        }
    }

    /**
     * String 转 Double
     * @param str           [String]需要转换的字符串
     * @param defaultValue  [Double]转换失败默认值
     * @return              返回double类型数值
     */
    public static double stringToDouble(String str, double defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            log.info(new Date() + " stringToDouble is fail");
            return defaultValue;
        }
    }

    /**
     * String 转 Float
     * @param str           [String]需要转换的字符串
     * @param defaultValue  [Float] 转换失败后默认值
     * @return              返回float类型数值
     */
    public static float stringToFloat(String str, float defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            log.info(new Date() + " stringToFloat is fail");
            return defaultValue;
        }
    }

    /**
     * String 转成 long
     * @param str           [String]需要转换的字符串
     * @param defaultValue  [long]  转换失败后返回的默认值
     * @return              返回 long 类型
     */
    public static long stringToLong(String str, long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            log.info(new Date() + " stringToLong is fail");
            return defaultValue;
        }
    }

    /**
     * 判断一个字符串是否为数字
     * @param str   [String] 需要转换的字符串
     * @return      通过正则验证返回
     */
    public static boolean isInt(String str) {
        return str.matches("\\d+");
    }

    /**
     * 判断一个字符串是否空
     * @param str   [String]需要判断的字符串
     * @return      若字符串为null则肯定为true 若字符串为 "",去除空格后则长度必为0
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断一个字符串是否非空
     * @param str       [String] 字符串
     * @return          返回isEmpty()的相反值
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


    public static String IntToString(int i,String defaultValue){
        try{
            return String.valueOf(i);
        }catch (Exception e){
            return defaultValue;
        }
    }
}
