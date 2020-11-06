package com.example.kymanage.Beans.GetMarketOrderNoByCode;

import com.example.kymanage.Beans.General.CodeMessageBean;

import java.util.List;

public class GetMarketOrderNoByCodeRep {
    private List<GetMarketOrderNoByCodeRepBean> data;
    private CodeMessageBean status;

    public List<GetMarketOrderNoByCodeRepBean> getData() {
        return data;
    }

    public void setData(List<GetMarketOrderNoByCodeRepBean> data) {
        this.data = data;
    }

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
