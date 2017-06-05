package com.tm.yunmo.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by daoying on 2017/5/16.
 */
public class DateUtil {


    /**
     * 日期转字符串
     *
     * @param time
     * @return
     */
    public static String dateToString(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }


    /**
     * 字符串转日期
     *
     * @param dateString
     * @return
     */
    public static Date StrToDate(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 两个string类型的日期比较大小
     *
     * @param DATE1
     * @param DATE2
     * @return 1: 说明date1> date2
     * -1: 说明date1< date2
     * -: 说明date1< date2
     */
    public static int compare_date(Date DATE1, Date DATE2) {
        if (DATE1.getTime() > DATE2.getTime()) {
            System.out.println("说明date1> date2");
            return 1;
        } else if (DATE1.getTime() < DATE2.getTime()) {
            System.out.println("说明date1< date2");
            return -1;
        } else {
            return 0;
        }

    }


    /**
     * 两个string类型的日期比较大小
     *
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public static String getDetailTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH) + 1;//获取月份  // 0-based!
        int day = cal.get(Calendar.DATE);//获取日
        int hour = cal.get(Calendar.HOUR);//小时
        int minute = cal.get(Calendar.MINUTE);//分
        int second = cal.get(Calendar.SECOND);//秒
        int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK) - 1;//一周的第几天
        System.out.println("现在的时间是：公元" + year + "年" + month + "月" + day + "日      " + hour + "时" + minute + "分" + second + "秒       星期" + WeekOfYear);
        String detailTimeStr = "现在的时间是：公元" + year + "年" + month + "月" + day + "日      " + hour + "时" + minute + "分" + second + "秒       星期" + WeekOfYear;
        return detailTimeStr;
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);//获取年份
        return year;
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;//获取月份 // 0-based!
        return month;
    }


    public static void main(String[] args) {
        getDetailTime(new Date());
    }

    /**
     * 返回两个string类型日期之间相差的天数
     *
     * @param aDate
     * @param bDate
     * @return
     */
    public static int daysBetween2Date(String aDate, String bDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        long time1 = 0;
        long time2 = 0;

        try {
            cal.setTime(sdf.parse(aDate));
            time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bDate));
            time2 = cal.getTimeInMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 判断是否润年
     *
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(String ddate) {

        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        Date d = StrToDate(ddate);
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(d);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            if ((year % 100) == 0)
                return false;
            else
                return true;
        } else
            return false;
    }


    /**
     * 返回两个string类型日期相差的小时数
     *
     * @param aTime
     * @param bTime
     * @return
     */
    public static int hoursBetween2Date(String aTime, String bTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Calendar cal = Calendar.getInstance();
        long time1 = 0;
        long time2 = 0;

        try {
            cal.setTime(sdf.parse(aTime));
            time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bTime));
            time2 = cal.getTimeInMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long between_days = (time2 - time1) / (1000 * 3600);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 计算两段日期的重合日期
     *
     * @param str1 开始日期1
     * @param str2 结束日期1
     * @param str3 开始日期2
     * @param str4 结束日期2
     * @return
     * @throws Exception
     */
    public static Map<String, Object> comparisonRQ(String str1, String str2, String str3,
                                                   String str4) throws Exception {
        String mesg = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startdate = "";
        String enddate = "";
        try {
            Date dt1 = df.parse(str1);
            Date dt2 = df.parse(str2);
            Date dt3 = df.parse(str3);
            Date dt4 = df.parse(str4);
            if (dt1.getTime() <= dt3.getTime() && dt3.getTime() <= dt2.getTime() && dt2.getTime() <= dt4.getTime()) {
                mesg = "f";//重合
                startdate = str3;
                enddate = str2;
            }
            if (dt1.getTime() >= dt3.getTime() && dt3.getTime() <= dt2.getTime() && dt2.getTime() <= dt4.getTime()) {
                mesg = "f";//重合
                startdate = str1;
                enddate = str2;
            }

            if (dt3.getTime() <= dt1.getTime() && dt1.getTime() <= dt4.getTime() && dt4.getTime() <= dt2.getTime()) {
                mesg = "f";//重合
                startdate = str1;
                enddate = str4;
            }
            if (dt3.getTime() >= dt1.getTime() && dt1.getTime() <= dt4.getTime() && dt4.getTime() <= dt2.getTime()) {
                mesg = "f";//重合
                startdate = str3;
                enddate = str4;
            }

            System.out.println(startdate + "----" + enddate);


        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException(e.getMessage(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startdate", startdate);
        map.put("enddate", enddate);
        return map;
    }


}
