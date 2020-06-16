package com.example.kymanage.presenter;



/*
 *Author:
 *Description:
 */public interface ReceiveView<T> {

    void onDataSuccess2(T data);

    void onFailed(String msg);

}
