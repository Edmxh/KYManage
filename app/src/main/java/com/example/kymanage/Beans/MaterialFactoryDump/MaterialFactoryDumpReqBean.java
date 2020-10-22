package com.example.kymanage.Beans.MaterialFactoryDump;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MaterialFactoryDumpReqBean {

    /**
     * budat : 2020-06-01
     * bldat : 2020-06-01
     * uname : zhengk
     * FID : 434
     * matnr : LJ7015001194
     * maktx : 测试物料LJ7015001194
     * materialtype : 专有物料
     * meins : EA
     * aufnr : 10048077
     * kdauf : 1000149731
     * kdpos : 00010
     * qty : 1
     * bktxt : 测试转储
     */

    private String budat;
    private String bldat;
    private long FID;
    private String matnr;
    private String maktx;
    private String materialtype;
    private String meins;
    private String aufnr;
    private String kdauf;
    private String kdpos;
    private float qty;
    private String bktxt;


    private String labelnum;
    private String warning;

    public MaterialFactoryDumpReqBean() {
    }

    public MaterialFactoryDumpReqBean(String budat, String bldat, long FID, String matnr, String maktx, String materialtype, String meins, String aufnr, String kdauf, String kdpos, float qty, String bktxt, String labelnum, String warning) {
        this.budat = budat;
        this.bldat = bldat;
        this.FID = FID;
        this.matnr = matnr;
        this.maktx = maktx;
        this.materialtype = materialtype;
        this.meins = meins;
        this.aufnr = aufnr;
        this.kdauf = kdauf;
        this.kdpos = kdpos;
        this.qty = qty;
        this.bktxt = bktxt;
        this.labelnum = labelnum;
        this.warning = warning;
    }

    public String getBudat() {
        return budat;
    }

    public void setBudat(String budat) {
        this.budat = budat;
    }

    public String getBldat() {
        return bldat;
    }

    public void setBldat(String bldat) {
        this.bldat = bldat;
    }
    @JSONField(name = "FID")
    public long getFID() {
        return FID;
    }
    @JSONField(name = "FID")
    public void setFID(long FID) {
        this.FID = FID;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMaktx() {
        return maktx;
    }

    public void setMaktx(String maktx) {
        this.maktx = maktx;
    }

    public String getMaterialtype() {
        return materialtype;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getKdauf() {
        return kdauf;
    }

    public void setKdauf(String kdauf) {
        this.kdauf = kdauf;
    }

    public String getKdpos() {
        return kdpos;
    }

    public void setKdpos(String kdpos) {
        this.kdpos = kdpos;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public String getBktxt() {
        return bktxt;
    }

    public void setBktxt(String bktxt) {
        this.bktxt = bktxt;
    }

    public String getLabelnum() {
        return labelnum;
    }

    public void setLabelnum(String labelnum) {
        this.labelnum = labelnum;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
}
