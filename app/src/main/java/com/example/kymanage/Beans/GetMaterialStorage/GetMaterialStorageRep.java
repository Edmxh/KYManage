package com.example.kymanage.Beans.GetMaterialStorage;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

public class GetMaterialStorageRep {
    private List<GetMaterialStorageRepBean> data;
    private StatusBean status;

    public List<GetMaterialStorageRepBean> getData() {
        return data;
    }

    public void setData(List<GetMaterialStorageRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
