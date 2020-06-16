package com.example.kymanage.Beans.GetIssueRecord;

/**
 *    {
 *             "issueStatus": "生产订单发料",
 *             "issueId": 201.0,
 *             "unit": "EA",
 *             "porductOrderNO": "pro test 001",
 *             "issueNum": 2.0,
 *             "materialCode": "DQ5095000031",
 *             "materialDescription": "插头/MC200-E1_6pin"
 *         }
 */
public class GetIssueRecordRep {
    private String issueStatus;
    private long issueId;
    private String unit;
    private String porductOrderNO;
    private float issueNum;
    private String materialCode;
    private String materialDescription;

    public GetIssueRecordRep() {
    }

    public GetIssueRecordRep(String issueStatus, long issueId, String unit, String porductOrderNO, float issueNum, String materialCode, String materialDescription) {
        this.issueStatus = issueStatus;
        this.issueId = issueId;
        this.unit = unit;
        this.porductOrderNO = porductOrderNO;
        this.issueNum = issueNum;
        this.materialCode = materialCode;
        this.materialDescription = materialDescription;
    }

    public long getIssueId() {
        return issueId;
    }

    public void setIssueId(long issueId) {
        this.issueId = issueId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPorductOrderNO() {
        return porductOrderNO;
    }

    public void setPorductOrderNO(String porductOrderNO) {
        this.porductOrderNO = porductOrderNO;
    }

    public float getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(float issueNum) {
        this.issueNum = issueNum;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}
