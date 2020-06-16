package com.example.kymanage.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTimeUtil {
    private static String timeStr1;
    private static String timeStr2;

    /**
     * (ForExample)当前时间：2019-6-1  20:51:5
     * @return
     */
    public static String getTimeStr1(){
        Calendar instance = Calendar.getInstance();
        int year = instance.get(instance.YEAR);
        int month = instance.get(instance.MARCH);
        int date = instance.get(instance.DAY_OF_MONTH);
        int hour = instance.get(instance.HOUR_OF_DAY);
        int minute = instance.get(instance.MINUTE);
        int secord = instance.get(instance.SECOND);
        timeStr1 =   year+"-"+month+"-"+ date +"  " +hour+ ":" + minute+":"+secord;
        return timeStr1;
    }

    /**
     * (ForExample)当前时间：2019-07-01 20:51:05
     * @return
     */
    public static String getTimeStr2(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStr2 = sf.format(date);
        return timeStr2;
    }


}
