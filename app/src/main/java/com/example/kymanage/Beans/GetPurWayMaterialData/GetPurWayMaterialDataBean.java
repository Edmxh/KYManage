package com.example.kymanage.Beans.GetPurWayMaterialData;

/**
 * {
 *         "MaterialDesc": "插头/MC200-E1_6pin",
 *         "InQty": 0.0,
 *         "Qty": 1.0,
 *         "PreQty": 1.0,
 *         "MaterialCode": "DQ5095000031",
 *         "Storage": "2100"
 *     }
 */
public class GetPurWayMaterialDataBean {
    private String MaterialDesc;
    private float InQty;
    private float Qty;
    private float PreQty;
    private String MaterialCode;
    private String factory;
    private String labelSeqNum;
    private String Storage;

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public float getInQty() {
        return InQty;
    }

    public void setInQty(float inQty) {
        InQty = inQty;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float qty) {
        Qty = qty;
    }

    public float getPreQty() {
        return PreQty;
    }

    public void setPreQty(float preQty) {
        PreQty = preQty;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getLabelSeqNum() {
        return labelSeqNum;
    }

    public void setLabelSeqNum(String labelSeqNum) {
        this.labelSeqNum = labelSeqNum;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }
}
