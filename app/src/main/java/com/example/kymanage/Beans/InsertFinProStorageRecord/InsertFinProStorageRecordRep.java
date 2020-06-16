package com.example.kymanage.Beans.InsertFinProStorageRecord;

import com.example.kymanage.Beans.StatusBean;

/**
 * {
 *     "data": 0.0,
 *     "status": {
 *         "code": 0.0,
 *         "message": "SAP入库失败E:；采购订单订货数量超过了1 EA : LJ4510000719-TZ4020"
 *     }
 * }
 */
public class InsertFinProStorageRecordRep {
    private long data;
    private StatusBean status;

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
