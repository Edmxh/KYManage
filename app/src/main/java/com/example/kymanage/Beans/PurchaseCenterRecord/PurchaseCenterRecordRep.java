package com.example.kymanage.Beans.PurchaseCenterRecord;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PurchaseCenterRecordRep {

    /**
     * purchaseOrderNO : 4100029758
     * materialDesc : 深沟球轴承/GB/T276-6018
     * materialType : 专有
     * orderNum : 4100029758
     * purchaseOrderRow : 00050
     * materialCode : BZ1510100070
     * updateTime : 2020-07-08 14:29:27
     * ID : 225.0
     * row : 00050
     * receiveNum : 2.0
     * describe : 104预入库冲销
     * AdvanceStorageId : 782.0
     */

    private String purchaseOrderNO;
    private String materialDesc;
    private String materialType;
    private String orderNum;
    private String purchaseOrderRow;
    private String materialCode;
    private String updateTime;
    private long ID;
    private String row;
    private float receiveNum;
    private String describe;
    private long AdvanceStorageId;

    private String ReverseHandler;
    private String handler;

    private float moreQty;

    public static PurchaseCenterRecordRep objectFromData(String str) {

        return new Gson().fromJson(str, PurchaseCenterRecordRep.class);
    }

    public static PurchaseCenterRecordRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), PurchaseCenterRecordRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<PurchaseCenterRecordRep> arrayPurchaseCenterRecordRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<PurchaseCenterRecordRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<PurchaseCenterRecordRep> arrayPurchaseCenterRecordRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<PurchaseCenterRecordRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPurchaseOrderNO() {
        return purchaseOrderNO;
    }

    public void setPurchaseOrderNO(String purchaseOrderNO) {
        this.purchaseOrderNO = purchaseOrderNO;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPurchaseOrderRow() {
        return purchaseOrderRow;
    }

    public void setPurchaseOrderRow(String purchaseOrderRow) {
        this.purchaseOrderRow = purchaseOrderRow;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public float getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(float receiveNum) {
        this.receiveNum = receiveNum;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long AdvanceStorageId) {
        this.AdvanceStorageId = AdvanceStorageId;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }

    public float getMoreQty() {
        return moreQty;
    }

    public void setMoreQty(float moreQty) {
        this.moreQty = moreQty;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
