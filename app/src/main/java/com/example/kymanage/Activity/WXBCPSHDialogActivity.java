package com.example.kymanage.Activity;

import android.content.Intent;
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
    private String factoryNO;
    private String marketorderno;
    private String marketorderrow;
    private float dhsl;
    private int index;
    private String username;
    private String demandStorage;
    private GetPurchaseOrderInfoJSRep checkedData;
    //返回的AdvanceStorageId
    private long AdvanceStorageId;
    //adapter
    private CGDialogAdapter adapter;
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
        Intent intent =getIntent();
        materialCode=intent.getStringExtra("materialCode");
        factoryNO=intent.getStringExtra("factoryNO");
        marketorderno=intent.getStringExtra("marketorderno");
        marketorderrow=intent.getStringExtra("marketorderrow");
        dhsl=intent.getFloatExtra("dhsl",0);
        index=intent.getIntExtra("index",0);
        username=intent.getStringExtra("username");
        demandStorage=intent.getStringExtra("demandStorage");
        checkedData = (GetPurchaseOrderInfoJSRep)intent.getSerializableExtra("checkedData");
        presenter1.CGSHReceiveDetail(marketorderno,marketorderrow,materialCode,factoryNO,dhsl);
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
                        receinum+=issueNum;
//                        Semi_FinishedProductReceivingReqBean bean=new Semi_FinishedProductReceivingReqBean(orderNo,issueNum,rep.getKDAUF(), rep.getKDPOS(), rep.getRSNUM(), rep.getRSPOS(), rep.getMATNR(), rep.getMAKTX(), rep.getDemandNum(),rep.getRSART(),rep.getProOrderDesc(),rep.getProOrderMaterialDesc(),rep.getProOrderMaterialCode(),rep.getProOrderMaterialUnit());
//                        productOrder.add(bean);
                    }
                }

//                presenter2.CG103SHReceive("2020-01-01",getCurrentdate(),username,receinum,checkedData.getOrderNum(),checkedData.getRow(),checkedData.getCode(),checkedData.getMaterialType(),checkedData.getFactory(),checkedData.getDescription(),checkedData.getUnit(),checkedData.getRemark(),productOrder);
                List<Semi_FinishedProductReceivingReq> detail=new ArrayList<Semi_FinishedProductReceivingReq>();
//                Semi_FinishedProductReceivingReq req=new Semi_FinishedProductReceivingReq(receinum,checkedData.getEBELN(),checkedData.getEBELP(),checkedData.getMATNR(),checkedData.getMaterialType(),checkedData.getWERKS(),demandStorage,checkedData.getTXZ01(),checkedData.getMEINS(),checkedData.getCGTXT(),productOrder);
//                detail.add(req);
//                presenter2.Semi_FinishedProductReceiving(getCurrentdate(),getCurrentdate(),username,req);
//                Toast.makeText(WXBCPSHDialogActivity.this,"外协103预入库成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                WXBCPSHDialogActivity.this.finish();
                break;
        }
    }

    @Override
    public void finish(){
        float receinum=0;

        Intent data = new Intent();
        data.putExtra("index",index);
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
            adapter=new CGDialogAdapter(WXBCPSHDialogActivity.this, R.layout.cgdddialogitem,datas);
            listview1.setAdapter(adapter);
        }
        Toast.makeText(WXBCPSHDialogActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDataSuccess2(Semi_FinishedProductReceivingRep data) {
        Toast.makeText(WXBCPSHDialogActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
        AdvanceStorageId=data.getStorageId();
        this.finish();
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
