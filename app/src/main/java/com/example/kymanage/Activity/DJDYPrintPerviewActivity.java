package com.example.kymanage.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kymanage.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import Printer.PrintHelper;
import hardware.print.BarcodeUtil;

public class DJDYPrintPerviewActivity extends BaseActivity {
    //打印类
    private PrintHelper printHelper=null;
    //打印数据
    private int mLabelWidth;
    private int mLabelHeight;
    //最终需要打印的bm
    private Bitmap bm;
    private ImageView tempbmIV;
    //打印的二维码content
    private String content;

    //打印按钮
    private Button print;
    //走纸按钮
    private Button gotopage;

    //暂定一行高度55
    private int contentLineHeight;
    //要打印的内容行数
    private int lines;
    //单据类型
    private String type;
    @Override
    public int initLayoutId() {
        return R.layout.activity_pgdprint_perview;
    }

    @Override
    public void initview() {
        tempbmIV=findViewById(R.id.IV);
        print=findViewById(R.id.print);
        gotopage=findViewById(R.id.gotopage);
    }

    @Override
    public void initData() {

        Intent intent=getIntent();
        lines=intent.getIntExtra("lines",0);
        type=intent.getStringExtra("type");
        System.out.println(type);
        switch (type){
            case "机加厂内派工单":
                //打印数据
                mLabelWidth = 48;
                mLabelHeight = 410;
                contentLineHeight=55;
                content="{\"productorderno\":\"1004300245\"}";
                bm=createImage1(content,lines);
                tempbmIV.setImageBitmap(bm);
                break;
            case "厂内配送单":
                //打印数据
                mLabelWidth = 48;
                mLabelHeight = 300;
                contentLineHeight=120;
                content="{\"productorderno\":\"1004300245\"}";
                bm=createImage2(content,lines);
                tempbmIV.setImageBitmap(bm);
                break;
            case "跨工厂配送单":
                //打印数据
                mLabelWidth = 48;
                mLabelHeight = 410;
                contentLineHeight=55;
                content="{\"productorderno\":\"1004300245\"}";
                bm=createImage3(content,lines);
                tempbmIV.setImageBitmap(bm);
                break;
            case "销售发货单":
                //打印数据
                mLabelWidth = 48;
                mLabelHeight = 410;
                contentLineHeight=55;
                content="{\"productorderno\":\"1004300245\"}";
                bm=createImage1(content,lines);
                tempbmIV.setImageBitmap(bm);
                break;
            default:
                break;
        }




    }

