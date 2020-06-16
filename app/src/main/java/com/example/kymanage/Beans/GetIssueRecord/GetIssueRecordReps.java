package com.example.kymanage.Beans.GetIssueRecord;

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
public class GetIssueRecordReps {
    private int code;
    private String message;
    private List<GetIssueRecordRep> data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetIssueRecordRep> getData() {
        return data;
    }

    public void setData(List<GetIssueRecordRep> data) {
        this.data = data;
    }
}
