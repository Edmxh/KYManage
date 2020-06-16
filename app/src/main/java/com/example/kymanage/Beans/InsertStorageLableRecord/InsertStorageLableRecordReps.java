package com.example.kymanage.Beans.InsertStorageLableRecord;

import java.util.List;

/**
 *  "code": 1.0,
 *     "message": "生成标签记录成功",
 *     "lables": [
 */
public class InsertStorageLableRecordReps {
    private int code;
    private String message;
    private List<InsertStorageLableRecordRep> lables;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<InsertStorageLableRecordRep> getLables() {
        return lables;
    }

    public void setLables(List<InsertStorageLableRecordRep> lables) {
        this.lables = lables;
    }
}
