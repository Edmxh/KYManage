package com.example.kymanage.Beans.Semi_FinishedProductReceiving;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * {
 *             "receNum": 5,
 *             "orderNum": "pliu4100011737",
 *             "orderRow": "00010",
 *             "materialCode": "pliu20000000",
 *             "materialType": "专有",
 *             "demandFactory": "2010",
 *             "demandStorage": "2912",
 *             "description": "pliu机器人",
 *             "unit": "EA",
 *             "remark": "Remark",
 *             "productOrder": [
 *                 {
 *                     "orderNo": "pliu0011",
 *                     "issueNum": 2
 *                 },
 *                 {
 *                     "orderNo": "pliu0022",
 *                     "issueNum": 3
 *                 }
 *             ]
 *         }
 */
public class Semi_FinishedProductReceivingReq {
    private String marketOrderNO;
    private String marketOrderRow;
    private String upstreamFactory;
    private float receNum;
    private float inStorage;
    private float demandNum;
    private String orderNum;
    private String orderRow;
    private String materialCode;
    private String materialType;
    private String demandFactory;
    private String demandStorage;
    private String description;
    private String unit;
    private String remark;
    private List<Semi_FinishedProductReceivingReqBean> productOrder;

    public Semi_FinishedProductReceivingReq() {
    }

    public Semi_FinishedProductReceivingReq(String marketOrderNO, String marketOrderRow, String upstreamFactory, float receNum, float inStorage, float demandNum, String orderNum, String orderRow, String materialCode, String materialType, String demandFactory, String demandStorage, String description, String unit, String remark, List<Semi_FinishedProductReceivingReqBean> productOrder) {
        this.marketOrderNO = marketOrderNO;
        this.marketOrderRow = marketOrderRow;
        this.upstreamFactory = upstreamFactory;
        this.receNum = receNum;
        this.inStorage = inStorage;
        this.demandNum = demandNum;
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.materialCode = materialCode;
        this.materialType = materialType;
        this.demandFactory = demandFactory;
        this.demandStorage = demandStorage;
        this.description = description;
        this.unit = unit;
        this.remark = remark;
        this.productOrder = productOrder;
    }

    @JSONField(name = "marketOrderNO")
    public String getMarketOrderNO() {
        return marketOrderNO;
    }
    @JSONField(name = "marketOrderNO")
    public void setMarketOrderNO(String marketOrderNO) {
        this.marketOrderNO = marketOrderNO;
    }

    public String getMarketOrderRow() {
        return marketOrderRow;
    }

    public void setMarketOrderRow(String marketOrderRow) {
        this.marketOrderRow = marketOrderRow;
    }

    public String getUpstreamFactory() {
        return upstreamFactory;
    }

    public void setUpstreamFactory(String upstreamFactory) {
        this.upstreamFactory = upstreamFactory;
    }

    public float getReceNum() {
        return receNum;
    }

    public void setReceNum(float receNum) {
        this.receNum = receNum;
    }

    @JSONField(name = "inStorage")
    public float getInStorage() {
        return inStorage;
    }
    @JSONField(name = "inStorage")
    public void setInStorage(float inStorage) {
        this.inStorage = inStorage;
    }
    @JSONField(name = "demandNum")
    public float getDemandNum() {
        return demandNum;
    }
    @JSONField(name = "demandNum")
    public void setDemandNum(float demandNum) {
        this.demandNum = demandNum;
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

    public String getDemandStorage() {
        return demandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        this.demandStorage = demandStorage;
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
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Semi_FinishedProductReceivingReqBean> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<Semi_FinishedProductReceivingReqBean> productOrder) {
        this.productOrder = productOrder;
    }
}
