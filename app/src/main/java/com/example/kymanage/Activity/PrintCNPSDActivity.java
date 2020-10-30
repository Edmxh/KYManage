package com.example.kymanage.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.kymanage.Adapter.PrintCNPSDAdapter;
import com.example.kymanage.Beans.General.CNPSDDisplayBean;
import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRepBean2;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.Print1.GetCMInFactoryDeliverJSPresenter;
import com.example.kymanage.presenter.Presenters.Print1.GetCMInFactoryDeliverPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.example.kymanage.utils.mPrintUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class PrintCNPSDActivity extends BaseActivity implements BaseView1<GetCMInFactoryDeliverRep>, BaseView2<GetCMInFactoryDeliverJSRep> {

    //username
    private String username;
    //扫描
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    private String scanString;
    private GetCMInFactoryDeliverPresenter presenter1;
    private GetCMInFactoryDeliverJSPresenter presenter2;

    //表
    private ListView listView1;
    private List<CNPSDDisplayBean> listBeans;
    private PrintCNPSDAdapter adapter;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    //震动
    private Vibrator vibrator;

    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();

    //缩略菜单
    private ImageView menupoint;
    PopupMenu popup = null;

    //重复打印
    GetCMInFactoryDeliverJSRep againPrint=new GetCMInFactoryDeliverJSRep();
    boolean isAgain=false;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_cnpsd;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //按钮
        scan=findViewById(R.id.scan);
        menupoint=findViewById(R.id.menupoint);
//        record=findViewById(R.id.record);
        //表格
        listView1=findViewById(R.id.listview1);

        presenter1=new GetCMInFactoryDeliverPresenter();
        presenter1.setView(this);

        presenter2=new GetCMInFactoryDeliverJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        listBeans=new ArrayList<CNPSDDisplayBean>();


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
        //扫描派工单
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

//                scanString="{\"code\":\"LJ2015000594-TZ2010043020\",\"dp\":\"15923846892067\",\"po\":\"000010048078\",\"no\":\"0010000208\",\"line\":\"000026\"}";
//                JSONObject lableObject= null;
//                try {
//                    lableObject = JSONObject.parseObject(scanString);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Toast.makeText(PrintCNPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
//                }
//                if(lableObject!=null) {
//                    String DispatchListNO=lableObject.getString("dp");
//                    //判断是否重复扫码
//                    boolean repeat=false;
//                    for (String no : DispatchListNOList) {
//                        if(DispatchListNO.equals(no)){
//                            repeat=true;
//                        }
//                    }
//                    if(repeat){
//                        System.out.println("请勿重复扫码");
//                        Toast.makeText(PrintCNPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
//
//                    }else {
//                        if(DispatchListNO!=null){
//                            DispatchListNOList.add(DispatchListNO);
//                            presenter1.GetCMInFactoryDeliver(DispatchListNOList,username,getCurrentdate());
//                        }
//                    }
////                    presenter1.GetPurWayMaterialData("00020","4100011740",1,"DQ5095000031","2010");
//                    scanString="";
//                }else {
//                    Log.i("token","扫描结果为空");
//                    Toast.makeText(PrintCNPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.wxcnpsmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
//                            case R.id.exit:
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                            case R.id.record:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                Intent intent = new Intent(PrintCNPSDActivity.this, PrintCNPSDRecord1Activity.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
                                break;
                            case R.id.print2:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                isAgain=true;
                                onDataSuccess2(againPrint);
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                List<String> DispatchListNOList=new ArrayList<String>();
                                for (int i = 0; i < listBeans.size(); i++) {
                                    View itmeview=listView1.getAdapter().getView(i,null,null);
                                    CheckBox cb= itmeview.findViewById(R.id.checked);
                                    if(cb.isChecked()){
                                        DispatchListNOList.add(listBeans.get(i).getDispatchno());
                                    }
                                }
                                if(DispatchListNOList.size()>0){
                                    isAgain=false;
                                    presenter1.GetCMInFactoryDeliver(DispatchListNOList,username,getCurrentdate());
                                }else {
                                    Toast.makeText(PrintCNPSDActivity.this, "未选择派工单行", Toast.LENGTH_SHORT).show();
                                }

                                break;
                            default:
                        }
                        return true;
                    }
                });
        popup.show();
    }

    @Override
    public void onDataSuccess1(GetCMInFactoryDeliverRep data) {
        if(data.getCode()==1){
            presenter2.GetCMInFactoryDeliverJS(data.getDeliverNO());
        }else {
            DialogUtil.errorMessageDialog(PrintCNPSDActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess2(GetCMInFactoryDeliverJSRep data) {
        againPrint=data;
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            for (GetCMInFactoryDeliverJSRepBean2 datum : data.getData()) {
                mPrintUtil.printCNBill(datum,printHelper);
                printHelper.printBlankLine(80);
            }
            List<CNPSDDisplayBean> checkedlistBeans=new ArrayList<CNPSDDisplayBean>();
            for (int i = 0; i < listBeans.size(); i++) {
                View itmeview=listView1.getAdapter().getView(i,null,null);
                CheckBox cb= itmeview.findViewById(R.id.checked);
                if(cb.isChecked()){
                    checkedlistBeans.add(listBeans.get(i));

                }
            }
            for (CNPSDDisplayBean checkedlistBean : checkedlistBeans) {
                listBeans.remove(checkedlistBean);
            }
            adapter=new PrintCNPSDAdapter(this, R.layout.wxcnpsditem,listBeans);
            listView1.setAdapter(adapter);
        }else {
            //again打印不弹窗错误
            if(!isAgain){
                DialogUtil.errorMessageDialog(PrintCNPSDActivity.this,data.getMessage());
            }

        }

    }

    @Override
    public void onFailed(String msg) {

    }

    //接收类
    public class MyCodeReceiver extends BroadcastReceiver
    {
        private static final String TAG = "MycodeReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString=str;
                    JSONObject lableObject= null;
                    try {
                        lableObject = JSONObject.parseObject(scanString);
                        if(lableObject!=null) {
                           String DispatchListNO=lableObject.getString("dp");
                           String materialCode=lableObject.getString("code");
                           String productOrder=lableObject.getString("po");
//                           String user=lableObject.getString("user");
//                           String createDate=lableObject.getString("date");
                            //判断是否重复扫码
                            boolean repeat=false;
                            for (CNPSDDisplayBean listBean : listBeans) {
                                if(DispatchListNO.equals(listBean.getDispatchno())){
                                    repeat=true;
                                }
                            }
                            if(repeat){
    //                            System.out.println("请勿重复扫码");
                                Toast.makeText(PrintCNPSDActivity.this, "请勿重复扫码", Toast.LENGTH_SHORT).show();
                            }else {
                                DialogUtil.startAlarm(PrintCNPSDActivity.this);
                                vibrator.vibrate(300);
                                CNPSDDisplayBean listBean=new CNPSDDisplayBean(DispatchListNO,productOrder,materialCode,username,getCurrentdate());
                                listBeans.add(listBean);
                                adapter=new PrintCNPSDAdapter(getApplicationContext(), R.layout.wxcnpsditem,listBeans);
                                listView1.setAdapter(adapter);
                            }

                            scanString="";
                        }else {
                            Log.i("token","扫描结果为空");
                            Toast.makeText(PrintCNPSDActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(PrintCNPSDActivity.this, "二维码格式有误", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
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
    public void scan(){
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
        printHelper.Open(PrintCNPSDActivity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
