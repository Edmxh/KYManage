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
     * DeliveryListRow : 000000
     * MarketOrderNO : 0000002107
     * Message : 交货数量大于所需数量 1 EA对象类型 OutboundDelivery 没有被创建的实例. 外部参考:|交货数量大于所需数量 1 EA对象类型 OutboundDelivery 没有被创建的实例. 外部参考:|
     * CreateTime : 1591804800000
     * DeliveryListNO :
     * Handler : pliu
     * Code : E
     * Name : 刘鹏
     * MaterialDesc : 调整垫片
     * ClientName : 唐山松下产业机器有限公司
     * ClientNO : PZD19092901
     * WorkNO : YA-TY3309
     * Qty : 2
     * MaterialCode : PLJ0304000834
     * MarketOrderRow : 000030
     */

    private String DeliveryListRow;
    private String MarketOrderNO;
    private String Message;
    private long CreateTime;
    private String DeliveryListNO;
    private String Handler;
    private String Code;
    private String Name;
    private String MaterialDesc;
    private String ClientName;
    private String ClientNO;
    private String WorkNO;
    private float Qty;
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

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
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