    @Override
    public void initLisenter() {
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPrinter();
                //mPrinterhelp.GoToNextPage();
                printHelper.PrintBitmapAtCenter(bm,mLabelWidth*8,mLabelHeight+lines*contentLineHeight);
                printHelper.printBlankLine(40);
                Toast.makeText(DJDYPrintPerviewActivity.this, "打印成功", Toast.LENGTH_SHORT).show();

            }
        });
        gotopage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printHelper.Step((byte) 0x5f);
            }
        });
    }
    //初始化
    public void    initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(DJDYPrintPerviewActivity.this);
        //Toast.makeText(DJDYPrintPerviewActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }
    //画图1,机加厂内派工单
    public static Bitmap createImage1(String content,int lines) {
        int picWidth = 380;//生成图片的宽度
        int picHeight = 410+55*lines;//生成图片的高度
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

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        //paint.setColor(Color.GREEN);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        String str1="机加生产派工单";
        paint.setColor(Color.BLACK);
        paint.setTextSize(titleTextSize);
        int top=25;
        canvas.drawText(str1,QRx,top,paint);


        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        top+=5;
        drawGrayLine(canvas,paint,top);


        //画二维码
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

        String str2="LJ6030000220-TZ201004GY09        5";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str2,leftpadding,top,paint);

        top+=5;
        drawGrayLine(canvas,paint,top);

        String str3="围栏";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str3,10,top,paint);

        top+=5;
        drawGrayLine(canvas,paint,top);

        String str4="10000139/10        2010";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str4,leftpadding,top,paint);

        top+=5;
        drawGrayLine(canvas,paint,top);

        String str5="123422343234        2020/04/22";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str5,leftpadding,top,paint);

        //内容行

        for (int i = 0; i < lines; i++) {
            if (i==0){
                top+=5;
                drawContentLine1(canvas,paint,top,text6);
            }else {
                top+=(text6+5)*2;
                top+=5;
                drawContentLine1(canvas,paint,top,text6);
            }
        }


        //画一维码
        Bitmap bm1=null;
        try {
            bm1=BarcodeUtil.create1dBarcode("01234567891234",BarcodeFormat.CODE_128,lineCodeWidth,45);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        //y1+=text3;
        top+=60;
        canvas.drawBitmap(bm1,(picWidth-lineCodeWidth)/2,top,paint);


        canvas.save();
        canvas.restore();

        return result;
    }
    //画图1,机加厂内派工单内容行
    public static void drawContentLine1(Canvas canvas,Paint paint,int top,int textsize){
        drawBlackLine(canvas,paint,top);
        top+=textsize+5;
        paint.setTextSize(textsize);
        canvas.drawText("0010"+"                         "+"喷漆",10,top,paint);
        top+=textsize+5;
        canvas.drawText("喷底漆，喷面漆",10,top,paint);
    }
    //画图2,机加厂内配送单
    public static Bitmap createImage2(String content,int lines) {
        int picWidth = 380;//生成图片的宽度
        int picHeight = 300+120*lines;//生成图片的高度
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

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        //paint.setColor(Color.GREEN);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        String str1="机加厂内配送单";
        paint.setColor(Color.BLACK);
        paint.setTextSize(titleTextSize);
        int top=25;
        canvas.drawText(str1,QRx,top,paint);


        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        top+=5;
        drawGrayLine(canvas,paint,top);


        //画二维码
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

        String str2="G90000014618";
        String str3="成品库";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str2,leftpadding,top,paint);
        canvas.drawText(str3,picWidth/2,top,paint);

        top+=5;
        drawGrayLine(canvas,paint,top);

        String str4="ZLN10075";
        String str5="2020/1/3";
        paint.setColor(Color.BLACK);
        paint.setTextSize(text6);
        top+=text6+5;
        canvas.drawText(str4,leftpadding,top,paint);
        canvas.drawText(str5,picWidth/2,top,paint);

        //内容行
        for (int i = 0; i < lines; i++) {
            if (i==0){
                top+=5;
                drawContentLine2(canvas,paint,top,text6);
            }else {
                top+=(text6+5)*2;
                top+=5;
                drawContentLine1(canvas,paint,top,text6);
            }
        }

        canvas.save();
        canvas.restore();

        return result;
    }
    //画图2,机加厂内配送单内容行
    public static void drawContentLine2(Canvas canvas,Paint paint,int top,int textsize){
        drawBlackLine(canvas,paint,top);
        top+=textsize+5;
        paint.setTextSize(textsize);
        canvas.drawText("1",10,top,paint);
        canvas.drawText("LJ6030000220-A01",190,top,paint);
        top+=textsize+5;
        canvas.drawText("围栏加工完成半成品",10,top,paint);
        top+=textsize+5;
        canvas.drawText("LJ6030000220-TZ201004GY09",10,top,paint);
        top+=textsize+5;
        canvas.drawText("10065590",10,top,paint);
        canvas.drawText("2/1",190,top,paint);
        top+=textsize+5;
        canvas.drawText("10000139/10",10,top,paint);
        canvas.drawText("机器人",190,top,paint);
    }

    //画图3,机加跨工厂配送单
    public static Bitmap createImage3(String content,int lines) {
        int picWidth = 380;//生成图片的宽度
        int picHeight = 580;//生成图片的高度
        int QRx = 120;//二维码x坐标
        int QRWidth = 140;//二维码宽
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

        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        //paint.setColor(Color.GREEN);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        String str1="机加制造部配送单";
        paint.setColor(Color.BLACK);
        paint.setTextSize(titleTextSize);
        int top=25;
        canvas.drawText(str1,QRx-40,top,paint);


        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        top+=5;
        drawGrayLine(canvas,paint,top);


        //画二维码
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
        //drawGrayLine(canvas,paint,top);

        drawDatasLine3(canvas,paint,top,text6,"接收事业部","机器人");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"配送单号","K90000005474");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"总计数量","46");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"配送人员","ZLN10075");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"配送场地","P51");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"打印时间","2020/4/14");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"上游部件","BJ4515000627");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"生产订单号","10065590");
        top+=text6+10;
        drawDatasLine3(canvas,paint,top,text6,"销售订单行/号","10000139/10");
        top+=text6+10;

        //内容行
        for (int i = 0; i < lines; i++) {
            if (i==0){
                top+=5;
                drawContentLine3(canvas,paint,top,text6);
            }else {
                top+=(text6+5)*2;
                top+=5;
                drawContentLine3(canvas,paint,top,text6);
            }
        }

        canvas.save();
        canvas.restore();

        return result;
    }
    //画图3,机加跨工厂配送单数据行
    public static void drawDatasLine3(Canvas canvas,Paint paint,int top,int textsize,String title,String values){
        top+=5;
        drawGrayLine(canvas,paint,top);
        paint.setColor(Color.BLACK);
        paint.setTextSize(textsize);
        top+=textsize+5;
        canvas.drawText(title,10,top,paint);
        canvas.drawText(values,190,top,paint);
    }
    //画图3,机加跨工厂配送单内容行
    public static void drawContentLine3(Canvas canvas,Paint paint,int top,int textsize){
        drawBlackLine(canvas,paint,top);
        top+=textsize+5;
        paint.setTextSize(textsize);
        canvas.drawText("1",10,top,paint);
        canvas.drawText("LJ6030000220",190,top,paint);
        top+=textsize+5;
        canvas.drawText("围栏加工完成半成品",10,top,paint);
        canvas.drawText("5/3",190,top,paint);
    }


    public static void drawGrayLine(Canvas canvas, Paint paint, int top){
        paint.setColor(Color.GRAY);
        canvas.drawLine (0,top,380,top,paint);
    }
    public static void drawBlackLine(Canvas canvas,Paint paint,int top){
        paint.setColor(Color.BLACK);
        canvas.drawLine (0,top,380,top,paint);
    }

}
