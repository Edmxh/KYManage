package com.example.kymanage.presenter.InterfaceView;

/*
 *Author:
 *Description:
 */public interface ScanBaseView<T> {

    void onDataSuccessScan(T data);

    void onFailed(String msg);

}
