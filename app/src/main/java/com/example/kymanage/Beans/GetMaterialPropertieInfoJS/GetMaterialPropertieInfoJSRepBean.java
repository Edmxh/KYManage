package com.example.kymanage.Beans.GetMaterialPropertieInfoJS;


import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetMaterialPropertieInfoJSRepBean {

    /**
     * factory : 2020
     * materialDesc : 十字槽盘头螺钉、平垫和弹垫组合/R9074.4-M3×12
     * materialType : 专有
     * materialCode : BZ1020341003
     * logisticsGroup : 测试后勤组
     * shelfNO : 组05B-6-05
     */

    private String factory;
    private String materialDesc;
    private String materialType;
    private String materialCode;
    private String logisticsGroup;
    private String shelfNO;
    private List<iddesBean> storage;

    private String labelSquNum;
    private float qty;

    public static GetMaterialPropertieInfoJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetMaterialPropertieInfoJSRepBean.class);
    }

    public static GetMaterialPropertieInfoJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetMaterialPropertieInfoJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetMaterialPropertieInfoJSRepBean> arrayGetMaterialPropertieInfoJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetMaterialPropertieInfoJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetMaterialPropertieInfoJSRepBean> arrayGetMaterialPropertieInfoJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetMaterialPropertieInfoJSRepBean>>() {
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

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getLogisticsGroup() {
        return logisticsGroup;
    }

    public void setLogisticsGroup(String logisticsGroup) {
        this.logisticsGroup = logisticsGroup;
    }

    public String getShelfNO() {
        return shelfNO;
    }

    public void setShelfNO(String shelfNO) {
        this.shelfNO = shelfNO;
    }

    public List<iddesBean> getStorage() {
        return storage;
    }

    public void setStorage(List<iddesBean> storage) {
        this.storage = storage;
    }

    public String getLabelSquNum() {
        return labelSquNum;
    }

    public void setLabelSquNum(String labelSquNum) {
        this.labelSquNum = labelSquNum;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }
}
