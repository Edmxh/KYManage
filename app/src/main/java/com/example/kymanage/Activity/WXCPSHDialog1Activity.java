package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.CGDialogAdapter;
import com.example.kymanage.Adapter.WXBCPJGRKDialog1Adapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean1;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean2;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXCPSHDialog1Activity extends AppCompatActivity implements BaseView1<PreMaterialProductOrderReps>, WXBCPJGRKDialog1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    private static final int REQUEST_CODE_1 = 1;

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
    private float receNum;
    private OutsourceFinishedProductReceivingJSReqBean2 inProduct;
//adapter
    List<PreMaterialProductOrderRep> listData;
    private WXBCPJGRKDialog1Adapter adapter;
    //确认
    private boolean confirm=false;
    //震动
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxbcpjgrkdialog1);
        initView();
        initData();
    }

    private void initView() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        mListview1 = (ListView) findViewById(R.id.listview1);

        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

    }

    private void initData() {
        inProduct=new OutsourceFinishedProductReceivingJSReqBean2();
        listData=new ArrayList<PreMaterialProductOrderRep>();
        Intent intent=getIntent();
        I_INKDPOS=intent.getStringExtra("I_INKDPOS");
        I_INMATNR=intent.getStringExtra("I_INMATNR");
        I_INKDAUF=intent.getStringExtra("I_INKDAUF");
        dhsl=intent.getFloatExtra("dhsl",0);
        index=intent.getIntExtra("index",0);
        username=intent.getStringExtra("username");
        MaterialType=intent.getStringExtra("type");
        System.out.println(I_INKDPOS+"/"+I_INMATNR+"/"+I_INKDAUF);
        //适配
//        adapter=new CGDialogTestAdapter(WXBCPJGRKDialog1Activity.this, R.layout.cgdddialogitem,datas);
//        mListview1.setAdapter(adapter);
        presenter1.CGSHReceiveDetail(I_INKDAUF, I_INKDPOS,I_INMATNR,"2090",dhsl);
    }

    @Override
    public void finish(){

        Intent data = new Intent();
        data.putExtra("index",index);
        data.putExtra("allNum",receNum);
        Bundle bundle = new Bundle();
        bundle.putSerializable("inProduct", inProduct);
        data.putExtras(bundle);
        data.putExtra("confirm",confirm);

        //同上
        this.setResult(RESULT_OK,data);
        //销毁当前Activity必须放到最后
        super.finish();
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        Toast.makeText(this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        listData = data.getData();
        try {
            if(listData.size()==0){
                System.out.println("dhsl:"+dhsl);
                receNum=dhsl;
                confirm=true;
                this.finish();
            }else {
                adapter=new WXBCPJGRKDialog1Adapter(WXCPSHDialog1Activity.this, R.layout.wxbcpjgrkdialog1item, listData);
                adapter.setOnInnerItemOnClickListener(this);
                mListview1.setAdapter(adapter);
                mListview1.setOnItemClickListener(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            case R.id.receive:
                vibrator.vibrate(30);
                Log.e("内部receive>>", position + "");
                PreMaterialProductOrderRep checkedData = listData.get(position);
                confirm=true;
                //选中的item输入的数量
                View itme=mListview1.getChildAt(position - mListview1.getFirstVisiblePosition());
                TextView et= itme.findViewById(R.id.rksl);
                Spinner sp= itme.findViewById(R.id.spinner1);
                receNum=Float.parseFloat(("0"+et.getText().toString()));

                //选中的需求仓库
                int selectedItemPosition = sp.getSelectedItemPosition();
//                System.out.println("选中的仓库index:"+selectedItemPosition);
                String storage= checkedData.getSAPStorage().getArray().get(selectedItemPosition).getId();
                //
                inProduct=new OutsourceFinishedProductReceivingJSReqBean2(I_INKDAUF, I_INKDPOS, checkedData.getProductOrderNO(), checkedData.getMATNR(), checkedData.getMAKTX(), checkedData.getMEINS(), checkedData.getProOrderMaterialCode(), checkedData.getProOrderMaterialDesc(), checkedData.getProOrderMaterialUnit(), checkedData.getRSNUM(), checkedData.getRSPOS(), checkedData.getDemandNum(), receNum, checkedData.getMCODE(), checkedData.getRSART());
                //
                this.finish();
                break;
            default:
                break;
        }
    }
}
