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
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXBCPSHAdapter;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean3;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReqBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.Print2BaseView;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetDispatchListJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.Semi_FinishedProductReceivingLablePresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.Semi_FinishedProductReceivingPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPSHNActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>,WXBCPSHAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener, BaseView2<Semi_FinishedProductReceivingRep>, PrintBaseView<GetDispatchListJSRep>, Print2BaseView<Semi_FinishedProductReceivingLableRep> {

    //震动
    private Vibrator vibrator;

    //扫描
    private ImageView scan;//扫描图标
    private String scanString;//扫描到的字符串
    private String marketorderno;//外协图纸上的数据
    private String marketorderrow;//外协图纸上的数据
    private String upstreamFactory;//外协图纸上的数据
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetPurchaseOrderInfoJSPresenter presenterScan;//扫描获取采购订单信息
    private WXBCPSHAdapter adapter;//扫描获取数据适配器
    private List<GetPurchaseOrderInfoJSRep> scanDatas;//扫描返回数据
    private ListView listView1;

    //半成品收货
    private Semi_FinishedProductReceivingPresenter presenter2;


    //打印
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //表单打印工具
    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();
    private GetDispatchListJSPresenter presenterPrint;//派工单打印
    private List<Long> AdvanceStorageId;
    private Semi_FinishedProductReceivingLablePresenter presenterPrint2;//标签打印
    private long currAdvanceStorageId;//当前收货返回的id，随收货操作成功时更新

    //缩略菜单
    private ImageView menupoint;
    PopupMenu popup = null;
    //记录
    private ImageView record;

    //username
    private String username;

    //自定义请求码常量
    private static final int REQUEST_CODE = 1;

    //重复打印
    GetDispatchListJSRep againPrint=new GetDispatchListJSRep();
    Semi_FinishedProductReceivingLableRep againPrint2=new Semi_FinishedProductReceivingLableRep();
    boolean isAgain=false;//判断是否重复打印
    int printType=0;



    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpshn;
    }

    @Override
    public void initview() {
        //震动
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        //按钮
        scan=findViewById(R.id.scan);
        menupoint=findViewById(R.id.menupoint);
//        record=findViewById(R.id.record);
        listView1=findViewById(R.id.listview1);//采购订单列表

        //扫描获取采购订单信息
        presenterScan=new GetPurchaseOrderInfoJSPresenter();
        presenterScan.setView(this);

        //半成品收货
        presenter2=new Semi_FinishedProductReceivingPresenter();
        presenter2.setView(this);

        //打印派工单
        presenterPrint=new GetDispatchListJSPresenter();
        presenterPrint.setView(this);

        //打印标签
        presenterPrint2=new Semi_FinishedProductReceivingLablePresenter();
        presenterPrint2.setView(this);
    }

    @Override
    public void initData() {

        scanDatas=new ArrayList<GetPurchaseOrderInfoJSRep>();//扫描返回数据
        //username
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
//        System.out.println("获取到的username=="+username);

        //打印初始化
        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
        //打印接口请求数据
        AdvanceStorageId=new ArrayList<Long>();


    }

    //弹窗返回
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
                //收货返回的id用于打印派工单
                long receiveid=data.getLongExtra("AdvanceStorageId",-1);
                //是否收货
                boolean confirm=data.getBooleanExtra("isReceive",false);

                if(confirm){
                    scanDatas.clear();
                    if(receiveid!=-1){
                        AdvanceStorageId.add(receiveid);
                        currAdvanceStorageId=receiveid;
                    }
                    //收货完直接自动打印派工单
                    isAgain=false;
                    printType=0;
                    presenterPrint.GetDispatchListJS(AdvanceStorageId,username,getCurrentdate());
                }
                adapter.notifyDataSetChanged();



                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(v -> {
            vibrator.vibrate(30);
            scan();
        });
