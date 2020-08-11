package com.example.kymanage.Beans.GetTransferRecord;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetTransferRecordRepBean2 {

    /**
     * Status : 已冲销
     * CreateTime : 2020-08-01 15:57:02
     * UpdateTime : 2020-08-01 16:23:18
     * Handler : xmao
     * ProductOrderNO : 000010048077
     * ReverseHandler :
     */

    private String Status;
    private String CreateTime;
    private String UpdateTime;
    private String Handler;
    private String ProductOrderNO;
    private String ReverseHandler;

    public static GetTransferRecordRepBean2 objectFromData(String str) {

        return new Gson().fromJson(str, GetTransferRecordRepBean2.class);
    }

    public static GetTransferRecordRepBean2 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetTransferRecordRepBean2.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetTransferRecordRepBean2> arrayGetTransferRecordRepBean2FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetTransferRecordRepBean2>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetTransferRecordRepBean2> arrayGetTransferRecordRepBean2FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetTransferRecordRepBean2>>() {
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

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
    }
}
