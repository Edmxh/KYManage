package com.example.kymanage.Beans.Semi_FinishedProductReceivingLable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Semi_FinishedProductReceivingLableRep {

    /**
     * code : 0.0
     * data : [{"Description":"橙色高压天然气管|内径Φ6/OG","MarketOrderNO":"","PurchaseOrderRow":"00010","MCode":"","DemandFactory":"2010","Unit":"M","StorageId":462,"DemandStorage":"2100","Qty":1,"company":"TKAS","MaterialCode":"QD6020000015","MarketOrderRow":"","ProductOrder":"","PurchaseOrderNO":"4100030201","printTime":"","printFactory":"CM"}]
     * message : 服务器内部错误
     */

    private int code;
    private String message;
    private List<Semi_FinishedProductReceivingLableRepBean> data;

    public static Semi_FinishedProductReceivingLableRep objectFromData(String str) {

        return new Gson().fromJson(str, Semi_FinishedProductReceivingLableRep.class);
    }

    public static Semi_FinishedProductReceivingLableRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Semi_FinishedProductReceivingLableRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Semi_FinishedProductReceivingLableRep> arraySemi_FinishedProductReceivingLableRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingLableRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Semi_FinishedProductReceivingLableRep> arraySemi_FinishedProductReceivingLableRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingLableRep>>() {
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

    public List<Semi_FinishedProductReceivingLableRepBean> getData() {
        return data;
    }

    public void setData(List<Semi_FinishedProductReceivingLableRepBean> data) {
        this.data = data;
    }

    public static class Semi_FinishedProductReceivingLableRepBean {
        /**
         * Description : 橙色高压天然气管|内径Φ6/OG
         * MarketOrderNO :
         * PurchaseOrderRow : 00010
         * MCode :
         * DemandFactory : 2010
         * Unit : M
         * StorageId : 462
         * DemandStorage : 2100
         * Qty : 1.0
         * company : TKAS
         * MaterialCode : QD6020000015
         * MarketOrderRow :
         * ProductOrder :
         * PurchaseOrderNO : 4100030201
         * printTime :
         * printFactory : CM
         */

        private String Description;
        private String MarketOrderNO;
        private String PurchaseOrderRow;
        private String MCode;
        private String DemandFactory;
        private String Unit;
        private long StorageId;
        private String DemandStorage;
        private float Qty;
        private String company;
        private String MaterialCode;
        private String MarketOrderRow;
        private String ProductOrder;
        private String PurchaseOrderNO;
        private String printTime;
        private String printFactory;

        public static Semi_FinishedProductReceivingLableRepBean objectFromData(String str) {

            return new Gson().fromJson(str, Semi_FinishedProductReceivingLableRepBean.class);
        }

        public static Semi_FinishedProductReceivingLableRepBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), Semi_FinishedProductReceivingLableRepBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<Semi_FinishedProductReceivingLableRepBean> arraySemi_FinishedProductReceivingLableRepBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingLableRepBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<Semi_FinishedProductReceivingLableRepBean> arraySemi_FinishedProductReceivingLableRepBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingLableRepBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public String getMarketOrderNO() {
            return MarketOrderNO;
        }

        public void setMarketOrderNO(String MarketOrderNO) {
            this.MarketOrderNO = MarketOrderNO;
        }

        public String getPurchaseOrderRow() {
            return PurchaseOrderRow;
        }

        public void setPurchaseOrderRow(String PurchaseOrderRow) {
            this.PurchaseOrderRow = PurchaseOrderRow;
        }

        public String getMCode() {
            return MCode;
        }

        public void setMCode(String MCode) {
            this.MCode = MCode;
        }

        public String getDemandFactory() {
            return DemandFactory;
        }

        public void setDemandFactory(String DemandFactory) {
            this.DemandFactory = DemandFactory;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public long getStorageId() {
            return StorageId;
        }

        public void setStorageId(long StorageId) {
            this.StorageId = StorageId;
        }

        public String getDemandStorage() {
            return DemandStorage;
        }

        public void setDemandStorage(String DemandStorage) {
            this.DemandStorage = DemandStorage;
        }

        public float getQty() {
            return Qty;
        }

        public void setQty(float Qty) {
            this.Qty = Qty;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
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

        public String getProductOrder() {
            return ProductOrder;
        }

        public void setProductOrder(String ProductOrder) {
            this.ProductOrder = ProductOrder;
        }

        public String getPurchaseOrderNO() {
            return PurchaseOrderNO;
        }

        public void setPurchaseOrderNO(String PurchaseOrderNO) {
            this.PurchaseOrderNO = PurchaseOrderNO;
        }

        public String getPrintTime() {
            return printTime;
        }

        public void setPrintTime(String printTime) {
            this.printTime = printTime;
        }

        public String getPrintFactory() {
            return printFactory;
        }

        public void setPrintFactory(String printFactory) {
            this.printFactory = printFactory;
        }
    }
}
