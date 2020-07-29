package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.util.SparseBooleanArray;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter1;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter2;
import com.example.kymanage.Adapter.WXBCPSHAdapter;
import com.example.kymanage.Adapter.WXCPSHAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.General.SwitchBean;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRepBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRepBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean1;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean2;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean3;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.Fragment.SelfTabFragment;
import com.example.kymanage.Fragment.UpStreamFragment;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.GetPurchaseOrderInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.GetOutsourceFinProLableJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.OutsourceFinishedProductReceivingJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.PreMaterialProductOrderJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Dialog1.GetOutStorageMaterialOrderJSPresenter;
import com.example.kymanage.utils.Base64Tool;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXCPSHActivity extends BaseActivity implements ScanBaseView<GetPurchaseOrderInfoJSReps>, BaseView1<GetOutStorageMaterialOrderJSRep>, BaseView2<OutsourceFinishedProductReceivingJSRep>, BaseView3<GetOutsourceFinProLableJSRep>, BaseView4<PreMaterialProductOrderReps>, WXCPSHAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    //震动
    private Vibrator vibrator;
    private ImageView scan;
//    private ImageView print;
//    private ImageView record;
    //表格
    private ListView listview1;
    private GetOutStorageMaterialOrderJSPresenter presenter4;
    private WXBCPJGRKAdapter1 adapter1;
    private ListView listview2;
    private WXBCPJGRKAdapter2 adapter2;
    //scan
//扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();

    private String scanString;
    private List<GetPurchaseOrderInfoJSRep> data1;
    //扫描要存的数据
    private String marketorderno;
    private String marketorderrow;
    private String factory;
    //
    private String username;
    //收货
    private OutsourceFinishedProductReceivingJSPresenter presenter2;
    private List<OutsourceFinishedProductReceivingJSReqBean3> beans3;

    //选择上游生产订单物料编码
    private List<String> materialList;

    //print
    private GetOutsourceFinProLableJSPresenter presenter3;
    private  List<GetOutsourceFinProLableJSReqBean> printList;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    //成品收货的索引
    private int receiveIndex=-1;

    //扫码获取采购订单信息
    private GetPurchaseOrderInfoJSPresenter presenter1;
    private List<GetOutStorageMaterialOrderJSRepBean> productOrderList1;


    /**
     * 自定义请求码常量
     */
    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE_1 = 1;
    private static final int REQUEST_CODE_2 = 2;

    private ImageView menupoint;
    PopupMenu popup = null;

    //采购订单号行筛选
    private PreMaterialProductOrderJSPresenter presenter5;
    private List<PreMaterialProductOrderRep> productOrderList2;
    private View layout1;
    private Spinner spinner2;
    private ArrayAdapter<String> adapter0;
    private List<String> cgddh_hang=new ArrayList<String>();

    private TextView wlbm;
    private TextView wlms;
    private TextView kcdd;
    private TextView xqsl;
    private TextView rksl;
    private EditText dhsl;
    private GetPurchaseOrderInfoJSRep selectedRep;

    private View ll_scdd;

    //收货
    private Button receive;
    //查看本事业部生产订单与上游事业部生产订单
    private RadioGroup radiogroup1;
    private RadioButton rb1;
    private RadioButton rb2;


    @Override
    public int initLayoutId() {
        return R.layout.activity_wxcpsh;
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
        ll_scdd=findViewById(R.id.ll_scdd);
        ll_scdd.setVisibility(View.INVISIBLE);

        spinner2=findViewById(R.id.spinner2);


        wlbm=findViewById(R.id.wlbm);
        wlms=findViewById(R.id.wlms);
        kcdd=findViewById(R.id.kcdd);
        xqsl=findViewById(R.id.xqsl);
        rksl=findViewById(R.id.rksl);
        dhsl=findViewById(R.id.dhsl);

//        print=findViewById(R.id.print);
//        record=findViewById(R.id.record);
        menupoint=findViewById(R.id.menupoint);
        //表格
        listview1=findViewById(R.id.listview1);
        listview2=findViewById(R.id.listview2);

        //获取采购订单
        presenter1=new GetPurchaseOrderInfoJSPresenter();
        presenter1.setView(this);
        //成品收货
        presenter2=new OutsourceFinishedProductReceivingJSPresenter();
        presenter2.setView(this);
        //打印标签
        presenter3=new GetOutsourceFinProLableJSPresenter();
        presenter3.setView(this);

        //获取本事业部生产订单
        presenter4=new GetOutStorageMaterialOrderJSPresenter();
        presenter4.setView(this);

        //获取上游事业部生产订单
        presenter5=new PreMaterialProductOrderJSPresenter();
        presenter5.setView(this);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE_1: //返回的请求码
//                操作
                boolean confirm = data.getBooleanExtra("confirm", false);
                int index=data.getIntExtra("index",0);
                float sl =data.getFloatExtra("allNum",0);
                OutsourceFinishedProductReceivingJSReqBean2 inProduct  = (OutsourceFinishedProductReceivingJSReqBean2) data.getSerializableExtra("inProduct");
                if(confirm){
                    beans3.get(index).setInProduct(inProduct);
                    EditText et=listview1.getChildAt(index - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
                    et.setText(""+sl);
                    if(inProduct.getPMATNR()!=null){
                        materialList.set(index,inProduct.getPMATNR());
                    }
                }
                break;
            case REQUEST_CODE_2: //返回的请求码
//                操作
                boolean confirm2 = data.getBooleanExtra("confirm", false);
                int index2=data.getIntExtra("index",0);
                List<OutsourceFinishedProductReceivingJSReqBean1> outProduct  = (List<OutsourceFinishedProductReceivingJSReqBean1>) data.getSerializableExtra("outProduct");
                if(confirm2){
                    beans3.get(index2).setOutProduct(outProduct);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initData() {
        productOrderList1=new ArrayList<GetOutStorageMaterialOrderJSRepBean>();
        productOrderList2=new ArrayList<PreMaterialProductOrderRep>();
        selectedRep=new GetPurchaseOrderInfoJSRep();
        printList=new ArrayList<GetOutsourceFinProLableJSReqBean>();
        materialList=new ArrayList<String>();
        beans3=new ArrayList<OutsourceFinishedProductReceivingJSReqBean3>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();

        cb=new CreateBitmap();
        //初始化打印类
//        initPrinter();

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
//                beans3.clear();
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

//                scanString="{ \"no\": \"10000316\", \"line\": \"35\", \"code\": \"TEo1NTQwMDE4NDI2\", \"gc\": \"2010\", \"sl\": \"10\" }";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(WXCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//
//                    String bm= null;
//                    String decodestr = null;
//                    try {
//                        marketorderno=lableObject.getString("no");
//                        marketorderrow=lableObject.getString("line");
//                        bm = lableObject.getString("code");
//                        factory=lableObject.getString("gc");
//                        decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
////
//                    if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
//                        presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(WXCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

            }
        });
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
                                Intent intent = new Intent(WXCPSHActivity.this, WXCPSHRecordActivity.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                presenter3.GetOutsourceFinProLableJS(username,getCurrentdate2(),printList);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(WXCPSHActivity.this,
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
//        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        if(data.getCode()==1){
            //扫码成功显示
            layout1.setVisibility(View.VISIBLE);
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
            List<GetPurchaseOrderInfoJSRep> currentDatas = data.getData();
            for (GetPurchaseOrderInfoJSRep data2 : currentDatas) {
                data2.setMarketorderno(marketorderno);
                data2.setMarketorderrow(marketorderrow);

                OutsourceFinishedProductReceivingJSReqBean3 bean3=new OutsourceFinishedProductReceivingJSReqBean3( data2.getWERKS(), data2.getLGPRO(), data2.getTXZ01(), data2.getMATNR(), data2.getMaterialType(), data2.getEBELN(), data2.getEBELP(), data2.getKINDS(), data2.getWESBS(), data2.getCGTXT(), data2.getMEINS(), null, null);
                beans3.add(bean3);

                materialList.add(data2.getMATNR());
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
            //扫码显示
            layout1.setVisibility(View.VISIBLE);
            ll_scdd.setVisibility(View.VISIBLE);
//            radiogroup1.clearCheck();
            if(factory.equals("2090")){
                rb2.setVisibility(View.INVISIBLE);
            }else {
                rb2.setVisibility(View.VISIBLE);
            }

            adapter0 = new ArrayAdapter<String>(getApplicationContext(), R.layout.defined_spinner_item, cgddh_hang);
            //设置下拉列表的风格
            adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //将adapter 添加到spinner中
            spinner2.setAdapter(adapter0);
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
                    //presenter3.CGSHReceiveDetail(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getWERKS(),selectedRep.getWESBS());
                    presenter4.GetOutStorageMaterialOrderJS(selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getMarketorderno(),selectedRep.getWERKS(),selectedRep.getWESBS());
                    radiogroup1.check(R.id.ben);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

//            System.out.println(data1.get(0).getEBELN());
//            adapter1=new WXCPSHAdapter(this, R.layout.wxcpshitem1, data1);
//            adapter1.setOnInnerItemOnClickListener(this);
//            listview1.setAdapter(adapter1);
//            listview1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(OutsourceFinishedProductReceivingJSRep data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        try {
            GetOutsourceFinProLableJSReqBean printBean=new GetOutsourceFinProLableJSReqBean(data.getData().getStorageId(),data.getData().getOrderType(),data.getData().getAdvanceStorageId());
            printList.add(printBean);

//            if(receiveIndex!=-1){
//                data1.remove(receiveIndex);
//                adapter1.notifyDataSetChanged();
//                receiveIndex=-1;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess3(GetOutsourceFinProLableJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            List<GetOutsourceFinProLableJSRepBean> beans = data.getData();
            for (GetOutsourceFinProLableJSRepBean bean : beans) {
                Bitmap bm=cb.createImage7(bean,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取本事业部生产订单
    @Override
    public void onDataSuccess1(GetOutStorageMaterialOrderJSRep data) {
        productOrderList1 = data.getData();
        adapter1=new WXBCPJGRKAdapter1(WXCPSHActivity.this, R.layout.wxcpshitem1, productOrderList1);
        listview1.setAdapter(adapter1);
    }

    @Override
    public void onDataSuccess4(PreMaterialProductOrderReps data) {
        productOrderList2 = data.getData();
        adapter2=new WXBCPJGRKAdapter2(WXCPSHActivity.this, R.layout.wxcpshitem1, productOrderList2);
        listview2.setAdapter(adapter2);
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
//        Toast.makeText(KFCGSHRKActivity.this, "扫描注册初始化", Toast.LENGTH_SHORT).show();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("整体item----->", i + "");

    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
//            case R.id.receive1:
//                Log.e("内部receive1>>", position + "");
//                vibrator.vibrate(30);
//                GetPurchaseOrderInfoJSRep info = data1.get(position);
//                Intent intent=new Intent(WXCPSHActivity.this,WXCPSHDialog1Activity.class);
//                intent.putExtra("I_INKDPOS",info.getMarketorderrow());
//                intent.putExtra("I_INMATNR",info.getMATNR());
//                intent.putExtra("I_INKDAUF",info.getMarketorderno());
//                EditText et=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
//                String recenumstr=et.getText().toString();
//                float num=Float.parseFloat(("0"+recenumstr));
//                intent.putExtra("dhsl",num);
//                intent.putExtra("type",info.getMaterialType());
//                intent.putExtra("index",position);
//                intent.putExtra("username",username);
//                startActivityForResult(intent,REQUEST_CODE_1);
//                break;
//            case R.id.receive2:
//                Log.e("内部receive2>>", position + "");
//                vibrator.vibrate(30);
//                GetPurchaseOrderInfoJSRep info2 = data1.get(position);
//                Intent intent2=new Intent(WXCPSHActivity.this,WXCPSHDialog2Activity.class);
//                intent2.putExtra("I_INKDPOS",info2.getMarketorderrow());
//                //!!!注意
//                intent2.putExtra("I_INMATNR",materialList.get(position));
//                intent2.putExtra("I_INKDAUF",info2.getMarketorderno());
//                EditText et2=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
//                String recenumstr2=et2.getText().toString();
//                float num2=Float.parseFloat(("0"+recenumstr2));
//                intent2.putExtra("dhsl",num2);
//                intent2.putExtra("type",info2.getMaterialType());
//                intent2.putExtra("index",position);
//                intent2.putExtra("username",username);
//                startActivityForResult(intent2,REQUEST_CODE_2);
//                break;
//            case R.id.receive3:
//                Log.e("内部receive3>>", position + "");
//                vibrator.vibrate(30);
//                if (false){
//                    //选中的需求仓库
//                    View itme=listview1.getChildAt(position - listview1.getFirstVisiblePosition());
//                    Spinner sp= itme.findViewById(R.id.spinner1);
//                    int selectedItemPosition = sp.getSelectedItemPosition();
////                System.out.println("选中的仓库index:"+selectedItemPosition);
//                    String storage= data1.get(position).getStorage().get(selectedItemPosition).getId();
//                    beans3.get(position).setDemandStorage(storage);
//                    //数量
//                    EditText et3=listview1.getChildAt(position - listview1.getFirstVisiblePosition()).findViewById(R.id.dhsl);
//                    String recenumstr3=et3.getText().toString();
//                    float num3=Float.parseFloat(("0"+recenumstr3));
//                    beans3.get(position).setRecNum(num3);
//                    presenter2.OutsourceFinishedProductReceivingJS(getCurrentdate(),getCurrentdate(),username,beans3.get(position));
//
//                    receiveIndex=position;
//                }else {
//                    Toast.makeText(this, "请先选择生产订单", Toast.LENGTH_SHORT).show();
//                }
//                break;
            default:
                break;
        }
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
                        Toast.makeText(WXCPSHActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {

                        String bm= null;
                        String decodestr = null;
                        try {
                            marketorderno=lableObject.getString("no");
                            marketorderrow=lableObject.getString("line");
                            bm = lableObject.getString("code");
                            factory=lableObject.getString("gc");
                            decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//
                        if(marketorderno!=null&&marketorderrow!=null&&bm!=null){
                            presenter1.GetPurchaseOrderInfoJS(marketorderno,marketorderrow,decodestr);
                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(WXCPSHActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        printHelper.Close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
        initPrinter();
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
        printHelper.Open(getApplicationContext());
//        Toast.makeText(WXCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
//                printHelper.Unreeling((byte) 0x1f);
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
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
            float num0=productOrderList1.get(i).getINQTY();
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
        presenter5.PreMaterialProductOrderJS(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),materialCodeArr,selectedRep.getWERKS());
    }


}
