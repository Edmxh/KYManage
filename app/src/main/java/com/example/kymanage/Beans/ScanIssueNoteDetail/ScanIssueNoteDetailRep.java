package com.example.kymanage.Beans.ScanIssueNoteDetail;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class ScanIssueNoteDetailRep {
    private List<ScanIssueNoteDetailRepBean> data;
    private String mstatus;
    private StatusBean status;

    public List<ScanIssueNoteDetailRepBean> getData() {
        return data;
    }

    public void setData(List<ScanIssueNoteDetailRepBean> data) {
        this.data = data;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
