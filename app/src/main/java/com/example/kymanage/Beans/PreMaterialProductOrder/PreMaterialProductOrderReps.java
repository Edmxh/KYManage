package com.example.kymanage.Beans.PreMaterialProductOrder;

import com.example.kymanage.Beans.General.CodeMessageBean;

import java.util.List;

public class PreMaterialProductOrderReps {
    private List<PreMaterialProductOrderRep> data;
    private CodeMessageBean status;

    public PreMaterialProductOrderReps() {
    }

    public PreMaterialProductOrderReps(List<PreMaterialProductOrderRep> data, CodeMessageBean status) {
        this.data = data;
        this.status = status;
    }

    public List<PreMaterialProductOrderRep> getData() {
        return data;
    }

    public void setData(List<PreMaterialProductOrderRep> data) {
        this.data = data;
    }

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
