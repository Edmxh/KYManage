package com.example.kymanage.Beans.GetCMInFactoryDeliver;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetCMInFactoryDeliverRepBean {

    /**
     * MaterialDesc : 支架加工完成半成品
     * MarketOrderNO : 0010000208
     * DemandQty : 1000.0
     * ProductOrderNO : 000010048078
     * Unit : EA
     * Client : 工厂自动化
     * MaterialCode : LJ2015000594-A01
     * MarketOrderRow : 000026
     * DispatchQty : 3.0
     * ProductMaterialCode : LJ2015000594-TZ2010043020
     */

    private String MaterialDesc;
    private String MarketOrderNO;
    private float DemandQty;
    private String ProductOrderNO;
    private String Unit;
    private String Client;
    private String MaterialCode;
    private String MarketOrderRow;
    private float DispatchQty;
    private String ProductMaterialCode;

    public static GetCMInFactoryDeliverRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetCMInFactoryDeliverRepBean.class);
    }

    public static GetCMInFactoryDeliverRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetCMInFactoryDeliverRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetCMInFactoryDeliverRepBean> arrayGetCMInFactoryDeliverRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetCMInFactoryDeliverRepBean> arrayGetCMInFactoryDeliverRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float DemandQty) {
        this.DemandQty = DemandQty;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String ProductOrderNO) {
        this.ProductOrderNO = ProductOrderNO;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String Client) {
        this.Client = Client;
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

    public float getDispatchQty() {
        return DispatchQty;
    }

    public void setDispatchQty(float DispatchQty) {
        this.DispatchQty = DispatchQty;
    }

    public String getProductMaterialCode() {
        return ProductMaterialCode;
    }

    public void setProductMaterialCode(String ProductMaterialCode) {
        this.ProductMaterialCode = ProductMaterialCode;
    }
}
