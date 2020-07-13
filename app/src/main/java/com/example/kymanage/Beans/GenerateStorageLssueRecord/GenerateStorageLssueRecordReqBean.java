package com.example.kymanage.Beans.GenerateStorageLssueRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *    {"FIssueId": 240}
 */
public class GenerateStorageLssueRecordReqBean {
   private long FIssueId;

    public GenerateStorageLssueRecordReqBean() {
    }

    public GenerateStorageLssueRecordReqBean(long FIssueId) {
        this.FIssueId = FIssueId;
    }

    @JSONField(name="FIssueId")
    public long getFIssueId() {
        return FIssueId;
    }
    @JSONField(name="FIssueId")
    public void setFIssueId(long FIssueId) {
        this.FIssueId = FIssueId;
    }
}
