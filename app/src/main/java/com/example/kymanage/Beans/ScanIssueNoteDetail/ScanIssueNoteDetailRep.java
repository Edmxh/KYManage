package com.example.kymanage.Beans.ScanIssueNoteDetail;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class ScanIssueNoteDetailRep {
    private List<ScanIssueNoteDetailRepBean> data;
    private StatusBean status;

    public List<ScanIssueNoteDetailRepBean> getData() {
        return data;
    }

    public void setData(List<ScanIssueNoteDetailRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
