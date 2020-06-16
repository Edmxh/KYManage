package com.example.kymanage.Beans.GetDumpRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetDumpRecordRep {

    private List<GetDumpRecordRepBean> data;
    private StatusBean status;

    public List<GetDumpRecordRepBean> getData() {
        return data;
    }

    public void setData(List<GetDumpRecordRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
