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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter1;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter2;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteReqBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean1;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean2;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage2.PreMaterialProductOrderJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.InsertFinProStorageRecordPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Dialog1.GetOutStorageMaterialOrderJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Record.GetFinProStorageRecordNotePresenter;

import java.util.ArrayList;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPJGRKActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView1<GetOutStorageMaterialOrderJSRep>, BaseView2<InsertFinProStorageRecordRep>, BaseView3<GetFinProStorageRecordNoteRep>, BaseView4<PreMaterialProductOrderReps> {
    //震动
    private Vibrator vibrator;
    private ImageView scan;
    //scan
//扫描相关
    private String m_Broadcastname = "com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private GetMaterialMasterDataJSPresenter presenter1;
    private List<GetPurchaseOrderInfoJSRep> data1;
    private String scanString;
    private String marketorderno;
    private String marketorderrow;
    private float num;
    private String factory;
    //username
    private String username;
    //101
    private List<InsertFinProStorageRecordReq> reqs;
    private InsertFinProStorageRecordPresenter presenter2;


    //print
    private GetFinProStorageRecordNotePresenter presenter3;
    private List<GetFinProStorageRecordNoteReqBean> idlist;
    //打印类
    private PrintHelper printHelper = null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE_1 = 1;
    private static final int REQUEST_CODE_2 = 2;



    private ImageView menupoint;
    PopupMenu popup = null;

    //采购订单号行筛选
    private View layout1;
    private GetMaterialMasterDataInfo material;
    private TextView wlbm;
    private TextView wlms;
    private TextView gc;
    private TextView dw;
    private EditText dhsl;
    private View ll_scdd;

    //收货
    private Button receive;
    //
    private View layout2;
    //查看本事业部生产订单与上游事业部生产订单
    private RadioGroup radiogroup1;
    //ben
    private RadioButton rb1;
    private GetOutStorageMaterialOrderJSPresenter presenter4;
    private List<GetOutStorageMaterialOrderJSRepBean> productOrderList1;
    private WXBCPJGRKAdapter1 adapter1;
    private ListView listview1;

    //shangyou
    private RadioButton rb2;
    private PreMaterialProductOrderJSPresenter presenter5;
    private List<PreMaterialProductOrderRep> productOrderList2;
    private WXBCPJGRKAdapter2 adapter2;
    private ListView listview2;

    //全局变量


    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpjgrk;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);

        receive=findViewById(R.id.receive);

        radiogroup1=findViewById(R.id.radiogroup1);
        rb1=findViewById(R.id.ben);
        rb2=findViewById(R.id.shangyou);

        layout1=findViewById(R.id.layout1);
        layout1.setVisibility(View.INVISIBLE);
        layout2=findViewById(R.id.layout2);
        layout2.setVisibility(View.INVISIBLE);
        ll_scdd=findViewById(R.id.ll_scdd);
        ll_scdd.setVisibility(View.INVISIBLE);



        wlbm=findViewById(R.id.wlbm);
        wlms=findViewById(R.id.wlms);
        gc=findViewById(R.id.gc);
        dw=findViewById(R.id.dw);
        dhsl=findViewById(R.id.dhsl);

//        print=findViewById(R.id.print);
//        record=findViewById(R.id.record);
        menupoint=findViewById(R.id.menupoint);
        //表格
        listview1=findViewById(R.id.listview1);
        listview2=findViewById(R.id.listview2);

        //获取采购订单
        presenter1=new GetMaterialMasterDataJSPresenter();
        presenter1.setView(this);

        //101入库
        presenter2 = new InsertFinProStorageRecordPresenter();
        presenter2.setView(this);
        //标签打印
        presenter3 = new GetFinProStorageRecordNotePresenter();
        presenter3.setView(this);

        //获取本事业部生产订单
        presenter4=new GetOutStorageMaterialOrderJSPresenter();
        presenter4.setView(this);

        //获取上游事业部生产订单
        presenter5=new PreMaterialProductOrderJSPresenter();
        presenter5.setView(this);
    }

    @Override
    public void initData() {
        //物料
        material=new GetMaterialMasterDataInfo();
        //扫描请求接口返回
        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();
        //本事业部生产订单接口返回
        productOrderList1=new ArrayList<GetOutStorageMaterialOrderJSRepBean>();
        //上游事业部生产订单接口返回
        productOrderList2=new ArrayList<PreMaterialProductOrderRep>();

        reqs = new ArrayList<InsertFinProStorageRecordReq>();
        idlist = new ArrayList<GetFinProStorageRecordNoteReqBean>();



        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        cb = new CreateBitmap();
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
                Thread scanThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        scan();
                    }
                });
                scanThread.start();
                try {
                    Log.i("token", "scanThread.join();");
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);
            }
        });

        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                String output = choise.getText().toString();
                if(output.equals("本")){
//                    System.out.println("选择了本事业部生产订单");
                    switchContent1();
                }else {
                    switchContent2();
                }
