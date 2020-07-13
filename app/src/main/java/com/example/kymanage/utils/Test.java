package com.example.kymanage.utils;

import android.util.Base64;

import com.example.kymanage.Bitmap.CreateBitmap;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(getSeriesNumber());
    }

    public static String getSeriesNumber(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
        String currentDate = sf.format(date0)+Math.round((Math.random()+1) * 1000);//凭证日期
        return currentDate;
    }
}
