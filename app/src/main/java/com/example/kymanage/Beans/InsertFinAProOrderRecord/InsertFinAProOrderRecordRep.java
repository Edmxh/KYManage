package com.example.kymanage.Beans.InsertFinAProOrderRecord;

import com.example.kymanage.Beans.StatusBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InsertFinAProOrderRecordRep {

    /**
     * data : [{"SendFactory":2090,"FType":"机加","MarketOrderNO":"0010000208","DemandQty":120,"MCode":"001","ProOMaterialNO":"ZJ9310000007","Factory":"2010","CreateDate":"2020-08-10 21:53:43","ProductOrderDesc":"","AllocatedQty":2,"MaterialDesc":"板","Area":"C09","Storage":"2100","NoteType":"内部配送","ProOMaterialDesc":"集中控制系统","SendStorage":"2900","ProductOrderNO":"000010048077","MaterialUnit":"EA","ID":8893,"ProOMaterialUnit":"EA","MarketOrderRow":"000013","MaterialCode":"LJ5525003029"}]
     * status : {"code":1,"message":"标签打印成功！"}
     */

    private StatusBean status;
    private List<InsertFinAProOrderRecord> data;

    public static InsertFinAProOrderRecordRep objectFromData(String str) {

        return new Gson().fromJson(str, InsertFinAProOrderRecordRep.class);
    }

    public static InsertFinAProOrderRecordRep objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), InsertFinAProOrderRecordRep.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<InsertFinAProOrderRecordRep> arrayInsertFinAProOrderRecordRepFromData(String str) {

        Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordRep>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<InsertFinAProOrderRecordRep> arrayInsertFinAProOrderRecordRepFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecordRep>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<InsertFinAProOrderRecord> getData() {
        return data;
    }

    public void setData(List<InsertFinAProOrderRecord> data) {
        this.data = data;
    }

    public static class InsertFinAProOrderRecord {
        /**
         * SendFactory : 2090
         * FType : 机加
         * MarketOrderNO : 0010000208
         * DemandQty : 120
         * MCode : 001
         * ProOMaterialNO : ZJ9310000007
         * Factory : 2010
         * CreateDate : 2020-08-10 21:53:43
         * ProductOrderDesc :
         * AllocatedQty : 2
         * MaterialDesc : 板
         * Area : C09
         * Storage : 2100
         * NoteType : 内部配送
         * ProOMaterialDesc : 集中控制系统
         * SendStorage : 2900
         * ProductOrderNO : 000010048077
         * MaterialUnit : EA
         * ID : 8893.0
         * ProOMaterialUnit : EA
         * MarketOrderRow : 000013
         * MaterialCode : LJ5525003029
         */

        private String SendFactory;
        private String FType;
        private String MarketOrderNO;
        private float DemandQty;
        private String MCode;
        private String ProOMaterialNO;
        private String Factory;
        private String CreateDate;
        private String ProductOrderDesc;
        private float AllocatedQty;
        private String MaterialDesc;
        private String Area;
        private String Storage;
        private String NoteType;
        private String ProOMaterialDesc;
        private String SendStorage;
        private String ProductOrderNO;
        private String MaterialUnit;
        private long ID;
        private String ProOMaterialUnit;
        private String MarketOrderRow;
        private String MaterialCode;
        private String clientNO;
        private String clientShortName;

        public static InsertFinAProOrderRecord objectFromData(String str) {

            return new Gson().fromJson(str, InsertFinAProOrderRecord.class);
        }

        public static InsertFinAProOrderRecord objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), InsertFinAProOrderRecord.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<InsertFinAProOrderRecord> arrayInsertFinAProOrderRecordFromData(String str) {

            Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecord>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<InsertFinAProOrderRecord> arrayInsertFinAProOrderRecordFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<InsertFinAProOrderRecord>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getSendFactory() {
            return SendFactory;
        }

        public void setSendFactory(String SendFactory) {
            this.SendFactory = SendFactory;
        }

        public String getFType() {
            return FType;
        }

        public void setFType(String FType) {
            this.FType = FType;
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

        public String getMCode() {
            return MCode;
        }

        public void setMCode(String MCode) {
            this.MCode = MCode;
        }

        public String getProOMaterialNO() {
            return ProOMaterialNO;
        }

        public void setProOMaterialNO(String ProOMaterialNO) {
            this.ProOMaterialNO = ProOMaterialNO;
        }

        public String getFactory() {
            return Factory;
        }

        public void setFactory(String Factory) {
            this.Factory = Factory;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getProductOrderDesc() {
            return ProductOrderDesc;
        }

        public void setProductOrderDesc(String ProductOrderDesc) {
            this.ProductOrderDesc = ProductOrderDesc;
        }

        public float getAllocatedQty() {
            return AllocatedQty;
        }

        public void setAllocatedQty(float AllocatedQty) {
            this.AllocatedQty = AllocatedQty;
        }

        public String getMaterialDesc() {
            return MaterialDesc;
        }

        public void setMaterialDesc(String MaterialDesc) {
            this.MaterialDesc = MaterialDesc;
        }

        public String getArea() {
            return Area;
        }

        public void setArea(String Area) {
            this.Area = Area;
        }

        public String getStorage() {
            return Storage;
        }

        public void setStorage(String Storage) {
            this.Storage = Storage;
        }

        public String getNoteType() {
            return NoteType;
        }

        public void setNoteType(String NoteType) {
            this.NoteType = NoteType;
        }

        public String getProOMaterialDesc() {
            return ProOMaterialDesc;
        }

        public void setProOMaterialDesc(String ProOMaterialDesc) {
            this.ProOMaterialDesc = ProOMaterialDesc;
        }

        public String getSendStorage() {
            return SendStorage;
        }

        public void setSendStorage(String SendStorage) {
            this.SendStorage = SendStorage;
        }

        public String getProductOrderNO() {
            return ProductOrderNO;
        }

        public void setProductOrderNO(String ProductOrderNO) {
            this.ProductOrderNO = ProductOrderNO;
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

        public String getProOMaterialUnit() {
            return ProOMaterialUnit;
        }

        public void setProOMaterialUnit(String ProOMaterialUnit) {
            this.ProOMaterialUnit = ProOMaterialUnit;
        }

        public String getMarketOrderRow() {
            return MarketOrderRow;
        }

        public void setMarketOrderRow(String MarketOrderRow) {
            this.MarketOrderRow = MarketOrderRow;
        }

        public String getMaterialCode() {
            return MaterialCode;
        }

        public void setMaterialCode(String MaterialCode) {
            this.MaterialCode = MaterialCode;
        }

        public String getClientNO() {
            return clientNO;
        }

        public void setClientNO(String clientNO) {
            this.clientNO = clientNO;
        }

        public String getClientShortName() {
            return clientShortName;
        }

        public void setClientShortName(String clientShortName) {
            this.clientShortName = clientShortName;
        }
    }
}
