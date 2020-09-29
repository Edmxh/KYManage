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
     * data : [{"DeliverID":"16006732949884","Status":"","MarketOrderNO":"0010000432","DemandQty":60,"CreateTime":"2020-09-24 15:47:09","IssueStorage":"2912","ReverseHandler":"","Handler":"","ActuallyQty":4,"ProductMaterialCode":"LJ5565000267-A01","ProductNO":"000010144050","MaterialDesc":"小角架","UpdateTime":"2020-09-24 15:47:12","MaterialUnit":"EA","DispatchListNO":"16006724734475","Client":"2030","MaterialCode":"LJ5565000267-A01","MarketOrderRow":"000030"}]
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
         * DeliverID : 16006732949884
         * Status :
         * MarketOrderNO : 0010000432
         * DemandQty : 60.0
         * CreateTime : 2020-09-24 15:47:09
         * IssueStorage : 2912
         * ReverseHandler :
         * Handler :
         * ActuallyQty : 4.0
         * ProductMaterialCode : LJ5565000267-A01
         * ProductNO : 000010144050
         * MaterialDesc : 小角架
         * UpdateTime : 2020-09-24 15:47:12
         * MaterialUnit : EA
         * DispatchListNO : 16006724734475
         * Client : 2030
         * MaterialCode : LJ5565000267-A01
         * MarketOrderRow : 000030
         */

        private String DeliverID;
        private String Status;
        private String MarketOrderNO;
        private float DemandQty;
        private String CreateTime;
        private String IssueStorage;
        private String ReverseHandler;
        private String Handler;
        private float ActuallyQty;
        private String ProductMaterialCode;
        private String ProductNO;
        private String MaterialDesc;
        private String UpdateTime;
        private String MaterialUnit;
        private String DispatchListNO;
        private String Client;
        private String MaterialCode;
        private String MarketOrderRow;

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

        public float getDemandQty() {
            return DemandQty;
        }

        public void setDemandQty(float DemandQty) {
            this.DemandQty = DemandQty;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getIssueStorage() {
            return IssueStorage;
        }

        public void setIssueStorage(String IssueStorage) {
            this.IssueStorage = IssueStorage;
        }

        public String getReverseHandler() {
            return ReverseHandler;
        }

        public void setReverseHandler(String ReverseHandler) {
            this.ReverseHandler = ReverseHandler;
        }

        public String getHandler() {
            return Handler;
        }

        public void setHandler(String Handler) {
            this.Handler = Handler;
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

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String UpdateTime) {
            this.UpdateTime = UpdateTime;
        }

        public String getMaterialUnit() {
            return MaterialUnit;
        }

        public void setMaterialUnit(String MaterialUnit) {
            this.MaterialUnit = MaterialUnit;
        }

        public String getDispatchListNO() {
            return DispatchListNO;
        }

        public void setDispatchListNO(String DispatchListNO) {
            this.DispatchListNO = DispatchListNO;
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
    }
}
