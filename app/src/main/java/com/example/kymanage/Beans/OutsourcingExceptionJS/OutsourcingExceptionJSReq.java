package com.example.kymanage.Beans.OutsourcingExceptionJS;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OutsourcingExceptionJSReq {

    /**
     * postingDate : 2020-9-14
     * documentDate : 2020-9-14
     * EBELN : 4800003186
     * EBELP : 00430
     * KINDS : 20
     * KDAUF : 10000425
     * KDPOS : 16
     * MATNR : LJ5530031545-A01
     * MAKTX : 支座加工完成半成品
     * MEINS : EA
     * MENGE : 36
     * WERKS : 2040
     * USER : pliu
     * reason : 0001
     * recNum : 1
     * inStorage : 1
     * materialType : 独立
     */

    private String postingDate;
    private String documentDate;
    private String EBELN;
    private String EBELP;
    private String KINDS;
    private String KDAUF;
    private String KDPOS;
    private String MATNR;
    private String MAKTX;
    private String MEINS;
    private float MENGE;
    private String WERKS;
    private String USER;
    private String reason;
    private float recNum;
    private float inStorage;
    private String materialType;


    public OutsourcingExceptionJSReq(String postingDate, String documentDate, String EBELN, String EBELP, String KINDS, String KDAUF, String KDPOS, String MATNR, String MAKTX, String MEINS, float MENGE, String WERKS, String USER, String reason, float recNum, float inStorage, String materialType) {
        this.postingDate = postingDate;
        this.documentDate = documentDate;
        this.EBELN = EBELN;
        this.EBELP = EBELP;
        this.KINDS = KINDS;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.MATNR = MATNR;
        this.MAKTX = MAKTX;
        this.MEINS = MEINS;
        this.MENGE = MENGE;
        this.WERKS = WERKS;
        this.USER = USER;
        this.reason = reason;
        this.recNum = recNum;
        this.inStorage = inStorage;
        this.materialType = materialType;
    }

    public static OutsourcingExceptionJSReq objectFromData(String str) {

        return new Gson().fromJson(str, OutsourcingExceptionJSReq.class);
    }

    public static OutsourcingExceptionJSReq objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), OutsourcingExceptionJSReq.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<OutsourcingExceptionJSReq> arrayOutsourcingExceptionJSReqFromData(String str) {

        Type listType = new TypeToken<ArrayList<OutsourcingExceptionJSReq>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<OutsourcingExceptionJSReq> arrayOutsourcingExceptionJSReqFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<OutsourcingExceptionJSReq>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    @JSONField(name = "EBELN")
    public String getEBELN() {
        return EBELN;
    }
    @JSONField(name = "EBELN")
    public void setEBELN(String EBELN) {
        this.EBELN = EBELN;
    }
    @JSONField(name = "EBELP")
    public String getEBELP() {
        return EBELP;
    }
    @JSONField(name = "EBELP")
    public void setEBELP(String EBELP) {
        this.EBELP = EBELP;
    }
    @JSONField(name = "KINDS")
    public String getKINDS() {
        return KINDS;
    }
    @JSONField(name = "KINDS")
    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
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
    @JSONField(name = "MATNR")
    public String getMATNR() {
        return MATNR;
    }
    @JSONField(name = "MATNR")
    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
    @JSONField(name = "MAKTX")
    public String getMAKTX() {
        return MAKTX;
    }
    @JSONField(name = "MAKTX")
    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }
    @JSONField(name = "MEINS")
    public String getMEINS() {
        return MEINS;
    }
    @JSONField(name = "MEINS")
    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }
    @JSONField(name = "MENGE")
    public float getMENGE() {
        return MENGE;
    }
    @JSONField(name = "MENGE")
    public void setMENGE(float MENGE) {
        this.MENGE = MENGE;
    }
    @JSONField(name = "WERKS")
    public String getWERKS() {
        return WERKS;
    }
    @JSONField(name = "WERKS")
    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }
    @JSONField(name = "USER")
    public String getUSER() {
        return USER;
    }
    @JSONField(name = "USER")
    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public float getRecNum() {
        return recNum;
    }

    public void setRecNum(float recNum) {
        this.recNum = recNum;
    }

    public float getInStorage() {
        return inStorage;
    }

    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}
