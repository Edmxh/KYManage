package com.example.kymanage.Beans.GetCMInFactoryDeliver;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * {
 *     "code": 1.0,
 *     "deliverNO": [
 *         "15965290453870"
 *     ],
 *     "message": "生成厂内配送单信息成功"
 * }
 */
public class GetCMInFactoryDeliverRep {
    private int code;
    private String message;
    private List<String>  deliverNO;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JSONField(name = "deliverNO")
    public List<String> getDeliverNO() {
        return deliverNO;
    }
    @JSONField(name = "deliverNO")
    public void setDeliverNO(List<String> deliverNO) {
        this.deliverNO = deliverNO;
    }
}
