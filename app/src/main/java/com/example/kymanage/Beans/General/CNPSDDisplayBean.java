package com.example.kymanage.Beans.General;

public class CNPSDDisplayBean {
    private String dispatchno;
    private String aufnr;
    private String materialCode;
    private String user;
    private String createDate;

    public CNPSDDisplayBean(String dispatchno, String aufnr, String materialCode, String user, String createDate) {
        this.dispatchno = dispatchno;
        this.aufnr = aufnr;
        this.materialCode = materialCode;
        this.user = user;
        this.createDate = createDate;
    }

    public String getDispatchno() {
        return dispatchno;
    }

    public void setDispatchno(String dispatchno) {
        this.dispatchno = dispatchno;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAufnr() {
        return aufnr;
    }

    public void setAufnr(String aufnr) {
        this.aufnr = aufnr;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
}
