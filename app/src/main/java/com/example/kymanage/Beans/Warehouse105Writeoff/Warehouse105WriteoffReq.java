package com.example.kymanage.Beans.Warehouse105Writeoff;

/**
 * {
 * 		"id": 1,
 * 		"storageId": 1
 *        }
 */
public class Warehouse105WriteoffReq {
    private long id;
    private long storageId;

    public Warehouse105WriteoffReq() {
    }

    public Warehouse105WriteoffReq(long id, long storageId) {
        this.id = id;
        this.storageId = storageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStorageId() {
        return storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }
}
