package com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS;

import java.util.List;

public class GetSapStorageInfoByFactoryJSBean {
    private int code;
    private String message;
    private List<iddesBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<iddesBean> getData() {
        return data;
    }

    public void setData(List<iddesBean> data) {
        this.data = data;
    }
}
