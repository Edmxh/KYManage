package com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetOutsourcingExceptionTypeJSRep {

    /**
     * code : 1.0
     * data : [{"Type":"质量低劣","Id":"0001"},{"Type":"不完整的","Id":"0002"},{"Type":"损坏的","Id":"0003"}]
     * message : 获取成功
     */

    private int code;
    private String message;
    private List<GetOutsourcingExceptionTypeJSRepBean> data;

    public static GetOutsourcingExceptionTypeJSRep objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsourcingExceptionTypeJSRep.class);
    }

    public static GetOutsourcingExceptionTypeJSRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsourcingExceptionTypeJSRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsourcingExceptionTypeJSRep> arrayGetOutsourcingExceptionTypeJSRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsourcingExceptionTypeJSRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsourcingExceptionTypeJSRep> arrayGetOutsourcingExceptionTypeJSRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsourcingExceptionTypeJSRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetOutsourcingExceptionTypeJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetOutsourcingExceptionTypeJSRepBean> data) {
        this.data = data;
    }

    public static class GetOutsourcingExceptionTypeJSRepBean {
        /**
         * Type : 质量低劣
         * Id : 0001
         */

        private String Type;
        private String Id;

        public static GetOutsourcingExceptionTypeJSRepBean objectFromData(String str) {

            return new Gson().fromJson(str, GetOutsourcingExceptionTypeJSRepBean.class);
        }

        public static GetOutsourcingExceptionTypeJSRepBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), GetOutsourcingExceptionTypeJSRepBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<GetOutsourcingExceptionTypeJSRepBean> arrayGetOutsourcingExceptionTypeJSRepBeanFromData(String str) {

            java.lang.reflect.Type listType = new TypeToken<ArrayList<GetOutsourcingExceptionTypeJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GetOutsourcingExceptionTypeJSRepBean> arrayGetOutsourcingExceptionTypeJSRepBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                java.lang.reflect.Type listType = new TypeToken<ArrayList<GetOutsourcingExceptionTypeJSRepBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }
    }
}
