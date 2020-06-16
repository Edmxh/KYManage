package com.example.kymanage.Beans.MaterialFactoryDump;

import java.util.List;

public class MaterialFactoryDumpReq {
    private String uname;
    private List<MaterialFactoryDumpReqBean> data;

    public MaterialFactoryDumpReq() {
    }

    public MaterialFactoryDumpReq(String uname, List<MaterialFactoryDumpReqBean> data) {
        this.uname = uname;
        this.data = data;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<MaterialFactoryDumpReqBean> getData() {
        return data;
    }

    public void setData(List<MaterialFactoryDumpReqBean> data) {
        this.data = data;
    }
}
