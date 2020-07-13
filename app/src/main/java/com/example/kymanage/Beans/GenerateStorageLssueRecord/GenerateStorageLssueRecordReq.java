package com.example.kymanage.Beans.GenerateStorageLssueRecord;

import java.util.List;

public class GenerateStorageLssueRecordReq {
    private String Handler;
    private List<GenerateStorageLssueRecordReqBean> data;

    public GenerateStorageLssueRecordReq() {
    }

    public GenerateStorageLssueRecordReq(String handler, List<GenerateStorageLssueRecordReqBean> data) {
        Handler = handler;
        this.data = data;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String handler) {
        Handler = handler;
    }

    public List<GenerateStorageLssueRecordReqBean> getData() {
        return data;
    }

    public void setData(List<GenerateStorageLssueRecordReqBean> data) {
        this.data = data;
    }
}
