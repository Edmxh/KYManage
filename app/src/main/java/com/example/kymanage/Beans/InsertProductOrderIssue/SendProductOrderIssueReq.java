package com.example.kymanage.Beans.InsertProductOrderIssue;

import java.util.List;

public class SendProductOrderIssueReq {
    private String handler;
    private List<InsertProductOrderIssueReqBean> data;

    public SendProductOrderIssueReq() {
    }

    public SendProductOrderIssueReq(String handler, List<InsertProductOrderIssueReqBean> data) {
        this.handler = handler;
        this.data = data;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public List<InsertProductOrderIssueReqBean> getData() {
        return data;
    }

    public void setData(List<InsertProductOrderIssueReqBean> data) {
        this.data = data;
    }
}
