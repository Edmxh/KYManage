package com.example.kymanage.Beans.GetLableInfo;

/**
 * {
 *             "Status": "采购收货",
 *             "Description": "螺丝",
 *             "Chargeman": "张飞",
 *             "ScanTime": "2020-1-8",
 *             "MaterialCode": "cs001"
 *         }
 */
public class DataBean3 {
    private String Status;
    private String Description;
    private String Chargeman;
    private String ScanTime;
    private String MaterialCode;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getChargeman() {
        return Chargeman;
    }

    public void setChargeman(String chargeman) {
        Chargeman = chargeman;
    }

    public String getScanTime() {
        return ScanTime;
    }

    public void setScanTime(String scanTime) {
        ScanTime = scanTime;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }
}
