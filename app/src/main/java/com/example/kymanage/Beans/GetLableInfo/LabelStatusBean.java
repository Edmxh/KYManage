package com.example.kymanage.Beans.GetLableInfo;

import java.util.List;

/**
 * "data": [
 *         {
 *             "Status": "采购收货",
 *             "Description": "螺丝",
 *             "Chargeman": "张飞",
 *             "ScanTime": "2020-1-8",
 *             "MaterialCode": "cs001"
 *         }
 *     ]
 */
public class LabelStatusBean {
    private List<DataBean3> data;

    public List<DataBean3> getData() {
        return data;
    }

    public void setData(List<DataBean3> data) {
        this.data = data;
    }
}
