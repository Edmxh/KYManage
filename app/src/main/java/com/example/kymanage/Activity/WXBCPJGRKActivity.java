package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter1;
import com.example.kymanage.Adapter.WXBCPJGRKAdapter2;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteReqBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean1;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReqBean2;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.WXPage2.PreMaterialProductOrderJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.InsertFinProStorageRecordPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Dialog1.GetOutStorageMaterialOrderJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Record.GetFinProStorageRecordNotePresenter;
import com.example.kymanage.utils.DialogUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Printer.PrintHelper;

public class WXBCPJGRKActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView1<GetOutStorageMaterialOrderJSRep>, BaseView2<InsertFinProStorageRecordRep>, BaseView3<GetFinProStorageRecordNoteRep>, BaseView4<PreMaterialProductOrderReps> {
    //震动
    private Vibrator vibrator;
    private ImageView scan;
    //scan
//扫描相关
    private String m_Broadcastname = "com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
//    private GetMaterialMasterDataJSPresenter presenter1;
//    private List<GetPurchaseOrderInfoJSRep> data1;
    private String scanString;
    private String marketorderno;
    private String marketorderrow;
    private float num;
    private String factory;
    //username
    private String username;
    //101
    private List<InsertFinProStorageRecordReq> reqs;
    private InsertFinProStorageRecordPresenter presenter2;


    //print
    private GetFinProStorageRecordNotePresenter presenter3;
    private List<GetFinProStorageRecordNoteReqBean> idlist;
    //打印类
    private PrintHelper printHelper = null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    /**
     * 自定义请求码常量
     */
    private static final int REQUEST_CODE_1 = 1;
    private static final int REQUEST_CODE_2 = 2;



    private ImageView menupoint;
    PopupMenu popup = null;
//    private ImageView record;

    //上方物料信息
    private View layout1;
    private TextView wlbm;
    private TextView xsddh_hang;
    private TextView gc;
    private TextView dhsl;
//    private EditText xlh;
    private View ll_scdd;
//    private Button scanxlh;

    //收货
    private Button receive;
    //
    private View layout2;
    //查看本事业部生产订单与上游事业部生产订单
    private RadioGroup radiogroup1;
    //ben
    private RadioButton rb1;
    private GetOutStorageMaterialOrderJSPresenter presenter4;
    private List<GetOutStorageMaterialOrderJSRepBean> productOrderList1;
    private WXBCPJGRKAdapter1 adapter1;
    private ListView listview1;

    //shangyou
    private RadioButton rb2;
    private PreMaterialProductOrderJSPresenter presenter5;
    private List<PreMaterialProductOrderRep> productOrderList2;
    private WXBCPJGRKAdapter2 adapter2;
    private ListView listview2;

    //全局变量
    private boolean autoReceive=false;
    //重复打印
    GetFinProStorageRecordNoteRep againPrint=new GetFinProStorageRecordNoteRep();
    boolean isAgain=false;



    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpjgrk;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
//        scanxlh=findViewById(R.id.scanxlh);

        receive=findViewById(R.id.receive);

        radiogroup1=findViewById(R.id.radiogroup1);
        rb1=findViewById(R.id.ben);
        rb2=findViewById(R.id.shangyou);

        layout1=findViewById(R.id.layout1);
        layout1.setVisibility(View.INVISIBLE);
        layout2=findViewById(R.id.layout2);
        layout2.setVisibility(View.INVISIBLE);
        ll_scdd=findViewById(R.id.ll_scdd);
        ll_scdd.setVisibility(View.INVISIBLE);



        wlbm=findViewById(R.id.wlbm);
        xsddh_hang=findViewById(R.id.xsddh_hang);
        gc=findViewById(R.id.gc);
        dhsl=findViewById(R.id.dhsl);
//        xlh=findViewById(R.id.xlh);

//        print=findViewById(R.id.print);
        menupoint=findViewById(R.id.menupoint);
//        record=findViewById(R.id.record);
        //表格
        listview1=findViewById(R.id.listview1);
        listview2=findViewById(R.id.listview2);

//        //获取物料主数据
//        presenter1=new GetMaterialMasterDataJSPresenter();
//        presenter1.setView(this);

        //101入库
        presenter2 = new InsertFinProStorageRecordPresenter();
        presenter2.setView(this);
        //标签打印
        presenter3 = new GetFinProStorageRecordNotePresenter();
        presenter3.setView(this);

        //获取本事业部生产订单
        presenter4=new GetOutStorageMaterialOrderJSPresenter();
        presenter4.setView(this);

