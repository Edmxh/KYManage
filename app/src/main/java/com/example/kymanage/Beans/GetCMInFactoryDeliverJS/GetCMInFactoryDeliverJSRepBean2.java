package com.example.kymanage.Beans.GetCMInFactoryDeliverJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetCMInFactoryDeliverJSRepBean2 {

    /**
     * DeliverID : 15941031602134
     * data : [{"DeliverID":"15941031602134","ProductNO":"000010117706","MaterialDesc":"焊枪电机检测架加工完成半成品","MarketOrderNO":"0010000397","DemandQty":8,"MaterialUnit":"EA","ID":51,"Client":"阻焊","MaterialCode":"LJ6510001463-A01","MarketOrderRow":"000018","ActuallyQty":1,"ProductMaterialCode":"LJ6510001463-TZ4020100000"}]
     * CreateTime : 2020-07-07 02:07:43
     * CreateUser : xmao
     * IssueStorage : 半成品库
     */

    private String DeliverID;
    private String CreateTime;
    private String CreateUser;
    private String IssueStorage;
    private List<GetCMInFactoryDeliverJSRepBean1> data;

    public static GetCMInFactoryDeliverJSRepBean2 objectFromData(String str) {

        return new Gson().fromJson(str, GetCMInFactoryDeliverJSRepBean2.class);
    }

    public static GetCMInFactoryDeliverJSRepBean2 objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetCMInFactoryDeliverJSRepBean2.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetCMInFactoryDeliverJSRepBean2> arrayGetCMInFactoryDeliverJSRepBean2FromData(String str) {

        Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverJSRepBean2>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetCMInFactoryDeliverJSRepBean2> arrayGetCMInFactoryDeliverJSRepBean2FromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverJSRepBean2>>() {
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

    public List<GetCMInFactoryDeliverJSRepBean1> getData() {
        return data;
    }

    public void setData(List<GetCMInFactoryDeliverJSRepBean1> data) {
        this.data = data;
    }

    public static class GetCMInFactoryDeliverJSRepBean1 {
        /**
         * DeliverID : 15941031602134
         * ProductNO : 000010117706
         * MaterialDesc : 焊枪电机检测架加工完成半成品
         * MarketOrderNO : 0010000397
         * DemandQty : 8.0
         * MaterialUnit : EA
         * ID : 51
         * Client : 阻焊
         * MaterialCode : LJ6510001463-A01
         * MarketOrderRow : 000018
         * ActuallyQty : 1.0
         * ProductMaterialCode : LJ6510001463-TZ4020100000
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

        public static GetCMInFactoryDeliverJSRepBean1 objectFromData(String str) {

            return new Gson().fromJson(str, GetCMInFactoryDeliverJSRepBean1.class);
        }

        public static GetCMInFactoryDeliverJSRepBean1 objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), GetCMInFactoryDeliverJSRepBean1.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<GetCMInFactoryDeliverJSRepBean1> arrayGetCMInFactoryDeliverJSRepBean1FromData(String str) {

            Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverJSRepBean1>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GetCMInFactoryDeliverJSRepBean1> arrayGetCMInFactoryDeliverJSRepBean1FromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<GetCMInFactoryDeliverJSRepBean1>>() {
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
