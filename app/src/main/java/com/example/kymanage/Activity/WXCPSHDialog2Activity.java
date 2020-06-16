package com.example.kymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kymanage.Adapter.WXBCPJGRKDialog2Adapter;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean1;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXCPSHDialog2Activity extends AppCompatActivity implements BaseView1<PreMaterialProductOrderReps>, View.OnClickListener {
    private static final int REQUEST_CODE_2 = 2;
    private ListView mListview1;
    private CGSHReceiveDetailPresenter presenter1;

    //接收的值
    private String I_INKDPOS;
    private String I_INMATNR;
    private String I_INKDAUF;
    private float dhsl;
    private int index;
    private String username;
    private String MaterialType;
    //传递的值
    private List<OutsourceFinishedProductReceivingJSReqBean1> outProduct;
    //adapter
    List<PreMaterialProductOrderRep> listData;
    private WXBCPJGRKDialog2Adapter adapter;
    //确认
    private boolean confirm = false;
    //震动
    private Vibrator vibrator;
    /**
     * 确定
     */
    private Button mYes;
    /**
     * 取消
     */
    private Button mCancel;

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
        outProduct=new ArrayList<OutsourceFinishedProductReceivingJSReqBean1>();
        listData = new ArrayList<PreMaterialProductOrderRep>();
        Intent intent = getIntent();
        I_INKDPOS = intent.getStringExtra("I_INKDPOS");
        I_INMATNR = intent.getStringExtra("I_INMATNR");
        I_INKDAUF = intent.getStringExtra("I_INKDAUF");
        dhsl = intent.getFloatExtra("dhsl", 0);
        index = intent.getIntExtra("index", 0);
        username = intent.getStringExtra("username");
        MaterialType = intent.getStringExtra("type");
        System.out.println(I_INKDPOS + "/" + I_INMATNR + "/" + I_INKDAUF);
        //适配
//        adapter=new CGDialogTestAdapter(WXBCPJGRKDialog1Activity.this, R.layout.cgdddialogitem,datas);
//        mListview1.setAdapter(adapter);
        presenter1.CGSHReceiveDetail(I_INKDAUF, I_INKDPOS, I_INMATNR, "", dhsl);
    }

    @Override
    public void finish() {

        Intent data = new Intent();
        data.putExtra("index", index);

//        data.putExtra("allNum",receNum);
        Bundle bundle = new Bundle();
        bundle.putSerializable("outProduct", (Serializable) outProduct);
        data.putExtras(bundle);
        data.putExtra("confirm", confirm);

        //同上
        this.setResult(RESULT_OK, data);
        //销毁当前Activity必须放到最后
        super.finish();
    }

    //获取当前日期
    private String getCurrentdate() {
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        listData = data.getData();
        try {
            adapter = new WXBCPJGRKDialog2Adapter(WXCPSHDialog2Activity.this, R.layout.wxbcpjgrkdialog2item, listData);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yes:
                confirm=true;
                float allnum=0;
                for (int i = 0; i < listData.size(); i++) {
                    EditText et=mListview1.getChildAt(i - mListview1.getFirstVisiblePosition()).findViewById(R.id.rksl);
                    String recenumstr=et.getText().toString();
                    float num=Float.parseFloat(("0"+recenumstr));
                    allnum+=num;
                    PreMaterialProductOrderRep currData = listData.get(i);

                    //选中的需求仓库
                    View itme=mListview1.getChildAt(i - mListview1.getFirstVisiblePosition());
                    Spinner sp= itme.findViewById(R.id.spinner1);
                    int selectedItemPosition = sp.getSelectedItemPosition();
                    String storage= currData.getSAPStorage().getArray().get(selectedItemPosition).getId();

                    OutsourceFinishedProductReceivingJSReqBean1 bean1=new OutsourceFinishedProductReceivingJSReqBean1(currData.getKDAUF(), currData.getKDPOS(), currData.getProductOrderNO(), currData.getProOrderMaterialCode(), currData.getProOrderMaterialDesc(), currData.getRSNUM(), currData.getRSPOS(), currData.getDemandNum(), num, currData.getMCODE(), currData.getProOrderMaterialUnit(), currData.getRSART(), currData.getFactory(),storage,currData.getAllocatedNum());
                    outProduct.add(bean1);
                }
                if(allnum>dhsl){
                    Toast.makeText(this, "数量超出，请重试", Toast.LENGTH_SHORT).show();
                    outProduct.clear();
                }else {
                    this.finish();
                }

                break;
            case R.id.cancel:
                this.finish();
                break;
        }
    }
}
