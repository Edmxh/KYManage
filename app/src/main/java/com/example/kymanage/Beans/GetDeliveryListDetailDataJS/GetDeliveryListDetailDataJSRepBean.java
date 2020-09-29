package com.example.kymanage.Beans.GetDeliveryListDetailDataJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDeliveryListDetailDataJSRepBean {


    /**
     * DeliveryListRow : 000010
     * MarketOrderNO : 0000004112
     * Message : 交货过账成功！|创建交货单成功！|
     * CreateTime : 1600876800000
     * DeliveryListNO : 0080011760
     * Code : S
     * MaterialDesc : 辅助支撑箱体
     * ClientNO : PZD20080101
     * WorkNO : TG-EA
     * Qty : 0
     * ID : 75.0
     * MaterialCode : PXL0108000008-TZ201004FAH2
     * MarketOrderRow : 000230
     */

    private String DeliveryListRow;
    private String MarketOrderNO;
    private String Message;
    private long CreateTime;
    private String DeliveryListNO;
    private String Code;
    private String MaterialDesc;
    private String ClientNO;
    private String WorkNO;
    private float Qty;
    private long ID;
    private String MaterialCode;
    private String MarketOrderRow;

    public static GetDeliveryListDetailDataJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetDeliveryListDetailDataJSRepBean.class);
    }

    public static GetDeliveryListDetailDataJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDeliveryListDetailDataJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDeliveryListDetailDataJSRepBean> arrayGetDeliveryListDetailDataJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDeliveryListDetailDataJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDeliveryListDetailDataJSRepBean> arrayGetDeliveryListDetailDataJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDeliveryListDetailDataJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDeliveryListRow() {
        return DeliveryListRow;
    }

    public void setDeliveryListRow(String DeliveryListRow) {
        this.DeliveryListRow = DeliveryListRow;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getDeliveryListNO() {
        return DeliveryListNO;
    }

    public void setDeliveryListNO(String DeliveryListNO) {
        this.DeliveryListNO = DeliveryListNO;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getClientNO() {
        return ClientNO;
    }

    public void setClientNO(String ClientNO) {
        this.ClientNO = ClientNO;
    }

    public String getWorkNO() {
        return WorkNO;
    }

    public void setWorkNO(String WorkNO) {
        this.WorkNO = WorkNO;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
}
