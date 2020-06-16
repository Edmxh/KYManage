package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

/**
 * {
 *         "orderType": "20",
 *         "StorageId": 158,
 *         "AdvanceStorageId": 460.0
 *     }
 */
public class OutsourceFinishedProductReceivingJSRepBean {
    private String orderType;
    private long StorageId;
    private long AdvanceStorageId;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public long getStorageId() {
        return StorageId;
    }

    public void setStorageId(long storageId) {
        StorageId = storageId;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }
}
