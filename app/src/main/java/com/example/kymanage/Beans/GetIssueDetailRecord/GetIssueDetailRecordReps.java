package com.example.kymanage.Beans.GetIssueDetailRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

/**
 * {
 *   "code": 1,
 *   "message": "查询成功",
 *   "data":[{
 *      "issueId":1
 *      "porductOrderNO":"",
 *      "materialCode":"",
 *      "materialDescription":"",
 *      "unit":"E",
 *      "issueNum":4
 *    }]
 * }
 */
public class GetIssueDetailRecordReps {
    private List<GetIssueDetailRecordRep> data;
    private StatusBean status;


    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<GetIssueDetailRecordRep> getData() {
        return data;
    }

    public void setData(List<GetIssueDetailRecordRep> data) {
        this.data = data;
    }
}
