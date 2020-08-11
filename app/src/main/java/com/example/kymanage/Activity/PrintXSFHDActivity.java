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
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.Print3Adapter;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean2;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSReqBean1;
import com.example.kymanage.Beans.GetLableStorageInfoJS.GetLableStorageInfoJSRep;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.Print3.GetDeliveryListInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.Print3.GetLableStorageInfoJSPresenter;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class PrintXSFHDActivity extends BaseActivity implements ScanBaseView<GetLableStorageInfoJSRep>, BaseView1<GetDeliveryListInfoJSRepBean3> {
    //username
    private String username;
    //扫描
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private String scanString;
    //扫描获取的数据
    private String no;
    private String line;
    private String code;
    private float num;

    private GetLableStorageInfoJSPresenter presenter1;
//    private List<String> DispatchListNOList;

    //表
    private ListView listView1;
    private Print3Adapter adapter;

    //print
    private ImageView print;
    //打印类
    private PrintHelper printHelper=null;
    private com.example.kymanage.utils.mPrintUtil mPrintUtil;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //打印内容
//    private GetCMInFactoryDeliverRep printData;
    private GetDeliveryListInfoJSPresenter presenter2;
    private List<GetDeliveryListInfoJSReqBean1> printReqs;

    private ImageView record;

    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_xsfhd;
    }

    @Override
    public void initview() {

        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        print=findViewById(R.id.print);
        record=findViewById(R.id.record);
        //表格
        listView1=findViewById(R.id.listview1);


        presenter1=new GetLableStorageInfoJSPresenter();
        presenter1.setView(this);

        presenter2=new GetDeliveryListInfoJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        mPrintUtil=new mPrintUtil();
        printReqs=new ArrayList<GetDeliveryListInfoJSReqBean1>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

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

//                scanString="{\n" +
//                        "    \"bm\":\"LJ7015001194\",\n" +
//                        "    \"sl\":3.0,\n" +
//                        "    \"num\":\"202006171205211938\",\n" +
//                        "    \"po\":\"000010048077\",\n" +
//                        "    \"no\":\"0010000208\",\n" +
//                        "    \"line\":\"000026\",\n" +
//                        "    \"type\":\"t301\",\n" +
//                        "    \"fid\":468,\n" +
//                        "    \"gc\":\"2010\",\n" +
//                        "    \"cd\":\"A11\"\n" +
//                        "}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(PrintXSFHDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    no=lableObject.getString("no");
//                    line=lableObject.getString("line");
//                    code=lableObject.getString("bm");
//                    num=lableObject.getFloat("sl");
//                    long id=lableObject.getLong("fid");
//                    String type=lableObject.getString("type");
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (int i = 0; i < printReqs.size(); i++) {
//                        GetDeliveryListInfoJSReqBean1 reqBean1 = printReqs.get(i);
//                        if(no.equals(reqBean1.getVBELN())&&line.equals(reqBean1.getPOSNR())&&code.equals(reqBean1.getMATNR())){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(PrintXSFHDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//                    }else {
//                        presenter1.GetLableStorageInfoJS(code,id,type,"2090");
//                    }
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(PrintXSFHDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                presenter2.GetDeliveryListInfoJS(printReqs,6,username,getCurrentdate());
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent = new Intent(PrintXSFHDActivity.this, XSFHRecordActivity.class);
                intent.putExtra("username",username);
//                System.out.println("外协二级菜单发："+username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetLableStorageInfoJSRep data) {
        try {
            GetDeliveryListInfoJSReqBean1 req=new GetDeliveryListInfoJSReqBean1(code, no, line, num, data.getStorage());
            printReqs.add(req);
            adapter=new Print3Adapter(this, R.layout.print3item,printReqs);
            listView1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess1(GetDeliveryListInfoJSRepBean3 data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();

        List<GetDeliveryListInfoJSRepBean2> data1 = data.getData();
        for (GetDeliveryListInfoJSRepBean2 data2 : data1) {

            mPrintUtil.printXSFHBill(data2,printHelper);
            printHelper.printBlankLine(80);
        }
    }

    @Override
    public void onFailed(String msg) {

    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(PrintXSFHDActivity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(PrintXSFHDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        long id= 0;
                        String type= null;
                        try {
                            no=lableObject.getString("no");
                            line=lableObject.getString("line");
                            code=lableObject.getString("bm");
                            num=lableObject.getFloat("sl");
                            id = lableObject.getLong("fid");
                            type = lableObject.getString("type");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //判断是否重复扫码
                        boolean repeat=false;
                        for (int i = 0; i < printReqs.size(); i++) {
                            GetDeliveryListInfoJSReqBean1 reqBean1 = printReqs.get(i);
                            if(no.equals(reqBean1.getVBELN())&&line.equals(reqBean1.getPOSNR())&&code.equals(reqBean1.getMATNR())){
                                repeat=true;
                            }
                        }
                        if(repeat){
                            System.out.println("请勿重复扫码");
                            Toast.makeText(PrintXSFHDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
                        }else {
                            presenter1.GetLableStorageInfoJS(code,id,type,"2090");
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(PrintXSFHDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
//                printHelper.Unreeling((byte) 0x1f);
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
