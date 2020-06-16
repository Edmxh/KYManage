package com.example.kymanage.Beans.InsertStorageLableRecord;

import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;

import java.util.List;

/**
 *  {
 *       "materialCode":"dsfe002344",
 *       "receiveNum": 5,
 *       "printPeople": "张飞",
 *       "printTime": "2020-01-08",
 *       "factory": "2000",
 *       "unit": "cs",
 *       "materialDesc": "螺丝",
 *       "materialType":"专有",
 *       "productOrder": [
 *         {
 *           "orderNo": "10051586",
 *           "issueNum": 2
 *         },
 *         {
 *           "orderNo": "10053470",
 *           "issueNum": 3
 *         }
 *       ]
 *     }
 */
public class InsertStorageLableRecordReq {
    private String materialCode;
    private float receiveNum;
    private String printPeople;
    private String printTime;
    private String factory;
    private String unit;
    private String materialDesc;
    private String materialType;
    private List<ProductOrderBean> productOrder;

    public InsertStorageLableRecordReq() {
    }

    public InsertStorageLableRecordReq(String materialCode, float receiveNum, String printPeople, String printTime, String factory, String unit, String materialDesc, String materialType, List<ProductOrderBean> productOrder) {
        this.materialCode = materialCode;
        this.receiveNum = receiveNum;
        this.printPeople = printPeople;
        this.printTime = printTime;
        this.factory = factory;
        this.unit = unit;
        this.materialDesc = materialDesc;
        this.materialType = materialType;
        this.productOrder = productOrder;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public float getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(float receiveNum) {
        this.receiveNum = receiveNum;
    }

    public String getPrintPeople() {
        return printPeople;
    }

    public void setPrintPeople(String printPeople) {
        this.printPeople = printPeople;
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public List<ProductOrderBean> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrderBean> productOrder) {
        this.productOrder = productOrder;
    }
}
