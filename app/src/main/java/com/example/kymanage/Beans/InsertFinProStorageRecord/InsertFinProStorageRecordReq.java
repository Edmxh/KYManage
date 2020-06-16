package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * {
 * "BLDAT":"2020-01-02",
 * "BUDAT":"2020-01-02",
 * "MATNR":"LJ4510000719-TZ4020100000",
 * "WERKS":"2090",
 * "LGORT":"2906",
 * "AUFNR":"10044960",
 * "MENGE":1,
 * "KDAUF":"30000160",
 * "KDPOS":"000010",
 * "MEINS":"EA",
 * "MCODE":"M002012",
 * "MaterialDesc":"测试20200601",
 * "MaterialType":"非专有",
 * "Handler":"kzheng",
 * "data":[{
 * 	"Factory":"",
 * 	"MarketOrderNO":"",
 * 	"MarketOrderRow":"",
 * 	"ProductOrderNO":"",
 * 	"ProductOrderDesc":"",
 * 	"ProOMaterialNO":"",
 * 	"ProOMaterialDesc":"",
 * 	"ProOMaterialUnit":"",
 * 	"DemandQty":"",
 * 	"AllocatedQty":"",
 * 	"ProductOrderReservedNO":"",
 * 	"ProductOrderReservedRowNO":""
 * }]
 *        }
 */
public class InsertFinProStorageRecordReq {
    private String BLDAT;
    private String BUDAT;
    private String MATNR;
    private String WERKS;
    private String LGORT;
    private String AUFNR;
    private float MENGE;
    private String KDAUF;
    private String KDPOS;
    private String MEINS;
    private String MCODE;
    private String MaterialDesc;
    private String MaterialType;
    private String Handler;
    private List<InsertFinProStorageRecordReqBean> data;

    public InsertFinProStorageRecordReq() {
    }

    public InsertFinProStorageRecordReq(String BLDAT, String BUDAT, String MATNR, String WERKS, String LGORT, String AUFNR, float MENGE, String KDAUF, String KDPOS, String MEINS, String MCODE, String materialDesc, String materialType, String handler, List<InsertFinProStorageRecordReqBean> data) {
        this.BLDAT = BLDAT;
        this.BUDAT = BUDAT;
        this.MATNR = MATNR;
        this.WERKS = WERKS;
        this.LGORT = LGORT;
        this.AUFNR = AUFNR;
        this.MENGE = MENGE;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.MEINS = MEINS;
        this.MCODE = MCODE;
        MaterialDesc = materialDesc;
        MaterialType = materialType;
        Handler = handler;
        this.data = data;
    }
    @JSONField(name = "BLDAT")
    public String getBLDAT() {
        return BLDAT;
    }
    @JSONField(name = "BLDAT")
    public void setBLDAT(String BLDAT) {
        this.BLDAT = BLDAT;
    }
    @JSONField(name = "BUDAT")
    public String getBUDAT() {
        return BUDAT;
    }
    @JSONField(name = "BUDAT")
    public void setBUDAT(String BUDAT) {
        this.BUDAT = BUDAT;
    }
    @JSONField(name = "MATNR")
    public String getMATNR() {
        return MATNR;
    }
    @JSONField(name = "MATNR")
    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
    @JSONField(name = "WERKS")
    public String getWERKS() {
        return WERKS;
    }
    @JSONField(name = "WERKS")
    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }
    @JSONField(name = "LGORT")
    public String getLGORT() {
        return LGORT;
    }
    @JSONField(name = "LGORT")
    public void setLGORT(String LGORT) {
        this.LGORT = LGORT;
    }
    @JSONField(name = "AUFNR")
    public String getAUFNR() {
        return AUFNR;
    }
    @JSONField(name = "AUFNR")
    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
    }
    @JSONField(name = "MENGE")
    public float getMENGE() {
        return MENGE;
    }
    @JSONField(name = "MENGE")
    public void setMENGE(float MENGE) {
        this.MENGE = MENGE;
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
    @JSONField(name = "MEINS")
    public String getMEINS() {
        return MEINS;
    }
    @JSONField(name = "MEINS")
    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }
    @JSONField(name = "MCODE")
    public String getMCODE() {
        return MCODE;
    }
    @JSONField(name = "MCODE")
    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }
    @JSONField(name = "MaterialDesc")
    public String getMaterialDesc() {
        return MaterialDesc;
    }
    @JSONField(name = "MaterialDesc")
    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }
    @JSONField(name = "MaterialType")
    public String getMaterialType() {
        return MaterialType;
    }
    @JSONField(name = "MaterialType")
    public void setMaterialType(String materialType) {
        MaterialType = materialType;
    }
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String handler) {
        Handler = handler;
    }
    @JSONField(name = "data")
    public List<InsertFinProStorageRecordReqBean> getData() {
        return data;
    }
    @JSONField(name = "data")
    public void setData(List<InsertFinProStorageRecordReqBean> data) {
        this.data = data;
    }
}