//                Toast.makeText(WXCPSHActivity.this, "你选择了：" + output, Toast.LENGTH_SHORT).show();
            }
        });

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
//                System.out.println("factory=="+factory);
                if((listview1.getVisibility()==View.GONE&&listview2.getVisibility()==View.VISIBLE)||factory.equals("2090")){
                    receive();
                }else {
                    Toast.makeText(WXBCPJGRKActivity.this, "请确认上游订单", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void receive(){
        List<InsertFinProStorageRecordReqBean2> ldata = new ArrayList<InsertFinProStorageRecordReqBean2>();
        List<InsertFinProStorageRecordReqBean1> sdata = new ArrayList<InsertFinProStorageRecordReqBean1>();
        for (int i = 0; i < productOrderList1.size(); i++) {
            GetOutStorageMaterialOrderJSRepBean currBean1 = productOrderList1.get(i);
            if(currBean1.isChosen()){
                InsertFinProStorageRecordReqBean2 bean2=new InsertFinProStorageRecordReqBean2(currBean1.getMATNR(), currBean1.getAUFNR(),"","", currBean1.getINQTY(), marketorderno, marketorderrow, currBean1.getMEINS(), currBean1.getMCODE(), currBean1.getMAKTX());
                ldata.add(bean2);
            }
        }

        for (int i = 0; i < productOrderList2.size(); i++) {
            PreMaterialProductOrderRep currBean2 = productOrderList2.get(i);
            if(currBean2.isChosen()){
                InsertFinProStorageRecordReqBean1 bean1=new InsertFinProStorageRecordReqBean1(currBean2.getFactory(), currBean2.getStorage(), currBean2.getKDAUF(), currBean2.getKDPOS(), currBean2.getProductOrderNO(), currBean2.getProOrderDesc(), currBean2.getProOrderMaterialCode(), currBean2.getProOrderMaterialDesc(), currBean2.getProOrderMaterialUnit(), currBean2.getDemandNum(), currBean2.getDispatchNum(), currBean2.getCurrentNum(), currBean2.getRSNUM(), currBean2.getRSPOS(), currBean2.getMCODE());
                sdata.add(bean1);
            }
        }
        String allnumStr=dhsl.getText().toString();
        float allnum = Float.parseFloat("0"+allnumStr);
        InsertFinProStorageRecordReq req=new InsertFinProStorageRecordReq(material.getMATNR(), material.getMAKTX(), material.getMaterialType(), material.getWERKS(), "2906", allnum,0, material.getMEINS(), marketorderno, marketorderrow, username, ldata, sdata);
        presenter2.InsertFinProStorageRecord(req);
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.wxmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.exit:
                                // 隐藏该对话框
                                popup.dismiss();
                                break;
                            case R.id.record:
                                // 隐藏该对话框
                                Intent intent = new Intent(WXBCPJGRKActivity.this, WXSHJLActivity.class);
                                intent.putExtra("username", username);
                                startActivity(intent);
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                presenter3.GetFinProStorageRecordNote(idlist);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(WXBCPJGRKActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
//        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        if(data.getCode()==1){
            //扫码成功显示
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);
            ll_scdd.setVisibility(View.VISIBLE);
            if(factory.equals("2090")){
                rb2.setVisibility(View.INVISIBLE);
            }else {
                rb2.setVisibility(View.VISIBLE);
            }
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
            material = data.getMaterial();
            material.setMarketorderno(marketorderno);
            material.setMarketorderrow(marketorderrow);
            material.setNum(num);

            wlbm.setText(material.getMATNR());
            wlms.setText(material.getMAKTX());
            gc.setText(material.getWERKS());
            dw.setText(material.getMEINS());
            String num3str=""+material.getNum();
            dhsl.setText(num3str);
            //presenter3.CGSHReceiveDetail(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getWERKS(),selectedRep.getWESBS());
            productOrderList1.clear();
            productOrderList2.clear();
            presenter4.GetOutStorageMaterialOrderJS(material.getMarketorderrow(),material.getMATNR(),material.getMarketorderno(),material.getWERKS(),material.getNum());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(InsertFinProStorageRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            GetFinProStorageRecordNoteReqBean idreq = new GetFinProStorageRecordNoteReqBean((data.getData()));
            idlist.add(idreq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        layout1.setVisibility(View.INVISIBLE);
        layout2.setVisibility(View.INVISIBLE);
        ll_scdd.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onDataSuccess3(GetFinProStorageRecordNoteRep data) {
        List<GetFinProStorageRecordNoteRepBean> labels = data.getData();
        if (labels != null) {
            for (GetFinProStorageRecordNoteRepBean label : labels) {
                Bitmap bm = cb.createImage6(label, tf);
                printHelper.PrintBitmapAtCenter(bm, 384, 480);
                printHelper.printBlankLine(81);
            }
            System.out.println("打印标签的数量为" + data.getData().size());
//            Toast.makeText(WXBCPJGRKActivity.this, "打印标签的数量为" + labels.size(), Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("未打印标签");
        }
        idlist.clear();
        Toast.makeText(WXBCPJGRKActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSuccess1(GetOutStorageMaterialOrderJSRep data) {
        productOrderList1 = data.getData();
        adapter1=new WXBCPJGRKAdapter1(WXBCPJGRKActivity.this, R.layout.wxcpshitem1, productOrderList1);
        listview1.setAdapter(adapter1);
        radiogroup1.check(R.id.ben);
    }

    @Override
    public void onDataSuccess4(PreMaterialProductOrderReps data) {
        productOrderList2 = data.getData();
        adapter2=new WXBCPJGRKAdapter2(WXBCPJGRKActivity.this, R.layout.wxbcprkitem2, productOrderList2);
        listview2.setAdapter(adapter2);
    }

    @Override
    public void onFailed(String msg) {

    }

    public void switchContent1() {
        listview1.setVisibility(View.VISIBLE);
        listview2.setVisibility(View.GONE);
    }

    public void switchContent2() {
        listview1.setVisibility(View.GONE);
        listview2.setVisibility(View.VISIBLE);
        List<PreMaterialProductOrderJSReqBean> materialCodeArr=new ArrayList<PreMaterialProductOrderJSReqBean>();
        for (int i = 0; i < productOrderList1.size(); i++) {
            String code=productOrderList1.get(i).getMATNR();

            View itmeview=listview1.getAdapter().getView(i,null,null);
            EditText et=itmeview.findViewById(R.id.fpsl);
            String recenumstr=et.getText().toString();
            float num0=Float.parseFloat(("0"+recenumstr));
//            float num0=productOrderList1.get(i).getCurrentNum();
            //分配数量为0直接跳过
            if(num0!=0){
                boolean dup=false;
                int ind=0;
                for (int j = 0; j < materialCodeArr.size(); j++) {
                    if(materialCodeArr.get(j).getMaterialCode().equals(code)){
                        ind=j;
                        dup=true;
                        break;
                    }
                }
                //物料未重复，则传参添加；物料重复，则只增加数量
                if(dup==false){
                    PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(code,num0);
                    materialCodeArr.add(bean);
                }else {
                    float num00=materialCodeArr.get(ind).getMatnrCurrentNum()+num0;
                    materialCodeArr.get(ind).setMatnrCurrentNum(num00);
                }
            }

        }
        presenter5.PreMaterialProductOrderJS(material.getMarketorderno(),material.getMarketorderrow(),materialCodeArr,material.getWERKS());
    }

    //扫描操作
    public void scan() {
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



    //接收类
    public class MyCodeReceiver extends BroadcastReceiver {
        private static final String TAG = "MycodeReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(WXBCPJGRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {

                        String bm= null;
                        String decodestr = null;
                        try {
                            marketorderno=lableObject.getString("no");
                            marketorderrow=lableObject.getString("line");
                            bm = lableObject.getString("code");
                            factory=lableObject.getString("gc");
                            String numstr=lableObject.getString("sl");
                            num=Float.parseFloat(numstr);
                            decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//
                        if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
                            presenter1.GetMaterialMasterDataJS(decodestr,factory);
                        }
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXBCPJGRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //初始化
    public void initPrinter() {
        printHelper = new PrintHelper();
        printHelper.Open(WXBCPJGRKActivity.this);
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
