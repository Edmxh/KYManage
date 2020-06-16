package com.example.kymanage.Beans.General;

/**
 *  String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getNum()+",\"num\":\""+rep.getLabelSeqNum()+"\",\"po\":\""+rep.getProductOrderNO()+"\",\"pono\":\""+rep.getPo()+"\",\"porow\":\""+rep.getPoRow()+"\",\"gc\":\""+rep.getFactory()+"\",\"cd\":\""+rep.getAreaNO()+"\"}";
 *
 */
public class LabelBean1 {
    private String bm;
    private float sl;
    private String num;
    private String po;
    private String pono;
    private String porow;
    private String gc;
    private String cd;

    public LabelBean1() {
    }

    public LabelBean1(String bm, float sl, String num, String po, String pono, String porow, String gc, String cd) {
        this.bm = bm;
        this.sl = sl;
        this.num = num;
        this.po = po;
        this.pono = pono;
        this.porow = porow;
        this.gc = gc;
        this.cd = cd;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public float getSl() {
        return sl;
    }

    public void setSl(float sl) {
        this.sl = sl;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getPorow() {
        return porow;
    }

    public void setPorow(String porow) {
        this.porow = porow;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }
}
