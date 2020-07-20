package com.example.kymanage.Beans.PreMaterialProductOrder;

/**
 * {
 *             "MAKTX": "插头/MC200-E1_6pin",
 *             "factory": "2010",
 *             "planStartTime": "2019-09-20",
 *             "demandNum": 3,
 *             "issueNum": 0,
 *             "RSART": "",
 *             "MENGE": "0",
 *             "MEINS": "EA",
 *             "storage": "2100",
 *             "allocatedNum": 1.0,
 *             "demandLevel": "",
 *             "ZSERNR": "",
 *             "RSNUM": "0000065688",
 *             "levelCode": 0,
 *             "LFDAT": "0000-00-00",
 *             "productOrderNO": "000010031163",
 *             "BANFN": "",
 *             "KDAUF": "",
 *             "RSPOS": "0013",
 *             "KDPOS": "000000",
 *             "BNFPO": "00000",
 *             "MATNR": "DQ5095000031",
 *
 *              "currentNum": 1,
 *             "proOrderMaterialUnit": "EA",
 *             "proOrderMaterialDesc": "空中移栽组件",
 *             "MCODE": "",
 *             "proOrderDesc": "",
 *             "proOrderMaterialCode": "BJ5015000418",
 *         }
 */
public class PreMaterialProductOrderRep {
    private String MAKTX;
    private String factory;
    private String planStartTime;
    private float demandNum;
    private float IssuedNum;
    private String RSART;
    private String MENGE;
    private String MEINS;
    private String storage;
    private float allocatedNum;
    private String demandLevel;
    private String ZSERNR;
    private String RSNUM;
    private int levelCode;
    private String LFDAT;
    private String productOrderNO;
    private String BANFN;
    private String KDAUF;
    private String RSPOS;
    private String KDPOS;
    private String BNFPO;
    private String MATNR;
    private float currentNum;
    private String MCODE;
    private String proOrderDesc;
    private String proOrderMaterialDesc;
    private String proOrderMaterialCode;
    private String proOrderMaterialUnit;

    private SAPStorageBean SAPStorage;

    private String PLNFL;
    private String LTXA1;
    private String MATKL;

    private float dispatchNum;




    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public float getDemandNum() {
        return demandNum;
    }

    public void setDemandNum(float demandNum) {
        this.demandNum = demandNum;
    }

    public float getIssuedNum() {
        return IssuedNum;
    }

    public void setIssuedNum(float issuedNum) {
        IssuedNum = issuedNum;
    }

    public String getRSART() {
        return RSART;
    }

    public void setRSART(String RSART) {
        this.RSART = RSART;
    }

    public String getMENGE() {
        return MENGE;
    }

    public void setMENGE(String MENGE) {
        this.MENGE = MENGE;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public float getAllocatedNum() {
        return allocatedNum;
    }

    public void setAllocatedNum(float allocatedNum) {
        this.allocatedNum = allocatedNum;
    }

    public String getDemandLevel() {
        return demandLevel;
    }

    public void setDemandLevel(String demandLevel) {
        this.demandLevel = demandLevel;
    }

    public String getZSERNR() {
        return ZSERNR;
    }

    public void setZSERNR(String ZSERNR) {
        this.ZSERNR = ZSERNR;
    }

    public String getRSNUM() {
        return RSNUM;
    }

    public void setRSNUM(String RSNUM) {
        this.RSNUM = RSNUM;
    }

    public int getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(int levelCode) {
        this.levelCode = levelCode;
    }

    public String getLFDAT() {
        return LFDAT;
    }

    public void setLFDAT(String LFDAT) {
        this.LFDAT = LFDAT;
    }

    public String getProductOrderNO() {
        return productOrderNO;
    }

    public void setProductOrderNO(String productOrderNO) {
        this.productOrderNO = productOrderNO;
    }

    public String getBANFN() {
        return BANFN;
    }

    public void setBANFN(String BANFN) {
        this.BANFN = BANFN;
    }

    public String getKDAUF() {
        return KDAUF;
    }

    public void setKDAUF(String KDAUF) {
        this.KDAUF = KDAUF;
    }

    public String getRSPOS() {
        return RSPOS;
    }

    public void setRSPOS(String RSPOS) {
        this.RSPOS = RSPOS;
    }

    public String getKDPOS() {
        return KDPOS;
    }

    public void setKDPOS(String KDPOS) {
        this.KDPOS = KDPOS;
    }

    public String getBNFPO() {
        return BNFPO;
    }

    public void setBNFPO(String BNFPO) {
        this.BNFPO = BNFPO;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }

    public float getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(float currentNum) {
        this.currentNum = currentNum;
    }

    public String getMCODE() {
        return MCODE;
    }

    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }

    public String getProOrderDesc() {
        return proOrderDesc;
    }

    public void setProOrderDesc(String proOrderDesc) {
        this.proOrderDesc = proOrderDesc;
    }

    public String getProOrderMaterialDesc() {
        return proOrderMaterialDesc;
    }

    public void setProOrderMaterialDesc(String proOrderMaterialDesc) {
        this.proOrderMaterialDesc = proOrderMaterialDesc;
    }

    public String getProOrderMaterialCode() {
        return proOrderMaterialCode;
    }

    public void setProOrderMaterialCode(String proOrderMaterialCode) {
        this.proOrderMaterialCode = proOrderMaterialCode;
    }

    public String getProOrderMaterialUnit() {
        return proOrderMaterialUnit;
    }

    public void setProOrderMaterialUnit(String proOrderMaterialUnit) {
        this.proOrderMaterialUnit = proOrderMaterialUnit;
    }

    public SAPStorageBean getSAPStorage() {
        return SAPStorage;
    }

    public void setSAPStorage(SAPStorageBean SAPStorage) {
        this.SAPStorage = SAPStorage;
    }

    public String getPLNFL() {
        return PLNFL;
    }

    public void setPLNFL(String PLNFL) {
        this.PLNFL = PLNFL;
    }

    public String getLTXA1() {
        return LTXA1;
    }

    public void setLTXA1(String LTXA1) {
        this.LTXA1 = LTXA1;
    }

    public String getMATKL() {
        return MATKL;
    }

    public void setMATKL(String MATKL) {
        this.MATKL = MATKL;
    }

    public float getDispatchNum() {
        return dispatchNum;
    }

    public void setDispatchNum(float dispatchNum) {
        this.dispatchNum = dispatchNum;
    }
}
