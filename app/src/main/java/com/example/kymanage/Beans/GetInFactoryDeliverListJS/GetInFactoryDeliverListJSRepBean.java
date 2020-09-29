package com.example.kymanage.Beans.GetInFactoryDeliverListJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetInFactoryDeliverListJSRepBean {

    /**
     * DeliverID : 15918752209265
     * CreateTime : 2020-06-11 11:06:11
     * CreateUser : pliu
     * IssueStorage : 半成品库
     */

    private String DeliverID;
    private String CreateTime;
    private String UpdateTime;
    private String CreateUser;
    private String IssueStorage;
    private String Status;
    private int Sign;
    private String ReverseHandler;

    public static GetInFactoryDeliverListJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetInFactoryDeliverListJSRepBean.class);
    }

    public static GetInFactoryDeliverListJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetInFactoryDeliverListJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetInFactoryDeliverListJSRepBean> arrayGetInFactoryDeliverListJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetInFactoryDeliverListJSRepBean> arrayGetInFactoryDeliverListJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getDeliverID() {
        return DeliverID;
    }

    public void setDeliverID(String DeliverID) {
        this.DeliverID = DeliverID;
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

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String CreateUser) {
        this.CreateUser = CreateUser;
    }

    public String getIssueStorage() {
        return IssueStorage;
    }

    public void setIssueStorage(String IssueStorage) {
        this.IssueStorage = IssueStorage;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getSign() {
        return Sign;
    }

    public void setSign(int sign) {
        Sign = sign;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }
}
