package com.example.kymanage.Beans.UpdateSemiStorage;

/**
 * {
 * 	"data":[{
 * 		"PostingDate": "2020-3-4",
 * 		"DocumentDate": "2020-3-5",
 * 		"User":"User",
 * 		"MarketOrderNO":"MarketOrderNO",
 * 		"marketOrderRow":"marketOrderRow",
 * 		"ReceNum": 1,
 * 		"OrderNum": "OrderNum",
 * 		"OrderRow": "OrderRow",
 * 		"MaterialCode": "LJ000245",
 * 		"Class": false,
 * 		"ForceReceive": false,
 * 		"DemandFactory":"DemandFactory",
 * 		"DemandStorage":"DemandStorage"
 *        }]
 *
 * }
 *
 * 		"PostingDate": "2020-3-4",
 * 		"DocumentDate": "2020-3-5",
 * 		"User":"User",
 * 		"MarketOrderNO":"MarketOrderNO",
 * 		"marketOrderRow":"marketOrderRow",
 * 		"ReceNum": 1,
 * 		"OrderNum": "OrderNum",
 * 		"OrderRow": "OrderRow",
 * 		"MaterialCode": "LJ000245",
 * 		"Class": false,
 * 		"ForceReceive": false,
 * 		"DemandFactory":"DemandFactory",
 * 		"DemandStorage":"DemandStorage"
 *        }
 */
public class UpdateSemiStorageReq {
    private String PostingDate;//凭证日期
    private String DocumentDate;//过帐日期
    private String User;//
    private String MarketOrderNO;//
    private String marketOrderRow;//
    private float ReceNum;
    private String OrderNum;
    private String OrderRow;
    private String MaterialCode;
    private boolean Class;
    private boolean ForceReceive;
    private String DemandFactory;
    private String DemandStorage;
    private String ReceiveType;

    public UpdateSemiStorageReq(String postingDate, String documentDate, String user, String marketOrderNO, String marketOrderRow, float receNum, String orderNum, String orderRow, String materialCode, boolean aClass, boolean forceReceive, String demandFactory, String demandStorage,String receiveType) {
        PostingDate = postingDate;
        DocumentDate = documentDate;
        User = user;
        MarketOrderNO = marketOrderNO;
        this.marketOrderRow = marketOrderRow;
        ReceNum = receNum;
        OrderNum = orderNum;
        OrderRow = orderRow;
        MaterialCode = materialCode;
        Class = aClass;
        ForceReceive = forceReceive;
        DemandFactory = demandFactory;
        DemandStorage = demandStorage;
        ReceiveType = receiveType;
    }

    public UpdateSemiStorageReq() {
    }

    public String getPostingDate() {
        return PostingDate;
    }

    public void setPostingDate(String postingDate) {
        PostingDate = postingDate;
    }

    public String getDocumentDate() {
        return DocumentDate;
    }

    public void setDocumentDate(String documentDate) {
        DocumentDate = documentDate;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }

    public String getMarketOrderRow() {
        return marketOrderRow;
    }

    public void setMarketOrderRow(String marketOrderRow) {
        this.marketOrderRow = marketOrderRow;
    }

    public float getReceNum() {
        return ReceNum;
    }

    public void setReceNum(float receNum) {
        ReceNum = receNum;
    }

    public String getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(String orderNum) {
        OrderNum = orderNum;
    }

    public String getOrderRow() {
        return OrderRow;
    }

    public void setOrderRow(String orderRow) {
        OrderRow = orderRow;
    }

    public String getMaterialCode() {
        return MaterialCode;
    }

    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }

    public boolean isClass() {
        return Class;
    }

    public void setClass(boolean aClass) {
        Class = aClass;
    }

    public boolean isForceReceive() {
        return ForceReceive;
    }

    public void setForceReceive(boolean forceReceive) {
        ForceReceive = forceReceive;
    }

    public String getDemandFactory() {
        return DemandFactory;
    }

    public void setDemandFactory(String demandFactory) {
        DemandFactory = demandFactory;
    }

    public String getDemandStorage() {
        return DemandStorage;
    }

    public void setDemandStorage(String demandStorage) {
        DemandStorage = demandStorage;
    }

    public String getReceiveType() {
        return ReceiveType;
    }

    public void setReceiveType(String receiveType) {
        ReceiveType = receiveType;
    }
}
