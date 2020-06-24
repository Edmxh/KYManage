package com.example.kymanage.Beans.GetTransferRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * { "DumpNum":"202006170945523" }
 */
public class GetTransferRecordReqBean {
    private String DumpNum;

    public GetTransferRecordReqBean() {
    }

    public GetTransferRecordReqBean(String dumpNum) {
        DumpNum = dumpNum;
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
