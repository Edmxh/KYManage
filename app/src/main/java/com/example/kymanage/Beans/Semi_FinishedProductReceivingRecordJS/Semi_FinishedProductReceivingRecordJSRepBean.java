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
     * Description : 支架加工完成半成品
     * MarketOrderNO : 0010000316
     * DemandFactory : 2090
     * Unit : EA
     * StorageId : 348
     * AdvanceStorageId : 3002
     * DemandStorage : 2912
     * Remark : 测试备注
     * MaterialType : 独立
     * MblnrRow : 0001
     * Qty : 1
     * ID : 37
     * MarketOrderRow : 000035
     * MoreQty : 0
     * OutsourcingType : 外协半成品
     * Mjahr : 2020
     * Status : 105
     * Describe : 105已入库
     * Messa : S
     * PurchaseOrderRow : 01970
     * CreateTime : 1595488819224
     * Handler : xmao
     * Mblnr : 5000402863
     * Type : 外协入库
     * PostingDate : 1595433600000
     * UpdateTime : 1595488819224
     * MaterialCode : LJ5540018426-A01
     * DocumentDate : 1595433600000
     * PurchaseOrderNO : 4800002219
     */

    private String Description;
    private String MarketOrderNO;
    private String DemandFactory;
    private String Unit;
    private long StorageId;
    private long AdvanceStorageId;
    private String DemandStorage;
    private String Remark;
    private String MaterialType;
    private String MblnrRow;
    private float Qty;
    private long ID;
    private String MarketOrderRow;
    private float MoreQty;
    private String OutsourcingType;
    private String Mjahr;
    private String Status;
    private String Describe;
    private String Messa;
    private String PurchaseOrderRow;
    private String CreateTime;
    private String Handler;
    private String Mblnr;
    private String Type;
    private String PostingDate;
    private String UpdateTime;
    private String MaterialCode;
    private String DocumentDate;
    private String PurchaseOrderNO;

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

    public float getMoreQty() {
        return MoreQty;
    }

    public void setMoreQty(float MoreQty) {
        this.MoreQty = MoreQty;
    }

    public String getOutsourcingType() {
        return OutsourcingType;
    }

    public void setOutsourcingType(String OutsourcingType) {
        this.OutsourcingType = OutsourcingType;
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

    public String getMessa() {
        return Messa;
    }

    public void setMessa(String Messa) {
        this.Messa = Messa;
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

    public String getMblnr() {
        return Mblnr;
    }

    public void setMblnr(String Mblnr) {
        this.Mblnr = Mblnr;
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
