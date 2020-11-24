package com.example.kymanage.Bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean1;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean3;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean1;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean2;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean1;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean2;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.KFLabelBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRepBean;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hardware.print.BarcodeUtil;

public class CreateBitmap{

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
    //获取当前日期
    private String getCurrentdate1(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
    //发料单流水号
    public String getSeriesNumber(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");
        String currentDate = sf.format(date0)+Math.round((Math.random()+1) * 1000);//凭证日期
        return currentDate;
    }

    //画图1,采购标签
    public Bitmap createImage1(GetParchaseCenterLableRep rep,int index, Typeface tf) {
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getNum()+",\"aid\":"+rep.getAdvanceStorageId()+",\"num\":\""+getSeriesNumber()+"\",\"po\":\""+rep.getProductOrderNO()+"\",\"pono\":\""+rep.getPo()+"\",\"porow\":\""+rep.getPoRow()+"\",\"gc\":\""+rep.getFactory()+"\",\"xh\":"+index+",\"cd\":\""+rep.getAreaNo()+"\",\"cs\":"+rep.getBatchNumber()+"}";
        System.out.println("content:"+content);
        int picWidth = 480;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 250;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 20;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
//        paint.setAntiAlias(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getMaterialDesc();
//        str1="旋转编码器（中空）|E80H30-360-3-N-24";
//        titleTextSize=(QRx)/(str1.length());
        System.out.println();
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<20){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=20&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        String str3=rep.getMaterialCode();
        System.out.println(str3.length());
        if(str3.length()>16){
            paint.setTextSize(text7);
        }else {
            paint.setTextSize(text3);
        }
        paint.setFakeBoldText(true);
        top+=titleTextSize*2+40;
        canvas.drawText(str3,0,top,paint);
        paint.setFakeBoldText(false);

        if(rep.isSeparateLabel()){
            rep.setNum(1);
        }
        String str4="单位:"+rep.getUnit()+" "+"数量:"+(rep.getNum());
        paint.setTextSize(text4);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);

        String str5=rep.getFactory()+"    "+rep.getAreaNo();

        paint.setTextSize(text2);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);

        String str6="";
        if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null||rep.getProductOrderNO()==null){
            if(rep.getShelfNO()!=null){
                str6=""+rep.getShelfNO();
            }
        }else {
            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
            str6=newStr1+"/"+newStr2+" "+newStr3;
        }
        paint.setTextSize(text6);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

        String str7="";
        if(rep.getOrderMaterialCode()==null){
            str7="";
        }else {
            str7=""+rep.getOrderMaterialCode();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str7,0,top,paint);

        String str8="";
        if(rep.getOrderMaterialDesc()==null){
            str8="";
        }else {
            str8=""+rep.getOrderMaterialDesc();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str8,0,top,paint);
        String str13="";
        paint.setTextSize(text3);
        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10=rep.getCompany()+"            "+rep.getPrintTime()+" "+rep.getPrintFactory();
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,0,paint);

        int y1=picWidth-QRx+10;

//        String str11=rep.getLabelSeqNum();
        String strporow = rep.getPoRow().replaceAll("^(0+)", "");
        String str11=rep.getPo()+"/"+strporow+"-"+Math.round((Math.random()+1) * 1000);
        paint.setTextSize(text6);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:";
        if(rep.getRemark()==null){
            str12="备注:";
        }else {
            str12="备注:"+rep.getRemark();
        }
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }
    //画图2,库房标签
    public Bitmap createImage2(KFLabelBean rep, Typeface tf) {
        String content="{\"bm\":\""+rep.getData().getMaterialCode()+"\",\"sl\":"+rep.getData().getIssueQty()+",\"num\":\""+getSeriesNumber()+"\",\"po\":\""+rep.getProductOrderNO()+"\",\"pono\":\""+"\",\"porow\":\""+"\",\"gc\":\""+rep.getData().getIssueFactory()+"\",\"cd\":\""+rep.getData().getArea()+"\"}";
        System.out.println(content);
        int picWidth = 480;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 250;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 20;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
//        paint.setAntiAlias(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getData().getMaterialDesc();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<30){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=30&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        String str3=rep.getData().getMaterialCode();
        paint.setFakeBoldText(true);
        if(str3.length()>16){
            paint.setTextSize(text7);
        }else {
            paint.setTextSize(text3);
        }
        top+=titleTextSize*2+30;
        canvas.drawText(str3,0,top,paint);
        paint.setFakeBoldText(false);

        String str4="单位:"+"EA"+" "+"数量:"+(rep.getData().getIssueQty());
        paint.setTextSize(text3);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);

