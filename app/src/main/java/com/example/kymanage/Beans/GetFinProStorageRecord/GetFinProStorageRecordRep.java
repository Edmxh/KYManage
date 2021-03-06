package com.example.kymanage.Beans.GetFinProStorageRecord;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetFinProStorageRecordRep {

    /**
     * Status : 101已入库
     * MarketOrderNO : 10000425
     * DemandFactory : 2090
     * CreateTime : 2020-09-17 08:13:07
     * Handler : xmao
     * Unit : EA
     * ReverseHandler :
     * DemandStorage : 2906
     * MaterialType : 独立
     * MaterialDesc : 支座|组焊件
     * ReceiveType : 机加入库
     * Qty : 6.0
     * UpdateTime : 2020-09-17 08:13:07
     * ID : 264.0
     * MaterialCode : LJ5530031545-TZ2010047038
     * MarketOrderRow : 16
     * datajson : [{"Status":"101","Qty":6,"ProductOrderNO":"000010138566"}]
     */

    private String Status;
    private String MarketOrderNO;
    private String DemandFactory;
    private String CreateTime;
    private String Handler;
    private String Unit;
    private String ReverseHandler;
    private String DemandStorage;
    private String MaterialType;
    private String MaterialDesc;
    private String ReceiveType;
    private float Qty;
    private String UpdateTime;
    private long ID;
    private String MaterialCode;
    private String MarketOrderRow;
    private List<DatajsonBean> datajson;

    public static GetFinProStorageRecordRep objectFromData(String str) {

        return new Gson().fromJson(str, GetFinProStorageRecordRep.class);
    }

    public static GetFinProStorageRecordRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetFinProStorageRecordRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetFinProStorageRecordRep> arrayGetFinProStorageRecordRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetFinProStorageRecordRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetFinProStorageRecordRep> arrayGetFinProStorageRecordRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetFinProStorageRecordRep>>() {
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

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String DemandStorage) {
        this.DemandStorage = DemandStorage;
    }

    public String getMaterialType() {
        return MaterialType;
    }

    public void setMaterialType(String MaterialType) {
        this.MaterialType = MaterialType;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getReceiveType() {
        return ReceiveType;
    }

    public void setReceiveType(String ReceiveType) {
        this.ReceiveType = ReceiveType;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public List<DatajsonBean> getDatajson() {
        return datajson;
    }

    public void setDatajson(List<DatajsonBean> datajson) {
        this.datajson = datajson;
    }

    public static class DatajsonBean {
        /**
         * Status : 101
         * Qty : 6
         * ProductOrderNO : 000010138566
         */

        private String Status;
        private float Qty;
        private String ProductOrderNO;

        public static DatajsonBean objectFromData(String str) {

            return new Gson().fromJson(str, DatajsonBean.class);
        }

        public static DatajsonBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DatajsonBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DatajsonBean> arrayDatajsonBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DatajsonBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DatajsonBean> arrayDatajsonBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DatajsonBean>>() {
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

        public float getQty() {
            return Qty;
        }

        public void setQty(float Qty) {
            this.Qty = Qty;
        }

        public String getProductOrderNO() {
            return ProductOrderNO;
        }

        public void setProductOrderNO(String ProductOrderNO) {
            this.ProductOrderNO = ProductOrderNO;
        }
    }
}
