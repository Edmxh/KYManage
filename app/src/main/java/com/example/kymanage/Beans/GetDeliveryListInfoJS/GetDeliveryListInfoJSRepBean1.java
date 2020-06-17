package com.example.kymanage.Beans.GetDeliveryListInfoJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDeliveryListInfoJSRepBean1 {

    /**
     * VBELN : 0000002107
     * MESSAGE : 交货数量大于所需数量 1 EA对象类型 OutboundDelivery 没有被创建的实例. 外部参考:没有选择标准的交货凭证没有选择标准的交货凭证|交货数量大于所需数量 1 EA对象类型 OutboundDelivery 没有被创建的实例. 外部参考:没有选择标准的交货凭证|交货数量大于所需数量 1 EA对象类型 OutboundDelivery 没有被创建的实例. 外部参考:|
     * STATUS : E
     * ZZGZBH : YA-TY3309
     * POSNR_VL : 000000
     * ARKTX : 调整垫片
     * KWMENG : 2.000
     * POSNR : 000030
     * BSTKD : PZD19092901
     * NAME_ORG1 : 唐山松下产业机器有限公司
     * VBELN_VL :
     * MATNR : PLJ0304000834
     */

    private String VBELN;
    private String MESSAGE;
    private String STATUS;
    private String ZZGZBH;
    private String POSNR_VL;
    private String ARKTX;
    private float KWMENG;
    private String POSNR;
    private String BSTKD;
    private String NAME_ORG1;
    private String VBELN_VL;
    private String MATNR;

    public static GetDeliveryListInfoJSRepBean1 objectFromData(String str) {

        return new Gson().fromJson(str, GetDeliveryListInfoJSRepBean1.class);
    }

    public static GetDeliveryListInfoJSRepBean1 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDeliveryListInfoJSRepBean1.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDeliveryListInfoJSRepBean1> arrayGetDeliveryListInfoJSRepBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDeliveryListInfoJSRepBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDeliveryListInfoJSRepBean1> arrayGetDeliveryListInfoJSRepBean1FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDeliveryListInfoJSRepBean1>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getVBELN() {
        return VBELN;
    }

    public void setVBELN(String VBELN) {
        this.VBELN = VBELN;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getZZGZBH() {
        return ZZGZBH;
    }

    public void setZZGZBH(String ZZGZBH) {
        this.ZZGZBH = ZZGZBH;
    }

    public String getPOSNR_VL() {
        return POSNR_VL;
    }

    public void setPOSNR_VL(String POSNR_VL) {
        this.POSNR_VL = POSNR_VL;
    }

    public String getARKTX() {
        return ARKTX;
    }

    public void setARKTX(String ARKTX) {
        this.ARKTX = ARKTX;
    }

    public float getKWMENG() {
        return KWMENG;
    }

    public void setKWMENG(float KWMENG) {
        this.KWMENG = KWMENG;
    }

    public String getPOSNR() {
        return POSNR;
    }

    public void setPOSNR(String POSNR) {
        this.POSNR = POSNR;
    }

    public String getBSTKD() {
        return BSTKD;
    }

    public void setBSTKD(String BSTKD) {
        this.BSTKD = BSTKD;
    }

    public String getNAME_ORG1() {
        return NAME_ORG1;
    }

    public void setNAME_ORG1(String NAME_ORG1) {
        this.NAME_ORG1 = NAME_ORG1;
    }

    public String getVBELN_VL() {
        return VBELN_VL;
    }

    public void setVBELN_VL(String VBELN_VL) {
        this.VBELN_VL = VBELN_VL;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
}
