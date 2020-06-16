package com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS;

import java.util.List;

/**
 *
 */
public class Semi_FinishedProductReceivingRecordJSRep {
    private int code;
    private List<Semi_FinishedProductReceivingRecordJSRepBean> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Semi_FinishedProductReceivingRecordJSRepBean> getData() {
        return data;
    }

    public void setData(List<Semi_FinishedProductReceivingRecordJSRepBean> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
