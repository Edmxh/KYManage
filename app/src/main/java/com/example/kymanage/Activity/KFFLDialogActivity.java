package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KFFLDialogActivity extends AppCompatActivity implements View.OnClickListener, BaseView1<PreMaterialProductOrderReps>, BaseView2<InsertProductOrderIssueRep> {

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
                    for (int i = 0; i < datas.size(); i++) {
                        PreMaterialProductOrderRep currentRep = datas.get(i);
                        View listItem=mListview1.getAdapter().getView(i,null,null);
                        EditText et1=listItem.findViewById(R.id.fpsl);
                        System.out.println("填写的数量："+et1.getText().toString());
                        float issueNum=Float.parseFloat(("0"+et1.getText().toString()));
                        if(issueNum!=0){
                            //System.out.println("发料请求增加一条");
//                            InsertProductOrderIssueReqBean req=new InsertProductOrderIssueReqBean(pono, porow, "2020-01-01", "2020-01-01", username, "", currentRep.getMATNR(), currentRep.getMAKTX(), currentRep.getMEINS(), currentRep.getFactory(), currentRep.getProductOrderNO(), currentRep.getRSNUM(), currentRep.getRSPOS(), "", currentRep.getKDAUF(), currentRep.getKDPOS(), "", issueNum, currentRep.getZSERNR(), currentRep.getStorage(), (""+issueNum));
                            InsertProductOrderIssueReqBean req=new InsertProductOrderIssueReqBean(pono, porow, "", currentRep.getMATNR(), currentRep.getMAKTX(), currentRep.getMEINS(), currentRep.getFactory(), currentRep.getProductOrderNO(), currentRep.getRSNUM(), currentRep.getRSPOS(), "", currentRep.getKDAUF(), currentRep.getKDPOS(), "", currentRep.getDemandNum(), currentRep.getZSERNR(), currentRep.getStorage(), (""+issueNum),(""+currentRep.getIssuedNum()),currentRep.getProOrderDesc(),currentRep.getProOrderMaterialCode(),currentRep.getProOrderMaterialDesc(),currentRep.getProOrderMaterialUnit(),currentRep.getPLNFL(),currentRep.getLTXA1(),currentRep.getRSNUM(),currentRep.getRSPOS(),currentRep.getMATKL(),currentRep.getLOGGR(),currentRep.getLGPBE(),"货架名称");
                            allNum+=issueNum;
                            FLreqs.add(req);
                        }
                    }
//                    FLreqs.clear();
//                    InsertProductOrderIssueReqBean req=new InsertProductOrderIssueReqBean("41000117372", "00010", "2020-01-01", "2020-01-01", username, "", "20000012", currentRep.getMAKTX(), currentRep.getMEINS(), currentRep.getFactory(), currentRep.getProductOrderNO(), currentRep.getRSNUM(), currentRep.getRSPOS(), "", currentRep.getKDAUF(), currentRep.getKDPOS(), "", issueNum, currentRep.getZSERNR(), currentRep.getStorage(), (""+issueNum));
                    SendProductOrderIssueReq req=new SendProductOrderIssueReq(username,FLreqs);
                    presenter2.InsertProductOrderIssue(req);
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
            mListview1.setAdapter(adapter);
            mListview1.setOnItemClickListener(new ListViewItemOnClick());
        }
    }

    @Override
    public void onDataSuccess2(InsertProductOrderIssueRep data) {
        Toast.makeText(this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        List<InsertProductOrderIssueRepBean> data1 = data.getData();
        if(data1!=null){
            if(data1.size()>0){
                for (int i = 0; i < data1.size(); i++) {
                    FIssueIds.add((int) data1.get(i).getFIssueId());
                }
            }
        }
        KFFLDialogActivity.this.finish();
//        System.out.println(data.getData().get(0).getFAllocatedID());
    }

    @Override
    public void onFailed(String msg) {

    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            View itme=mListview1.getChildAt(position- mListview1.getFirstVisiblePosition());
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
        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xqjb).setBackgroundResource(i);
        view.findViewById(R.id.scddh).setBackgroundResource(i);
        view.findViewById(R.id.jhksrq).setBackgroundResource(i);
        view.findViewById(R.id.xqsl).setBackgroundResource(i);
        view.findViewById(R.id.fpsl).setBackgroundResource(i);
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
}
