package com.example.kymanage.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Layout;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kymanage.Adapter.CGDialogAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailrep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Req;
import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.UpdateStorage.UpdateStorageReq;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.CGSH103ReceivePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.CGPage1.CG103SHReceivePresenter;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.ReceiveView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CGDDDialogActivity extends AppCompatActivity implements View.OnClickListener, BaseView1<PreMaterialProductOrderReps>, BaseView2<MaterialFlow103Rep> {

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
    private float dhsl;
    private int index;
    private String username;
    //adapter
    private CGDialogAdapter adapter;
    //103入库参数
    private List<UpdateStorageReq> reqList;
    //获取数据
    private CGSHReceiveDetailPresenter presenter1;

    private CG103SHReceivePresenter presenter2;

    private List<ProductOrderBean> products;

    private float allNum;

    private GetRecevingDetailrep checkedData;

    //是否收货
    private boolean isReceive=false;

    //收货返回的标签AdvanceStorageId
    private Long AdvanceStorageId;
    //震动
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgdddialog);
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
        mYes = (Button) findViewById(R.id.yes);
        mYes.setOnClickListener(this);
        mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(this);

        listview1=findViewById(R.id.listview1);

        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

        presenter2=new CG103SHReceivePresenter();
        presenter2.setView(this);
    }
    private void initData() {
        Intent intent =getIntent();
        materialCode=intent.getStringExtra("materialCode");
        factoryNO=intent.getStringExtra("factoryNO");
        dhsl=intent.getFloatExtra("dhsl",0);
        index=intent.getIntExtra("index",0);
        username=intent.getStringExtra("username");
        checkedData = (GetRecevingDetailrep)intent.getSerializableExtra("checkedData");
        presenter1.CGSHReceiveDetail("","",materialCode,factoryNO,dhsl);

        datas=new ArrayList<PreMaterialProductOrderRep>();
        products=new ArrayList<ProductOrderBean>();
//        DemoBean1 bean1=new DemoBean1("特急","00000001","2020-04-15","","",5,5);
//        DemoBean1 bean2=new DemoBean1("加急","00000002","2020-04-15","","",4,4);
//        DemoBean1 bean3=new DemoBean1("正常","00000003","2020-04-15","","",3,1);
//        datas.add(bean1);
//        datas.add(bean2);
//        datas.add(bean3);


        reqList=new ArrayList<UpdateStorageReq>();
//        ProductOrderBean productOrderBean1=new ProductOrderBean("12124",2);
//        ProductOrderBean productOrderBean2=new ProductOrderBean("12124",3);

//        products.add(productOrderBean1);
//        products.add(productOrderBean2);
        UpdateStorageReq req1=new UpdateStorageReq(getCurrentdate(), getCurrentdate(), "12441", 5, "orderNum", "orderRow", "cs001", "专有", "2010", "机器人", "E", "remark",products);
        reqList.add(req1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yes:
//                Toast.makeText(CGDDDialogActivity.this,"采购103预入库成功",Toast.LENGTH_SHORT).show();
//                presenter2.CG103SHReceive("2020-01-01", getCurrentdate(), username, 5, "orderNum", "orderRow", "cs001", "专有", "2010", "机器人", "E", "remark",products);
                vibrator.vibrate(30);
                List<ProductOrderBean> productOrder = new ArrayList<>();
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
                        ProductOrderBean bean=new ProductOrderBean(orderNo,issueNum,rep.getKDAUF(), rep.getKDPOS(), rep.getRSNUM(), rep.getRSPOS(), rep.getMATNR(), rep.getMAKTX(), rep.getDemandNum(),rep.getRSART(),rep.getZSERNR(),rep.getProOrderDesc(),rep.getProOrderMaterialDesc(),rep.getProOrderMaterialCode(),rep.getProOrderMaterialUnit());
                        productOrder.add(bean);
                    }
                }

//                presenter2.CG103SHReceive("2020-01-01",getCurrentdate(),username,receinum,checkedData.getOrderNum(),checkedData.getRow(),checkedData.getCode(),checkedData.getMaterialType(),checkedData.getFactory(),checkedData.getDescription(),checkedData.getUnit(),checkedData.getRemark(),productOrder);
                List<MaterialFlow103Req> detail=new ArrayList<MaterialFlow103Req>();
                MaterialFlow103Req req=new MaterialFlow103Req(dhsl,checkedData.getOrderNum(),checkedData.getRow(),checkedData.getCode(),checkedData.getMaterialType(),checkedData.getFactory(),checkedData.getLGFSB(),checkedData.getDescription(),checkedData.getUnit(),checkedData.getRemark(),productOrder);
                detail.add(req);
                if(dhsl>=receinum){
                    presenter2.CG103SHReceive(getCurrentdate(),getCurrentdate(),username,detail);
                    isReceive=true;
                }else {
                    Toast.makeText(this, "输入总数量超出，请重新输入", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.cancel:
                vibrator.vibrate(30);
                CGDDDialogActivity.this.finish();
                break;
        }
    }

    @Override
    public void finish(){
        List<ProductOrderBean> productOrder = new ArrayList<>();
        float receinum=0;
        if(datas!=null){
            //获取要传递的分堆信息
            for (int i = 0; i < datas.size(); i++) {
                PreMaterialProductOrderRep rep = datas.get(i);
//                View listItem=listview1.getChildAt(i - listview1.getFirstVisiblePosition());
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
                ProductOrderBean bean=new ProductOrderBean(orderNo,issueNum,rep.getKDAUF(), rep.getKDPOS(), rep.getRSNUM(), rep.getRSPOS(), rep.getMATNR(), rep.getMAKTX(), rep.getDemandNum(),rep.getRSART(),rep.getZSERNR(),rep.getProOrderDesc(),rep.getProOrderMaterialDesc(),rep.getProOrderMaterialCode(),rep.getProOrderMaterialUnit());
                productOrder.add(bean);
            }
        }
        Intent data = new Intent();
        data.putExtra("productOrder",(Serializable) productOrder);
        data.putExtra("index",index);
        data.putExtra("allNum",receinum);
        data.putExtra("isReceive",isReceive);
        data.putExtra("AdvanceStorageId",AdvanceStorageId);
//        System.out.println("1传递的生产订单信息是："+productOrder.toString());
        System.out.println("1传递的AdvanceStorageId是："+AdvanceStorageId);

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
            adapter=new CGDialogAdapter(CGDDDialogActivity.this, R.layout.cgdddialogitem,datas);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(new ListViewItemOnClick());
        }
        Toast.makeText(CGDDDialogActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onDataSuccess2(MaterialFlow103Rep data) {

        Toast.makeText(this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        if(data.getStatus().getData()!=null&&data.getStatus().getData().size()>0){
            System.out.println(data.getStatus().getData().size());
            System.out.println(data.getStatus().getData().get(0));
            AdvanceStorageId=data.getStatus().getData().get(0);
        }
        CGDDDialogActivity.this.finish();
    }

    @Override
    public void onFailed(String msg) {
//        System.out.println("103失败");
//        System.out.println(msg);
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            View itme=listview1.getChildAt(position);
//            View itme=listview1.getChildAt(position - listview1.getFirstVisiblePosition());
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
