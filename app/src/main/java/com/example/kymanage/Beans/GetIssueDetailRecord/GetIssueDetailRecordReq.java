package com.example.kymanage.Beans.GetIssueDetailRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  {
 *     "Handler":"pliu",
 *     "CurrentDate":"2020-06-12"
 *   }
 */
public class GetIssueDetailRecordReq {
    private String Handler;
    private String CurrentDate;

    public GetIssueDetailRecordReq() {
    }

    public GetIssueDetailRecordReq(String handler, String currentDate) {
        Handler = handler;
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
    @JSONField(name = "CurrentDate")
    public String getCurrentDate() {
        return CurrentDate;
    }
    @JSONField(name = "CurrentDate")
    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }
}
