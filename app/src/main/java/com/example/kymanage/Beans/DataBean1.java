package com.example.kymanage.Beans;

public class DataBean1{

    /**
     * {
     * 		"id": 1,
     * 		"ordernum": "001",    采购订单号
     * 		"row": "2",           采购订单行
     * 		"factory": "2000",    分厂
     * 		"code": "zj001",      物料编码
     * 		"area": "A01",        配送场地
     * 		"demand": 10,         需求数量
     * 		"storage": 4,         已入库数量
     * 		"description": "机器人",    物料描述
     * 		"ForceRecive": false,       强制收货
     * 		"class": false        是否专有物料
     *        }
     */
    private long id;
    private String ordernum;
    private String row;
    private String factory;
    private String code;
    private String area;
    private double demand;
    private double storage;
    private String description;
    private boolean ForceRecive;
    private boolean isclass;

    private boolean Check;

    public boolean isCheck() {
        return Check;
    }

    public void setCheck(boolean check) {
        Check = check;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getDemand() {
        return demand;
    }

    public void setDemand(long demand) {
        this.demand = demand;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(long storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isForceRecive() {
        return ForceRecive;
    }

    public void setForceRecive(boolean forceRecive) {
        ForceRecive = forceRecive;
    }

    public boolean isIsclass() {
        return isclass;
    }

    public void setIsclass(boolean isclass) {
        this.isclass = isclass;
    }
}
