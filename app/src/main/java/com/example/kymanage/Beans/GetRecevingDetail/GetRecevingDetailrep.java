package com.example.kymanage.Beans.GetRecevingDetail;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 *{
 * 		"orderNum": "001",
 * 		"row": "2",
 * 		"factory": "2000",
 * 		"code": "zj001",
 * 		"demand": 10,
 * 		"description": "机器人",
 *      "unit":"E",
 *      "remark":"采购备注",
 *      "materialType"："独立",
 *      "orderType":'半成品'
 *        }
 */
public class GetRecevingDetailrep implements Serializable {
    private String orderNum;
    private String row;
    private String factory;
    private String code;
    private float demand;
    private String description;
    private String unit;
    private String remark;
    private String materialType;
    private String orderType;
    private float inStorageQty;
    private float currentQty;


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDemand() {
        return demand;
    }

    public void setDemand(float demand) {
        this.demand = demand;
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

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public float getInStorageQty() {
        return inStorageQty;
    }

    public void setInStorageQty(float inStorageQty) {
        this.inStorageQty = inStorageQty;
    }

    public float getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(float currentQty) {
        this.currentQty = currentQty;
    }
}
