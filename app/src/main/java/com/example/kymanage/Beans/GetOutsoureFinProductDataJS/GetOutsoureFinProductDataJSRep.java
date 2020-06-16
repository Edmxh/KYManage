package com.example.kymanage.Beans.GetOutsoureFinProductDataJS;

import java.util.List;

public class GetOutsoureFinProductDataJSRep {

    private int code;
    private String message;
    private List<GetOutsoureFinProductDataJSRepBean> data;

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

    public List<GetOutsoureFinProductDataJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetOutsoureFinProductDataJSRepBean> data) {
        this.data = data;
    }
}
