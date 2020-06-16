package com.example.kymanage.Beans.GetOutsourceFinProLableJS;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetOutsourceFinProLableJSRepBean {

    /**
     * Company : TKAS
     * MarketOrderNO : 0010000208
     * MCode :
     * ProOMaterialNO : ZJ9310000007
     * Factory : 2010
     * PrintTime : 2020-06-10 14:54
     * Remark :
     * MaterialDesc : 拖链导槽|Q235A
     * Area : A11
     * PrintFactory : CM
     * ProOMaterialDesc : 集中控制系统
     * Qty : 4.0
     * ProductOrderNO : 000010048077
     * MaterialUnit : EA
     * MaterialCode : LJ7015001194
     * MarketOrderRow : 000026
     */

    private String Company;
    private String MarketOrderNO;
    private String MCode;
    private String ProOMaterialNO;
    private String Factory;
    private String PrintTime;
    private String Remark;
    private String MaterialDesc;
    private String Area;
    private String PrintFactory;
    private String ProOMaterialDesc;
    private float Qty;
    private String ProductOrderNO;
    private String MaterialUnit;
    private String MaterialCode;
    private String MarketOrderRow;
    private String FType;
    private String allocatedID;
    private String ClientNO ;
    private String ClientShortName ;

    public static GetOutsourceFinProLableJSRepBean objectFromData(String str) {

        return new Gson().fromJson(str, GetOutsourceFinProLableJSRepBean.class);
    }

    public static GetOutsourceFinProLableJSRepBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), GetOutsourceFinProLableJSRepBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<GetOutsourceFinProLableJSRepBean> arrayGetOutsourceFinProLableJSRepBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GetOutsourceFinProLableJSRepBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<GetOutsourceFinProLableJSRepBean> arrayGetOutsourceFinProLableJSRepBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<GetOutsourceFinProLableJSRepBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String MarketOrderNO) {
        this.MarketOrderNO = MarketOrderNO;
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

    public String getPrintTime() {
        return PrintTime;
    }

    public void setPrintTime(String PrintTime) {
        this.PrintTime = PrintTime;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
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

    public String getPrintFactory() {
        return PrintFactory;
    }

    public void setPrintFactory(String PrintFactory) {
        this.PrintFactory = PrintFactory;
    }

    public String getProOMaterialDesc() {
        return ProOMaterialDesc;
    }

    public void setProOMaterialDesc(String ProOMaterialDesc) {
        this.ProOMaterialDesc = ProOMaterialDesc;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float Qty) {
        this.Qty = Qty;
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

    public String getFType() {
        return FType;
    }

    public void setFType(String FType) {
        this.FType = FType;
    }

    public String getAllocatedID() {
        return allocatedID;
    }

    public void setAllocatedID(String allocatedID) {
        this.allocatedID = allocatedID;
    }

    public String getClientNO() {
        return ClientNO;
    }

    public void setClientNO(String clientNO) {
        ClientNO = clientNO;
    }

    public String getClientShortName() {
        return ClientShortName;
    }

    public void setClientShortName(String clientShortName) {
        ClientShortName = clientShortName;
    }
}
