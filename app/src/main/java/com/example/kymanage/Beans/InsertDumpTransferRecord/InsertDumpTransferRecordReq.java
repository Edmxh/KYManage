package com.example.kymanage.Beans.InsertDumpTransferRecord;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class InsertDumpTransferRecordReq {
    private List<InsertDumpTransferRecordReqBean> data;
    private String uname;
    private String DumpNum;

    public InsertDumpTransferRecordReq() {
    }

    public InsertDumpTransferRecordReq(List<InsertDumpTransferRecordReqBean> data, String uname, String dumpNum) {
        this.data = data;
        this.uname = uname;
        DumpNum = dumpNum;
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


    @JSONField(name = "DumpNum")
    public String getDumpNum() {
        return DumpNum;
    }
    @JSONField(name = "DumpNum")
    public void setDumpNum(String dumpNum) {
        DumpNum = dumpNum;
    }
}
