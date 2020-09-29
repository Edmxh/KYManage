package com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetPreRecMaterialCodeInfoJSRepBean {

    /**
     * LogisticsGroup :
     * Description : 锥面垫圈/GB/T850-12
     * PurchaseOrderRow : 00320
     * CreateTime : 1601102255641
     * DemandFactory : 2010
     * Unit : EA
     * Remark :
     * MaterialType : 集中
     * Assigner : pliu
     * ShelfNO :
     * Qty : 64.0
     * MaterialCode : BZ1030820004
     * PurchaseOrderNO : 4100035008
     */

    private String LogisticsGroup;
    private String Description;
    private String PurchaseOrderRow;
    private long CreateTime;
    private String DemandFactory;
    private String Unit;
    private String Remark;
    private String MaterialType;
    private String Assigner;
    private String ShelfNO;
    private float Qty;
    private String MaterialCode;
    private String PurchaseOrderNO;
    private long AdvanceStorageId;

    public static GetPreRecMaterialCodeInfoJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetPreRecMaterialCodeInfoJSRepBean.class);
    }

    public static GetPreRecMaterialCodeInfoJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetPreRecMaterialCodeInfoJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetPreRecMaterialCodeInfoJSRepBean> arrayGetPreRecMaterialCodeInfoJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetPreRecMaterialCodeInfoJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetPreRecMaterialCodeInfoJSRepBean> arrayGetPreRecMaterialCodeInfoJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetPreRecMaterialCodeInfoJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getLogisticsGroup() {
        return LogisticsGroup;
    }

    public void setLogisticsGroup(String LogisticsGroup) {
        this.LogisticsGroup = LogisticsGroup;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPurchaseOrderRow() {
        return PurchaseOrderRow;
    }

    public void setPurchaseOrderRow(String PurchaseOrderRow) {
        this.PurchaseOrderRow = PurchaseOrderRow;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
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

    public String getAssigner() {
        return Assigner;
    }

    public void setAssigner(String Assigner) {
        this.Assigner = Assigner;
    }

    public String getShelfNO() {
        return ShelfNO;
    }

    public void setShelfNO(String ShelfNO) {
        this.ShelfNO = ShelfNO;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
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

    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }

    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }
}
