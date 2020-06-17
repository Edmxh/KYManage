package com.example.kymanage.Beans.GetDumpRecordNode;

import com.alibaba.fastjson.annotation.JSONField;

public class GetDumpRecordNodeReqBean {
    private long ID;

    public GetDumpRecordNodeReqBean() {
    }

    public GetDumpRecordNodeReqBean(long ID) {
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
