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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.KFFLDialogAdapter;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRepBean;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueReqBean;
import com.example.kymanage.Beans.InsertProductOrderIssue.SendProductOrderIssueReq;
import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.KFPage3.InsertProductOrderIssuePresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class KFFLDialogActivity extends AppCompatActivity implements View.OnClickListener, BaseView1<PreMaterialProductOrderReps>, BaseView2<InsertProductOrderIssueRep>, KFFLDialogAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    private ListView mListview1;
    /**
     * 确定
     */
    private Button mYes;
    /**
     * 取消
     */
    private Button mCancel;
    //传递的值
    // 标签数量
    private float dhsl;
    private String materialCode;
    private String factoryNO;
    private String pono;
    private String porow;
    private String username;
    //索引
    private int index;
    //表中数据list
    private List<PreMaterialProductOrderRep> datas;
    //adapter
    private KFFLDialogAdapter adapter;
    //获取数据
    private CGSHReceiveDetailPresenter presenter1;
    //发料
    private InsertProductOrderIssuePresenter presenter2;
    private List<InsertProductOrderIssueReqBean> FLreqs;
    //是否发料
    private boolean confirm;

    //发料总数量
    private float allNum=0;
    //传递的list<long>
    private ArrayList<Integer>  FIssueIds;
    //震动
    private Vibrator vibrator;


    //扫描相关
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;
    //序列号扫码识别
    private int xlScan=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kffldialog);
        initView();
        initData();
        //窗口对齐屏幕宽度
