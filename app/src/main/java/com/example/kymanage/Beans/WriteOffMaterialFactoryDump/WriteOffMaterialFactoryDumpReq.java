package com.example.kymanage.Beans.WriteOffMaterialFactoryDump;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class WriteOffMaterialFactoryDumpReq {
    private List<WriteOffMaterialFactoryDumpReqBean> data;
    private String handler;

    public WriteOffMaterialFactoryDumpReq(List<WriteOffMaterialFactoryDumpReqBean> data, String handler) {
        this.data = data;
        this.handler = handler;
    }

    @JSONField(name = "data")
    public List<WriteOffMaterialFactoryDumpReqBean> getData() {
        return data;
    }
    @JSONField(name = "data")
    public void setData(List<WriteOffMaterialFactoryDumpReqBean> data) {
        this.data = data;
    }
    @JSONField(name = "handler")
    public String getHandler() {
        return handler;
    }
    @JSONField(name = "handler")
    public void setHandler(String handler) {
        this.handler = handler;
    }
}
