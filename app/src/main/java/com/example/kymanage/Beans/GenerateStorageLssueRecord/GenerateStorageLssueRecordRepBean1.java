package com.example.kymanage.Beans.GenerateStorageLssueRecord;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenerateStorageLssueRecordRepBean1 {

    /**
     * Status : 已冲销
     * ProcessNo : 000000
     * MaterialDesc : 外部轴连接电缆单元/TSMWU934LZ
     * IssueQty : 2
     * Area : C09
     * Storage : 2100
     * DemandQty : 2
     * ProcessText : 机械装配
     * LastQty : 0
     * Unit : EA
     * MaterialCode : CT9015000159
     */

    private String Status;
    private String ProcessNo;
    private String MaterialDesc;
    private float IssueQty;
    private String Area;
    private String Storage;
    private float DemandQty;
    private String ProcessText;
    private float LastQty;
    private String Unit;
    private String MaterialCode;

    public static GenerateStorageLssueRecordRepBean1 objectFromData(String str) {

        return new Gson().fromJson(str, GenerateStorageLssueRecordRepBean1.class);
    }

    public static GenerateStorageLssueRecordRepBean1 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GenerateStorageLssueRecordRepBean1.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GenerateStorageLssueRecordRepBean1> arrayGenerateStorageLssueRecordRepBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<GenerateStorageLssueRecordRepBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GenerateStorageLssueRecordRepBean1> arrayGenerateStorageLssueRecordRepBean1FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GenerateStorageLssueRecordRepBean1>>() {
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

    public String getProcessNo() {
        return ProcessNo;
    }

    public void setProcessNo(String ProcessNo) {
        this.ProcessNo = ProcessNo;
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

    public String getProcessText() {
        return ProcessText;
    }

    public void setProcessText(String ProcessText) {
        this.ProcessText = ProcessText;
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

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
}
