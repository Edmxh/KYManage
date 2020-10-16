package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *  {
 *         "outKDAUF": "0010000208",
 *         "outKDPOS": "000026",
 *         "outAUFNR": "000010048078",
 *         "outMATNR": "LJ2015000594-A01",
 *         "outMAKTX": "支架加工完成半成品",
 *         "outRSNUM": "0000095028",
 *         "outRSPOS": "0001",
 *         "outBDMNG": 5,
 *         "outIssueNum": 2,
 *         "outMCODE": "1234",
 *         "outPUNIT": "EA",
 *         "outRSART": "1",
 *         "outWERKS": "2010",
 *
 *         "UBNO": "",
*          "BUProjectNO": "",
*          "UBDemandQty": "",
*          "DeliveryDate": "2020-09-06-06"
 *       }
 */
public class AUFNRBean implements Serializable {
    /**
     * PAUFNR :
     * PRSNUM :
     * PRSPOS :
     * PMATNR :
     * PMAKTX :
     * PMEINS :
     * PRSART :
     * PMCODE :
     * PLGFSB :
     * PMENGE : 0
     * PIssueQty : 0
     * PIssuedQty : 0
     */

    private String PAUFNR;
    private String PRSNUM;
    private String PRSPOS;
    private String PMATNR;
    private String PMAKTX;
    private String PMEINS;
    private String PRSART;
    private String PMCODE;
    private String PLGFSB;
    private float PMENGE;
    private float PIssueQty;
    private float PIssuedQty;
    private String PSOBKZ;
    private String PLGPBE;
    private String PPLORD;
    private String POTYPE;

    public AUFNRBean(String PAUFNR, String PRSNUM, String PRSPOS, String PMATNR, String PMAKTX, String PMEINS, String PRSART, String PMCODE, String PLGFSB, float PMENGE, float PIssueQty, float PIssuedQty, String PSOBKZ, String PLGPBE, String PPLORD, String POTYPE) {
        this.PAUFNR = PAUFNR;
        this.PRSNUM = PRSNUM;
        this.PRSPOS = PRSPOS;
        this.PMATNR = PMATNR;
        this.PMAKTX = PMAKTX;
        this.PMEINS = PMEINS;
        this.PRSART = PRSART;
        this.PMCODE = PMCODE;
        this.PLGFSB = PLGFSB;
        this.PMENGE = PMENGE;
        this.PIssueQty = PIssueQty;
        this.PIssuedQty = PIssuedQty;
        this.PSOBKZ = PSOBKZ;
        this.PLGPBE = PLGPBE;
        this.PPLORD = PPLORD;
        this.POTYPE = POTYPE;
    }

    public static AUFNRBean objectFromData(String str) {

        return new Gson().fromJson(str, AUFNRBean.class);
    }

    public static AUFNRBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), AUFNRBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<AUFNRBean> arrayAUFNRBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AUFNRBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<AUFNRBean> arrayAUFNRBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<AUFNRBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "PAUFNR")
    public String getPAUFNR() {
        return PAUFNR;
    }
    @JSONField(name = "PAUFNR")
    public void setPAUFNR(String PAUFNR) {
        this.PAUFNR = PAUFNR;
    }
    @JSONField(name = "PRSNUM")
    public String getPRSNUM() {
        return PRSNUM;
    }
    @JSONField(name = "PRSNUM")
    public void setPRSNUM(String PRSNUM) {
        this.PRSNUM = PRSNUM;
    }
    @JSONField(name = "PRSPOS")
    public String getPRSPOS() {
        return PRSPOS;
    }
    @JSONField(name = "PRSPOS")
    public void setPRSPOS(String PRSPOS) {
        this.PRSPOS = PRSPOS;
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
    @JSONField(name = "PMEINS")
    public String getPMEINS() {
        return PMEINS;
    }
    @JSONField(name = "PMEINS")
    public void setPMEINS(String PMEINS) {
        this.PMEINS = PMEINS;
    }
    @JSONField(name = "PRSART")
    public String getPRSART() {
        return PRSART;
    }
    @JSONField(name = "PRSART")
    public void setPRSART(String PRSART) {
        this.PRSART = PRSART;
    }
    @JSONField(name = "PMCODE")
    public String getPMCODE() {
        return PMCODE;
    }
    @JSONField(name = "PMCODE")
    public void setPMCODE(String PMCODE) {
        this.PMCODE = PMCODE;
    }
    @JSONField(name = "PLGFSB")
    public String getPLGFSB() {
        return PLGFSB;
    }
    @JSONField(name = "PLGFSB")
    public void setPLGFSB(String PLGFSB) {
        this.PLGFSB = PLGFSB;
    }
    @JSONField(name = "PMENGE")
    public float getPMENGE() {
        return PMENGE;
    }
    @JSONField(name = "PMENGE")
    public void setPMENGE(float PMENGE) {
        this.PMENGE = PMENGE;
    }
    @JSONField(name = "PIssueQty")
    public float getPIssueQty() {
        return PIssueQty;
    }
    @JSONField(name = "PIssueQty")
    public void setPIssueQty(float PIssueQty) {
        this.PIssueQty = PIssueQty;
    }
    @JSONField(name = "PIssuedQty")
    public float getPIssuedQty() {
        return PIssuedQty;
    }
    @JSONField(name = "PIssuedQty")
    public void setPIssuedQty(float PIssuedQty) {
        this.PIssuedQty = PIssuedQty;
    }
    @JSONField(name = "PSOBKZ")
    public String getPSOBKZ() {
        return PSOBKZ;
    }
    @JSONField(name = "PSOBKZ")
    public void setPSOBKZ(String PSOBKZ) {
        this.PSOBKZ = PSOBKZ;
    }
    @JSONField(name = "PLGPBE")
    public String getPLGPBE() {
        return PLGPBE;
    }
    @JSONField(name = "PLGPBE")
    public void setPLGPBE(String PLGPBE) {
        this.PLGPBE = PLGPBE;
    }
    @JSONField(name = "PPLORD")
    public String getPPLORD() {
        return PPLORD;
    }
    @JSONField(name = "PPLORD")
    public void setPPLORD(String PPLORD) {
        this.PPLORD = PPLORD;
    }
    @JSONField(name = "POTYPE")
    public String getPOTYPE() {
        return POTYPE;
    }
    @JSONField(name = "POTYPE")
    public void setPOTYPE(String POTYPE) {
        this.POTYPE = POTYPE;
    }
}
