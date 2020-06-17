package com.example.kymanage.Beans.WriteOffMaterialFactoryDump;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 * "ID":35
 * }
 */
public class WriteOffMaterialFactoryDumpReqBean {
    private long ID;

    public WriteOffMaterialFactoryDumpReqBean() {
    }

    public WriteOffMaterialFactoryDumpReqBean(long ID) {
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
