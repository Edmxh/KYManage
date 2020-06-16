package com.example.kymanage.Beans.WriteOffProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * {
 * "data":{
 *    "Handler":"kzheng",
 * "data":[
 *    {"FinProEnterID":"19"}
 * ]
 * }
 * }
 */
public class WriteOffProStorageRecordReq {
    private String Handler;
    private List<WriteOffProStorageRecordReqBean> data;


    public WriteOffProStorageRecordReq(String handler, List<WriteOffProStorageRecordReqBean> data) {
        Handler = handler;
        this.data = data;
    }

    public WriteOffProStorageRecordReq() {
    }

    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String handler) {
        Handler = handler;
    }

    public List<WriteOffProStorageRecordReqBean> getData() {
        return data;
    }

    public void setData(List<WriteOffProStorageRecordReqBean> data) {
        this.data = data;
    }
}
