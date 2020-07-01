package com.example.kymanage.Activity;

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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter;
import com.example.kymanage.Beans.General.SwitchBean;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.InsertFinProStorageRecordPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Record.GetFinProStorageRecordNotePresenter;
import com.example.kymanage.utils.Base64Tool;

import java.util.ArrayList;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPJGRKActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView2<InsertFinProStorageRecordRep>, BaseView3<GetFinProStorageRecordNoteRep>, WXBCPJGRKAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //震动
    private Vibrator vibrator;
    private ImageView scan;

    private ImageView record;
    //表格
    private ListView listview1;
    //scan
//扫描相关
    private String m_Broadcastname = "com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetMaterialMasterDataJSPresenter presenter1;
    private String scanString;
    private String marketorderno;
    private String marketorderrow;
    private WXBCPJGRKAdapter adapter1;
    private List<GetMaterialMasterDataInfo> datas;
    //base64解密
    private Base64Tool bt;

    private String username;
    //101
    private List<InsertFinProStorageRecordReq> reqs;
    private InsertFinProStorageRecordPresenter presenter2;

    //控制选择生产订单
    private List<SwitchBean> switchBeans;

    //选择上游生产订单物料编码
    private List<String> materialList;

    //限制数量
    private float limitNum;
    //print
    private ImageView print;
    private GetFinProStorageRecordNotePresenter presenter3;
    private List<WriteOffProStorageRecordReqBean> idlist;
    //打印类
    private PrintHelper printHelper = null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE_1 = 1;
    private static final int REQUEST_CODE_2 = 2;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpjgrk;
    }

    @Override
    public void initview() {
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan = findViewById(R.id.scan);
        print = findViewById(R.id.print);
        record = findViewById(R.id.record);
        //表格
        listview1 = findViewById(R.id.listview1);

        presenter1 = new GetMaterialMasterDataJSPresenter();
        presenter1.setView(this);

        presenter2 = new InsertFinProStorageRecordPresenter();
        presenter2.setView(this);

        presenter3 = new GetFinProStorageRecordNotePresenter();
        presenter3.setView(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("返回执行码是：" + requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE_1: //返回的请求码
                // 操作
                boolean confirm = data.getBooleanExtra("confirm", false);
                int index = data.getIntExtra("index", 0);
                String BLDAT = data.getStringExtra("BLDAT");
                String budat = data.getStringExtra("BUDAT");
                String matnr = data.getStringExtra("MATNR");
                String werks = data.getStringExtra("WERKS");
                String lgort = data.getStringExtra("LGORT");
                String aufnr = data.getStringExtra("AUFNR");
                float menge = data.getFloatExtra("MENGE", 0);
                String kdauf = data.getStringExtra("KDAUF");
                String kdpos = data.getStringExtra("KDPOS");
                String meins = data.getStringExtra("MEINS");
                String mcode = data.getStringExtra("MCODE");
                String materialDesc = data.getStringExtra("MaterialDesc");
                String materialType = data.getStringExtra("MaterialType");
                String handler = data.getStringExtra("Handler");
                if (confirm) {
                    System.out.println(reqs.get(index).toString());
                    InsertFinProStorageRecordReq currReq = reqs.get(index);
                    currReq.setBLDAT(BLDAT);
                    currReq.setBUDAT(budat);
                    currReq.setMATNR(matnr);
                    currReq.setWERKS(werks);
                    currReq.setLGORT(lgort);
                    currReq.setAUFNR(aufnr);
                    currReq.setMENGE(menge);
                    currReq.setKDAUF(kdauf);
                    currReq.setKDPOS(kdpos);
                    currReq.setMEINS(meins);
                    currReq.setMCODE(mcode);
                    currReq.setMaterialDesc(materialDesc);
                    currReq.setMaterialType(materialType);
                    currReq.setHandler(handler);
                    switchBeans.get(index).setSwitch1(true);

                    limitNum = menge;

                    View itme = listview1.getChildAt(index - listview1.getFirstVisiblePosition());
                    TextView rkdd = itme.findViewById(R.id.rkdd);
                    rkdd.setText(aufnr);

                    materialList.set(index, matnr);
                }
                break;
            case REQUEST_CODE_2: //返回的请求码
                // 操作
                boolean confirm2 = data.getBooleanExtra("confirm", false);
                int index2 = data.getIntExtra("index", 0);
                List<InsertFinProStorageRecordReqBean> detail = (List<InsertFinProStorageRecordReqBean>) data.getSerializableExtra("detail");
                if (confirm2) {
                    InsertFinProStorageRecordReq currReq = reqs.get(index2);
                    currReq.setData(detail);
                    System.out.println(reqs.get(index2).toString());
                    Object obj = JSON.toJSON(detail);
                    System.out.println("外协收货信息为：" + obj.toString());

                    switchBeans.get(index2).setSwitch2(true);

                    List<String> syddList = new ArrayList<String>();
                    for (InsertFinProStorageRecordReqBean detailBean : detail) {
                        syddList.add(detailBean.getProductOrderNO());
                    }
                    View itme = listview1.getChildAt(index2 - listview1.getFirstVisiblePosition());
                    TextView rkdd = itme.findViewById(R.id.sydd);
                    rkdd.setText(syddList.toString());


                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        materialList = new ArrayList<String>();
        datas = new ArrayList<GetMaterialMasterDataInfo>();
        reqs = new ArrayList<InsertFinProStorageRecordReq>();
        switchBeans = new ArrayList<SwitchBean>();
        idlist = new ArrayList<WriteOffProStorageRecordReqBean>();

        bt = new Base64Tool();

        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        cb = new CreateBitmap();
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
                Thread scanThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        scan();
                    }
                });
                scanThread.start();
                try {
                    Log.i("token", "scanThread.join();");
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                scanString = "{\"no\":\"0010000208\",\"line\":\"000026\",\"code\":\"TEoyMDE1MDAwNTk0LUEwMQ==\"}";
//                JSONObject lableObject = null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(WXBCPJGRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if (lableObject != null) {
////                    System.out.println(lableObject.getString("bm"));
//                    marketorderno = lableObject.getString("no");
//                    marketorderrow = lableObject.getString("line");
//                    String bm = lableObject.getString("code");
////                        sl=lableObject.getFloat("sl");
////                        bm = lableObject.getString("bm");
////                        area = lableObject.getString("cd");
////                        factory=lableObject.getString("gc");
////                        labelSquNum=lableObject.getString("num");
////                        cs=lableObject.getInteger("cs");
//
//                    //判断是否重复扫码
//                    boolean repeat = false;
//                    for (GetMaterialMasterDataInfo data : datas) {
//                        String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                        if (data.getMATNR().equals(decodestr)) {
//                            repeat = true;
//                            break;
//                        }
//                    }
//                    if (repeat) {
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(WXBCPJGRKActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                    } else {
////
//                        if (bm != null) {
//                            String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                            presenter1.GetMaterialMasterDataJS(decodestr, "2090");
//                        }
//
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString = "";
//                } else {
//                    Log.i("token", "扫描结果为空");
//                    Toast.makeText(WXBCPJGRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                presenter3.GetFinProStorageRecordNote(idlist);
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent = new Intent(WXBCPJGRKActivity.this, WXSHJLActivity.class);
                intent.putExtra("username", username);
//                System.out.println("外协二级菜单发："+username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        GetMaterialMasterDataInfo material = data.getMaterial();
        material.setMarketorderno(marketorderno);
        material.setMarketorderrow(marketorderrow);
        try {
            datas.add(material);
            materialList.add(material.getMATNR());
            adapter1 = new WXBCPJGRKAdapter(this, R.layout.wxbcprkitem, datas);
            adapter1.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter1);
            listview1.setOnItemClickListener(this);

            InsertFinProStorageRecordReq req = new InsertFinProStorageRecordReq();
            reqs.add(req);

            SwitchBean switchbean = new SwitchBean(false, false);
            switchBeans.add(switchbean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDataSuccess2(InsertFinProStorageRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            WriteOffProStorageRecordReqBean idreq = new WriteOffProStorageRecordReqBean(("" + data.getData()));
            idlist.add(idreq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess3(GetFinProStorageRecordNoteRep data) {
        List<GetFinProStorageRecordNoteRepBean> labels = data.getData();
        if (labels != null) {
            for (GetFinProStorageRecordNoteRepBean label : labels) {
                Bitmap bm = cb.createImage6(label, tf);
                printHelper.PrintBitmapAtCenter(bm, 384, 480);
                printHelper.printBlankLine(80);
            }
            System.out.println("打印标签的数量为" + data.getData().size());
            Toast.makeText(WXBCPJGRKActivity.this, "打印标签的数量为" + labels.size(), Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("未打印标签");
        }

        Toast.makeText(WXBCPJGRKActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {

    }

    //扫描操作
    public void scan() {
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
                GetMaterialMasterDataInfo info = datas.get(position);
                Intent intent = new Intent(WXBCPJGRKActivity.this, WXBCPJGRKDialog1Activity.class);
                intent.putExtra("I_INKDPOS", info.getMarketorderrow());
                intent.putExtra("I_INMATNR", info.getMATNR());
                intent.putExtra("I_INKDAUF", info.getMarketorderno());
                intent.putExtra("type", info.getMaterialType());
                intent.putExtra("index", position);
                intent.putExtra("username", username);
                startActivityForResult(intent, REQUEST_CODE_1);
                break;
            case R.id.receive2:
                Log.e("内部receive2>>", position + "");
                vibrator.vibrate(30);
                if (switchBeans.get(position).isSwitch1()) {
                    GetMaterialMasterDataInfo info2 = datas.get(position);
                    Intent intent2 = new Intent(WXBCPJGRKActivity.this, WXBCPJGRKDialog2Activity.class);
                    intent2.putExtra("I_INKDPOS", info2.getMarketorderrow());
                    intent2.putExtra("I_INMATNR", materialList.get(position));
                    intent2.putExtra("I_INKDAUF", info2.getMarketorderno());
                    intent2.putExtra("limitNum", limitNum);
                    intent2.putExtra("type", info2.getMaterialType());
                    intent2.putExtra("index", position);
                    intent2.putExtra("username", username);
                    startActivityForResult(intent2, REQUEST_CODE_2);
                } else {
                    Toast.makeText(WXBCPJGRKActivity.this, "请先选择本事业部生产订单", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.receive3:
                Log.e("内部receive3>>", position + "");
                vibrator.vibrate(30);
                if (switchBeans.get(position).isSwitch1() && switchBeans.get(position).isSwitch2()) {
                    presenter2.InsertFinProStorageRecord(reqs.get(position));
                } else {
                    Toast.makeText(WXBCPJGRKActivity.this, "请先选择生产订单", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }

    public void initView() {
    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver {
        private static final String TAG = "MycodeReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString = str;
                    JSONObject lableObject = null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(WXBCPJGRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if (lableObject != null) {
//                    System.out.println(lableObject.getString("bm"));
                        marketorderno = lableObject.getString("no");
                        marketorderrow = lableObject.getString("line");
                        String bm = lableObject.getString("code");
//                        sl=lableObject.getFloat("sl");
//                        bm = lableObject.getString("bm");
//                        area = lableObject.getString("cd");
//                        factory=lableObject.getString("gc");
//                        labelSquNum=lableObject.getString("num");
//                        cs=lableObject.getInteger("cs");

                        //判断是否重复扫码
                        boolean repeat = false;
                        for (GetMaterialMasterDataInfo data : datas) {
                            String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                            if (data.getMATNR().equals(decodestr)) {
                                repeat = true;
                                break;
                            }
                        }
                        if (repeat) {
                            System.out.println("请勿重复扫码");
                            Toast.makeText(WXBCPJGRKActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();

                        } else {
//
                            if (bm != null) {
                                String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                                presenter1.GetMaterialMasterDataJS(decodestr, "2090");
                            }

                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString = "";
                    } else {
                        Log.i("token", "扫描结果为空");
                        Toast.makeText(WXBCPJGRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //初始化
    public void initPrinter() {
        printHelper = new PrintHelper();
        printHelper.Open(WXBCPJGRKActivity.this);
        Toast.makeText(WXBCPJGRKActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
