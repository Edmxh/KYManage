package com.example.kymanage.utils;

import android.graphics.Bitmap;

import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRepBean1;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRepBean2;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRepBean2;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean1;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSBean1;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean2;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean1;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean2;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;
import hardware.print.BarcodeUtil;

public class mPrintUtil {
    int picWidth = 384;//生成图片的宽度
    int QRx = 96;//二维码坐标
    int titleTextSize=34;//统一标题字号
    int text2 = 24;//发料单用
    int text3 = 30;//发料单用


    /**
     * 发料单
     * @param rep
     * @param printHelper
     */
    //发料单打印--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printFLBill(GenerateStorageLssueRecordRep rep, PrintHelper printHelper){
        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType("库房发料单",titleTextSize, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();
        //画二维码
        String content="{\"no\":\""+rep.getIssueListNo()+"\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx*2, picWidth-QRx*2);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        printHelper.PrintBitmapAtCenter(bm,picWidth,picWidth-QRx*2);
        printHelper.PrintLineEnd();
        printHelper.printBlankLine(5);
        //流水号
        String str="流水号："+getSeriesNumber();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        List<GenerateStorageLssueRecordRepBean2> data = rep.getData();
        for (GenerateStorageLssueRecordRepBean2 bean : data) {
            printFLBillContent1(bean,printHelper);
        }

        //底部
        str="-------------------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();
        printHelper.PrintLineInit(text2);
        str="TKAS"+"                 "+getCurrentdate2()+"  "+"RS";
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();


    }
    //发料单第一层内容
    private void printFLBillContent1(GenerateStorageLssueRecordRepBean2 bean,PrintHelper printHelper){

        String str="----------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();

        List<GenerateStorageLssueRecordRepBean1> materials = bean.getData();
        //共有内容
        String newStr1 = bean.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = bean.getMarketOrderRow().replaceAll("^(0+)", "");
        String newStr3 = bean.getProductOrderNO().replaceAll("^(0+)", "");
        str=newStr1+"/"+newStr2+"          "+newStr3;
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="上游部件："+"          "+bean.getMaterialCode();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="上游部件描述："+"     "+bean.getMaterialDesc();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //发料单第二层内容方法
        for (int i = 0; i < materials.size(); i++) {
            GenerateStorageLssueRecordRepBean1 material = materials.get(i);
            printFLBillContent2(material,printHelper);
        }

    }
    //第二层内容
    private void printFLBillContent2(GenerateStorageLssueRecordRepBean1 bean, PrintHelper printHelper){
        String str=bean.getMaterialCode()+"          "+bean.getDemandQty()+"/"+bean.getLastQty()+"/"+bean.getIssueQty()+"-个";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str=bean.getMaterialDesc();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
    }
    //发料单流水号
    public String getSeriesNumber(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDate = sf.format(date0)+Math.round((Math.random()+1) * 1000);//凭证日期
        return currentDate;
    }

    //获取当前日期2
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    /**
     * 派工单
     * @param rep
     * @param printHelper
     */
    //派工单------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printPGBill(GetDispatchListJSRepBean2 rep, PrintHelper printHelper){

        printHelper.printBlankLine(80);
        printHelper.PrintLineEnd();
        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType(rep.getUPFAC(),titleTextSize, PrintHelper.PrintType.Left,true);
        printHelper.PrintLineEnd();

        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType("机加生产派工单",titleTextSize, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();
        //画二维码
        String content="{\"code\":\""+rep.getMATNR()+"\",\"dp\":\""+rep.getDispatchListNO()+"\",\"po\":\""+rep.getAUFNR()+"\",\"no\":\""+rep.getKDAUF()+"\",\"line\":\""+rep.getKDPOS()+"\",\"user\":\""+rep.getUsername()+"\",\"date\":\""+rep.getCreateDate()+"\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx*2, picWidth-QRx*2);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        printHelper.PrintBitmapAtCenter(bm,picWidth,picWidth-QRx*2);
        printHelper.PrintLineEnd();
        printHelper.printBlankLine(5);
        //派工单号
        String str=rep.getDispatchListNO()+"             "+rep.getIssueNum()+" "+rep.getMEINS();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,true);
        printHelper.PrintLineEnd();
        //物料编码
        String matnr1=rep.getMATNR().substring(0,12);
        String matnr2="      "+rep.getMATNR().substring(12);
        str=rep.getMATNR();
        printHelper.PrintLineInit(text3);
        printHelper.PrintLineStringByType(matnr1,text3, PrintHelper.PrintType.Left,true);
        printHelper.PrintLineEnd();
        printHelper.PrintLineInit(text3);
        printHelper.PrintLineStringByType(matnr2,text3, PrintHelper.PrintType.Left,true);
        printHelper.PrintLineEnd();
        //物料描述
        str=rep.getMAKTX();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
        //去0
        String newStr1 = rep.getKDAUF().replaceAll("^(0+)", "");
        String newStr2 = rep.getKDPOS().replaceAll("^(0+)", "");
        String newStr3 = rep.getDWERK().replaceAll("^(0+)", "");
        //销售订单号/行    工厂
        str=newStr1+"/"+newStr2+"        "+newStr3;
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
        //去0
        String newStr4 = rep.getAUFNR().replaceAll("^(0+)", "");
        //生产订单号   打印日期
        str=newStr4+"        "+getCurrentdate1();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //内容行

