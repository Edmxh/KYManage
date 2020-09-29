package com.example.kymanage.Beans.GetDeliveryListDataJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDeliveryListDataJSRepBean {

    /**
     * Status :
     * Desc : 已打印
     * ClientName : 唐山松下产业机器有限公司
     * Message :
     * CreateTime :
     * UpdateTime :
     * DeliveryListNO : 0080011751
     * Handler : wx2090
     * ReverseHandler :
     */

    private String Status;
    private String Desc;
    private String ClientName;
    private String Message;
    private String CreateTime;
    private String UpdateTime;
    private String DeliveryListNO;
    private String Handler;
    private String ReverseHandler;

    public static GetDeliveryListDataJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetDeliveryListDataJSRepBean.class);
    }

    public static GetDeliveryListDataJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDeliveryListDataJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDeliveryListDataJSRepBean> arrayGetDeliveryListDataJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDeliveryListDataJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDeliveryListDataJSRepBean> arrayGetDeliveryListDataJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDeliveryListDataJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
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

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
    }
}
