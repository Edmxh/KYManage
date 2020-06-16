package com.example.kymanage.Beans.InsertProductOrderIssue;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class InsertProductOrderIssueRep {
    private List<InsertProductOrderIssueRepBean> data;
    private StatusBean status;

    public List<InsertProductOrderIssueRepBean> getData() {
        return data;
    }

    public void setData(List<InsertProductOrderIssueRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
