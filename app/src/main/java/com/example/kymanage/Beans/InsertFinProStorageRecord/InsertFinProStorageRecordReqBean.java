package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * {
 * 	"Factory":"",
 * 	"MarketOrderNO":"",
 * 	"MarketOrderRow":"",
 * 	"ProductOrderNO":"",
 * 	"ProductOrderDesc":"",
 * 	"ProOMaterialNO":"",
 * 	"ProOMaterialDesc":"",
 * 	"ProOMaterialUnit":"",
 * 	"DemandQty":"",
 * 	"AllocatedQty":"",
 * 	"ProductOrderReservedNO":"",
 * 	"ProductOrderReservedRowNO":"",
 *
 * 	"UBNO":"22",
 *      "BUProjectNO":"22",
 *      "UBDemandQty":"33",
 *      "DeliveryDate":"44"
 * }
 */
public class InsertFinProStorageRecordReqBean implements Serializable {
    private String Factory;
    private String Storage;
    private String MarketOrderNO;
    private String MarketOrderRow;
    private String ProductOrderNO;
    private String ProductOrderDesc;
    private String ProOMaterialNO;
    private String ProOMaterialDesc;
    private String ProOMaterialUnit;
    private float DemandQty;
    private float AllocatedQty;
    private float AlreadyQty;
    private String ProductOrderReservedNO;
    private String ProductOrderReservedRowNO;

    private String MCODE;

    public InsertFinProStorageRecordReqBean() {
    }

    public InsertFinProStorageRecordReqBean(String factory, String storage, String marketOrderNO, String marketOrderRow, String productOrderNO, String productOrderDesc, String proOMaterialNO, String proOMaterialDesc, String proOMaterialUnit, float demandQty, float allocatedQty, float alreadyQty, String productOrderReservedNO, String productOrderReservedRowNO, String MCODE) {
        Factory = factory;
        Storage = storage;
        MarketOrderNO = marketOrderNO;
        MarketOrderRow = marketOrderRow;
        ProductOrderNO = productOrderNO;
        ProductOrderDesc = productOrderDesc;
        ProOMaterialNO = proOMaterialNO;
        ProOMaterialDesc = proOMaterialDesc;
        ProOMaterialUnit = proOMaterialUnit;
        DemandQty = demandQty;
        AllocatedQty = allocatedQty;
        AlreadyQty = alreadyQty;
        ProductOrderReservedNO = productOrderReservedNO;
        ProductOrderReservedRowNO = productOrderReservedRowNO;
        this.MCODE = MCODE;
    }

    @JSONField(name="Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name="Factory")
    public void setFactory(String factory) {
        Factory = factory;
    }
    @JSONField(name="Storage")
    public String getStorage() {
        return Storage;
    }
    @JSONField(name="Storage")
    public void setStorage(String storage) {
        Storage = storage;
    }

    @JSONField(name="MarketOrderNO")
    public String getMarketOrderNO() {
        return MarketOrderNO;
    }
    @JSONField(name="MarketOrderNO")
    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }
    @JSONField(name="MarketOrderRow")
    public String getMarketOrderRow() {
        return MarketOrderRow;
    }
    @JSONField(name="MarketOrderRow")
    public void setMarketOrderRow(String marketOrderRow) {
        MarketOrderRow = marketOrderRow;
    }
    @JSONField(name="ProductOrderNO")
    public String getProductOrderNO() {
        return ProductOrderNO;
    }
    @JSONField(name="ProductOrderNO")
    public void setProductOrderNO(String productOrderNO) {
        ProductOrderNO = productOrderNO;
    }
    @JSONField(name="ProductOrderDesc")
    public String getProductOrderDesc() {
        return ProductOrderDesc;
    }
    @JSONField(name="ProductOrderDesc")
    public void setProductOrderDesc(String productOrderDesc) {
        ProductOrderDesc = productOrderDesc;
    }
    @JSONField(name="ProOMaterialNO")
    public String getProOMaterialNO() {
        return ProOMaterialNO;
    }
    @JSONField(name="ProOMaterialNO")
    public void setProOMaterialNO(String proOMaterialNO) {
        ProOMaterialNO = proOMaterialNO;
    }
    @JSONField(name="ProOMaterialDesc")
    public String getProOMaterialDesc() {
        return ProOMaterialDesc;
    }
    @JSONField(name="ProOMaterialDesc")
    public void setProOMaterialDesc(String proOMaterialDesc) {
        ProOMaterialDesc = proOMaterialDesc;
    }
    @JSONField(name="ProOMaterialUnit")
    public String getProOMaterialUnit() {
        return ProOMaterialUnit;
    }
    @JSONField(name="ProOMaterialUnit")
    public void setProOMaterialUnit(String proOMaterialUnit) {
        ProOMaterialUnit = proOMaterialUnit;
    }
    @JSONField(name="DemandQty")
    public float getDemandQty() {
        return DemandQty;
    }
    @JSONField(name="DemandQty")
    public void setDemandQty(float demandQty) {
        DemandQty = demandQty;
    }
    @JSONField(name="AllocatedQty")
    public float getAllocatedQty() {
        return AllocatedQty;
    }
    @JSONField(name="AllocatedQty")
    public void setAllocatedQty(float allocatedQty) {
        AllocatedQty = allocatedQty;
    }

    @JSONField(name="AlreadyQty")
    public float getAlreadyQty() {
        return AlreadyQty;
    }
    @JSONField(name="AlreadyQty")
    public void setAlreadyQty(float alreadyQty) {
        AlreadyQty = alreadyQty;
    }

    @JSONField(name="ProductOrderReservedNO")
    public String getProductOrderReservedNO() {
        return ProductOrderReservedNO;
    }
    @JSONField(name="ProductOrderReservedNO")
    public void setProductOrderReservedNO(String productOrderReservedNO) {
        ProductOrderReservedNO = productOrderReservedNO;
    }
    @JSONField(name="ProductOrderReservedRowNO")
    public String getProductOrderReservedRowNO() {
        return ProductOrderReservedRowNO;
    }
    @JSONField(name="ProductOrderReservedRowNO")
    public void setProductOrderReservedRowNO(String productOrderReservedRowNO) {
        ProductOrderReservedRowNO = productOrderReservedRowNO;
    }

    @JSONField(name="MCODE")
    public String getMCODE() {
        return MCODE;
    }
    @JSONField(name="MCODE")
    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }
}
