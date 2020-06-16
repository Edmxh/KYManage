package com.example.kymanage.Beans.GetPurchaseOrderInfoJS;

import java.util.List;

/**
 *{
 *     "code": 1.0,
 *     "data": [
 *         {
 *             "EBELN": "4800000034",
 *             "LGPRO": "2906",
 *             "WERKS": "2090",
 *             "EBELP": "00010",
 *             "materialType": "",
 *             "MENGE": 495,
 *             "LGFSB": "2906",
 *             "MEINS": "EA",
 *             "SBDKZ": "",
 *             "KINDS": "10",
 *             "WESBS": 0,
 *             "CGTXT": "",
 *             "LABOR": "",
 *             "TXZ01": "护罩",
 *             "MATNR": "LJ6025009377-TZ2010041018"
 *         }
 *     ],
 *     "message": "查询成功"
 * }
 */
public class GetPurchaseOrderInfoJSReps {
    private int code;
    private List<GetPurchaseOrderInfoJSRep> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<GetPurchaseOrderInfoJSRep> getData() {
        return data;
    }

    public void setData(List<GetPurchaseOrderInfoJSRep> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