//        String str5="2010"+"    "+rep.getData().getArea();
        String str5=rep.getData().getIssueFactory()+"/"+rep.getData().getArea()+"/"+rep.getData().getLgpbe();

        paint.setTextSize(text4);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);

        String str6="";
        if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null||rep.getProductOrderNO()==null){
            str6="";
        }else {
            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
            str6=newStr1+"/"+newStr2+" "+newStr3;
        }
        paint.setTextSize(text5);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

        String str7="";
        if(rep.getMaterialCode()==null){
            str7="";
        }else {
            str7=""+rep.getMaterialCode();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str7,0,top,paint);

        String str8="";
        if(rep.getMaterialDesc()==null){
            str8="";
        }else {
            str8=""+rep.getMaterialDesc();
//            str8="泰安五岳专用汽车自卸车前版焊接";
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str8,0,top,paint);
//        String str13=""+rep.getmCode();
//        paint.setTextSize(text3);
//        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10="TKAS"+"             "+getCurrentdate()+" "+"CM";
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,0,paint);

        int y1=picWidth-QRx+10;

        String str11=getSeriesNumber();
        paint.setTextSize(text6);
        canvas.drawText(str11,QRx,y1,paint);
//        String str12="备注:"+rep.getRemark();
//        paint.setTextSize(text4);
//        y1+=text5+lineSpacing;
//        canvas.drawText(str12,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }

    //旋转bitmap
    public static Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree) {
        Matrix m = new Matrix();
        m.setRotate(orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);
        float targetX, targetY;
        if (orientationDegree == 90) {
            targetX = bm.getHeight();
            targetY = 0;
        } else {
            targetX = bm.getHeight();
            targetY = bm.getWidth();
        }

        final float[] values = new float[9];
        m.getValues(values);

        float x1 = values[Matrix.MTRANS_X];
        float y1 = values[Matrix.MTRANS_Y];

        m.postTranslate(targetX - x1, targetY - y1);

        Bitmap bm1 = Bitmap.createBitmap(bm.getHeight(), bm.getWidth(), Bitmap.Config.ARGB_8888);

        Paint paint = new Paint();
        Canvas canvas = new Canvas(bm1);
        canvas.drawBitmap(bm, m, paint);


        return bm1;
    }

    //发料单打印
    public Bitmap createImage3(GetIssueNoteDetailRep rep,Typeface tf) {
//    public Bitmap createImage3() {
        int picWidth = 384;//生成图片的宽度
        int QRx = 96;//二维码坐标
        int height1 = 100+(picWidth-QRx*2);//基础100
        int height2 = 85;//heightone85
        int height3 = 55;//heighttwo55
        int height4 = 30;//bottom 30
        
        int picHeight = height1;//生成图片的高度，基础100+heightone85+heighttwo55+bottom 30
        List<GetIssueNoteDetailBean2> orders = rep.getData();
        for (GetIssueNoteDetailBean2 order : orders) {
            picHeight+=height2;
            List<GetIssueNoteDetailBean1> materials = order.getData();
            for (GetIssueNoteDetailBean1 material : materials) {
                picHeight+=height3;
            }
        }
        picHeight+=height4;
        

        int titleTextSize=34;
        int text1 = 24;
        int text2 = 20;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int lineSpacing = 2;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
//        //从asset 读取字体
////        AssetManager mgr = getAssets();
////        //根据路径得到Typeface
////        Typeface tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
////        paint.setTypeface(tf);

        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);
        paint.setColor(Color.BLACK);
        int top=titleTextSize;
        //标题
        String strTitle="库房发料单";
        paint.setTextSize(titleTextSize);
        int titlex=(picWidth-5*titleTextSize)/2;
        canvas.drawText(strTitle,titlex,top,paint);

        top+=lineSpacing;

        //补二维码
        //画二维码
        String content="{\"no\":\"123456\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx*2, picWidth-QRx*2);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,top,paint);

        top+=(picWidth-QRx*2);



        //凭证号和流水号
