package com.example.kymanage.Beans.InsertDumpTransferRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class InsertDumpTransferRecordRep {
    private List<InsertDumpTransferRecordRepBean> data;
    private StatusBean status;

    public List<InsertDumpTransferRecordRepBean> getData() {
        return data;
    }

    public void setData(List<InsertDumpTransferRecordRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
