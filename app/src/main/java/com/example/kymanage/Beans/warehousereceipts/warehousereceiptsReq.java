package com.example.kymanage.Beans.warehousereceipts;

/**
 * {
 * "data":[{
 * 	"gzrq": "2020-3-30",
 * 	"ddate": "2020-3-30",
 * 	"user": "1233",
 * 	"matnr": "LJ34235325",
 * 	"gzsl": 1,
 * 	"bktxt": "bktxt",
 * 	"hetxt": "hetxt",
 * 	"reswk": "reswk",
 * 	"werks": "werks",
 * 	"lgpro": "lgpro",
 * 	"lgort": "lgort",
 * 	"vbeln": "vbeln",
 * 	"vbelp": "vbelp",
 * 	"seria":   "23" ,
 * 	"banfn": "banfn",
 * 	"pitem":  "pitem"
 * }]
 * }
 *
 * {
 *  * 	"gzrq": "2020-3-30",
 *  * 	"ddate": "2020-3-30",
 *  * 	"user": "1233",
 *  * 	"matnr": "LJ34235325",
 *  * 	"gzsl": 1,
 *  * 	"bktxt": "bktxt",
 *  * 	"hetxt": "hetxt",
 *  * 	"reswk": "reswk",
 *  * 	"werks": "werks",
 *  * 	"lgpro": "lgpro",
 *  * 	"lgort": "lgort",
 *  * 	"vbeln": "vbeln",
 *  * 	"vbelp": "vbelp",
 *  * 	"seria":   "23" ,
 *  * 	"banfn": "banfn",
 *  * 	"pitem":  "pitem"
 *  * }
 */
public class warehousereceiptsReq {
    private String gzrq;
    private String ddate;
    private String user;
    private String matnr;
    private float gzsl;
    private String bktxt;
    private String hetxt;
    private String reswk;
    private String werks;
    private String lgpro;
    private String lgort;
    private String vbeln;
    private String vbelp;
    private String seria;
    private String banfn;
    private String pitem;

    public warehousereceiptsReq() {
    }

    public warehousereceiptsReq(String gzrq, String ddate, String user, String matnr, float gzsl, String bktxt, String hetxt, String reswk, String werks, String lgpro, String lgort, String vbeln, String vbelp, String seria, String banfn, String pitem) {
        this.gzrq = gzrq;
        this.ddate = ddate;
        this.user = user;
        this.matnr = matnr;
        this.gzsl = gzsl;
        this.bktxt = bktxt;
        this.hetxt = hetxt;
        this.reswk = reswk;
        this.werks = werks;
        this.lgpro = lgpro;
        this.lgort = lgort;
        this.vbeln = vbeln;
        this.vbelp = vbelp;
        this.seria = seria;
        this.banfn = banfn;
        this.pitem = pitem;
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

    public float getGzsl() {
        return gzsl;
    }

    public void setGzsl(float gzsl) {
        this.gzsl = gzsl;
    }

    public String getBktxt() {
        return bktxt;
    }

    public void setBktxt(String bktxt) {
        this.bktxt = bktxt;
    }

    public String getHetxt() {
        return hetxt;
    }

    public void setHetxt(String hetxt) {
        this.hetxt = hetxt;
    }

    public String getReswk() {
        return reswk;
    }

    public void setReswk(String reswk) {
        this.reswk = reswk;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getLgpro() {
        return lgpro;
    }

    public void setLgpro(String lgpro) {
        this.lgpro = lgpro;
    }

    public String getLgort() {
        return lgort;
    }

    public void setLgort(String lgort) {
        this.lgort = lgort;
    }

    public String getVbeln() {
        return vbeln;
    }

    public void setVbeln(String vbeln) {
        this.vbeln = vbeln;
    }

    public String getVbelp() {
        return vbelp;
    }

    public void setVbelp(String vbelp) {
        this.vbelp = vbelp;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getBanfn() {
        return banfn;
    }

    public void setBanfn(String banfn) {
        this.banfn = banfn;
    }

    public String getPitem() {
        return pitem;
    }

    public void setPitem(String pitem) {
        this.pitem = pitem;
    }
}
