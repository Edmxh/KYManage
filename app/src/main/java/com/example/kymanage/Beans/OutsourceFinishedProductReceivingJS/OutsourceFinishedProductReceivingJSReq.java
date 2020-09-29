package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OutsourceFinishedProductReceivingJSReq {

    private String postingDate;
    private String documentDate;
    private String user;
    private String KDAUF;
    private String KDPOS;
    private String orderNum;
    private String orderRow;
    private String upstreamFactory;
    private String demandFactory;
    private String demandStorage;
    private String materialCode;
    private String materialDesc;
    private String materialType;
    private String materialUnit;
    private float MENGE;
    private float inStorage;
    private float recNum;
    private String remark;
    private String KINDS;
    //9.5
    private String aufnr;
    private String pmatn;
    private String mcode;
    private String maktx;

    private List<AUFNRBean> AUFNR;
    private List<UPAUFNRBean> UPAUFNR;

    public OutsourceFinishedProductReceivingJSReq(String postingDate, String documentDate, String user, String KDAUF, String KDPOS, String orderNum, String orderRow, String upstreamFactory, String demandFactory, String demandStorage, String materialCode, String materialDesc, String materialType, String materialUnit, float MENGE, float inStorage, float recNum, String remark, String KINDS, String aufnr, String pmatn, String mcode, String maktx, List<AUFNRBean> AUFNR, List<UPAUFNRBean> UPAUFNR) {
        this.postingDate = postingDate;
        this.documentDate = documentDate;
        this.user = user;
        this.KDAUF = KDAUF;
        this.KDPOS = KDPOS;
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.upstreamFactory = upstreamFactory;
        this.demandFactory = demandFactory;
        this.demandStorage = demandStorage;
        this.materialCode = materialCode;
        this.materialDesc = materialDesc;
        this.materialType = materialType;
        this.materialUnit = materialUnit;
        this.MENGE = MENGE;
        this.inStorage = inStorage;
        this.recNum = recNum;
        this.remark = remark;
        this.KINDS = KINDS;
        this.aufnr = aufnr;
        this.pmatn = pmatn;
        this.mcode = mcode;
        this.maktx = maktx;
        this.AUFNR = AUFNR;
        this.UPAUFNR = UPAUFNR;
    }

    public static OutsourceFinishedProductReceivingJSReq objectFromData(String str) {

        return new Gson().fromJson(str, OutsourceFinishedProductReceivingJSReq.class);
    }

    public static OutsourceFinishedProductReceivingJSReq objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), OutsourceFinishedProductReceivingJSReq.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<OutsourceFinishedProductReceivingJSReq> arrayOutsourceFinishedProductReceivingJSReqFromData(String str) {

        Type listType = new TypeToken<ArrayList<OutsourceFinishedProductReceivingJSReq>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<OutsourceFinishedProductReceivingJSReq> arrayOutsourceFinishedProductReceivingJSReqFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<OutsourceFinishedProductReceivingJSReq>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    @JSONField(name = "postingDate")
    public String getPostingDate() {
        return postingDate;
    }
    @JSONField(name = "postingDate")
    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }
    @JSONField(name = "documentDate")
    public String getDocumentDate() {
        return documentDate;
    }
    @JSONField(name = "documentDate")
    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }
    @JSONField(name = "user")
    public String getUser() {
        return user;
    }
    @JSONField(name = "user")
    public void setUser(String user) {
        this.user = user;
    }
    @JSONField(name = "KDAUF")
    public String getKDAUF() {
        return KDAUF;
    }
    @JSONField(name = "KDAUF")
    public void setKDAUF(String KDAUF) {
        this.KDAUF = KDAUF;
    }
    @JSONField(name = "KDPOS")
    public String getKDPOS() {
        return KDPOS;
    }
    @JSONField(name = "KDPOS")
    public void setKDPOS(String KDPOS) {
        this.KDPOS = KDPOS;
    }
    @JSONField(name = "orderNum")
    public String getOrderNum() {
        return orderNum;
    }
    @JSONField(name = "orderNum")
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    @JSONField(name = "orderRow")
    public String getOrderRow() {
        return orderRow;
    }
    @JSONField(name = "orderRow")
    public void setOrderRow(String orderRow) {
        this.orderRow = orderRow;
    }
    @JSONField(name = "upstreamFactory")
    public String getUpstreamFactory() {
        return upstreamFactory;
    }
    @JSONField(name = "upstreamFactory")
    public void setUpstreamFactory(String upstreamFactory) {
        this.upstreamFactory = upstreamFactory;
    }
    @JSONField(name = "demandFactory")
    public String getDemandFactory() {
        return demandFactory;
    }
    @JSONField(name = "demandFactory")
    public void setDemandFactory(String demandFactory) {
        this.demandFactory = demandFactory;
    }
    @JSONField(name = "demandStorage")
    public String getDemandStorage() {
        return demandStorage;
    }
    @JSONField(name = "demandStorage")
    public void setDemandStorage(String demandStorage) {
        this.demandStorage = demandStorage;
    }
    @JSONField(name = "materialCode")
    public String getMaterialCode() {
        return materialCode;
    }
    @JSONField(name = "materialCode")
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
    @JSONField(name = "materialDesc")
    public String getMaterialDesc() {
        return materialDesc;
    }
    @JSONField(name = "materialDesc")
    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }
    @JSONField(name = "materialType")
    public String getMaterialType() {
        return materialType;
    }
    @JSONField(name = "materialType")
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    @JSONField(name = "materialUnit")
    public String getMaterialUnit() {
        return materialUnit;
    }
    @JSONField(name = "materialUnit")
    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }
    @JSONField(name = "MENGE")
    public float getMENGE() {
        return MENGE;
    }
    @JSONField(name = "MENGE")
    public void setMENGE(float MENGE) {
        this.MENGE = MENGE;
    }
    @JSONField(name = "inStorage")
    public float getInStorage() {
        return inStorage;
    }
    @JSONField(name = "inStorage")
    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }
    @JSONField(name = "recNum")
    public float getRecNum() {
        return recNum;
    }
    @JSONField(name = "recNum")
    public void setRecNum(float recNum) {
        this.recNum = recNum;
    }
    @JSONField(name = "remark")
    public String getRemark() {
        return remark;
    }
    @JSONField(name = "remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @JSONField(name = "KINDS")
    public String getKINDS() {
        return KINDS;
    }
    @JSONField(name = "KINDS")
    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getPmatn() {
        return pmatn;
    }

    public void setPmatn(String pmatn) {
        this.pmatn = pmatn;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMaktx() {
        return maktx;
    }

    public void setMaktx(String maktx) {
        this.maktx = maktx;
    }

    @JSONField(name = "AUFNR")
    public List<AUFNRBean> getAUFNR() {
        return AUFNR;
    }
    @JSONField(name = "AUFNR")
    public void setAUFNR(List<AUFNRBean> AUFNR) {
        this.AUFNR = AUFNR;
    }
    @JSONField(name = "UPAUFNR")
    public List<UPAUFNRBean> getUPAUFNR() {
        return UPAUFNR;
    }
    @JSONField(name = "UPAUFNR")
    public void setUPAUFNR(List<UPAUFNRBean> UPAUFNR) {
        this.UPAUFNR = UPAUFNR;
    }
}