        for (int i = 0; i < (rep.getData().size()); i++) {
            GetDispatchListJSBean1 bean1 = rep.getData().get(i);
            printPGBillContent1(bean1,printHelper);
        }
        str= rep.getAUFNR().replaceAll("^(0+)", "");
        //底部条形码
        Bitmap bm1=null;
        try {
            bm1=BarcodeUtil.create1dBarcode(str,BarcodeFormat.CODE_128,300,45);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        printHelper.PrintBitmapAtCenter(bm1,picWidth,50);
        printHelper.PrintLineEnd();
        //生产订单号

        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();


        printHelper.printBlankLine(5);
    }
    //获取当前日期
    private String getCurrentdate1(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
    //画图1,机加厂内派工单内容行
    public void printPGBillContent1(GetDispatchListJSBean1 bean,PrintHelper printHelper){
        String str="----------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();

        str=bean.getVORNR().replaceAll("^(0+)", "")+"           "+bean.getLTXA1();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str=bean.getGXCWB();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
    }

    /**
     *跨工厂配送单
     * @param rep
     * @param printHelper
     */

    //跨工厂配送单打印--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printKGCBill(GetDumpRecordNodeRepBean2 rep, PrintHelper printHelper){


        printHelper.printBlankLine(80);
        printHelper.PrintLineEnd();
        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType(rep.getFacName(),titleTextSize, PrintHelper.PrintType.Left,true);
        printHelper.PrintLineEnd();

        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType("机加厂外配送单",titleTextSize, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();
        //画二维码
        String content="{\"code\":\""+rep.getDumpNum()+"\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx*2, picWidth-QRx*2);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        printHelper.PrintBitmapAtCenter(bm,picWidth,picWidth-QRx*2);
        printHelper.PrintLineEnd();
        printHelper.printBlankLine(5);
        //接收事业部
        String str="接收事业部:"+rep.getFactory();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //配送单号:
        str="配送单号:"+rep.getDumpNum();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //总计数量
        str="总计:"+rep.getData().size()+"种/共"+rep.getSumCount()+"个";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //配送人员
        str="配送人员:"+rep.getHandler();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //配送场地
        str="配送场地:"+rep.getArea();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //打印时间
        str="打印时间:"+getCurrentdate2();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //上游部件
        str="上游部件:"+rep.getMaterialCode();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //生产订单号
        str="生产订单号:"+rep.getProductOrderNO().replaceAll("^(0+)", "");
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //销售订单号/行
        String newStr2 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr3 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        str="销售订单号/行:"+newStr2+"/"+newStr3;
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //内容行
        for (int i = 0; i < (rep.getData().size()); i++) {
            GetDumpRecordNodeRepBean1 bean = rep.getData().get(i);
            printKGCBillContent1(bean,printHelper,i);
        }
    }
    //画图1,机加跨工厂配送单内容行
    public void printKGCBillContent1(GetDumpRecordNodeRepBean1 bean,PrintHelper printHelper,int i){
        String str="----------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();

        str=(i+1)+"   "+bean.getMaterialCode();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        String des1="";
        String des2="";
        String des3="";
        if(bean.getMaterialDesc().length()>=15&&bean.getMaterialDesc().length()<=30){
            des1=bean.getMaterialDesc().substring(0,15);
            des2=bean.getMaterialDesc().substring(15,bean.getMaterialDesc().length());
        }else if(bean.getMaterialDesc().length()<15) {
            des1=bean.getMaterialDesc();
        }else {
            des1=bean.getMaterialDesc().substring(0,15);
            des2=bean.getMaterialDesc().substring(15,30);
            des3=bean.getMaterialDesc().substring(30,bean.getMaterialDesc().length());
        }

        String demand=""+bean.getTQty();
        if(bean.getTQty()==0){
            demand="-";
        }
        str=des1+"     "+demand+"/"+bean.getQty();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
        if(!des2.equals("")){
            str=des2;
            printHelper.PrintLineInit(text2);
            printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
            printHelper.PrintLineEnd();
        }
        if(!des3.equals("")){
            str=des3;
            printHelper.PrintLineInit(text2);
            printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
            printHelper.PrintLineEnd();
        }
    }


    /**
     *厂内配送单
     * @param rep
     * @param printHelper
     */

    //厂内配送单打印--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printCNBill(GetCMInFactoryDeliverJSRepBean2 rep, PrintHelper printHelper){
        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType("机加厂内配送单",titleTextSize, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();
        //画二维码
        String content="{\"code\":\""+rep.getDeliverID()+"\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx*2, picWidth-QRx*2);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        printHelper.PrintBitmapAtCenter(bm,picWidth,picWidth-QRx*2);
        printHelper.PrintLineEnd();
        printHelper.printBlankLine(5);
        //
        String str=rep.getDeliverID()+"    "+rep.getIssueStorage();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //
        str=rep.getCreateUser()+"    "+rep.getCreateTime();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();


        //内容行
        for (int i = 0; i < (rep.getData().size()); i++) {
            GetCMInFactoryDeliverJSRepBean2.GetCMInFactoryDeliverJSRepBean1 bean = rep.getData().get(i);
            printCNBillContent1(bean,printHelper,i);
        }
    }
    //画图1,厂内配送单内容行
    public void printCNBillContent1(GetCMInFactoryDeliverJSRepBean2.GetCMInFactoryDeliverJSRepBean1 bean, PrintHelper printHelper, int i){
        String str="----------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();

        str=(i+1)+"        "+bean.getMaterialCode();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str=bean.getMaterialDesc();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str=bean.getProductMaterialCode();
        printHelper.PrintLineInit(text2-2);
        printHelper.PrintLineStringByType(str,(text2-2), PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        String newStr1 = bean.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = bean.getMarketOrderRow().replaceAll("^(0+)", "");

        str=newStr1+"/"+newStr2+"    "+bean.getClient();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        String newStr3 = bean.getProductNO().replaceAll("^(0+)", "");
        str=newStr3+"    "+bean.getDemandQty()+"/"+bean.getActuallyQty();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
    }



    //销售发货单打印--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void printXSFHBill(GetDeliveryListInfoJSRepBean2 rep, PrintHelper printHelper){
        printHelper.PrintLineInit(titleTextSize);
        printHelper.PrintLineStringByType("TKAS-CM送货单",titleTextSize, PrintHelper.PrintType.Centering,false);
        printHelper.PrintLineEnd();
        //
        String str="编号："+rep.getVBELN_VL();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //
        str="送货时间："+getCurrentdate1();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //
        str="送货单位："+rep.getNAME_ORG1();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //
        str="确认："+"              "+"   年   月   日";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        //
        str="配货："+"              "+"   年   月   日";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();


        //内容行
        for (int i = 0; i < (rep.getData().size()); i++) {
            GetDeliveryListInfoJSRepBean1 bean = rep.getData().get(i);
            printXSFHBillContent1(bean,printHelper,i);
        }
    }

    private void printXSFHBillContent1(GetDeliveryListInfoJSRepBean1 bean,PrintHelper printHelper, int i){
        String str="----------------------------------------------------------------------------------";
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,true);
        printHelper.PrintLineEnd();

        str="序号："+(i+1);
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="工作号："+bean.getZZGZBH();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        String matnr1;
        String matnr2;
        if(bean.getMATNR().length()<=15){
            matnr1=bean.getMATNR();
            matnr2="";
        }else {
            matnr1=bean.getMATNR().substring(0,15);
            matnr2=bean.getMATNR().substring(15);
        }
        str="物料编码："+matnr1;
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
        if(!matnr2.equals("")){
            str=matnr2;
            printHelper.PrintLineInit(text2);
            printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Centering,false);
            printHelper.PrintLineEnd();
        }

        str="物料名称："+bean.getARKTX();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="发货数量："+bean.getKWMENG();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="客户订单号："+bean.getBSTKD();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();


        String newStr1 = bean.getVBELN().replaceAll("^(0+)", "");
        String newStr2 = bean.getPOSNR().replaceAll("^(0+)", "");
        str="SAP订单："+newStr1+"/"+newStr2;
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();

        str="状态描述："+bean.getSTATUS();
        printHelper.PrintLineInit(text2);
        printHelper.PrintLineStringByType(str,text2, PrintHelper.PrintType.Left,false);
        printHelper.PrintLineEnd();
    }
}
