package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InsertFinProStorageRecordReqBean2 {

    /**
     * MaterialCode : LJ6025011857
     * ProductOrderNO : 10042078
     * Qty : 1
     * MarketOrderNO : 30000115
     * MarketOrderRow : 000020
     * Unit : EA
     * MCode : M002012
     * MaterialDesc : 测试20200601
     */

    private String MaterialCode;
    private String ProductOrderNO;
    private String Factory;
    private String Storage;
    private float Qty;
    private String MarketOrderNO;
    private String MarketOrderRow;
    private String Unit;
    private String MCode;
    private String MaterialDesc;

    public InsertFinProStorageRecordReqBean2(String materialCode, String productOrderNO, String factory, String storage, float qty, String marketOrderNO, String marketOrderRow, String unit, String MCode, String materialDesc) {
        MaterialCode = materialCode;
        ProductOrderNO = productOrderNO;
        Factory = factory;
        Storage = storage;
        Qty = qty;
        MarketOrderNO = marketOrderNO;
        MarketOrderRow = marketOrderRow;
        Unit = unit;
        this.MCode = MCode;
        MaterialDesc = materialDesc;
    }

    public static InsertFinProStorageRecordReqBean2 objectFromData(String str) {

        return new Gson().fromJson(str, InsertFinProStorageRecordReqBean2.class);
    }

    public static InsertFinProStorageRecordReqBean2 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertFinProStorageRecordReqBean2.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertFinProStorageRecordReqBean2> arrayInsertFinProStorageRecordReqBean2FromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReqBean2>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertFinProStorageRecordReqBean2> arrayInsertFinProStorageRecordReqBean2FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReqBean2>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
    @JSONField(name = "ProductOrderNO")
    public String getProductOrderNO() {
        return ProductOrderNO;
    }
    @JSONField(name = "ProductOrderNO")
    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name = "Factory")
    public void setFactory(String factory) {
        Factory = factory;
    }
    @JSONField(name = "Storage")
    public String getStorage() {
        return Storage;
    }
    @JSONField(name = "Storage")
    public void setStorage(String storage) {
        Storage = storage;
    }

    @JSONField(name = "Qty")
    public float getQty() {
        return Qty;
    }
    @JSONField(name = "Qty")
    public void setQty(float Qty) {
        this.Qty = Qty;
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
    @JSONField(name = "Unit")
    public String getUnit() {
        return Unit;
    }
    @JSONField(name = "Unit")
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
    @JSONField(name = "MCode")
    public String getMCode() {
        return MCode;
    }
    @JSONField(name = "MCode")
    public void setMCode(String MCode) {
        this.MCode = MCode;
    }
    @JSONField(name = "MaterialDesc")
    public String getMaterialDesc() {
        return MaterialDesc;
    }
    @JSONField(name = "MaterialDesc")
    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }
}
