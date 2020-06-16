package com.example.kymanage.Beans.WarehouseReceiptRecord;

import java.util.List;

/**
 * code
 * message
 * list<></>
 */
public class WarehouseReceiptRecordReps {
   private int code;
   private String message;
   private List<WarehouseReceiptRecordRep> data;

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

    public List<WarehouseReceiptRecordRep> getData() {
        return data;
    }

    public void setData(List<WarehouseReceiptRecordRep> data) {
        this.data = data;
    }
}
