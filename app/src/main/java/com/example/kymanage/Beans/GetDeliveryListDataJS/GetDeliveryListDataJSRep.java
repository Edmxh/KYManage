package com.example.kymanage.Beans.GetDeliveryListDataJS;

import java.util.List;

public class GetDeliveryListDataJSRep {
    private int code;
    private String message;
    private List<GetDeliveryListDataJSRepBean> data;

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

    public List<GetDeliveryListDataJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetDeliveryListDataJSRepBean> data) {
        this.data = data;
    }
}
