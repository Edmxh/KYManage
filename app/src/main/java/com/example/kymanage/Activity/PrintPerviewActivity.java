package com.example.kymanage.Activity;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;

import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHPrintPresenter;
import com.example.kymanage.presenter.PrintView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;


import java.util.ArrayList;
import java.util.List;

import Printer.PrintHelper;
import hardware.print.BarcodeUtil;


public class PrintPerviewActivity extends BaseActivity implements PrintBaseView<GetParchaseCenterLableReps> {


    //打印类
    private PrintHelper printHelper=null;
    //打印数据
    private int mLabelWidth = 48;
    private int mLabelHeight = 48;
    //最终需要打印的bm
    private Bitmap bm;
    private ImageView tempbmIV;
    //打印的二维码content
    private String content;

    private LinearLayout mCard1ContentLayout;

    //打印按钮
    private Button print;
    //走纸按钮
    private Button gotopage;

    private CGSHPrintPresenter presenter3;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_perview;
    }

    @Override
    public void initview() {
        mCard1ContentLayout = findViewById(R.id.lyt_card1_content);
        tempbmIV=findViewById(R.id.IV);
        print=findViewById(R.id.print);
        gotopage=findViewById(R.id.gotopage);

        presenter3=new CGSHPrintPresenter();
        presenter3.setView(this);

        cb=new CreateBitmap();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
        //mPrinterhelp.SetGrayLevel((byte)0x05);
    }

    @Override
    public void initData() {
//        content="{\"bm\":\"dsfe002344\",\"sl\":6.0,\"num\":\"15882405763666\",\"po\":\"10051586\",\"pono\":\"1\",\"porow\":\"1\",\"gc\":\"2000\",\"cd\":\"A001\"}";
        content="1234567890";
//        bm=createImage2(content);
        List<Long> checkedPrintList=new ArrayList<Long>();
        checkedPrintList.add(253L);
        presenter3.CGSHPrint(checkedPrintList,"xmao","2020-05-21 15:10");

//        bm=createImage3();
//        tempbmIV.setImageBitmap(bm);

        //mCard1ContentLayout.addView(tempbmIV);

    }
    @Override
    public void initLisenter() {
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPrinter();
                //mPrinterhelp.GoToNextPage();
                printHelper.PrintBitmapAtCenter(bm,mLabelWidth*8,mLabelHeight*10);
                printHelper.printBlankLine(40);
                Toast.makeText(PrintPerviewActivity.this, "打印成功", Toast.LENGTH_SHORT).show();

            }
        });
        gotopage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printHelper.Step((byte) 0x5f);
            }
        });



    }


    @Override
    public void onDataSuccessPrint(GetParchaseCenterLableReps data) {
        GetParchaseCenterLableRep label = data.getData().get(0);
//        bm=cb.createImage1(label,tf);
//        tempbmIV.setImageBitmap(bm);
    }

    @Override
    public void onFailed(String msg) {

    }

    //初始化
    public void    initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(PrintPerviewActivity.this);
        Toast.makeText(PrintPerviewActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();

    }

    //画图2
    public Bitmap createImage2(String content) {
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
        int lineSpacing = 10;//行间距
        //生成的图片
        Bitmap result = Bitmap.createBitmap(picWidth,picHeight,Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setSubpixelText(true);
        paint.setDither(true);
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
        paint.setTypeface(tf);
        //paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStrokeWidth(0.1f);
//        paint.setStrokeMiter(0.1f);
        //paint.setColor(Color.GREEN);
        Canvas canvas = new Canvas(result);
        //先画一整块白色矩形块
        canvas.drawRect(0,0,picWidth,picHeight,paint);


        //画文字
        String str1="ACQ系列超薄气缸测试加长换行";
//        titleTextSize=(QRx)/(str1.length());
//
       paint.setColor(Color.BLACK);
//        paint.setTextSize(titleTextSize);
       int top=15;
//        canvas.drawText(str1,0,top,paint);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(titleTextSize);
        textPaint.setTypeface(tf);
        StaticLayout layout = new StaticLayout(str1,textPaint,QRx-10, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);

//从 (20,80)的位置开始绘制
        canvas.translate(0,top);
        layout.draw(canvas);


        String str3="QD2000000611";
        paint.setTextSize(text1);
        top+=titleTextSize*2+30;
        canvas.drawText(str3,0,top,paint);

        String str4="单位:EA"+"  "+"数量:4";
        paint.setTextSize(text3);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);

        String str5="2010"+"    "+"BC1025";
        paint.setTextSize(text2);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);

        String str6="100000150/19"+"  "+"10057088";
        paint.setTextSize(20);
        top+=text2+lineSpacing;
        canvas.drawText(str6,0,top,paint);

        String str7="BJ012345678";
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str7,0,top,paint);



        String str8="移动底座";
        paint.setTextSize(text3);
        top+=text3+lineSpacing;
        canvas.drawText(str8,0,top,paint);
        String str13="M000149911";
        paint.setTextSize(text3);
        canvas.drawText(str13,QRx,top,paint);

        //String str9="--------------------------------------------------------------------------------------------------------------------------";
        paint.setFakeBoldText(true);
        top+=lineSpacing;
        canvas.drawLine (0,top,picWidth,top,paint);

        String str10="TKAS"+"                      "+"2019/12/19"+"   "+"21:13"+"  "+"CM";
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

        String str11="01234567891234";
        paint.setTextSize(text5);
        canvas.drawText(str11,QRx,y1,paint);
        String str12="备注:"+"唐山开元";
        paint.setTextSize(text4);
        y1+=text5+lineSpacing;
        canvas.drawText(str12,QRx,y1,paint);


        //画一维码
