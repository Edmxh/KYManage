package com.example.kymanage.Beans.GetFinProStorageRecordNote;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetFinProStorageRecordNoteRep {
    private List<GetFinProStorageRecordNoteRepBean> data;
    private StatusBean status;

    public List<GetFinProStorageRecordNoteRepBean> getData() {
        return data;
    }

    public void setData(List<GetFinProStorageRecordNoteRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
