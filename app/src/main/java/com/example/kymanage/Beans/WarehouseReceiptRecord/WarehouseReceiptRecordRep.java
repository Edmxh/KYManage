package com.example.kymanage.Beans.WarehouseReceiptRecord;

/**
 *  {
 *             "purchaseOrderNo": "4100011740",
 *             "advanceStorageId": 179,
 *             "materialType": "非专有",
 *             "qty": 9.0,
 *             "recStatus": "入库",
 *             "materialCode": "DQ5095000046",
 *             "id": 168,
 *             "materialDescription": "航空插头外壳/MT25-N",
 *             "storageId": 42
 *         }
 */
public class WarehouseReceiptRecordRep {
    private String purchaseOrderNo;
    private String materialType;
    private float qty;
    private String materialCode;
    private long advanceStorageId;
    private long id;
    private long storageId;
    private String materialDescription;
    private String recStatus;

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public long getAdvanceStorageId() {
        return advanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        this.advanceStorageId = advanceStorageId;
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

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }
}
