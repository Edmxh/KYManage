package com.example.kymanage.Beans.PreMaterialProductOrderJS;

/**
 * {
 *             "materialCode": "LJ5540018426-A01",
 *             "matnrCurrentNum": 10
 *         }
 */
public class PreMaterialProductOrderJSReqBean {
    private String materialCode;
    private float matnrCurrentNum;

    public PreMaterialProductOrderJSReqBean() {
    }

    public PreMaterialProductOrderJSReqBean(String materialCode, float matnrCurrentNum) {
        this.materialCode = materialCode;
        this.matnrCurrentNum = matnrCurrentNum;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public float getMatnrCurrentNum() {
        return matnrCurrentNum;
    }

    public void setMatnrCurrentNum(float matnrCurrentNum) {
        this.matnrCurrentNum = matnrCurrentNum;
    }
}
