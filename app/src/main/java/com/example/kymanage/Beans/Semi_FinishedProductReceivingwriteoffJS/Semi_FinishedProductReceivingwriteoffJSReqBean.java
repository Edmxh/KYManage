package com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 *             "StorageId": 85,
 *             "AdvanceStorageId": 321
 *         }
 */
public class Semi_FinishedProductReceivingwriteoffJSReqBean {
    private long StorageId;
    private long AdvanceStorageId;

    public Semi_FinishedProductReceivingwriteoffJSReqBean() {
    }

    public Semi_FinishedProductReceivingwriteoffJSReqBean(long storageId, long advanceStorageId) {
        StorageId = storageId;
        AdvanceStorageId = advanceStorageId;
    }
    @JSONField(name = "StorageId")
    public long getStorageId() {
        return StorageId;
    }
    @JSONField(name = "StorageId")
    public void setStorageId(long storageId) {
        StorageId = storageId;
    }
    @JSONField(name = "AdvanceStorageId")
    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }
    @JSONField(name = "AdvanceStorageId")
    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }
}
