package com.example.kymanage.Beans.GetIssueDetailRecord;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetIssueDetailRecordRep {

    /**
     * MaterialDesc : 支架加工完成半成品
     * IssueQty : 2.0
     * Area : PPPAA
     * Storage : 2912
     * DemandQty : 1000
     * ProductOrderNO : 000010048078
     * LastQty : 0.0
     * IssueId : 365.0
     * ID : 25.0
     * Unit : EA
     * MaterialCode : LJ2015000594-A01
     * Status: ""
     */

    private String MaterialDesc;
    private float IssueQty;
    private String Area;
    private String Storage;
    private float DemandQty;
    private String ProductOrderNO;
    private float LastQty;
    private long IssueId;
    private long ID;
    private String Unit;
    private String MaterialCode;
    private String Status;

    public static GetIssueDetailRecordRep objectFromData(String str) {

        return new Gson().fromJson(str, GetIssueDetailRecordRep.class);
    }

    public static GetIssueDetailRecordRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetIssueDetailRecordRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetIssueDetailRecordRep> arrayGetIssueRecordRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetIssueDetailRecordRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetIssueDetailRecordRep> arrayGetIssueRecordRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetIssueDetailRecordRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public float getIssueQty() {
        return IssueQty;
    }

    public void setIssueQty(float IssueQty) {
        this.IssueQty = IssueQty;
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

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }

    public float getLastQty() {
        return LastQty;
    }

    public void setLastQty(float LastQty) {
        this.LastQty = LastQty;
    }

    public long getIssueId() {
        return IssueId;
    }

    public void setIssueId(long IssueId) {
        this.IssueId = IssueId;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
