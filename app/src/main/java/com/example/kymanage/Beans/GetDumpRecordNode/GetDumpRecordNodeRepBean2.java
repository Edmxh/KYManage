package com.example.kymanage.Beans.GetDumpRecordNode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDumpRecordNodeRepBean2 {

    /**
     * DumpNum : 202006161520162
     * factory : 2010
     * Area : A11
     * MarketOrderNO : 0010000208
     * Handler : kzheng
     * ProductOrderNO : 10048077
     * SumCount : 1.0
     * MaterialCode : ZJ6025011857
     * MarketOrderRow : 000026
     */

    private String DumpNum;
    private String factory;
    private String Area;
    private String MarketOrderNO;
    private String Handler;
    private String ProductOrderNO;
    private float SumCount;
    private String MaterialCode;
    private String MarketOrderRow;
    private List<GetDumpRecordNodeRepBean1> data;

    public static GetDumpRecordNodeRepBean2 objectFromData(String str) {

        return new Gson().fromJson(str, GetDumpRecordNodeRepBean2.class);
    }

    public static GetDumpRecordNodeRepBean2 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDumpRecordNodeRepBean2.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDumpRecordNodeRepBean2> arrayGetDumpRecordNodeRepBean2FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDumpRecordNodeRepBean2>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDumpRecordNodeRepBean2> arrayGetDumpRecordNodeRepBean2FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDumpRecordNodeRepBean2>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDumpNum() {
        return DumpNum;
    }

    public void setDumpNum(String DumpNum) {
        this.DumpNum = DumpNum;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }

    public float getSumCount() {
        return SumCount;
    }

    public void setSumCount(float SumCount) {
        this.SumCount = SumCount;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }

    public List<GetDumpRecordNodeRepBean1> getData() {
        return data;
    }

    public void setData(List<GetDumpRecordNodeRepBean1> data) {
        this.data = data;
    }
}
