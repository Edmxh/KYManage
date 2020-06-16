package com.example.kymanage.Beans;

import com.example.kymanage.Beans.General.CodeMessageBean;

import java.util.List;

public class ReceivingListBean {


    private List<DataBean1> data;
    private CodeMessageBean status;

    public List<DataBean1> getData() {
        return data;
    }

    public void setData(List<DataBean1> data) {
        this.data = data;
    }

    public CodeMessageBean getQuerystatus() {
        return status;
    }

    public void setQuerystatus(CodeMessageBean status) {
        this.status = status;
    }



}
