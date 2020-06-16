package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPSHAdapter;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetDispatchListJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.utils.Base64Tool;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPSHActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>, PrintBaseView<GetDispatchListJSRep>, WXBCPSHAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    //震动
    private Vibrator vibrator;

    //表格
    private ListView listview1;
    //scan
//扫描相关
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetPurchaseOrderInfoJSPresenter presenter1;
    private String scanString;
    private WXBCPSHAdapter adapter1;
    private List<GetPurchaseOrderInfoJSRep> data1;
    //扫描要存的数据
    private String marketorderno;
    private String marketorderrow;
    //print
    private ImageView print;
    private GetDispatchListJSPresenter presenter2;
    private List<Long> AdvanceStorageId;
    //record
    private ImageView record;

    //
    private String username;

    //print
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE = 1;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpsh;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        print=findViewById(R.id.print);
        record=findViewById(R.id.record);
        //表格
        listview1=findViewById(R.id.listview1);

        presenter1=new GetPurchaseOrderInfoJSPresenter();
        presenter1.setView(this);

        presenter2=new GetDispatchListJSPresenter();
        presenter2.setView(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
//                操作
                boolean isReceive = data.getBooleanExtra("isReceive", false);
                long pastId = data.getLongExtra("AdvanceStorageId", 0L);
                if(isReceive){
                    AdvanceStorageId.add(pastId);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();

        AdvanceStorageId=new ArrayList<Long>();

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
                //pliu
//                scanString="{\"no\":\"0010000209\",\"line\":\"10\",\"code\":\"TEo2MDI1MDA5Mzc4\"}";
                //kh
//                scanString="{\"no\":\"10000208\",\"line\":\"26\",\"code\":\"TEoyMDE1MDAwNTk0LUEwMQ==\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(WXBCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
////                    System.out.println(lableObject.getString("bm"));
//                    String marketorderno=lableObject.getString("no");
//                    String marketorderrow=lableObject.getString("line");
//                    String bm=lableObject.getString("code");
////                        sl=lableObject.getFloat("sl");
////                        bm = lableObject.getString("bm");
////                        area = lableObject.getString("cd");
////                        factory=lableObject.getString("gc");
////                        labelSquNum=lableObject.getString("num");
////                        cs=lableObject.getInteger("cs");
//
//                    //判断是否重复扫码
////                        boolean repeat=false;
////                        for (GetPurWayMaterialDataRep data : datas) {
////                            if(labelSquNum.equals(data.getData().getLabelSeqNum())){
////                                repeat=true;
////                            }
////                        }
////                        if(repeat){
////                            System.out.println("请勿重复扫码");
////                            Toast.makeText(WXBCPSHActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
////
////                        }else {
////
//                    if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
//                        String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                        presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
//                    }
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(WXBCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                presenter2.GetDispatchListJS(AdvanceStorageId,username);
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent = new Intent(WXBCPSHActivity.this, WXBCPSHRecordActivity.class);
                intent.putExtra("username",username);
//                System.out.println("外协二级菜单发："+username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        data1 = data.getData();
        try {
//            data1.add(data.getData());
            for (GetPurchaseOrderInfoJSRep data2 : data1) {
                data2.setMarketorderno(marketorderno);
                data2.setMarketorderrow(marketorderrow);
            }
            System.out.println(data1.get(0).getEBELN());
            adapter1=new WXBCPSHAdapter(this, R.layout.wxbcpshitem, data1);
            adapter1.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter1);
            listview1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccessPrint(GetDispatchListJSRep data) {
        System.out.println("print success");
        for (GetDispatchListJSBean2 datum : data.getData()) {
            Bitmap bm=cb.createImage5(datum,tf);
            int picHeight = 410+55*(datum.getData().size());
            printHelper.PrintBitmapAtCenter(bm,384,picHeight);
            printHelper.printBlankLine(80);
        }

        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        System.out.println(msg);
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("整体item----->", i + "");
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.receive:
                Log.e("内部receive>>", position + "");
                vibrator.vibrate(30);
                GetPurchaseOrderInfoJSRep checkedData = data1.get(position);
                Intent intent=new Intent(WXBCPSHActivity.this,WXBCPSHDialogActivity.class);
                intent.putExtra("materialCode",checkedData.getMATNR());
                System.out.println(checkedData.getMATNR()+"|||"+checkedData.getWERKS());
//            intent.putExtra("materialCode","LJ4515006377-A01");
                intent.putExtra("factoryNO",checkedData.getWERKS());
//            intent.putExtra("factoryNO","2090");
                EditText et=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                String recenumstr=et.getText().toString();
                float num=Float.parseFloat(("0"+recenumstr));
                Spinner sp= listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.spinner1);
                int selectedItemPosition = sp.getSelectedItemPosition();
//                System.out.println("选中的仓库index:"+selectedItemPosition);
                String demandStorage=checkedData.getStorage().get(selectedItemPosition).getId();
                intent.putExtra("demandStorage",demandStorage);
                intent.putExtra("marketorderno",checkedData.getMarketorderno());
                intent.putExtra("marketorderrow",checkedData.getMarketorderrow());
                intent.putExtra("dhsl",num);
                intent.putExtra("index",position);
                intent.putExtra("username",username);
                intent.putExtra("checkedData",(Serializable) checkedData);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            default:
                break;
        }
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
                        Toast.makeText(WXBCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
//                    System.out.println(lableObject.getString("bm"));
                        marketorderno=lableObject.getString("no");
                        marketorderrow=lableObject.getString("line");
                        String bm=lableObject.getString("code");
//                        sl=lableObject.getFloat("sl");
//                        bm = lableObject.getString("bm");
//                        area = lableObject.getString("cd");
//                        factory=lableObject.getString("gc");
//                        labelSquNum=lableObject.getString("num");
//                        cs=lableObject.getInteger("cs");

                        //判断是否重复扫码
//                        boolean repeat=false;
//                        for (GetPurWayMaterialDataRep data : datas) {
//                            if(labelSquNum.equals(data.getData().getLabelSeqNum())){
//                                repeat=true;
//                            }
//                        }
//                        if(repeat){
//                            System.out.println("请勿重复扫码");
//                            Toast.makeText(WXBCPSHActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                        }else {
//
                        if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
                            String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                            presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
                        }

//                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXBCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXBCPSHActivity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }
}
