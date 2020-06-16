package com.example.kymanage.Beans.GetIssueNoteDetail;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 *    {"FIssueId": "240"}
 */
public class GetIssueNoteDetailReq {
   private String FIssueId;

    public GetIssueNoteDetailReq() {
    }

    public GetIssueNoteDetailReq(String FIssueId) {
        this.FIssueId = FIssueId;
    }

    @JSONField(name="FIssueId")
    public String getFIssueId() {
        return FIssueId;
    }
    @JSONField(name="FIssueId")
    public void setFIssueId(String FIssueId) {
        this.FIssueId = FIssueId;
    }
}
