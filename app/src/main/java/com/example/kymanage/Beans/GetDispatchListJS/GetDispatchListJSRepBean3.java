package com.example.kymanage.Beans.GetDispatchListJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDispatchListJSRepBean3 {

    /**
     * Description : 支架加工完成半成品
     * MarketOrderNO : 0010000208
     * Factory :
     * Unit : EA
     * MaterialCode : LJ2015000594-A01
     * MarketOrderRow : 000026
     * MoreQty : 99.0
     * DemandStorage : 2912
     * Remark : 外协采购半成品收货测试备注
     */

    private String Description;
    private String MarketOrderNO;
    private String Factory;
    private String Unit;
    private String MaterialCode;
    private String MarketOrderRow;
    private float MoreQty;
    private String DemandStorage;
    private String Remark;

    public static GetDispatchListJSRepBean3 objectFromData(String str) {

        return new Gson().fromJson(str, GetDispatchListJSRepBean3.class);
    }

    public static GetDispatchListJSRepBean3 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDispatchListJSRepBean3.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDispatchListJSRepBean3> arrayGetDispatchListJSRepBean3FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDispatchListJSRepBean3>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDispatchListJSRepBean3> arrayGetDispatchListJSRepBean3FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDispatchListJSRepBean3>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String Factory) {
        this.Factory = Factory;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
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

    public float getMoreQty() {
        return MoreQty;
    }

    public void setMoreQty(float MoreQty) {
        this.MoreQty = MoreQty;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String DemandStorage) {
        this.DemandStorage = DemandStorage;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }
}
