package com.example.kymanage.Beans.WriteOffProductOrderIssue;

import java.util.List;

public class WriteOffProductOrderIssueReq {
    private String dldate;
    private List<WriteOffProductOrderIssueReqBean> data;

    public WriteOffProductOrderIssueReq() {
    }

    public WriteOffProductOrderIssueReq(String dldate, List<WriteOffProductOrderIssueReqBean> data) {
        this.dldate = dldate;
        this.data = data;
    }

    public String getDldate() {
        return dldate;
    }

    public void setDldate(String dldate) {
        this.dldate = dldate;
    }

    public List<WriteOffProductOrderIssueReqBean> getData() {
        return data;
    }

    public void setData(List<WriteOffProductOrderIssueReqBean> data) {
        this.data = data;
    }
}
