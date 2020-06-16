package com.example.kymanage.presenter;

/*
 *Author:
 *Description:
 */public class BasePresenter<T> {
    T view;

    public T getView() {
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }

    public void detttch() {  //销毁的
        if (view != null) {
            view = null;
        }
    }


}
