package com.example.kymanage.Beans;

/**
 * {
 *     "flag": 1.0,
 *     "message": "物料场地更新成功"
 * }
 */
public class FlagAndMessageBean {
    private long flag;
    private String message;

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
