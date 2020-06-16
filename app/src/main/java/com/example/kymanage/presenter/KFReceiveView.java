package com.example.kymanage.presenter;

/*
 *Author:
 *Description:
 */public interface KFReceiveView<T> {

    void onDataSuccesskf(T data);

    void onFailed(String msg);

}
