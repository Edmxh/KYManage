package com.example.kymanage.Beans;

import java.util.List;

/**
 * {
 *     "status": {
 *         "code": 0.0,
 *         "message": "服务器内部错误"
 *     }
 * }
 */

public class StatusBean {

    private long code;
    private String message;

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
}
