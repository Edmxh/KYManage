package com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Semi_FinishedProductReceivingRecordJSRepBean {

    /**
     * MarketOrderNO : 0010000374
     * DemandFactory : 2090
     * MCode :
     * Unit : EA
     * AdvanceStorageId : 3309
     * DemandStorage : 2906
     * MaterialType :
     * MaterialDesc : 夹紧块0.5|CuCrZr
     * OrderType : 1
     * Qty : 0
     * id : 153
     * MarketOrderRow : 000010
     * OutsourcingType : 外协半成品
     * MoreQty : 0
     * ProductOrder : 000010116009
     * Describe : 101成品入库
     * Mjahr : 2020
     * Status : 101
     * PurchaseOrderRow : 00030
     * Messa : S
     * CreateTime : 2020-09-04 01:04:15
     * Handler : pliu
     * Documentdate : 2020-09-04
     * Type : 外协半成品入库
     * PostingDate : 2020-09-04
     * UpdateTime : 2020-09-04 01:04:15
     * MaterialCode : LJ4525002454
     * PurchaseOrderNO : 4300000787
     */

    private String MarketOrderNO;
    private String DemandFactory;
    private String MCode;
    private String Unit;
    private long AdvanceStorageId;
    private String DemandStorage;
    private String MaterialType;
    private String MaterialDesc;
    private String OrderType;
    private float Qty;
    private long id;
    private String MarketOrderRow;
    private String OutsourcingType;
    private float MoreQty;
    private String ProductOrder;
    private String Describe;
    private String Mjahr;
    private String Status;
    private String PurchaseOrderRow;
    private String Messa;
    private String CreateTime;
    private String Handler;
    private String Documentdate;
    private String Type;
    private String PostingDate;
    private String UpdateTime;
    private String MaterialCode;
    private String PurchaseOrderNO;
    private String ReverseHandler;

    public static Semi_FinishedProductReceivingRecordJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, Semi_FinishedProductReceivingRecordJSRepBean.class);
    }

    public static Semi_FinishedProductReceivingRecordJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), Semi_FinishedProductReceivingRecordJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Semi_FinishedProductReceivingRecordJSRepBean> arraySemi_FinishedProductReceivingRecordJSRepBeanFromData(String str) {

        java.lang.reflect.Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingRecordJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<Semi_FinishedProductReceivingRecordJSRepBean> arraySemi_FinishedProductReceivingRecordJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Semi_FinishedProductReceivingRecordJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


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

    public String getMCode() {
        return MCode;
    }

    public void setMCode(String MCode) {
        this.MCode = MCode;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
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

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String MaterialDesc) {
        this.MaterialDesc = MaterialDesc;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String OrderType) {
        this.OrderType = OrderType;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getProductOrder() {
        return ProductOrder;
    }

    public void setProductOrder(String ProductOrder) {
        this.ProductOrder = ProductOrder;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
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

    public String getDocumentdate() {
        return Documentdate;
    }

    public void setDocumentdate(String Documentdate) {
        this.Documentdate = Documentdate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
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

    public String getPurchaseOrderNO() {
        return PurchaseOrderNO;
    }

    public void setPurchaseOrderNO(String PurchaseOrderNO) {
        this.PurchaseOrderNO = PurchaseOrderNO;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }


}
