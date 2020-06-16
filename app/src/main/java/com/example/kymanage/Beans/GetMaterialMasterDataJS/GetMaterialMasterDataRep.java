package com.example.kymanage.Beans.GetMaterialMasterDataJS;

/**
 *{
 *     "code": 1.0,
 *     "material": {
 *         "MAKTX": "插头/MC200-E1_6pin",
 *         "LGPRO": "2100",
 *         "SBDKZ": "2",
 *         "WERKS": "2010",
 *         "materialType": "专有",
 *         "LGFSB": "2100",
 *         "MEINS": "EA",
 *         "LABOR": "001",
 *         "MATNR": "DQ5095000031"
 *     },
 *     "message": "查询成功"
 * }
 */
public class GetMaterialMasterDataRep {
    private long code;
    private GetMaterialMasterDataInfo material;
    private String message;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public GetMaterialMasterDataInfo getMaterial() {
        return material;
    }

    public void setMaterial(GetMaterialMasterDataInfo material) {
        this.material = material;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
