package com.example.kymanage.Beans.GetIssueNoteDetail;

/**
 * {
 *                     "MaterialDesc": 0.0,
 *                     "IssueQty": 1.0,
 *                     "DemandQty": 0.0,
 *                     "LastQty": 0.0,
 *                     "MaterialCode": "20000012",
 *                     "Area":""
 *                 }
 */
public class GetIssueNoteDetailBean1 {
    private String MaterialDesc;
    private float IssueQty;
    private float DemandQty;
    private float LastQty;
    private String MaterialCode;
    private String Area;

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public float getIssueQty() {
        return IssueQty;
    }

    public void setIssueQty(float issueQty) {
        IssueQty = issueQty;
    }

    public float getDemandQty() {
        return DemandQty;
    }

    public void setDemandQty(float demandQty) {
        DemandQty = demandQty;
    }

    public float getLastQty() {
        return LastQty;
    }

    public void setLastQty(float lastQty) {
        LastQty = lastQty;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}
