package com.example.kymanage.Beans;

import com.example.kymanage.Beans.UpdateStorage.UpdateStorageReq;

import java.util.List;

/**
 * {
 * 	"data": [{
 *       "ReceiveDate":"2020-3-4 17:41:42",
 * 		"receNum": 2,
 * 		"orderNum": "001",
 * 		"orderRow": "1",
 * 		"materialCode": "LJ000245",
 * 		"class": false,
 * 		"forcereceive": false,
 * 		"remark": "该物料来源于新供应商",
 * 		"batch": 3,
 * 		"batchNum": [1, 2, 3]
 *        }]
 * }
 */
public class ReceiveDatasBean {
    List<UpdateStorageReq> data;

    public List<UpdateStorageReq> getData() {
        return data;
    }

    public void setData(List<UpdateStorageReq> data) {
        this.data = data;
    }




}
