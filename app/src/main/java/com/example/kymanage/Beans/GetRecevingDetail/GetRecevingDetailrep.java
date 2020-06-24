package com.example.kymanage.Beans.GetRecevingDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetRecevingDetailrep implements Serializable {

    /**
     * factory : 2010
     * LGPRO : 2100
     * code : BZ1020100008
     * materialType : 非专有
     * orderNum : 4100011740
     * description : 内六角圆柱头螺钉/GB/T70.1-M3×25
     * remark :
     * LGFSB : 2100
     * currentQty : 0
     * demand : 500
     * unit : EA
     * SBDKZ : 2
     * row : 00030
     * KINDS : de
     * inStorageQty : 500.0
     * LABOR : 002
     */

    private String factory;
    private String LGPRO;
    private String code;
    private String materialType;
    private String orderNum;
    private String description;
    private String remark;
    private String LGFSB;
    private float currentQty;
    private float demand;
    private String unit;
    private String SBDKZ;
    private String row;
    private String KINDS;
    private float inStorageQty;
    private String LABOR;

    public static GetRecevingDetailrep objectFromData(String str) {

        return new Gson().fromJson(str, GetRecevingDetailrep.class);
    }

    public static GetRecevingDetailrep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetRecevingDetailrep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetRecevingDetailrep> arrayGetRecevingDetailrepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetRecevingDetailrep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetRecevingDetailrep> arrayGetRecevingDetailrepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetRecevingDetailrep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getLGPRO() {
        return LGPRO;
    }

    public void setLGPRO(String LGPRO) {
        this.LGPRO = LGPRO;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLGFSB() {
        return LGFSB;
    }

    public void setLGFSB(String LGFSB) {
        this.LGFSB = LGFSB;
    }

    public float getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(float currentQty) {
        this.currentQty = currentQty;
    }

    public float getDemand() {
        return demand;
    }

    public void setDemand(float demand) {
        this.demand = demand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSBDKZ() {
        return SBDKZ;
    }

    public void setSBDKZ(String SBDKZ) {
        this.SBDKZ = SBDKZ;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getKINDS() {
        return KINDS;
    }

    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
    }

    public float getInStorageQty() {
        return inStorageQty;
    }

    public void setInStorageQty(float inStorageQty) {
        this.inStorageQty = inStorageQty;
    }

    public String getLABOR() {
        return LABOR;
    }

    public void setLABOR(String LABOR) {
        this.LABOR = LABOR;
    }
}
