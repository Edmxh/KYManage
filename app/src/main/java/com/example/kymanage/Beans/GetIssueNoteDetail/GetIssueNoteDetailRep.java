package com.example.kymanage.Beans.GetIssueNoteDetail;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

/**
 *
 */
public class GetIssueNoteDetailRep {
    private List<GetIssueNoteDetailBean2> data;
    private StatusBean status;

    public List<GetIssueNoteDetailBean2> getData() {
        return data;
    }

    public void setData(List<GetIssueNoteDetailBean2> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
