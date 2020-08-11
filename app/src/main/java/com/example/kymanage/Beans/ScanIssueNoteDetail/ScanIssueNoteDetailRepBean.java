package com.example.kymanage.Beans.ScanIssueNoteDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ScanIssueNoteDetailRepBean {

    /**
     * Status : 待发料
     * IssueQty : 8.0
     * MaterialDesc : 铜端子/OT10-8
     * DemandQty : 8.0
     * Messa : E:对于预留 0000253622 0005, 无移动能记帐
     * ProductOrderNO : 000010119413
     * IssueFactory :
     * IssueStorage :
     * Handler :
     * Unit : EA
     * MaterialCode : DQ7001060006
     * ReverseHandler :
     */

    private String Status;
    private float IssueQty;
    private String MaterialDesc;
    private float DemandQty;
    private String Messa;
    private String ProductOrderNO;
    private String IssueFactory;
    private String IssueStorage;
    private String Handler;
    private String Unit;
    private String MaterialCode;
    private String ReverseHandler;

    public static ScanIssueNoteDetailRepBean objectFromData(String str) {

        return new Gson().fromJson(str, ScanIssueNoteDetailRepBean.class);
    }

    public static ScanIssueNoteDetailRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ScanIssueNoteDetailRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ScanIssueNoteDetailRepBean> arrayScanIssueNoteDetailRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ScanIssueNoteDetailRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ScanIssueNoteDetailRepBean> arrayScanIssueNoteDetailRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ScanIssueNoteDetailRepBean>>() {
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

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }

    public String getMessa() {
        return Messa;
    }

    public void setMessa(String Messa) {
        this.Messa = Messa;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }

    public String getIssueFactory() {
        return IssueFactory;
    }

    public void setIssueFactory(String IssueFactory) {
        this.IssueFactory = IssueFactory;
    }

    public String getIssueStorage() {
        return IssueStorage;
    }

    public void setIssueStorage(String IssueStorage) {
        this.IssueStorage = IssueStorage;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
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

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
    }
}
