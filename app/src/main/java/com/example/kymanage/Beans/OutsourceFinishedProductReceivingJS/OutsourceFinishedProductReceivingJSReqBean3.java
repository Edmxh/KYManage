package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * {
 *     "OrderType": "10",
 *     "demandFactory": "2090",
 *     "demandStorage": "2906",
 *     "description": "拖链导槽|Q235A",
 *     "materialCode": "LJ7015001194",
 *     "materialType": "独立",
 *     "orderNum": "4800000036",
 *     "orderRow": "00010",
 *     "KINDS": "10",
 *     "recNum": 2,
 *     "remark": "采购备注",
 *     "unit": "EA",
 *     "inProduct": {
 *       "KDAUF": "0010000208",
 *       "KDPOS": "000026",
 *       "AUFNR": "000010048078",
 *       "MATNR": "LJ7015001194",
 *       "MAKTX": "支架加工完成半成品",
 *       "UNIT": "EA",
 *       "PMATNR": "LJ7015001194",
 *       "PMAKTX": "支架加工完成半成品",
 *       "PUNIT": "EA",
 *       "RSNUM": "0000095028",
 *       "RSPOS": "0001",
 *       "BDMNG": 5,
 *       "issueNum": 2,
 *       "MCODE": "1234",
 *       "RSART": ""
 *     },
 *     "outProduct": [
 *       {
 *         "outKDAUF": "0010000208",
 *         "outKDPOS": "000026",
 *         "outAUFNR": "000010048078",
 *         "outMATNR": "LJ2015000594-A01",
 *         "outMAKTX": "支架加工完成半成品",
 *         "outRSNUM": "0000095028",
 *         "outRSPOS": "0001",
 *         "outBDMNG": 5,
 *         "outIssueNum": 2,
 *         "outMCODE": "1234",
 *         "outPUNIT": "EA",
 *         "outRSART": "1",
 *         "outWERKS": "2010"
 *       }
 *     ]
 *   }
 */
public class OutsourceFinishedProductReceivingJSReqBean3 implements Serializable {
    private String demandFactory;
    private String demandStorage;
    private String description;
    private String materialCode;
    private String materialType;
    private String orderNum;
    private String orderRow;
    private String KINDS;
    private float recNum;
    private String remark;
    private String unit;
    private OutsourceFinishedProductReceivingJSReqBean2 inProduct;
    private List<OutsourceFinishedProductReceivingJSReqBean1> outProduct;

    public OutsourceFinishedProductReceivingJSReqBean3() {
    }

    public OutsourceFinishedProductReceivingJSReqBean3(String demandFactory, String demandStorage, String description, String materialCode, String materialType, String orderNum, String orderRow, String KINDS, float recNum, String remark, String unit, OutsourceFinishedProductReceivingJSReqBean2 inProduct, List<OutsourceFinishedProductReceivingJSReqBean1> outProduct) {
        this.demandFactory = demandFactory;
        this.demandStorage = demandStorage;
        this.description = description;
        this.materialCode = materialCode;
        this.materialType = materialType;
        this.orderNum = orderNum;
        this.orderRow = orderRow;
        this.KINDS = KINDS;
        this.recNum = recNum;
        this.remark = remark;
        this.unit = unit;
        this.inProduct = inProduct;
        this.outProduct = outProduct;
    }
    @JSONField(name = "demandFactory")
    public String getDemandFactory() {
        return demandFactory;
    }
    @JSONField(name = "demandFactory")
    public void setDemandFactory(String demandFactory) {
        this.demandFactory = demandFactory;
    }
    @JSONField(name = "demandStorage")
    public String getDemandStorage() {
        return demandStorage;
    }
    @JSONField(name = "demandStorage")
    public void setDemandStorage(String demandStorage) {
        this.demandStorage = demandStorage;
    }
    @JSONField(name = "description")
    public String getDescription() {
        return description;
    }
    @JSONField(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }
    @JSONField(name = "materialCode")
    public String getMaterialCode() {
        return materialCode;
    }
    @JSONField(name = "materialCode")
    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }
    @JSONField(name = "materialType")
    public String getMaterialType() {
        return materialType;
    }
    @JSONField(name = "materialType")
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    @JSONField(name = "orderNum")
    public String getOrderNum() {
        return orderNum;
    }
    @JSONField(name = "orderNum")
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    @JSONField(name = "orderRow")
    public String getOrderRow() {
        return orderRow;
    }
    @JSONField(name = "orderRow")
    public void setOrderRow(String orderRow) {
        this.orderRow = orderRow;
    }
    @JSONField(name = "KINDS")
    public String getKINDS() {
        return KINDS;
    }
    @JSONField(name = "KINDS")
    public void setKINDS(String KINDS) {
        this.KINDS = KINDS;
    }
    @JSONField(name = "recNum")
    public float getRecNum() {
        return recNum;
    }
    @JSONField(name = "recNum")
    public void setRecNum(float recNum) {
        this.recNum = recNum;
    }
    @JSONField(name = "remark")
    public String getRemark() {
        return remark;
    }
    @JSONField(name = "remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @JSONField(name = "unit")
    public String getUnit() {
        return unit;
    }
    @JSONField(name = "unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }
    @JSONField(name = "inProduct")
    public OutsourceFinishedProductReceivingJSReqBean2 getInProduct() {
        return inProduct;
    }
    @JSONField(name = "inProduct")
    public void setInProduct(OutsourceFinishedProductReceivingJSReqBean2 inProduct) {
        this.inProduct = inProduct;
    }
    @JSONField(name = "outProduct")
    public List<OutsourceFinishedProductReceivingJSReqBean1> getOutProduct() {
        return outProduct;
    }
    @JSONField(name = "outProduct")
    public void setOutProduct(List<OutsourceFinishedProductReceivingJSReqBean1> outProduct) {
        this.outProduct = outProduct;
    }
}
