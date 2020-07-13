package com.example.kymanage.Beans.GenerateStorageLssueRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

/**
 *
 */
public class GenerateStorageLssueRecordRep {
    private List<GenerateStorageLssueRecordRepBean2> data;
    private String IssueListNo;
    private StatusBean status;

    public List<GenerateStorageLssueRecordRepBean2> getData() {
        return data;
    }

    public void setData(List<GenerateStorageLssueRecordRepBean2> data) {
        this.data = data;
    }

    public String getIssueListNo() {
        return IssueListNo;
    }

    public void setIssueListNo(String issueListNo) {
        IssueListNo = issueListNo;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
