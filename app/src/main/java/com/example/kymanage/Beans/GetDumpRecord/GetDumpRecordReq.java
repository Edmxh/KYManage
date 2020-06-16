package com.example.kymanage.Beans.GetDumpRecord;

import com.alibaba.fastjson.annotation.JSONField;

public class GetDumpRecordReq {
    private String ID;

    public GetDumpRecordReq() {
    }

    public GetDumpRecordReq(String ID) {
        this.ID = ID;
    }
    @JSONField(name = "ID")
    public String getID() {
        return ID;
    }
    @JSONField(name = "ID")
    public void setID(String ID) {
        this.ID = ID;
    }
}
