package com.example.kymanage.Beans.GetPurWayMaterialData;

import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;

import java.util.List;

/**
 * {
 *     "code": 1.0,
 *     "data": {
 *         "MaterialDesc": "插头/MC200-E1_6pin",
 *         "InQty": 0.0,
 *         "Qty": 1.0,
 *         "PreQty": 1.0,
 *         "MaterialCode": "DQ5095000031"
 *     },
 *     "storage": [
 *         {
 *             "id": "0001",
 *             "desc": "Lager 0001"
 *         },
 *         {
 *             "id": "0088",
 *             "desc": "Lager 0088 (WM)"
 *         }
 *     ],
 *     "message": "查询成功"
 * }
 */
public class GetPurWayMaterialDataRep {
    private long code;
    private GetPurWayMaterialDataBean data;
    private String message;
    private List<iddesBean> storage;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public GetPurWayMaterialDataBean getData() {
        return data;
    }

    public void setData(GetPurWayMaterialDataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<iddesBean> getStorage() {
        return storage;
    }

    public void setStorage(List<iddesBean> storage) {
        this.storage = storage;
    }
}
