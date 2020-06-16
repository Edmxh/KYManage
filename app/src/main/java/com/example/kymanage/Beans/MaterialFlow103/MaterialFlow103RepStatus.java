package com.example.kymanage.Beans.MaterialFlow103;

import java.util.List;

/**
 * "status": {
 *         "code": 1.0,
 *         "data": [
 *             151,
 *             152
 *         ],
 *         "message": "收货成功"
 *     }
 */
public class MaterialFlow103RepStatus {
    private int code;
    private List<Long> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
