package com.example.kymanage.net;

import android.text.TextUtils;

import okhttp3.logging.HttpLoggingInterceptor;

/*
 *Author:
 *Description:     拦截器   日志
 */public class MyLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        if (!TextUtils.isEmpty(message)) {
            if (message.startsWith("{") || message.startsWith("[")) {
                Logutil.json(message);
            } else {
                Logutil.v(message);
            }
        }
    }
}
