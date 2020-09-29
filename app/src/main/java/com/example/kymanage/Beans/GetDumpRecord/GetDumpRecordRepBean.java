package com.example.kymanage.Beans.GetDumpRecord;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDumpRecordRepBean {

    /**
     * Mjahr : 2020
     * Status : 301
     * SendFactory : 2090
     * Postingdate : 1592150400000
     * MarketOrderNO : 0010000208
     * DemandFactory : 2010
     * CreateTime : 2020-06-15 14:00:37
     * PID : 8.0
     * Documentdate : 1592150400000
     * DemandStorage : 2100
     * SID : 197.0
     * Mblnr : 4900307091
     * SendStorage : 2912
     * Qty : 2
     * ProductOrderNO : 000010048077
     * ID : 7.0
     * MarketOrderRow : 000026
     * MaterialCode : LJ2015000594-TZ2010043020
     */

    private String Mjahr;
    private String Status;
    private String SendFactory;
    private String Postingdate;
    private String MarketOrderNO;
    private String DemandFactory;
    private String CreateTime;
    private long PID;
    private String Documentdate;
    private String DemandStorage;
    private long SID;
    private String Mblnr;
    private String SendStorage;
    private float Qty;
    private String ProductOrderNO;
    private long ID;
    private String MarketOrderRow;
    private String MaterialCode;
    private String ReverseHandler;

    public static GetDumpRecordRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetDumpRecordRepBean.class);
    }

    public static GetDumpRecordRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDumpRecordRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDumpRecordRepBean> arrayGetDumpRecordRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDumpRecordRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDumpRecordRepBean> arrayGetDumpRecordRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDumpRecordRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMjahr() {
        return Mjahr;
    }

    public void setMjahr(String Mjahr) {
        this.Mjahr = Mjahr;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSendFactory() {
        return SendFactory;
    }

    public void setSendFactory(String SendFactory) {
        this.SendFactory = SendFactory;
    }

    public String getPostingdate() {
        return Postingdate;
    }

    public void setPostingdate(String Postingdate) {
        this.Postingdate = Postingdate;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public long getPID() {
        return PID;
    }

    public void setPID(long PID) {
        this.PID = PID;
    }

    public String getDocumentdate() {
        return Documentdate;
    }

    public void setDocumentdate(String Documentdate) {
        this.Documentdate = Documentdate;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String DemandStorage) {
        this.DemandStorage = DemandStorage;
    }

    public long getSID() {
        return SID;
    }

    public void setSID(long SID) {
        this.SID = SID;
    }

    public String getMblnr() {
        return Mblnr;
    }

    public void setMblnr(String Mblnr) {
        this.Mblnr = Mblnr;
    }

    public String getSendStorage() {
        return SendStorage;
    }

    public void setSendStorage(String SendStorage) {
        this.SendStorage = SendStorage;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
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

    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
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
}
