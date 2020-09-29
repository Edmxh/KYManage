package com.example.kymanage.Beans.GetLableStorageInfoJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetLableStorageInfoJSRep {

    /**
     * SendFactory : 2090
     * MaterialDesc : EA
     * code : 1.0
     * SendStorage : 2906
     * MaterialUnit :
     * message : 查询成功
     * MaterialCode : LJ7015000033
     */

    private String SendFactory;
    private String MaterialDesc;
    private int code;
    private String SendStorage;
    private String MaterialUnit;
    private String message;
    private String MaterialCode;

    public static GetLableStorageInfoJSRep objectFromData(String str) {

        return new Gson().fromJson(str, GetLableStorageInfoJSRep.class);
    }

    public static GetLableStorageInfoJSRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetLableStorageInfoJSRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetLableStorageInfoJSRep> arrayGetLableStorageInfoJSRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetLableStorageInfoJSRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetLableStorageInfoJSRep> arrayGetLableStorageInfoJSRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetLableStorageInfoJSRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getSendFactory() {
        return SendFactory;
    }

    public void setSendFactory(String SendFactory) {
        this.SendFactory = SendFactory;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSendStorage() {
        return SendStorage;
    }

    public void setSendStorage(String SendStorage) {
        this.SendStorage = SendStorage;
    }

    public String getMaterialUnit() {
        return MaterialUnit;
    }

    public void setMaterialUnit(String MaterialUnit) {
        this.MaterialUnit = MaterialUnit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
}
