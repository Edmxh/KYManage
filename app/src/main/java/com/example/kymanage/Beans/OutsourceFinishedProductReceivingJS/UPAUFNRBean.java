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
public class UPAUFNRBean implements Serializable {
    /**PMATNR : ZJxxxxxxxxxx
     * UPPAUFNR : 000010048077
     * UPPRSNUM : 0000095024
     * UPPRSPOS : 0007
     * UPPMATNR : ZJ9310000007
     * UPPMAKTX : 集中控制系统
     * UPPMEINS : EA
     * UPPRSART :
     * UPPMCODE :
     * UPPLGFSB : 2100
     * UPPMENGE : 1000
     * UPPIssueQty : 2
     * UPPIssuedQty : 10
     */

    private String UPPAUFNR;
    private String UPPRSNUM;
    private String UPPRSPOS;
    private String UPPMATNR;
    private String UPPMAKTX;
    private String UPPMEINS;
    private String UPPRSART;
    private String UPPMCODE;
    private String UPPLGFSB;
    private float UPPMENGE;
    private float UPPIssueQty;
    private float UPPIssuedQty;

    private String PMATNR;
    private String PMAKTX;
    private String PMEINS;

    public UPAUFNRBean(String UPPAUFNR, String UPPRSNUM, String UPPRSPOS, String UPPMATNR, String UPPMAKTX, String UPPMEINS, String UPPRSART, String UPPMCODE, String UPPLGFSB, float UPPMENGE, float UPPIssueQty, float UPPIssuedQty, String PMATNR, String PMAKTX, String PMEINS) {
        this.UPPAUFNR = UPPAUFNR;
        this.UPPRSNUM = UPPRSNUM;
        this.UPPRSPOS = UPPRSPOS;
        this.UPPMATNR = UPPMATNR;
        this.UPPMAKTX = UPPMAKTX;
        this.UPPMEINS = UPPMEINS;
        this.UPPRSART = UPPRSART;
        this.UPPMCODE = UPPMCODE;
        this.UPPLGFSB = UPPLGFSB;
        this.UPPMENGE = UPPMENGE;
        this.UPPIssueQty = UPPIssueQty;
        this.UPPIssuedQty = UPPIssuedQty;
        this.PMATNR = PMATNR;
        this.PMAKTX = PMAKTX;
        this.PMEINS = PMEINS;
    }

    public static UPAUFNRBean objectFromData(String str) {

        return new Gson().fromJson(str, UPAUFNRBean.class);
    }

    public static UPAUFNRBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), UPAUFNRBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<UPAUFNRBean> arrayUPAUFNRBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UPAUFNRBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<UPAUFNRBean> arrayUPAUFNRBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<UPAUFNRBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "UPPAUFNR")
    public String getUPPAUFNR() {
        return UPPAUFNR;
    }
    @JSONField(name = "UPPAUFNR")
    public void setUPPAUFNR(String UPPAUFNR) {
        this.UPPAUFNR = UPPAUFNR;
    }
    @JSONField(name = "UPPRSNUM")
    public String getUPPRSNUM() {
        return UPPRSNUM;
    }
    @JSONField(name = "UPPRSNUM")
    public void setUPPRSNUM(String UPPRSNUM) {
        this.UPPRSNUM = UPPRSNUM;
    }
    @JSONField(name = "UPPRSPOS")
    public String getUPPRSPOS() {
        return UPPRSPOS;
    }
    @JSONField(name = "UPPRSPOS")
    public void setUPPRSPOS(String UPPRSPOS) {
        this.UPPRSPOS = UPPRSPOS;
    }
    @JSONField(name = "UPPMATNR")
    public String getUPPMATNR() {
        return UPPMATNR;
    }
    @JSONField(name = "UPPMATNR")
    public void setUPPMATNR(String UPPMATNR) {
        this.UPPMATNR = UPPMATNR;
    }
    @JSONField(name = "UPPMAKTX")
    public String getUPPMAKTX() {
        return UPPMAKTX;
    }
    @JSONField(name = "UPPMAKTX")
    public void setUPPMAKTX(String UPPMAKTX) {
        this.UPPMAKTX = UPPMAKTX;
    }
    @JSONField(name = "UPPMEINS")
    public String getUPPMEINS() {
        return UPPMEINS;
    }
    @JSONField(name = "UPPMEINS")
    public void setUPPMEINS(String UPPMEINS) {
        this.UPPMEINS = UPPMEINS;
    }
    @JSONField(name = "UPPRSART")
    public String getUPPRSART() {
        return UPPRSART;
    }
    @JSONField(name = "UPPRSART")
    public void setUPPRSART(String UPPRSART) {
        this.UPPRSART = UPPRSART;
    }
    @JSONField(name = "UPPMCODE")
    public String getUPPMCODE() {
        return UPPMCODE;
    }
    @JSONField(name = "UPPMCODE")
    public void setUPPMCODE(String UPPMCODE) {
        this.UPPMCODE = UPPMCODE;
    }
    @JSONField(name = "UPPLGFSB")
    public String getUPPLGFSB() {
        return UPPLGFSB;
    }
    @JSONField(name = "UPPLGFSB")
    public void setUPPLGFSB(String UPPLGFSB) {
        this.UPPLGFSB = UPPLGFSB;
    }
    @JSONField(name = "UPPMENGE")
    public float getUPPMENGE() {
        return UPPMENGE;
    }
    @JSONField(name = "UPPMENGE")
    public void setUPPMENGE(float UPPMENGE) {
        this.UPPMENGE = UPPMENGE;
    }
    @JSONField(name = "UPPIssueQty")
    public float getUPPIssueQty() {
        return UPPIssueQty;
    }
    @JSONField(name = "UPPIssueQty")
    public void setUPPIssueQty(float UPPIssueQty) {
        this.UPPIssueQty = UPPIssueQty;
    }
    @JSONField(name = "UPPIssuedQty")
    public float getUPPIssuedQty() {
        return UPPIssuedQty;
    }
    @JSONField(name = "UPPIssuedQty")
    public void setUPPIssuedQty(float UPPIssuedQty) {
        this.UPPIssuedQty = UPPIssuedQty;
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
}
