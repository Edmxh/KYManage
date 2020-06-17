package com.example.kymanage.Beans.GetDumpRecordNode;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetDumpRecordNodeRep {
    private List<GetDumpRecordNodeRepBean2> data;
    private StatusBean status;

    public List<GetDumpRecordNodeRepBean2> getData() {
        return data;
    }

    public void setData(List<GetDumpRecordNodeRepBean2> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
