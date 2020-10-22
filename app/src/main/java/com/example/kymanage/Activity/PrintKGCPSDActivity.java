package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.PrintKGCPSDAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean2;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeReqBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRepBean;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRepBean2;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;
import com.example.kymanage.presenter.Presenters.Print2.GetDumpRecordNodePresenter;
import com.example.kymanage.presenter.Presenters.Print2.MaterialExistDumpDataPresenter;
import com.example.kymanage.presenter.Presenters.Print2.MaterialFactoryDumpPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3.GetMaterialMasterDataJSPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class PrintKGCPSDActivity extends BaseActivity implements ScanBaseView<GetMaterialMasterDataRep>, BaseView1<MaterialFactoryDumpRep>, BaseView2<GetDumpRecordNodeRep>, BaseView3<StatusRespBean>, PrintKGCPSDAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //震动
    private Vibrator vibrator;
    private ImageView scan;
//    private ImageView print;
//    private ImageView divert;
//    private ImageView record;
    //表格
    private ListView listview1;
    private List<MaterialFactoryDumpReqBean> datas;
    private PrintKGCPSDAdapter adapter;
    //扫描相关
    private String m_Broadcastname = "com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private MaterialExistDumpDataPresenter presenter33;//扫码前验证
    private GetMaterialMasterDataJSPresenter presenter1;
    private String scanString;

    //扫描获取的值
    private long fid;
    private String po;
    private String no;
    private String line;
    private float qty;
    private String labelnum;

    //301转储
    private MaterialFactoryDumpPresenter presenter2;

    //传递的username
    private String username;

    //跨工厂配送单打印
    private GetDumpRecordNodePresenter presenter3;
    private List<GetDumpRecordNodeReqBean> printDatas;

    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    private ImageView menupoint;
    PopupMenu popup = null;

    private mPrintUtil mPrintUtil=new mPrintUtil();

    //全局变量
    String bm = "";

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_kgcpsd;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        scan=findViewById(R.id.scan);
//        print=findViewById(R.id.print);
//        divert=findViewById(R.id.divert);
//        record=findViewById(R.id.record);
        menupoint=findViewById(R.id.menupoint);
        listview1=findViewById(R.id.listview1);

        presenter1=new GetMaterialMasterDataJSPresenter();
        presenter1.setView(this);

        presenter2=new MaterialFactoryDumpPresenter();
        presenter2.setView(this);

        presenter3=new GetDumpRecordNodePresenter();
        presenter3.setView(this);

        presenter33=new MaterialExistDumpDataPresenter();
        presenter33.setView(this);

//        LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom5).show();
    }

    @Override
    public void initData() {
        printDatas=new ArrayList<GetDumpRecordNodeReqBean>();
        datas=new ArrayList<MaterialFactoryDumpReqBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");


        cb=new CreateBitmap();
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
                Thread scanThread=new Thread(new Runnable(){
                    @Override
                    public void run() {
                        scan();
                    }
                });
                scanThread.start();
                try {
                    Log.i("token","scanThread.join();");
                    scanThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                scanString = "{\"bm\":\"LJ7015001194\",\"sl\":3.0,\"num\":\"202006171205211938\",\"po\":\"000010048077\",\"no\":\"0010000208\",\"line\":\"000026\",\"type\":\"t301\",\"fid\":468,\"gc\":\"2010\",\"cd\":\"A11\"}";
//                JSONObject lableObject = null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(PrintKGCPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if (lableObject != null) {
////                    System.out.println(lableObject.getString("bm"));
//                    String bm = null;
//                    try {
//                        po = lableObject.getString("po");
//                        no = lableObject.getString("no");
//                        line = lableObject.getString("line");
//                        fid = lableObject.getLong("fid");
//                        qty = lableObject.getFloat("sl");
//                        bm = lableObject.getString("bm");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
////                        sl=lableObject.getFloat("sl");
////                        bm = lableObject.getString("bm");
////                        area = lableObject.getString("cd");
////                        factory=lableObject.getString("gc");
////                        labelSquNum=lableObject.getString("num");
////                        cs=lableObject.getInteger("cs");
//
//                    //判断是否重复扫码
//                    boolean repeat = false;
//                    for (MaterialFactoryDumpReqBean data : datas) {
//                        if (data.getMatnr().equals(bm)) {
//                            repeat = true;
//                            break;
//                        }
//                    }
//                    if (repeat) {
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(PrintKGCPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        if (bm != null) {
////                                String decodestr = new String(Base64.decode(bm.getBytes(), Base64.DEFAULT));
//                            presenter1.GetMaterialMasterDataJS(bm, "2090");
//                        }
//
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString = "";
//                } else {
//                    Log.i("token", "扫描结果为空");
//                    Toast.makeText(PrintKGCPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);

            }
        });
    }
    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.kgcpsmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.divert:
                                // 隐藏该对话框
                                vibrator.vibrate(30);

                                if(datas.size()>0){
                                    LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom6).show();
                                    MaterialFactoryDumpReq req=new MaterialFactoryDumpReq(username,datas);
                                    presenter2.MaterialFactoryDump(req);
                                }
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                if(printDatas.size()>0){
                                    presenter3.GetDumpRecordNode(printDatas);
                                }else {
                                    Toast.makeText(PrintKGCPSDActivity.this, "请先转储", Toast.LENGTH_SHORT).show();
                                }
                                break;
