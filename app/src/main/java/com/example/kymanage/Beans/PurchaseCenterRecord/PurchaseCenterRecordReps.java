package com.example.kymanage.Beans.PurchaseCenterRecord;

import com.example.kymanage.Beans.General.CodeMessageBean;

import java.util.List;

/**
 * {
 *     "data": [
 *         {
 *             "code": "1",
 *             "materialType": "1",
 *             "orderNum": "1",
 *             "description": "1",
 *             "ID": 19,
 *             "row": "1",
 *             "receiveNum": 1.0
 *         },
 *         {
 *             "code": "2",
 *             "materialType": "2",
 *             "orderNum": "2",
 *             "description": "2",
 *             "ID": 20,
 *             "row": "2",
 *             "receiveNum": 2.0
 *         }
 *     ],
 *     "status": {
 *         "code": 1.0,
 *         "message": "查询成功"
 *     }
 * }
 */
public class PurchaseCenterRecordReps {
    private List<PurchaseCenterRecordRep> data;
    private CodeMessageBean status;

    public List<PurchaseCenterRecordRep> getData() {
        return data;
    }

    public void setData(List<PurchaseCenterRecordRep> data) {
        this.data = data;
    }

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
