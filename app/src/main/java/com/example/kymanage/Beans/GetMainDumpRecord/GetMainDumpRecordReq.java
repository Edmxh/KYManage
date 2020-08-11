package com.example.kymanage.Beans.GetMainDumpRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  { "CurrentDate":"2020-05-31", "Handler":"kzheng" }
 */
public class GetMainDumpRecordReq {
    private String CurrentDate;
    private String Handler;
    private String DumpNum;

    public GetMainDumpRecordReq() {
    }

    public GetMainDumpRecordReq(String currentDate, String handler, String dumpNum) {
        CurrentDate = currentDate;
        Handler = handler;
        DumpNum = dumpNum;
    }

    @JSONField(name = "CurrentDate")
    public String getCurrentDate() {
        return CurrentDate;
    }
    @JSONField(name = "CurrentDate")
    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String handler) {
        Handler = handler;
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
