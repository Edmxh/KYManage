package com.example.kymanage.Beans.GetMarketOrderNoByCode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetMarketOrderNoByCodeRepBean {

    /**
     * LABST : 4
     * WERKS : 2090
     * LGORT : 2906
     * WMENG : 1
     * MATRN : BZ1045100057
     * YJHSL : 1
     * KDAUF : 0015400006
     * KDPOS : 000013
     */

    private float LABST;
    private String WERKS;
    private String LGORT;
    private float WMENG;
    private String MATRN;
    private float YJHSL;
    private String KDAUF;
    private String KDPOS;
    private float waitNum;
    private boolean change;

    public static GetMarketOrderNoByCodeRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetMarketOrderNoByCodeRepBean.class);
    }

    public static GetMarketOrderNoByCodeRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetMarketOrderNoByCodeRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetMarketOrderNoByCodeRepBean> arrayGetMarketOrderNoByCodeRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetMarketOrderNoByCodeRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetMarketOrderNoByCodeRepBean> arrayGetMarketOrderNoByCodeRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetMarketOrderNoByCodeRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public float getLABST() {
        return LABST;
    }

    public void setLABST(float LABST) {
        this.LABST = LABST;
    }

    public String getWERKS() {
        return WERKS;
    }

    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }

    public String getLGORT() {
        return LGORT;
    }

    public void setLGORT(String LGORT) {
        this.LGORT = LGORT;
    }

    public float getWMENG() {
        return WMENG;
    }

    public void setWMENG(float WMENG) {
        this.WMENG = WMENG;
    }

    public String getMATRN() {
        return MATRN;
    }

    public void setMATRN(String MATRN) {
        this.MATRN = MATRN;
    }

    public float getYJHSL() {
        return YJHSL;
    }

    public void setYJHSL(float YJHSL) {
        this.YJHSL = YJHSL;
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

    public float getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(float waitNum) {
        this.waitNum = waitNum;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }
}
