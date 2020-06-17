package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WLQueryAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRepBean;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageReq;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSBean;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage3.GetStockInformationDataJSPresenter;
import com.example.kymanage.presenter.Presenters.WLQueryPage1.GetMaterialStoragePresenter;

import java.util.ArrayList;
import java.util.List;

public class WLQueryActivity extends BaseActivity implements ScanBaseView<GetStockInformationDataJSRep>, BaseView1<GetMaterialStorageRep> {
    //扫描
    private ImageView scan;
    private View kcxx_layout;
    private TextView wlbm;
    private TextView wlms;
    private TextView wllx;
    private TextView kcdd;
    private TextView kcsl;

    private GetStockInformationDataJSPresenter presenter1;
    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;



    private ListView listview1;
    private GetMaterialStoragePresenter presenter2;


    private WLQueryAdapter adapter;
    private List<GetMaterialStorageRepBean> datas;

    //震动
    private Vibrator vibrator;
    @Override
    public int initLayoutId() {
        return R.layout.activity_wlquery;
    }

    @Override
    public void initview() {
        scan=findViewById(R.id.scan);
        kcxx_layout=findViewById(R.id.kcxx_layout);
        kcxx_layout.setVisibility(View.INVISIBLE);
        wlbm=findViewById(R.id.wlbm);
        wlms=findViewById(R.id.wlms);
        wllx=findViewById(R.id.wllx);
        kcdd=findViewById(R.id.kcdd);
        kcsl=findViewById(R.id.kcsl);

        listview1=findViewById(R.id.listview1);

        presenter1=new GetStockInformationDataJSPresenter();
        presenter1.setView(this);

        presenter2=new GetMaterialStoragePresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        datas=new ArrayList<GetMaterialStorageRepBean>();
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
//                 scanString="{\"bm\":\"DQ2002020001\",\"sl\":2.0,\"num\":\"15905735622182\",\"po\":\"000010031196\",\"pono\":\"4100011740\",\"porow\":\"00020\",\"gc\":\"2010\",\"cd\":\"A12\",\"cs\":6}";
//               JSONObject lableObject= null;
//                    try {
//                        lableObject = JSONObject.parseObject(scanString);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Toast.makeText(WLQueryActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                    }
//                    if(lableObject!=null) {
//                        String materialCode = lableObject.getString("bm");
//                        String factory=lableObject.getString("gc");
//                        presenter1.GetStockInformationDataJS(materialCode,factory);
//
////                        GetMaterialStorageReq req2=new GetMaterialStorageReq(factory, materialCode);
//                        GetMaterialStorageReq req2=new GetMaterialStorageReq("2010", "DQ4402000001");
//                        presenter2.GetMaterialStorage(req2);
//                        scanString="";
//                    }else {
//                        Toast.makeText(WLQueryActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                    }
            }
        });
    }

    @Override
    public void onDataSuccessScan(GetStockInformationDataJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            wlbm.setText(data.getData().getMaterialCode());
            wlms.setText(data.getData().getMaterialDesc());
            wllx.setText(data.getData().getMaterialType());
            kcdd.setText(data.getData().getStorage());
            kcsl.setText(data.getData().getQty()+"");
            kcxx_layout.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess1(GetMaterialStorageRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas=data.getData();
            adapter=new WLQueryAdapter(this, R.layout.wlqueryitem,datas);
            listview1.setAdapter(adapter);
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
//        Toast.makeText(KFFLActivity.this, "扫描注册初始化", Toast.LENGTH_SHORT).show();
        registerReceiver(receiver, intentFilter);

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
                        Toast.makeText(WLQueryActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        String materialCode = lableObject.getString("bm");
                        String factory=lableObject.getString("gc");
                        presenter1.GetStockInformationDataJS(materialCode,factory);

                        GetMaterialStorageReq req2=new GetMaterialStorageReq(factory, materialCode);
//                        GetMaterialStorageReq req2=new GetMaterialStorageReq("2010", "DQ4402000001");
                        presenter2.GetMaterialStorage(req2);
                        scanString="";
                    }else {
                        Toast.makeText(WLQueryActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(WLQueryActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
}