//        Bitmap bm1=null;
//        try {
//            bm1=BarcodeUtil.create1dBarcode("01234567891234",BarcodeFormat.CODE_128,picWidth-QRx+80,45);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//        //y1+=text3;
//        y1+=25;
//        canvas.drawBitmap(bm1,QRx-100,y1,paint);
//        textPaint.setTextSize(text4);
//        StaticLayout layout2 = new StaticLayout(str12,textPaint,picWidth-QRx, Layout.Alignment.ALIGN_NORMAL,1.0F,0.0F,true);
//
////从 (x,y)的位置开始绘制
//        canvas.translate(QRx,y1);
//        layout2.draw(canvas);
//        //paint.setTextSize(text3);
//        //canvas.drawText(str12,QRx,y1,paint);




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

    //测试打印
    public void testPrint(){
        Bitmap bm2=null;
        try {
            bm2 = BarcodeUtil.encodeAsBitmap("Thanks for using our Android terminal",
                    BarcodeFormat.QR_CODE, 80, 80);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        if(bm2!=null)
        {
            printHelper.PrintBitmap(bm2);
        }
    }

    //发料单打印
//    public Bitmap createImage3(GenerateStorageLssueRecordRep rep) {
    public Bitmap createImage3() {
        int picWidth = 480;//生成图片的宽度
        int picHeight = 325;//生成图片的高度，基础100+heightone85+heighttwo55+bottom 30
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
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
        paint.setTypeface(tf);

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
        //凭证号和流水号
        String str1="凭证号：0000001";
        paint.setTextSize(text1);
        top+=titleTextSize+lineSpacing;
        canvas.drawText(str1,0,top,paint);

        String str2="流水号：0000001";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str2,0,top,paint);
        //第一层内容方法
        drawFLContent1( paint, canvas, text1, top, lineSpacing, picWidth);

        top+=85+55*2;
        //横线
        paint.setFakeBoldText(true);
        top+=5;
        canvas.drawLine (0,top,picWidth,top,paint);
        paint.setFakeBoldText(false);

        String str3="TKAS"+"     "+"2020-05-13  9:34:00"+"   "+"RS";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str3,0,top,paint);



        return result;
    }
    //第一层内容方法
    public void drawFLContent1(Paint paint,Canvas canvas,int text1,int top,int lineSpacing,int picWidth) {
        //横线
        paint.setFakeBoldText(true);
        top+=5;
        canvas.drawLine (0,top,picWidth,top,paint);
        paint.setFakeBoldText(false);
        //共有内容
        String str3="10000223/10";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str3,0,top,paint);
        str3="10000015";
        canvas.drawText(str3,picWidth/2,top,paint);

        String str4="上游部件：";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str4,0,top,paint);
        str4="BJ2015008015";
        canvas.drawText(str4,picWidth/2,top,paint);

        String str5="上游部件描述：";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str5,0,top,paint);
        str5="机械手臂";
        canvas.drawText(str5,picWidth/2,top,paint);
        //第二层内容方法
        drawFLContent2( paint, canvas, text1, top, lineSpacing, picWidth);
        top+=55;
        drawFLContent2( paint, canvas, text1, top, lineSpacing, picWidth);
    }
    //第二层内容方法
    public void drawFLContent2(Paint paint,Canvas canvas,int text1,int top,int lineSpacing,int picWidth) {
        String str6="LJ001：";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str6,0,top,paint);
        str6="5/2/3-个";
        canvas.drawText(str6,picWidth/2,top,paint);

        String str7="物料描述一";
        paint.setTextSize(text1);
        top+=text1+lineSpacing;
        canvas.drawText(str7,0,top,paint);
    }



}
