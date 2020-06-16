package com.example.kymanage.Beans.WriteOffProStorageRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * {"FinProEnterID":"19"}
 */
public class WriteOffProStorageRecordReqBean {
    private String FinProEnterID;

    public WriteOffProStorageRecordReqBean() {
    }

    public WriteOffProStorageRecordReqBean(String finProEnterID) {
        FinProEnterID = finProEnterID;
    }

    @JSONField(name = "FinProEnterID")
    public String getFinProEnterID() {
        return FinProEnterID;
    }
    @JSONField(name = "FinProEnterID")
    public void setFinProEnterID(String finProEnterID) {
        FinProEnterID = finProEnterID;
    }
}
