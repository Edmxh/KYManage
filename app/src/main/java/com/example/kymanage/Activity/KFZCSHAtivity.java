package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.KFPSDAdapter;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRepBean1;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordReqBean;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordRep;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReq;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage2.GetTransferRecordPresenter;
import com.example.kymanage.presenter.Presenters.KFPage2.InsertDumpTransferRecordPresenter;
import com.example.kymanage.utils.DialogUtil;

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
    private TextView scdd;
    private TextView cjsj;
    private TextView gxsj;
    private TextView zczt;
    //扫描获取的数据
    private String dumpNum ;
    private GetTransferRecordPresenter presenter1;
    private List<GetTransferRecordRepBean1> datas;



    //缩略菜单
    private ImageView menupoint;
    PopupMenu popup = null;
    //转储发料确认
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
        menupoint=findViewById(R.id.menupoint);
        listview1=findViewById(R.id.listview1);
        scdd=findViewById(R.id.scdd);
        cjsj=findViewById(R.id.cjsj);
        gxsj=findViewById(R.id.gxsj);
        zczt=findViewById(R.id.zczt);

        presenter1=new GetTransferRecordPresenter();
        presenter1.setView(this);

        presenter2=new InsertDumpTransferRecordPresenter();
        presenter2.setView(this);


    }

    @Override
    public void initData() {
        reqList=new ArrayList<InsertDumpTransferRecordReqBean>();
        datas=new ArrayList<GetTransferRecordRepBean1>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        recordReq=new InsertDumpTransferRecordReq(null,username,"");
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
        menupoint.setOnClickListener(v -> {
            vibrator.vibrate(30);
            onPopupButtonClick(menupoint);
        });
    }

    //缩略菜单
    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.kfzcshmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                item -> {
                    switch (item.getItemId())
                    {
                        case R.id.record:
                            // 隐藏该对话框
                            Intent intent = new Intent(KFZCSHAtivity.this,KFZCSHRecordActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.receive:
                            vibrator.vibrate(30);
                            if(reqList.size()>0){
                                recordReq.setData(reqList);
                                recordReq.setDumpNum(dumpNum);
                                LoadingBar.dialog(KFZCSHAtivity.this).setFactoryFromResource(R.layout.layout_custom8).show();
                                presenter2.InsertDumpTransferRecord(recordReq);
                            }
                            break;
                        default:
                            // 使用Toast显示用户单击的菜单项
                    }
                    return true;
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetTransferRecordRep data) {
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            DialogUtil.startAlarm(this);
            vibrator.vibrate(300);
            if(data.getMdata().getStatus().equals("已全部配送")){
                DialogUtil.infoMessageDialog(KFZCSHAtivity.this,"配送单已全部配送，请勿重复扫码!");
            }else if(data.getMdata().getStatus().equals("已全部发料")){
                DialogUtil.infoMessageDialog(KFZCSHAtivity.this,"配送单已全部发料，请勿重复扫码!");
            }
            try {
                datas.clear();
                reqList.clear();
                for (GetTransferRecordRepBean1 datum : data.getData()) {
                    datas.add(datum);
                    InsertDumpTransferRecordReqBean reqBean=new InsertDumpTransferRecordReqBean(datum.getID());
                    reqList.add(reqBean);
                }
                adapter=new KFPSDAdapter(KFZCSHAtivity.this, R.layout.kfpsditem,datas);
                listview1.setAdapter(adapter);

                scdd.setText(data.getMdata().getProductOrderNO());
                cjsj.setText(data.getMdata().getCreateTime());
                gxsj.setText(data.getMdata().getUpdateTime());
                String ztStr;
                if(data.getMdata().getReverseHandler().equals("")){
                    ztStr=data.getMdata().getStatus();
                }else {
                    ztStr=data.getMdata().getStatus()+"("+data.getMdata().getReverseHandler()+")";
                }
                zczt.setText(ztStr);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            DialogUtil.errorMessageDialog(KFZCSHAtivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onDataSuccess1(InsertDumpTransferRecordRep data) {
        LoadingBar.dialog(KFZCSHAtivity.this).setFactoryFromResource(R.layout.layout_custom8).cancel();
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            datas.clear();
            adapter.notifyDataSetChanged();

            scdd.setText("");
            cjsj.setText("");
            gxsj.setText("");
            zczt.setText("");
        }else {
            DialogUtil.errorMessageDialog(KFZCSHAtivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(KFZCSHAtivity.this).setFactoryFromResource(R.layout.layout_custom8).cancel();
        DialogUtil.errorMessageDialog(KFZCSHAtivity.this,"服务器响应失败，请稍后重试!");
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
                        GetTransferRecordReqBean bean=new GetTransferRecordReqBean(dumpNum);
                        presenter1.GetTransferRecord(bean);

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
