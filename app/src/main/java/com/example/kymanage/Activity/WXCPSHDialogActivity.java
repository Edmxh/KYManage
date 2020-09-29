package com.example.kymanage.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter2;
import com.example.kymanage.Adapter.WXCPSHDialog1Adapter;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.AUFNRBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRepBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReq;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.UPAUFNRBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView4;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHReceiveDetailPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.OutsourceFinishedProductReceivingJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2.PreMaterialProductOrderJSPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXCPSHDialogActivity extends BaseActivity implements BaseView1<PreMaterialProductOrderReps>, BaseView2<OutsourceFinishedProductReceivingJSRep>, BaseView4<PreMaterialProductOrderReps> {


    //震动
    private Vibrator vibrator;
//扫描相关
//    private String m_Broadcastname="com.barcode.sendBroadcast";
//    private MyCodeReceiver receiver = new MyCodeReceiver();

    private String scanString;
    //username
    private String username;

    //选择上游生产订单物料编码
    private View ll_scdd;

    //查看本事业部生产订单与上游事业部生产订单
    private RadioGroup radiogroup1;
    private RadioButton rb1;
    private RadioButton rb2;

    private ListView listview1;
    private WXCPSHDialog1Adapter adapter1;
    private CGSHReceiveDetailPresenter presenter1;
    private List<PreMaterialProductOrderRep> productOrderList1;

    private ListView listview2;
    private WXBCPJGRKAdapter2 adapter2;
    private PreMaterialProductOrderJSPresenter presenter4;
    private List<PreMaterialProductOrderRep> productOrderList2;

    /**
     * 确定
     */
    private Button yes;
    private OutsourceFinishedProductReceivingJSPresenter presenter2;
    /**
     * 取消
     */
    private Button cancel;

    //传递的数据
    private String materialCode;
    private String factoryNO;
    private String marketorderno;
    private String marketorderrow;
    private float dhsl;
    private String kinds;
    private GetPurchaseOrderInfoJSRep selectListData;

    //是否收货
    private boolean isReceive=false;
    //收货成功后返回的打印数据
    private OutsourceFinishedProductReceivingJSRepBean printReq;
    private ArrayList<Integer> printReqs;
    private boolean autoReceive=false;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxcpshdialog;
    }

    @Override
    public void initview() {
        //震动
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

        //选本事业部和上游事业部按钮组
        radiogroup1=findViewById(R.id.radiogroup1);
        rb1=findViewById(R.id.ben);
        rb2=findViewById(R.id.shangyou);

        listview1 = (ListView) findViewById(R.id.listview1);
        listview2 = (ListView) findViewById(R.id.listview2);
        listview1.setVisibility(View.GONE);
        listview2.setVisibility(View.GONE);
        yes = (Button) findViewById(R.id.yes);
        cancel = (Button) findViewById(R.id.cancel);


        //获取本事业部生产订单
        presenter1=new CGSHReceiveDetailPresenter();
        presenter1.setView(this);

        //获取上游事业部生产订单
        presenter4=new PreMaterialProductOrderJSPresenter();
        presenter4.setView(this);

        //成品收货
        presenter2=new OutsourceFinishedProductReceivingJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
        Intent intent =getIntent();
        materialCode=intent.getStringExtra("materialCode");
        factoryNO=intent.getStringExtra("factoryNO");
        marketorderno=intent.getStringExtra("marketorderno");
        marketorderrow=intent.getStringExtra("marketorderrow");
        dhsl=intent.getFloatExtra("dhsl",0);
        kinds=intent.getStringExtra("kinds");
        selectListData = (GetPurchaseOrderInfoJSRep)intent.getSerializableExtra("selectListData");
        presenter1.CGSHReceiveDetail(marketorderno,marketorderrow,materialCode,"2090",dhsl);

        printReq=new OutsourceFinishedProductReceivingJSRepBean();
        printReqs=new ArrayList<Integer>();

        productOrderList1=new ArrayList<PreMaterialProductOrderRep>();
        productOrderList2=new ArrayList<PreMaterialProductOrderRep>();
    }

    @Override
    public void initLisenter() {

        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 获取选中的RadioButton的id
                int id = group.getCheckedRadioButtonId();
                // 通过id实例化选中的这个RadioButton
                RadioButton choise = (RadioButton) findViewById(id);
                // 获取这个RadioButton的text内容
                String output = choise.getText().toString();
                if(output.equals("本事业部")){
//                    System.out.println("选择了本事业部生产订单");
                    switchContent1();
                }else {
                    autoReceive=false;
                    switchContent2();
                }
//                Toast.makeText(WXCPSHActivity.this, "你选择了：" + output, Toast.LENGTH_SHORT).show();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                isReceive=true;
                //点击确定按钮进行收货
                LoadingBar.dialog(WXCPSHDialogActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
                autoReceive=true;
                autoLoadContent2();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                //点击取消按钮关闭弹窗
                isReceive=false;
                WXCPSHDialogActivity.this.finish();
            }
        });
    }

    //收货方法
    public void receive(){
        List<AUFNRBean> AUFNRs = new ArrayList<AUFNRBean>();
        List<UPAUFNRBean> UPAUFNRs = new ArrayList<UPAUFNRBean>();
        boolean rece=true;
        float allnum1=0;
        float allnum2=0;
        for (int i = 0; i < productOrderList1.size(); i++) {
            PreMaterialProductOrderRep currBean1 = productOrderList1.get(i);
            View itmeview=listview1.getAdapter().getView(i,null,null);
            EditText et=itmeview.findViewById(R.id.fpsl);
            CheckBox cb= itmeview.findViewById(R.id.checked);
            if(cb.isChecked()){
                String numstr=et.getText().toString();
                float num = Float.parseFloat("0"+numstr);
                if(num>0){
                    allnum1+=num;
//                System.out.println("num1=="+num);
                    AUFNRBean AUFNR=new AUFNRBean(currBean1.getProductOrderNO(), currBean1.getRSNUM(), currBean1.getRSPOS(), currBean1.getProOrderMaterialCode(), currBean1.getProOrderMaterialDesc(), currBean1.getProOrderMaterialUnit(), currBean1.getRSART(), currBean1.getMCODE(), currBean1.getStorage(), currBean1.getDemandNum(), num, currBean1.getDispatchNum());
                    AUFNRs.add(AUFNR);
                }

            }
        }

        for (int i = 0; i < productOrderList2.size(); i++) {
            PreMaterialProductOrderRep currBean2 = productOrderList2.get(i);
            float num = currBean2.getCurrentNum();
            if(num>0){
                allnum2+=num;
                UPAUFNRBean UPAUFNR=new UPAUFNRBean(currBean2.getProductOrderNO(), currBean2.getRSNUM(), currBean2.getRSPOS(), currBean2.getProOrderMaterialCode(), currBean2.getProOrderMaterialDesc(), currBean2.getProOrderMaterialUnit(), currBean2.getRSART(), currBean2.getMCODE(), currBean2.getStorage(), currBean2.getDemandNum(), num, currBean2.getDispatchNum(),currBean2.getMATNR(),currBean2.getMAKTX(),currBean2.getMEINS());
                UPAUFNRs.add(UPAUFNR);
            }
        }
        float allnum = dhsl;
        float mqty=allnum-allnum2>0?(allnum-allnum2):0;
        //若没有本事业部生产订单
        if(productOrderList1.size()==0){
            allnum1=allnum;
        }else {
            //若有本事业部生产订单,循环本事业部生产订单，确保对应的上游事业部生产订单分配数量都小于本事业部生产订单分配数量
            for (AUFNRBean aufnrBean : AUFNRs) {
                String pmatnr = aufnrBean.getPMATNR();
                float qty1 = aufnrBean.getPIssueQty();//本事业部订单分配数量
//                System.out.println("本事业部共分配:"+qty1);
                float qty2=0;//上游订单分配数量
                for (UPAUFNRBean upaufnr : UPAUFNRs) {
                    //物料编码相同，则可本事业部生产订单与上游事业部生产订单对应起来
                    if(upaufnr.getPMATNR().equals(pmatnr)){
                        qty2+=upaufnr.getUPPIssueQty();
                        System.out.println("--"+upaufnr.getUPPIssueQty()+"--");
                    }
                }
//                System.out.println("上游事业部共分配:"+qty2);
                if(qty2>qty1){
                    rece=false;
                    break;
                }
            }
        }
        System.out.println(rece);
        System.out.println(allnum);
        System.out.println(allnum2);
        if(rece&&allnum2<=allnum&&allnum1<=allnum){
            OutsourceFinishedProductReceivingJSReq req=new OutsourceFinishedProductReceivingJSReq(getCurrentdate(), getCurrentdate(), username, marketorderno, marketorderrow, selectListData.getEBELN(), selectListData.getEBELP(), factoryNO, selectListData.getWERKS(), selectListData.getLGFSB(), selectListData.getMATNR(), selectListData.getTXZ01(), selectListData.getMaterialType(),selectListData.getMEINS(), selectListData.getMENGE(), selectListData.getInStorage(), allnum, selectListData.getCGTXT(), selectListData.getKINDS(), selectListData.getAUFNR(), selectListData.getPMATN(), selectListData.getMCODE(), selectListData.getMAKTX(), AUFNRs, UPAUFNRs);
//            System.out.println("生产订单号"+selectListData.getAUFNR()+"--"+selectListData.getPMATN());
            presenter2.OutsourceFinishedProductReceivingJS(req);
        } else {
            Toast.makeText(this, "分配数量有误", Toast.LENGTH_SHORT).show();
        }
    }

    public void switchContent1() {
        listview1.setVisibility(View.VISIBLE);
        listview2.setVisibility(View.GONE);
    }

    public void switchContent2() {
        listview1.setVisibility(View.GONE);
        listview2.setVisibility(View.VISIBLE);
        List<PreMaterialProductOrderJSReqBean> materialCodeArr=new ArrayList<PreMaterialProductOrderJSReqBean>();
//        float allnum = Float.parseFloat("0"+allnumStr);//直接传过来
        if(productOrderList1.size()==0){
            //当本事业部没有生产订单时，直接用采购订单信息中的物料编码去获取上游生产订单
            PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(materialCode,dhsl);
            materialCodeArr.add(bean);
        }else {
            for (int i = 0; i < productOrderList1.size(); i++) {
                String code=productOrderList1.get(i).getProOrderMaterialCode();
                float num0=productOrderList1.get(i).getCurrentNum();
                boolean dup=false;
                int ind=0;
                for (int j = 0; j < materialCodeArr.size(); j++) {
                    if(materialCodeArr.get(j).getMaterialCode().equals(code)){
                        ind=j;
                        dup=true;
                        break;
                    }
                }
                //物料未重复，则传参添加；物料重复，则只增加数量
                if(dup==false){
                    PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(code,num0);
                    materialCodeArr.add(bean);
                }else {
                    float num00=materialCodeArr.get(ind).getMatnrCurrentNum()+num0;
                    materialCodeArr.get(ind).setMatnrCurrentNum(num00);
                }
            }
        }
        //销售订单号为空则不查上游订单
        if(!marketorderno.equals("")){
            presenter4.PreMaterialProductOrderJS(marketorderno,marketorderrow,materialCodeArr,factoryNO);
        }

    }

    public void autoLoadContent2() {
        List<PreMaterialProductOrderJSReqBean> materialCodeArr=new ArrayList<PreMaterialProductOrderJSReqBean>();
//        float allnum = Float.parseFloat("0"+allnumStr);//直接传过来
        if(productOrderList1.size()==0){
            //当本事业部没有生产订单时，直接用采购订单信息中的物料编码去获取上游生产订单
            PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(materialCode,dhsl);
            materialCodeArr.add(bean);
        }else {
            for (int i = 0; i < productOrderList1.size(); i++) {
                String code=productOrderList1.get(i).getProOrderMaterialCode();
                float num0=productOrderList1.get(i).getCurrentNum();
                boolean dup=false;
                int ind=0;
                for (int j = 0; j < materialCodeArr.size(); j++) {
                    if(materialCodeArr.get(j).getMaterialCode().equals(code)){
                        ind=j;
                        dup=true;
                        break;
                    }
                }
                //物料未重复，则传参添加；物料重复，则只增加数量
                if(dup==false){
                    PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(code,num0);
                    materialCodeArr.add(bean);
                }else {
                    float num00=materialCodeArr.get(ind).getMatnrCurrentNum()+num0;
                    materialCodeArr.get(ind).setMatnrCurrentNum(num00);
                }
            }
        }
        //销售订单号为空则不查上游订单
        if(!marketorderno.equals("")){
            presenter4.PreMaterialProductOrderJS(marketorderno,marketorderrow,materialCodeArr,factoryNO);
        }
    }

    @Override
    public void onDataSuccess1(PreMaterialProductOrderReps data) {
        productOrderList1 = data.getData();
        adapter1=new WXCPSHDialog1Adapter(WXCPSHDialogActivity.this, R.layout.wxcpshitem1, productOrderList1);
        listview1.setAdapter(adapter1);
        radiogroup1.check(R.id.ben);
    }

    @Override
    public void onDataSuccess4(PreMaterialProductOrderReps data) {
        productOrderList2 = data.getData();
        adapter2=new WXBCPJGRKAdapter2(WXCPSHDialogActivity.this, R.layout.wxcpshitem2, productOrderList2);
        listview2.setAdapter(adapter2);
        if(autoReceive){
            receive();
        }
    }

    @Override
    public void onDataSuccess2(OutsourceFinishedProductReceivingJSRep data) {
        LoadingBar.dialog(WXCPSHDialogActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            printReq=data.getData();
            printReqs=data.getAllocatedId();
            this.finish();
        }else {
            DialogUtil.errorMessageDialog(WXCPSHDialogActivity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXCPSHDialogActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
    }

    //关闭activity传参
    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("isReceive",isReceive);
        data.putExtra("printReq",printReq);
        data.putIntegerArrayListExtra("printReqs",printReqs);
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
}
