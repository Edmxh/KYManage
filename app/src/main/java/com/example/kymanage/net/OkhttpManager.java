package com.example.kymanage.net;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class OkhttpManager {
    private static OkhttpManager okhttpManager;
    private static OkHttpClient mOkHttpClient;


    private OkhttpManager() {
        mOkHttpClient = new OkHttpClient.Builder()
                .writeTimeout(180000, TimeUnit.MILLISECONDS)
                .readTimeout(180000, TimeUnit.MILLISECONDS)
                .connectTimeout(180000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HanderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor(new MyLogger()).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static OkhttpManager getInstance() {
        if (okhttpManager == null) {
            synchronized (OkhttpManager.class) {
                if (okhttpManager == null) {
                    okhttpManager = new OkhttpManager();
                }
            }
        }
        return okhttpManager;
    }


    public OkHttpClient getmOkHttpClient() {
        return mOkHttpClient;
    }
}
