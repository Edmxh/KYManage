package com.example.kymanage.Beans.GetIssueNoteDetail;

import java.util.List;

/**
 *  {
 *             "MaterialDesc": "",
 *             "MarketOrderNO": "0010000073",
 *             "data": [
 *                 {
 *                     "MaterialDesc": "",
 *                     "IssueQty": 1.0,
 *                     "DemandQty": 0.0,
 *                     "LastQty": 0.0,
 *                     "MaterialCode": "20000012"
 *                 }
 *             ],
 *             "ProductOrderNO": "000010031163",
 *             "MaterialCode": "BJ6515000412",
 *             "MarketOrderRow": "000016"
 *         }
 */
public class GetIssueNoteDetailBean2 {
    private String MaterialDesc;
    private String MarketOrderNO;
    private List<GetIssueNoteDetailBean1> data;
    private String ProductOrderNO;
    private String MaterialCode;
    private String MarketOrderRow;

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

    public List<GetIssueNoteDetailBean1> getData() {
        return data;
    }

    public void setData(List<GetIssueNoteDetailBean1> data) {
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
