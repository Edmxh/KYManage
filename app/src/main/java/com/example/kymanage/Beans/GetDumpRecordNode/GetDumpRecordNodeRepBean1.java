package com.example.kymanage.Beans.GetDumpRecordNode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetDumpRecordNodeRepBean1 {

    /**
     * MaterialDesc : 测试20200601
     * TQty : 988.0
     * Num : 1.0
     * Qty : 1
     * MaterialCode : LJ7015001194
     */

    private String MaterialDesc;
    private float TQty;
    private int Num;
    private float Qty;
    private String MaterialCode;

    public static GetDumpRecordNodeRepBean1 objectFromData(String str) {

        return new Gson().fromJson(str, GetDumpRecordNodeRepBean1.class);
    }

    public static GetDumpRecordNodeRepBean1 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetDumpRecordNodeRepBean1.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetDumpRecordNodeRepBean1> arrayGetDumpRecordNodeRepBean1FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetDumpRecordNodeRepBean1>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetDumpRecordNodeRepBean1> arrayGetDumpRecordNodeRepBean1FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetDumpRecordNodeRepBean1>>() {
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

    public float getTQty() {
        return TQty;
    }

    public void setTQty(float TQty) {
        this.TQty = TQty;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
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
}
