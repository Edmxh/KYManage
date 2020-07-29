package com.example.kymanage.Beans.GetFinProStorageRecordNote;

import com.alibaba.fastjson.annotation.JSONField;

public class GetFinProStorageRecordNoteReqBean {
    private long ID;

    public GetFinProStorageRecordNoteReqBean(long ID) {
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
