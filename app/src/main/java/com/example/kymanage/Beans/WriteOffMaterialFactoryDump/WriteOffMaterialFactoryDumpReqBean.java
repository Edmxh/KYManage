package com.example.kymanage.Beans.WriteOffMaterialFactoryDump;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 * "ID":35
 * }
 */
public class WriteOffMaterialFactoryDumpReqBean {
    private long ID;
    private String DumpNum;


    public WriteOffMaterialFactoryDumpReqBean(long ID, String dumpNum) {
        this.ID = ID;
        DumpNum = dumpNum;
    }

    @JSONField(name = "ID")
    public long getID() {
        return ID;
    }
    @JSONField(name = "ID")
    public void setID(long ID) {
        this.ID = ID;
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