//        //凭证号暂时和流水号取同一个值
//        String str1="凭证号："+rep.getSeriesNumber();
//        paint.setTextSize(text1);
//        top+=titleTextSize+lineSpacing;
//        canvas.drawText(str1,0,top,paint);

        String str2="流水号："+getSeriesNumber();
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str2,0,top,paint);

        for (GetIssueNoteDetailBean2 order : orders) {
            top=drawFLContent1( paint, canvas, text1, top, lineSpacing, picWidth,order);
        }

//        top+=(picWidth-height1-height4);
        //横线
        paint.setFakeBoldText(true);
        top+=5;
        canvas.drawLine (0,top,picWidth,top,paint);
        paint.setFakeBoldText(false);

        String str3="TKAS"+"     "+getCurrentdate2()+"  "+"RS";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str3,0,top,paint);

        return result;
    }
    //第一层内容方法
    public int drawFLContent1(Paint paint,Canvas canvas,int text1,int top,int lineSpacing,int picWidth,GetIssueNoteDetailBean2 order) {
        List<GetIssueNoteDetailBean1> materials = order.getData();
        //横线
        paint.setFakeBoldText(true);
        top+=5;
        canvas.drawLine (0,top,picWidth,top,paint);
        paint.setFakeBoldText(false);
        //共有内容
        String newStr1 = order.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = order.getMarketOrderRow().replaceAll("^(0+)", "");
        String newStr3 = order.getProductOrderNO().replaceAll("^(0+)", "");
        String str3=newStr1+"/"+newStr2;
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str3,0,top,paint);
        str3=newStr3;
        canvas.drawText(str3,picWidth/2,top,paint);

        String str4="上游部件：";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);
        str4=order.getMaterialCode();
        canvas.drawText(str4,picWidth/2,top,paint);

        String str5="上游部件描述：";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);
        str5=order.getMaterialDesc();
        canvas.drawText(str5,picWidth/2,top,paint);
        //第二层内容方法
        for (int i = 0; i < materials.size(); i++) {
            GetIssueNoteDetailBean1 material = materials.get(i);
            top+=(55*i);
//            System.out.println("第"+(i+1)+"次drawFLContent2"+top);
            drawFLContent2( paint, canvas, text1, top, lineSpacing, picWidth,material);
        }
        top+=55;
        int result=top;
        return result;
    }
    //第二层内容方法
    public void drawFLContent2(Paint paint,Canvas canvas,int text1,int top,int lineSpacing,int picWidth,GetIssueNoteDetailBean1 material) {
        String str6=material.getMaterialCode();
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str6,0,top,paint);
        str6=material.getDemandQty()+"/"+material.getLastQty()+"/"+material.getIssueQty()+"-个";//"5/2/3-个";
        canvas.drawText(str6,picWidth/2,top,paint);

        String str7=material.getMaterialDesc();
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str7,0,top,paint);
    }


    //画图5,机加厂内派工单超量标签
    public Bitmap createImage5(GetDispatchListJSRepBean3 rep, Typeface tf) {
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getMoreQty()+",\"num\":\""+getSeriesNumber()+"\",\"po\":\""+"\",\"pono\":\""+rep.getMarketOrderNO()+"\",\"porow\":\""+rep.getMarketOrderRow()+"\",\"gc\":\""+rep.getFactory()+"\",\"cd\":\""+rep.getDemandStorage()+"\"}";
        System.out.println(content);
        int picWidth = 480;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 250;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 20;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
//        paint.setAntiAlias(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getDescription();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<25){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=25&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        String str3=rep.getMaterialCode();
        paint.setFakeBoldText(true);
        if(str3.length()>16){
            paint.setTextSize(text7);
        }else {
            paint.setTextSize(text3);
        }
        top+=titleTextSize*2+30;
        canvas.drawText(str3,0,top,paint);
        paint.setFakeBoldText(false);

        String str4="单位:"+rep.getUnit()+" "+"数量:"+(rep.getMoreQty());
        paint.setTextSize(text3);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);

