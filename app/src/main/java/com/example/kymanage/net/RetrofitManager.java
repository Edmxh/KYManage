package com.example.kymanage.net;


import com.example.kymanage.API.API;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *Author:
 *Description:
 */public class RetrofitManager {
    private static volatile  RetrofitManager mInstance = null;
    private final Retrofit mretrofit;

    private RetrofitManager() {
        mretrofit = new Retrofit.Builder()
                .baseUrl(API.BASEURL)
                //和ok建立联系
                .client(OkhttpManager.getInstance().getmOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

    public static RetrofitManager getmInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }


    //  泛型 动态代理机制
    public <T> T createService1(final Class<T> service) {
        T t = mretrofit.create(service);
        return t;
    }


}
