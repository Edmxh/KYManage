package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.PrintKGCPSDAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.Print2.MaterialFactoryDumpPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintKGCPSDActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView1<MaterialFactoryDumpRep> {
    //震动
    private Vibrator vibrator;
    private ImageView scan;
    private ImageView print;
    private ImageView divert;
    private ImageView record;
    //表格
    private ListView listview1;
    private List<MaterialFactoryDumpReqBean> datas;
    private PrintKGCPSDAdapter adapter;
    //扫描相关
    private String m_Broadcastname = "com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetMaterialMasterDataJSPresenter presenter1;
    private String scanString;

    //扫描获取的值
    private long fid;
    private String po;
    private String no;
    private String line;
    private float qty;

    //301转储
    private MaterialFactoryDumpPresenter presenter2;

    //传递的username
    private String username;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_kgcpsd;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        scan=findViewById(R.id.scan);
        print=findViewById(R.id.print);
        divert=findViewById(R.id.divert);
        record=findViewById(R.id.record);
        listview1=findViewById(R.id.listview1);

        presenter1=new GetMaterialMasterDataJSPresenter();
        presenter1.setView(this);

        presenter2=new MaterialFactoryDumpPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        datas=new ArrayList<MaterialFactoryDumpReqBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
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
            }
        });
        divert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                MaterialFactoryDumpReq req=new MaterialFactoryDumpReq(username,datas);
                presenter2.MaterialFactoryDump(req);
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent=new Intent(PrintKGCPSDActivity.this,DivertRecord1Activity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
        MaterialFactoryDumpReqBean scanBean=new MaterialFactoryDumpReqBean(getCurrentdate(), getCurrentdate(), fid, data.getMaterial().getMATNR(), data.getMaterial().getMAKTX(), data.getMaterial().getMaterialType(), data.getMaterial().getMEINS(), po, no, line, qty, "301转储");
        datas.add(scanBean);
        adapter=new PrintKGCPSDAdapter(this, R.layout.wxkgcpsditem,datas);
        listview1.setAdapter(adapter);
    }

    @Override
    public void onDataSuccess1(MaterialFactoryDumpRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {

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
                        Toast.makeText(PrintKGCPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if (lableObject != null) {
//                    System.out.println(lableObject.getString("bm"));
                        po = lableObject.getString("po");
                        no = lableObject.getString("no");
                        line = lableObject.getString("line");
                        fid = lableObject.getLong("fid");
                        qty = lableObject.getFloat("sl");
                        String bm = lableObject.getString("bm");
//                        sl=lableObject.getFloat("sl");
//                        bm = lableObject.getString("bm");
//                        area = lableObject.getString("cd");
//                        factory=lableObject.getString("gc");
//                        labelSquNum=lableObject.getString("num");
//                        cs=lableObject.getInteger("cs");

                        //判断是否重复扫码
                        boolean repeat = false;
                        for (MaterialFactoryDumpReqBean data : datas) {
                            if (data.getMatnr().equals(bm)) {
                                repeat = true;
                                break;
                            }
                        }
                        if (repeat) {
                            System.out.println("请勿重复扫码");
                            Toast.makeText(PrintKGCPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();

                        } else {
                            if (bm != null) {
//                                String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                                presenter1.GetMaterialMasterDataJS(bm, "2090");
                            }

                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString = "";
                    } else {
                        Log.i("token", "扫描结果为空");
                        Toast.makeText(PrintKGCPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
}
