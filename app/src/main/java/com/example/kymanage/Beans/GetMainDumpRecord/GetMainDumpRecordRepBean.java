package com.example.kymanage.Beans.GetMainDumpRecord;

/**
 *  {
 *             "DumpNum": "PS2020061514281201",
 *             "CreateTime": "2020-06-15 14:28:12",
 *             "Handler": "xmao",
 *             "ID": 12.0
 *         }
 */
public class GetMainDumpRecordRepBean {
    private String DumpNum;
    private String CreateTime;
    private String UpdateTime;
    private String Handler;
    private String ReverseHandler;
    private String Status;
    private String MarketOrderNO;
    private long ID;

    public String getDumpNum() {
        return DumpNum;
    }

    public void setDumpNum(String dumpNum) {
        DumpNum = dumpNum;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getHandler() {
        return Handler;
    }

    public void setHandler(String handler) {
        Handler = handler;
    }

    public String getReverseHandler() {
        return ReverseHandler;
    }

    public void setReverseHandler(String reverseHandler) {
        ReverseHandler = reverseHandler;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getMarketOrderNO() {
        return MarketOrderNO;
    }

    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }
}
