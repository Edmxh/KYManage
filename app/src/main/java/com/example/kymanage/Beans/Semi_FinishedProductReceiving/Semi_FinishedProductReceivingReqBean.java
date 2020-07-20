package com.example.kymanage.Beans.Semi_FinishedProductReceiving;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Semi_FinishedProductReceivingReqBean implements Serializable {

    /**
     * BDMNG : 1000
     * KDAUF : 0010000208
     * KDPOS : 000026
     * MAKTX : 支架加工完成半成品
     * MATNR : LJ2015000594-A01
     * RSART :
     * RSNUM : 0000095028
     * RSPOS : 0001
     * IssueNum : 2
     * AUFNR : 000010048078
     * proOrderDesc :
     * proOrderMaterialCode : LJ2015000594-TZ2010043020
     * proOrderMaterialDesc : 支架
     * proOrderMaterialUnit : EA
     * factory : 2090
     * storage : 2912
     */

    private float BDMNG;
    private String KDAUF;
    private String KDPOS;
    private String MAKTX;
    private String MATNR;
    private String RSART;
    private String RSNUM;
    private String RSPOS;
    private float IssueNum;
    private String AUFNR;
    private String proOrderDesc;
    private String proOrderMaterialCode;
    private String proOrderMaterialDesc;
    private String proOrderMaterialUnit;
    private String factory;
    private String storage;

    private String MCODE;
    private float currentNum;

    public Semi_FinishedProductReceivingReqBean(float BDMNG, String KDAUF, String KDPOS, String MAKTX, String MATNR, String RSART, String RSNUM, String RSPOS, float issueNum, String AUFNR, String proOrderDesc, String proOrderMaterialCode, String proOrderMaterialDesc, String proOrderMaterialUnit, String factory, String storage, String MCODE, float currentNum) {
        this.BDMNG = BDMNG;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.MAKTX = MAKTX;
        this.MATNR = MATNR;
        this.RSART = RSART;
        this.RSNUM = RSNUM;
        this.RSPOS = RSPOS;
        IssueNum = issueNum;
        this.AUFNR = AUFNR;
        this.proOrderDesc = proOrderDesc;
        this.proOrderMaterialCode = proOrderMaterialCode;
        this.proOrderMaterialDesc = proOrderMaterialDesc;
        this.proOrderMaterialUnit = proOrderMaterialUnit;
        this.factory = factory;
        this.storage = storage;
        this.MCODE = MCODE;
        this.currentNum = currentNum;
    }

    public static Semi_FinishedProductReceivingReqBean objectFromData(String str) {

        return new Gson().fromJson(str, Semi_FinishedProductReceivingReqBean.class);
    }

    public static Semi_FinishedProductReceivingReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Semi_FinishedProductReceivingReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Semi_FinishedProductReceivingReqBean> arraySemi_FinishedProductReceivingReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Semi_FinishedProductReceivingReqBean> arraySemi_FinishedProductReceivingReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "BDMNG")
    public float getBDMNG() {
        return BDMNG;
    }
    @JSONField(name = "BDMNG")
    public void setBDMNG(float BDMNG) {
        this.BDMNG = BDMNG;
    }
    @JSONField(name = "KDAUF")
    public String getKDAUF() {
        return KDAUF;
    }
    @JSONField(name = "KDAUF")
    public void setKDAUF(String KDAUF) {
        this.KDAUF = KDAUF;
    }
    @JSONField(name = "KDPOS")
    public String getKDPOS() {
        return KDPOS;
    }
    @JSONField(name = "KDPOS")
    public void setKDPOS(String KDPOS) {
        this.KDPOS = KDPOS;
    }
    @JSONField(name = "MAKTX")
    public String getMAKTX() {
        return MAKTX;
    }
    @JSONField(name = "MAKTX")
    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }
    @JSONField(name = "MATNR")
    public String getMATNR() {
        return MATNR;
    }
    @JSONField(name = "MATNR")
    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
    @JSONField(name = "RSART")
    public String getRSART() {
        return RSART;
    }
    @JSONField(name = "RSART")
    public void setRSART(String RSART) {
        this.RSART = RSART;
    }
    @JSONField(name = "RSNUM")
    public String getRSNUM() {
        return RSNUM;
    }
    @JSONField(name = "RSNUM")
    public void setRSNUM(String RSNUM) {
        this.RSNUM = RSNUM;
    }
    @JSONField(name = "RSPOS")
    public String getRSPOS() {
        return RSPOS;
    }
    @JSONField(name = "RSPOS")
    public void setRSPOS(String RSPOS) {
        this.RSPOS = RSPOS;
    }
    @JSONField(name = "IssueNum")
    public float getIssueNum() {
        return IssueNum;
    }
    @JSONField(name = "IssueNum")
    public void setIssueNum(float IssueNum) {
        this.IssueNum = IssueNum;
    }
    @JSONField(name = "AUFNR")
    public String getAUFNR() {
        return AUFNR;
    }
    @JSONField(name = "AUFNR")
    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
    }
    @JSONField(name = "proOrderDesc")
    public String getProOrderDesc() {
        return proOrderDesc;
    }
    @JSONField(name = "proOrderDesc")
    public void setProOrderDesc(String proOrderDesc) {
        this.proOrderDesc = proOrderDesc;
    }
    @JSONField(name = "proOrderMaterialCode")
    public String getProOrderMaterialCode() {
        return proOrderMaterialCode;
    }
    @JSONField(name = "proOrderMaterialCode")
    public void setProOrderMaterialCode(String proOrderMaterialCode) {
        this.proOrderMaterialCode = proOrderMaterialCode;
    }
    @JSONField(name = "proOrderMaterialDesc")
    public String getProOrderMaterialDesc() {
        return proOrderMaterialDesc;
    }
    @JSONField(name = "proOrderMaterialDesc")
    public void setProOrderMaterialDesc(String proOrderMaterialDesc) {
        this.proOrderMaterialDesc = proOrderMaterialDesc;
    }
    @JSONField(name = "proOrderMaterialUnit")
    public String getProOrderMaterialUnit() {
        return proOrderMaterialUnit;
    }
    @JSONField(name = "proOrderMaterialUnit")
    public void setProOrderMaterialUnit(String proOrderMaterialUnit) {
        this.proOrderMaterialUnit = proOrderMaterialUnit;
    }
    @JSONField(name = "factory")
    public String getFactory() {
        return factory;
    }
    @JSONField(name = "factory")
    public void setFactory(String factory) {
        this.factory = factory;
    }
    @JSONField(name = "storage")
    public String getStorage() {
        return storage;
    }
    @JSONField(name = "storage")
    public void setStorage(String storage) {
        this.storage = storage;
    }

    @JSONField(name = "MCODE")
    public String getMCODE() {
        return MCODE;
    }
    @JSONField(name = "MCODE")
    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }
    @JSONField(name = "currentNum")
    public float getCurrentNum() {
        return currentNum;
    }
    @JSONField(name = "currentNum")
    public void setCurrentNum(float currentNum) {
        this.currentNum = currentNum;
    }
}
