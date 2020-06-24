package com.example.kymanage.Beans.GetTransferRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetTransferRecordRep {
    private List<GetTransferRecordRepBean> data;
    private StatusBean status;

    public List<GetTransferRecordRepBean> getData() {
        return data;
    }

    public void setData(List<GetTransferRecordRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
