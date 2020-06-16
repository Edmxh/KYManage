package com.example.kymanage.Beans.GetMainDumpRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  { "CurrentDate":"2020-05-31", "Handler":"kzheng" }
 */
public class GetMainDumpRecordReq {
    private String CurrentDate;
    private String Handler;

    public GetMainDumpRecordReq() {
    }

    public GetMainDumpRecordReq(String currentDate, String handler) {
        CurrentDate = currentDate;
        Handler = handler;
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
}
