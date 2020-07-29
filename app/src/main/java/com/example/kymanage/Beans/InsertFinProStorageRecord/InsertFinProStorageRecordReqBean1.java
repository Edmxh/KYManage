package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class InsertFinProStorageRecordReqBean1 implements Serializable {

    /**
     * Factory : 2010
     * Storage : 2100
     * MarketOrderNO : 10000208
     * MarketOrderRow : 26
     * ProductOrderNO : 10000010
     * ProductOrderDesc : 测试订单001
     * ProOMaterialNO : ZJ6025011857
     * ProOMaterialDesc : 测试001
     * ProOMaterialUnit : EA
     * DemandQty : 1000
     * AlreadyQty : 50
     * AllocatedQty : 12
     * ProductOrderReservedNO : 10000011
     * ProductOrderReservedRowNO : 122
     * MCode : M002011
     */

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
    private float AlreadyQty;
    private float AllocatedQty;
    private String ProductOrderReservedNO;
    private String ProductOrderReservedRowNO;
    private String MCode;

    public InsertFinProStorageRecordReqBean1(String factory, String storage, String marketOrderNO, String marketOrderRow, String productOrderNO, String productOrderDesc, String proOMaterialNO, String proOMaterialDesc, String proOMaterialUnit, float demandQty, float alreadyQty, float allocatedQty, String productOrderReservedNO, String productOrderReservedRowNO, String MCode) {
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
        AlreadyQty = alreadyQty;
        AllocatedQty = allocatedQty;
        ProductOrderReservedNO = productOrderReservedNO;
        ProductOrderReservedRowNO = productOrderReservedRowNO;
        this.MCode = MCode;
    }

    public static InsertFinProStorageRecordReqBean1 objectFromData(String str) {

        return new Gson().fromJson(str, InsertFinProStorageRecordReqBean1.class);
    }

    public static InsertFinProStorageRecordReqBean1 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertFinProStorageRecordReqBean1.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertFinProStorageRecordReqBean1> arrayInsertFinProStorageRecordReqBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReqBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertFinProStorageRecordReqBean1> arrayInsertFinProStorageRecordReqBean1FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReqBean1>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name = "Factory")
    public void setFactory(String Factory) {
        this.Factory = Factory;
    }
    @JSONField(name = "Storage")
    public String getStorage() {
        return Storage;
    }
    @JSONField(name = "Storage")
    public void setStorage(String Storage) {
        this.Storage = Storage;
    }
    @JSONField(name = "MarketOrderNO")
    public String getMarketOrderNO() {
        return MarketOrderNO;
    }
    @JSONField(name = "MarketOrderNO")
    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }
    @JSONField(name = "MarketOrderRow")
    public String getMarketOrderRow() {
        return MarketOrderRow;
    }
    @JSONField(name = "MarketOrderRow")
    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }
    @JSONField(name = "ProductOrderNO")
    public String getProductOrderNO() {
        return ProductOrderNO;
    }
    @JSONField(name = "ProductOrderNO")
    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }
    @JSONField(name = "ProductOrderDesc")
    public String getProductOrderDesc() {
        return ProductOrderDesc;
    }
    @JSONField(name = "ProductOrderDesc")
    public void setProductOrderDesc(String ProductOrderDesc) {
        this.ProductOrderDesc = ProductOrderDesc;
    }
    @JSONField(name = "ProOMaterialNO")
    public String getProOMaterialNO() {
        return ProOMaterialNO;
    }
    @JSONField(name = "ProOMaterialNO")
    public void setProOMaterialNO(String ProOMaterialNO) {
        this.ProOMaterialNO = ProOMaterialNO;
    }
    @JSONField(name = "ProOMaterialDesc")
    public String getProOMaterialDesc() {
        return ProOMaterialDesc;
    }
    @JSONField(name = "ProOMaterialDesc")
    public void setProOMaterialDesc(String ProOMaterialDesc) {
        this.ProOMaterialDesc = ProOMaterialDesc;
    }
    @JSONField(name = "ProOMaterialUnit")
    public String getProOMaterialUnit() {
        return ProOMaterialUnit;
    }
    @JSONField(name = "ProOMaterialUnit")
    public void setProOMaterialUnit(String ProOMaterialUnit) {
        this.ProOMaterialUnit = ProOMaterialUnit;
    }
    @JSONField(name = "DemandQty")
    public float getDemandQty() {
        return DemandQty;
    }
    @JSONField(name = "DemandQty")
    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }
    @JSONField(name = "AlreadyQty")
    public float getAlreadyQty() {
        return AlreadyQty;
    }
    @JSONField(name = "AlreadyQty")
    public void setAlreadyQty(float AlreadyQty) {
        this.AlreadyQty = AlreadyQty;
    }
    @JSONField(name = "AllocatedQty")
    public float getAllocatedQty() {
        return AllocatedQty;
    }
    @JSONField(name = "AllocatedQty")
    public void setAllocatedQty(float AllocatedQty) {
        this.AllocatedQty = AllocatedQty;
    }
    @JSONField(name = "ProductOrderReservedNO")
    public String getProductOrderReservedNO() {
        return ProductOrderReservedNO;
    }
    @JSONField(name = "ProductOrderReservedNO")
    public void setProductOrderReservedNO(String ProductOrderReservedNO) {
        this.ProductOrderReservedNO = ProductOrderReservedNO;
    }
    @JSONField(name = "ProductOrderReservedRowNO")
    public String getProductOrderReservedRowNO() {
        return ProductOrderReservedRowNO;
    }
    @JSONField(name = "ProductOrderReservedRowNO")
    public void setProductOrderReservedRowNO(String ProductOrderReservedRowNO) {
        this.ProductOrderReservedRowNO = ProductOrderReservedRowNO;
    }
    @JSONField(name = "MCode")
    public String getMCode() {
        return MCode;
    }
    @JSONField(name = "MCode")
    public void setMCode(String MCode) {
        this.MCode = MCode;
    }
}
