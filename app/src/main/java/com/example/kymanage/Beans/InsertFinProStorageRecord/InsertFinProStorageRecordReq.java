package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class InsertFinProStorageRecordReq {

    /**
     * MaterialCode : LJ6025011857
     * MaterialDesc : 测试20200601
     * MaterialType : 非专有
     * Factory : 2090
     * Storage : 2906
     * Qty : 5
     * Unit : EA
     * MarketOrderNO : 30000115
     * MarketOrderRow : 000020
     * Handler : kzheng
     */

    private String MaterialCode;
    private String MaterialDesc;
    private String MaterialType;
    private String Factory;
    private float Qty;
    private float MQty;
    private String Unit;
    private String MarketOrderNO;
    private String MarketOrderRow;
    private String Handler;
    private String SerialNumber;

    private List<InsertFinProStorageRecordReqBean2> ldata;
    private List<InsertFinProStorageRecordReqBean1> sdata;

    public InsertFinProStorageRecordReq(String materialCode, String materialDesc, String materialType, String factory, float qty, float MQty, String unit, String marketOrderNO, String marketOrderRow, String handler,String serialNumber, List<InsertFinProStorageRecordReqBean2> ldata, List<InsertFinProStorageRecordReqBean1> sdata) {
        MaterialCode = materialCode;
        MaterialDesc = materialDesc;
        MaterialType = materialType;
        Factory = factory;
        Qty = qty;
        this.MQty = MQty;
        Unit = unit;
        MarketOrderNO = marketOrderNO;
        MarketOrderRow = marketOrderRow;
        Handler = handler;
        SerialNumber = serialNumber;
        this.ldata = ldata;
        this.sdata = sdata;
    }

    public static InsertFinProStorageRecordReq objectFromData(String str) {

        return new Gson().fromJson(str, InsertFinProStorageRecordReq.class);
    }

    public static InsertFinProStorageRecordReq objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertFinProStorageRecordReq.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertFinProStorageRecordReq> arrayInsertFinProStorageRecordReqFromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReq>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertFinProStorageRecordReq> arrayInsertFinProStorageRecordReqFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertFinProStorageRecordReq>>() {
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
    @JSONField(name = "MaterialDesc")
    public String getMaterialDesc() {
        return MaterialDesc;
    }
    @JSONField(name = "MaterialDesc")
    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }
    @JSONField(name = "MaterialType")
    public String getMaterialType() {
        return MaterialType;
    }
    @JSONField(name = "MaterialType")
    public void setMaterialType(String MaterialType) {
        this.MaterialType = MaterialType;
    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name = "Factory")
    public void setFactory(String Factory) {
        this.Factory = Factory;
    }
    @JSONField(name = "Qty")
    public float getQty() {
        return Qty;
    }
    @JSONField(name = "Qty")
    public void setQty(float Qty) {
        this.Qty = Qty;
    }
    @JSONField(name = "MQty")
    public float getMQty() {
        return MQty;
    }
    @JSONField(name = "MQty")
    public void setMQty(float MQty) {
        this.MQty = MQty;
    }

    @JSONField(name = "Unit")
    public String getUnit() {
        return Unit;
    }
    @JSONField(name = "Unit")
    public void setUnit(String Unit) {
        this.Unit = Unit;
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
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String Handler) {
        this.Handler = Handler;
    }


    @JSONField(name = "SerialNumber")
    public String getSerialNumber() {
        return SerialNumber;
    }
    @JSONField(name = "SerialNumber")
    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public List<InsertFinProStorageRecordReqBean2> getLdata() {
        return ldata;
    }

    public void setLdata(List<InsertFinProStorageRecordReqBean2> ldata) {
        this.ldata = ldata;
    }

    public List<InsertFinProStorageRecordReqBean1> getSdata() {
        return sdata;
    }

    public void setSdata(List<InsertFinProStorageRecordReqBean1> sdata) {
        this.sdata = sdata;
    }
}
