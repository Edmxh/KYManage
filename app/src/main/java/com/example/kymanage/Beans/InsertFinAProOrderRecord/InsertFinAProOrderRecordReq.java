package com.example.kymanage.Beans.InsertFinAProOrderRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InsertFinAProOrderRecordReq {

    /**
     * MaterialCode : LJ5525003029-TZ2010041014
     * MaterialType : 专有物料
     * MaterialDesc : 板
     * Qty : 2
     * Handler : xmao
     * Factory : 2090
     * FID : 163
     * sdata : [{"DemandQty":120,"AlreadyQty":90,"AllocatedQty":2,"Factory":"2010","MaterialCode":"LJ5525003029","ProductOrderNO":"000010048077","MaterialDesc":"板","MarketOrderNO":"0010000208","MarketOrderRow":"000013","Storage":"2100","ProductOrderReservedNO":"0000095024","ProductOrderReservedRowNO":"0005","ProductOrderDesc":"","ProOMaterialNO":"ZJ9310000007","ProOMaterialDesc":"集中控制系统","ProOMaterialUnit":"EA","Unit":"EA","RecordType":"1","MCode":"001"}]
     */
    //
    private String MaterialCode;
    private String MaterialType;
    private String MaterialDesc;
    private float Qty;
    private String Handler;
    private String Factory;
    private long FID;
    private List<InsertFinAProOrderRecordReqBean> sdata;

    public InsertFinAProOrderRecordReq(String materialCode, String materialType, String materialDesc, float qty, String handler, String factory, long FID, List<InsertFinAProOrderRecordReqBean> sdata) {
        MaterialCode = materialCode;
        MaterialType = materialType;
        MaterialDesc = materialDesc;
        Qty = qty;
        Handler = handler;
        Factory = factory;
        this.FID = FID;
        this.sdata = sdata;
    }

    public static InsertFinAProOrderRecordReq objectFromData(String str) {

        return new Gson().fromJson(str, InsertFinAProOrderRecordReq.class);
    }

    public static InsertFinAProOrderRecordReq objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertFinAProOrderRecordReq.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertFinAProOrderRecordReq> arrayInsertFinAProOrderRecordReqFromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordReq>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertFinAProOrderRecordReq> arrayInsertFinAProOrderRecordReqFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordReq>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }
    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }
    @JSONField(name = "MaterialType")
    public String getMaterialType() {
        return MaterialType;
    }
    @JSONField(name = "MaterialType")
    public void setMaterialType(String MaterialType) {
        this.MaterialType = MaterialType;
    }
    @JSONField(name = "MaterialDesc")
    public String getMaterialDesc() {
        return MaterialDesc;
    }
    @JSONField(name = "MaterialDesc")
    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }
    @JSONField(name = "Qty")
    public float getQty() {
        return Qty;
    }
    @JSONField(name = "Qty")
    public void setQty(float Qty) {
        this.Qty = Qty;
    }
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String Handler) {
        this.Handler = Handler;
    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name = "Factory")
    public void setFactory(String Factory) {
        this.Factory = Factory;
    }
    @JSONField(name = "FID")
    public long getFID() {
        return FID;
    }
    @JSONField(name = "FID")
    public void setFID(long FID) {
        this.FID = FID;
    }
    @JSONField(name = "sdata")
    public List<InsertFinAProOrderRecordReqBean> getSdata() {
        return sdata;
    }
    @JSONField(name = "sdata")
    public void setSdata(List<InsertFinAProOrderRecordReqBean> sdata) {
        this.sdata = sdata;
    }

    public static class InsertFinAProOrderRecordReqBean {
        /**
         * DemandQty : 120
         * AlreadyQty : 90
         * AllocatedQty : 2
         * Factory : 2010
         * MaterialCode : LJ5525003029
         * ProductOrderNO : 000010048077
         * MaterialDesc : 板
         * MarketOrderNO : 0010000208
         * MarketOrderRow : 000013
         * Storage : 2100
         * ProductOrderReservedNO : 0000095024
         * ProductOrderReservedRowNO : 0005
         * ProductOrderDesc :
         * ProOMaterialNO : ZJ9310000007
         * ProOMaterialDesc : 集中控制系统
         * ProOMaterialUnit : EA
         * Unit : EA
         * RecordType : 1
         * MCode : 001
         */

        private float DemandQty;
        private float AlreadyQty;
        private float AllocatedQty;
        private String Factory;
        private String MaterialCode;
        private String ProductOrderNO;
        private String MaterialDesc;
        private String MarketOrderNO;
        private String MarketOrderRow;
        private String Storage;
        private String ProductOrderReservedNO;
        private String ProductOrderReservedRowNO;
        private String ProductOrderDesc;
        private String ProOMaterialNO;
        private String ProOMaterialDesc;
        private String ProOMaterialUnit;
        private String Unit;
        private String RecordType;
        private String MCode;
        private String PlanOrderNO;
        private String OrderType;
        private String Sobkz;
        private String Lgpbz;

        public InsertFinAProOrderRecordReqBean(float demandQty, float alreadyQty, float allocatedQty, String factory, String materialCode, String productOrderNO, String materialDesc, String marketOrderNO, String marketOrderRow, String storage, String productOrderReservedNO, String productOrderReservedRowNO, String productOrderDesc, String proOMaterialNO, String proOMaterialDesc, String proOMaterialUnit, String unit, String recordType, String MCode, String planOrderNO, String orderType, String sobkz, String lgpbz) {
            DemandQty = demandQty;
            AlreadyQty = alreadyQty;
            AllocatedQty = allocatedQty;
            Factory = factory;
            MaterialCode = materialCode;
            ProductOrderNO = productOrderNO;
            MaterialDesc = materialDesc;
            MarketOrderNO = marketOrderNO;
            MarketOrderRow = marketOrderRow;
            Storage = storage;
            ProductOrderReservedNO = productOrderReservedNO;
            ProductOrderReservedRowNO = productOrderReservedRowNO;
            ProductOrderDesc = productOrderDesc;
            ProOMaterialNO = proOMaterialNO;
            ProOMaterialDesc = proOMaterialDesc;
            ProOMaterialUnit = proOMaterialUnit;
            Unit = unit;
            RecordType = recordType;
            this.MCode = MCode;
            PlanOrderNO = planOrderNO;
            OrderType = orderType;
            Sobkz = sobkz;
            Lgpbz = lgpbz;
        }

        public static InsertFinAProOrderRecordReqBean objectFromData(String str) {

            return new Gson().fromJson(str, InsertFinAProOrderRecordReqBean.class);
        }

        public static InsertFinAProOrderRecordReqBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), InsertFinAProOrderRecordReqBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<InsertFinAProOrderRecordReqBean> arrayInsertFinAProOrderRecordReqBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordReqBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<InsertFinAProOrderRecordReqBean> arrayInsertFinAProOrderRecordReqBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordReqBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        @JSONField(name = "DemandQty")
        public float getDemandQty() {
            return DemandQty;
        }
        @JSONField(name = "DemandQty")
        public void setDemandQty(float DemandQty) {
            this.DemandQty = DemandQty;
        }
        @JSONField(name = "AlreadyQty")
        public float getAlreadyQty() {
            return AlreadyQty;
        }
        @JSONField(name = "AlreadyQty")
        public void setAlreadyQty(float AlreadyQty) {
            this.AlreadyQty = AlreadyQty;
        }
        @JSONField(name = "AllocatedQty")
        public float getAllocatedQty() {
            return AllocatedQty;
        }
        @JSONField(name = "AllocatedQty")
        public void setAllocatedQty(float AllocatedQty) {
            this.AllocatedQty = AllocatedQty;
        }
        @JSONField(name = "Factory")
        public String getFactory() {
            return Factory;
        }
        @JSONField(name = "Factory")
        public void setFactory(String Factory) {
            this.Factory = Factory;
        }
        @JSONField(name = "MaterialCode")
        public String getMaterialCode() {
            return MaterialCode;
        }
        @JSONField(name = "MaterialCode")
        public void setMaterialCode(String MaterialCode) {
            this.MaterialCode = MaterialCode;
        }
        @JSONField(name = "ProductOrderNO")
        public String getProductOrderNO() {
            return ProductOrderNO;
        }
        @JSONField(name = "ProductOrderNO")
        public void setProductOrderNO(String ProductOrderNO) {
            this.ProductOrderNO = ProductOrderNO;
        }
        @JSONField(name = "MaterialDesc")
        public String getMaterialDesc() {
            return MaterialDesc;
        }
        @JSONField(name = "MaterialDesc")
        public void setMaterialDesc(String MaterialDesc) {
            this.MaterialDesc = MaterialDesc;
        }
        @JSONField(name = "MarketOrderNO")
        public String getMarketOrderNO() {
            return MarketOrderNO;
        }
        @JSONField(name = "MarketOrderNO")
        public void setMarketOrderNO(String MarketOrderNO) {
            this.MarketOrderNO = MarketOrderNO;
        }
        @JSONField(name = "MarketOrderRow")
        public String getMarketOrderRow() {
            return MarketOrderRow;
        }
        @JSONField(name = "MarketOrderRow")
        public void setMarketOrderRow(String MarketOrderRow) {
            this.MarketOrderRow = MarketOrderRow;
        }
        @JSONField(name = "Storage")
        public String getStorage() {
            return Storage;
        }
        @JSONField(name = "Storage")
        public void setStorage(String Storage) {
            this.Storage = Storage;
        }
        @JSONField(name = "ProductOrderReservedNO")
        public String getProductOrderReservedNO() {
            return ProductOrderReservedNO;
        }
        @JSONField(name = "ProductOrderReservedNO")
        public void setProductOrderReservedNO(String ProductOrderReservedNO) {
            this.ProductOrderReservedNO = ProductOrderReservedNO;
        }
        @JSONField(name = "ProductOrderReservedRowNO")
        public String getProductOrderReservedRowNO() {
            return ProductOrderReservedRowNO;
        }
        @JSONField(name = "ProductOrderReservedRowNO")
        public void setProductOrderReservedRowNO(String ProductOrderReservedRowNO) {
            this.ProductOrderReservedRowNO = ProductOrderReservedRowNO;
        }
        @JSONField(name = "ProductOrderDesc")
        public String getProductOrderDesc() {
            return ProductOrderDesc;
        }
        @JSONField(name = "ProductOrderDesc")
        public void setProductOrderDesc(String ProductOrderDesc) {
            this.ProductOrderDesc = ProductOrderDesc;
        }
        @JSONField(name = "ProOMaterialNO")
        public String getProOMaterialNO() {
            return ProOMaterialNO;
        }
        @JSONField(name = "ProOMaterialNO")
        public void setProOMaterialNO(String ProOMaterialNO) {
            this.ProOMaterialNO = ProOMaterialNO;
        }
        @JSONField(name = "ProOMaterialDesc")
        public String getProOMaterialDesc() {
            return ProOMaterialDesc;
        }
        @JSONField(name = "ProOMaterialDesc")
        public void setProOMaterialDesc(String ProOMaterialDesc) {
            this.ProOMaterialDesc = ProOMaterialDesc;
        }
        @JSONField(name = "ProOMaterialUnit")
        public String getProOMaterialUnit() {
            return ProOMaterialUnit;
        }
        @JSONField(name = "ProOMaterialUnit")
        public void setProOMaterialUnit(String ProOMaterialUnit) {
            this.ProOMaterialUnit = ProOMaterialUnit;
        }
        @JSONField(name = "Unit")
        public String getUnit() {
            return Unit;
        }
        @JSONField(name = "Unit")
        public void setUnit(String Unit) {
            this.Unit = Unit;
        }
        @JSONField(name = "RecordType")
        public String getRecordType() {
            return RecordType;
        }
        @JSONField(name = "RecordType")
        public void setRecordType(String RecordType) {
            this.RecordType = RecordType;
        }
        @JSONField(name = "MCode")
        public String getMCode() {
            return MCode;
        }
        @JSONField(name = "MCode")
        public void setMCode(String MCode) {
            this.MCode = MCode;
        }

        @JSONField(name = "PlanOrderNO")
        public String getPlanOrderNO() {
            return PlanOrderNO;
        }
        @JSONField(name = "PlanOrderNO")
        public void setPlanOrderNO(String planOrderNO) {
            PlanOrderNO = planOrderNO;
        }
        @JSONField(name = "OrderType")
        public String getOrderType() {
            return OrderType;
        }
        @JSONField(name = "OrderType")
        public void setOrderType(String orderType) {
            OrderType = orderType;
        }
        @JSONField(name = "Sobkz")
        public String getSobkz() {
            return Sobkz;
        }
        @JSONField(name = "Sobkz")
        public void setSobkz(String sobkz) {
            Sobkz = sobkz;
        }
        @JSONField(name = "Lgpbz")
        public String getLgpbz() {
            return Lgpbz;
        }
        @JSONField(name = "Lgpbz")
        public void setLgpbz(String lgpbz) {
            Lgpbz = lgpbz;
        }
    }
}
