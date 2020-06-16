package com.example.kymanage.Beans.GetCMInFactoryDeliver;

import java.util.List;

/**
 * {
 *     "DeliverID": "15918649118229",
 *     "code": 1.0,
 *     "data": [
 *         {
 *             "MaterialDesc": "支架加工完成半成品",
 *             "MarketOrderNO": "0010000208",
 *             "DemandQty": 1000.0,
 *             "ProductOrderNO": "000010048078",
 *             "Unit": "EA",
 *             "Client": "工厂自动化",
 *             "MaterialCode": "LJ2015000594-A01",
 *             "MarketOrderRow": "000026",
 *             "DispatchQty": 3.0,
 *             "ProductMaterialCode": "LJ2015000594-TZ2010043020"
 *         }
 *     ],
 *     "CreateTime": "2020-06-11 11:11:11",
 *     "CreateUser": "pliu",
 *     "message": "获取厂内配送单信息成功",
 *     "StorageDescription": "半成品库"
 * }
 */
public class GetCMInFactoryDeliverRep {
    private String DeliverID;
    private int code;
    private List<GetCMInFactoryDeliverRepBean> data;
    private String CreateTime;
    private String CreateUser;
    private String message;
    private String StorageDescription;

    public String getDeliverID() {
        return DeliverID;
    }

    public void setDeliverID(String deliverID) {
        DeliverID = deliverID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<GetCMInFactoryDeliverRepBean> getData() {
        return data;
    }

    public void setData(List<GetCMInFactoryDeliverRepBean> data) {
        this.data = data;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(String createUser) {
        CreateUser = createUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStorageDescription() {
        return StorageDescription;
    }

    public void setStorageDescription(String storageDescription) {
        StorageDescription = storageDescription;
    }
}
