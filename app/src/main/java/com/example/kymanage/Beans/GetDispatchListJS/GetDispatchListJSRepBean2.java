package com.example.kymanage.Beans.GetDispatchListJS;

import java.util.List;

/**
 * {
 *             "MAKTX": "支架",
 *             "GLTRP": "2020-06-11",
 *             "data": [
 *                 {
 *                     "LTXA1": "喷底漆、喷面漆",
 *                     "GXCWB": "喷底漆、喷面漆",
 *                     "VORNR": "0010"
 *                 },
 *                 {
 *                     "LTXA1": "检验",
 *                     "GXCWB": "检验",
 *                     "VORNR": "0020"
 *                 }
 *             ],
 *             "GSTRS": "2020-06-02",
 *             "KTSCH": "喷漆",
 *             "MEINS": "EA",
 *             "DWERK": "2090",
 *             "AUFNR": "000010048078",
 *             "PSMNG": "1000.000",
 *             "ZAEHL": "00000001",
 *             "ERDAT": "2020-06-02",
 *             "KDAUF": "0010000208",
 *             "KDPOS": "000026",
 *             "PLNNR": "50012891",
 *             "PLNKN": "00000001",
 *             "MATNR": "LJ2015000594-TZ2010043020"
 *         }
 */
public class GetDispatchListJSRepBean2 {
    private List<GetDispatchListJSBean1> data;
    private String MAKTX;
    private String GLTRP;
    private String GSTRS;
    private String KTSCH;
    private String MEINS;
    private String DWERK;
    private String AUFNR;
    private String PSMNG;
    private String ZAEHL;
    private String ERDAT;
    private String KDAUF;
    private String KDPOS;
    private String PLNNR;
    private String PLNKN;
    private String MATNR;
    private float issueNum;
    private String DispatchListNO;
    private String username;
    private String createDate;

    public List<GetDispatchListJSBean1> getData() {
        return data;
    }

    public void setData(List<GetDispatchListJSBean1> data) {
        this.data = data;
    }

    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }

    public String getGLTRP() {
        return GLTRP;
    }

    public void setGLTRP(String GLTRP) {
        this.GLTRP = GLTRP;
    }

    public String getGSTRS() {
        return GSTRS;
    }

    public void setGSTRS(String GSTRS) {
        this.GSTRS = GSTRS;
    }

    public String getKTSCH() {
        return KTSCH;
    }

    public void setKTSCH(String KTSCH) {
        this.KTSCH = KTSCH;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getDWERK() {
        return DWERK;
    }

    public void setDWERK(String DWERK) {
        this.DWERK = DWERK;
    }

    public String getAUFNR() {
        return AUFNR;
    }

    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
    }

    public String getPSMNG() {
        return PSMNG;
    }

    public void setPSMNG(String PSMNG) {
        this.PSMNG = PSMNG;
    }

    public String getZAEHL() {
        return ZAEHL;
    }

    public void setZAEHL(String ZAEHL) {
        this.ZAEHL = ZAEHL;
    }

    public String getERDAT() {
        return ERDAT;
    }

    public void setERDAT(String ERDAT) {
        this.ERDAT = ERDAT;
    }

    public String getKDAUF() {
        return KDAUF;
    }

    public void setKDAUF(String KDAUF) {
        this.KDAUF = KDAUF;
    }

    public String getKDPOS() {
        return KDPOS;
    }

    public void setKDPOS(String KDPOS) {
        this.KDPOS = KDPOS;
    }

    public String getPLNNR() {
        return PLNNR;
    }

    public void setPLNNR(String PLNNR) {
        this.PLNNR = PLNNR;
    }

    public String getPLNKN() {
        return PLNKN;
    }

    public void setPLNKN(String PLNKN) {
        this.PLNKN = PLNKN;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }

    public float getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(float issueNum) {
        this.issueNum = issueNum;
    }

    public String getDispatchListNO() {
        return DispatchListNO;
    }

    public void setDispatchListNO(String dispatchListNO) {
        DispatchListNO = dispatchListNO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