//        Display display = getWindowManager().getDefaultDisplay(); // 为获取屏幕宽、高
//        Window window = this.getWindow();
//        window.getDecorView().setPadding(0, 0, 0, 0);
//        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = (int) (display.getHeight() * 0.8); // 高度设置为屏幕的0.8
//        lp.gravity = Gravity.CENTER;//设置对话框底部显示
//        //windowLayoutParams.alpha = 0.5f;// 设置透明度
//        window.setAttributes(lp);
    }

    private void initView() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        mListview1 = (ListView) findViewById(R.id.listview1);
        mYes = (Button) findViewById(R.id.yes);
        mYes.setOnClickListener(this);
        mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);

        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

        presenter2=new InsertProductOrderIssuePresenter();
        presenter2.setView(this);
    }
    private void initData() {
        FIssueIds=new ArrayList<Integer>();

        datas=new ArrayList<PreMaterialProductOrderRep>();
        FLreqs=new ArrayList<InsertProductOrderIssueReqBean>();

        Intent intent=getIntent();
        dhsl=intent.getFloatExtra("qty",0);
        materialCode=intent.getStringExtra("materialCode");
        factoryNO=intent.getStringExtra("factoryNO");
        pono=intent.getStringExtra("pono");
        System.out.println("收到的pono"+pono);
        porow=intent.getStringExtra("porow");
        System.out.println("收到的porow"+porow);
        username=intent.getStringExtra("username");
        System.out.println("收到的username"+username);
        index=intent.getIntExtra("index",0);
        presenter1.CGSHReceiveDetail("","",materialCode,factoryNO,dhsl);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yes:
                vibrator.vibrate(30);
                //Toast.makeText(KFFLDialogActivity.this,"库房261出库成功",Toast.LENGTH_SHORT).show();
                confirm=true;
                //发料操作
                if(datas!=null){
                    boolean rec=true;
                    for (int i = 0; i < datas.size(); i++) {
                        PreMaterialProductOrderRep currentRep = datas.get(i);
                        View listItem=mListview1.getAdapter().getView(i,null,null);
                        EditText et1=listItem.findViewById(R.id.fpsl);
                        System.out.println("填写的数量："+et1.getText().toString());
                        float issueNum=Float.parseFloat(("0"+et1.getText().toString()));
                        //序列号
                        EditText et2 = listItem.findViewById(R.id.xlh);
                        String xlhStr = et2.getText().toString();
                        if(issueNum!=0){
                            int count= (xlhStr.length()-xlhStr.replace(",","").length());
                            if(issueNum==(count+1)||!currentRep.getSERNP().equals("KY01")){
                                InsertProductOrderIssueReqBean req=new InsertProductOrderIssueReqBean(pono, porow, "", currentRep.getMATNR(), currentRep.getMAKTX(), currentRep.getMEINS(), currentRep.getFactory(), currentRep.getProductOrderNO(), currentRep.getRSNUM(), currentRep.getRSPOS(), "", currentRep.getKDAUF(), currentRep.getKDPOS(), currentRep.getRSART(),"", currentRep.getDemandNum(), currentRep.getZSERNR(), currentRep.getStorage(), (""+issueNum),(""+currentRep.getIssuedNum()),currentRep.getProOrderDesc(),currentRep.getProOrderMaterialCode(),currentRep.getProOrderMaterialDesc(),currentRep.getProOrderMaterialUnit(),currentRep.getPLNFL(),currentRep.getLTXA1(),currentRep.getRSNUM(),currentRep.getRSPOS(),currentRep.getMATKL(),currentRep.getLOGGR(),currentRep.getLGPBE(),"货架名称",xlhStr,currentRep.getSOBKZ());
                                //字段SOBKZ ==“E”时，发料时应该传 销售订单号 和行号，等于其他时销售订单号和行号传 空“”
//                                if(!currentRep.getSOBKZ().equals("E")){
//                                    req.setKdauf("");
//                                    req.setKdpos("");
//                                }
                                allNum+=issueNum;
                                FLreqs.add(req);
                            }else {
                                rec=false;
                                Toast.makeText(this, "序列号数量错误", Toast.LENGTH_SHORT).show();
                                break;
                            }

                        }
                    }
                    if(rec==true){
                        SendProductOrderIssueReq req=new SendProductOrderIssueReq(username,FLreqs);
                        presenter2.InsertProductOrderIssue(req);
                    }
                }
                break;
            case R.id.cancel:
                vibrator.vibrate(30);
                confirm=false;
                KFFLDialogActivity.this.finish();
                break;
        }
    }
    @Override
    public void finish(){
        //bq
        List<ProductOrderBean> productOrderBeans = new ArrayList<>();
        //sl

        Intent data = new Intent();
//        data.putExtra("productOrder",(Serializable) productOrder);
//        data.putExtra("productOrderBeans",(Serializable) productOrderBeans);
//        data.putExtra("allNum",allNum);
        data.putExtra("confirm",confirm);
        data.putIntegerArrayListExtra("FIssueIds",FIssueIds);
        data.putExtra("index",index);
//        //
//        JSONArray jsonArray1 = JSONArray.parseArray(JSON.toJSONString(productOrder));
//        JSONArray jsonArray2 = JSONArray.parseArray(JSON.toJSONString(productOrderBeans));
        System.out.println("发料传递的id信息是："+FIssueIds.toString());
//        System.out.println("2传递的生产订单信息是："+jsonArray2.toString());

        //同上
        this.setResult(RESULT_OK,data);
        //销毁当前Activity必须放到最后
        super.finish();
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        datas=data.getData();
        if(datas!=null){
//            //自动分配到货数量
//            for (int i = 0; i < datas.size(); i++) {
//                float num=datas.get(i).getDemandNum()-datas.get(i).getAllocatedNum();
//                if(datas.get(i).getDemandNum()<dhsl){
//                    datas.get(i).setCurrentNum(num);
//                }else {
//                    datas.get(i).setCurrentNum(dhsl);
//                }
//                dhsl-=num;
//                dhsl=dhsl>0?dhsl:0;
//            }
            adapter=new KFFLDialogAdapter(KFFLDialogActivity.this, R.layout.kffldialogitem,datas);
            adapter.setOnInnerItemOnClickListener(this);
            mListview1.setAdapter(adapter);
            mListview1.setOnItemClickListener(this);
        }
    }

    @Override
    public void onDataSuccess2(InsertProductOrderIssueRep data) {
        if(data.getStatus().getCode()==1){
            List<InsertProductOrderIssueRepBean> data1 = data.getData();
            if(data1!=null){
                if(data1.size()>0){
                    for (int i = 0; i < data1.size(); i++) {
                        FIssueIds.add((int) data1.get(i).getFIssueId());
                    }
                }
            }
            KFFLDialogActivity.this.finish();
            Toast.makeText(this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        }else {
            DialogUtil.errorMessageDialog(KFFLDialogActivity.this,data.getStatus().getMessage());
        }

//        System.out.println(data.getData().get(0).getFAllocatedID());
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.scan:
                vibrator.vibrate(30);
                xlScan = position;
                System.out.println("内部scan>>" + xlScan);
                scan();
                break;
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
                if(!str.equals("")){
                    if (xlScan == -1) {
                        Toast.makeText(KFFLDialogActivity.this, "选中行错误", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println("扫描字符串:"+str);
                        View itme = mListview1.getAdapter().getView(xlScan, null, null);
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
