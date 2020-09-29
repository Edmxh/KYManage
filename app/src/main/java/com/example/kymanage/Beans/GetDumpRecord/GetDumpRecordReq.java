package com.example.kymanage.Beans.GetDumpRecord;

import com.alibaba.fastjson.annotation.JSONField;

public class GetDumpRecordReq {
    private long ID;

    public GetDumpRecordReq() {
    }

    public GetDumpRecordReq(long ID) {
        this.ID = ID;
    }
    @JSONField(name = "ID")
    public long getID() {
        return ID;
    }
    @JSONField(name = "ID")
    public void setID(long ID) {
        this.ID = ID;
    }
}
