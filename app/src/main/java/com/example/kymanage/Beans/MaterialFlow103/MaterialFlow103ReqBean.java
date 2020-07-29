package com.example.kymanage.Beans.MaterialFlow103;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * {{
 *             "po": "4100029758",
 *             "poLine": "00040",
 *             "factory": "2010",
 *             "materialCode": "BZ1510100048",
 *             "materialType": "专有",
 *             "materialDesc": "深沟球轴承/GB/T276-6312",
 *             "recNum": 1,
 *             "unit": "EA",
 *             "remark": "",
 *             "SeparateLabel": true,
 *             "LGPRO": "2100"
 *         }
 */
public class MaterialFlow103ReqBean {


    /**
     * po : 4100029758
     * poLine : 00040
     * factory : 2010
     * materialCode : BZ1510100048
     * materialType : 专有
     * materialDesc : 深沟球轴承/GB/T276-6312
     * recNum : 1
     * unit : EA
     * remark :
     * SeparateLabel : true
     * LGPRO : 2100
     */

    private String po;
    private String poLine;
    private String factory;
    private String materialCode;
    private String materialType;
    private String materialDesc;
    private float recNum;
    private String unit;
    private String remark;
    private boolean SeparateLabel;
    private String LGFSB;

    private String LGPBE;
    private String LOGGR;

    private float demand;
    private float inStorage;

    public MaterialFlow103ReqBean(String po, String poLine, String factory, String materialCode, String materialType, String materialDesc, float recNum, String unit, String remark, boolean separateLabel, String LGFSB, String LGPBE, String LOGGR, float demand, float inStorage) {
        this.po = po;
        this.poLine = poLine;
        this.factory = factory;
        this.materialCode = materialCode;
        this.materialType = materialType;
        this.materialDesc = materialDesc;
        this.recNum = recNum;
        this.unit = unit;
        this.remark = remark;
        SeparateLabel = separateLabel;
        this.LGFSB = LGFSB;
        this.LGPBE = LGPBE;
        this.LOGGR = LOGGR;
        this.demand = demand;
        this.inStorage = inStorage;
    }

    public MaterialFlow103ReqBean() {
    }



    public static MaterialFlow103ReqBean objectFromData(String str) {

        return new Gson().fromJson(str, MaterialFlow103ReqBean.class);
    }

    public static MaterialFlow103ReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), MaterialFlow103ReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<MaterialFlow103ReqBean> arrayMaterialFlow103ReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<MaterialFlow103ReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<MaterialFlow103ReqBean> arrayMaterialFlow103ReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<MaterialFlow103ReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getPoLine() {
        return poLine;
    }

    public void setPoLine(String poLine) {
        this.poLine = poLine;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public float getRecNum() {
        return recNum;
    }

    public void setRecNum(float recNum) {
        this.recNum = recNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @JSONField(name = "SeparateLabel")
    public boolean isSeparateLabel() {
        return SeparateLabel;
    }
    @JSONField(name = "SeparateLabel")
    public void setSeparateLabel(boolean SeparateLabel) {
        this.SeparateLabel = SeparateLabel;
    }
    @JSONField(name = "LGFSB")
    public String getLGFSB() {
        return LGFSB;
    }
    @JSONField(name = "LGFSB")
    public void setLGFSB(String LGFSB) {
        this.LGFSB = LGFSB;
    }

    @JSONField(name = "LGPBE")
    public String getLGPBE() {
        return LGPBE;
    }
    @JSONField(name = "LGPBE")
    public void setLGPBE(String LGPBE) {
        this.LGPBE = LGPBE;
    }
    @JSONField(name = "LOGGR")
    public String getLOGGR() {
        return LOGGR;
    }
    @JSONField(name = "LOGGR")
    public void setLOGGR(String LOGGR) {
        this.LOGGR = LOGGR;
    }
    @JSONField(name = "demand")
    public float getDemand() {
        return demand;
    }
    @JSONField(name = "demand")
    public void setDemand(float demand) {
        this.demand = demand;
    }
    @JSONField(name = "inStorage")
    public float getInStorage() {
        return inStorage;
    }
    @JSONField(name = "inStorage")
    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }
}
