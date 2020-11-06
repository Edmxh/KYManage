package com.example.kymanage.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.CGSHRKAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetMaterialPropertieInfoJSRepBean;
import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.KFPage1.GetMaterialPropertieInfoJSPresenter;
import com.example.kymanage.presenter.Presenters.KFPage1.GetSapStoragesPresenter;
import com.example.kymanage.presenter.Presenters.KFPage1.KFReceivePresenter;
import com.example.kymanage.utils.DialogUtil;
import com.olc.scan.ScanManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    private GetMaterialPropertieInfoJSPresenter presenter1;
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

    //序列号扫码识别
    private int xlScan=-1;


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

        presenter1=new GetMaterialPropertieInfoJSPresenter();
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
                scan();

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
        if(data.getCode()==1){
            Toast.makeText(KFCGSHRKActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
            if(data.getData()!=null){
                req=new WarehouseReceiptReq(pono, porow, po, bm, factory, null, sl,area, cs,aid,"");
                receiptReqs.add(req);
                DialogUtil.startAlarm(this);
                vibrator.vibrate(300);
                data.getData().setFactory(factory);
                data.getData().setLabelSquNum(labelSquNum);
                data.getData().setQty(sl);
                factory="";
                labelSquNum="";
                sl=0;
                datas.add(data);

                adapter=new CGSHRKAdapter(KFCGSHRKActivity.this, R.layout.cgshrkitem,datas);
                adapter.setOnInnerItemOnClickListener(this);
                cgshlistview.setAdapter(adapter);
                cgshlistview.setOnItemClickListener(this);
            }
        }else {
            DialogUtil.errorMessageDialog(KFCGSHRKActivity.this,data.getMessage());
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
        LoadingBar.dialog(KFCGSHRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getCode()==1){
            Toast.makeText(KFCGSHRKActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            try {
                if(currentIndex!=-1){
                    datas.remove(currentIndex);
                    receiptReqs.remove(currentIndex);
                    currentIndex=-1;
                    adapter.notifyDataSetChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            DialogUtil.errorMessageDialog(KFCGSHRKActivity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(KFCGSHRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        Toast.makeText(this, "服务器响应失败,请稍后重试", Toast.LENGTH_LONG).show();
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
                    //验证是否需要序列号
                    GetPurWayMaterialDataRep dataRep = datas.get(position);

                    WarehouseReceiptReq checkedReq = receiptReqs.get(position);
                    View itme=cgshlistview.getAdapter().getView(position,null,null);
                    TextView et= itme.findViewById(R.id.rksl);
                    Spinner sp= itme.findViewById(R.id.spinner1);
                    float recenum=Float.parseFloat(et.getText().toString());
                    checkedReq.setReceNum(recenum);
                    //选中的需求仓库
                    int selectedItemPosition = sp.getSelectedItemPosition();
//                System.out.println("选中的仓库index:"+selectedItemPosition);
                    areadess= dataRep.getData().getStorage();
                    ckid=areadess.get(selectedItemPosition).getId();
                    checkedReq.setDemandStorage(ckid);

                    //序列号
                    EditText et2 = itme.findViewById(R.id.xlh);
                    String xlhStr = et2.getText().toString();
                    checkedReq.setSerialNO(xlhStr);
                    int count= (xlhStr.length()-xlhStr.replace(",","").length());
//                System.out.println("ckid:"+ckid);
                    if(dataRep.getData().getSerialNO().equals("KY01")&&checkedReq.getReceNum()!=(count+1)){
                        Toast.makeText(this, "序列号数量错误", Toast.LENGTH_SHORT).show();
                    }else {
                        List<WarehouseReceiptReq> checkedListReq=new ArrayList<WarehouseReceiptReq>();
                        checkedListReq.add(checkedReq);
                        currentIndex=position;
                        LoadingBar.dialog(KFCGSHRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
                        presenter3.WarehouseReceipt(getCurrentdate(),getCurrentdate(),username,checkedListReq);
                    }

                }else {
                    Toast.makeText(KFCGSHRKActivity.this,"未选中收货行",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.scan:
                vibrator.vibrate(30);
                xlScan=position;
                System.out.println("内部scan>>"+xlScan);
                scan();


                break;
            default:
                break;
        }
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
                if (str.contains("{")) {
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
                                if(labelSquNum.equals(data.getData().getLabelSquNum())){
                                    repeat=true;
                                }
                            }
                            if(repeat){
                                System.out.println("请勿重复扫码");
                                Toast.makeText(KFCGSHRKActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();

                            }else {
                                if(porow!=null&&pono!=null&&bm!=null&&factory!=null){
                                    SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                                            Activity.MODE_PRIVATE);
                                    String fac =sharedPreferences.getString("factory", "");
                                    System.out.println("所在部门是"+fac);
                                    if(factory.equals(fac)){
                                        System.out.println("执行查询105");
                                        try {
                                            presenter1.GetMaterialPropertieInfoJS(aid);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            Toast.makeText(KFCGSHRKActivity.this, "解析二维码错误", Toast.LENGTH_SHORT).show();
                                        }
                                    }else {
                                        DialogUtil.errorMessageDialog(KFCGSHRKActivity.this,"该物料属于"+factory);
                                    }
                                }
                            }
                            scanString="";
                        }else {
                            Log.i("token","扫描结果为空");
                            Toast.makeText(KFCGSHRKActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                        }
                    //tv.setText(str);
                } else if(!str.equals("")){
                    if (xlScan == -1) {
                        Toast.makeText(KFCGSHRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println("扫描字符串:"+str);
                        View itme = cgshlistview.getAdapter().getView(xlScan, null, null);
                        EditText et = itme.findViewById(R.id.xlh);
                        String xlhStr = et.getText().toString();
                        //输入框内容为空，则直接增加；若不为空，判断序列号是否存在，不存在则用“，”隔开并增加
                        if (xlhStr.equals("")) {
                            System.out.println("直接增加"+str);
                            xlhStr = str;
                            et.setText(xlhStr);
                        } else {
                            String[] split = xlhStr.split(",");
                            if (Arrays.asList(split).contains(str)) {
                            } else {
                                xlhStr = xlhStr + "," + str;
                                et.setText(xlhStr);
                            }
                        }
                        adapter.notifyDataSetChanged();
                        //扫描完毕后初始化xlScan
                        xlScan = -1;
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
