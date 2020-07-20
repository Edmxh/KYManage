package com.example.kymanage.utils;

import android.util.Base64;

import com.example.kymanage.Bitmap.CreateBitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

    }

    public static String getSeriesNumber(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
        String currentDate = sf.format(date0)+Math.round((Math.random()+1) * 1000);//凭证日期
        return currentDate;
    }
}
