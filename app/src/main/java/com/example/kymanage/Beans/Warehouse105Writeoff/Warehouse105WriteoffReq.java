package com.example.kymanage.Beans.Warehouse105Writeoff;

/**
 * {
 * 		"id": 1,
 * 		"storageId": 1
 *        }
 */
public class Warehouse105WriteoffReq {
    private String materialType;
    private long storageId;

    public Warehouse105WriteoffReq() {
    }

    public Warehouse105WriteoffReq(String materialType, long storageId) {
        this.materialType = materialType;
        this.storageId = storageId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public long getStorageId() {
        return storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }
}
