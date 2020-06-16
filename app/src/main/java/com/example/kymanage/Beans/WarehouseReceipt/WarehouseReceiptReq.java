package com.example.kymanage.Beans.WarehouseReceipt;

/**
 *  {
 *             "orderNum": "OrderNum",
 *             "orderRow": "OrderRow",
 *             "materialCode": "DQ5095000031",
 *             "demandFactory": "2010",
 *             "demandStorage": "2100",
 *             "receNum": 2,
 *             "productOrder": "pro test 001",
 *             "targetArea": "A001",
 *             "batchNumber":1
 *         }
 */
public class WarehouseReceiptReq {
    private String orderNum;
    private String orderRow;
    private String productOrder;
    private String materialCode;
    private String demandFactory;
    private String demandStorage;
    private float receNum;
    private String targetArea;
    private int batchNumber;

    public WarehouseReceiptReq() {
    }

    public WarehouseReceiptReq(String orderNum, String orderRow, String productOrder, String materialCode, String demandFactory, String demandStorage, float receNum, String targetArea, int batchNumber) {
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.productOrder = productOrder;
        this.materialCode = materialCode;
        this.demandFactory = demandFactory;
        this.demandStorage = demandStorage;
        this.receNum = receNum;
        this.targetArea = targetArea;
        this.batchNumber = batchNumber;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderRow() {
        return orderRow;
    }

    public void setOrderRow(String orderRow) {
        this.orderRow = orderRow;
    }

    public String getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(String productOrder) {
        this.productOrder = productOrder;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getDemandFactory() {
        return demandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        this.demandFactory = demandFactory;
    }

    public String getDemandStorage() {
        return demandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        this.demandStorage = demandStorage;
    }

    public float getReceNum() {
        return receNum;
    }

    public void setReceNum(float receNum) {
        this.receNum = receNum;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }
}
