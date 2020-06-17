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
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPSHAdapter;
import com.example.kymanage.Adapter.WXCPSHAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.General.SwitchBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRepBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean1;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean2;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean3;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.GetOutsourceFinProLableJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.OutsourceFinishedProductReceivingJSPresenter;
import com.example.kymanage.utils.Base64Tool;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXCPSHActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>, BaseView2<OutsourceFinishedProductReceivingJSRep>, BaseView3<GetOutsourceFinProLableJSRep>, WXCPSHAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    //震动
    private Vibrator vibrator;
    private ImageView scan;
    private ImageView print;
    private ImageView record;
    //表格
    private ListView listview1;
    //scan
//扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetPurchaseOrderInfoJSPresenter presenter1;
    private String scanString;
    private WXCPSHAdapter adapter1;
    private List<GetPurchaseOrderInfoJSRep> data1;
    //扫描要存的数据
    private String marketorderno;
    private String marketorderrow;
    //
    private String username;
    //收货
    private OutsourceFinishedProductReceivingJSPresenter presenter2;
    private List<OutsourceFinishedProductReceivingJSReqBean3> beans3;

    //选择上游生产订单物料编码
    private List<String> materialList;

    //控制选择生产订单
    private List<SwitchBean> switchBeans;

    //print
    private GetOutsourceFinProLableJSPresenter presenter3;
    private  List<GetOutsourceFinProLableJSReqBean> printList;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;


    /**
     * 自定义请求码常量
     */
    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE_1 = 1;
    private static final int REQUEST_CODE_2 = 2;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxcpsh;
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

        presenter2=new OutsourceFinishedProductReceivingJSPresenter();
        presenter2.setView(this);

        presenter3=new GetOutsourceFinProLableJSPresenter();
        presenter3.setView(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE_1: //返回的请求码
//                操作
                boolean confirm = data.getBooleanExtra("confirm", false);
                int index=data.getIntExtra("index",0);
                float sl =data.getFloatExtra("allNum",0);
                OutsourceFinishedProductReceivingJSReqBean2 inProduct  = (OutsourceFinishedProductReceivingJSReqBean2) data.getSerializableExtra("inProduct");
                if(confirm){
                    beans3.get(index).setInProduct(inProduct);
                    EditText et=listview1.getChildAt(index - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                    et.setText(""+sl);
                    if(inProduct.getPMATNR()!=null){
                        materialList.set(index,inProduct.getPMATNR());
                    }
                    switchBeans.get(index).setSwitch1(true);
                }
                break;
            case REQUEST_CODE_2: //返回的请求码
//                操作
                boolean confirm2 = data.getBooleanExtra("confirm", false);
                int index2=data.getIntExtra("index",0);
                List<OutsourceFinishedProductReceivingJSReqBean1> outProduct  = (List<OutsourceFinishedProductReceivingJSReqBean1>) data.getSerializableExtra("outProduct");
                if(confirm2){
                    beans3.get(index2).setOutProduct(outProduct);
                    switchBeans.get(index2).setSwitch2(true);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        printList=new ArrayList<GetOutsourceFinProLableJSReqBean>();
        switchBeans = new ArrayList<SwitchBean>();
        materialList=new ArrayList<String>();
        beans3=new ArrayList<OutsourceFinishedProductReceivingJSReqBean3>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();

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
                beans3.clear();
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

//                scanString="{\"no\":\"0010000208\",\"line\":\"000026\",\"code\":\"TEo3MDE1MDAxMTk0\"}";//无生产订单
//                scanString="{\"no\":\"0010000208\",\"line\":\"000026\",\"code\":\"TEoyMDE1MDAwNTk0LUEwMQ==\"}";//有生产订单
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(WXCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
////                    System.out.println(lableObject.getString("bm"));
//                    marketorderno=lableObject.getString("no");
//                    marketorderrow=lableObject.getString("line");
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
////                        }
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(WXCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                //测试数据
//                printList.clear();
//                GetOutsourceFinProLableJSReqBean csbean1=new GetOutsourceFinProLableJSReqBean(140,"10",441);
//                GetOutsourceFinProLableJSReqBean csbean2=new GetOutsourceFinProLableJSReqBean(157,"20",459);
//                printList.add(csbean1);
//                printList.add(csbean2);
                presenter3.GetOutsourceFinProLableJS(username,getCurrentdate2(),printList);
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent = new Intent(WXCPSHActivity.this, WXCPSHRecordActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        data1 = data.getData();
        switchBeans.clear();
        try {
            for (GetPurchaseOrderInfoJSRep data2 : data1) {
                data2.setMarketorderno(marketorderno);
                data2.setMarketorderrow(marketorderrow);

                OutsourceFinishedProductReceivingJSReqBean3 bean3=new OutsourceFinishedProductReceivingJSReqBean3( data2.getWERKS(), data2.getLGPRO(), data2.getTXZ01(), data2.getMATNR(), data2.getMaterialType(), data2.getEBELN(), data2.getEBELP(), data2.getKINDS(), data2.getWESBS(), data2.getCGTXT(), data2.getMEINS(), null, null);
                beans3.add(bean3);

                materialList.add(data2.getMATNR());

                SwitchBean switchbean = new SwitchBean(false, false);
                switchBeans.add(switchbean);
            }
            System.out.println(data1.get(0).getEBELN());
            adapter1=new WXCPSHAdapter(this, R.layout.wxcpshitem, data1);
            adapter1.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter1);
            listview1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(OutsourceFinishedProductReceivingJSRep data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();

        try {
            GetOutsourceFinProLableJSReqBean printBean=new GetOutsourceFinProLableJSReqBean(data.getData().getStorageId(),data.getData().getOrderType(),data.getData().getAdvanceStorageId());
            printList.add(printBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("成品收货返回的data数据"+data.getData().getStorageId());

    }

    @Override
    public void onDataSuccess3(GetOutsourceFinProLableJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            List<GetOutsourceFinProLableJSRepBean> beans = data.getData();
            for (GetOutsourceFinProLableJSRepBean bean : beans) {
                printHelper.printBlankLine(10);
                Bitmap bm=cb.createImage7(bean,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(40);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {

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
            case R.id.receive1:
                Log.e("内部receive1>>", position + "");
                vibrator.vibrate(30);
                GetPurchaseOrderInfoJSRep info = data1.get(position);
                Intent intent=new Intent(WXCPSHActivity.this,WXCPSHDialog1Activity.class);
                intent.putExtra("I_INKDPOS",info.getMarketorderrow());
                intent.putExtra("I_INMATNR",info.getMATNR());
                intent.putExtra("I_INKDAUF",info.getMarketorderno());
                EditText et=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                String recenumstr=et.getText().toString();
                float num=Float.parseFloat(("0"+recenumstr));
                intent.putExtra("dhsl",num);
                intent.putExtra("type",info.getMaterialType());
                intent.putExtra("index",position);
                intent.putExtra("username",username);
                startActivityForResult(intent,REQUEST_CODE_1);
                break;
            case R.id.receive2:
                Log.e("内部receive2>>", position + "");
                vibrator.vibrate(30);
                GetPurchaseOrderInfoJSRep info2 = data1.get(position);
                Intent intent2=new Intent(WXCPSHActivity.this,WXCPSHDialog2Activity.class);
                intent2.putExtra("I_INKDPOS",info2.getMarketorderrow());
                //!!!注意
                intent2.putExtra("I_INMATNR",materialList.get(position));
                intent2.putExtra("I_INKDAUF",info2.getMarketorderno());
                EditText et2=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                String recenumstr2=et2.getText().toString();
                float num2=Float.parseFloat(("0"+recenumstr2));
                intent2.putExtra("dhsl",num2);
                intent2.putExtra("type",info2.getMaterialType());
                intent2.putExtra("index",position);
                intent2.putExtra("username",username);
                startActivityForResult(intent2,REQUEST_CODE_2);
                break;
            case R.id.receive3:
                Log.e("内部receive3>>", position + "");
                vibrator.vibrate(30);
                if (switchBeans.get(position).isSwitch1() && switchBeans.get(position).isSwitch2()){
                    //选中的需求仓库
                    View itme=listview1.getChildAt(position - listview1.getFirstVisiblePosition());
                    Spinner sp= itme.findViewById(R.id.spinner1);
                    int selectedItemPosition = sp.getSelectedItemPosition();
//                System.out.println("选中的仓库index:"+selectedItemPosition);
                    String storage= data1.get(position).getStorage().get(selectedItemPosition).getId();
                    beans3.get(position).setDemandStorage(storage);
                    //数量
                    EditText et3=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                    String recenumstr3=et3.getText().toString();
                    float num3=Float.parseFloat(("0"+recenumstr3));
                    beans3.get(position).setRecNum(num3);
                    presenter2.OutsourceFinishedProductReceivingJS(getCurrentdate(),getCurrentdate(),username,beans3.get(position));
                }else {
                    Toast.makeText(this, "请先选择生产订单", Toast.LENGTH_SHORT).show();
                }

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
                        Toast.makeText(WXCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(WXCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXCPSHActivity.this);
        Toast.makeText(WXCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }
}
