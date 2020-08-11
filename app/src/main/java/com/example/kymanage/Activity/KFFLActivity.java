package com.example.kymanage.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.KFFLAdapter;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordReq;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordReqBean;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean1;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean2;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.KFLabelBean;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSBean;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReq;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage1.GetSapStoragesPresenter;
import com.example.kymanage.presenter.Presenters.KFPage3.GetIssueNoteDetail2Presenter;
import com.example.kymanage.presenter.Presenters.KFPage3.GenerateStorageLssueRecordPresenter;
import com.example.kymanage.presenter.Presenters.KFPage3.GetStockInformationDataJSPresenter;
import com.example.kymanage.utils.mPrintUtil;

import java.util.ArrayList;
import java.util.List;

import Printer.PrintHelper;

public class KFFLActivity extends BaseActivity implements ScanBaseView<GetStockInformationDataJSRep>, BaseView1<GenerateStorageLssueRecordRep>,BaseView3<GetIssueNoteDetailRep>, KFFLAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //自定义请求码常量
    private static final int REQUEST_CODE = 1;

    private ImageView scan;
//    private ImageView print1;
//    private ImageView print2;
//    private ImageView record;
    private ListView listview1;
    //cs
    private KFFLAdapter adapter;
    private List<GetStockInformationDataJSBean> datas;

    private GetStockInformationDataJSPresenter presenter1;
    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;
    //username
    private String username;
    //当前扫描获得的全局变量
    private String labelSquNum;
    private String materialCode;
    private float qty;
    private String factory;
    private String pono;
    private String porow;
    private GetStockInformationDataJSBean currentdata;
    //打印发料单接口
    private GenerateStorageLssueRecordPresenter presenter2;
    private List<GenerateStorageLssueRecordReqBean> flDatas;
    //获取主料仓
    private GetSapStoragesPresenter presenter3;
    //标签打印
    private GetIssueNoteDetail2Presenter presenter4;
    private List<GetIssueNoteDetailReq> bqDatas;
    private List<InsertStorageLableRecordReq> bqPrintDatas;
    private InsertStorageLableRecordReq bqPrintData;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //打印类
    private PrintHelper printHelper=null;

    //不可重复发料
    private boolean hasFL=false;
    //震动
    private Vibrator vibrator;

    private ImageView menupoint;
    PopupMenu popup = null;

    private mPrintUtil mPrintUtil;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kffl;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        scan=findViewById(R.id.scan);
//        print1=findViewById(R.id.print1);
//        print2=findViewById(R.id.print2);
        listview1=findViewById(R.id.listview1);
        menupoint=findViewById(R.id.menupoint);
