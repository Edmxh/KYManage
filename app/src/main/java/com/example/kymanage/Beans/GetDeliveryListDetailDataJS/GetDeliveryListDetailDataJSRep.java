package com.example.kymanage.Beans.GetDeliveryListDetailDataJS;

import java.util.List;

public class GetDeliveryListDetailDataJSRep {
    private int code;
    private String message;
    private List<GetDeliveryListDetailDataJSRepBean> data;

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

    public List<GetDeliveryListDetailDataJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetDeliveryListDetailDataJSRepBean> data) {
        this.data = data;
    }
}
