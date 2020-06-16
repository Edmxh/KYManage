package com.example.kymanage.Beans.UpdatefinishedStorage;

import org.json.JSONObject;

/**
 * {
 * "data": [{
 * 	"gzrq": "2020-3-29",
 * 	"ddate": "2020-3-30",
 * 	"user": "ymk",
 * 	"matnr": "LJ22345",
 * 	"belnr": "belnr",
 * 	"kdauf":"kdauf",
 * 	"kdpos":"kdpos",
 * 	"buzei": "buzei",
 * 	"ebeln": "ebeln",
 * 	"ebelp": "ebelp",
 * 	"gzsl": "11",
 * 	"werks":"werks",
 * 	"lgort": "lgort",
 * 	"bktxt": "bktxt",
 * 	"lableseries": "lableseries"
 * }]
 * }
 *
 * {
 *  * 	"gzrq": "2020-3-29",
 *  * 	"ddate": "2020-3-30",
 *  * 	"user": "ymk",
 *  * 	"matnr": "LJ22345",
 *  * 	"belnr": "belnr",
 *  * 	"kdauf":"kdauf",
 *  * 	"kdpos":"kdpos",
 *  * 	"buzei": "buzei",
 *  * 	"ebeln": "ebeln",
 *  * 	"ebelp": "ebelp",
 *  * 	"gzsl": "11",
 *  * 	"werks":"werks",
 *  * 	"lgort": "lgort",
 *  * 	"bktxt": "bktxt",
 *  * 	"lableseries": "lableseries",
 *      "ReceiveType": "ReceiveType"
 *  * }
 */
public class UpdatefinishedStorageData {
    
    private String gzrq;//过账日期
    private String ddate;//凭证日期
    private String user;//用户名
    private String matnr;//物料号（物料编码）
    private String belnr;//参考凭证号
    private String kdauf;//销售订单号
    private String kdpos;//销售订单行
    private String buzei;//参考凭证行
    private String ebeln;//采购订单号
    private String ebelp;//采购订单行
    private float gzsl;//过账数量
    private String werks;//需求工厂
    private String lgort;//需求仓库
    private String bktxt;//项目文本
    private String lableseries;//标签序列号
    private String ReceiveType;//标签序列号

    public UpdatefinishedStorageData(String gzrq, String ddate, String user, String matnr, String belnr, String kdauf, String kdpos, String buzei, String ebeln, String ebelp, float gzsl, String werks, String lgort, String bktxt, String lableseries, String receiveType) {
        this.gzrq = gzrq;
        this.ddate = ddate;
        this.user = user;
        this.matnr = matnr;
        this.belnr = belnr;
        this.kdauf = kdauf;
        this.kdpos = kdpos;
        this.buzei = buzei;
        this.ebeln = ebeln;
        this.ebelp = ebelp;
        this.gzsl = gzsl;
        this.werks = werks;
        this.lgort = lgort;
        this.bktxt = bktxt;
        this.lableseries = lableseries;
        ReceiveType = receiveType;
    }

    public UpdatefinishedStorageData() {
    }

    public String getGzrq() {
        return gzrq;
    }

    public void setGzrq(String gzrq) {
        this.gzrq = gzrq;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getBelnr() {
        return belnr;
    }

    public void setBelnr(String belnr) {
        this.belnr = belnr;
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

    public String getBuzei() {
        return buzei;
    }

    public void setBuzei(String buzei) {
        this.buzei = buzei;
    }

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getEbelp() {
        return ebelp;
    }

    public void setEbelp(String ebelp) {
        this.ebelp = ebelp;
    }

    public float getGzsl() {
        return gzsl;
    }

    public void setGzsl(float gzsl) {
        this.gzsl = gzsl;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getBktxt() {
        return bktxt;
    }

    public void setBktxt(String bktxt) {
        this.bktxt = bktxt;
    }

    public String getLableseries() {
        return lableseries;
    }

    public void setLableseries(String lableseries) {
        this.lableseries = lableseries;
    }

    public String getReceiveType() {
        return ReceiveType;
    }

    public void setReceiveType(String receiveType) {
        ReceiveType = receiveType;
    }
}
