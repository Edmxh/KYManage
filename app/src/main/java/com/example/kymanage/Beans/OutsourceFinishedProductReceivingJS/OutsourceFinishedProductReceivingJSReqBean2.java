package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * {
 *       "KDAUF": "0010000208",
 *       "KDPOS": "000026",
 *       "AUFNR": "000010048078",
 *       "MATNR": "LJ7015001194",
 *       "MAKTX": "支架加工完成半成品",
 *       "UNIT": "EA",
 *       "PMATNR": "LJ7015001194",
 *       "PMAKTX": "支架加工完成半成品",
 *       "PUNIT": "EA",
 *       "RSNUM": "0000095028",
 *       "RSPOS": "0001",
 *       "BDMNG": 5,
 *       "issueNum": 2,
 *       "MCODE": "1234",
 *       "RSART": ""
 *     }
 */
public class OutsourceFinishedProductReceivingJSReqBean2 implements Serializable {
    private String KDAUF;
    private String KDPOS;
    private String AUFNR;
    private String MATNR;
    private String MAKTX;
    private String UNIT;
    private String PMATNR;
    private String PMAKTX;
    private String PUNIT;
    private String RSNUM;
    private String RSPOS;
    private float BDMNG;
    private float issueNum;
    private String MCODE;
    private String RSART;

    public OutsourceFinishedProductReceivingJSReqBean2() {
    }

    public OutsourceFinishedProductReceivingJSReqBean2(String KDAUF, String KDPOS, String AUFNR, String MATNR, String MAKTX, String UNIT, String PMATNR, String PMAKTX, String PUNIT, String RSNUM, String RSPOS, float BDMNG, float issueNum, String MCODE, String RSART) {
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.AUFNR = AUFNR;
        this.MATNR = MATNR;
        this.MAKTX = MAKTX;
        this.UNIT = UNIT;
        this.PMATNR = PMATNR;
        this.PMAKTX = PMAKTX;
        this.PUNIT = PUNIT;
        this.RSNUM = RSNUM;
        this.RSPOS = RSPOS;
        this.BDMNG = BDMNG;
        this.issueNum = issueNum;
        this.MCODE = MCODE;
        this.RSART = RSART;
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
    @JSONField(name = "AUFNR")
    public String getAUFNR() {
        return AUFNR;
    }
    @JSONField(name = "AUFNR")
    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
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
    @JSONField(name = "UNIT")
    public String getUNIT() {
        return UNIT;
    }
    @JSONField(name = "UNIT")
    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
    }
    @JSONField(name = "PMATNR")
    public String getPMATNR() {
        return PMATNR;
    }
    @JSONField(name = "PMATNR")
    public void setPMATNR(String PMATNR) {
        this.PMATNR = PMATNR;
    }
    @JSONField(name = "PMAKTX")
    public String getPMAKTX() {
        return PMAKTX;
    }
    @JSONField(name = "PMAKTX")
    public void setPMAKTX(String PMAKTX) {
        this.PMAKTX = PMAKTX;
    }
    @JSONField(name = "PUNIT")
    public String getPUNIT() {
        return PUNIT;
    }
    @JSONField(name = "PUNIT")
    public void setPUNIT(String PUNIT) {
        this.PUNIT = PUNIT;
    }
    @JSONField(name = "RSNUM")
    public String getRSNUM() {
        return RSNUM;
    }
    @JSONField(name = "RSNUM")
    public void setRSNUM(String RSNUM) {
        this.RSNUM = RSNUM;
    }
    @JSONField(name = "RSPOS")
    public String getRSPOS() {
        return RSPOS;
    }
    @JSONField(name = "RSPOS")
    public void setRSPOS(String RSPOS) {
        this.RSPOS = RSPOS;
    }
    @JSONField(name = "BDMNG")
    public float getBDMNG() {
        return BDMNG;
    }
    @JSONField(name = "BDMNG")
    public void setBDMNG(float BDMNG) {
        this.BDMNG = BDMNG;
    }
    @JSONField(name = "issueNum")
    public float getIssueNum() {
        return issueNum;
    }
    @JSONField(name = "issueNum")
    public void setIssueNum(float issueNum) {
        this.issueNum = issueNum;
    }
    @JSONField(name = "MCODE")
    public String getMCODE() {
        return MCODE;
    }
    @JSONField(name = "MCODE")
    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }
    @JSONField(name = "RSART")
    public String getRSART() {
        return RSART;
    }
    @JSONField(name = "RSART")
    public void setRSART(String RSART) {
        this.RSART = RSART;
    }
}
