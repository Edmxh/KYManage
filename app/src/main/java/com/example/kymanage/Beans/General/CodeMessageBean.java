package com.example.kymanage.Beans.General;

public class CodeMessageBean {
    /**
     * {
     * 		"code": 1,           状态码
     * 		"message": "查询成功"       查询反馈信息
     *        }
     */
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
