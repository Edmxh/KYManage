package com.example.kymanage.Beans.InsertProductOrderIssue;

/**
 * {
 *                 "FMESSA": "S",
 *                 "FMBLNR": "4900306936",
 *                 "FMJAHR": "2020",
 *                 "FAllocatedID": 132.0,
 *                 "FIssueId": 220.0
 *             }
 */
public class InsertProductOrderIssueRepBean {
    private String FMESSA;
    private String FMBLNR;
    private String FMJAHR;
    private long FAllocatedID;
    private long FIssueId;

    public String getFMESSA() {
        return FMESSA;
    }

    public void setFMESSA(String FMESSA) {
        this.FMESSA = FMESSA;
    }

    public String getFMBLNR() {
        return FMBLNR;
    }

    public void setFMBLNR(String FMBLNR) {
        this.FMBLNR = FMBLNR;
    }

    public String getFMJAHR() {
        return FMJAHR;
    }

    public void setFMJAHR(String FMJAHR) {
        this.FMJAHR = FMJAHR;
    }

    public long getFAllocatedID() {
        return FAllocatedID;
    }

    public void setFAllocatedID(long FAllocatedID) {
        this.FAllocatedID = FAllocatedID;
    }

    public long getFIssueId() {
        return FIssueId;
    }

    public void setFIssueId(long FIssueId) {
        this.FIssueId = FIssueId;
    }
}
