package com.example.kymanage.Beans.GetMaterialMasterDataJS;

/**
 * {
 *         "MAKTX": "插头/MC200-E1_6pin",
 *         "LGPRO": "2100",
 *         "SBDKZ": "2",
 *         "WERKS": "2010",
 *         "materialType": "专有",
 *         "LGFSB": "2100",
 *         "MEINS": "EA",
 *         "LABOR": "001",
 *         "MATNR": "DQ5095000031"
 *     }
 */
public class GetMaterialMasterDataInfo {
    private String MAKTX;
    private String LGPRO;
    private String SBDKZ;
    private String WERKS;
    private String materialType;
    private String LGFSB;
    private String MEINS;
    private String LABOR;
    private String MATNR;
    private String marketorderno;
    private String marketorderrow;


    public String getMAKTX() {
        return MAKTX;
    }

    public void setMAKTX(String MAKTX) {
        this.MAKTX = MAKTX;
    }

    public String getLGPRO() {
        return LGPRO;
    }

    public void setLGPRO(String LGPRO) {
        this.LGPRO = LGPRO;
    }

    public String getSBDKZ() {
        return SBDKZ;
    }

    public void setSBDKZ(String SBDKZ) {
        this.SBDKZ = SBDKZ;
    }

    public String getWERKS() {
        return WERKS;
    }

    public void setWERKS(String WERKS) {
        this.WERKS = WERKS;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getLGFSB() {
        return LGFSB;
    }

    public void setLGFSB(String LGFSB) {
        this.LGFSB = LGFSB;
    }

    public String getMEINS() {
        return MEINS;
    }

    public void setMEINS(String MEINS) {
        this.MEINS = MEINS;
    }

    public String getLABOR() {
        return LABOR;
    }

    public void setLABOR(String LABOR) {
        this.LABOR = LABOR;
    }

    public String getMATNR() {
        return MATNR;
    }

    public void setMATNR(String MATNR) {
        this.MATNR = MATNR;
    }

    public String getMarketorderno() {
        return marketorderno;
    }

    public void setMarketorderno(String marketorderno) {
        this.marketorderno = marketorderno;
    }

    public String getMarketorderrow() {
        return marketorderrow;
    }

    public void setMarketorderrow(String marketorderrow) {
        this.marketorderrow = marketorderrow;
    }
}
