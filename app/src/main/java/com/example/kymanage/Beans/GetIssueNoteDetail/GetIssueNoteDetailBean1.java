package com.example.kymanage.Beans.GetIssueNoteDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * {
 *                     "MaterialDesc": 0.0,
 *                     "IssueQty": 1.0,
 *                     "DemandQty": 0.0,
 *                     "LastQty": 0.0,
 *                     "MaterialCode": "20000012",
 *                     "Area":""
 *                 }
 */
public class GetIssueNoteDetailBean1 {

    /**
     * Status : 已发料
     * ProcessNo : 000000
     * IssueQty : 1.0
     * DemandQty : 120.0
     * ProcessText : 精密
     * Lgpbe : 2
     * LastQty : 5.0
     * Unit : EA
     * MaterialDesc : 测试123
     * Area : J01
     * Storage : 2300
     * UpdateTime : 1595241104814
     * MaterialCode : SJ1520000187
     */

    private String Status;
    private String ProcessNo;
    private float IssueQty;
    private float DemandQty;
    private String ProcessText;
    private String Lgpbe;
    private float LastQty;
    private String Unit;
    private String MaterialDesc;
    private String IssueFactory;
    private String Area;
    private String Storage;
    private String UpdateTime;
    private String MaterialCode;

    public static GetIssueNoteDetailBean1 objectFromData(String str) {

        return new Gson().fromJson(str, GetIssueNoteDetailBean1.class);
    }

    public static GetIssueNoteDetailBean1 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetIssueNoteDetailBean1.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetIssueNoteDetailBean1> arrayGetIssueNoteDetailBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetIssueNoteDetailBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetIssueNoteDetailBean1> arrayGetIssueNoteDetailBean1FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetIssueNoteDetailBean1>>() {
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

    public String getProcessText() {
        return ProcessText;
    }

    public void setProcessText(String ProcessText) {
        this.ProcessText = ProcessText;
    }

    public String getLgpbe() {
        return Lgpbe;
    }

    public void setLgpbe(String Lgpbe) {
        this.Lgpbe = Lgpbe;
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

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getIssueFactory() {
        return IssueFactory;
    }

    public void setIssueFactory(String issueFactory) {
        IssueFactory = issueFactory;
    }
}
