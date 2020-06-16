package com.example.kymanage.Beans.GetDispatchListJS;

import java.util.List;

public class GetDispatchListJSRep {
    private int code;
    private List<GetDispatchListJSBean2> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<GetDispatchListJSBean2> getData() {
        return data;
    }

    public void setData(List<GetDispatchListJSBean2> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
