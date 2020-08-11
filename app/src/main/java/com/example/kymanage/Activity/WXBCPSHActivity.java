package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPSHAdapter;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean3;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetDispatchListJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.Semi_FinishedProductReceivingPresenter;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPSHActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>, PrintBaseView<GetDispatchListJSRep>, BaseView1<PreMaterialProductOrderReps>, BaseView2<Semi_FinishedProductReceivingRep>, AdapterView.OnItemClickListener {

    //震动
    private Vibrator vibrator;

    //表格
    private ListView listview1;
    //scan
//扫描相关
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetPurchaseOrderInfoJSPresenter presenter1;
    private String scanString;
    private WXBCPSHAdapter adapter1;
    private List<GetPurchaseOrderInfoJSRep> data1;
    //扫描要存的数据
    private String marketorderno;
    private String marketorderrow;
    private String upstreamFactory;
    //print
//    private ImageView print;
    private GetDispatchListJSPresenter presenter2;
    private List<Long> AdvanceStorageId;
    //record
    //
    private String username;

    //print
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE = 1;

    private ImageView menupoint;
    PopupMenu popup = null;

    private mPrintUtil mPrintUtil=new mPrintUtil();

    //采购订单号行筛选
    private View layout1;
    private Spinner spinner2;
    private ArrayAdapter<String> adapter2;
    private List<String> cgddh_hang=new ArrayList<String>();

    private TextView wlbm;
    private TextView wlms;
    private TextView kcdd;
    private TextView xqsl;
    private TextView rksl;
    private EditText dhsl;
    private GetPurchaseOrderInfoJSRep selectedRep;

    //获取数据
    private CGSHReceiveDetailPresenter presenter3;
    private List<PreMaterialProductOrderRep> productOrderList=new ArrayList<PreMaterialProductOrderRep>();
    //收货
    private Semi_FinishedProductReceivingPresenter presenter4;
    private Button receive;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpsh;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);


        receive=findViewById(R.id.receive);

        layout1=findViewById(R.id.layout1);
        layout1.setVisibility(View.INVISIBLE);
        spinner2=findViewById(R.id.spinner2);


        wlbm=findViewById(R.id.wlbm);
        wlms=findViewById(R.id.wlms);
        kcdd=findViewById(R.id.kcdd);
        xqsl=findViewById(R.id.xqsl);
        rksl=findViewById(R.id.rksl);
        dhsl=findViewById(R.id.dhsl);

        menupoint=findViewById(R.id.menupoint);
        //表格
        listview1=findViewById(R.id.listview1);

        presenter1=new GetPurchaseOrderInfoJSPresenter();
        presenter1.setView(this);

        presenter2=new GetDispatchListJSPresenter();
        presenter2.setView(this);

        presenter3=new CGSHReceiveDetailPresenter();
        presenter3.setView(this);

        presenter4=new Semi_FinishedProductReceivingPresenter();
        presenter4.setView(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
//                操作
                boolean isReceive = data.getBooleanExtra("isReceive", false);
                long pastId = data.getLongExtra("AdvanceStorageId", 0L);
                int pastIndex = data.getIntExtra("index", -1);
                if(isReceive){
                    try {
                        AdvanceStorageId.add(pastId);

                        data1.remove(pastIndex);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    adapter1.notifyDataSetChanged();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();

        selectedRep=new GetPurchaseOrderInfoJSRep();

        AdvanceStorageId=new ArrayList<Long>();

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
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
                //pliu
//                scanString="{\"no\":\"0010000209\",\"line\":\"10\",\"code\":\"TEo2MDI1MDA5Mzc4\"}";
                //kh
//                scanString="{\"no\":\"10000208\",\"line\":\"26\",\"code\":\"TEoyMDE1MDAwNTk0LUEwMQ==\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(WXBCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
////                    System.out.println(lableObject.getString("bm"));
//                    String marketorderno=lableObject.getString("no");
//                    String marketorderrow=lableObject.getString("line");
//                    String bm=lableObject.getString("code");
////                        sl=lableObject.getFloat("sl");
////                        bm = lableObject.getString("bm");
////                        area = lableObject.getString("cd");
////                        factory=lableObject.getString("gc");
////                        labelSquNum=lableObject.getString("num");
////                        cs=lableObject.getInteger("cs");
//
//                    //判断是否重复扫码
////                        boolean repeat=false;
////                        for (GetPurWayMaterialDataRep data : datas) {
////                            if(labelSquNum.equals(data.getData().getLabelSeqNum())){
////                                repeat=true;
////                            }
////                        }
////                        if(repeat){
////                            System.out.println("请勿重复扫码");
////                            Toast.makeText(WXBCPSHActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
////
////                        }else {
////
//                    if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
//                        String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                        presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
//                    }
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(WXBCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);
            }
        });

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<Semi_FinishedProductReceivingReqBean> productOrderReqs=new ArrayList<Semi_FinishedProductReceivingReqBean>();
                float allnum=0;
                for (int i = 0; i < productOrderList.size(); i++) {
                    PreMaterialProductOrderRep rep = productOrderList.get(i);
                    View listItem=listview1.getAdapter().getView(i,null,null);
                    TextView tv1=listItem.findViewById(R.id.scddh);
                    EditText et1=listItem.findViewById(R.id.fpsl);
                    String orderNo=tv1.getText().toString();
                    float issueNum=0;
                    issueNum=Float.parseFloat(("0"+et1.getText().toString()));
                    if(issueNum>0){
                        allnum+=issueNum;
                        Semi_FinishedProductReceivingReqBean bean=new Semi_FinishedProductReceivingReqBean(rep.getDemandNum(), rep.getKDAUF(), rep.getKDPOS(), rep.getMAKTX(), rep.getMATNR(), rep.getRSART(), rep.getRSNUM(), rep.getRSPOS(), rep.getIssuedNum(), rep.getProductOrderNO(), rep.getProOrderDesc(),rep.getProOrderMaterialCode(), rep.getProOrderMaterialDesc(), rep.getProOrderMaterialUnit(), rep.getFactory(), rep.getStorage(),rep.getMCODE(),issueNum);
                        productOrderReqs.add(bean);
                    }
                }
                float recNum=Float.parseFloat(("0"+dhsl.getText().toString()));
                if(recNum>0&&recNum>=allnum){
                    Semi_FinishedProductReceivingReq req=new Semi_FinishedProductReceivingReq(selectedRep.getMarketorderno(), selectedRep.getMarketorderrow(), selectedRep.getUpstreamFactory(), recNum,selectedRep.getInStorage(),selectedRep.getMENGE(),selectedRep.getEBELN(), selectedRep.getEBELP(), selectedRep.getMATNR(), selectedRep.getMaterialType(), selectedRep.getWERKS(), selectedRep.getLGPRO(), selectedRep.getTXZ01(), selectedRep.getMEINS(), selectedRep.getCGTXT(), productOrderReqs);
                    presenter4.Semi_FinishedProductReceiving(getCurrentdate(),getCurrentdate(),username,req);
                }else {
                    Toast.makeText(WXBCPSHActivity.this, "输入数量错误", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.wxbcpmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
//                            case R.id.exit:
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                            case R.id.record:
                                // 隐藏该对话框
                                Intent intent = new Intent(WXBCPSHActivity.this, WXBCPSHRecordActivity.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                presenter2.GetDispatchListJS(AdvanceStorageId,username,getCurrentdate());
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(WXBCPSHActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetPurchaseOrderInfoJSReps data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        try {
            List<GetPurchaseOrderInfoJSRep> currentDatas = data.getData();
            for (GetPurchaseOrderInfoJSRep data2 : currentDatas) {
                data2.setMarketorderno(marketorderno);
                data2.setMarketorderrow(marketorderrow);
                data2.setUpstreamFactory(upstreamFactory);
            }
            data1.clear();
            cgddh_hang.clear();
            for (GetPurchaseOrderInfoJSRep currentData : currentDatas) {
                data1.add(currentData);
            }

            for (GetPurchaseOrderInfoJSRep rep : data1) {
                String str=rep.getEBELN()+"/"+rep.getEBELP();
                cgddh_hang.add(str);
            }
            layout1.setVisibility(View.VISIBLE);
            adapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.defined_spinner_item, cgddh_hang);
            //设置下拉列表的风格
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //将adapter 添加到spinner中
            spinner2.setAdapter(adapter2);
            spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    selectedRep = data1.get(arg2);
                    wlbm.setText(selectedRep.getMATNR());
                    wlms.setText(selectedRep.getTXZ01());
                    kcdd.setText(selectedRep.getLGPRO());

                    String num1str=""+selectedRep.getMENGE();
                    xqsl.setText(num1str);
                    String num2str=""+selectedRep.getInStorage();
                    rksl.setText(num2str);
                    String num3str=""+selectedRep.getWESBS();
                    dhsl.setText(num3str);

                    presenter3.CGSHReceiveDetail(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getWERKS(),selectedRep.getWESBS());

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
//            adapter1=new WXBCPSHAdapter(this, R.layout.wxbcpshitem, data1);
//            adapter1.setOnInnerItemOnClickListener(this);
//            listview1.setAdapter(adapter1);
//            listview1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccessPrint(GetDispatchListJSRep data) {
        try {
            for (GetDispatchListJSRepBean2 datum : data.getData().getDispatchListDataArr()) {
                datum.setUsername(username);
                datum.setCreateDate(getCurrentdate());
                mPrintUtil.printPGBill(datum,printHelper);
                printHelper.printBlankLine(80);
            }

            for (GetDispatchListJSRepBean3 label : data.getData().getLableDataArr()) {
                Bitmap bm=cb.createImage5(label,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        productOrderList = data.getData();
        adapter1=new WXBCPSHAdapter(WXBCPSHActivity.this, R.layout.wxbcpshitem, productOrderList);
        listview1.setAdapter(adapter1);
    }

    @Override
    public void onDataSuccess2(Semi_FinishedProductReceivingRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if(data.getCode()==1){
            layout1.setVisibility(View.INVISIBLE);
            productOrderList.clear();
            adapter1.notifyDataSetChanged();
            AdvanceStorageId.add(data.getStorageId());
        }
    }

    @Override
    public void onFailed(String msg) {
        System.out.println(msg);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("整体item----->", i + "");
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
                        Toast.makeText(WXBCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
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
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXBCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXBCPSHActivity.this);
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
