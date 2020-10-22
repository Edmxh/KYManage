package com.example.kymanage.Beans.GetOutStorageMaterialOrderJS;

import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;

import java.util.List;

/**
 * {            "MAKTX": "压板|45",//
 *             "WEMNG": 0,//
 *             "WERKS": "2090",//
 *             "MCODE": "",//
 *             "GSTRS": "2019-10-10",//
 *             "LGORT": "2906",//
 *             "MEINS": "EA",//
 *             "AUFNR": "000010044339",//
 *             "PSMNG": 4,//
 *             "MATNR": "LJ5540008372-TZ4010000000"//
 *             库位信息
 *         }
 */
public class GetOutStorageMaterialOrderJSRepBean {
    private float WEMNG;
    private String MEINS;
    private String AUFNR;
    private float PSMNG;
    private float INQTY;
    private String MATNR;
    private String WERKS;
    private String MAKTX;
    private String MCODE;
    private String GSTRS;
    private String LGORT;
    private GetOutStorageMaterialOrderJSRepBean1 STORAGE;

    private boolean chosen;
    private boolean change;

    public float getWEMNG() {
        return WEMNG;
    }

    public void setWEMNG(float WEMNG) {
        this.WEMNG = WEMNG;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getAUFNR() {
        return AUFNR;
    }

    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
    }

    public float getPSMNG() {
        return PSMNG;
    }

    public void setPSMNG(float PSMNG) {
        this.PSMNG = PSMNG;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }

    public String getWERKS() {
        return WERKS;
    }

    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }

    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }

    public String getMCODE() {
        return MCODE;
    }

    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
    }

    public String getGSTRS() {
        return GSTRS;
    }

    public void setGSTRS(String GSTRS) {
        this.GSTRS = GSTRS;
    }

    public String getLGORT() {
        return LGORT;
    }

    public void setLGORT(String LGORT) {
        this.LGORT = LGORT;
    }

    public float getINQTY() {
        return INQTY;
    }

    public void setINQTY(float INQTY) {
        this.INQTY = INQTY;
    }

    public GetOutStorageMaterialOrderJSRepBean1 getSTORAGE() {
        return STORAGE;
    }

    public void setSTORAGE(GetOutStorageMaterialOrderJSRepBean1 STORAGE) {
        this.STORAGE = STORAGE;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }
}
