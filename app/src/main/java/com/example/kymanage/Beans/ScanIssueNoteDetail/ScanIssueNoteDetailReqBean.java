package com.example.kymanage.Beans.ScanIssueNoteDetail;

import com.alibaba.fastjson.annotation.JSONField;

public class ScanIssueNoteDetailReqBean {
    private String IssueListNo;

    public ScanIssueNoteDetailReqBean(String issueListNo) {
        IssueListNo = issueListNo;
    }

    @JSONField(name = "IssueListNo")
    public String getIssueListNo() {
        return IssueListNo;
    }
    @JSONField(name = "IssueListNo")
    public void setIssueListNo(String issueListNo) {
        IssueListNo = issueListNo;
    }
}
