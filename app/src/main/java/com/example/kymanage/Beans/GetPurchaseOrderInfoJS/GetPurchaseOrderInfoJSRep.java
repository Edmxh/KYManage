package com.example.kymanage.Beans.GetPurchaseOrderInfoJS;

import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class GetPurchaseOrderInfoJSRep implements Serializable {

    /**
     * EBELN : 4300000396
     * LGPRO : 2912
     * WERKS : 2090
     * MCODE :
     * EBELP : 00010
     * materialType : 独立
     * MENGE : 2
     * LGFSB : 2912
     * MEINS : EA
     * inStorage : 0
     * AUFNR : 000010040566
     * SBDKZ : 1
     * PMATN : LJ5530003770-A01
     * KINDS : 3
     * WESBS : 2
     * deliveryDate : 2019-10-15
     * CGTXT :
     * LABOR :
     * TXZ01 : LJ5530003770/夹具体/外协加工
     * MATNR : LJ5530003770-A01
     */

    private String EBELN;
    private String LGPRO;
    private String WERKS;
    private String MCODE;
    private String EBELP;
    private String materialType;
    private float MENGE;
    private String LGFSB;
    private String MEINS;
    private float inStorage;
    private String AUFNR;
    private String SBDKZ;
    private String PMATN;
    private String KINDS;
    private float WESBS;
    private String deliveryDate;
    private String CGTXT;
    private String LABOR;
    private String TXZ01;
    private String MATNR;
    private String MAKTX;

    private String marketorderno;
    private String marketorderrow;
    private List<GetOutsourcingExceptionTypeJSRep.GetOutsourcingExceptionTypeJSRepBean> reasonList;

    public static GetPurchaseOrderInfoJSRep objectFromData(String str) {

        return new Gson().fromJson(str, GetPurchaseOrderInfoJSRep.class);
    }

    public static GetPurchaseOrderInfoJSRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetPurchaseOrderInfoJSRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetPurchaseOrderInfoJSRep> arrayGetPurchaseOrderInfoJSRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetPurchaseOrderInfoJSRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetPurchaseOrderInfoJSRep> arrayGetPurchaseOrderInfoJSRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetPurchaseOrderInfoJSRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

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

    public String getMCODE() {
        return MCODE;
    }

    public void setMCODE(String MCODE) {
        this.MCODE = MCODE;
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

    public float getInStorage() {
        return inStorage;
    }

    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }

    public String getAUFNR() {
        return AUFNR;
    }

    public void setAUFNR(String AUFNR) {
        this.AUFNR = AUFNR;
    }

    public String getSBDKZ() {
        return SBDKZ;
    }

    public void setSBDKZ(String SBDKZ) {
        this.SBDKZ = SBDKZ;
    }

    public String getPMATN() {
        return PMATN;
    }

    public void setPMATN(String PMATN) {
        this.PMATN = PMATN;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
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

    public List<GetOutsourcingExceptionTypeJSRep.GetOutsourcingExceptionTypeJSRepBean> getReasonList() {
        return reasonList;
    }

    public void setReasonList(List<GetOutsourcingExceptionTypeJSRep.GetOutsourcingExceptionTypeJSRepBean> reasonList) {
        this.reasonList = reasonList;
    }
}
