package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXExceptionAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.OutsourcingExceptionJS.OutsourcingExceptionJSReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage9.GetOutsourcingExceptionTypeJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage9.OutsourcingExceptionJSPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXExceptionReceiveActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>, WXExceptionAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener, BaseView1<GetOutsourcingExceptionTypeJSRep>, BaseView2<CodeMessageBean> {

    //确认和取消按钮
    private ImageView scan;
    private ImageView record;
    //listview
    private ListView listview1;

    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;
    private String marketorderno;//外协图纸上的数据
    private String marketorderrow;//外协图纸上的数据
    private String upstreamFactory;//外协图纸上的数据
    private GetPurchaseOrderInfoJSPresenter presenterScan;//扫描获取采购订单信息
    private WXExceptionAdapter adapter;//扫描获取数据适配器
    private List<GetPurchaseOrderInfoJSRep> scanDatas;//扫描返回数据
    //username
    private String username;

    //震动
    private Vibrator vibrator;

    //获取外协异常登记原因
    private GetOutsourcingExceptionTypeJSPresenter presenter1;
    //异常原因列表
    private List<GetOutsourcingExceptionTypeJSRep.GetOutsourcingExceptionTypeJSRepBean> reasonList;

    //外协收货后冲销接口
    private OutsourcingExceptionJSPresenter presenter2;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxexception_receive;
    }

    @Override
    public void initview() {

        reasonList=new ArrayList<>();
        //震动
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        //按钮
        scan=findViewById(R.id.scan);
        record=findViewById(R.id.record);
        listview1=findViewById(R.id.listview1);//采购订单列表

        //扫描获取采购订单信息
        presenterScan=new GetPurchaseOrderInfoJSPresenter();
        presenterScan.setView(this);

        //获取外协异常登记原因
        presenter1=new GetOutsourcingExceptionTypeJSPresenter();
        presenter1.setView(this);
        presenter1.GetOutsourcingExceptionTypeJS();

        //外协收货后冲销接口
        presenter2=new OutsourcingExceptionJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        scanDatas=new ArrayList<GetPurchaseOrderInfoJSRep>();//扫描返回数据
        //username
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(v -> {
            vibrator.vibrate(30);
            scan();
        });
        record.setOnClickListener(v -> {
            vibrator.vibrate(30);
            Intent intent=new Intent(WXExceptionReceiveActivity.this,WXExceptionRecordActivity.class);
            startActivity(intent);
        });
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

    /**
     * 扫描成功适配显示
     * @param data
     */
    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        DialogUtil.startAlarm(this);
        vibrator.vibrate(300);
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            for (GetPurchaseOrderInfoJSRep datum : data.getData()) {
                datum.setMarketorderno(marketorderno);
                datum.setMarketorderrow(marketorderrow);
                datum.setReasonList(reasonList);
            }
            scanDatas=data.getData();
            adapter=new WXExceptionAdapter(this, R.layout.wxexceptionitem,scanDatas);
            adapter.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(this);
        }else {
            DialogUtil.errorMessageDialog(WXExceptionReceiveActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess1(GetOutsourcingExceptionTypeJSRep data) {
        reasonList=data.getData();
    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            scanDatas.clear();
            adapter.notifyDataSetChanged();
            //DialogUtil.errorMessageDialog(WXExceptionReceiveActivity.this,data.getMessage());
        }else {
            DialogUtil.errorMessageDialog(WXExceptionReceiveActivity.this,data.getMessage());
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        DialogUtil.errorMessageDialog(WXExceptionReceiveActivity.this,"服务器响应失败，请稍后重试!");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("整体receive>>", position + "");
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.receive:
                Log.d("内部receive>>", position + "");
                vibrator.vibrate(30);
                LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
                receive(position);
                break;
            default:
                break;
        }
    }

    /**
     * 异常收货
     */
    private void receive(int position){
        if(position>=0){
            GetPurchaseOrderInfoJSRep selectedData = scanDatas.get(position);


            View itme=listview1.getAdapter().getView(position,null,null);
            TextView et= itme.findViewById(R.id.dhsl);
            Spinner sp= itme.findViewById(R.id.spinner1);
            float recenum=Float.parseFloat("0"+et.getText().toString());
            //选中的需求仓库
//            int selectedItemPosition = sp.getSelectedItemPosition();
            int selectedItemPosition = selectedData.getSelectedItem();
            System.out.println("selectedItemPosition="+selectedItemPosition);
            String idStr = reasonList.get(selectedItemPosition).getId();

            OutsourcingExceptionJSReq req=new OutsourcingExceptionJSReq(getCurrentdate(), getCurrentdate(), selectedData.getEBELN(), selectedData.getEBELP(), selectedData.getKINDS(), marketorderno, marketorderrow, selectedData.getMATNR(), selectedData.getMAKTX(), selectedData.getMEINS(), selectedData.getMENGE(), upstreamFactory, username, idStr, recenum, selectedData.getInStorage(), selectedData.getMaterialType());
            presenter2.OutsourcingExceptionJS(req);

        }else {
            LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
            Toast.makeText(WXExceptionReceiveActivity.this,"未选中收货行",Toast.LENGTH_SHORT).show();
        }
    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver
    {
        //        private static final String TAG = "MycodeReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    marketorderno="";
                    marketorderrow="";
                    upstreamFactory="";
                    //tv.setText(str);
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(WXExceptionReceiveActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        String bm= null;
                        String decodestr = null;
                        try {
                            marketorderno=lableObject.getString("no");
                            String s1=".*[0-9]{1,}.*";
                            marketorderno=marketorderno.matches(s1)?marketorderno:"";
                            marketorderrow=lableObject.getString("line");
                            upstreamFactory=lableObject.getString("gc");
                            bm = lableObject.getString("code");
                            decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                            LoadingBar.dialog(WXExceptionReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom5).show();
                            presenterScan.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr,"2");
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(WXExceptionReceiveActivity.this, "解析二维码获取采购订单错误", Toast.LENGTH_LONG).show();
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXExceptionReceiveActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
}