        //获取上游事业部生产订单
        presenter5=new PreMaterialProductOrderJSPresenter();
        presenter5.setView(this);
    }

    @Override
    public void initData() {
//        //物料
//        material=new GetMaterialMasterDataInfo();
//        //扫描请求接口返回
//        data1=new ArrayList<GetPurchaseOrderInfoJSRep>();
        //本事业部生产订单接口返回
        productOrderList1=new ArrayList<GetOutStorageMaterialOrderJSRepBean>();
        //上游事业部生产订单接口返回
        productOrderList2=new ArrayList<PreMaterialProductOrderRep>();

        adapter2=new WXBCPJGRKAdapter2(WXBCPJGRKActivity.this, R.layout.wxbcprkitem2, productOrderList2);

        reqs = new ArrayList<InsertFinProStorageRecordReq>();
        idlist = new ArrayList<GetFinProStorageRecordNoteReqBean>();



        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        cb = new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                //确保扫描完毕scanString被赋值后才被解析
                Thread scanThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        scan();
                    }
                });
                scanThread.start();
                try {
                    Log.i("token", "scanThread.join();");
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
//        scanxlh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vibrator.vibrate(30);
//                scan();
//            }
//        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);
            }
        });
//        record.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vibrator.vibrate(30);
//                Intent intent = new Intent(WXBCPJGRKActivity.this, WXSHJLActivity.class);
//                intent.putExtra("username", username);
//                startActivity(intent);
//            }
//        });

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

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                autoReceive=true;
                autoLoadContent2();

            }
        });
    }

    public void receive(){
        List<InsertFinProStorageRecordReqBean2> ldata = new ArrayList<InsertFinProStorageRecordReqBean2>();
        List<InsertFinProStorageRecordReqBean1> sdata = new ArrayList<InsertFinProStorageRecordReqBean1>();
        boolean rece=true;
        float allnum1=0;
        float allnum2=0;
        for (int i = 0; i < productOrderList1.size(); i++) {
            GetOutStorageMaterialOrderJSRepBean currBean1 = productOrderList1.get(i);
            View itmeview=listview1.getAdapter().getView(i,null,null);
            EditText et=itmeview.findViewById(R.id.fpsl);
            CheckBox cb= itmeview.findViewById(R.id.checked);
            if(cb.isChecked()){
                String numstr=et.getText().toString();
                float num = Float.parseFloat("0"+numstr);
                if(num>0){
                    allnum1+=num;
//                System.out.println("num1=="+num);
                    InsertFinProStorageRecordReqBean2 bean2=new InsertFinProStorageRecordReqBean2(currBean1.getMATNR(), currBean1.getAUFNR(),currBean1.getWERKS(),currBean1.getLGORT(), num, marketorderno, marketorderrow, currBean1.getMEINS(), currBean1.getMCODE(), currBean1.getMAKTX());
                    ldata.add(bean2);
                }

            }
        }

        for (int i = 0; i < productOrderList2.size(); i++) {
            PreMaterialProductOrderRep currBean2 = productOrderList2.get(i);
            float num = currBean2.getCurrentNum();
            if(num>0){
                allnum2+=num;
                InsertFinProStorageRecordReqBean1 bean1=new InsertFinProStorageRecordReqBean1(currBean2.getFactory(), currBean2.getStorage(), currBean2.getKDAUF(), currBean2.getKDPOS(), currBean2.getProductOrderNO(), currBean2.getProOrderDesc(), currBean2.getProOrderMaterialCode(), currBean2.getProOrderMaterialDesc(), currBean2.getProOrderMaterialUnit(), currBean2.getDemandNum()+"", currBean2.getDispatchNum()+"", num+"", currBean2.getRSNUM(), currBean2.getRSPOS(), currBean2.getMCODE(),currBean2.getMATNR(),currBean2.getMAKTX(),currBean2.getRSART(),currBean2.getPLORD(),currBean2.getOTYPE(),currBean2.getSOBKZ(),currBean2.getLGPBE());
                sdata.add(bean1);
            }


        }
        float allnum = Float.parseFloat("0"+dhsl.getText().toString());
        float mqty=allnum1-allnum2>0?(allnum1-allnum2):0;

        //序列号长度不能超过10
//        String xlhStr = xlh.getText().toString();
//        String[] xlhSplit = xlhStr.split(",");
//        boolean legalxlh=true;
//        for (String s : xlhSplit) {
//            if (s.length()>10){
//                legalxlh=false;
//                break;
//            }
//        }

//        if(productOrderList1.size()==0){
//            rece=false;
//        }else {
//            //若有本事业部生产订单,循环本事业部生产订单，确保对应的上游事业部生产订单分配数量都小于本事业部生产订单分配数量
//            for (InsertFinProStorageRecordReqBean2 aufnrBean : ldata) {
//                String pmatnr = aufnrBean.getMaterialCode();
//                float qty1 = aufnrBean.getQty();//本事业部订单分配数量
//                float qty2=0;//上游订单分配数量
//                for (InsertFinProStorageRecordReqBean1 upaufnr : sdata) {
//                    //物料编码相同，则可本事业部生产订单与上游事业部生产订单对应起来
//                    if(upaufnr.getMaterialCode().equals(pmatnr)){
//                        qty2+=Float.parseFloat("0"+upaufnr.getAllocatedQty());;
//                    }
//                }
//                if(qty2>qty1){
//                    rece=false;
//                    break;
//                }
//            }
//        }

        //序列号数量=入库数量
//        System.out.println(rece);
        if(allnum1<=allnum){
            try {
                LoadingBar.dialog(WXBCPJGRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
//                sdata.clear();
                InsertFinProStorageRecordReq req=new InsertFinProStorageRecordReq(ldata.get(0).getMaterialCode(), ldata.get(0).getMaterialDesc(), "独立", factory, allnum1,mqty, ldata.get(0).getUnit(), marketorderno, marketorderrow, username, "", ldata, sdata);
                presenter2.InsertFinProStorageRecord(req);
            } catch (Exception e) {
                LoadingBar.dialog(WXBCPJGRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
                DialogUtil.errorMessageDialog(WXBCPJGRKActivity.this,"收货发生错误,缺少本事业部生产订单");
            }
        } else {
            Toast.makeText(this, "分配数量超出图纸数量", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.wxmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                item -> {
                    switch (item.getItemId())
                    {
//                            case R.id.exit:
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                        case R.id.print:
                            // 隐藏该对话框
                            vibrator.vibrate(30);
                            isAgain=true;
                            onDataSuccess3(againPrint);
                            break;
                        case R.id.record:
                            // 隐藏该对话框
                            vibrator.vibrate(30);
                            Intent intent = new Intent(WXBCPJGRKActivity.this, WXSHJLActivity.class);
                            intent.putExtra("username", username);
                            startActivity(intent);
                            break;
                        default:
                            // 使用Toast显示用户单击的菜单项
                            Toast.makeText(WXBCPJGRKActivity.this,
                                    "您单击了【" + item.getTitle() + "】菜单项"
                                    , Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
//        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        DialogUtil.startAlarm(this);
        vibrator.vibrate(300);
        if(data.getCode()==1){
            //扫码成功显示
            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);
            ll_scdd.setVisibility(View.VISIBLE);
            if(factory.equals("2090")){
                rb2.setVisibility(View.INVISIBLE);
            }else {
                rb2.setVisibility(View.VISIBLE);
            }
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
//            material = data.getMaterial();
//            material.setMarketorderno(marketorderno);
//            material.setMarketorderrow(marketorderrow);
//            material.setNum(num);
//
//            wlbm.setText(material.getMATNR());
//            wlms.setText(material.getMAKTX());
//            gc.setText(material.getWERKS());
//            dw.setText(material.getMEINS());
//            String num3str=""+material.getNum();
//            dhsl.setText(num3str);
            //presenter3.CGSHReceiveDetail(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getWERKS(),selectedRep.getWESBS());
            productOrderList1.clear();
            productOrderList2.clear();
//            presenter4.GetOutStorageMaterialOrderJS(material.getMarketorderrow(),material.getMATNR(),material.getMarketorderno(),"2090",material.getNum());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ScanSuccess(String materialCode){
        //扫码成功显示
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.VISIBLE);
        ll_scdd.setVisibility(View.VISIBLE);
        if(factory.equals("2090")){
            rb2.setVisibility(View.INVISIBLE);
        }else {
            rb2.setVisibility(View.VISIBLE);
        }
        try {
            wlbm.setText(materialCode);
            xsddh_hang.setText(marketorderno+"/"+marketorderrow);
            gc.setText(factory);
            String num3str=""+num;
            dhsl.setText(num3str);
//            presenter3.CGSHReceiveDetail(selectedRep.getMarketorderno(),selectedRep.getMarketorderrow(),selectedRep.getMATNR(),selectedRep.getWERKS(),selectedRep.getWESBS());
            productOrderList1.clear();
            productOrderList2.clear();
            presenter4.GetOutStorageMaterialOrderJS(marketorderrow,materialCode,marketorderno,"2090",num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(InsertFinProStorageRecordRep data) {
        LoadingBar.dialog(WXBCPJGRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            try {
                GetFinProStorageRecordNoteReqBean idreq = new GetFinProStorageRecordNoteReqBean((data.getData()));
                idlist.add(idreq);
            } catch (Exception e) {
                e.printStackTrace();
            }
            layout1.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.INVISIBLE);
            productOrderList1.clear();
            productOrderList2.clear();
            adapter1.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
            ll_scdd.setVisibility(View.INVISIBLE);
            //收货完成直接自动打印标签
            isAgain=false;
            presenter3.GetFinProStorageRecordNote(idlist);
        }else {
//            System.out.println("error");
            DialogUtil.errorMessageDialog(WXBCPJGRKActivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onDataSuccess3(GetFinProStorageRecordNoteRep data) {
        againPrint=data;
        if(data.getStatus()!=null&&data.getStatus().getCode()==1){
            List<GetFinProStorageRecordNoteRepBean> labels = data.getData();
            if (labels != null) {
                for (GetFinProStorageRecordNoteRepBean label : labels) {
                    printHelper.printBlankLine(40);
                    Bitmap bm = cb.createImage6(label, tf);
                    printHelper.PrintBitmapAtCenter(bm, 384, 530);
                    printHelper.printBlankLine(80);
                }
                System.out.println("打印标签的数量为" + data.getData().size());
//            Toast.makeText(WXBCPJGRKActivity.this, "打印标签的数量为" + labels.size(), Toast.LENGTH_SHORT).show();
            } else {
                System.out.println("未打印标签");
            }
            idlist.clear();
            Toast.makeText(WXBCPJGRKActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            if(!isAgain){
                DialogUtil.errorMessageDialog(WXBCPJGRKActivity.this,data.getStatus().getMessage());
            }
        }

    }

    @Override
    public void onDataSuccess1(GetOutStorageMaterialOrderJSRep data) {
        productOrderList1 = data.getData();
        adapter1=new WXBCPJGRKAdapter1(WXBCPJGRKActivity.this, R.layout.wxcpshitem1, productOrderList1);
        listview1.setAdapter(adapter1);
        radiogroup1.check(R.id.ben);
    }

    @Override
    public void onDataSuccess4(PreMaterialProductOrderReps data) {
        productOrderList2 = data.getData();
        adapter2=new WXBCPJGRKAdapter2(WXBCPJGRKActivity.this, R.layout.wxbcprkitem2, productOrderList2);
        listview2.setAdapter(adapter2);
        if(autoReceive){
            receive();
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXBCPJGRKActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
    }

    public void switchContent1() {
        listview1.setVisibility(View.VISIBLE);
        listview2.setVisibility(View.GONE);
    }

    public void switchContent2() {

        List<PreMaterialProductOrderJSReqBean> materialCodeArr=new ArrayList<PreMaterialProductOrderJSReqBean>();
        for (int i = 0; i < productOrderList1.size(); i++) {
            String code=productOrderList1.get(i).getMATNR();

            View itmeview=listview1.getAdapter().getView(i,null,null);
            CheckBox cb=itmeview.findViewById(R.id.checked);
            EditText et=itmeview.findViewById(R.id.fpsl);
            String recenumstr=et.getText().toString();
            float num0=Float.parseFloat(("0"+recenumstr));
//            float num0=productOrderList1.get(i).getCurrentNum();
            //分配数量为0或者未选中则直接跳过
            if(num0!=0&&cb.isChecked()){
                boolean dup=false;
                int index=0;
                for (int j = 0; j < materialCodeArr.size(); j++) {
                    if(materialCodeArr.get(j).getMaterialCode().equals(code)){
                        index=j;
                        dup=true;
                        break;
                    }
                }
                //物料未重复，则传参添加；物料重复，则只增加数量
                if(dup==false){
                    PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(code,num0);
                    materialCodeArr.add(bean);
                }else {
                    float num00=materialCodeArr.get(index).getMatnrCurrentNum()+num0;
                    materialCodeArr.get(index).setMatnrCurrentNum(num00);
                }
            }

        }
        //销售订单号为空则不查上游订单
        if(!marketorderno.equals("")){
            presenter5.PreMaterialProductOrderJS(marketorderno,marketorderrow,materialCodeArr,gc.getText().toString());
        }

        listview1.setVisibility(View.GONE);
        listview2.setVisibility(View.VISIBLE);
    }


    public void autoLoadContent2() {
        List<PreMaterialProductOrderJSReqBean> materialCodeArr=new ArrayList<PreMaterialProductOrderJSReqBean>();
        for (int i = 0; i < productOrderList1.size(); i++) {
            String code=productOrderList1.get(i).getMATNR();

            View itmeview=listview1.getAdapter().getView(i,null,null);
            CheckBox cb=itmeview.findViewById(R.id.checked);
            EditText et=itmeview.findViewById(R.id.fpsl);
            String recenumstr=et.getText().toString();
            float num0=Float.parseFloat(("0"+recenumstr));
//            float num0=productOrderList1.get(i).getCurrentNum();
            //分配数量为0或者未选中则直接跳过
            if(num0!=0&&cb.isChecked()){
                boolean dup=false;
                int index=0;
                for (int j = 0; j < materialCodeArr.size(); j++) {
                    if(materialCodeArr.get(j).getMaterialCode().equals(code)){
                        index=j;
                        dup=true;
                        break;
                    }
                }
                //物料未重复，则传参添加；物料重复，则只增加数量
                if(dup==false){
                    PreMaterialProductOrderJSReqBean bean=new PreMaterialProductOrderJSReqBean(code,num0);
                    materialCodeArr.add(bean);
                }else {
                    float num00=materialCodeArr.get(index).getMatnrCurrentNum()+num0;
                    materialCodeArr.get(index).setMatnrCurrentNum(num00);
                }
            }

        }
        //销售订单号为空则不查上游订单
        if(!marketorderno.equals("")){
            presenter5.PreMaterialProductOrderJS(marketorderno,marketorderrow,materialCodeArr,gc.getText().toString());
        }else {
            if(autoReceive){
                receive();
            }
        }
    }

    //扫描操作
    public void scan() {
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
    public class MyCodeReceiver extends BroadcastReceiver {
        private static final String TAG = "MycodeReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (str.contains("{")) {
                    //tv.setText(str);
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(WXBCPJGRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if(lableObject!=null) {
                        String bm= null;
                        factory="";
                        String decodestr = null;
                        try {
                            marketorderno=lableObject.getString("no");
                            String s1=".*[0-9]{1,}.*";
                            marketorderno=marketorderno.matches(s1)?marketorderno:"";
                            marketorderrow=lableObject.getString("line");
                            bm = lableObject.getString("code");
                            factory=lableObject.getString("gc");
                            String numstr=lableObject.getString("sl");
                            num=Float.parseFloat(numstr);
                            decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(WXBCPJGRKActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                        }
//
                        if(marketorderno!=null&&marketorderrow!=null&&bm!=null&&factory!=null&&!factory.equals("")){
                            ScanSuccess(decodestr);
                        }else {
                            String moremsg="";
                            if(marketorderno==null){
                                moremsg+="|销售订单号";
                            }
                            if(marketorderrow==null){
                                moremsg+="|销售订单行";
                            }
                            if(bm==null){
                                moremsg+="物料编码";
                            }
                            if(factory==null||factory.equals("")){
                                moremsg+="工厂";
                            }
                            DialogUtil.errorMessageDialog(WXBCPJGRKActivity.this,"图纸内容有误,缺少字段"+moremsg);
                        }
                        scanString="";
                    }
                }else if(!str.equals("")){
//                    String xlhStr = xlh.getText().toString();
//                    //输入框内容为空，则直接增加；若不为空，判断序列号是否存在，不存在则用“，”隔开并增加
//                    if (xlhStr.equals("")) {
//                        System.out.println("直接增加"+str);
//                        xlhStr = str;
//                        xlh.setText(xlhStr);
//                    } else {
//                        String[] split = xlhStr.split(",");
//                        if (Arrays.asList(split).contains(str)) {
//                        } else {
//                            xlhStr = xlhStr + "," + str;
//                            xlh.setText(xlhStr);
//                        }
//                    }

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

    //初始化
    public void initPrinter() {
        printHelper = new PrintHelper();
        printHelper.Open(WXBCPJGRKActivity.this);
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        // 获取手机当前音量值
//        int i = getCurrentRingValue ();
        switch (keyCode) {
            // 音量减小
            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                Toast.makeText (CGDDListActivity.this, "上上上", Toast.LENGTH_SHORT).show ();
                // 音量减小时应该执行的功能代码
                return true;
            // 音量增大
            case KeyEvent.KEYCODE_VOLUME_UP:
//                Toast.makeText (CGDDListActivity.this, "下下下", Toast.LENGTH_SHORT).show ();
                // 音量增大时应该执行的功能代码
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
