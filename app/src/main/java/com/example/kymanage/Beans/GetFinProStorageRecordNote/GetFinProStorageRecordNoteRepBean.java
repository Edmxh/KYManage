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
     * SendFactory : 2090
     * FType : 机加
     * MarketOrderNO : 0010000208
     * DemandQty : 1000.0
     * clientShortName :
     * MCode :
     * ProOMaterialNO : ZJ9310000007
     * Factory : 2010
     * clientNO :
     * CreateDate : 2020-06-22 18:18:27
     * ProductOrderDesc :
     * AllocatedQty : 20.0
     * MaterialDesc : 板
     * Area : A11
     * Storage : 2100
     * NoteType : 内部配送
     * ProOMaterialDesc : 集中控制系统
     * SendStorage : 2912
     * ProductOrderNO : 000010048077
     * MaterialUnit : EA
     * ID : 535.0
     * ProOMaterialUnit : EA
     * MarketOrderRow : 000026
     * MaterialCode : LJ5525003029-TZ2010041014
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
    private String MaterialUnit;
    private long ID;
    private String ProOMaterialUnit;
    private String MarketOrderRow;
    private String MaterialCode;

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

    public String getMaterialUnit() {
        return MaterialUnit;
    }

    public void setMaterialUnit(String MaterialUnit) {
        this.MaterialUnit = MaterialUnit;
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
}
