package com.example.kymanage.Beans.GetPurchaseOrderInfoJS;

import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;

import java.io.Serializable;
import java.util.List;

/**
 * {
 *             "EBELN": "4800000034",
 *             "LGPRO": "2906",
 *             "WERKS": "2090",
 *             "EBELP": "00010",
 *             "materialType": "",
 *             "MENGE": 495,
 *             "LGFSB": "2906",
 *             "MEINS": "EA",
 *             "SBDKZ": "",
 *             "KINDS": "10",
 *             "WESBS": 0,
 *             "CGTXT": "",
 *             "LABOR": "",
 *             "TXZ01": "护罩",
 *             "MATNR": "LJ6025009377-TZ2010041018"
 *         }
 */
public class GetPurchaseOrderInfoJSRep implements Serializable {
    private String EBELN;
    private String LGPRO;
    private String WERKS;
    private String EBELP;
    private String materialType;
    private float MENGE;
    private String LGFSB;
    private String MEINS;
    private String SBDKZ;
    private String KINDS;
    private float WESBS;
    private float inStorage;
    private String CGTXT;
    private String LABOR;
    private String TXZ01;
    private String MATNR;
    private List<iddesBean> storage;

    private String marketorderno;
    private String marketorderrow;



    public String getEBELN() {
        return EBELN;
    }

    public void setEBELN(String EBELN) {
        this.EBELN = EBELN;
    }

    public String getLGPRO() {
        return LGPRO;
    }

    public void setLGPRO(String LGPRO) {
        this.LGPRO = LGPRO;
    }

    public String getWERKS() {
        return WERKS;
    }

    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }

    public String getEBELP() {
        return EBELP;
    }

    public void setEBELP(String EBELP) {
        this.EBELP = EBELP;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public float getMENGE() {
        return MENGE;
    }

    public void setMENGE(float MENGE) {
        this.MENGE = MENGE;
    }

    public String getLGFSB() {
        return LGFSB;
    }

    public void setLGFSB(String LGFSB) {
        this.LGFSB = LGFSB;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getSBDKZ() {
        return SBDKZ;
    }

    public void setSBDKZ(String SBDKZ) {
        this.SBDKZ = SBDKZ;
    }

    public String getKINDS() {
        return KINDS;
    }

    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
    }

    public float getWESBS() {
        return WESBS;
    }

    public void setWESBS(float WESBS) {
        this.WESBS = WESBS;
    }

    public float getInStorage() {
        return inStorage;
    }

    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }

    public String getCGTXT() {
        return CGTXT;
    }

    public void setCGTXT(String CGTXT) {
        this.CGTXT = CGTXT;
    }

    public String getLABOR() {
        return LABOR;
    }

    public void setLABOR(String LABOR) {
        this.LABOR = LABOR;
    }

    public String getTXZ01() {
        return TXZ01;
    }

    public void setTXZ01(String TXZ01) {
        this.TXZ01 = TXZ01;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }

    public List<iddesBean> getStorage() {
        return storage;
    }

    public void setStorage(List<iddesBean> storage) {
        this.storage = storage;
    }


    public String getMarketorderno() {
        return marketorderno;
    }

    public void setMarketorderno(String marketorderno) {
        this.marketorderno = marketorderno;
    }

    public String getMarketorderrow() {
        return marketorderrow;
    }

    public void setMarketorderrow(String marketorderrow) {
        this.marketorderrow = marketorderrow;
    }
}
