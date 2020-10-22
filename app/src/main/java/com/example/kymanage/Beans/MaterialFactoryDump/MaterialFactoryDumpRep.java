package com.example.kymanage.Beans.MaterialFactoryDump;

import com.example.kymanage.Beans.StatusBean;

import java.util.List;

/**
 * {
 *     "data": [
 *         {
 *             "PID": 32.0
 *         }
 *     ],
 *     "status": {
 *         "code": 1.0,
 *         "message": "事业部转储成功！"
 *     }
 * }
 */
public class MaterialFactoryDumpRep {
    private List<MaterialFactoryDumpRepBean> data;
    private List<MaterialFactoryDumpRepBean2> warnInfo;
    private StatusBean status;

    public List<MaterialFactoryDumpRepBean> getData() {
        return data;
    }

    public void setData(List<MaterialFactoryDumpRepBean> data) {
        this.data = data;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public List<MaterialFactoryDumpRepBean2> getWarnInfo() {
        return warnInfo;
    }

    public void setWarnInfo(List<MaterialFactoryDumpRepBean2> warnInfo) {
        this.warnInfo = warnInfo;
    }
}
