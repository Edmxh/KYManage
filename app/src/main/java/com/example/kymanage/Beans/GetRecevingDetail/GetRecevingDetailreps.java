package com.example.kymanage.Beans.GetRecevingDetail;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetRecevingDetailreps {
    private List<GetRecevingDetailrep> data;
    private StatusBean status;

    public List<GetRecevingDetailrep> getData() {
        return data;
    }

    public void setData(List<GetRecevingDetailrep> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
