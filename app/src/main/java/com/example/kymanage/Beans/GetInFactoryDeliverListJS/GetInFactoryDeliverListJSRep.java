package com.example.kymanage.Beans.GetInFactoryDeliverListJS;

import java.util.List;

public class GetInFactoryDeliverListJSRep {
    private int code;
    private String message;
    private List<GetInFactoryDeliverListJSRepBean> data;

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

    public List<GetInFactoryDeliverListJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetInFactoryDeliverListJSRepBean> data) {
        this.data = data;
    }
}
