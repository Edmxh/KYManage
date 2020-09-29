package com.example.kymanage.Beans.GetFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * { "CurrentDate":"2020-05-31", "Handler":"kzheng" }
 */
public class GetFinProStorageRecordReq {
    private String CurrentDate;
    private String Factory;
    private String Handler;
    private String MaterialCode;
    private String ProductOrderNO;

    public GetFinProStorageRecordReq() {
    }

    public GetFinProStorageRecordReq(String currentDate, String factory, String handler, String materialCode, String productOrderNO) {
        CurrentDate = currentDate;
        Factory = factory;
        Handler = handler;
        MaterialCode = materialCode;
        ProductOrderNO = productOrderNO;
    }

    @JSONField(name="CurrentDate")
    public String getCurrentDate() {
        return CurrentDate;
    }
    @JSONField(name="CurrentDate")
    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }
    @JSONField(name="Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name="Factory")
    public void setFactory(String factory) {
        Factory = factory;
    }

    @JSONField(name="Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name="Handler")
    public void setHandler(String handler) {
        Handler = handler;
    }

    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }
    @JSONField(name = "ProductOrderNO")
    public String getProductOrderNO() {
        return ProductOrderNO;
    }
    @JSONField(name = "ProductOrderNO")
    public void setProductOrderNO(String productOrderNO) {
        ProductOrderNO = productOrderNO;
    }
}
