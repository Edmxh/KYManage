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
     * MarketOrderNO : 10000208
     * DemandQty : 1000.0
     * MCode : M002011
     * ProOMaterialNO : ZJ6025011857
     * Factory : 2010
     * DeliveryDate : 2020-06-14 00:00:00
     * ProductOrderDesc : 测试订单001
     * MaterialDesc : 测试20200601
     * ProOMaterialDesc : 测试001
     * SendStorage : 2906
     * ProductOrderNO : 10000010
     * MaterialUnit : EA
     * ID : 434.0
     * ProOMaterialUnit : EA
     * MarketOrderRow : 26
     * SendFactory : 2090
     * FType : 机加
     * UBNO : 22
     * AllocatedQty : 12.0
     * Area : A11
     * UBDemandQty : 33.0
     * Storage : 2100
     * BUProjectNO : 22
     * NoteType : 未知类型
     * MaterialCode : LJ6025011857
     * clientShortName : 沈阳海纳
     * clientNO : 0000400013
     */

    private String MarketOrderNO;
    private float DemandQty;
    private String MCode;
    private String ProOMaterialNO;
    private String Factory;
    private String DeliveryDate;
    private String ProductOrderDesc;
    private String MaterialDesc;
    private String ProOMaterialDesc;
    private String SendStorage;
    private String ProductOrderNO;
    private String MaterialUnit;
    private long ID;
    private String ProOMaterialUnit;
    private String MarketOrderRow;
    private String SendFactory;
    private String FType;
    private String UBNO;
    private float AllocatedQty;
    private String Area;
    private float UBDemandQty;
    private String Storage;
    private String BUProjectNO;
    private String NoteType;
    private String MaterialCode;
    private String clientShortName;
    private String clientNO;

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

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public String getProductOrderDesc() {
        return ProductOrderDesc;
    }

    public void setProductOrderDesc(String ProductOrderDesc) {
        this.ProductOrderDesc = ProductOrderDesc;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
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

    public String getUBNO() {
        return UBNO;
    }

    public void setUBNO(String UBNO) {
        this.UBNO = UBNO;
    }

    public float getAllocatedQty() {
        return AllocatedQty;
    }

    public void setAllocatedQty(float AllocatedQty) {
        this.AllocatedQty = AllocatedQty;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public float getUBDemandQty() {
        return UBDemandQty;
    }

    public void setUBDemandQty(float UBDemandQty) {
        this.UBDemandQty = UBDemandQty;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String Storage) {
        this.Storage = Storage;
    }

    public String getBUProjectNO() {
        return BUProjectNO;
    }

    public void setBUProjectNO(String BUProjectNO) {
        this.BUProjectNO = BUProjectNO;
    }

    public String getNoteType() {
        return NoteType;
    }

    public void setNoteType(String NoteType) {
        this.NoteType = NoteType;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getClientName() {
        return clientShortName;
    }

    public void setClientName(String clientName) {
        this.clientShortName = clientName;
    }

    public String getClientNo() {
        return clientNO;
    }

    public void setClientNo(String clientNo) {
        this.clientNO = clientNo;
    }
}
