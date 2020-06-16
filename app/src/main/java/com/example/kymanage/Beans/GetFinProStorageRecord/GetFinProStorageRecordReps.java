package com.example.kymanage.Beans.GetFinProStorageRecord;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

/**
 *
 */
public class GetFinProStorageRecordReps {
    private List<GetFinProStorageRecordRep>  data;
    private StatusBean status;

    public List<GetFinProStorageRecordRep> getData() {
        return data;
    }

    public void setData(List<GetFinProStorageRecordRep> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
