package com.example.kymanage.presenter;

/*
 *Author:
 *Description:
 */public interface PrintView<T> {

    void onDataSuccess4(T data);

    void onFailed(String msg);

}
