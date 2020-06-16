package com.example.kymanage.Beans.GetOutStorageMaterialOrderJS;

import java.util.List;

/**
 * {
 *     "code": 0.0,
 *     "data": [
 *         {
 *             "WEMNG": 0,
 *             "MEINS": "EA",
 *             "AUFNR": "000010044339",
 *             "PSMNG": 4,
 *             "MATNRR": "LJ5540008372-TZ4010000000",
 *             "WERKSR": "2090"
 *         }
 *     ],
 *     "message": "查询成功"
 * }
 */
public class GetOutStorageMaterialOrderJSRep {
    private int code;
    private List<GetOutStorageMaterialOrderJSRepBean> data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<GetOutStorageMaterialOrderJSRepBean> getData() {
        return data;
    }

    public void setData(List<GetOutStorageMaterialOrderJSRepBean> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
