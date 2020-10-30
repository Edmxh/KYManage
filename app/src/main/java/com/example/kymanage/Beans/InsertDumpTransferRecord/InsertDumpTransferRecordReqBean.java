package com.example.kymanage.Beans.InsertDumpTransferRecord;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InsertDumpTransferRecordReqBean {
    private long ID;

    public InsertDumpTransferRecordReqBean(long ID) {
        this.ID = ID;
    }

    @JSONField(name = "ID")
    public long getID() {
        return ID;
    }
    @JSONField(name = "ID")
    public void setID(long ID) {
        this.ID = ID;
    }
}
