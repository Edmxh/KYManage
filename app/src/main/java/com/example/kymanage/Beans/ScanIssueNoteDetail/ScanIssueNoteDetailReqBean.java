package com.example.kymanage.Beans.ScanIssueNoteDetail;

import com.alibaba.fastjson.annotation.JSONField;

public class ScanIssueNoteDetailReqBean {
    private String IssueListNo;
    private String handler;

    public ScanIssueNoteDetailReqBean(String issueListNo, String handler) {
        IssueListNo = issueListNo;
        this.handler = handler;
    }

    @JSONField(name = "IssueListNo")
    public String getIssueListNo() {
        return IssueListNo;
    }
    @JSONField(name = "IssueListNo")
    public void setIssueListNo(String issueListNo) {
        IssueListNo = issueListNo;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
