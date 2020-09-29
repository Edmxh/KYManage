package com.example.kymanage.Beans.WriteOffMaterialFactoryCDump;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WriteOffMaterialFactoryCDumpReq {

    /**
     * handler : xmao
     * PID : 210
     * data : [{"ID":97},{"ID":98}]
     */

    private String handler;
    private long PID;
    private List<DataBean> data;

    public WriteOffMaterialFactoryCDumpReq(String handler, long PID, List<DataBean> data) {
        this.handler = handler;
        this.PID = PID;
        this.data = data;
    }

    public static WriteOffMaterialFactoryCDumpReq objectFromData(String str) {

        return new Gson().fromJson(str, WriteOffMaterialFactoryCDumpReq.class);
    }

    public static WriteOffMaterialFactoryCDumpReq objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), WriteOffMaterialFactoryCDumpReq.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<WriteOffMaterialFactoryCDumpReq> arrayWriteOffMaterialFactoryCDumpReqFromData(String str) {

        Type listType = new TypeToken<ArrayList<WriteOffMaterialFactoryCDumpReq>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<WriteOffMaterialFactoryCDumpReq> arrayWriteOffMaterialFactoryCDumpReqFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<WriteOffMaterialFactoryCDumpReq>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
    @JSONField(name = "PID")
    public long getPID() {
        return PID;
    }
    @JSONField(name = "PID")
    public void setPID(long PID) {
        this.PID = PID;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ID : 97
         */

        private long ID;

        public DataBean(long ID) {
            this.ID = ID;
        }

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        @JSONField(name = "ID")
        public long getID() {
            return ID;
        }
        @JSONField(name = "ID")
        public void setID(long ID) {
            this.ID = ID;
        }
    }
}
