package com.example.kymanage.Beans.GetMainDumpRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetMainDumpRecordRep {
    private List<GetMainDumpRecordRepBean> data;
    private StatusBean status;

    public List<GetMainDumpRecordRepBean> getData() {
        return data;
    }

    public void setData(List<GetMainDumpRecordRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
