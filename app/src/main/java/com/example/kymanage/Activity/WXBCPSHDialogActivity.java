package com.example.kymanage.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kymanage.Adapter.CGDialogAdapter;
import com.example.kymanage.Adapter.WXBCPSHDialogAdapter;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.Semi_FinishedProductReceivingPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXBCPSHDialogActivity extends AppCompatActivity implements View.OnClickListener, BaseView1<PreMaterialProductOrderReps>, BaseView2<Semi_FinishedProductReceivingRep> {

    /**
     * 确定
     */
    private Button mYes;
    /**
     * 取消
     */
    private Button mCancel;

    //listview
    private ListView listview1;
    //传递的list
    private List<PreMaterialProductOrderRep> datas;
    private String materialCode;
    private String pmaterialCode;
    private String kinds;
    private String factoryNO;
    private String marketorderno;
    private String marketorderrow;
    private float dhsl;
    private String username;
    private Semi_FinishedProductReceivingReq receiveReq;
    //返回的AdvanceStorageId
    private long AdvanceStorageId;
    //adapter
    private WXBCPSHDialogAdapter adapter;
    //获取数据
    private CGSHReceiveDetailPresenter presenter1;
    //收货
    private Semi_FinishedProductReceivingPresenter presenter2;
    private Semi_FinishedProductReceivingReq detailData;

    //是否收货
    private boolean isReceive=false;
    //震动
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxbcpshdialog);
        initView();
        initData();
    }

    private void initView() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        mYes = (Button) findViewById(R.id.yes);
        mYes.setOnClickListener(this);
        mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);
        listview1=findViewById(R.id.listview1);


        detailData=new Semi_FinishedProductReceivingReq();

        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

        presenter2=new Semi_FinishedProductReceivingPresenter();
        presenter2.setView(this);
    }

    private void initData() {
        //username
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
        Intent intent =getIntent();
        materialCode=intent.getStringExtra("materialCode");
        pmaterialCode=intent.getStringExtra("pmaterialCode");
        kinds=intent.getStringExtra("kinds");
        factoryNO=intent.getStringExtra("factoryNO");
        marketorderno=intent.getStringExtra("marketorderno");
        marketorderrow=intent.getStringExtra("marketorderrow");
        dhsl=intent.getFloatExtra("dhsl",0);
        receiveReq = (Semi_FinishedProductReceivingReq)intent.getSerializableExtra("receiveReq");
        if(kinds.equals("20")){
            presenter1.CGSHReceiveDetail(marketorderno,marketorderrow,materialCode,"2090",dhsl);
        }else {
            presenter1.CGSHReceiveDetail(marketorderno,marketorderrow,pmaterialCode,"2090",dhsl);
        }

//        presenter1.CGSHReceiveDetail("DQ5095000031","2010",2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yes:
                vibrator.vibrate(30);
                isReceive=true;
                List<Semi_FinishedProductReceivingReqBean> productOrder = new ArrayList<>();
                float receinum=0;
                if(datas!=null){
                    //获取要传递的分堆信息
                    for (int i = 0; i < datas.size(); i++) {
                        PreMaterialProductOrderRep rep = datas.get(i);
                        View listItem=listview1.getAdapter().getView(i,null,null);
                        TextView tv1=listItem.findViewById(R.id.scddh);
                        EditText et1=listItem.findViewById(R.id.fpsl);
                        String orderNo=tv1.getText().toString();
                        float issueNum=0;
                        if(et1.getText().toString().equals("")||et1.getText().toString()==null){

                        }else {
                            issueNum=Float.parseFloat(("0"+et1.getText().toString()));
                        }
                        if(issueNum>0){
                            receinum+=issueNum;
                            Semi_FinishedProductReceivingReqBean bean=new Semi_FinishedProductReceivingReqBean(rep.getDemandNum(), rep.getKDAUF(), rep.getKDPOS(), rep.getMAKTX(), rep.getMATNR(), rep.getRSART(), rep.getRSNUM(), rep.getRSPOS(), rep.getDispatchNum(), rep.getProductOrderNO(), rep.getProOrderDesc(), rep.getProOrderMaterialCode(), rep.getProOrderMaterialDesc(), rep.getProOrderMaterialUnit(), rep.getFactory(), rep.getStorage(), rep.getMCODE(), issueNum);
                            productOrder.add(bean);
                        }

                    }
                }
                receiveReq.setProductOrder(productOrder);
                presenter2.Semi_FinishedProductReceiving(receiveReq);
//                Toast.makeText(WXBCPSHDialogActivity.this,"外协103预入库成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                isReceive=false;
                finish();
                break;
        }
    }

    @Override
    public void finish(){
        float receinum=0;

        Intent data = new Intent();
        data.putExtra("allNum",receinum);
        data.putExtra("isReceive",isReceive);
        data.putExtra("AdvanceStorageId",AdvanceStorageId);

        //同上
        this.setResult(RESULT_OK,data);
        //销毁当前Activity必须放到最后
        super.finish();
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
//        System.out.println("103成功");
        datas=data.getData();
//        System.out.println("总数量:"+dhsl);
        if(datas!=null){
            adapter=new WXBCPSHDialogAdapter(WXBCPSHDialogActivity.this, R.layout.wxbcpshdialogitem,datas);
            listview1.setAdapter(adapter);
        }
        Toast.makeText(WXBCPSHDialogActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDataSuccess2(Semi_FinishedProductReceivingRep data) {
        if(data.getCode()==1){
            Toast.makeText(WXBCPSHDialogActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
            AdvanceStorageId=data.getAdvanceStorageId();
            this.finish();
        }else {
            DialogUtil.errorMessageDialog(WXBCPSHDialogActivity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {

    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
}
