package com.example.kymanage.Beans;

/**
 * {
 *     "code": 1.0,
 *     "message": "查询标签记录成功",
 *     "lables": {
 *         "Company": "TKAS",
 *         "PORow  ": "1",
 *         "LableSeqNum": "00000000000032",
 *         "Factory": "2000",
 *         "PrintTime": 1578412800000,
 *         "Unit": "cs",
 *         "AreaNO": "A001",
 *         "PrintFactory": "2020-01-08 00:00:00+08",
 *         "Specifications": "cs-001",
 *         "VersionSymbol ": "©",
 *         "MaterialDesc ": "螺丝",
 *         "MaterialCode ": "cs001",
 *         "PO  ": "001",
 *         "Num ": 10.0
 *     }
 * }
 *
 *
 */
public class LabelBean {
    private double code;
    private String message;
    private labelDataBean lables;

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public labelDataBean getLables() {
        return lables;
    }

    public void setLables(labelDataBean lables) {
        this.lables = lables;
    }

    public LabelBean(double code, String message, labelDataBean lables) {
        this.code = code;
        this.message = message;
        this.lables = lables;
    }

    public static class labelDataBean{
        private String Company;
        private String PORow;
        private String LableSeqNum;
        private String Factory;
        private String PrintTime;
        private String Unit;
        private String AreaNO;
        private String PrintFactory;
        private String Specifications;
        private String VersionSymbol;
        private String MaterialDesc;
        private String MaterialCode;
        private String PO;
        private double Num;

        public String getCompany() {
            return Company;
        }

        public void setCompany(String company) {
            Company = company;
        }

        public String getPORow() {
            return PORow;
        }

        public void setPORow(String PORow) {
            this.PORow = PORow;
        }

        public String getLableSeqNum() {
            return LableSeqNum;
        }

        public void setLableSeqNum(String lableSeqNum) {
            LableSeqNum = lableSeqNum;
        }

        public String getFactory() {
            return Factory;
        }

        public void setFactory(String factory) {
            Factory = factory;
        }

        public String getPrintTime() {
            return PrintTime;
        }

        public void setPrintTime(String printTime) {
            PrintTime = printTime;
        }

        public String getUnit() {
            return Unit;
        }

        public void setUnit(String unit) {
            Unit = unit;
        }

        public String getAreaNO() {
            return AreaNO;
        }

        public void setAreaNO(String areaNO) {
            AreaNO = areaNO;
        }

        public String getPrintFactory() {
            return PrintFactory;
        }

        public void setPrintFactory(String printFactory) {
            PrintFactory = printFactory;
        }

        public String getSpecifications() {
            return Specifications;
        }

        public void setSpecifications(String specifications) {
            Specifications = specifications;
        }

        public String getVersionSymbol() {
            return VersionSymbol;
        }

        public void setVersionSymbol(String versionSymbol) {
            VersionSymbol = versionSymbol;
        }

        public String getMaterialDesc() {
            return MaterialDesc;
        }

        public void setMaterialDesc(String materialDesc) {
            MaterialDesc = materialDesc;
        }

        public String getMaterialCode() {
            return MaterialCode;
        }

        public void setMaterialCode(String materialCode) {
            MaterialCode = materialCode;
        }

        public String getPO() {
            return PO;
        }

        public void setPO(String PO) {
            this.PO = PO;
        }

        public double getNum() {
            return Num;
        }

        public void setNum(double num) {
            Num = num;
        }
    }
}


