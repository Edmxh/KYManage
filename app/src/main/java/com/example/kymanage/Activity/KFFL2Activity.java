package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.KFFLFKAdapter;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRep;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRepBean;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFScanFL.ScanIssueNoteDetailPresenter;
import com.jensdriller.libs.multistatelistview.MultiStateListView;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.popup.QMUIPopups;
import com.qmuiteam.qmui.widget.popup.QMUIQuickAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KFFL2Activity extends BaseActivity implements ScanBaseView<ScanIssueNoteDetailRep> {
    //扫描
    private ImageView scan;
    private View fldxx_layout;
    private TextView fldh;
    private TextView flry;
    private TextView flsj;
    private TextView flzt;

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
    private ImageView sx;
    //震动
    private Vibrator vibrator;

    private List<ScanIssueNoteDetailRepBean> list2;

    private boolean finish261=true;



    @Override
    public int initLayoutId() {
        return R.layout.activity_kffl2;
    }

    @Override
    public void initview() {
        scan=findViewById(R.id.scan);
        sx=findViewById(R.id.sx);
        fldxx_layout=findViewById(R.id.fldxx_layout);
        fldxx_layout.setVisibility(View.INVISIBLE);

        fldh=findViewById(R.id.fldh);
        flry=findViewById(R.id.flry);
        flsj=findViewById(R.id.flsj);
        flzt=findViewById(R.id.flzt);


        listview1=findViewById(R.id.listview1);
        //listview1.showLoadingView();
        adapter=new KFFLFKAdapter(this, R.layout.kfflfkitem,new ArrayList<ScanIssueNoteDetailRepBean>());
        listview1.setAdapter(adapter);


        presenter1=new ScanIssueNoteDetailPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        list2=new ArrayList<ScanIssueNoteDetailRepBean>();

        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                scan();

//                scanString="{\"no\":\"200723094521873\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(KFFL2Activity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    String flnum = lableObject.getString("no");
//
//                    fldh.setText(flnum);
//                    flry.setText(username);
//                    flsj.setText(getCurrentdate2());
//                    fldxx_layout.setVisibility(View.VISIBLE);
//                    //加载动画
//                    adapter.clear();
//                    adapter.notifyDataSetChanged();
//                    LoadingBar.dialog(KFFL2Activity.this).setFactoryFromResource(R.layout.layout_custom3).show();
////                        listview1.setVisibility(View.GONE);
////                        loading.setVisibility(View.VISIBLE);
////                        String factory=lableObject.getString("gc");
////                        presenter1.GetStockInformationDataJS(materialCode,factory);
//
////                        GetMaterialStorageReq req2=new GetMaterialStorageReq(factory, materialCode);
////                        GetMaterialStorageReq req2=new GetMaterialStorageReq("2010", "DQ4402000001");
////                        presenter2.GetMaterialStorage(req2);
//                    ScanIssueNoteDetailReqBean bean=new ScanIssueNoteDetailReqBean(flnum,username);
//                    presenter1.ScanIssueNoteDetail(bean);
//                    scanString="";
//                }else {
//                    Toast.makeText(KFFL2Activity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }

            }
        });
        sx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                QMUIPopups.quickAction(getApplicationContext(),
                        QMUIDisplayHelper.dp2px(getApplicationContext(), 48),
                        QMUIDisplayHelper.dp2px(getApplicationContext(), 48))
                        .shadow(true)
                        .skinManager(QMUISkinManager.defaultInstance(getApplicationContext()))
                        .edgeProtection(QMUIDisplayHelper.dp2px(getApplicationContext(), 1))
                        .addAction(new QMUIQuickAction.Action().icon(R.drawable.icon_all).text("全部").onClick(
                                new QMUIQuickAction.OnClickListener() {
                                    @Override
                                    public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                        quickAction.dismiss();
                                        List<ScanIssueNoteDetailRepBean> list=new ArrayList<ScanIssueNoteDetailRepBean>();
                                        for (ScanIssueNoteDetailRepBean bean : list2) {
                                            list.add(bean);
                                        }
                                        adapter=new KFFLFKAdapter(getApplicationContext(), R.layout.kfflfkitem,list);
                                        listview1.setAdapter(adapter);
                                    }
                                }
                        ))
                        .addAction(new QMUIQuickAction.Action().icon(R.drawable.icon_success).text("成功").onClick(
                                new QMUIQuickAction.OnClickListener() {
                                    @Override
                                    public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                        quickAction.dismiss();
                                        List<ScanIssueNoteDetailRepBean> list=new ArrayList<ScanIssueNoteDetailRepBean>();
                                        for (ScanIssueNoteDetailRepBean bean : list2) {
                                            if(bean.getStatus().equals("已发料")){
                                                list.add(bean);
                                            }
                                        }
                                        adapter=new KFFLFKAdapter(getApplicationContext(), R.layout.kfflfkitem,list);
                                        listview1.setAdapter(adapter);
                                        if(list.size()==0){
                                            Toast.makeText(KFFL2Activity.this, "本次没有发料成功的物料", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        ))
                        .addAction(new QMUIQuickAction.Action().icon(R.drawable.icon_fail).text("失败").onClick(
                                new QMUIQuickAction.OnClickListener() {
                                    @Override
                                    public void onClick(QMUIQuickAction quickAction, QMUIQuickAction.Action action, int position) {
                                        quickAction.dismiss();
                                        List<ScanIssueNoteDetailRepBean> list=new ArrayList<ScanIssueNoteDetailRepBean>();
                                        for (ScanIssueNoteDetailRepBean bean : list2) {
                                            if(bean.getStatus().equals("待发料")){
                                                list.add(bean);
                                            }
                                        }
                                        adapter=new KFFLFKAdapter(getApplicationContext(), R.layout.kfflfkitem,list);
                                        listview1.setAdapter(adapter);
                                        if(list.size()==0){
                                            Toast.makeText(KFFL2Activity.this, "本次没有发料失败的物料", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                        ))
                        .show(v);
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
        System.out.println("服务器响应成功");
        //收到响应后解除扫码发料的限制
        finish261=true;
        LoadingBar.dialog(KFFL2Activity.this).setFactoryFromResource(R.layout.layout_custom3).cancel();
        flzt.setText(data.getMstatus());
        if(data.getMstatus()!=null){
            if(data.getMstatus().equals("全部发料")){
                flzt.setTextColor(Color.GREEN);
            }else {
                flzt.setTextColor(Color.RED);
            }
        }
        list2=data.getData();
        List<ScanIssueNoteDetailRepBean> list = data.getData();
        adapter=new KFFLFKAdapter(this, R.layout.kfflfkitem,list);
        listview1.setAdapter(adapter);
        //listview1.showView(MultiStateListView.State.LOADING);
//        listview1.setVisibility(View.VISIBLE);
//        loading.setVisibility(View.GONE);
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(KFFL2Activity.this).setFactoryFromResource(R.layout.layout_custom3).cancel();
        System.out.println("服务器响应失败");
        Toast.makeText(this, "服务器响应失败,请稍后重试", Toast.LENGTH_LONG).show();
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
                        //加载动画
                        adapter.clear();
                        adapter.notifyDataSetChanged();
                        LoadingBar.dialog(KFFL2Activity.this).setFactoryFromResource(R.layout.layout_custom3).show();
//                        listview1.setVisibility(View.GONE);
//                        loading.setVisibility(View.VISIBLE);
//                        String factory=lableObject.getString("gc");
//                        presenter1.GetStockInformationDataJS(materialCode,factory);

//                        GetMaterialStorageReq req2=new GetMaterialStorageReq(factory, materialCode);
//                        GetMaterialStorageReq req2=new GetMaterialStorageReq("2010", "DQ4402000001");
//                        presenter2.GetMaterialStorage(req2);
                        ScanIssueNoteDetailReqBean bean=new ScanIssueNoteDetailReqBean(flnum,username);
                        //控制未收到上一次扫码发料返回结果前禁止扫码
                        if(finish261){
                            finish261=false;
                            presenter1.ScanIssueNoteDetail(bean);
                        }else {
                            Toast.makeText(KFFL2Activity.this, "请稍等...", Toast.LENGTH_SHORT).show();
                        }

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
