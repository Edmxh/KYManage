package com.example.kymanage.net;

/*
 *Author:
 *Description:
 */public interface HttpDataListener<T> {
     
    void onDataSuccess(T data);

    void onFailer(String msg);
}
