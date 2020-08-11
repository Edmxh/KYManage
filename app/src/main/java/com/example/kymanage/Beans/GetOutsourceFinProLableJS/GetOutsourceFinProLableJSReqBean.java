package com.example.kymanage.Beans.GetOutsourceFinProLableJS;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * {
 *            "id": 1,
 *            "orderType": "10",
 *            "AdvanceStorageId":1
 *          }
 */
public class GetOutsourceFinProLableJSReqBean {

    /**
     * storageId : 440
     * orderType : 20
     * advanceStorageId : 3199
     * Factory : 2010
     */

    private long storageId;
    private String orderType;
    private long advanceStorageId;
    private String Factory;


    public GetOutsourceFinProLableJSReqBean(long storageId, String orderType, long advanceStorageId, String factory) {
        this.storageId = storageId;
        this.orderType = orderType;
        this.advanceStorageId = advanceStorageId;
        Factory = factory;
    }

    public static GetOutsourceFinProLableJSReqBean objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsourceFinProLableJSReqBean.class);
    }

    public static GetOutsourceFinProLableJSReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsourceFinProLableJSReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsourceFinProLableJSReqBean> arrayGetOutsourceFinProLableJSReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsourceFinProLableJSReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsourceFinProLableJSReqBean> arrayGetOutsourceFinProLableJSReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsourceFinProLableJSReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }
    @JSONField(name = "storageId")
    public long getStorageId() {
        return storageId;
    }
    @JSONField(name = "storageId")
    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }
    @JSONField(name = "orderType")
    public String getOrderType() {
        return orderType;
    }
    @JSONField(name = "orderType")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    @JSONField(name = "advanceStorageId")
    public long getAdvanceStorageId() {
        return advanceStorageId;
    }
    @JSONField(name = "advanceStorageId")
    public void setAdvanceStorageId(long advanceStorageId) {
        this.advanceStorageId = advanceStorageId;
    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }

    @JSONField(name = "Factory")
    public void setFactory(String Factory) {
        this.Factory = Factory;
    }
}
