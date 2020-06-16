package com.example.kymanage.Beans.General;

/**
 * {
 *     "status": {
 *         "code": 1.0,
 *         "message": "收货成功"
 *     }
 * }
 */
public class StatusRespBean {

    private CodeMessageBean status;

    public CodeMessageBean getStatus() {
        return status;
    }

    public void setStatus(CodeMessageBean status) {
        this.status = status;
    }
}
