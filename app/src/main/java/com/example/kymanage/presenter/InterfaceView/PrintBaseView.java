package com.example.kymanage.presenter.InterfaceView;

/*
 *Author:
 *Description:
 */public interface PrintBaseView<T> {

    void onDataSuccessPrint(T data);

    void onFailed(String msg);

}
