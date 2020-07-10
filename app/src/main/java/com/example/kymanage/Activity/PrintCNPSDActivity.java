package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.PrintCNPSDAdapter;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRepBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.Print1.GetCMInFactoryDeliverPresenter;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class PrintCNPSDActivity extends BaseActivity implements ScanBaseView<GetCMInFactoryDeliverRep> {

    //username
    private String username;
    //扫描
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private String scanString;
    private GetCMInFactoryDeliverPresenter presenter1;
    private List<String> DispatchListNOList;

    //表
    private ListView listView1;
    private PrintCNPSDAdapter adapter;

    //print
    private ImageView print;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //打印内容
    private GetCMInFactoryDeliverRep printData;

    //震动
    private Vibrator vibrator;

    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_cnpsd;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        print=findViewById(R.id.print);
//        record=findViewById(R.id.record);
        //表格
        listView1=findViewById(R.id.listview1);

        presenter1=new GetCMInFactoryDeliverPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        printData=new GetCMInFactoryDeliverRep();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        DispatchListNOList=new ArrayList<String>();

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                //确保扫描完毕scanString被赋值后才被解析
                Thread scanThread=new Thread(new Runnable(){
                    @Override
                    public void run() {
                        scan();
                    }
                });
                scanThread.start();
                try {
                    Log.i("token","scanThread.join();");
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                scanString="{\"code\":\"LJ2015000594-TZ2010043020\",\"dp\":\"15923846892067\",\"po\":\"000010048078\",\"no\":\"0010000208\",\"line\":\"000026\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(PrintCNPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    String DispatchListNO=lableObject.getString("dp");
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (String no : DispatchListNOList) {
//                        if(DispatchListNO.equals(no)){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(PrintCNPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                    }else {
//                        if(DispatchListNO!=null){
//                            DispatchListNOList.add(DispatchListNO);
//                            presenter1.GetCMInFactoryDeliver(DispatchListNOList,username,getCurrentdate());
//                        }
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(PrintCNPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                try {
//                    Bitmap bm=cb.createImage8(printData,tf);
//                    int picHeight = 300+105*(printData.getData().size());
//                    printHelper.PrintBitmapAtCenter(bm,384,picHeight);
                    mPrintUtil.printCNBill(printData,printHelper);
                    printHelper.printBlankLine(80);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetCMInFactoryDeliverRep data) {
        System.out.println(data.getDeliverID());
        printData=data;
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        adapter=new PrintCNPSDAdapter(this, R.layout.wxcnpsditem,data.getData());
        listView1.setAdapter(adapter);
    }

    @Override
    public void onFailed(String msg) {

    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver
    {
        private static final String TAG = "MycodeReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(PrintCNPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                       String DispatchListNO=lableObject.getString("dp");
                        //判断是否重复扫码
                        boolean repeat=false;
                        for (String no : DispatchListNOList) {
                            if(DispatchListNO.equals(no)){
                                repeat=true;
                            }
                        }
                        if(repeat){
//                            System.out.println("请勿重复扫码");
                            Toast.makeText(PrintCNPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
                        }else {
                            if(DispatchListNO!=null){
                                DispatchListNOList.add(DispatchListNO);
                                presenter1.GetCMInFactoryDeliver(DispatchListNOList,username,getCurrentdate());
                            }
                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(PrintCNPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
    }

    //扫描操作
    public void scan(){
        Intent intent = new Intent();
        intent.setAction("com.barcode.sendBroadcastScan");
        sendBroadcast(intent);
    }
    //注册广播
    public void registerBroadcast() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(m_Broadcastname);
//        Toast.makeText(KFCGSHRKActivity.this, "扫描注册初始化", Toast.LENGTH_SHORT).show();
        registerReceiver(receiver, intentFilter);
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(PrintCNPSDActivity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        // 获取手机当前音量值
//        int i = getCurrentRingValue ();
        switch (keyCode) {
            // 音量减小
            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                Toast.makeText (CGDDListActivity.this, "上上上", Toast.LENGTH_SHORT).show ();
                // 音量减小时应该执行的功能代码
                return true;
            // 音量增大
            case KeyEvent.KEYCODE_VOLUME_UP:
//                Toast.makeText (CGDDListActivity.this, "下下下", Toast.LENGTH_SHORT).show ();
                // 音量增大时应该执行的功能代码
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
