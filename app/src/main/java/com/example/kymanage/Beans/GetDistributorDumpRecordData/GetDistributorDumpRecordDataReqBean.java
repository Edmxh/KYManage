package com.example.kymanage.Beans.GetDistributorDumpRecordData;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDistributorDumpRecordDataReqBean {

    /**
     * curdate : 2020-09-23
     * Handler : wx2090
     * MaterialCode :
     * ProductOrderNO :
     */

    private String curdate;
    private String Handler;
    private String MaterialCode;
    private String MarketOrderNO;

    public GetDistributorDumpRecordDataReqBean(String curdate, String handler, String materialCode, String marketOrderNO) {
        this.curdate = curdate;
        Handler = handler;
        MaterialCode = materialCode;
        MarketOrderNO = marketOrderNO;
    }

    public static GetDistributorDumpRecordDataReqBean objectFromData(String str) {

        return new Gson().fromJson(str, GetDistributorDumpRecordDataReqBean.class);
    }

    public static GetDistributorDumpRecordDataReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDistributorDumpRecordDataReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDistributorDumpRecordDataReqBean> arrayGetDistributorDumpRecordDataReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDistributorDumpRecordDataReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDistributorDumpRecordDataReqBean> arrayGetDistributorDumpRecordDataReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDistributorDumpRecordDataReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "curdate")
    public String getCurdate() {
        return curdate;
    }
    @JSONField(name = "curdate")
    public void setCurdate(String curdate) {
        this.curdate = curdate;
    }
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String Handler) {
        this.Handler = Handler;
    }
    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    @JSONField(name = "MarketOrderNO")
    public String getMarketOrderNO() {
        return MarketOrderNO;
    }
    @JSONField(name = "MarketOrderNO")
    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }
}
