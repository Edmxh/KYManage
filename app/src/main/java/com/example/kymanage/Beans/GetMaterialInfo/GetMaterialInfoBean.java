package com.example.kymanage.Beans.GetMaterialInfo;

import com.example.kymanage.Beans.General.CodeMessageBean;

/**
 * 物料编号       MaterialCode
 * 物料描述       MaterialDescription
 * 物料类型       Type
 * 规格型号       Specifications
 * 备注           Remark
 * 供应工厂       FeedFactory
 * 供应仓库       FeedStorage
 * 需求工厂       DemandFactory
 * 需求仓库       DemandStorage
 *
 * status   CodeMessageBean
 */
public class GetMaterialInfoBean {

    private String MaterialCode;
    private String MaterialDescription;
    private String Type;
    private String Specifications;
    private String Remark;
    private String FeedFactory;
    private String FeedStorage;
    private String DemandFactory;
    private String DemandStorage;
    private CodeMessageBean status;

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getMaterialDescription() {
        return MaterialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        MaterialDescription = materialDescription;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSpecifications() {
        return Specifications;
    }

    public void setSpecifications(String specifications) {
        Specifications = specifications;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getFeedFactory() {
        return FeedFactory;
    }

    public void setFeedFactory(String feedFactory) {
        FeedFactory = feedFactory;
    }

    public String getFeedStorage() {
        return FeedStorage;
    }

    public void setFeedStorage(String feedStorage) {
        FeedStorage = feedStorage;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        DemandFactory = demandFactory;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        DemandStorage = demandStorage;
    }

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
