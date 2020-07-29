package com.example.kymanage.Beans.WriteOffProductOrderIssue;

import java.util.List;

public class WriteOffProductOrderIssueReq {
    private String handler;
    private List<WriteOffProductOrderIssueReqBean> data;

    public WriteOffProductOrderIssueReq() {
    }

    public WriteOffProductOrderIssueReq(String handler, List<WriteOffProductOrderIssueReqBean> data) {
        this.handler = handler;
        this.data = data;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public List<WriteOffProductOrderIssueReqBean> getData() {
        return data;
    }

    public void setData(List<WriteOffProductOrderIssueReqBean> data) {
        this.data = data;
    }
}
