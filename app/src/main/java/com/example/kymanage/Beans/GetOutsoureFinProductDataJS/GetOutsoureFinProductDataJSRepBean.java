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
     * MarketOrderNO : 0000003683
     * Description : 管线护套45|丁晴橡胶
     * DemandFactory : 2090
     * Unit : EA
     * StorageId : 576
     * ReverseHandler :
     * DemandStorage : 2906
     * AdvanceStorageId : 3404
     * MaterialType : 独立
     * OrderType : 10
     * Qty : 1
     * ID : 0
     * MarketOrderRow : 000040
     * OutsourcingType : 外协成品
     * MoreQty : 0
     * Describe : 105已入库
     * Status : 105
     * Path : 103,105
     * PurchaseOrderRow : 00040
     * CreateTime : 2020-09-08 10:09:26
     * Handler : xmao
     * PostingDate : 2020-09-08
     * UpdateTime : 2020-09-08 10:09:26
     * MaterialCode : LJ7015000968
     * DocumentDate : 2020-09-08
     * PurchaseOrderNO : 4800002301
     */

    private String MarketOrderNO;
    private String Description;
    private String DemandFactory;
    private String Factory;
    private String Unit;
    private long StorageId;
    private String ReverseHandler;
    private String DemandStorage;
    private long AdvanceStorageId;
    private String MaterialType;
    private String OrderType;
    private float Qty;
    private long ID;
    private String MarketOrderRow;
    private String OutsourcingType;
    private float MoreQty;
    private String Describe;
    private String Status;
    private String Path;
    private String PurchaseOrderRow;
    private String CreateTime;
    private String Handler;
    private String PostingDate;
    private String UpdateTime;
    private String MaterialCode;
    private String DocumentDate;
    private String PurchaseOrderNO;

    private String allocatedId;

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

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String DemandFactory) {
        this.DemandFactory = DemandFactory;
    }

    public String getFactory() {
        return Factory;
    }

    public void setFactory(String factory) {
        Factory = factory;
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

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long AdvanceStorageId) {
        this.AdvanceStorageId = AdvanceStorageId;
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

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String Describe) {
        this.Describe = Describe;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
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

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String Handler) {
        this.Handler = Handler;
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

    public String getAllocatedId() {
        return allocatedId;
    }

    public void setAllocatedId(String allocatedId) {
        this.allocatedId = allocatedId;
    }
}
