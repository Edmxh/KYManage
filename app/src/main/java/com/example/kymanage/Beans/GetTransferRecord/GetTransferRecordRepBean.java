package com.example.kymanage.Beans.GetTransferRecord;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetTransferRecordRepBean {

    /**
     * Mjahr : 2020
     * Status : 已入库
     * SendFactory : 2090
     * Postingdate : 2020-06-17 00:00:00
     * MarketOrderNO : 0010000208
     * DemandFactory : 2010
     * CreateTime : 2020-06-17 09:45:52
     * PID : 40.0
     * Documentdate : 2020-06-17 00:00:00
     * Unit : EA
     * DemandStorage : 2100
     * SID : 216.0
     * Mblnr : 4900307119
     * YID : 465.0
     * SendStorage : 2912
     * Qty : 1
     * ProductOrderNO : 000010048077
     * ID : 24.0
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
    private String Unit;
    private String DemandStorage;
    private long SID;
    private String Mblnr;
    private long YID;
    private String SendStorage;
    private float Qty;
    private String ProductOrderNO;
    private long ID;
    private String MarketOrderRow;
    private String MaterialCode;

    public static GetTransferRecordRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetTransferRecordRepBean.class);
    }

    public static GetTransferRecordRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetTransferRecordRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetTransferRecordRepBean> arrayGetTransferRecordRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetTransferRecordRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetTransferRecordRepBean> arrayGetTransferRecordRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetTransferRecordRepBean>>() {
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

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
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

    public long getYID() {
        return YID;
    }

    public void setYID(long YID) {
        this.YID = YID;
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
}
