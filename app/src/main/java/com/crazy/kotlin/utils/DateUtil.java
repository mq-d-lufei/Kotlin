package com.crazy.kotlin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by feaoes on 2018/12/7.
 */

public class DateUtil {

    private final static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return defaultDatePattern;
    }

    /**
     * 返回预设Format的当前日期字符串
     */
    public static String getToday() {
        Date today = new Date();
        return format(today);
    }

    /**
     * 使用预设Format格式化Date成字符串
     */
    public static String format(Date date) {
        return date == null ? " " : format(date, getDatePattern());
    }

    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        return date == null ? " " : new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
    }

    /**
     * 使用预设格式将字符串转为Date
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
