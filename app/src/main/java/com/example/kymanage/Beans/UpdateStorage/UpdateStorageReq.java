package com.example.kymanage.Beans.UpdateStorage;

import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;

import java.util.List;

/**
 * {
 * 	"data":[{
 * 	"PostingDate": "2020-3-4",
 * 	"DocumentDate": "2020-3-5",
 * 	"User":"User",
 * 	"ReceNum": 2,
 * 	"OrderNum": "OrderNum",
 * 	"OrderRow": "OrderRow",
 * 	"MaterialCode": "cs001",
 * 	"Class": true,
 * 	"ForceReceive": false,
 *         "DemandFactory":"2000",
 *         "DemandStorage":"DemandStorage",
 *         "Remark":"Remark"
 *        }]
 * }
 */
public class UpdateStorageReq {
    private String  postingDate;
    private String  documentDate;
    private String  user;
    private float  receNum;
    private String  orderNum;
    private String  orderRow;
    private String  materialCode;
    private String  materialType;
    private String  demandFactory;
    private String  description;
    private String  unit;
    private String  Remark;
    private List<ProductOrderBean> productOrder;

    public UpdateStorageReq() {
    }

    public UpdateStorageReq(String postingDate, String documentDate, String user, float receNum, String orderNum, String orderRow, String materialCode, String materialType, String demandFactory, String description, String unit, String remark, List<ProductOrderBean> productOrder) {
        this.postingDate = postingDate;
        this.documentDate = documentDate;
        this.user = user;
        this.receNum = receNum;
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.materialCode = materialCode;
        this.materialType = materialType;
        this.demandFactory = demandFactory;
        this.description = description;
        this.unit = unit;
        Remark = remark;
        this.productOrder = productOrder;
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

    public float getReceNum() {
        return receNum;
    }

    public void setReceNum(float receNum) {
        this.receNum = receNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderRow() {
        return orderRow;
    }

    public void setOrderRow(String orderRow) {
        this.orderRow = orderRow;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getDemandFactory() {
        return demandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        this.demandFactory = demandFactory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public List<ProductOrderBean> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<ProductOrderBean> productOrder) {
        this.productOrder = productOrder;
    }
}
