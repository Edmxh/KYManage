package com.example.kymanage.Beans.Semi_FinishedProductReceiving;

/**
 * {
 *         "code": 1.0,
 *         "storageId":  151
 *         "message": "收货成功"
 * }
 */
public class Semi_FinishedProductReceivingRep {
    private int code;
    private long storageId;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getStorageId() {
        return storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
