package com.example.kymanage.Beans.GetLableStorageInfoJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetLableStorageInfoJSRepBean {

    /**
     * MAKTX : 围栏加工完成半成品
     * LGPRO : 2912
     * SBDKZ : 1
     * WERKS : 2090
     * materialType : 独立
     * LGFSB : 2912
     * MEINS : EA
     * LABOR :
     * MATNR : LJ6030000220-A01
     */

    private String MAKTX;
    private String LGPRO;
    private String SBDKZ;
    private String WERKS;
    private String materialType;
    private String LGFSB;
    private String MEINS;
    private String LABOR;
    private String MATNR;

    public static GetLableStorageInfoJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetLableStorageInfoJSRepBean.class);
    }

    public static GetLableStorageInfoJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetLableStorageInfoJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetLableStorageInfoJSRepBean> arrayGetLableStorageInfoJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetLableStorageInfoJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetLableStorageInfoJSRepBean> arrayGetLableStorageInfoJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetLableStorageInfoJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }

    public String getLGPRO() {
        return LGPRO;
    }

    public void setLGPRO(String LGPRO) {
        this.LGPRO = LGPRO;
    }

    public String getSBDKZ() {
        return SBDKZ;
    }

    public void setSBDKZ(String SBDKZ) {
        this.SBDKZ = SBDKZ;
    }

    public String getWERKS() {
        return WERKS;
    }

    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getLGFSB() {
        return LGFSB;
    }

    public void setLGFSB(String LGFSB) {
        this.LGFSB = LGFSB;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getLABOR() {
        return LABOR;
    }

    public void setLABOR(String LABOR) {
        this.LABOR = LABOR;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
}
