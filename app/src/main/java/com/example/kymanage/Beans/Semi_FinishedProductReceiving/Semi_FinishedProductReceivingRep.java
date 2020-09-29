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
    private long AdvanceStorageId;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
