package com.example.kymanage.Beans.GetParchaseCenterLable;

import java.util.List;

public class GetParchaseCenterLableReps {
    private long code;
    private String message;
    private List<GetParchaseCenterLableRep> data;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetParchaseCenterLableRep> getData() {
        return data;
    }

    public void setData(List<GetParchaseCenterLableRep> data) {
        this.data = data;
    }
}
