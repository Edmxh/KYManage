package com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 *  {
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
 *         "outWERKS": "2010",
 *
 *         "UBNO": "",
*          "BUProjectNO": "",
*          "UBDemandQty": "",
*          "DeliveryDate": "2020-09-06-06"
 *       }
 */
public class OutsourceFinishedProductReceivingJSReqBean1 implements Serializable {
   private String outKDAUF;
   private String outKDPOS;
   private String outAUFNR;
   private String outMATNR;
   private String outMAKTX;
   private String outRSNUM;
   private String outRSPOS;
   private float outBDMNG;
   private float outIssueNum;
   private String outMCODE;
   private String outPUNIT;
   private String outRSART;
   private String outWERKS;

   private String outLOGRT;

   private float AlreadyQty;

    public OutsourceFinishedProductReceivingJSReqBean1() {
    }

    public OutsourceFinishedProductReceivingJSReqBean1(String outKDAUF, String outKDPOS, String outAUFNR, String outMATNR, String outMAKTX, String outRSNUM, String outRSPOS, float outBDMNG, float outIssueNum, String outMCODE, String outPUNIT, String outRSART, String outWERKS, String outLOGRT, float alreadyQty) {
        this.outKDAUF = outKDAUF;
        this.outKDPOS = outKDPOS;
        this.outAUFNR = outAUFNR;
        this.outMATNR = outMATNR;
        this.outMAKTX = outMAKTX;
        this.outRSNUM = outRSNUM;
        this.outRSPOS = outRSPOS;
        this.outBDMNG = outBDMNG;
        this.outIssueNum = outIssueNum;
        this.outMCODE = outMCODE;
        this.outPUNIT = outPUNIT;
        this.outRSART = outRSART;
        this.outWERKS = outWERKS;
        this.outLOGRT = outLOGRT;
        AlreadyQty = alreadyQty;
    }

    @JSONField(name = "outKDAUF")
    public String getOutKDAUF() {
        return outKDAUF;
    }
    @JSONField(name = "outKDAUF")
    public void setOutKDAUF(String outKDAUF) {
        this.outKDAUF = outKDAUF;
    }
    @JSONField(name = "outKDPOS")
    public String getOutKDPOS() {
        return outKDPOS;
    }
    @JSONField(name = "outKDPOS")
    public void setOutKDPOS(String outKDPOS) {
        this.outKDPOS = outKDPOS;
    }
    @JSONField(name = "outAUFNR")
    public String getOutAUFNR() {
        return outAUFNR;
    }
    @JSONField(name = "outAUFNR")
    public void setOutAUFNR(String outAUFNR) {
        this.outAUFNR = outAUFNR;
    }
    @JSONField(name = "outMATNR")
    public String getOutMATNR() {
        return outMATNR;
    }
    @JSONField(name = "outMATNR")
    public void setOutMATNR(String outMATNR) {
        this.outMATNR = outMATNR;
    }
    @JSONField(name = "outMAKTX")
    public String getOutMAKTX() {
        return outMAKTX;
    }
    @JSONField(name = "outMAKTX")
    public void setOutMAKTX(String outMAKTX) {
        this.outMAKTX = outMAKTX;
    }
    @JSONField(name = "outRSNUM")
    public String getOutRSNUM() {
        return outRSNUM;
    }
    @JSONField(name = "outRSNUM")
    public void setOutRSNUM(String outRSNUM) {
        this.outRSNUM = outRSNUM;
    }
    @JSONField(name = "outRSPOS")
    public String getOutRSPOS() {
        return outRSPOS;
    }
    @JSONField(name = "outRSPOS")
    public void setOutRSPOS(String outRSPOS) {
        this.outRSPOS = outRSPOS;
    }
    @JSONField(name = "outBDMNG")
    public float getOutBDMNG() {
        return outBDMNG;
    }
    @JSONField(name = "outBDMNG")
    public void setOutBDMNG(float outBDMNG) {
        this.outBDMNG = outBDMNG;
    }
    @JSONField(name = "outIssueNum")
    public float getOutIssueNum() {
        return outIssueNum;
    }
    @JSONField(name = "outIssueNum")
    public void setOutIssueNum(float outIssueNum) {
        this.outIssueNum = outIssueNum;
    }
    @JSONField(name = "outMCODE")
    public String getOutMCODE() {
        return outMCODE;
    }
    @JSONField(name = "outMCODE")
    public void setOutMCODE(String outMCODE) {
        this.outMCODE = outMCODE;
    }
    @JSONField(name = "outPUNIT")
    public String getOutPUNIT() {
        return outPUNIT;
    }
    @JSONField(name = "outPUNIT")
    public void setOutPUNIT(String outPUNIT) {
        this.outPUNIT = outPUNIT;
    }
    @JSONField(name = "outRSART")
    public String getOutRSART() {
        return outRSART;
    }
    @JSONField(name = "outRSART")
    public void setOutRSART(String outRSART) {
        this.outRSART = outRSART;
    }
    @JSONField(name = "outWERKS")
    public String getOutWERKS() {
        return outWERKS;
    }
    @JSONField(name = "outWERKS")
    public void setOutWERKS(String outWERKS) {
        this.outWERKS = outWERKS;
    }


    @JSONField(name = "outLOGRT")
    public String getOutLOGRT() {
        return outLOGRT;
    }
    @JSONField(name = "outLOGRT")
    public void setOutLOGRT(String outLOGRT) {
        this.outLOGRT = outLOGRT;
    }

    @JSONField(name = "AlreadyQty")
    public float getAlreadyQty() {
        return AlreadyQty;
    }
    @JSONField(name = "AlreadyQty")
    public void setAlreadyQty(float alreadyQty) {
        AlreadyQty = alreadyQty;
    }
}
