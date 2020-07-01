package com.example.kymanage.Beans.WriteOffProductOrderIssue;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {"FIssueId": "361"}
 */
public class WriteOffProductOrderIssueReqBean {
    private String FIssueId;

    public WriteOffProductOrderIssueReqBean(String FIssueId) {
        this.FIssueId = FIssueId;
    }

    @JSONField(name = "FIssueId")
    public String getFIssueId() {
        return FIssueId;
    }
    @JSONField(name = "FIssueId")
    public void setFIssueId(String FIssueId) {
        this.FIssueId = FIssueId;
    }
}
