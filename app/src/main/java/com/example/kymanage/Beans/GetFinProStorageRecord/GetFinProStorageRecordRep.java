package com.example.kymanage.Beans.GetFinProStorageRecord;

/**
 * {
 *             "MarketOrderNO": "123",
 *             "MCode": "123",
 *             "DemandFactory": "123",
 *             "CreateTime": "2020-05-31 16:50:36",
 *             "BMaterialCode": "ZJ2010000029",
 *             "FinProEnterID": 10.0,
 *             "BMaterialDesc": "TKAS托辊钢管自动倒角切断机床",
 *             "Unit": "123",
 *             "DemandStorage": "123",
 *             "Type": "123",
 *             "Batch": "qew",
 *             "Qty": 123,
 *             "ProductOrderNO": "000010018955",
 *             "ID": 123.0,
 *             "MarketOrderRow": "qew",
 *             "MaterialCode": "123"
 *         }
 */
public class GetFinProStorageRecordRep {
    private String MarketOrderNO;
    private String MCode;
    private String DemandFactory;
    private String CreateTime;
    private String BMaterialCode;
    private long FinProEnterID;
    private String BMaterialDesc;
    private String Unit;
    private String DemandStorage;
    private String Type;
    private String Batch;
    private float Qty;
    private String ProductOrderNO;
    private long ID;
    private String MarketOrderRow;
    private String MaterialCode;
    private String Status;


    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }

    public String getMCode() {
        return MCode;
    }

    public void setMCode(String MCode) {
        this.MCode = MCode;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        DemandFactory = demandFactory;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getBMaterialCode() {
        return BMaterialCode;
    }

    public void setBMaterialCode(String BMaterialCode) {
        this.BMaterialCode = BMaterialCode;
    }

    public long getFinProEnterID() {
        return FinProEnterID;
    }

    public void setFinProEnterID(long finProEnterID) {
        FinProEnterID = finProEnterID;
    }

    public String getBMaterialDesc() {
        return BMaterialDesc;
    }

    public void setBMaterialDesc(String BMaterialDesc) {
        this.BMaterialDesc = BMaterialDesc;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        DemandStorage = demandStorage;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float qty) {
        Qty = qty;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String productOrderNO) {
        ProductOrderNO = productOrderNO;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String marketOrderRow) {
        MarketOrderRow = marketOrderRow;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
