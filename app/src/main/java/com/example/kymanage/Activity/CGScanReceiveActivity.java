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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.CGScanReceiveAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRepBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.CGPage3.AdvanceRec103JSPresenter;
import com.example.kymanage.presenter.Presenters.CGPage3.GetPreRecMaterialCodeInfoJSPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CGScanReceiveActivity extends BaseActivity implements ScanBaseView<GetPreRecMaterialCodeInfoJSRep>, BaseView1<CodeMessageBean>, CGScanReceiveAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    //确认和取消按钮
    private ImageView scan;
    private ImageView record;
    //listview
    private ListView cgshlistview;
    private List<GetPreRecMaterialCodeInfoJSRepBean> datas;//表格数据
    //adapter
    private CGScanReceiveAdapter adapter;
    //采购103
    private AdvanceRec103JSPresenter presenter1;
    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;
    private long aid;
    //扫码查询接口
    private GetPreRecMaterialCodeInfoJSPresenter presenterScan;
    //username
    private String username;
    //震动
    private Vibrator vibrator;
    //当前收货的序号
    private int currentIndex=-1;

    @Override
    public int initLayoutId() {
        return R.layout.activity_cgscan_receive;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        record=findViewById(R.id.record);
        cgshlistview=findViewById(R.id.cgshlistview);


        //扫码
        presenterScan=new GetPreRecMaterialCodeInfoJSPresenter();
        presenterScan.setView(this);

        //收货
        presenter1=new AdvanceRec103JSPresenter();
        presenter1.setView(this);



    }

    @Override
    public void initData() {
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        datas=new ArrayList<GetPreRecMaterialCodeInfoJSRepBean>();
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(v -> {
            vibrator.vibrate(30);
            scan();
        });
        record.setOnClickListener(v -> {
            vibrator.vibrate(30);
            Intent intent = new Intent(CGScanReceiveActivity.this, CGRecordActivity.class);
            intent.putExtra("username", username);
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

    @Override
    public void onDataSuccessScan(GetPreRecMaterialCodeInfoJSRep data) {
        if(data.getCode()==1&&aid!=-1){
            data.getData().setAdvanceStorageId(aid);
            aid=-1;
            datas.add(data.getData());
            adapter=new CGScanReceiveAdapter(CGScanReceiveActivity.this, R.layout.cgscanreceiveitem,datas);
            adapter.setOnInnerItemOnClickListener(this);
            cgshlistview.setAdapter(adapter);
            cgshlistview.setOnItemClickListener(this);
        }else {
            DialogUtil.errorMessageDialog(CGScanReceiveActivity.this,data.getMessage());
        }



    }

    @Override
    public void onDataSuccess1(CodeMessageBean data) {
        LoadingBar.dialog(CGScanReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getCode()==1&&currentIndex!=-1){
            datas.remove(currentIndex);
            currentIndex=-1;
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }else {
            DialogUtil.errorMessageDialog(CGScanReceiveActivity.this,data.getMessage());
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(CGScanReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void itemClick(View v) {
        currentIndex = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.receive:
                vibrator.vibrate(30);
                System.out.println("内部receive>>"+currentIndex);
                receive(currentIndex);
                break;
            default:
                break;
        }
    }

    private void receive(int position){
        GetPreRecMaterialCodeInfoJSRepBean currBean = datas.get(position);
        long advanceStorageId = currBean.getAdvanceStorageId();
        View view = cgshlistview.getAdapter().getView(position, null, null);
        TextView tv = view.findViewById(R.id.dhsl);
        float receNum = Float.parseFloat("0" + tv.getText().toString());
        LoadingBar.dialog(CGScanReceiveActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
        presenter1.AdvanceRec103JS(advanceStorageId,getCurrentdate(),getCurrentdate(),username,receNum);
    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver
    {
        private static final String TAG = "MycodeReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (str.contains("{")) {
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        DialogUtil.errorMessageDialog(CGScanReceiveActivity.this, "二维码格式有误1");
                    }
                    if(lableObject!=null) {
                        try {
                            aid=lableObject.getLong("aid");
                            presenterScan.GetPreRecMaterialCodeInfoJS(aid);
                            scanString="";
                        } catch (Exception e) {
                            e.printStackTrace();
                            DialogUtil.errorMessageDialog(CGScanReceiveActivity.this, "二维码格式有误2");
                        }
                    }else {
                        Log.i("token","扫描结果为空");
                        DialogUtil.errorMessageDialog(CGScanReceiveActivity.this, "二维码格式有误3");
                    }
                }
            }
        }
    }
}
