package com.example.kymanage.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HanderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("appKey", "03306135-280c-4542-a3fd-46c5a46d4722");
        builder.addHeader("Content-Type","application/json;charset=UTF-8");
        builder.addHeader("Accept", "application/json");
        Request request1 = builder.build();
        return chain.proceed(request1);


    }
}
