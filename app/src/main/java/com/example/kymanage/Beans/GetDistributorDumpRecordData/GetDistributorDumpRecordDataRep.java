package com.example.kymanage.Beans.GetDistributorDumpRecordData;

import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;

import java.util.List;

public class GetDistributorDumpRecordDataRep {
    private List<GetDistributorDumpRecordDataRepBean> data;
    private CodeMessageBean status;

    public List<GetDistributorDumpRecordDataRepBean> getData() {
        return data;
    }

    public void setData(List<GetDistributorDumpRecordDataRepBean> data) {
        this.data = data;
    }

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
