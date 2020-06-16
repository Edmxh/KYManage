package com.example.kymanage.Beans.GetStockInformationDataJS;

/**
 * {
 *         "factory": "2010",
 *         "materialDesc": "插头/MC200-E1_6pin",
 *         "materialType": "专有",
 *         "Qty": 0.0,
 *         "materialCode": "DQ5095000031",
 *         "storage": "2100"
 *     }
 */
public class GetStockInformationDataJSBean {
    private String factory;
    private String materialDesc;
    private String materialType;
    private float Qty;
    private String materialCode;
    private String storage;
    //发料要传
    private String labelSeqNum;
    private String pono;
    private String porow;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public float getQty() {
        return Qty;
    }

    public void setQty(float qty) {
        Qty = qty;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getLabelSeqNum() {
        return labelSeqNum;
    }

    public void setLabelSeqNum(String labelSeqNum) {
        this.labelSeqNum = labelSeqNum;
    }

    public String getPono() {
        return pono;
    }

    public void setPono(String pono) {
        this.pono = pono;
    }

    public String getPorow() {
        return porow;
    }

    public void setPorow(String porow) {
        this.porow = porow;
    }
}