//                            case R.id.exit:
//                                vibrator.vibrate(30);
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                            case R.id.record:
                                vibrator.vibrate(30);
                                // 隐藏该对话框
                                Intent intent=new Intent(PrintKGCPSDActivity.this,DivertRecord1Activity.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(PrintKGCPSDActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

    @Override
    public void onDataSuccessScan(GetMaterialMasterDataRep data) {
        LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        if(data.getCode()==1){
            boolean cf=false;
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).getFID()==fid){
                    cf=true;
                    break;
                }
            }
            if(!cf){
                MaterialFactoryDumpReqBean scanBean=new MaterialFactoryDumpReqBean(getCurrentdate(), getCurrentdate(), fid, data.getMaterial().getMATNR(), data.getMaterial().getMAKTX(), data.getMaterial().getMaterialType(), data.getMaterial().getMEINS(), po, no, line, qty, "301转储",labelnum,"");
                datas.add(scanBean);
                adapter=new PrintKGCPSDAdapter(this, R.layout.wxkgcpsditem,datas);
                adapter.setOnInnerItemOnClickListener(this);
                listview1.setAdapter(adapter);
                listview1.setOnItemClickListener(this);
            }
        }else {
            DialogUtil.errorMessageDialog(PrintKGCPSDActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess1(MaterialFactoryDumpRep data) {
        LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom6).cancel();
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < data.getData().size(); i++) {
                MaterialFactoryDumpRepBean bean = data.getData().get(i);
                System.out.println(bean.getPID());
                GetDumpRecordNodeReqBean printData=new GetDumpRecordNodeReqBean(bean.getPID());
                printDatas.add(printData);
            }
            presenter3.GetDumpRecordNode(printDatas);
            datas.clear();
            adapter=new PrintKGCPSDAdapter(this, R.layout.wxkgcpsditem,datas);
            adapter.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(this);
        }else {
            //转储成功的移除，转储失败的显示失败信息
            List<MaterialFactoryDumpReqBean> newdatas=new ArrayList<MaterialFactoryDumpReqBean>();
            List<Integer> indexarr=new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                System.out.println("datas.size()"+datas.size());
                MaterialFactoryDumpReqBean bean = datas.get(i);
                for (int j = 0; j < data.getWarnInfo().size(); j++) {
                    MaterialFactoryDumpRepBean2 bean2 = data.getWarnInfo().get(j);
                    if (bean.getFID() == bean2.getFID()) {
                        datas.get(i).setWarning(bean2.getMessage());
                        System.out.println(bean2.getFID()+"=="+bean2.getMessage());
                        newdatas.add(datas.get(i));
                        break;
                    }
                }
            }

            datas=newdatas;

            adapter=new PrintKGCPSDAdapter(this, R.layout.wxkgcpsditem,datas);
            adapter.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(this);
            //转储完打印跨工厂配送单
            for (int i = 0; i < data.getData().size(); i++) {
                MaterialFactoryDumpRepBean bean3 = data.getData().get(i);
                System.out.println(bean3.getPID());
                GetDumpRecordNodeReqBean printData=new GetDumpRecordNodeReqBean(bean3.getPID());
                printDatas.add(printData);
            }
            if(printDatas.size()>0){
                presenter3.GetDumpRecordNode(printDatas);//print
            }

            DialogUtil.errorMessageDialog(PrintKGCPSDActivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onDataSuccess2(GetDumpRecordNodeRep data) {
        if(data.getStatus().getCode()==1){
            printDatas.clear();
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            List<GetDumpRecordNodeRepBean2> data1 = data.getData();
            //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            try {
                printHelper.printBlankLine(10);
                for (GetDumpRecordNodeRepBean2 data2 : data1) {
//                Bitmap bm=cb.createImage10(data2,tf);
//                printHelper.PrintBitmapAtCenter(bm,384,450+55*(data2.getData().size()));
//                printHelper.printBlankLine(40);
                    mPrintUtil.printKGCBill(data2,printHelper);
                    printHelper.printBlankLine(80);
                }
//            printHelper.printBlankLine(40);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            DialogUtil.errorMessageDialog(PrintKGCPSDActivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onDataSuccess3(StatusRespBean data) {
        if (data.getStatus().getCode()==1){
            presenter1.GetMaterialMasterDataJS(bm, "2090");
        }else {
            LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
            DialogUtil.errorMessageDialog(PrintKGCPSDActivity.this,data.getStatus().getMessage());
        }
    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom5).cancel();
        LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom6).cancel();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println("456");
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.delete:
                System.out.println("delete"+position);
                datas.remove(position);
                adapter.notifyDataSetChanged();
                break;
            default:
                System.out.println("123");
                break;
        }
    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver {
        private static final String TAG = "MycodeReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString = str;
                    JSONObject lableObject = null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(PrintKGCPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                    }
                    if (lableObject != null) {
//                    System.out.println(lableObject.getString("bm"));

                        String gc="";
                        try {
                            po = lableObject.getString("po");
                            no = lableObject.getString("no");
                            line = lableObject.getString("line");
                            fid = lableObject.getLong("fid");
                            qty = lableObject.getFloat("sl");
                            bm = lableObject.getString("bm");
                            labelnum = lableObject.getString("num");
                            gc = lableObject.getString("gc");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        sl=lableObject.getFloat("sl");
//                        bm = lableObject.getString("bm");
//                        area = lableObject.getString("cd");
//                        factory=lableObject.getString("gc");
//                        labelSquNum=lableObject.getString("num");
//                        cs=lableObject.getInteger("cs");

                        //判断是否重复扫码
                        boolean repeat = false;
                        for (MaterialFactoryDumpReqBean data : datas) {
                            if (data.getLabelnum().equals(labelnum)) {
                                repeat = true;
                                break;
                            }
                        }
                        if (repeat) {
                            System.out.println("请勿重复扫码");
                            Toast.makeText(PrintKGCPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();

                        } else {
                            if (bm != null) {
                                if(gc.equals("")||gc.equals("2090")){
                                    DialogUtil.errorMessageDialog(PrintKGCPSDActivity.this,bm+"该物料不是上游需求");
                                }else {
                                    List<MaterialFactoryDumpReqBean> currdata=new ArrayList<>();
                                    MaterialFactoryDumpReqBean currbean=new MaterialFactoryDumpReqBean();
                                    currbean.setFID(fid);
                                    currdata.add(currbean);
                                    MaterialFactoryDumpReq req=new MaterialFactoryDumpReq(username,currdata);
                                    LoadingBar.dialog(PrintKGCPSDActivity.this).setFactoryFromResource(R.layout.layout_custom5).show();
                                    presenter33.MaterialExistDumpData(req);
                                }

                            }

                        }
//                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
                        scanString = "";
                    } else {
                        Log.i("token", "扫描结果为空");
                        Toast.makeText(PrintKGCPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(PrintKGCPSDActivity.this);
//        Toast.makeText(DivertRecord1Activity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
