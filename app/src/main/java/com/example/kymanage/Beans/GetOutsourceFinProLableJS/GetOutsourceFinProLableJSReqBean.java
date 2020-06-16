package com.example.kymanage.Beans.GetOutsourceFinProLableJS;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {
 *            "id": 1,
 *            "orderType": "10",
 *            "AdvanceStorageId":1
 *          }
 */
public class GetOutsourceFinProLableJSReqBean {
    private long id;
    private String orderType;
    private long AdvanceStorageId;

    public GetOutsourceFinProLableJSReqBean(long id, String orderType, long advanceStorageId) {
        this.id = id;
        this.orderType = orderType;
        AdvanceStorageId = advanceStorageId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @JSONField(name = "AdvanceStorageId")
    public long getAdvanceStorageId() {
        return AdvanceStorageId;
    }
    @JSONField(name = "AdvanceStorageId")
    public void setAdvanceStorageId(long advanceStorageId) {
        AdvanceStorageId = advanceStorageId;
    }
}
