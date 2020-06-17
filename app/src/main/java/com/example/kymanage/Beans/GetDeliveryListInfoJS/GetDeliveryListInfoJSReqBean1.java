package com.example.kymanage.Beans.GetDeliveryListInfoJS;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 *             "MATNR": "PLJ0304000860-TZ405001FAH2",
 *             "VBELN": "0000002107",
 *             "POSNR": "000040",
 *             "KWMENG": 2,
 *             "LGORT": "2906"
 *         }
 */
public class GetDeliveryListInfoJSReqBean1 {
    private String MATNR;
    private String VBELN;
    private String POSNR;
    private float KWMENG;
    private String LGORT;

    public GetDeliveryListInfoJSReqBean1() {
    }

    public GetDeliveryListInfoJSReqBean1(String MATNR, String VBELN, String POSNR, float KWMENG, String LGORT) {
        this.MATNR = MATNR;
        this.VBELN = VBELN;
        this.POSNR = POSNR;
        this.KWMENG = KWMENG;
        this.LGORT = LGORT;
    }
    @JSONField(name = "MATNR")
    public String getMATNR() {
        return MATNR;
    }
    @JSONField(name = "MATNR")
    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }
    @JSONField(name = "VBELN")
    public String getVBELN() {
        return VBELN;
    }
    @JSONField(name = "VBELN")
    public void setVBELN(String VBELN) {
        this.VBELN = VBELN;
    }
    @JSONField(name = "POSNR")
    public String getPOSNR() {
        return POSNR;
    }
    @JSONField(name = "POSNR")
    public void setPOSNR(String POSNR) {
        this.POSNR = POSNR;
    }
    @JSONField(name = "KWMENG")
    public float getKWMENG() {
        return KWMENG;
    }
    @JSONField(name = "KWMENG")
    public void setKWMENG(float KWMENG) {
        this.KWMENG = KWMENG;
    }
    @JSONField(name = "LGORT")
    public String getLGORT() {
        return LGORT;
    }
    @JSONField(name = "LGORT")
    public void setLGORT(String LGORT) {
        this.LGORT = LGORT;
    }
}
