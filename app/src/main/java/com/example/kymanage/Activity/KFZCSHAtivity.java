package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.KFPSDAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRepBean;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordReqBean;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordRep;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReq;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage2.GetTransferRecordPresenter;
import com.example.kymanage.presenter.Presenters.KFPage2.InsertDumpTransferRecordPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KFZCSHAtivity extends BaseActivity implements ScanBaseView<GetTransferRecordRep>, BaseView1<InsertDumpTransferRecordRep> {
    //扫描
    private ImageView scan;
    private ListView listview1;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private String scanString;
    //扫描获取的数据
    private String dumpNum ;
    private List<String> dumpNums;
    private GetTransferRecordPresenter presenter1;
    private List<GetTransferRecordRepBean> datas;


    //转储发料确认
    private ImageView receive;
    private InsertDumpTransferRecordPresenter presenter2;
    private InsertDumpTransferRecordReq recordReq;
    private List<InsertDumpTransferRecordReqBean> reqList;
    //cs
    private KFPSDAdapter adapter;

    //username
    private String username;

    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfpsdsh_ativity;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        scan=findViewById(R.id.scan);
        receive=findViewById(R.id.receive);
        listview1=findViewById(R.id.listview1);

        presenter1=new GetTransferRecordPresenter();
        presenter1.setView(this);

        presenter2=new InsertDumpTransferRecordPresenter();
        presenter2.setView(this);


    }

    @Override
    public void initData() {
        reqList=new ArrayList<InsertDumpTransferRecordReqBean>();
        dumpNums=new ArrayList<String>();
        datas=new ArrayList<GetTransferRecordRepBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        recordReq=new InsertDumpTransferRecordReq(null,username);
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

                //模拟扫码
//                scanString="{\"code\":\"202006220837072\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(KFZCSHAtivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    dumpNum=lableObject.getString("code");
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (int i = 0; i < dumpNums.size(); i++) {
//                        if(dumpNum.equals(dumpNums.get(i))){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(KFZCSHAtivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//                    }else {
//                        GetTransferRecordReqBean bean=new GetTransferRecordReqBean(dumpNum);
//                        presenter1.GetTransferRecord(bean);
//                    }
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(KFZCSHAtivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }

            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                if(reqList.size()>0){
                    recordReq.setData(reqList);
                    presenter2.InsertDumpTransferRecord(recordReq);
                }
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetTransferRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            for (GetTransferRecordRepBean datum : data.getData()) {
                datas.add(datum);

                InsertDumpTransferRecordReqBean reqBean=new InsertDumpTransferRecordReqBean(datum.getStatus(), datum.getSendFactory(), datum.getPostingdate(), datum.getMarketOrderNO(), datum.getDemandFactory(), datum.getCreateTime(), datum.getPID(), datum.getDocumentdate(), datum.getUnit(), datum.getDemandStorage(), datum.getSID(), datum.getYID(), datum.getSendStorage(), datum.getQty(), datum.getProductOrderNO(), datum.getID(), datum.getMarketOrderRow(), datum.getMaterialCode());
                reqList.add(reqBean);
            }
            adapter=new KFPSDAdapter(KFZCSHAtivity.this, R.layout.kfpsditem,datas);
            listview1.setAdapter(adapter);
            dumpNums.add(dumpNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess1(InsertDumpTransferRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(KFZCSHAtivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        dumpNum=lableObject.getString("code");
                        //判断是否重复扫码
                        boolean repeat=false;
                        for (int i = 0; i < dumpNums.size(); i++) {
                            if(dumpNum.equals(dumpNums.get(i))){
                                repeat=true;
                            }
                        }
                        if(repeat){
                            System.out.println("请勿重复扫码");
                            Toast.makeText(KFZCSHAtivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
                        }else {
                            GetTransferRecordReqBean bean=new GetTransferRecordReqBean(dumpNum);
                            presenter1.GetTransferRecord(bean);
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(KFZCSHAtivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
}
