package com.example.kymanage.Beans.General;

public class CNPSDDisplayBean {
    private String dispatchno;
    private String user;
    private String createDate;

    public CNPSDDisplayBean(String dispatchno, String user, String createDate) {
        this.dispatchno = dispatchno;
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
}
