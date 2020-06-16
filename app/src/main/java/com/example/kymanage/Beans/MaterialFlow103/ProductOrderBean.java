package com.example.kymanage.Beans.MaterialFlow103;

import android.renderscript.Sampler;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * {
 *           "orderNo": "pliu0033",
 *           "issueNum": 3,
 *           "KDAUF": "",
 *           "KDPOS": "",
 *           "RSNUM": "",
 *           "RSPOS": "",
 *           "MATNR": "",
 *           "MAKTX": "",
 *           "BDMNG": 1,
 *
 *           "RSART": 1,
 *           "ZSERNR": "",
 *           "proOrderDesc": "",
 *           "proOrderMaterialDesc": "",
 *           "proOrderMaterialCode": "",
 *           "proOrderMaterialUnit": ""
 *         }
 */
public class ProductOrderBean implements Serializable {
    private String orderNo;
    private float issueNum;
    @JSONField(name="KDAUF")
    private String KDAUF;
    private String KDPOS;
    private String RSNUM;
    private String RSPOS;
    private String MATNR;
    private String MAKTX;
    private float BDMNG;

    private String RSART;
    private String ZSERNR;
    private String proOrderDesc;
    private String proOrderMaterialDesc;
    private String proOrderMaterialCode;
    private String proOrderMaterialUnit;

    public ProductOrderBean() {
    }

    public ProductOrderBean(String orderNo, float issueNum, String KDAUF, String KDPOS, String RSNUM, String RSPOS, String MATNR, String MAKTX, float BDMNG, String RSART, String ZSERNR, String proOrderDesc, String proOrderMaterialDesc, String proOrderMaterialCode, String proOrderMaterialUnit) {
        this.orderNo = orderNo;
        this.issueNum = issueNum;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.RSNUM = RSNUM;
        this.RSPOS = RSPOS;
        this.MATNR = MATNR;
        this.MAKTX = MAKTX;
        this.BDMNG = BDMNG;
        this.RSART = RSART;
        this.ZSERNR = ZSERNR;
        this.proOrderDesc = proOrderDesc;
        this.proOrderMaterialDesc = proOrderMaterialDesc;
        this.proOrderMaterialCode = proOrderMaterialCode;
        this.proOrderMaterialUnit = proOrderMaterialUnit;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public float getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(float issueNum) {
        this.issueNum = issueNum;
    }
    @JSONField(name="KDAUF")
    public String getKDAUF() {
        return KDAUF;
    }
    @JSONField(name="KDAUF")
    public void setKDAUF(String KDAUF) {
        this.KDAUF = KDAUF;
    }
    @JSONField(name="KDPOS")
    public String getKDPOS() {
        return KDPOS;
    }
    @JSONField(name="KDPOS")
    public void setKDPOS(String KDPOS) {
        this.KDPOS = KDPOS;
    }
    @JSONField(name="RSNUM")
    public String getRSNUM() {
        return RSNUM;
    }
    @JSONField(name="RSNUM")
    public void setRSNUM(String RSNUM) {
        this.RSNUM = RSNUM;
    }
    @JSONField(name="RSPOS")
    public String getRSPOS() {
        return RSPOS;
    }
    @JSONField(name="RSPOS")
    public void setRSPOS(String RSPOS) {
        this.RSPOS = RSPOS;
    }
    @JSONField(name="MATNR")
    public String getMATNR() {
        return MATNR;
    }
    @JSONField(name="MATNR")
    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
    @JSONField(name="MAKTX")
    public String getMAKTX() {
        return MAKTX;
    }
    @JSONField(name="MAKTX")
    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }
    @JSONField(name="BDMNG")
    public float getBDMNG() {
        return BDMNG;
    }
    @JSONField(name="BDMNG")
    public void setBDMNG(float BDMNG) {
        this.BDMNG = BDMNG;
    }

    @JSONField(name="RSART")
    public String getRSART() {
        return RSART;
    }
    @JSONField(name="RSART")
    public void setRSART(String RSART) {
        this.RSART = RSART;
    }
    @JSONField(name="ZSERNR")
    public String getZSERNR() {
        return ZSERNR;
    }
    @JSONField(name="ZSERNR")
    public void setZSERNR(String ZSERNR) {
        this.ZSERNR = ZSERNR;
    }

    public String getProOrderDesc() {
        return proOrderDesc;
    }

    public void setProOrderDesc(String proOrderDesc) {
        this.proOrderDesc = proOrderDesc;
    }

    public String getProOrderMaterialDesc() {
        return proOrderMaterialDesc;
    }

    public void setProOrderMaterialDesc(String proOrderMaterialDesc) {
        this.proOrderMaterialDesc = proOrderMaterialDesc;
    }

    public String getProOrderMaterialCode() {
        return proOrderMaterialCode;
    }

    public void setProOrderMaterialCode(String proOrderMaterialCode) {
        this.proOrderMaterialCode = proOrderMaterialCode;
    }

    public String getProOrderMaterialUnit() {
        return proOrderMaterialUnit;
    }

    public void setProOrderMaterialUnit(String proOrderMaterialUnit) {
        this.proOrderMaterialUnit = proOrderMaterialUnit;
    }
}
