package com.example.kymanage.Beans.GetLableRecords;

import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetLableRecordsReps {
    private List<GetParchaseCenterLableRep> labels;
    private StatusBean status;

    public List<GetParchaseCenterLableRep> getLabels() {
        return labels;
    }

    public void setLabels(List<GetParchaseCenterLableRep> labels) {
        this.labels = labels;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
