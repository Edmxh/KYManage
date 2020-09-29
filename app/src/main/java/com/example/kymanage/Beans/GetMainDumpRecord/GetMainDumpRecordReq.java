package com.example.kymanage.Beans.GetMainDumpRecord;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  { "CurrentDate":"2020-05-31", "Handler":"kzheng" }
 */
public class GetMainDumpRecordReq {
    private String CurrentDate;
    private String Handler;
    private String DumpNum;
    private String MarketOrderNO;
    private String MaterialCode;
    private String Factory;

    public GetMainDumpRecordReq() {
    }

    public GetMainDumpRecordReq(String currentDate, String handler, String dumpNum, String marketOrderNO, String materialCode, String factory) {
        CurrentDate = currentDate;
        Handler = handler;
        DumpNum = dumpNum;
        MarketOrderNO = marketOrderNO;
        MaterialCode = materialCode;
        Factory = factory;
    }

    @JSONField(name = "CurrentDate")
    public String getCurrentDate() {
        return CurrentDate;
    }
    @JSONField(name = "CurrentDate")
    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }
    @JSONField(name = "Handler")
    public String getHandler() {
        return Handler;
    }
    @JSONField(name = "Handler")
    public void setHandler(String handler) {
        Handler = handler;
    }
    @JSONField(name = "DumpNum")
    public String getDumpNum() {
        return DumpNum;
    }
    @JSONField(name = "DumpNum")
    public void setDumpNum(String dumpNum) {
        DumpNum = dumpNum;
    }
    @JSONField(name = "MarketOrderNO")
    public String getMarketOrderNO() {
        return MarketOrderNO;
    }
    @JSONField(name = "MarketOrderNO")
    public void setMarketOrderNO(String marketOrderNO) {
        MarketOrderNO = marketOrderNO;
    }
    @JSONField(name = "MaterialCode")
    public String getMaterialCode() {
        return MaterialCode;
    }
    @JSONField(name = "MaterialCode")
    public void setMaterialCode(String materialCode) {
        MaterialCode = materialCode;
    }
    @JSONField(name = "Factory")
    public String getFactory() {
        return Factory;
    }
    @JSONField(name = "Factory")
    public void setFactory(String factory) {
        Factory = factory;
    }
}
