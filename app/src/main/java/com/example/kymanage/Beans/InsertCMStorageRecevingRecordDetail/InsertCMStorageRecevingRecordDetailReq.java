package com.example.kymanage.Beans.InsertCMStorageRecevingRecordDetail;

/**
 * {
 * "data": [{
 * 	"gzrq": "2020-3-30",
 * 	"ddate": "2020-3-30",
 * 	"user": "ymk",
 * 	"matnr": "LJ22345",
 * 	" kdauf ": "2142144",
 * 	" kdpos ": "12",
 * 	"gzsl": 11,
 * "werks":"2010",
 * 	"lgort": "123214",
 * 	"charg": "",
 * "aufnr":"234235"
 * }]
 * }
 */
public class InsertCMStorageRecevingRecordDetailReq {
    private String gzrq;
    private String ddate;
    private String user;
    private String matnr;
    private String kdauf;
    private String kdpos;
    private float gzsl;
    private String werks;
    private String lgort;
    private String charg;
    private String aufnr;

    public InsertCMStorageRecevingRecordDetailReq() {
    }

    public InsertCMStorageRecevingRecordDetailReq(String gzrq, String ddate, String user, String matnr, String kdauf, String kdpos, float gzsl, String werks, String lgort, String charg, String aufnr) {
        this.gzrq = gzrq;
        this.ddate = ddate;
        this.user = user;
        this.matnr = matnr;
        this.kdauf = kdauf;
        this.kdpos = kdpos;
        this.gzsl = gzsl;
        this.werks = werks;
        this.lgort = lgort;
        this.charg = charg;
        this.aufnr = aufnr;
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

    public String getCharg() {
        return charg;
    }

    public void setCharg(String charg) {
        this.charg = charg;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }
}
