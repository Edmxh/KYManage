package com.example.kymanage.Beans.GetParchaseCenterLable;

/**
 *   {
 *             "PoRow": "00020",
 *             "factory": "2010",
 *             "MarketOrderNO": "销售订单号",
 *             "labelSeqNum": "15899473659211",
 *             "materialDesc": "插头/MC200-E1_6pin",
 *             "num": 5.0,
 *             "materialType": "专有",
 *             "materialCode": "DQ5095000031",
 *             "unit": "EA",
 *             "productOrderNO": "0000100445401",
 *             "areaNo": "I29",
 *             "company": "TKAS",
 *             "OrderMaterialCode": "上游BJ号",
 *             "MarketOrderRow": "销行号",
 *             "printTime": "2020-01-01",
 *             "printFactory": "PD",
 *             "Po": "4100011740",
 *             "OrderMaterialDesc": "上游BJ描述",
 *             "AdvanceStorageId": 1
 *         }
 */

public class GetParchaseCenterLableRep {
    private String printTime;
    private String company;
    private String printFactory;
    private String Po;
    private String PoRow;
    private String labelSeqNum;
    private String factory;
    private float num;
    private String unit;
    private String areaNo;
    private String materialCode;
    private String materialDesc;
    //private String mCode;
    private String remark;
    private String materialType;
    private String MarketOrderNO;
    private String MarketOrderRow;
    private String productOrderNO;
    private String OrderMaterialDesc;
    private String OrderMaterialCode;
    private int batchNumber;

    private long AdvanceStorageId;

    public GetParchaseCenterLableRep() {
    }


    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrintFactory() {
        return printFactory;
    }

    public void setPrintFactory(String printFactory) {
        this.printFactory = printFactory;
    }

    public String getPo() {
        return Po;
    }

    public void setPo(String po) {
        Po = po;
    }

    public String getPoRow() {
        return PoRow;
    }

    public void setPoRow(String poRow) {
        PoRow = poRow;
    }

    public String getLabelSeqNum() {
        return labelSeqNum;
    }

    public void setLabelSeqNum(String labelSeqNum) {
        this.labelSeqNum = labelSeqNum;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }

    public String getProductOrderNO() {
        return productOrderNO;
    }

    public void setProductOrderNO(String productOrderNO) {
        this.productOrderNO = productOrderNO;
    }

    public String getOrderMaterialDesc() {
        return OrderMaterialDesc;
    }

    public void setOrderMaterialDesc(String OrderMaterialDesc) {
        this.OrderMaterialDesc = OrderMaterialDesc;
    }

    public String getOrderMaterialCode() {
        return OrderMaterialCode;
    }

    public void setOrderMaterialCode(String OrderMaterialCode) {
        this.OrderMaterialCode = OrderMaterialCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }
}
