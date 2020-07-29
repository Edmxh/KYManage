package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kymanage.Adapter.WXBCPJGRKDialog2Adapter;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean1;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WXBCPJGRKDialog2Activity extends AppCompatActivity implements View.OnClickListener, BaseView1<PreMaterialProductOrderReps> {
    private static final int REQUEST_CODE_2 = 2;
    private ListView mListview1;
    private CGSHReceiveDetailPresenter presenter1;
    /**
     * 确定
     */
    private Button mYes;
    /**
     * 取消
     */
    private Button mCancel;

    //接收的值
    //接收的值
    private String I_INKDPOS;
    private String I_INMATNR;
    private String I_INKDAUF;
    private String marketorderno;
    private String marketorderrow;
    private float dhsl;
    private int index;
    private String username;
    private String MaterialType;

    //传递的数据
    private List<InsertFinProStorageRecordReqBean1> detail;
    //adapter
    List<PreMaterialProductOrderRep> listData;
    private WXBCPJGRKDialog2Adapter adapter;
    //确认
    private boolean confirm = false;
    //震动
    private Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxbcpjgrkdialog2);
        initView();
        initData();
    }

    private void initView() {
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mListview1 = (ListView) findViewById(R.id.listview1);

        presenter1 = new CGSHReceiveDetailPresenter();
        presenter1.setView(this);
        mYes = (Button) findViewById(R.id.yes);
        mYes.setOnClickListener(this);
        mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);
    }
    private void initData() {
        listData = new ArrayList<PreMaterialProductOrderRep>();
        Intent intent = getIntent();
        I_INKDPOS = intent.getStringExtra("I_INKDPOS");
        I_INMATNR = intent.getStringExtra("I_INMATNR");
        I_INKDAUF = intent.getStringExtra("I_INKDAUF");
        dhsl = intent.getFloatExtra("limitNum", 0);
        index = intent.getIntExtra("index", 0);
        username = intent.getStringExtra("username");
        MaterialType = intent.getStringExtra("type");
        System.out.println(I_INKDPOS + "/" + I_INMATNR + "/" + I_INKDAUF);
        //适配
//        adapter=new CGDialogTestAdapter(WXBCPJGRKDialog1Activity.this, R.layout.cgdddialogitem,datas);
//        mListview1.setAdapter(adapter);
        presenter1.CGSHReceiveDetail(I_INKDAUF, I_INKDPOS, I_INMATNR, "", dhsl);

//        datas=new ArrayList<GetOutStorageMaterialOrderJSRepBean>();

        detail=new ArrayList<InsertFinProStorageRecordReqBean1>();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.yes:
                vibrator.vibrate(30);
                confirm=true;
                float allNum=0;
                for (int i = 0; i < listData.size(); i++) {
//                    PreMaterialProductOrderRep currData = datas.get(i);
                    PreMaterialProductOrderRep currData = listData.get(i);
                    View itme=mListview1.getChildAt(i - mListview1.getFirstVisiblePosition());
                    //选中的需求仓库
                    Spinner sp= itme.findViewById(R.id.spinner1);
                    int selectedItemPosition = sp.getSelectedItemPosition();
                    String storage= currData.getSAPStorage().getArray().get(selectedItemPosition).getId();

                    //输入的数量
                    EditText et= itme.findViewById(R.id.rksl);
                    float recenum=Float.parseFloat(("0"+et.getText().toString()));

                    if(recenum!=0){
                        InsertFinProStorageRecordReqBean1 bean=new InsertFinProStorageRecordReqBean1(currData.getFactory(),storage, currData.getKDAUF(), currData.getKDPOS(), currData.getProductOrderNO(), currData.getProOrderDesc(),currData.getProOrderMaterialCode(), currData.getProOrderMaterialDesc(), currData.getProOrderMaterialUnit(), currData.getDemandNum(), recenum,currData.getAllocatedNum(), currData.getRSNUM(), currData.getRSPOS(),currData.getMCODE());
                        detail.add(bean);
                        allNum+=recenum;
                    }
                }
                if(allNum>dhsl){
                    Toast.makeText(WXBCPJGRKDialog2Activity.this, "填写数量超出,请重试", Toast.LENGTH_SHORT).show();
                }else {
                    WXBCPJGRKDialog2Activity.this.finish();
                }

                break;
            case R.id.cancel:
                vibrator.vibrate(30);
                WXBCPJGRKDialog2Activity.this.finish();
                break;
        }
    }

    @Override
    public void finish(){

        Intent data = new Intent();
        data.putExtra("confirm",confirm);
        data.putExtra("index",index);
        data.putExtra("detail",(Serializable) detail);

        //同上
        this.setResult(REQUEST_CODE_2,data);
        //销毁当前Activity必须放到最后
        super.finish();
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        listData = data.getData();
        try {
            adapter = new WXBCPJGRKDialog2Adapter(WXBCPJGRKDialog2Activity.this, R.layout.wxbcpjgrkdialog2item, listData);
//            adapter.setOnInnerItemOnClickListener(this);
            mListview1.setAdapter(adapter);
//            mListview1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailed(String msg) {

    }
}