//        record=findViewById(R.id.record);

        presenter1=new GetStockInformationDataJSPresenter();
        presenter1.setView(this);

        presenter2=new GenerateStorageLssueRecordPresenter();
        presenter2.setView(this);


        presenter4=new GetIssueNoteDetail2Presenter();
        presenter4.setView(this);
    }

    @Override
    public void initData() {
        mPrintUtil=new mPrintUtil();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
//测试数据
        bqPrintDatas=new ArrayList<InsertStorageLableRecordReq>();
//        currentData=new GetMaterialMasterDataInfo();
        datas=new ArrayList<GetStockInformationDataJSBean>();
        currentdata=new GetStockInformationDataJSBean();
        flDatas=new ArrayList<GenerateStorageLssueRecordReqBean>();
        bqDatas=new ArrayList<GetIssueNoteDetailReq>();


        adapter=new KFFLAdapter(KFFLActivity.this, R.layout.kfflitem,datas);
        adapter.setOnInnerItemOnClickListener(this);
        listview1.setAdapter(adapter);
        listview1.setOnItemClickListener(this);
//        DemoBean1 db3=new DemoBean1("ZJ500000004323","测试描述螺旋机H6","2030","H152","G90000054323",12,8);
//        datas.add(db3);
        cb=new CreateBitmap();
        //初始化打印类
//        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
                //fld
//                List<GetIssueNoteDetailPOReq> productOrder = (List<GetIssueNoteDetailPOReq>)data.getSerializableExtra("productOrder");
                boolean confirm=data.getBooleanExtra("confirm",false);
                int flIndex=data.getIntExtra("index",-1);
                ArrayList<Integer> ids = data.getIntegerArrayListExtra("FIssueIds");
                System.out.println("发料接收的id信息是："+ids.toString());
//                float allnum=data.getFloatExtra("allNum",0);
                //bq
//                List<ProductOrderBean> productOrderBeans = (List<ProductOrderBean>)data.getSerializableExtra("productOrderBeans");
//                JSONArray jsonArray1 = JSONArray.parseArray(JSON.toJSONString(productOrder));
//                JSONArray jsonArray2 = JSONArray.parseArray(JSON.toJSONString(productOrderBeans));
//                System.out.println("1传递的生产订单信息是："+jsonArray1.toString());
//                System.out.println("2传递的生产订单信息是："+jsonArray2.toString());
                if(confirm){
                    for (int i = 0; i < ids.size(); i++) {
                        GenerateStorageLssueRecordReqBean flData=new GenerateStorageLssueRecordReqBean(ids.get(i));
                        flDatas.add(flData);
                        GetIssueNoteDetailReq bqData=new GetIssueNoteDetailReq((""+ids.get(i)));
                        bqDatas.add(bqData);
                    }
                    if(flIndex!=-1){
                        datas.remove(flIndex);
                    }
                }
                adapter.notifyDataSetChanged();

                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                bqPrintData=new InsertStorageLableRecordReq("dsfe002344", 6, "xmao", "2020-05-09", "2000", null, null, null, null);
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
                //Toast.makeText(AdvancedReceiveActivity.this, scanString, Toast.LENGTH_SHORT).show();
//                scanString="{\"bm\":\"DQ3008000001\",\"sl\":1.0,\"aid\":2995,\"num\":\"2007222012101587\",\"po\":\"\",\"pono\":\"4100026847\",\"porow\":\"00010\",\"gc\":\"2020\",\"cd\":\"\",\"cs\":0}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(KFFLActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    materialCode = lableObject.getString("bm");
//                    factory=lableObject.getString("gc");
//                    qty=lableObject.getFloat("sl");
//                    labelSquNum=lableObject.getString("num");
//                    pono=lableObject.getString("pono");
//                    porow=lableObject.getString("porow");
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (GetStockInformationDataJSBean data : datas) {
//                        if(materialCode.equals(data.getMaterialCode())){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        Toast.makeText(KFFLActivity.this, "该物料已存在", Toast.LENGTH_SHORT).show();
//                    }else {
//                        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
//                                Activity.MODE_PRIVATE);
//// 使用getString方法获得value，注意第2个参数是value的默认值
//                        String fac =sharedPreferences.getString("factory", "");
//                        if(factory.equals(fac)){
//                            presenter1.GetStockInformationDataJS(materialCode,factory);
//                        }else {
//                            Toast.makeText(getApplicationContext(), "该物料属于"+factory, Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString="";
//                }else {
//                    Toast.makeText(KFFLActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.kfflmenu, popup.getMenu());
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
                                Intent intent = new Intent(KFFLActivity.this, KFFLRecordActivity.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
                                break;
//                            case R.id.print1:
//                                // 隐藏该对话框
//                                if(!hasFL){
//                                    GenerateStorageLssueRecordReq FLReq=new GenerateStorageLssueRecordReq(username,flDatas);
//                                    presenter2.GenerateStorageLssueRecord(FLReq);
//                                }else {
//                                    Toast.makeText(KFFLActivity.this,"不可重复收货发料，请退出页面重试！",Toast.LENGTH_SHORT).show();
//                                }
//                                break;
                            case R.id.print2:
                                // 隐藏该对话框
                                presenter4.GetIssueNoteDetail2(bqDatas);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(KFFLActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetStockInformationDataJSRep data) {
        currentdata=data.getData();
        currentdata.setPono(pono);
        currentdata.setPorow(porow);
        datas.add(currentdata);
        adapter.notifyDataSetChanged();
        pono="";
        porow="";
//        Intent intent=new Intent(KFFLActivity.this,KFFLDialogActivity.class);
//        intent.putExtra("qty",qty);
//        intent.putExtra("materialCode",materialCode);
//        intent.putExtra("factoryNO",factory);
//        startActivityForResult(intent,REQUEST_CODE);
//        currentData=data.getData();
//        currentData.setMaterialCode(materialCode);
//
//        flData.setMaterialDesc(data.getData().getMaterialDescription());
//        flData.setUnit(data.getData().getUnit());
//
//        bqPrintData.setUnit(data.getData().getUnit());
//        bqPrintData.setMaterialDesc(data.getData().getMaterialDescription());
//        bqPrintData.setMaterialType(data.getData().getType());

    }

    @Override
    public void onDataSuccess1(GenerateStorageLssueRecordRep data) {
        mPrintUtil.printFLBill(data,printHelper);
        printHelper.printBlankLine(80);
    }
    @Override
    public void onDataSuccess3(GetIssueNoteDetailRep data) {
        Toast.makeText(KFFLActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        List<GetIssueNoteDetailBean2> data1 = data.getData();

        int labelnum=0;
        if(data1!=null){
            if(data1.size()>0){
//                System.out.println();
                for (int i = 0; i < data1.size(); i++) {
                    GetIssueNoteDetailBean2 data2 = data1.get(i);
                    List<GetIssueNoteDetailBean1> data3 = data2.getData();
                    if(data3!=null){
                        if(data3.size()>0){
                            for (GetIssueNoteDetailBean1 data4 : data3) {
                                KFLabelBean labelBean=new KFLabelBean(data2.getMaterialDesc(), data2.getMarketOrderNO(),data4 ,data2.getProductOrderNO(), data2.getMaterialCode(), data2.getMarketOrderRow());
                                Bitmap bm=cb.createImage2(labelBean,tf);
//                                printHelper.GoToNextPage();
                                printHelper.PrintBitmapAtCenter(bm,384,480);
                                printHelper.printBlankLine(81);
                                labelnum++;
                            }
                        }
                    }
                }
            }
        }
//        printHelper.printBlankLine(100);
        System.out.println("打印标签的数量为"+labelnum);

        bqDatas.clear();
       // Toast.makeText(KFFLActivity.this, "打印标签的数量为"+labelnum, Toast.LENGTH_SHORT).show();
        //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {

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
            case R.id.dispatch:
                vibrator.vibrate(30);
                Log.e("内部receive>>", position + "");
                GetStockInformationDataJSBean checkedData = datas.get(position);
                float checkedDataQty = checkedData.getQty();
                String checkedDataMaterialCode = checkedData.getMaterialCode();
                String checkedDataFactory = checkedData.getFactory();
                String checkedDataPono = checkedData.getPono();
                String checkedDataPorow = checkedData.getPorow();
                Intent intent=new Intent(KFFLActivity.this,KFFLDialogActivity.class);
                intent.putExtra("qty", checkedDataQty);
                intent.putExtra("materialCode", checkedDataMaterialCode);
                intent.putExtra("factoryNO", checkedDataFactory);
                intent.putExtra("pono", checkedDataPono);
                System.out.println("传递的pono"+checkedDataPono);
                intent.putExtra("porow", checkedDataPorow);
                System.out.println("传递的porow"+checkedDataPorow);
                intent.putExtra("username", username);
                System.out.println("传递的username"+username);
                intent.putExtra("index", position);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            default:
                break;
        }
    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            for (int i = 0; i < datas.size(); i++) {
                //View itme=cgshlistview.getChildAt(i);
//                View itme=cglistview.getChildAt(i);
//                View itme=listview1.getChildAt(i - listview1.getFirstVisiblePosition());
//                if (i==position){
//                    setBackgroundChange(itme, R.drawable.tablebody3);
//                }else {
//                    if(i%2==1){
//                        setBackgroundChange(itme, R.drawable.tablebody1);
//                    }else {
//                        setBackgroundChange(itme, R.drawable.tablebody2);
//                    }
//                }
            }
//            View itme=listview1.getChildAt(position);
//
//            CheckableLayout itemlayout=itme.findViewById(R.id.parent_layout);
//
//            if(itemlayout.isChecked()){
//                setBackgroundChange(itme, R.drawable.tablebody3);
//            }else {
//                if(position%2==1){
//                    setBackgroundChange(itme, R.drawable.tablebody1);
//                }else {
//                    setBackgroundChange(itme, R.drawable.tablebody2);
//                }
//            }
//            itemlayout.toggle();
//            DemoBean1 tempdb=datas.get(position);
            //psdh.setText(tempdb.getStr5());
//            GetRecevingDetailrep temprep=datas.get(position);
//            wlms.setText(temprep.getDescription());
//            wllx.setText(temprep.getClassStr());
//            String s1=""+temprep.getDemand();
//            xqsl.setText(s1);
//            String s2=""+temprep.getStorage();
//            dhsl.setText(s2);

        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.wlms).setBackgroundResource(i);
        view.findViewById(R.id.sl).setBackgroundResource(i);
    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(getApplicationContext());
//        Toast.makeText(KFFLActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(KFFLActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {

                        try {
                            materialCode = lableObject.getString("bm");
                            factory=lableObject.getString("gc");
                            qty=lableObject.getFloat("sl");
                            labelSquNum=lableObject.getString("num");
                            pono=lableObject.getString("pono");
                            porow=lableObject.getString("porow");

                            //判断是否重复扫码
                            boolean repeat=false;
                            for (GetStockInformationDataJSBean data : datas) {
                                if(materialCode.equals(data.getMaterialCode())){
                                    repeat=true;
                                }
                            }
                            if(repeat){
                                Toast.makeText(KFFLActivity.this, "该物料已存在", Toast.LENGTH_SHORT).show();
                            }else {
                                SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                                        Activity.MODE_PRIVATE);
    // 使用getString方法获得value，注意第2个参数是value的默认值
                                String fac =sharedPreferences.getString("factory", "");
                                if(factory.equals(fac)){
                                    presenter1.GetStockInformationDataJS(materialCode,factory);
                                }else {
                                    Toast.makeText(context, "该物料属于"+factory, Toast.LENGTH_SHORT).show();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString="";
                    }else {
                        Toast.makeText(KFFLActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(KFFLActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
