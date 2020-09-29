package com.example.kymanage.Beans.GetDistributorDumpRecordData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDistributorDumpRecordDataRepBean {

    /**
     * Status : 已发料
     * Qty : 2.0
     * Factory : 2040
     * Handler : wx2090
     * Unit : EA
     * MStatus : 已发料
     * DumpNum : 2009230859391
     * MaterialDesc : LJ5530031545-TZ2010047038
     * Area : P01
     * Storage : 2400
     * UpdateTime : 2020-09-23 08:59:55
     * ProductOrderNO : 000010144128
     * WStatus : 已配送
     * IssueId : 8803.0
     * MaterialCode : LJ5530031545-TZ2010047038
     */

    private String Status;
    private float Qty;
    private String Factory;
    private String Handler;
    private String Unit;
    private String MStatus;
    private String DumpNum;
    private String MaterialDesc;
    private String Area;
    private String Storage;
    private String UpdateTime;
    private String ProductOrderNO;
    private String WStatus;
    private long IssueId;
    private String MaterialCode;
    private String ReverseHandler;
    private String MarketOrderNO;
    private String MarketOrderRow;

    public static GetDistributorDumpRecordDataRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetDistributorDumpRecordDataRepBean.class);
    }

    public static GetDistributorDumpRecordDataRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDistributorDumpRecordDataRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDistributorDumpRecordDataRepBean> arrayGetDistributorDumpRecordDataRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDistributorDumpRecordDataRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDistributorDumpRecordDataRepBean> arrayGetDistributorDumpRecordDataRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDistributorDumpRecordDataRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String Factory) {
        this.Factory = Factory;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getMStatus() {
        return MStatus;
    }

    public void setMStatus(String MStatus) {
        this.MStatus = MStatus;
    }

    public String getDumpNum() {
        return DumpNum;
    }

    public void setDumpNum(String DumpNum) {
        this.DumpNum = DumpNum;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String Storage) {
        this.Storage = Storage;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }

    public String getWStatus() {
        return WStatus;
    }

    public void setWStatus(String WStatus) {
        this.WStatus = WStatus;
    }

    public long getIssueId() {
        return IssueId;
    }

    public void setIssueId(long IssueId) {
        this.IssueId = IssueId;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String marketOrderRow) {
        MarketOrderRow = marketOrderRow;
    }
}
