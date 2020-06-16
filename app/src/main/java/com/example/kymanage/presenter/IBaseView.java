package com.example.kymanage.presenter;

/*
 *Author:
 *Description:
 */public interface IBaseView<T> {

    void onDataSuccess(T data);

    void onFailed(String msg);

}
