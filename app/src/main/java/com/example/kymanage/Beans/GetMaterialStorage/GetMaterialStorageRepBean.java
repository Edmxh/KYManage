package com.example.kymanage.Beans.GetMaterialStorage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetMaterialStorageRepBean {

    /**
     * Status : 261
     * MaterialDesc : 大磁环|H48X30X15
     * Area : A11
     * IssueQty : 2.0
     * SMaterialCode : DQ1010001126+M3
     * DemandQty : 120
     * ProductOrderNO : 000010029536
     * IssueStorage : 2100
     * LastQty : 0
     * MaterialCode : DQ4402000001
     * SMaterialDesc : 外部位置1
     */

    private String Status;
    private String MaterialDesc;
    private String Area;
    private float IssueQty;
    private String SMaterialCode;
    private float DemandQty;
    private String ProductOrderNO;
    private String IssueStorage;
    private float LastQty;
    private String MaterialCode;
    private String SMaterialDesc;

    public static GetMaterialStorageRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetMaterialStorageRepBean.class);
    }

    public static GetMaterialStorageRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetMaterialStorageRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetMaterialStorageRepBean> arrayGetMaterialStorageRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetMaterialStorageRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetMaterialStorageRepBean> arrayGetMaterialStorageRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetMaterialStorageRepBean>>() {
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

    public float getIssueQty() {
        return IssueQty;
    }

    public void setIssueQty(float IssueQty) {
        this.IssueQty = IssueQty;
    }

    public String getSMaterialCode() {
        return SMaterialCode;
    }

    public void setSMaterialCode(String SMaterialCode) {
        this.SMaterialCode = SMaterialCode;
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

    public String getIssueStorage() {
        return IssueStorage;
    }

    public void setIssueStorage(String IssueStorage) {
        this.IssueStorage = IssueStorage;
    }

    public float getLastQty() {
        return LastQty;
    }

    public void setLastQty(float LastQty) {
        this.LastQty = LastQty;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getSMaterialDesc() {
        return SMaterialDesc;
    }

    public void setSMaterialDesc(String SMaterialDesc) {
        this.SMaterialDesc = SMaterialDesc;
    }
}
