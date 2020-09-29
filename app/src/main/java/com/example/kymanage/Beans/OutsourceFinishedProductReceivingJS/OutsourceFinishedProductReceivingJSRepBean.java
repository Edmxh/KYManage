package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import java.io.Serializable;

/**
 * {
 *         "orderType": "20",
 *         "StorageId": 158,
 *         "AdvanceStorageId": 460.0
 *     }
 */
public class OutsourceFinishedProductReceivingJSRepBean implements Serializable {
    private String orderType;
    private long StorageId;
    private long AdvanceStorageId;
    private String factory;

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

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
