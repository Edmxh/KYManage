package com.example.kymanage.Beans.InsertDumpTransferRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InsertDumpTransferRecordReqBean {

    /**
     * Status : 已入库
     * SendFactory : 2090
     * Postingdate : 2020-06-17
     * MarketOrderNO : 0010000208
     * DemandFactory : 2010
     * CreateTime : 2020-06-17 09:45:52
     * PID : 40.0
     * Documentdate : 2020-06-17
     * Unit : EA
     * DemandStorage : 2100
     * SID : 216.0
     * YID : 465.0
     * SendStorage : 2912
     * Qty : 1
     * ProductOrderNO : 000010048077
     * ID : 24.0
     * MarketOrderRow : 000026
     * MaterialCode : LJ2015000594-TZ2010043020
     */

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
    private long YID;
    private String SendStorage;
    private float Qty;
    private String ProductOrderNO;
    private long ID;
    private String MarketOrderRow;
    private String MaterialCode;

    public InsertDumpTransferRecordReqBean() {
    }

    public InsertDumpTransferRecordReqBean(String status, String sendFactory, String postingdate, String marketOrderNO, String demandFactory, String createTime, long PID, String documentdate, String unit, String demandStorage, long SID, long YID, String sendStorage, float qty, String productOrderNO, long ID, String marketOrderRow, String materialCode) {
        Status = status;
        SendFactory = sendFactory;
        Postingdate = postingdate;
        MarketOrderNO = marketOrderNO;
        DemandFactory = demandFactory;
        CreateTime = createTime;
        this.PID = PID;
        Documentdate = documentdate;
        Unit = unit;
        DemandStorage = demandStorage;
        this.SID = SID;
        this.YID = YID;
        SendStorage = sendStorage;
        Qty = qty;
        ProductOrderNO = productOrderNO;
        this.ID = ID;
        MarketOrderRow = marketOrderRow;
        MaterialCode = materialCode;
    }

    public static InsertDumpTransferRecordReqBean objectFromData(String str) {

        return new Gson().fromJson(str, InsertDumpTransferRecordReqBean.class);
    }

    public static InsertDumpTransferRecordReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertDumpTransferRecordReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertDumpTransferRecordReqBean> arrayInsertDumpTransferRecordReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertDumpTransferRecordReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertDumpTransferRecordReqBean> arrayInsertDumpTransferRecordReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertDumpTransferRecordReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }
    @JSONField(name = "Status")
    public String getStatus() {
        return Status;
    }
    @JSONField(name = "Status")
    public void setStatus(String Status) {
        this.Status = Status;
    }
    @JSONField(name = "SendFactory")
    public String getSendFactory() {
        return SendFactory;
    }
    @JSONField(name = "SendFactory")
    public void setSendFactory(String SendFactory) {
        this.SendFactory = SendFactory;
    }
    @JSONField(name = "Postingdate")
    public String getPostingdate() {
        return Postingdate;
    }
    @JSONField(name = "Postingdate")
    public void setPostingdate(String Postingdate) {
        this.Postingdate = Postingdate;
    }
    @JSONField(name = "MarketOrderNO")
    public String getMarketOrderNO() {
        return MarketOrderNO;
    }
    @JSONField(name = "MarketOrderNO")
    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }
    @JSONField(name = "DemandFactory")
    public String getDemandFactory() {
        return DemandFactory;
    }
    @JSONField(name = "DemandFactory")
    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }
    @JSONField(name = "CreateTime")
    public String getCreateTime() {
        return CreateTime;
    }
    @JSONField(name = "CreateTime")
    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }
    @JSONField(name = "PID")
    public long getPID() {
        return PID;
    }
    @JSONField(name = "PID")
    public void setPID(long PID) {
        this.PID = PID;
    }
    @JSONField(name = "Documentdate")
    public String getDocumentdate() {
        return Documentdate;
    }
    @JSONField(name = "Documentdate")
    public void setDocumentdate(String Documentdate) {
        this.Documentdate = Documentdate;
    }
    @JSONField(name = "Unit")
    public String getUnit() {
        return Unit;
    }
    @JSONField(name = "Unit")
    public void setUnit(String Unit) {
        this.Unit = Unit;
    }
    @JSONField(name = "DemandStorage")
    public String getDemandStorage() {
        return DemandStorage;
    }
    @JSONField(name = "DemandStorage")
    public void setDemandStorage(String DemandStorage) {
        this.DemandStorage = DemandStorage;
    }
    @JSONField(name = "SID")
    public long getSID() {
        return SID;
    }
    @JSONField(name = "SID")
    public void setSID(long SID) {
        this.SID = SID;
    }
    @JSONField(name = "YID")
    public long getYID() {
        return YID;
    }
    @JSONField(name = "YID")
    public void setYID(long YID) {
        this.YID = YID;
    }
    @JSONField(name = "SendStorage")
    public String getSendStorage() {
        return SendStorage;
    }
    @JSONField(name = "SendStorage")
    public void setSendStorage(String SendStorage) {
        this.SendStorage = SendStorage;
    }
    @JSONField(name = "Qty")
    public float getQty() {
        return Qty;
    }
    @JSONField(name = "Qty")
    public void setQty(float Qty) {
        this.Qty = Qty;
    }
    @JSONField(name = "ProductOrderNO")
    public String getProductOrderNO() {
        return ProductOrderNO;
    }
    @JSONField(name = "ProductOrderNO")
    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }
    @JSONField(name = "ID")
    public long getID() {
        return ID;
    }
    @JSONField(name = "ID")
    public void setID(long ID) {
        this.ID = ID;
    }
    @JSONField(name = "MarketOrderRow")
    public String getMarketOrderRow() {
        return MarketOrderRow;
    }
    @JSONField(name = "MarketOrderRow")
    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }
    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
}
