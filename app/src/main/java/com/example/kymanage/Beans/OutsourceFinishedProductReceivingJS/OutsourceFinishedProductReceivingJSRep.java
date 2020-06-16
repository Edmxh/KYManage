package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import java.util.List;

/**
 * {
 *     "code": 1.0,
 *     "message": "收货成功",
 *     "AdvanceStorageId": 362.0
 * }
 */
public class OutsourceFinishedProductReceivingJSRep {
    private int code;
    private String message;
    private OutsourceFinishedProductReceivingJSRepBean data;

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

    public OutsourceFinishedProductReceivingJSRepBean getData() {
        return data;
    }

    public void setData(OutsourceFinishedProductReceivingJSRepBean data) {
        this.data = data;
    }
}
