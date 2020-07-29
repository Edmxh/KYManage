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
     * Status : 已出库
     * IssueQty : 2.0
     * DemandQty : 2.0
     * Handler : kzheng
     * LastQty : 0.0
     * Unit : EA
     * ReverseHandler :
     * MaterialDesc : O形橡胶密封圈|14×1.9-G-N-GB/T1235
     * Area : C09
     * Storage : 2100
     * UpdateTime : 2020-07-21 22:19:37
     * ProductOrderNO : 000010117401
     * IssueId : 5045.0
     * ID : 0.0
     * MaterialCode : BZ2512000518
     */

    private String Status;
    private float IssueQty;
    private float DemandQty;
    private String Handler;
    private float LastQty;
    private String Unit;
    private String ReverseHandler;
    private String MaterialDesc;
    private String Area;
    private String Storage;
    private String UpdateTime;
    private String ProductOrderNO;
    private long IssueId;
    private long ID;
    private String MaterialCode;

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

    public static List<GetIssueDetailRecordRep> arrayGetIssueDetailRecordRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetIssueDetailRecordRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetIssueDetailRecordRep> arrayGetIssueDetailRecordRepFromData(String str, String key) {

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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public float getIssueQty() {
        return IssueQty;
    }

    public void setIssueQty(float IssueQty) {
        this.IssueQty = IssueQty;
    }

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
    }

    public float getLastQty() {
        return LastQty;
    }

    public void setLastQty(float LastQty) {
        this.LastQty = LastQty;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
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

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
}
