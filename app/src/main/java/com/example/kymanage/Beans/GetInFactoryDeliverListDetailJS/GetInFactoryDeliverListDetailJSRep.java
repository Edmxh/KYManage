package com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetInFactoryDeliverListDetailJSRep {

    /**
     * code : 1.0
     * data : [{"DeliverID":"15918752209265","ProductNO":"000010048078","MaterialDesc":"支架加工完成半成品","MarketOrderNO":"0010000208","DemandQty":1000,"MaterialUnit":"EA","ID":4,"Client":"工厂自动化","MaterialCode":"LJ2015000594-A01","MarketOrderRow":"000026","ActuallyQty":3,"ProductMaterialCode":"LJ2015000594-TZ2010043020"}]
     * message : 查询成功
     */

    private int code;
    private String message;
    private List<GetInFactoryDeliverListDetailJSRepBean> data;

    public static GetInFactoryDeliverListDetailJSRep objectFromData(String str) {

        return new Gson().fromJson(str, GetInFactoryDeliverListDetailJSRep.class);
    }

    public static GetInFactoryDeliverListDetailJSRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetInFactoryDeliverListDetailJSRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetInFactoryDeliverListDetailJSRep> arrayGetInFactoryDeliverListDetailJSRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListDetailJSRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetInFactoryDeliverListDetailJSRep> arrayGetInFactoryDeliverListDetailJSRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListDetailJSRep>>() {
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

    public List<GetInFactoryDeliverListDetailJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetInFactoryDeliverListDetailJSRepBean> data) {
        this.data = data;
    }

    public static class GetInFactoryDeliverListDetailJSRepBean {
        /**
         * DeliverID : 15918752209265
         * ProductNO : 000010048078
         * MaterialDesc : 支架加工完成半成品
         * MarketOrderNO : 0010000208
         * DemandQty : 1000.0
         * MaterialUnit : EA
         * ID : 4
         * Client : 工厂自动化
         * MaterialCode : LJ2015000594-A01
         * MarketOrderRow : 000026
         * ActuallyQty : 3.0
         * ProductMaterialCode : LJ2015000594-TZ2010043020
         */

        private String DeliverID;
        private String ProductNO;
        private String MaterialDesc;
        private String MarketOrderNO;
        private float DemandQty;
        private String MaterialUnit;
        private long ID;
        private String Client;
        private String MaterialCode;
        private String MarketOrderRow;
        private float ActuallyQty;
        private String ProductMaterialCode;

        public static GetInFactoryDeliverListDetailJSRepBean objectFromData(String str) {

            return new Gson().fromJson(str, GetInFactoryDeliverListDetailJSRepBean.class);
        }

        public static GetInFactoryDeliverListDetailJSRepBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), GetInFactoryDeliverListDetailJSRepBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<GetInFactoryDeliverListDetailJSRepBean> arrayGetInFactoryDeliverListDetailJSRepBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListDetailJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GetInFactoryDeliverListDetailJSRepBean> arrayGetInFactoryDeliverListDetailJSRepBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<GetInFactoryDeliverListDetailJSRepBean>>() {
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

        public String getProductNO() {
            return ProductNO;
        }

        public void setProductNO(String ProductNO) {
            this.ProductNO = ProductNO;
        }

        public String getMaterialDesc() {
            return MaterialDesc;
        }

        public void setMaterialDesc(String MaterialDesc) {
            this.MaterialDesc = MaterialDesc;
        }

        public String getMarketOrderNO() {
            return MarketOrderNO;
        }

        public void setMarketOrderNO(String MarketOrderNO) {
            this.MarketOrderNO = MarketOrderNO;
        }

        public float getDemandQty() {
            return DemandQty;
        }

        public void setDemandQty(float DemandQty) {
            this.DemandQty = DemandQty;
        }

        public String getMaterialUnit() {
            return MaterialUnit;
        }

        public void setMaterialUnit(String MaterialUnit) {
            this.MaterialUnit = MaterialUnit;
        }

        public long getID() {
            return ID;
        }

        public void setID(long ID) {
            this.ID = ID;
        }

        public String getClient() {
            return Client;
        }

        public void setClient(String Client) {
            this.Client = Client;
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

        public float getActuallyQty() {
            return ActuallyQty;
        }

        public void setActuallyQty(float ActuallyQty) {
            this.ActuallyQty = ActuallyQty;
        }

        public String getProductMaterialCode() {
            return ProductMaterialCode;
        }

        public void setProductMaterialCode(String ProductMaterialCode) {
            this.ProductMaterialCode = ProductMaterialCode;
        }
    }
}
