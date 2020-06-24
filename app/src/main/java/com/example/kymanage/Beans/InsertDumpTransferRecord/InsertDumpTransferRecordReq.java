package com.example.kymanage.Beans.InsertDumpTransferRecord;

import java.util.List;

public class InsertDumpTransferRecordReq {
    private List<InsertDumpTransferRecordReqBean> data;
    private String uname;

    public InsertDumpTransferRecordReq() {
    }

    public InsertDumpTransferRecordReq(List<InsertDumpTransferRecordReqBean> data, String uname) {
        this.data = data;
        this.uname = uname;
    }

    public List<InsertDumpTransferRecordReqBean> getData() {
        return data;
    }

    public void setData(List<InsertDumpTransferRecordReqBean> data) {
        this.data = data;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
