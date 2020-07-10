package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.KFFLFKAdapter;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRep;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRepBean;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFScanFL.ScanIssueNoteDetailPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class KFFL2Activity extends BaseActivity implements ScanBaseView<ScanIssueNoteDetailRep> {
    //扫描
    private ImageView scan;
    private View fldxx_layout;
    private TextView fldh;
    private TextView flry;
    private TextView flsj;

    private ScanIssueNoteDetailPresenter presenter1;

    private String username;

    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;

    //列表
    private ListView listview1;
    private KFFLFKAdapter adapter;

    //震动
    private Vibrator vibrator;



    @Override
    public int initLayoutId() {
        return R.layout.activity_kffl2;
    }

    @Override
    public void initview() {
        scan=findViewById(R.id.scan);
        fldxx_layout=findViewById(R.id.fldxx_layout);
        fldxx_layout.setVisibility(View.INVISIBLE);

        fldh=findViewById(R.id.fldh);
        flry=findViewById(R.id.flry);
        flsj=findViewById(R.id.flsj);


        listview1=findViewById(R.id.listview1);

        presenter1=new ScanIssueNoteDetailPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

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
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //扫描操作
    public void scan(){
        Intent intent = new Intent();
        intent.setAction("com.barcode.sendBroadcastScan");
        sendBroadcast(intent);
    }
    //注册广播
    public void registerBroadcast(){
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(m_Broadcastname);
//        Toast.makeText(KFFLActivity.this, "扫描注册初始化", Toast.LENGTH_SHORT).show();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    public void onDataSuccessScan(ScanIssueNoteDetailRep data) {
        List<ScanIssueNoteDetailRepBean> list = data.getData();
        adapter=new KFFLFKAdapter(this, R.layout.kfflfkitem,list);
        listview1.setAdapter(adapter);
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
                        Toast.makeText(KFFL2Activity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        String flnum = lableObject.getString("no");

                        fldh.setText(flnum);
                        flry.setText(username);
                        flsj.setText(getCurrentdate2());
                        fldxx_layout.setVisibility(View.VISIBLE);
//                        String factory=lableObject.getString("gc");
//                        presenter1.GetStockInformationDataJS(materialCode,factory);

//                        GetMaterialStorageReq req2=new GetMaterialStorageReq(factory, materialCode);
//                        GetMaterialStorageReq req2=new GetMaterialStorageReq("2010", "DQ4402000001");
//                        presenter2.GetMaterialStorage(req2);
                        ScanIssueNoteDetailReqBean bean=new ScanIssueNoteDetailReqBean(flnum);
                        presenter1.ScanIssueNoteDetail(bean);
                        scanString="";
                    }else {
                        Toast.makeText(KFFL2Activity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(KFFL2Activity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
}
