package com.example.kymanage.Beans.GetLableInfo;

import java.util.List;

/**
 * {
 *     "area": "A001",
 *     "code": 1.0,
 *     "data": [
 *         {
 *             "Status": "采购收货",
 *             "Description": "螺丝",
 *             "Chargeman": "张飞",
 *             "ScanTime": "2020-1-8",
 *             "MaterialCode": "cs001"
 *         }
 *     ],
 *     "state": "采购收货",
 *     "message": "查询成功"
 * }
 */
public class LabelStatussBean {
    private String area;
    private long code;
    private List<DataBean3> data;
    //private boolean data;
    private String state;
    private String message;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public List<DataBean3> getData() {
        return data;
    }

    public void setData(List<DataBean3> data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
