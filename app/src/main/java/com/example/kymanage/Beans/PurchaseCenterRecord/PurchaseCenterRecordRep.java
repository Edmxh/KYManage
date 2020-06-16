package com.example.kymanage.Beans.PurchaseCenterRecord;

/**
 * {
 *             "code": "1",
 *             "materialType": "1",
 *             "orderNum": "1",
 *             "description": "1",
 *             "ID": 19,
 *             "row": "1",
 *             "receiveNum": 1.0
 *         }
 */
public class PurchaseCenterRecordRep {
    private long AdvanceStorageId;
    private String code;
    private String materialType;
    private String orderNum;
    private String description;
    private long ID;
    private String row;
    private float receiveNum;
    private String describe;
    private String updateTime;

    public PurchaseCenterRecordRep() {
    }

    public PurchaseCenterRecordRep(long advanceStorageId, String code, String materialType, String orderNum, String description, long ID, String row, float receiveNum, String describe, String updateTime) {
        AdvanceStorageId = advanceStorageId;
        this.code = code;
        this.materialType = materialType;
        this.orderNum = orderNum;
        this.description = description;
        this.ID = ID;
        this.row = row;
        this.receiveNum = receiveNum;
        this.describe = describe;
        this.updateTime = updateTime;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public float getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(float receiveNum) {
        this.receiveNum = receiveNum;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
