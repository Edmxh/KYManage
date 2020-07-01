package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.CGSHRKAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataBean;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage1.GetPurWayMaterialDataPresenter;
import com.example.kymanage.presenter.Presenters.KFPage1.GetSapStoragesPresenter;
import com.example.kymanage.presenter.Presenters.KFPage1.KFReceivePresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KFCGSHRKActivity extends BaseActivity implements ScanBaseView<GetPurWayMaterialDataRep>, BaseView2<GetSapStorageInfoByFactoryJSBean>,BaseView1<CodeMessageBean>, CGSHRKAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {


    //确认和取消按钮
    private ImageView scan;
    private ImageView record;
    //listview
    private ListView cgshlistview;
    //adapter
    private CGSHRKAdapter adapter;
    //kufang105
    private KFReceivePresenter presenter3;
    //工厂和场地
//    private TextView gc;
    private TextView cd;
    //扫描查询
    private List<GetPurWayMaterialDataRep> datas;
    private GetPurWayMaterialDataPresenter presenter1;
    private String factory;
    private String labelSquNum;
    private String po;
    private String pono;
    private String porow;
    private String bm;
    private float sl;
    private String area;
    private int cs;
    private long aid;
    //收货数据
    private List<WarehouseReceiptReq> receiptReqs;
    private WarehouseReceiptReq req;
    //选择日期
    //private TextView date;
    //当前时间
    private String currentdate;
    //获取库位信息
    private GetSapStoragesPresenter presenter2;
    //需求仓库下拉框
    private List<iddesBean> areadess;
    private List<String> dess;
    private String chosenArea;

    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;
    //username
    private String username;
    //选中的需求仓库
    private String ckid;
    //震动
    private Vibrator vibrator;

    //当前收货的序号
    private int currentIndex=-1;


    @Override
    public int initLayoutId() {
        return R.layout.activity_cgshrk;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        record=findViewById(R.id.record);
        cgshlistview=findViewById(R.id.cgshlistview);
//        gc=findViewById(R.id.gc);

        presenter3=new KFReceivePresenter();
        presenter3.setView(this);

        presenter1=new GetPurWayMaterialDataPresenter();
        presenter1.setView(this);

        presenter2=new GetSapStoragesPresenter();
        presenter2.setView(this);

        Intent intent=getIntent();
        username=intent.getStringExtra("username");


    }

    @Override
    public void initData() {
        receiptReqs=new ArrayList<WarehouseReceiptReq>();
        req=new WarehouseReceiptReq();

        //测试数据
        datas=new ArrayList<GetPurWayMaterialDataRep>();
//        db=new DemoBean1("测试","测试","测试","测试","",0,0);

        //初始化
        areadess=new ArrayList<iddesBean>();
        dess=new ArrayList<String>();
//        //下拉框
//        adapter2 = new ArrayAdapter<String>(this, R.layout.defined_spinner_item, dess);
//        //设置下拉列表的风格
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //将adapter 添加到spinner中
//        mSpinner1.setAdapter(adapter2);
//        //添加事件Spinner事件监听
//        //mSpinner1.setOnItemSelectedListener(new SpinnerSelectedListener());
//        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                chosenArea=areadess.get(arg2).getId();
//                System.out.println("spinner选中项"+mSpinner1.getSelectedItemPosition());
//            }
//
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
//        mSpinner1.setVisibility(View.VISIBLE);
//        adapter.notifyDataSetChanged();
//        DemoBean1 db1=new DemoBean1("ZJ0000000001","测试描述1","2010","A123","",6,8);
//        DemoBean1 db2=new DemoBean1("ZJ0000000002","测试描述2","2030","B132","",3,8);
//        DemoBean1 db3=new DemoBean1("ZJ0000000003","测试描述3","2030","H152","",12,8);
//        datas.add(db1);
//        datas.add(db2);
//        datas.add(db3);
    }

    @Override
    public void initLisenter() {
//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDateAndTable();
//            }
//        });

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

                //Toast.makeText(AdvancedReceiveActivity.this, scanString, Toast.LENGTH_SHORT).show();
//                scanString="{\"bm\":\"DQ5095000046\",\"sl\":2.0,\"num\":\"15914359052732\",\"po\":\"\",\"pono\":\"4100011740\",\"porow\":\"00010\",\"gc\":\"2010\",\"cd\":\"A38\",\"cs\":19}";
//                scanString="{”id” : “123”, “name” : “hello”, “title” : “work”}";

//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(KFCGSHRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
////                    System.out.println(lableObject.getString("bm"));
//                    String purchaseorderno=lableObject.getString("pono");
//                    System.out.println(purchaseorderno);
//                    String purchaseorderrow=lableObject.getString("porow");
//                    String productOrderno=lableObject.getString("po");
//                    float qty=lableObject.getFloat("sl");
//                    String MaterialCode = lableObject.getString("bm");
//                    String targetArea = lableObject.getString("cd");
//                    factory=lableObject.getString("gc");
//                    labelSquNum=lableObject.getString("num");
//                    int batch=lableObject.getInteger("cs");
//
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (GetPurWayMaterialDataRep data : datas) {
//                        if(labelSquNum.equals(data.getData().getLabelSeqNum())){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(KFCGSHRKActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                    }else {
//                        req=new WarehouseReceiptReq(purchaseorderno, purchaseorderrow, productOrderno, MaterialCode, factory, null, qty,targetArea, batch);
//                        receiptReqs.add(req);
//                        presenter1.GetPurWayMaterialData(purchaseorderrow,purchaseorderno,qty,MaterialCode,factory);
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(KFCGSHRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent=new Intent(KFCGSHRKActivity.this,KFCGRKRecordActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
//        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//                ckid=areadess.get(arg2).getId();
//                System.out.println("选中的ckid是:"+ckid);
//            }
//            public void onNothingSelected(AdapterView<?> arg0) {
//                ckid=areadess.get(0).getId();
//                System.out.println("默认的ckid是:"+ckid);
//            }
//        });

    }
    @Override
    public void onDataSuccessScan(GetPurWayMaterialDataRep data) {
        Toast.makeText(KFCGSHRKActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
        if(data.getData()!=null){
            req=new WarehouseReceiptReq(pono, porow, po, bm, factory, null, sl,area, cs,aid);
            receiptReqs.add(req);
            data.getData().setFactory(factory);
            data.getData().setLabelSeqNum(labelSquNum);
            factory="";
            labelSquNum="";
            datas.add(data);

            adapter=new CGSHRKAdapter(KFCGSHRKActivity.this, R.layout.cgshrkitem,datas);
            adapter.setOnInnerItemOnClickListener(this);
            cgshlistview.setAdapter(adapter);
            cgshlistview.setOnItemClickListener(this);
        }
    }

    @Override
    public void onDataSuccess2(GetSapStorageInfoByFactoryJSBean data) {
        areadess=data.getData();
        dess.clear();
        for (iddesBean iddesBean : areadess) {
            dess.add(iddesBean.getDesc());
        }
//        adapter2.notifyDataSetChanged();
    }

    @Override
    public void onDataSuccess1(CodeMessageBean data) {
        Toast.makeText(KFCGSHRKActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas.remove(currentIndex);
            receiptReqs.remove(currentIndex);
            currentIndex=-1;
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {
        currentIndex=-1;
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
            case R.id.receive:
                Log.e("内部receive>>", position + "");
                vibrator.vibrate(30);
//                checkednum = position;
//                receive(checkednum);
                //初始化日期为当前日期
                Date date0 = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                currentdate=sf.format(date0);

                if(position>=0){
                    WarehouseReceiptReq checkedReq = receiptReqs.get(position);
                    View itme=cgshlistview.getChildAt(position - cgshlistview.getFirstVisiblePosition());
                    TextView et= itme.findViewById(R.id.rksl);
                    Spinner sp= itme.findViewById(R.id.spinner1);
                    float recenum=Float.parseFloat(et.getText().toString());
                    checkedReq.setReceNum(recenum);
                    //选中的需求仓库
                    int selectedItemPosition = sp.getSelectedItemPosition();
//                System.out.println("选中的仓库index:"+selectedItemPosition);
                    areadess=datas.get(position).getStorage();
                    ckid=areadess.get(selectedItemPosition).getId();
                    checkedReq.setDemandStorage(ckid);
//                System.out.println("ckid:"+ckid);
                    List<WarehouseReceiptReq> checkedListReq=new ArrayList<WarehouseReceiptReq>();
                    checkedListReq.add(checkedReq);
                    currentIndex=position;
                    presenter3.WarehouseReceipt(getCurrentdate(),getCurrentdate(),username,checkedListReq);
                }else {
                    Toast.makeText(KFCGSHRKActivity.this,"未选中收货行",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            for (int i = 0; i < datas.size(); i++) {
//                View itme=cgshlistview.getChildAt(i - cgshlistview.getFirstVisiblePosition());
//                if (i==position){
//                    setBackgroundChange(itme, R.drawable.tablebody3);
//                }else {
//                    if(i%2==1){
//                    setBackgroundChange(itme, R.drawable.tablebody1);
//                    }else {
//                    setBackgroundChange(itme, R.drawable.tablebody2);
//                    }
//                }
//            }

            GetPurWayMaterialDataBean tempdb=datas.get(position).getData();
//            gc.setText(tempdb.getFactory());

            presenter2.GetSapStorages(tempdb.getFactory());
        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.wlms).setBackgroundResource(i);
//        view.findViewById(R.id.yrksl).setBackgroundResource(i);
        view.findViewById(R.id.yirksl).setBackgroundResource(i);
        view.findViewById(R.id.rksl).setBackgroundResource(i);
    }

    //日期弹窗
    private void showDateAndTable() {
        Calendar calendar = Calendar.getInstance();//调用Calendar类获取年月日
        int  mYear = calendar.get(Calendar.YEAR);//年
        int  mMonth = calendar.get(Calendar.MONTH);//月份要加一个一，这个值的初始值是0。不加会日期会少一月。
        int  mDay = calendar.get(Calendar.DAY_OF_MONTH);//日
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String str1=""+i;
                String str2;
                String str3;
                str2=(i1+1)<10?("-0"+(i1+1)):"-" + (i1+1);
                str3=i2<10?("-0"+i2):"-"+i2;
                //date.setText(str1+str2+str3);
            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
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
                        Toast.makeText(KFCGSHRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
//                    System.out.println(lableObject.getString("bm"));
                        try {
                            pono=lableObject.getString("pono");
                            porow=lableObject.getString("porow");
                            po=lableObject.getString("po");
                            sl=lableObject.getFloat("sl");
                            bm = lableObject.getString("bm");
                            area = lableObject.getString("cd");
                            factory=lableObject.getString("gc");
                            labelSquNum=lableObject.getString("num");
                            cs=lableObject.getInteger("cs");
                            aid=lableObject.getLong("aid");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //判断是否重复扫码
                        boolean repeat=false;
                        for (GetPurWayMaterialDataRep data : datas) {
                            if(labelSquNum.equals(data.getData().getLabelSeqNum())){
                                repeat=true;
                            }
                        }
                        if(repeat){
                            System.out.println("请勿重复扫码");
                            Toast.makeText(KFCGSHRKActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();

                        }else {
                            if(porow!=null&&pono!=null&&bm!=null&&factory!=null){
                                presenter1.GetPurWayMaterialData(porow,pono,sl,bm,factory);
                            }
                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString="";
                    }else {
                        Log.i("token","扫描结果为空");
                        Toast.makeText(KFCGSHRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
