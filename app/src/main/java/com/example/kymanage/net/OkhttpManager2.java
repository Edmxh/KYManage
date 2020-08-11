package com.example.kymanage.net;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class OkhttpManager2 {
    private static OkhttpManager2 okhttpManager;
    private static OkHttpClient mOkHttpClient;


    private OkhttpManager2() {
        mOkHttpClient = new OkHttpClient.Builder()
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HanderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor(new MyLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static OkhttpManager2 getInstance() {
        if (okhttpManager == null) {
            synchronized (OkhttpManager2.class) {
                if (okhttpManager == null) {
                    okhttpManager = new OkhttpManager2();
                }
            }
        }
        return okhttpManager;
    }


    public OkHttpClient getmOkHttpClient() {
        return mOkHttpClient;
    }
}
