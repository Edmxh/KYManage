package com.example.kymanage.Beans.GetIssueNoteDetail;

import java.util.List;

public class KFLabelBean {
    private String MaterialDesc;
    private String MarketOrderNO;
    private GetIssueNoteDetailBean1 data;
    private String ProductOrderNO;
    private String MaterialCode;
    private String MarketOrderRow;

    public KFLabelBean() {
    }

    public KFLabelBean(String materialDesc, String marketOrderNO, GetIssueNoteDetailBean1 data, String productOrderNO, String materialCode, String marketOrderRow) {
        MaterialDesc = materialDesc;
        MarketOrderNO = marketOrderNO;
        this.data = data;
        ProductOrderNO = productOrderNO;
        MaterialCode = materialCode;
        MarketOrderRow = marketOrderRow;
    }

    public String getMaterialDesc() {
        return MaterialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        MaterialDesc = materialDesc;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }

    public GetIssueNoteDetailBean1 getData() {
        return data;
    }

    public void setData(GetIssueNoteDetailBean1 data) {
        this.data = data;
    }

    public String getProductOrderNO() {
        return ProductOrderNO;
    }

    public void setProductOrderNO(String productOrderNO) {
        ProductOrderNO = productOrderNO;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public String getMarketOrderRow() {
        return MarketOrderRow;
    }

    public void setMarketOrderRow(String marketOrderRow) {
        MarketOrderRow = marketOrderRow;
    }
}
