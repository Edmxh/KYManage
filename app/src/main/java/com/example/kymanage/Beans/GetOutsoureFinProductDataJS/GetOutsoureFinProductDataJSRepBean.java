package com.example.kymanage.Beans.GetOutsoureFinProductDataJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetOutsoureFinProductDataJSRepBean {

    /**
     * Description : 安装座
     * MarketOrderNO :
     * DemandFactory : 2090
     * StorageId : 221
     * ReverseHandler :
     * AdvanceStorageId : 588
     * DemandStorage : 2900
     * MaterialType : 独立
     * OrderType : 20
     * MblnrRow : 0001
     * Qty : 1
     * MarketOrderRow :
     * OutsourcingType : 外协成品
     * MoreQty : 0
     * Mjahr : 2020
     * Status : 105
     * Describe : 105已入库
     * PurchaseOrderRow : 00010
     * Messa : S
     * CreateTime : 1592982501523
     * Handler : pliu
     * Mblnr : 5000149496
     * PostingDate : 1592928000000
     * UpdateTime : 1592982501523
     * MaterialCode : LJ1510000078-A01
     * DocumentDate : 1592928000000
     * PurchaseOrderNO : 4800000042
     */

    private String Description;
    private String MarketOrderNO;
    private String DemandFactory;
    private long StorageId;
    private String ReverseHandler;
    private long AdvanceStorageId;
    private String DemandStorage;
    private String MaterialType;
    private String OrderType;
    private String MblnrRow;
    private float Qty;
    private String MarketOrderRow;
    private String OutsourcingType;
    private float MoreQty;
    private String Mjahr;
    private String Status;
    private String Describe;
    private String PurchaseOrderRow;
    private String Messa;
    private String CreateTime;
    private String Handler;
    private String Mblnr;
    private String PostingDate;
    private String UpdateTime;
    private String MaterialCode;
    private String DocumentDate;
    private String PurchaseOrderNO;

    public static GetOutsoureFinProductDataJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsoureFinProductDataJSRepBean.class);
    }

    public static GetOutsoureFinProductDataJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsoureFinProductDataJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsoureFinProductDataJSRepBean> arrayGetOutsoureFinProductDataJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsoureFinProductDataJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsoureFinProductDataJSRepBean> arrayGetOutsoureFinProductDataJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsoureFinProductDataJSRepBean>>() {
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

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }

    public long getStorageId() {
        return StorageId;
    }

    public void setStorageId(long StorageId) {
        this.StorageId = StorageId;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String ReverseHandler) {
        this.ReverseHandler = ReverseHandler;
    }

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long AdvanceStorageId) {
        this.AdvanceStorageId = AdvanceStorageId;
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

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }

    public String getMblnrRow() {
        return MblnrRow;
    }

    public void setMblnrRow(String MblnrRow) {
        this.MblnrRow = MblnrRow;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String MarketOrderRow) {
        this.MarketOrderRow = MarketOrderRow;
    }

    public String getOutsourcingType() {
        return OutsourcingType;
    }

    public void setOutsourcingType(String OutsourcingType) {
        this.OutsourcingType = OutsourcingType;
    }

    public float getMoreQty() {
        return MoreQty;
    }

    public void setMoreQty(float MoreQty) {
        this.MoreQty = MoreQty;
    }

    public String getMjahr() {
        return Mjahr;
    }

    public void setMjahr(String Mjahr) {
        this.Mjahr = Mjahr;
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

    public String getPurchaseOrderRow() {
        return PurchaseOrderRow;
    }

    public void setPurchaseOrderRow(String PurchaseOrderRow) {
        this.PurchaseOrderRow = PurchaseOrderRow;
    }

    public String getMessa() {
        return Messa;
    }

    public void setMessa(String Messa) {
        this.Messa = Messa;
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

    public String getMblnr() {
        return Mblnr;
    }

    public void setMblnr(String Mblnr) {
        this.Mblnr = Mblnr;
    }

    public String getPostingDate() {
        return PostingDate;
    }

    public void setPostingDate(String PostingDate) {
        this.PostingDate = PostingDate;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String MaterialCode) {
        this.MaterialCode = MaterialCode;
    }

    public String getDocumentDate() {
        return DocumentDate;
    }

    public void setDocumentDate(String DocumentDate) {
        this.DocumentDate = DocumentDate;
    }

    public String getPurchaseOrderNO() {
        return PurchaseOrderNO;
    }

    public void setPurchaseOrderNO(String PurchaseOrderNO) {
        this.PurchaseOrderNO = PurchaseOrderNO;
    }
}
