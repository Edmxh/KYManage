package com.example.kymanage.Beans.GetStockInformationDataJS;

/**
 * {
 *     "code": 1.0,
 *     "data": {
 *         "factory": "2010",
 *         "materialDesc": "插头/MC200-E1_6pin",
 *         "materialType": "专有",
 *         "Qty": "0.000",
 *         "materialCode": "DQ5095000031",
 *         "storage": "2100"
 *     },
 *     "message": "查询成功"
 * }
 */
public class GetStockInformationDataJSRep {
    private int code;
    private String message;
    private GetStockInformationDataJSBean data;

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

    public GetStockInformationDataJSBean getData() {
        return data;
    }

    public void setData(GetStockInformationDataJSBean data) {
        this.data = data;
    }
}
