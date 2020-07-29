package com.example.kymanage.Beans.WarehouseReceiptRecord;

/**
 *  {
 *             "purchaseOrderNo": "4100011740",
 *             "advanceStorageId": 179,
 *             "materialType": "非专有",
 *             "PurchaseOrderRow":"",
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
    private String PurchaseOrderRow;
    private String materialType;
    private float qty;
    private String materialCode;
    private long advanceStorageId;
    private long id;
    private long storageId;
    private String materialDescription;
    private String recStatus;

    private String ReverseHandler;
    private String CreateTime ;
    private String UpdateTime ;
    private String Handler ;

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getPurchaseOrderRow() {
        return PurchaseOrderRow;
    }

    public void setPurchaseOrderRow(String purchaseOrderRow) {
        PurchaseOrderRow = purchaseOrderRow;
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

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String handler) {
        Handler = handler;
    }
}
