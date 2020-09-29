package com.example.kymanage.Beans.GetOutsoureExceptionRecordJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetOutsoureExceptionRecordJSRep {

    /**
     * code : 1.0
     * data : [{"Status":"103","Describe":"103预入库","Description":"","MarketOrderNO":"10000310","PurchaseOrderRow":"00030","CreateTime":"2020-09-09 09:15:48","ReasonDesc":"","Handler":"xmao","Factory":"2090","Unit":"EA","Reason":"","Remark":"","MaterialType":"","OrderType":"3","PostingDate":"2020-09-09","Qty":1,"UpdateTime":"2020-09-09 09:15:48","DocumentDate":"2020-09-09","MaterialCode":"","MarketOrderRow":"10","PurchaseOrderNO":"4300000790"}]
     * message : 查询成功
     */

    private int code;
    private String message;
    private List<GetOutsoureExceptionRecordJSRepBean> data;

    public static GetOutsoureExceptionRecordJSRep objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsoureExceptionRecordJSRep.class);
    }

    public static GetOutsoureExceptionRecordJSRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsoureExceptionRecordJSRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsoureExceptionRecordJSRep> arrayGetOutsoureExceptionRecordJSRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsoureExceptionRecordJSRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsoureExceptionRecordJSRep> arrayGetOutsoureExceptionRecordJSRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsoureExceptionRecordJSRep>>() {
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

    public List<GetOutsoureExceptionRecordJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetOutsoureExceptionRecordJSRepBean> data) {
        this.data = data;
    }

    public static class GetOutsoureExceptionRecordJSRepBean {
        /**
         * Status : 103
         * Describe : 103预入库
         * Description :
         * MarketOrderNO : 10000310
         * PurchaseOrderRow : 00030
         * CreateTime : 2020-09-09 09:15:48
         * ReasonDesc :
         * Handler : xmao
         * Factory : 2090
         * Unit : EA
         * Reason :
         * Remark :
         * MaterialType :
         * OrderType : 3
         * PostingDate : 2020-09-09
         * Qty : 1.0
         * UpdateTime : 2020-09-09 09:15:48
         * DocumentDate : 2020-09-09
         * MaterialCode :
         * MarketOrderRow : 10
         * PurchaseOrderNO : 4300000790
         */

        private String Status;
        private String Describe;
        private String Description;
        private String MarketOrderNO;
        private String PurchaseOrderRow;
        private String CreateTime;
        private String ReasonDesc;
        private String Handler;
        private String Factory;
        private String Unit;
        private String Reason;
        private String Remark;
        private String MaterialType;
        private String OrderType;
        private String PostingDate;
        private float Qty;
        private String UpdateTime;
        private String DocumentDate;
        private String MaterialCode;
        private String MarketOrderRow;
        private String PurchaseOrderNO;

        public static GetOutsoureExceptionRecordJSRepBean objectFromData(String str) {

            return new Gson().fromJson(str, GetOutsoureExceptionRecordJSRepBean.class);
        }

        public static GetOutsoureExceptionRecordJSRepBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), GetOutsoureExceptionRecordJSRepBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<GetOutsoureExceptionRecordJSRepBean> arrayGetOutsoureExceptionRecordJSFromData(String str) {

            Type listType = new TypeToken<ArrayList<GetOutsoureExceptionRecordJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<GetOutsoureExceptionRecordJSRepBean> arrayGetOutsoureExceptionRecordJSFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<GetOutsoureExceptionRecordJSRepBean>>() {
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

        public String getDescribe() {
            return Describe;
        }

        public void setDescribe(String Describe) {
            this.Describe = Describe;
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

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getReasonDesc() {
            return ReasonDesc;
        }

        public void setReasonDesc(String ReasonDesc) {
            this.ReasonDesc = ReasonDesc;
        }

        public String getHandler() {
            return Handler;
        }

        public void setHandler(String Handler) {
            this.Handler = Handler;
        }

        public String getFactory() {
            return Factory;
        }

        public void setFactory(String Factory) {
            this.Factory = Factory;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getMaterialType() {
            return MaterialType;
        }

        public void setMaterialType(String MaterialType) {
            this.MaterialType = MaterialType;
        }

        public String getOrderType() {
            return OrderType;
        }

        public void setOrderType(String OrderType) {
            this.OrderType = OrderType;
        }

        public String getPostingDate() {
            return PostingDate;
        }

        public void setPostingDate(String PostingDate) {
            this.PostingDate = PostingDate;
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

        public String getDocumentDate() {
            return DocumentDate;
        }

        public void setDocumentDate(String DocumentDate) {
            this.DocumentDate = DocumentDate;
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

        public String getPurchaseOrderNO() {
            return PurchaseOrderNO;
        }

        public void setPurchaseOrderNO(String PurchaseOrderNO) {
            this.PurchaseOrderNO = PurchaseOrderNO;
        }
    }
}
