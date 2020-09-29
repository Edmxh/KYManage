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
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXCPSHAdapter;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRepBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRepBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetDispatchListJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.GetOutsourceFinProLableJSPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXCPSHNActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>,PrintBaseView<GetOutsourceFinProLableJSRep>, WXCPSHAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {


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
    private WXCPSHAdapter adapter;//扫描获取数据适配器
    private List<GetPurchaseOrderInfoJSRep> scanDatas;//扫描返回数据
    private ListView listView1;

    //成品收货
//    private Semi_FinishedProductReceivingPresenter presenter2;


    //打印
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //表单打印工具
    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();
    //print
    private GetOutsourceFinProLableJSPresenter presenterPrint;
    private  List<Integer> printList;


    //缩略菜单
    private ImageView menupoint;
    PopupMenu popup = null;

    //username
    private String username;

    //自定义请求码常量
    private static final int REQUEST_CODE = 1;



    @Override
    public int initLayoutId() {
        return R.layout.activity_wxcpshn;
    }

    @Override
    public void initview() {
        //震动
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        //按钮
        scan=findViewById(R.id.scan);
        menupoint=findViewById(R.id.menupoint);
        listView1=findViewById(R.id.listview1);//采购订单列表

        //扫描获取采购订单信息
        presenterScan=new GetPurchaseOrderInfoJSPresenter();
        presenterScan.setView(this);

        //打印标签
        presenterPrint=new GetOutsourceFinProLableJSPresenter();
        presenterPrint.setView(this);
    }

    @Override
    public void initData() {

        scanDatas=new ArrayList<GetPurchaseOrderInfoJSRep>();//扫描返回数据
        //username
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        //打印初始化
        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
        printList=new ArrayList<Integer>();


    }

    //弹窗返回
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
                //是否收货
                boolean confirm=data.getBooleanExtra("isReceive",false);

                if(confirm){
                    scanDatas.clear();
                    //收货返回的数据用于打印成品标签
//                    OutsourceFinishedProductReceivingJSRepBean bqReq = (OutsourceFinishedProductReceivingJSRepBean)data.getSerializableExtra("printReq");
//                    GetOutsourceFinProLableJSReqBean printBean=new GetOutsourceFinProLableJSReqBean(bqReq.getStorageId(),bqReq.getOrderType(),bqReq.getAdvanceStorageId(),bqReq.getFactory());
                    ArrayList<Integer> printReqs = data.getIntegerArrayListExtra("printReqs");
                    for (Integer printReq : printReqs) {
                        printList.add(printReq);
                    }
                    //收货完成直接自动打印标签
                    presenterPrint.GetOutsourceFinProLableJS(printList);
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
        getMenuInflater().inflate(R.menu.wxcpmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                item -> {
                    switch (item.getItemId())
                    {
                        case R.id.record:
                            // 隐藏该对话框
                            Intent intent = new Intent(WXCPSHNActivity.this, WXCPSHRecordActivity.class);
                            intent.putExtra("username",username);
                            startActivity(intent);
                            break;
                        default:
                            // 使用Toast显示用户单击的菜单项
                            Toast.makeText(WXCPSHNActivity.this,
                                    "您单击了【" + item.getTitle() + "】菜单项"
                                    , Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        LoadingBar.dialog(WXCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        scanDatas=data.getData();
        adapter=new WXCPSHAdapter(this, R.layout.wxbcpshitem,scanDatas);
        adapter.setOnInnerItemOnClickListener(this);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(this);
        if(scanDatas.size()>1){
            DialogUtil.infoMessageDialog(WXCPSHNActivity.this,"该图纸涉及到多个采购订单号/行，请注意收货路径！");
        }else if(scanDatas.size()==0){
            DialogUtil.errorMessageDialog(WXCPSHNActivity.this,data.getMessage());
        }
    }

    @Override
    public void onDataSuccessPrint(GetOutsourceFinProLableJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            printList.clear();
            List<GetOutsourceFinProLableJSRepBean> beans = data.getData();
            for (GetOutsourceFinProLableJSRepBean bean : beans) {
                Bitmap bm=cb.createImage7(bean,tf);
                printHelper.PrintBitmapAtCenter(bm,384,530);
                printHelper.printBlankLine(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
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
                receive(position);
                break;
            default:
                break;
        }
    }

    private void receive(int position){
        /**
         * 成品实物入库：103、105 类型：10     //用matnr选本事业部，本事业部获取物料编码去选上游事业部生产订单
         * 成品实物入库：103、105、261、101 类型：20   //用matnr选本事业部，本事业部获取物料编码去选上游事业部生产订单
         * 成品费用入库：103、105、101 类型：3  //用pmatn选上游生产订单
         * 成品费用入库：103、105、101、261、101 类型：4   //用pmatn选本事业部，本事业部获取物料编码去选上游事业部生产订单
         */
        GetPurchaseOrderInfoJSRep selectListData = scanDatas.get(position);
        Intent intent = new Intent(WXCPSHNActivity.this,WXCPSHDialogActivity.class);
        //获取数量
        View itmeview=listView1.getAdapter().getView(position,null,null);
        EditText et=itmeview.findViewById(R.id.dhsl);
        String recenumstr=et.getText().toString();
        float num=Float.parseFloat(("0"+recenumstr));
        intent.putExtra("marketorderno", marketorderno);
        intent.putExtra("marketorderrow", marketorderrow);
        intent.putExtra("materialCode", selectListData.getMATNR());
        intent.putExtra("factoryNO", upstreamFactory);
        intent.putExtra("dhsl", num);
        intent.putExtra("kinds", selectListData.getKINDS());
        intent.putExtra("selectListData", selectListData);
        startActivityForResult(intent,REQUEST_CODE);
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
                        Toast.makeText(WXCPSHNActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
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
                            LoadingBar.dialog(WXCPSHNActivity.this).setFactoryFromResource(R.layout.layout_custom5).show();
                            presenterScan.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr,"1");
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(WXCPSHNActivity.this, "解析二维码获取采购订单错误", Toast.LENGTH_LONG).show();
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXCPSHNActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
        registerReceiver(receiver, intentFilter);

    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXCPSHNActivity.this);
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
