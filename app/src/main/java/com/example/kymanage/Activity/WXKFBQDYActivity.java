package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXCPSHAdapter;
import com.example.kymanage.Adapter.WXCPSHDialog1Adapter;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordReq;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage7.InsertFinAProOrderRecordPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXKFBQDYActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView1<PreMaterialProductOrderReps>, PrintBaseView<InsertFinAProOrderRecordRep> {

    //扫码
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private String scanString;
    private String marketorderno;
    private String marketorderrow;
    private long fid;
    private TextView wlbm;
    private TextView wlms;
    private TextView wllx;
    private TextView wlsl;
    private GetMaterialMasterDataJSPresenter presenterScan;
    private GetMaterialMasterDataInfo material=new GetMaterialMasterDataInfo();



    //选择上游工厂
    private Spinner spinner1;
    private ArrayAdapter<String> adapter0;
    private CGSHReceiveDetailPresenter presenter1;
    private ListView listview1;
    private WXCPSHDialog1Adapter adapter1;
    private List<PreMaterialProductOrderRep> productOrderList=new ArrayList<PreMaterialProductOrderRep>();


    //打印
    private ImageView print;
    private InsertFinAProOrderRecordPresenter presenterPrint;
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    //震动
    private Vibrator vibrator;
    //username
    private String username;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxkfbqdy;
    }

    @Override
    public void initview() {
        //震动
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        //扫码
        scan=findViewById(R.id.scan);
        wlbm=findViewById(R.id.wlbm);
        wlms=findViewById(R.id.wlms);
        wllx=findViewById(R.id.wllx);
        wlsl=findViewById(R.id.wlsl);

        presenterScan=new GetMaterialMasterDataJSPresenter();
        presenterScan.setView(this);

        //选择上游生产订单
        spinner1=findViewById(R.id.spinner1);
        listview1=findViewById(R.id.listview1);
        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

        //打印
        print=findViewById(R.id.print);
        presenterPrint=new InsertFinAProOrderRecordPresenter();
        presenterPrint.setView(this);
    }

    @Override
    public void initData() {

        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("name", "");

        //选择上游生产订单
        List<String> factorys = new ArrayList<String>();
        factorys.add("请选择");
        factorys.add("2010");
        factorys.add("2020");
        factorys.add("2030");
        factorys.add("2040");
        factorys.add("2050");
        factorys.add("2051");
        factorys.add("2090");
        adapter0 = new ArrayAdapter<String>(getApplicationContext(), R.layout.defined_spinner_item, factorys);
        //设置下拉列表的风格
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spinner1.setAdapter(adapter0);
        spinner1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                float reqnum=Float.parseFloat("0"+wlsl.getText().toString());
                presenter1.CGSHReceiveDetail("","",wlbm.getText().toString(),factorys.get(arg2),reqnum);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        cb = new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
    }

    //初始化
    public void initPrinter() {
        printHelper = new PrintHelper();
        printHelper.Open(WXKFBQDYActivity.this);
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                scan();
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<InsertFinAProOrderRecordReq.InsertFinAProOrderRecordReqBean> sdata=new ArrayList<InsertFinAProOrderRecordReq.InsertFinAProOrderRecordReqBean>();
                float allnum=0;
                for (int i = 0; i < productOrderList.size(); i++) {
                    PreMaterialProductOrderRep rep = productOrderList.get(i);
                    View listItem=listview1.getAdapter().getView(i,null,null);
                    CheckBox checkBox=listItem.findViewById(R.id.checked);
                    EditText et1=listItem.findViewById(R.id.fpsl);
                    float issueNum=0;
                    issueNum=Float.parseFloat(("0"+et1.getText().toString()));
                    if(checkBox.isChecked()){
                        allnum+=issueNum;
                        InsertFinAProOrderRecordReq.InsertFinAProOrderRecordReqBean bean =new InsertFinAProOrderRecordReq.InsertFinAProOrderRecordReqBean(rep.getDemandNum(), rep.getDispatchNum(), issueNum, rep.getFactory(), rep.getMATNR(), rep.getProductOrderNO(), rep.getMAKTX(), rep.getKDAUF(), rep.getKDPOS(), rep.getStorage(), rep.getRSNUM(), rep.getRSPOS(), rep.getProOrderDesc(), rep.getProOrderMaterialCode(), rep.getProOrderMaterialDesc(), rep.getProOrderMaterialUnit(), rep.getMEINS(), "", rep.getMCODE(),rep.getPLORD(),rep.getOTYPE(),rep.getSOBKZ(),rep.getLGPBE());
                        sdata.add(bean);
                    }
                }
                InsertFinAProOrderRecordReq req=new InsertFinAProOrderRecordReq(material.getMATNR(), material.getMaterialType(), material.getMAKTX(), allnum, username, material.getWERKS(), fid, sdata);
                presenterPrint.InsertFinAProOrderRecord(req);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
        material = data.getMaterial();
        wlbm.setText(material.getMATNR());
        wlms.setText(material.getMAKTX());
        wllx.setText(material.getMaterialType());
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        productOrderList = data.getData();
        adapter1=new WXCPSHDialog1Adapter(WXKFBQDYActivity.this, R.layout.wxcpshitem1, productOrderList);
        listview1.setAdapter(adapter1);
    }

    @Override
    public void onDataSuccessPrint(InsertFinAProOrderRecordRep data) {
        List<InsertFinAProOrderRecordRep.InsertFinAProOrderRecord> datas = data.getData();

        for (InsertFinAProOrderRecordRep.InsertFinAProOrderRecord label : datas) {
            Bitmap bm = cb.createImage9(label, tf);
            printHelper.PrintBitmapAtCenter(bm, 384, 480);
            printHelper.printBlankLine(81);
        }

        wlbm.setText("");
        wlms.setText("");
        wllx.setText("");
        wlsl.setText("");
        spinner1.setSelection(0);
        productOrderList.clear();
        adapter1.notifyDataSetChanged();
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
                        Toast.makeText(WXKFBQDYActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        try {
                           String code=lableObject.getString("bm");
                           marketorderno=lableObject.getString("no");
                           marketorderrow=lableObject.getString("line");
                           String gc=lableObject.getString("gc");
                           float num=lableObject.getFloat("sl");
                           fid=lableObject.getLong("fid");
                           wlsl.setText(""+num);
                           presenterScan.GetMaterialMasterDataJS(code,"2090");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXKFBQDYActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
                return true;
            // 音量增大
            case KeyEvent.KEYCODE_VOLUME_UP:
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
