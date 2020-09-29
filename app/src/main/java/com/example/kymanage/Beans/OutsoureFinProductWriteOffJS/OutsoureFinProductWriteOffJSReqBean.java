package com.example.kymanage.Beans.OutsoureFinProductWriteOffJS;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OutsoureFinProductWriteOffJSReqBean {

    /**
     * Id : 425
     * OrderType : 20
     * AdvanceStorageId : 3184
     * StorageId : 3184
     */

    private String OrderType;
    private long AdvanceStorageId;
    private long StorageId;
    private String AllocatedId;

    public OutsoureFinProductWriteOffJSReqBean(String orderType, long advanceStorageId, long storageId, String allocatedId) {
        OrderType = orderType;
        AdvanceStorageId = advanceStorageId;
        StorageId = storageId;
        AllocatedId = allocatedId;
    }

    public static OutsoureFinProductWriteOffJSReqBean objectFromData(String str) {

        return new Gson().fromJson(str, OutsoureFinProductWriteOffJSReqBean.class);
    }

    public static OutsoureFinProductWriteOffJSReqBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), OutsoureFinProductWriteOffJSReqBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<OutsoureFinProductWriteOffJSReqBean> arrayOutsoureFinProductWriteOffJSReqBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<OutsoureFinProductWriteOffJSReqBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<OutsoureFinProductWriteOffJSReqBean> arrayOutsoureFinProductWriteOffJSReqBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<OutsoureFinProductWriteOffJSReqBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }
    @JSONField(name = "OrderType")
    public String getOrderType() {
        return OrderType;
    }
    @JSONField(name = "OrderType")
    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }
    @JSONField(name = "AdvanceStorageId")
    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }
    @JSONField(name = "AdvanceStorageId")
    public void setAdvanceStorageId(long AdvanceStorageId) {
        this.AdvanceStorageId = AdvanceStorageId;
    }
    @JSONField(name = "StorageId")
    public long getStorageId() {
        return StorageId;
    }
    @JSONField(name = "StorageId")
    public void setStorageId(long StorageId) {
        this.StorageId = StorageId;
    }
    @JSONField(name = "AllocatedId")
    public String getAllocatedId() {
        return AllocatedId;
    }
    @JSONField(name = "AllocatedId")
    public void setAllocatedId(String allocatedId) {
        AllocatedId = allocatedId;
    }
}
