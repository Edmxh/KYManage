package com.example.kymanage.Beans.GetOutsoureFinProductDataJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetOutsoureFinProductDataJSRepBean {


    /**
     * Mjahr : 2020
     * Status : 1105
     * Describe : 入库冲销
     * Description : 支架加工完成半成品
     * MarketOrderNO : 0010000208
     * Messa : S
     * DemandFactory : 2090
     * AdvanceStorageId : 448
     * DemandStorage : 2912
     * MaterialType : 独立
     * Mblnr : 5000149202
     * OrderType : 10
     * MblnrRow : 0001
     * Qty : 4
     * UpdateTime : 1591835066962
     * ID : 147
     * MarketOrderRow : 000026
     * MaterialCode : LJ2015000594-A01
     * OutsourcingType : 外协半成品
     */

    private String Mjahr;
    private String Status;
    private String Describe;
    private String Description;
    private String MarketOrderNO;
    private String Messa;
    private String DemandFactory;
    private long AdvanceStorageId;
    private String DemandStorage;
    private String MaterialType;
    private String Mblnr;
    private String OrderType;
    private String MblnrRow;
    private float Qty;
    private String UpdateTime;
    private long ID;
    private String MarketOrderRow;
    private String MaterialCode;
    private String OutsourcingType;

    public static GetOutsoureFinProductDataJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsoureFinProductDataJSRepBean.class);
    }

    public static GetOutsoureFinProductDataJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsoureFinProductDataJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsoureFinProductDataJSRepBean> arrayGetOutsoureFinProductDataJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsoureFinProductDataJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsoureFinProductDataJSRepBean> arrayGetOutsoureFinProductDataJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsoureFinProductDataJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMjahr() {
        return Mjahr;
    }

    public void setMjahr(String Mjahr) {
        this.Mjahr = Mjahr;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
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

    public String getMessa() {
        return Messa;
    }

    public void setMessa(String Messa) {
        this.Messa = Messa;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long AdvanceStorageId) {
        this.AdvanceStorageId = AdvanceStorageId;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String DemandStorage) {
        this.DemandStorage = DemandStorage;
    }

    public String getMaterialType() {
        return MaterialType;
    }

    public void setMaterialType(String MaterialType) {
        this.MaterialType = MaterialType;
    }

    public String getMblnr() {
        return Mblnr;
    }

    public void setMblnr(String Mblnr) {
        this.Mblnr = Mblnr;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }

    public String getMblnrRow() {
        return MblnrRow;
    }

    public void setMblnrRow(String MblnrRow) {
        this.MblnrRow = MblnrRow;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getOutsourcingType() {
        return OutsourcingType;
    }

    public void setOutsourcingType(String OutsourcingType) {
        this.OutsourcingType = OutsourcingType;
    }
}