//        String str5="2010"+"    "+rep.getData().getArea();
        String str5=rep.getDemandStorage();

        paint.setTextSize(text4);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);

        String str6="";
        if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null){
            str6="";
        }else {
            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            str6=newStr1+"/"+newStr2;
        }
        paint.setTextSize(text5);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

//        String str7="";
//        if(rep.getMaterialCode()==null){
//            str7="";
//        }else {
//            str7=""+rep.getMaterialCode();
//        }
//        paint.setTextSize(text3);
//        top+=text3+lineSpacing;
//        canvas.drawText(str7,0,top,paint);

        String str13="备注：超量入库";
        paint.setTextSize(text3);
        top+=text2+lineSpacing;
        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing+30;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10="TKAS"+"             "+getCurrentdate()+" "+"CM";
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,0,paint);

        int y1=picWidth-QRx+10;

        String str11=getSeriesNumber();
        paint.setTextSize(text6);
        canvas.drawText(str11,QRx,y1,paint);
//        String str12="备注:"+rep.getRemark();
//        paint.setTextSize(text4);
//        y1+=text5+lineSpacing;
//        canvas.drawText(str12,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }

    public static void drawGrayLine(Canvas canvas, Paint paint, int top){
        paint.setColor(Color.GRAY);
        canvas.drawLine (0,top,380,top,paint);
    }
    public static void drawBlackLine(Canvas canvas,Paint paint,int top){
        paint.setColor(Color.BLACK);
        canvas.drawLine (0,top,380,top,paint);
    }



    //画图6,外协101标签
    public Bitmap createImage6(GetFinProStorageRecordNoteRepBean rep, Typeface tf) {
        String str11=getSeriesNumber();
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getAllocatedQty()+",\"po\":\""+rep.getProductOrderNO()+"\",\"num\":\""+str11+"\",\"no\":\""+rep.getMarketOrderNO()+"\",\"line\":\""+rep.getMarketOrderRow()+"\",\"fid\":"+rep.getID()+",\"gc\":\""+rep.getFactory()+"\",\"cd\":\""+rep.getArea()+"\",\"cs\":\""+""+"\"}";
        System.out.println("content:"+content);
        int picWidth = 530;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 300;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 15;//
        int text8 = 18;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getMaterialDesc();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<30){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=30&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        String str3=rep.getMaterialCode();
        top+=titleTextSize+30;
        textPaint.setTextSize(text3);
        textPaint.setFakeBoldText(true);
        StaticLayout layout2 = new StaticLayout(str3,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);
        canvas.translate(0,top);
        layout2.draw(canvas);

        paint.setFakeBoldText(true);
        String str4="单位:"+rep.getProOMaterialUnit()+" "+"数量:"+(rep.getAllocatedQty());
        paint.setTextSize(text3);
        top+=lineSpacing;
        canvas.drawText(str4,0,top,paint);


        //标签类型 "内部配送（事业部场地）|销售发货（客户）|未知类型（写个2090+）
        String str5="";
        if(rep.getNoteType().equals("内部配送")&&rep.getArea()!=null){
            String area=rep.getArea().equals("")?"-":rep.getArea();
            str5=rep.getFactory()+"  "+rep.getStorage()+"/"+area;
        }else if(rep.getNoteType().equals("销售发货")){
            str5=rep.getClientShortName()+"  "+rep.getClientNO();
        }else {
            str5="2090"+"  "+rep.getSendStorage();
        }


        paint.setTextSize(text3);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);
        paint.setFakeBoldText(false);

        String str6="";
        if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null||rep.getProductOrderNO()==null){
            str6="";
        }else {
            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
            String newStr4 = rep.getPlanOrderNO().replaceAll("^(0+)", "");
            String orderNO=newStr3.equals("")?("*"+newStr4):newStr3;
            str6=newStr1+"/"+newStr2+"   "+orderNO;
        }
        paint.setTextSize(text4);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

        String str7="";
        if(rep.getProOMaterialNO()==null||rep.getProOMaterialNO().equals("")){
            str7=rep.getLgpbz();
        }else {
            str7=""+rep.getProOMaterialNO();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str7,0,top,paint);

        String str8="";
        if(rep.getProOMaterialDesc()==null||rep.getProOMaterialDesc().equals("")){
            str8=rep.getWorkNO();
        }else {
            str8=""+rep.getProOMaterialDesc();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str8,0,top,paint);
        String str13="";
        paint.setTextSize(text3);
        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10="TKAS"+"-"+rep.getFacName()+"         "+rep.getCreateDate()+" "+"CM";
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,-80,paint);

        int y1=170;

        str11=getSeriesNumber();
        paint.setTextSize(text5);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:";
        if(rep.getNoteType().equals("未知类型")||rep.getNoteType().equals("超量入库")){
            str12="备注:"+rep.getNoteType();
        }else {
            str12="备注:";
        }
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }


    //画图7,外协成品收货标签
    public Bitmap createImage7(GetOutsourceFinProLableJSRepBean rep, Typeface tf) {
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getQty()+",\"num\":\""+getSeriesNumber()+"\",\"po\":\""+rep.getProductOrderNO()+"\",\"no\":\""+rep.getMarketOrderNO()+"\",\"line\":\""+rep.getMarketOrderRow()+"\",\"type\":\""+rep.getFType()+"\",\"fid\":"+rep.getId()+",\"gc\":\""+rep.getFactory()+"\",\"cd\":\""+rep.getArea()+"\"}";
        System.out.println(content);
        int picWidth = 530;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 300;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 20;//
        int text8 = 18;//
        int lineSpacing = 2;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getMaterialDesc();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<30){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=30&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);



        String str3=rep.getMaterialCode();
        textPaint.setFakeBoldText(true);
        textPaint.setTextSize(text2);

        top+=titleTextSize+30;
        StaticLayout layout2 = new StaticLayout(str3,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);
        canvas.translate(0,top);
        layout2.draw(canvas);

        paint.setFakeBoldText(true);
        String str4="单位:"+rep.getMaterialUnit()+" "+"数量:"+(rep.getQty());
        paint.setTextSize(text2);
        top+=text2;
        canvas.drawText(str4,0,top,paint);


        if(!rep.getFactory().equals("2090")){
            String area=rep.getArea().equals("")?"-":rep.getArea();
            String str5=rep.getFactory()+"  "+rep.getTargetStorage()+"/"+area;
            paint.setTextSize(text2);
            top+=text1+lineSpacing;
            canvas.drawText(str5,0,top,paint);

            String str6="";
            if(rep.getMarketOrderNO()==null||rep.getMarketOrderNO().equals("")){
                str6=rep.getLgpbz();
            }else {
                String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
                String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
                String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
                String newStr4 = rep.getPlanOrderNO().replaceAll("^(0+)", "");
                String orderNO=newStr3.equals("")?("*"+newStr4):newStr3;//生产订单号字段为空则加*
                str6=newStr1+"/"+newStr2+"   "+orderNO;
            }
            paint.setTextSize(text5);
            top+=text2+lineSpacing;
            canvas.drawText(str6,0,top,paint);

            String str7="";
            if(rep.getProOMaterialNO()==null){
                str7="";
            }else {
                str7=""+rep.getProOMaterialNO();
            }
            paint.setTextSize(text3);
            top+=text3+lineSpacing;
            canvas.drawText(str7,0,top,paint);

            String str8="";
            if(rep.getProOMaterialDesc()==null){
                str8="";
            }else {
                str8=""+rep.getProOMaterialDesc();
            }
            paint.setTextSize(text3);
            top+=text3+lineSpacing;
            canvas.drawText(str8,0,top,paint);
        }else{
            String newStr3 = rep.getClientNO().replaceAll("^(0+)", "");

            String str5=newStr3+"  "+rep.getClientShortName();
            paint.setTextSize(text2);
            top+=text1+lineSpacing;
            canvas.drawText(str5,0,top,paint);

            String str6="";
            if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null){
                str6="";
            }else {
                String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
                String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
//                String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
                str6=newStr1+"/"+newStr2+"   ";
            }
            paint.setTextSize(22);
            top+=text2+lineSpacing;
            canvas.drawText(str6,0,top,paint);

            String str7="";
            if(rep.getProOMaterialNO()==null||rep.getProOMaterialNO().equals("")){
                str7=rep.getLgpbz();
            }else {
                str7=""+rep.getProOMaterialNO();
            }
            paint.setTextSize(text3);
            top+=text3+lineSpacing;
            canvas.drawText(str7,0,top,paint);

            String str8="";
            if(rep.getProOMaterialDesc()==null||rep.getProOMaterialDesc().equals("")){
                str8=rep.getWorkNO();
            }else {
                str8=""+rep.getProOMaterialDesc();
            }
            paint.setTextSize(text3);
            top+=text3+lineSpacing;
            canvas.drawText(str8,0,top,paint);
        }
        paint.setFakeBoldText(false);

