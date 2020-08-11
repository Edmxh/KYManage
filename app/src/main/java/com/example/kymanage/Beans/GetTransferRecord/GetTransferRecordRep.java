package com.example.kymanage.Beans.GetTransferRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetTransferRecordRep {
    private List<GetTransferRecordRepBean1> data;
    private GetTransferRecordRepBean2 mdata;
    private StatusBean status;

    public List<GetTransferRecordRepBean1> getData() {
        return data;
    }

    public void setData(List<GetTransferRecordRepBean1> data) {
        this.data = data;
    }

    public GetTransferRecordRepBean2 getMdata() {
        return mdata;
    }

    public void setMdata(GetTransferRecordRepBean2 mdata) {
        this.mdata = mdata;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