//        record.setOnClickListener(v -> {
//            vibrator.vibrate(30);
//            Intent intent = new Intent(WXBCPSHNActivity.this, WXBCPSHRecordActivity.class);
//            intent.putExtra("username",username);
//            startActivity(intent);
//        });
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
        getMenuInflater().inflate(R.menu.wxbcpmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                item -> {
                    switch (item.getItemId())
                    {
                        case R.id.print:
                            vibrator.vibrate(30);
                            isAgain=true;
                            if(printType==0){
                                onDataSuccessPrint(againPrint);
                            }else {
                                onDataSuccessPrint2(againPrint2);
                            }


                            break;
                        case R.id.record:
                            // 隐藏该对话框
                            vibrator.vibrate(30);
                            Intent intent = new Intent(WXBCPSHNActivity.this, WXBCPSHRecordActivity.class);
                            intent.putExtra("username",username);
                            startActivity(intent);
                            break;
                        default:
                            // 使用Toast显示用户单击的菜单项
                            Toast.makeText(WXBCPSHNActivity.this,
                                    "您单击了【" + item.getTitle() + "】菜单项"
                                    , Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        LoadingBar.dialog(WXBCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        DialogUtil.startAlarm(this);
        vibrator.vibrate(300);
        scanDatas=data.getData();
        adapter=new WXBCPSHAdapter(this, R.layout.wxbcpshitem,scanDatas);
        adapter.setOnInnerItemOnClickListener(this);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
        if(scanDatas.size()>1){
            DialogUtil.infoMessageDialog(WXBCPSHNActivity.this,"该图纸涉及到多个采购订单号/行，请注意收货路径！");
        }else if(scanDatas.size()==0){
            DialogUtil.errorMessageDialog(WXBCPSHNActivity.this,data.getMessage());
        }
    }

    @Override
    public void onDataSuccess2(Semi_FinishedProductReceivingRep data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            AdvanceStorageId.add(data.getAdvanceStorageId());
            currAdvanceStorageId=data.getAdvanceStorageId();
            scanDatas.clear();
            adapter.notifyDataSetChanged();
            //收货完直接自动打印标签
            isAgain=false;
            printType=1;
            presenterPrint2.Semi_FinishedProductReceivingLable(currAdvanceStorageId,username,getCurrentdate());
        }else {
            DialogUtil.errorMessageDialog(WXBCPSHNActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccessPrint(GetDispatchListJSRep data) {
        if(data.getCode()==1){
            againPrint=data;
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            AdvanceStorageId.clear();
            try {
                for (GetDispatchListJSRepBean2 datum : data.getData().getDispatchListDataArr()) {
                    datum.setUsername(username);
                    datum.setCreateDate(getCurrentdate());
                    mPrintUtil.printPGBill(datum,printHelper);
                    printHelper.printBlankLine(80);
                }

                for (GetDispatchListJSRepBean3 label : data.getData().getLableDataArr()) {
                    printHelper.printBlankLine(40);
                    Bitmap bm=cb.createImage5(label,tf);
                    printHelper.PrintBitmapAtCenter(bm,384,480);
                    printHelper.printBlankLine(80);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            if(!isAgain){
                DialogUtil.errorMessageDialog(WXBCPSHNActivity.this,data.getMessage());
            }

        }

    }

    @Override
    public void onDataSuccessPrint2(Semi_FinishedProductReceivingLableRep data) {
        againPrint2=data;
        if(data.getCode()==1){
            for (Semi_FinishedProductReceivingLableRep.Semi_FinishedProductReceivingLableRepBean datum : data.getData()) {
                Bitmap bm=cb.createImage11(datum,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(80);
            }
        }else {
            if(!isAgain){
                DialogUtil.errorMessageDialog(WXBCPSHNActivity.this,data.getMessage());
            }
        }

    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXBCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
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
                //实物收货弹窗选择生产订单
                //费用收货不弹窗直接收货
                receive(position);
                break;
            default:
                break;
        }
    }

    private void receive(int position){
        GetPurchaseOrderInfoJSRep selectListData = scanDatas.get(position);
        List<Semi_FinishedProductReceivingReqBean> productOrder = new ArrayList<Semi_FinishedProductReceivingReqBean>();
        //获取数量
        View itmeview=listView1.getAdapter().getView(position,null,null);
        EditText et=itmeview.findViewById(R.id.dhsl);
        String recenumstr=et.getText().toString();
        float num=Float.parseFloat(("0"+recenumstr));
        System.out.println(recenumstr+"=="+num);
        Semi_FinishedProductReceivingReq req=new Semi_FinishedProductReceivingReq(getCurrentdate(), getCurrentdate(), username, marketorderno, marketorderrow, upstreamFactory, num, selectListData.getInStorage(), selectListData.getMENGE(), selectListData.getEBELN(), selectListData.getEBELP(), selectListData.getMATNR(), selectListData.getMaterialType(), selectListData.getWERKS(), selectListData.getLGPRO(), selectListData.getTXZ01(), selectListData.getMEINS(), selectListData.getCGTXT(), selectListData.getKINDS(), selectListData.getAUFNR(), selectListData.getPMATN(), selectListData.getMCODE(),selectListData.getMAKTX(), productOrder);
        /**
         *
         * 半成品实物入库103、105 类型：20   //用matnr去选生产订单
         * 半成品费用入库103、105 类型：2    //不用选
         * 半成品费用入库103、105、101 类型：1   //用pmatn去选生产订单
         */
        if(selectListData.getKINDS().equals("20")||selectListData.getKINDS().equals("1")){
            Intent intent = new Intent(WXBCPSHNActivity.this,WXBCPSHDialogActivity.class);
            intent.putExtra("receiveReq", req);
            intent.putExtra("marketorderno", marketorderno);
            intent.putExtra("marketorderrow", marketorderrow);
            intent.putExtra("materialCode", selectListData.getMATNR());
            intent.putExtra("pmaterialCode", selectListData.getPMATN());
            intent.putExtra("kinds", selectListData.getKINDS());
            intent.putExtra("factoryNO", upstreamFactory);
            intent.putExtra("dhsl", num);
            startActivityForResult(intent,REQUEST_CODE);
        }else {
            presenter2.Semi_FinishedProductReceiving(req);
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
                        Toast.makeText(WXBCPSHNActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        String bm= null;
                        String decodestr = null;
                        try {
                            marketorderno=lableObject.getString("no");
                            marketorderrow=lableObject.getString("line");
                            upstreamFactory=lableObject.getString("gc");
                            bm = lableObject.getString("code");
                            decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                            if(upstreamFactory!=null&&!upstreamFactory.equals("")){
                                LoadingBar.dialog(WXBCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).show();
                                presenterScan.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr,"2");
                            }else {
                                DialogUtil.errorMessageDialog(WXBCPSHNActivity.this,"二维码中工厂字段为空，无法解析");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(WXBCPSHNActivity.this, "解析二维码获取采购订单错误", Toast.LENGTH_LONG).show();
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXBCPSHNActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXBCPSHNActivity.this);
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
