package com.example.kymanage.Beans.WriteOffProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {"FinProEnterID":"19"}
 */
public class WriteOffProStorageRecordReqBean {
    private long ID;

    public WriteOffProStorageRecordReqBean(long ID) {
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
