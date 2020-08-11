package com.example.kymanage.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Test {

    /**
     * postingDate : 2020-06-15
     * documentDate : 2020-06-15
     * user : pliu
     * KDAUF : 10000208
     * KDPOS : 26
     * orderNum : 4800000036
     * orderRow : 00010
     * upstreamFactory : 2010
     * demandFactory : 2090
     * demandStorage : 2906
     * materialCode : LJ7015001194
     * materialDesc : 拖链导槽|Q235A
     * materialType : 独立
     * materialUnit : EA
     * MENGE : 1000
     * inStorage : 195.0
     * recNum : 2
     * remark : 外协成品收货物料测试备注
     * KINDS : 10
     * AUFNR : [{"PAUFNR":"","PRSNUM":"","PRSPOS":"","PMATNR":"","PMAKTX":"","PMEINS":"","PRSART":"","PMCODE":"","PLGFSB":"","PMENGE":0,"PIssueQty":0,"PIssuedQty":0}]
     * UPAUFNR : [{"UPPAUFNR":"000010048077","UPPRSNUM":"0000095024","UPPRSPOS":"0007","UPPMATNR":"ZJ9310000007","UPPMAKTX":"集中控制系统","UPPMEINS":"EA","UPPRSART":"","UPPMCODE":"","UPPLGFSB":"2100","UPPMENGE":1000,"UPPIssueQty":2,"UPPIssuedQty":10}]
     */

    private String postingDate;
    private String documentDate;
    private String user;
    private String KDAUF;
    private String KDPOS;
    private String orderNum;
    private String orderRow;
    private String upstreamFactory;
    private String demandFactory;
    private String demandStorage;
    private String materialCode;
    private String materialDesc;
    private String materialType;
    private String materialUnit;
    private float MENGE;
    private float inStorage;
    private float recNum;
    private String remark;
    private String KINDS;
    private List<AUFNRBean> AUFNR;
    private List<UPAUFNRBean> UPAUFNR;

    public Test(String postingDate, String documentDate, String user, String KDAUF, String KDPOS, String orderNum, String orderRow, String upstreamFactory, String demandFactory, String demandStorage, String materialCode, String materialDesc, String materialType, String materialUnit, float MENGE, float inStorage, float recNum, String remark, String KINDS, List<AUFNRBean> AUFNR, List<UPAUFNRBean> UPAUFNR) {
        this.postingDate = postingDate;
        this.documentDate = documentDate;
        this.user = user;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.upstreamFactory = upstreamFactory;
        this.demandFactory = demandFactory;
        this.demandStorage = demandStorage;
        this.materialCode = materialCode;
        this.materialDesc = materialDesc;
        this.materialType = materialType;
        this.materialUnit = materialUnit;
        this.MENGE = MENGE;
        this.inStorage = inStorage;
        this.recNum = recNum;
        this.remark = remark;
        this.KINDS = KINDS;
        this.AUFNR = AUFNR;
        this.UPAUFNR = UPAUFNR;
    }

    public static Test objectFromData(String str) {

        return new Gson().fromJson(str, Test.class);
    }

    public static Test objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Test.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Test> arrayTestFromData(String str) {

        Type listType = new TypeToken<ArrayList<Test>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Test> arrayTestFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Test>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderRow() {
        return orderRow;
    }

    public void setOrderRow(String orderRow) {
        this.orderRow = orderRow;
    }

    public String getUpstreamFactory() {
        return upstreamFactory;
    }

    public void setUpstreamFactory(String upstreamFactory) {
        this.upstreamFactory = upstreamFactory;
    }

    public String getDemandFactory() {
        return demandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        this.demandFactory = demandFactory;
    }

    public String getDemandStorage() {
        return demandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        this.demandStorage = demandStorage;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public float getMENGE() {
        return MENGE;
    }

    public void setMENGE(float MENGE) {
        this.MENGE = MENGE;
    }

    public float getInStorage() {
        return inStorage;
    }

    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }

    public float getRecNum() {
        return recNum;
    }

    public void setRecNum(float recNum) {
        this.recNum = recNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKINDS() {
        return KINDS;
    }

    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
    }

    public List<AUFNRBean> getAUFNR() {
        return AUFNR;
    }

    public void setAUFNR(List<AUFNRBean> AUFNR) {
        this.AUFNR = AUFNR;
    }

    public List<UPAUFNRBean> getUPAUFNR() {
        return UPAUFNR;
    }

    public void setUPAUFNR(List<UPAUFNRBean> UPAUFNR) {
        this.UPAUFNR = UPAUFNR;
    }

    public static class AUFNRBean {
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

        public String getPAUFNR() {
            return PAUFNR;
        }

        public void setPAUFNR(String PAUFNR) {
            this.PAUFNR = PAUFNR;
        }

        public String getPRSNUM() {
            return PRSNUM;
        }

        public void setPRSNUM(String PRSNUM) {
            this.PRSNUM = PRSNUM;
        }

        public String getPRSPOS() {
            return PRSPOS;
        }

        public void setPRSPOS(String PRSPOS) {
            this.PRSPOS = PRSPOS;
        }

        public String getPMATNR() {
            return PMATNR;
        }

        public void setPMATNR(String PMATNR) {
            this.PMATNR = PMATNR;
        }

        public String getPMAKTX() {
            return PMAKTX;
        }

        public void setPMAKTX(String PMAKTX) {
            this.PMAKTX = PMAKTX;
        }

        public String getPMEINS() {
            return PMEINS;
        }

        public void setPMEINS(String PMEINS) {
            this.PMEINS = PMEINS;
        }

        public String getPRSART() {
            return PRSART;
        }

        public void setPRSART(String PRSART) {
            this.PRSART = PRSART;
        }

        public String getPMCODE() {
            return PMCODE;
        }

        public void setPMCODE(String PMCODE) {
            this.PMCODE = PMCODE;
        }

        public String getPLGFSB() {
            return PLGFSB;
        }

        public void setPLGFSB(String PLGFSB) {
            this.PLGFSB = PLGFSB;
        }

        public float getPMENGE() {
            return PMENGE;
        }

        public void setPMENGE(float PMENGE) {
            this.PMENGE = PMENGE;
        }

        public float getPIssueQty() {
            return PIssueQty;
        }

        public void setPIssueQty(float PIssueQty) {
            this.PIssueQty = PIssueQty;
        }

        public float getPIssuedQty() {
            return PIssuedQty;
        }

        public void setPIssuedQty(float PIssuedQty) {
            this.PIssuedQty = PIssuedQty;
        }
    }

    public static class UPAUFNRBean {
        /**
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

        public String getUPPAUFNR() {
            return UPPAUFNR;
        }

        public void setUPPAUFNR(String UPPAUFNR) {
            this.UPPAUFNR = UPPAUFNR;
        }

        public String getUPPRSNUM() {
            return UPPRSNUM;
        }

        public void setUPPRSNUM(String UPPRSNUM) {
            this.UPPRSNUM = UPPRSNUM;
        }

        public String getUPPRSPOS() {
            return UPPRSPOS;
        }

        public void setUPPRSPOS(String UPPRSPOS) {
            this.UPPRSPOS = UPPRSPOS;
        }

        public String getUPPMATNR() {
            return UPPMATNR;
        }

        public void setUPPMATNR(String UPPMATNR) {
            this.UPPMATNR = UPPMATNR;
        }

        public String getUPPMAKTX() {
            return UPPMAKTX;
        }

        public void setUPPMAKTX(String UPPMAKTX) {
            this.UPPMAKTX = UPPMAKTX;
        }

        public String getUPPMEINS() {
            return UPPMEINS;
        }

        public void setUPPMEINS(String UPPMEINS) {
            this.UPPMEINS = UPPMEINS;
        }

        public String getUPPRSART() {
            return UPPRSART;
        }

        public void setUPPRSART(String UPPRSART) {
            this.UPPRSART = UPPRSART;
        }

        public String getUPPMCODE() {
            return UPPMCODE;
        }

        public void setUPPMCODE(String UPPMCODE) {
            this.UPPMCODE = UPPMCODE;
        }

        public String getUPPLGFSB() {
            return UPPLGFSB;
        }

        public void setUPPLGFSB(String UPPLGFSB) {
            this.UPPLGFSB = UPPLGFSB;
        }

        public float getUPPMENGE() {
            return UPPMENGE;
        }

        public void setUPPMENGE(float UPPMENGE) {
            this.UPPMENGE = UPPMENGE;
        }

        public float getUPPIssueQty() {
            return UPPIssueQty;
        }

        public void setUPPIssueQty(float UPPIssueQty) {
            this.UPPIssueQty = UPPIssueQty;
        }

        public float getUPPIssuedQty() {
            return UPPIssuedQty;
        }

        public void setUPPIssuedQty(float UPPIssuedQty) {
            this.UPPIssuedQty = UPPIssuedQty;
        }
    }
}
