package com.example.kymanage.Beans.GetFinProStorageRecordNote;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetFinProStorageRecordNoteRepBean {

    /**
     * SendFactory : 2010
     * FType : 机加
     * MarketOrderNO : 0010000208
     * DemandQty : 1000.0
     * clientShortName :
     * MCode :
     * ProOMaterialNO : ZJ9310000007
     * Factory : 2010
     * clientNO :
     * CreateDate : 2020-08-01 10:13:40
     * ProductOrderDesc :
     * AllocatedQty : 10.0
     * MaterialDesc :
     * Area : C09
     * Storage : 2100
     * NoteType : 内部配送
     * ProOMaterialDesc : 集中控制系统
     * SendStorage : 2906
     * ProductOrderNO : 000010048077
     * ID : 8346.0
     * ProOMaterialUnit : EA
     * MarketOrderRow : 000026
     * MaterialCode :
     */

    private String SendFactory;
    private String FType;
    private String MarketOrderNO;
    private float DemandQty;
    private String clientShortName;
    private String MCode;
    private String ProOMaterialNO;
    private String Factory;
    private String clientNO;
    private String CreateDate;
    private String ProductOrderDesc;
    private float AllocatedQty;
    private String MaterialDesc;
    private String Area;
    private String Storage;
    private String NoteType;
    private String ProOMaterialDesc;
    private String SendStorage;
    private String ProductOrderNO;
    private long ID;
    private String ProOMaterialUnit;
    private String MarketOrderRow;
    private String MaterialCode;
    private String facName;
    private String workNO;
    private String PlanOrderNO;
    private String Sobkz;
    private String Lgpbz;
    private String OrderType;

    public static GetFinProStorageRecordNoteRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetFinProStorageRecordNoteRepBean.class);
    }

    public static GetFinProStorageRecordNoteRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetFinProStorageRecordNoteRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetFinProStorageRecordNoteRepBean> arrayGetFinProStorageRecordNoteRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetFinProStorageRecordNoteRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetFinProStorageRecordNoteRepBean> arrayGetFinProStorageRecordNoteRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetFinProStorageRecordNoteRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getSendFactory() {
        return SendFactory;
    }

    public void setSendFactory(String SendFactory) {
        this.SendFactory = SendFactory;
    }

    public String getFType() {
        return FType;
    }

    public void setFType(String FType) {
        this.FType = FType;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }

    public String getClientShortName() {
        return clientShortName;
    }

    public void setClientShortName(String clientShortName) {
        this.clientShortName = clientShortName;
    }

    public String getMCode() {
        return MCode;
    }

    public void setMCode(String MCode) {
        this.MCode = MCode;
    }

    public String getProOMaterialNO() {
        return ProOMaterialNO;
    }

    public void setProOMaterialNO(String ProOMaterialNO) {
        this.ProOMaterialNO = ProOMaterialNO;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String Factory) {
        this.Factory = Factory;
    }

    public String getClientNO() {
        return clientNO;
    }

    public void setClientNO(String clientNO) {
        this.clientNO = clientNO;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getProductOrderDesc() {
        return ProductOrderDesc;
    }

    public void setProductOrderDesc(String ProductOrderDesc) {
        this.ProductOrderDesc = ProductOrderDesc;
    }

    public float getAllocatedQty() {
        return AllocatedQty;
    }

    public void setAllocatedQty(float AllocatedQty) {
        this.AllocatedQty = AllocatedQty;
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

    public String getNoteType() {
        return NoteType;
    }

    public void setNoteType(String NoteType) {
        this.NoteType = NoteType;
    }

    public String getProOMaterialDesc() {
        return ProOMaterialDesc;
    }

    public void setProOMaterialDesc(String ProOMaterialDesc) {
        this.ProOMaterialDesc = ProOMaterialDesc;
    }

    public String getSendStorage() {
        return SendStorage;
    }

    public void setSendStorage(String SendStorage) {
        this.SendStorage = SendStorage;
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

    public String getProOMaterialUnit() {
        return ProOMaterialUnit;
    }

    public void setProOMaterialUnit(String ProOMaterialUnit) {
        this.ProOMaterialUnit = ProOMaterialUnit;
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

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getWorkNO() {
        return workNO;
    }

    public void setWorkNO(String workNO) {
        this.workNO = workNO;
    }

    public String getPlanOrderNO() {
        return PlanOrderNO;
    }

    public void setPlanOrderNO(String planOrderNO) {
        PlanOrderNO = planOrderNO;
    }

    public String getSobkz() {
        return Sobkz;
    }

    public void setSobkz(String sobkz) {
        Sobkz = sobkz;
    }

    public String getLgpbz() {
        return Lgpbz;
    }

    public void setLgpbz(String lgpbz) {
        Lgpbz = lgpbz;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }
}
