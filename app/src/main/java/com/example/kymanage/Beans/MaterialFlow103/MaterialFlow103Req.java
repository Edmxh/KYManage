package com.example.kymanage.Beans.MaterialFlow103;

import java.util.List;

public class MaterialFlow103Req {
    private String postingDate;
    private String documentDate;
    private String user;
    private List<MaterialFlow103ReqBean> detail;

    public MaterialFlow103Req() {
    }

    public MaterialFlow103Req(String postingDate, String documentDate, String user, List<MaterialFlow103ReqBean> detail) {
        this.postingDate = postingDate;
        this.documentDate = documentDate;
        this.user = user;
        this.detail = detail;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<MaterialFlow103ReqBean> getDetail() {
        return detail;
    }

    public void setDetail(List<MaterialFlow103ReqBean> detail) {
        this.detail = detail;
    }
}
