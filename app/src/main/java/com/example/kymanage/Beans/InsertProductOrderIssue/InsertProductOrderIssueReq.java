package com.example.kymanage.Beans.InsertProductOrderIssue;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 *    "ordernum": "41000117372",
 *    "rowno": "00010",
 *    "budat": "2020-01-02",
 *    "bldat": "2020-01-02",
 *    "uname": "kzheng",
 *    "hetxt": "hetxt",
 *    "matnr": "20000012",
 *    "mdesc":"测试",
 *    "meins": "EA",
 *    "werks": "2010",
 *    "aufnr": "10048072",
 *    "rsnum": "0000095018",
 *    "rspos": "0004",
 *    "bktxt": "TSRFC",
 *    "kdauf": "",
 *    "kdpos": "000000",
 *    "batch": "批次1",
 *     "qty": 120,
 *     "sertb": "序列号",
 *    "lgort": "2100",
 *    "menge": "1",
 *
 * }
 */
public class InsertProductOrderIssueReq {
    private String ordernum;
    private String rowno;
    private String budat;
    private String bldat;
    private String uname;
    private String hetxt;
    private String matnr;
    private String mdesc;
    private String meins;
    private String werks;
    private String aufnr;
    private String rsnum;
    private String rspos;
    private String bktxt;
    private String kdauf;
    private String kdpos;
    private String batch;
    private float qty;
    private String sertb;
    private String lgort;
    private String menge;
    private String lastqty;

    private String ProductOrderDesc;
    private String ProOMaterialNO;
    private String ProOMaterialDesc;
    private String ProOMaterialUnit;


    private String ProcessNo;
    private String ProcessText;

    public InsertProductOrderIssueReq() {
    }

    public InsertProductOrderIssueReq(String ordernum, String rowno, String budat, String bldat, String uname, String hetxt, String matnr, String mdesc, String meins, String werks, String aufnr, String rsnum, String rspos, String bktxt, String kdauf, String kdpos, String batch, float qty, String sertb, String lgort, String menge, String lastqty, String productOrderDesc, String proOMaterialNO, String proOMaterialDesc, String proOMaterialUnit, String processNo, String processText) {
        this.ordernum = ordernum;
        this.rowno = rowno;
        this.budat = budat;
        this.bldat = bldat;
        this.uname = uname;
        this.hetxt = hetxt;
        this.matnr = matnr;
        this.mdesc = mdesc;
        this.meins = meins;
        this.werks = werks;
        this.aufnr = aufnr;
        this.rsnum = rsnum;
        this.rspos = rspos;
        this.bktxt = bktxt;
        this.kdauf = kdauf;
        this.kdpos = kdpos;
        this.batch = batch;
        this.qty = qty;
        this.sertb = sertb;
        this.lgort = lgort;
        this.menge = menge;
        this.lastqty = lastqty;
        ProductOrderDesc = productOrderDesc;
        ProOMaterialNO = proOMaterialNO;
        ProOMaterialDesc = proOMaterialDesc;
        ProOMaterialUnit = proOMaterialUnit;
        ProcessNo = processNo;
        ProcessText = processText;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getRowno() {
        return rowno;
    }

    public void setRowno(String rowno) {
        this.rowno = rowno;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHetxt() {
        return hetxt;
    }

    public void setHetxt(String hetxt) {
        this.hetxt = hetxt;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getRsnum() {
        return rsnum;
    }

    public void setRsnum(String rsnum) {
        this.rsnum = rsnum;
    }

    public String getRspos() {
        return rspos;
    }

    public void setRspos(String rspos) {
        this.rspos = rspos;
    }

    public String getBktxt() {
        return bktxt;
    }

    public void setBktxt(String bktxt) {
        this.bktxt = bktxt;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public String getSertb() {
        return sertb;
    }

    public void setSertb(String sertb) {
        this.sertb = sertb;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public String getLastqty() {
        return lastqty;
    }

    public void setLastqty(String lastqty) {
        this.lastqty = lastqty;
    }

    @JSONField(name="ProductOrderDesc")
    public String getProductOrderDesc() {
        return ProductOrderDesc;
    }
    @JSONField(name="ProductOrderDesc")
    public void setProductOrderDesc(String productOrderDesc) {
        ProductOrderDesc = productOrderDesc;
    }
    @JSONField(name="ProOMaterialNO")
    public String getProOMaterialNO() {
        return ProOMaterialNO;
    }
    @JSONField(name="ProOMaterialNO")
    public void setProOMaterialNO(String proOMaterialNO) {
        ProOMaterialNO = proOMaterialNO;
    }
    @JSONField(name="ProOMaterialDesc")
    public String getProOMaterialDesc() {
        return ProOMaterialDesc;
    }
    @JSONField(name="ProOMaterialDesc")
    public void setProOMaterialDesc(String proOMaterialDesc) {
        ProOMaterialDesc = proOMaterialDesc;
    }
    @JSONField(name="proOMaterialUnit")
    public String getProOMaterialUnit() {
        return ProOMaterialUnit;
    }
    @JSONField(name="proOMaterialUnit")
    public void setProOMaterialUnit(String proOMaterialUnit) {
        ProOMaterialUnit = proOMaterialUnit;
    }

    @JSONField(name="ProcessNo")
    public String getProcessNo() {
        return ProcessNo;
    }
    @JSONField(name="ProcessNo")
    public void setProcessNo(String processNo) {
        ProcessNo = processNo;
    }
    @JSONField(name="ProcessText")
    public String getProcessText() {
        return ProcessText;
    }
    @JSONField(name="ProcessText")
    public void setProcessText(String processText) {
        ProcessText = processText;
    }
}