//        String str13=""+rep.getmCode();
//        paint.setTextSize(text3);
//        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10=rep.getCompany()+"-"+rep.getUPFAC()+"            "+rep.getPrintTime()+" "+rep.getPrintFactory();
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,-80,paint);

        int y1=170;

        String str11=getSeriesNumber();
        paint.setTextSize(text5);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:"+rep.getRemark();
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);

        String str13=rep.getMCode()==null?"":rep.getMCode();
        paint.setTextSize(text4);
        y1+=(text5+lineSpacing);
        canvas.drawText(str13,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }


    //画图9,超量标签转外协标签
    public Bitmap createImage9(InsertFinAProOrderRecordRep.InsertFinAProOrderRecord rep, Typeface tf) {
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getAllocatedQty()+",\"po\":\""+rep.getProductOrderNO()+"\",\"no\":\""+rep.getMarketOrderNO()+"\",\"line\":\""+rep.getMarketOrderRow()+"\",\"fid\":"+rep.getID()+",\"gc\":\""+rep.getFactory()+"\",\"cd\":\""+rep.getArea()+"\",\"cs\":\""+""+"\"}";
        System.out.println("content:"+content);
        int picWidth = 480;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 250;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 15;//
        int text8 = 20;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getMaterialDesc();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<30){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=30&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        //物料编码换行
        String str3=rep.getMaterialCode();
        textPaint.setFakeBoldText(true);
        textPaint.setTextSize(text2);
        //
        top+=titleTextSize+30;
        StaticLayout layout2 = new StaticLayout(str3,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);
        canvas.translate(0,top);
        layout2.draw(canvas);
        paint.setFakeBoldText(false);

        String str4="单位:"+rep.getProOMaterialUnit()+" "+"数量:"+(rep.getAllocatedQty());
        paint.setTextSize(text5);
        top+=lineSpacing;
        canvas.drawText(str4,0,top,paint);

        //!!!
        String str5="";
        if(rep.getNoteType().equals("销售发货")){
            String cliStr = rep.getClientNO().replaceAll("^(0+)", "");
            str5=cliStr+"  "+rep.getClientShortName();

        }else {
            String area=rep.getArea().equals("")?"-":rep.getArea();
            str5=rep.getFactory()+"  "+rep.getStorage()+"/"+area;
        }


        paint.setTextSize(text5);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);

        String str6="";
        if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null||rep.getProductOrderNO()==null){
            str6="";
        }else {
            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
            str6=newStr1+"/"+newStr2+" "+newStr3;
        }
        paint.setTextSize(text6);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

        String str7="";
        if(rep.getProOMaterialNO()==null){
            str7="";
        }else {
            str7=""+rep.getProOMaterialNO();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str7,0,top,paint);

        String str8="";
        if(rep.getProOMaterialDesc()==null||rep.getProOMaterialDesc().equals("")){
            str8=rep.getWorkNO();
        }else {
            str8=""+rep.getProOMaterialDesc();
        }
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str8,0,top,paint);
        String str13="";
        paint.setTextSize(text3);
        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10="TKAS"+"-"+rep.getFacName()+"         "+rep.getCreateDate()+" "+"CM";
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,-80,paint);

        int y1=170;

        String str11=getSeriesNumber();
        paint.setTextSize(text5);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:";
        if(rep.getNoteType().equals("未知类型")||rep.getNoteType().equals("超量入库")){
            str12="备注:"+rep.getNoteType();
        }else {
            str12="备注:";
        }
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }



    //画图10,跨工厂配送单
    public Bitmap createImage10(GetDumpRecordNodeRepBean2 rep, Typeface tf) {
        int picWidth = 380;//生成图片的宽度
        int picHeight = 450+55*(rep.getData().size());//生成图片的高度
        int QRx = 95;//二维码x坐标
        int QRWidth = 190;//二维码宽
        int lineCodeWidth = 300;//一维码宽
        int titleTextSize=27;//标题字号
        int text1 = 36;
        int text2 = 32;
        int text3 = 28;
        int text4 = 24;
        int text5 = 20;
        int text6 = 18;//
        int text7 = 27;//
        int lineSpacing = 5;//行间距
        int textColor = Color.BLACK;

        int leftpadding = 10;//左边距
        int contentLeftpadding = 150;//左边距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTypeface(tf);
        //paint.setColor(Color.GREEN);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        String str1="机加厂外配送单";
        paint.setColor(Color.BLACK);
        paint.setTextSize(titleTextSize);
        int top=25;
        canvas.drawText(str1,QRx,top,paint);


        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        top+=5;
        drawGrayLine(canvas,paint,top);


        //画二维码

        String content="{\"code\":\""+rep.getDumpNum()+"\"}";
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,QRWidth, QRWidth);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        top+=5;
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bm,QRx,top,paint);
//
        top+=QRWidth+5;
        drawGrayLine(canvas,paint,top);

        String str2="接收事业部:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str2,leftpadding,top,paint);
        str2=rep.getFactory();
        canvas.drawText(str2,contentLeftpadding,top,paint);

        top+=5;
        drawGrayLine(canvas,paint,top);

        String str3="配送单号:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str3,leftpadding,top,paint);
        str3=rep.getDumpNum();
        canvas.drawText(str3,contentLeftpadding,top,paint);

        String str4="总计数量:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str4,leftpadding,top,paint);
        str4=rep.getSumCount()+"";
        canvas.drawText(str4,contentLeftpadding,top,paint);

        String str5="配送人员:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str5,leftpadding,top,paint);
        str5=rep.getHandler();
        canvas.drawText(str5,contentLeftpadding,top,paint);

        String str6="配送场地:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str6,leftpadding,top,paint);
        str6=rep.getArea();
        canvas.drawText(str6,contentLeftpadding,top,paint);

        String str7="打印时间:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str7,leftpadding,top,paint);
        str7=getCurrentdate2();
        canvas.drawText(str7,contentLeftpadding,top,paint);

        String str8="上游部件:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str8,leftpadding,top,paint);
        str8=rep.getMaterialCode();
        canvas.drawText(str8,contentLeftpadding,top,paint);

        String str9="生产订单号:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str9,leftpadding,top,paint);
        String newStr1 = rep.getProductOrderNO().replaceAll("^(0+)", "");
        str9=newStr1;
        canvas.drawText(str9,contentLeftpadding,top,paint);

        String str10="销售订单号/行:";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+lineSpacing;
        canvas.drawText(str10,leftpadding,top,paint);
        String newStr2 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr3 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        str10=newStr2+"/"+newStr3;
        canvas.drawText(str10,contentLeftpadding,top,paint);


        //内容行
        for (int i = 0; i < (rep.getData().size()); i++) {
            GetDumpRecordNodeRepBean1 bean = rep.getData().get(i);
            top+=(text6+5)*2*i;
            top+=5;
            drawKGCPSDContentLine1(canvas,paint,top,text6,bean,i);

        }

        canvas.save();
        canvas.restore();

        return result;
    }

    //跨工厂配送单内容行
    private void drawKGCPSDContentLine1(Canvas canvas, Paint paint, int top, int textsize, GetDumpRecordNodeRepBean1 bean,int i){
        drawBlackLine(canvas,paint,top);
        top+=textsize+5;
        paint.setTextSize(textsize);
        canvas.drawText((i+1)+"             "+bean.getMaterialCode(),10,top,paint);
        top+=textsize+5;
        canvas.drawText(bean.getMaterialDesc()+"             "+bean.getQty()+"/"+bean.getTQty(),10,top,paint);
    }



    //画图11,外协半成品标签
    public Bitmap createImage11(Semi_FinishedProductReceivingLableRep.Semi_FinishedProductReceivingLableRepBean rep, Typeface tf) {
        String content="{\"bm\":\""+rep.getMaterialCode()+"\",\"sl\":"+rep.getQty()+",\"num\":\""+getSeriesNumber()+"\",\"po\":\""+rep.getProductOrder()+"\",\"no\":\""+rep.getMarketOrderNO()+"\",\"line\":\""+rep.getMarketOrderRow()+"\",\"type\":\""+"\",\"fid\":"+",\"gc\":\""+rep.getDemandFactory()+"\",\"cd\":\""+rep.getDemandStorage()+"\"}";
        System.out.println(content);
        int picWidth = 480;//生成图片的宽度
        int picHeight = 380;//生成图片的高度
        int QRx = 250;//二维码x坐标
        int titleTextSize=34;
        int text1 = 32;
        int text2 = 30;
        int text3 = 28;
        int text4 = 26;
        int text5 = 24;//
        int text6 = 22;//
        int text7 = 20;//
        int lineSpacing = 10;//行间距

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
        //从asset 读取字体
//        AssetManager mgr= getAssets();
        //根据路径得到Typeface
//        Typeface tf = Typeface.createFromFile("D:\\MyFile\\temp\\KYManage\\app\\src\\main\\assets\\fonts\\simfang.ttf");//仿宋
        paint.setTypeface(tf);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1=rep.getDescription();
//        titleTextSize=(QRx)/(str1.length());
//
        paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
        int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        if(str1.length()<30){
            textPaint.setTextSize(text2);
        }else if(str1.length()>=30&&str1.length()<=40) {
            textPaint.setTextSize(text4);
        }else {
            textPaint.setTextSize(text6);
        }
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);

        String str3=rep.getMaterialCode();
        paint.setFakeBoldText(true);
        if(str3.length()>16){
            paint.setTextSize(text7);
        }else {
            paint.setTextSize(text3);
        }
        top+=titleTextSize*2+30;
        canvas.drawText(str3,0,top,paint);
        paint.setFakeBoldText(false);

        String str4="单位:"+rep.getUnit()+" "+"数量:"+(rep.getQty());
        paint.setTextSize(text3);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);

        if(true){
            String str5=rep.getDemandFactory()+"    "+rep.getDemandStorage();
            paint.setTextSize(text2);
            top+=text1+lineSpacing;
            canvas.drawText(str5,0,top,paint);

            String str6="";
            if(rep.getMarketOrderNO()==null||rep.getMarketOrderRow()==null||rep.getProductOrder()==null){
                str6="";
            }else {
                String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
                String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
                String newStr3 = rep.getProductOrder().replaceAll("^(0+)", "");
                str6=newStr1+"/"+newStr2+"   "+newStr3;
            }
            paint.setTextSize(22);
            top+=text2+lineSpacing;
            canvas.drawText(str6,0,top,paint);

            String str7="";
            if(rep.getPurchaseOrderNO()==null){
                str7="";
            }else {
                String newStr1 = rep.getPurchaseOrderNO().replaceAll("^(0+)", "");
                String newStr2 = rep.getPurchaseOrderRow().replaceAll("^(0+)", "");
                str7=newStr1+"/"+newStr2;
            }
            paint.setTextSize(text3);
            top+=text3+lineSpacing;
            canvas.drawText(str7,0,top,paint);
        }

//        String str13=""+rep.getmCode();
//        paint.setTextSize(text3);
//        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10=rep.getCompany()+"            "+rep.getPrintTime()+" "+rep.getPrintFactory();
        paint.setTextSize(text4);
        paint.setFakeBoldText(false);
        top+=text4;
        canvas.drawText(str10,0,top,paint);
        //画二维码
        Bitmap bm=null;
        try {
            bm = BarcodeUtil.encodeAsBitmap(content,
                    BarcodeFormat.QR_CODE,picWidth-QRx-20, picWidth-QRx-20);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        canvas.drawBitmap(bm,QRx,0,paint);

        int y1=picWidth-QRx+10;

        String str11=getSeriesNumber();
        paint.setTextSize(text5);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:半成品";
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);

        String str13=rep.getMCode()==null?"":rep.getMCode();
        paint.setTextSize(text4);
        y1+=(text5+lineSpacing);
        canvas.drawText(str13,QRx,y1,paint);

        canvas.save();
        canvas.restore();

        //转向
        Bitmap adjustresult = adjustPhotoRotation(result,90);

        return adjustresult;
    }


    /**
     * 压缩图片
     *
     * @param image
     * @return
     */
    public Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }
}
